/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.jc.incremental.jawa

import _root_.java.io.File
import _root_.java.util

import com.intellij.openapi.util.io.FileUtil
import com.intellij.util.Processor
import org.argus.jawa.core.io.SourceFile
import org.argus.jc.incremental.jawa.local.IdeClientIdea
import org.argus.jc.incremental.jawa.model.CompileOrder
import org.jetbrains.jps.ModuleChunk
import org.jetbrains.jps.builders.java.{JavaBuilderUtil, JavaSourceRootDescriptor}
import org.jetbrains.jps.builders.{DirtyFilesHolder, FileProcessor}
import org.jetbrains.jps.incremental.ModuleLevelBuilder.ExitCode
import org.jetbrains.jps.incremental.messages.ProgressMessage

import _root_.scala.collection.JavaConverters._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import org.jetbrains.jps.incremental._

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class IdeaIncrementalBuilder(category: BuilderCategory) extends ModuleLevelBuilder(category) {

  override def getPresentableName: String = "Jawa IDEA builder"

  override def build(context: CompileContext,
                     chunk: ModuleChunk,
                     dirtyFilesHolder: DirtyFilesHolder[JavaSourceRootDescriptor, ModuleBuildTarget],
                     outputConsumer: ModuleLevelBuilder.OutputConsumer): ModuleLevelBuilder.ExitCode = {

    if (isDisabled(context, chunk))
      return ExitCode.NOTHING_DONE

    context.processMessage(new ProgressMessage("Searching for compilable files..."))

    val sources = collectSources(context, chunk, dirtyFilesHolder)
    if (sources.isEmpty) return ExitCode.NOTHING_DONE

    val delta = context.getProjectDescriptor.dataManager.getMappings.createDelta()
    val callback = delta.getCallback

    val modules = chunk.getModules.asScala.toSet

    val successfullyCompiled = mutable.Set[SourceFile]()

    val compilerName = "jawac"

    val client = new IdeClientIdea(compilerName, context, modules.map(_.getName).toSeq, outputConsumer,
      callback, successfullyCompiled)

    val jawaSources = sources.filter(_.getName.endsWith(".jawa")).asJava

    JawaBuilder.compile(context, chunk, sources, modules, client) match {
      case Left(error) =>
        client.error(error)
        ExitCode.ABORT
      case _ if client.hasReportedErrors || client.isCanceled => ExitCode.ABORT
      case Right(code) =>
        if (delta != null && JavaBuilderUtil.updateMappings(context, delta, dirtyFilesHolder, chunk, jawaSources, successfullyCompiled.map(_.file.file).asJava))
          ExitCode.ADDITIONAL_PASS_REQUIRED
        else {
          client.progress("Compilation completed", Some(1.0F))
          code
        }
    }
  }

  override def getCompilableFileExtensions: util.List[String] = util.Arrays.asList("jawa", "java")

  private def isDisabled(context: CompileContext, chunk: ModuleChunk): Boolean = {
    val settings = JawaBuilder.projectSettings(context)
    def wrongCompileOrder = settings.getCompilerSettings(chunk).getCompileOrder match {
      case CompileOrder.JAVA_THEN_JAWA => getCategory == BuilderCategory.SOURCE_PROCESSOR
      case CompileOrder.JAWA_THEN_JAVA => getCategory == BuilderCategory.OVERWRITING_TRANSLATOR
      case _ => false
    }
    wrongCompileOrder
  }

  private def collectSources(context: CompileContext,
                             chunk: ModuleChunk,
                             dirtyFilesHolder: DirtyFilesHolder[JavaSourceRootDescriptor, ModuleBuildTarget]): Seq[File] = {

    val result = ListBuffer[File]()

    val project = context.getProjectDescriptor

    val extensionsToCollect = List(".jawa")

    def checkAndCollectFile(file: File): Boolean = {
      val fileName = file.getName
      if (extensionsToCollect.exists(fileName.endsWith))
        result += file

      true
    }

    dirtyFilesHolder.processDirtyFiles(new FileProcessor[JavaSourceRootDescriptor, ModuleBuildTarget] {
      def apply(target: ModuleBuildTarget, file: File, root: JavaSourceRootDescriptor) = checkAndCollectFile(file)
    })

    for {
      target <- chunk.getTargets.asScala
      tempRoot <- project.getBuildRootIndex.getTempTargetRoots(target, context).asScala
    } {
      FileUtil.processFilesRecursively(tempRoot.getRootFile, new Processor[File] {
        def process(file: File) = checkAndCollectFile(file)
      })
    }


    //if no jawa files to compile, return empty seq
    if (!result.exists(_.getName.endsWith(".jawa"))) Seq.empty
    else result
  }


}
