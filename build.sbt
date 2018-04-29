import Common._
import sbt.Keys.{`package` => pack}


resolvers in ThisBuild ++= BintrayResolvers.allResolvers
resolvers in ThisBuild ++= Seq("Repo Realm" at "http://oss.jfrog.org/artifactory/oss-snapshot-local")


licenses in ThisBuild := ("Eclipse-2.0" -> url("https://www.eclipse.org/legal/epl-2.0/")) :: Nil // this is required! otherwise Bintray will reject the code
homepage in ThisBuild := Some(url("https://github.com/fgwei/jawa-intellij"))

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val jawaPluginSettings = Defaults.coreDefaultSettings ++ Seq(
  libraryDependencies += "org.scala-lang" % "scala-compiler" % JawaVersions.scalaVersion,
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
)

lazy val sdkDirectory = SettingKey[File]("sdk-directory", "Path to SDK directory where unmanaged Jars and IDEA are located")

sdkDirectory in ThisBuild := baseDirectory.in(ThisBuild).value / "SDK"

ideaBuild in ThisBuild := JawaVersions.ideaVersion

ideaDownloadDirectory in ThisBuild := sdkDirectory.value / "ideaSDK"

onLoad in Global := ((s: State) => { "updateIdea" :: s }) compose (onLoad in Global).value

addCommandAlias("downloadIdea", "updateIdea")

addCommandAlias("packagePlugin", "plugin-packager/package")

addCommandAlias("packagePluginZip", "plugin-compressor/package")

lazy val jawa_intellij: Project =
  newProject("jawa-intellij", file("."))
    .dependsOn(compiler_settings)
    .enablePlugins(SbtIdeaPlugin)
    .settings(jawaPluginSettings)
    .settings(
      ideExcludedDirectories := Seq(baseDirectory.value / "testdata" / "projects"),
      javacOptions in Global ++= Seq("-source", "1.8", "-target", "1.8"),
      scalacOptions in Global += "-target:jvm-1.8",
      libraryDependencies ++= DependencyGroups.jawa_plugin,
      unmanagedJars in Compile +=  file(System.getProperty("java.home")).getParentFile / "lib" / "tools.jar",
      ideaInternalPlugins := Seq(
        "copyright",
        "IntelliLang",
        "java-i18n",
        "maven",
        "junit"
      ),
      ideaInternalPluginsJars :=
        ideaInternalPluginsJars.value
          .filterNot(cp => cp.data.getName.contains("lucene-core") || cp.data.getName.contains("junit-jupiter-api"))
      ,
      aggregate.in(updateIdea) := false
    )

lazy val nailgun_runners =
  newProject("nailgun-runners", file("nailgun-runners"))
    .settings(libraryDependencies += Dependencies.nailgun)

lazy val jc_plugin  =
  newProject("jc-plugin", file("jc-plugin"))
    .dependsOn(compiler_settings)
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      libraryDependencies ++= DependencyGroups.jc
    )

lazy val compiler_settings =
  newProject("compiler-settings", file("compiler-settings"))
    .enablePlugins(SbtIdeaPlugin)
    .settings(libraryDependencies ++= Seq(Dependencies.nailgun, Dependencies.jawa))

// Utility projects

lazy val idea_runner =
  newProject("idea-runner", file("idea-runner"))
    .dependsOn(Seq(compiler_settings, jawa_intellij, jc_plugin, nailgun_runners).map(_ % Provided): _*)
    .settings(
      autoScalaLibrary := false,
      unmanagedJars in Compile := ideaMainJars.in(jawa_intellij).value,
      unmanagedJars in Compile += file(System.getProperty("java.home")).getParentFile / "lib" / "tools.jar",
      // run configuration
      fork in run := true,
      mainClass in (Compile, run) := Some("com.intellij.idea.Main"),
      javaOptions in run ++= Seq(
        "-Xmx1024m",
        "-XX:ReservedCodeCacheSize=64m",
        "-XX:MaxPermSize=250m",
        "-XX:+HeapDumpOnOutOfMemoryError",
        "-ea",
        "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005",
        "-Didea.is.internal=true",
        "-Didea.debug.mode=true",
        "-Didea.system.path=$USER_HOME$/.IdeaData/IDEA-15/scala/system",
        "-Didea.config.path=$USER_HOME$/.IdeaData/IDEA-15/scala/config",
        "-Dapple.laf.useScreenMenuBar=true",
        s"-Dplugin.path=${baseDirectory.value.getParentFile}/out/plugin",
        "-Didea.ProcessCanceledException=disabled"
      )
    )

// Packaging projects

lazy val packagedPluginDir = settingKey[File]("Path to packaged, but not yet compressed plugin")

packagedPluginDir in ThisBuild := baseDirectory.in(ThisBuild).value / "out" / "plugin" / "Jawa"

lazy val plugin_packager =
  newProject("plugin-packager")
    .settings(
      artifactPath := packagedPluginDir.value,
      dependencyClasspath :=
        dependencyClasspath.in(jawa_intellij, Compile).value ++
          dependencyClasspath.in(jc_plugin, Compile).value,
      mappings := {
        import Packaging.PackageEntry._
        val crossLibraries = List(
          (Dependencies.jawa, "lib")
        )
        val librariesToCopyAsIs = DependencyGroups.jawa_plugin.filterNot(lib =>
          crossLibraries.map(_._1).contains(lib) || lib == Dependencies.scalaLibrary)
        val jc = Seq(
          Artifact(pack.in(jc_plugin, Compile).value,
            "lib/jc/jawa-jc-plugin.jar"),
          Library(Dependencies.asm_all,
            "lib/jc/asm-all.jar"),
          Library(Dependencies.nailgun,
            "lib/jc/nailgun.jar"),
          Library(Dependencies.compilerInterfaceSources,
            "lib/jc/compiler-interface-sources.jar"),
          Library(Dependencies.incrementalCompiler,
            "lib/jc/incremental-compiler.jar"),
          Library(Dependencies.bundledJline,
            "lib/jc/jline.jar")
        )
        val lib = Seq(
          Artifact(pack.in(jawa_intellij, Compile).value,
            "lib/jawa-plugin.jar"),
          Artifact(pack.in(compiler_settings, Compile).value,
            "lib/compiler-settings.jar"),
          Artifact(pack.in(nailgun_runners, Compile).value,
            "lib/jawa-nailgun-runner.jar"),
          Library(Dependencies.scalaLibrary,
            "lib/scala-library.jar")
        ) ++
        crossLibraries.map { case (clib, dir) =>
          Library(clib.withName(s"${clib.name}_2.12"), s"$dir/${clib.name}.jar")
        } ++
        librariesToCopyAsIs.map { lib =>
          Library(lib, s"lib/${lib.name}.jar")
        }
        Packaging.convertEntriesToMappings(jc ++ lib, dependencyClasspath.value)
      },
      pack := {
        Packaging.packagePlugin(mappings.value, artifactPath.value)
        artifactPath.value
      }
    )

lazy val plugin_compressor =
  newProject("plugin-compressor")
    .settings(
      artifactPath := baseDirectory.in(ThisBuild).value / "out" / "jawa-plugin.zip",
      pack := {
        Packaging.compressPackagedPlugin(pack.in(plugin_packager).value, artifactPath.value)
        artifactPath.value
      }
    )