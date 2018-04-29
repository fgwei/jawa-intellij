/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

import sbt._

object BintrayResolvers {
  def jbBintrayResolver(name: String, repo: String, patterns: Patterns): URLRepository =
    Resolver.url(name, url(s"http://dl.bintray.com/jetbrains/$repo"))(patterns)

  val scalaPluginDeps: URLRepository = jbBintrayResolver("scala-plugin-deps", "scala-plugin-deps", Resolver.ivyStylePatterns)

  val allResolvers = Seq(scalaPluginDeps)
}

object JawaVersions {
  val scalaVersion = "2.12.6"
  val sbtVersion = "1.1.4"
  val ideaVersion = "181.4668.68"
  val sbtStructureVersion = "5.1.2"
  val argusSafVersion = "3.1.3-SNAPSHOT"
  val jgraphtVersion = "1.0.1"
}

object Dependencies {
  import JawaVersions._

  val scalaLibrary: ModuleID = "org.scala-lang" % "scala-library" % scalaVersion
  val scalaReflect: ModuleID = "org.scala-lang" % "scala-reflect" % scalaVersion

  val jawa: ModuleID = "com.github.arguslab" % "jawa_2.12" % argusSafVersion

  val nailgun: ModuleID = "org.jetbrains" % "nailgun-patched" % "1.0.0"
  val compilerInterfaceSources: ModuleID = "org.jetbrains" % "compiler-interface-sources" % "1.0.0"
  val bundledJline: ModuleID = "org.jetbrains" % "jline" % "1.0.0"
  val incrementalCompiler: ModuleID = "org.jetbrains" % "incremental-compiler" % "1.0.0"

  val guava: ModuleID = "com.google.guava" % "guava" % "21.0"

  val commons_lang3: ModuleID = "org.apache.commons" % "commons-lang3" % "3.5"

  val st4: ModuleID = "org.antlr" % "ST4" % "4.0.8"
  val antlr4_runtime: ModuleID = "org.antlr" % "antlr4-runtime" % "4.7"
  val antlr_runtime: ModuleID = "org.antlr" % "antlr-runtime" % "3.5.2"


  val jgrapht_core: ModuleID = "org.jgrapht" % "jgrapht-core" % jgraphtVersion
  val jgrapht_ext: ModuleID = "org.jgrapht" % "jgrapht-ext" % jgraphtVersion
  val jgraph: ModuleID = "jgraph" % "jgraph" % "5.13.0.0"
  val jgraphx: ModuleID = "org.tinyjee.jgraphx" % "jgraphx" % "2.0.0.1"

  val asm_all: ModuleID = "org.ow2.asm" % "asm-all" % "5.2"

  val ini4j: ModuleID = "org.ini4j" % "ini4j" % "0.5.4"

}

object DependencyGroups {
  import Dependencies._

  val sbtBundled = Seq(
    compilerInterfaceSources,
    bundledJline,
    incrementalCompiler
  )

  val st = Seq(st4, antlr_runtime)

  val jgrapht = Seq(
    jgrapht_core,
    jgrapht_ext,
    jgraph,
    jgraphx,
    antlr4_runtime
  )

  val jawa_all: Seq[ModuleID] = Seq(
    jawa,
    guava,
    commons_lang3,
    scalaReflect
  ) ++ st ++ jgrapht

  val jawa_plugin: Seq[ModuleID] = Seq(
    scalaLibrary
  ) ++ jawa_all

  val jc: Seq[ModuleID] = Seq(
    nailgun
  ) ++ jawa_all ++ sbtBundled
}