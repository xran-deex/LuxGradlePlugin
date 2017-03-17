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
Until the plugin is available in a repository, you will need to copy the jar file into whatever project you need to build.

#### Example:

Assuming you've copied the __LuxGradlePlugin-0.1-SNAPSHOT.jar__ into the libs directory in your project's root directory...
Example folder structure (See the example app in the repository):
```bash
build.gradle
src/your/package/main.lux
libs/LuxGradlePlugin-0.1-SNAPSHOT.jar
```

Sample __build.gradle__
```
buildscript {
    repositories {
      jcenter()
      flatDir {
        dirs "./libs"
      }
    }
    dependencies {
      classpath 'com.github.luxlang:luxc-jvm:0.5.0'
      classpath 'com.github.luxlang:stdlib:0.5.0'
      classpath 'com.github.luxlang:LuxGradlePlugin:0.1-SNAPSHOT'
    }
}

apply plugin: 'com.github.luxlang.lux'
 
lux {
  program = 'your/package/main'
  sourcePath = 'src'
}
```
