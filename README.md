# LuxGradlePlugin
A gradle plugin for building Lux applications

#### Usage:
```
gradle packageLux
```
Then run with
```
java -jar build/outputs/jar/program.jar
```

#### Building:

Just build using gradle. A jar file should be created in build/libs
```
gradle build
```

#### Installing:

This will install into your local Maven repository
```
gradle install
```

Until the plugin is available in a central repository, you will need to build and install the plugin yourself.

#### Example:

Assuming you've built and installd the plugin to you local maven repository (~/.m2) ...
Example folder structure (See the example app in the repository):
```bash
build.gradle
src/your/package/main.lux
```

Sample __build.gradle__
```
buildscript {
    repositories {
      jcenter()
      mavenLocal()
    }
    dependencies {
      classpath 'com.github.luxlang:luxc-jvm:0.5.0'
      classpath 'com.github.luxlang:stdlib:0.5.0'
      classpath 'com.github.luxlang:LuxGradlePlugin:0.3-SNAPSHOT'
    }
}

apply plugin: 'com.github.luxlang.lux'
 
lux {
  program = 'your/package/main'
  sourcePath = 'src'
  build = "debug"
}
```
