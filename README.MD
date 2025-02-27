# Big Data Labs

These are Lab Submissions for a Big Data Course given by Dr. Lilia Sfaxi @INSATunisia.

## Lab 1: Batch Processing with Hadoop

You can find [here](https://insatunisia.github.io/TP-BigData/tp1/) the Lab's Page.

Using Windows and VSCode I encountered some problems, so I used commands rather than relying on the extensions or VSCode itself when it comes to building the code.

### Prerequesites

- Maven.
- Java 8 (new versions are incompatible with Hadoop, I guess the newest version supported is Java 17).
- Docker.
- You would need to install **hadoop windows** for ***Local Testing***: files included are *winutils.exe*, *hadoop.dll* and *hdfs.dll*. You can find these [here](https://github.com/cdarlint/winutils).

**NOTE:** Don't forget to add them to your path and add these variables too: *JAVA_HOME* and *HADOOP_HOME*.

**NOTE2:** Downloading a good Java 8 in windows feels like a hustle so after many trials here is the best one: Installers provided by [Adoptium](https://adoptium.net/fr/temurin/releases/?package=jdk&version=8&os=windows&arch=x64).

### Core Commands

Make sure you are in the wordcount folder.

- `mvn exec:java`: compiles the code and runs the main function in WordCount with main arguments. (Check `TP1/wordcount/pom.xml` at line 81).
- `mvn clean`: cleans the target.
- `mvn package`: packages the code into a JAR file you can share to the Hadoop Docker Cluster.

### Working with Docker

I would prefer to use Docker Compose over using docker commands because it centralizes all needed configurations and it is easier to debug and maintain.

In VSCode it is easy to attach a shell and it will open up in the terminal. This made it easier for me.
