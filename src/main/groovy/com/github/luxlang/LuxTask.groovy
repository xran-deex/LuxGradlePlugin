package com.github.luxlang

import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.TaskAction

apply plugin: 'java'

class LuxCompile extends JavaExec {

  String sourcePath
  String program
  String classesPath = "lux_classes"

  @Override
  void exec() {
    setMain("lux")
    def relativeClassesDir = project.relativePath(classesPath)
    setArgs(["release", program, "", sourcePath, relativeClassesDir])

    classpath += project.buildscript.configurations.classpath

    super.exec();
  }
}
