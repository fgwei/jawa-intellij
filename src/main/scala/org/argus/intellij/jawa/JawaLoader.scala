/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa

import com.intellij.debugger.DebuggerManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.compiler.CompilerManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.project.{Project, ProjectManager, ProjectManagerAdapter, ProjectManagerListener}
import org.argus.intellij.jawa.debugger.JawaJVMNameMapper
import org.argus.intellij.jawa.lang.JawaFileType

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaLoader extends ApplicationComponent {
  val JAWA_EXTENSION: String = "jawa"
  val JAWA_EXTENSIONS = Set(JAWA_EXTENSION)

  override def initComponent() {
    if (!JawaLoader.isUnderUpsource) {
      loadJawa()
    }
  }

  def loadJawa() {
    ProjectManager.getInstance.addProjectManagerListener(new ProjectManagerListener() {
      override def projectOpened(project: Project) {
        val compilerManager = CompilerManager.getInstance(project)
        compilerManager.addCompilableFileType(JawaFileType.INSTANCE)
        DebuggerManager.getInstance(project).addClassNameMapper(new JawaJVMNameMapper)
      }
    })
  }

  override def disposeComponent(): Unit = {}

  override def getComponentName: String = "Jawa Loader"
}

object JawaLoader {
  def isUnderUpsource: Boolean = ApplicationManager.getApplication.getClass.getSimpleName.contains("Upsource")
}