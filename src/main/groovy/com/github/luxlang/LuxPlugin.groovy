package com.github.luxlang

import com.github.luxlang.LuxCompile
import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.Delete

class LuxPlugin implements Plugin<Project> {
  void apply(Project project) {
    project.extensions.create('lux', LuxPluginExtension)

    project.task('compileLux', type: LuxCompile).doFirst({
        sourcePath = project.lux.sourcePath
        program = project.lux.program
        resourcesPath = project.lux.resourcesPath
        build = project.lux.build
        classesPath = "${project.buildDir}/${project.lux.classesPath}"
    })

    project.task('packageLux', type: Jar).doFirst({
      from project.fileTree(dir: "${project.buildDir}/${project.lux.classesPath}").matching {
          include '**/*.class'
      }

      if(project.lux.targetPath == null) {
        destinationDir = new File("${project.buildDir}/outputs/jar/")
      } else {
        destinationDir = new File("${project.lux.targetPath}/outputs/jar/")
      }
      archiveName = "program.jar"
      manifest {
          attributes("Main-Class": "${project.lux.program}._")
      }
    }).dependsOn(project.tasks.compileLux)
  }
}

class LuxPluginExtension {
  String sourcePath
  String program
  String classesPath = "lux"
  String targetPath
  String resourcesPath = ""
  String build = "debug"
}
