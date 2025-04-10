# Lab 2: Batch, Micro-Batch, Streaming Processing with Apache Spark

You can find [here](https://insatunisia.github.io/TP-BigData/tp2/) the Lab's Page.

Using Windows and VSCode I encountered some problems, so I used commands rather than relying on the extensions or VSCode itself when it comes to building the code. This makes it applied to other platforms and text editors or IDEs.

## Lab Objective

Running ***Apache Spark*** on ***Hadoop Yarn***.

### Explaining briefly the terms

- **Apache Spark:** Apache Spark is an open-source framework for big data processing, excelling in speed by using in-memory computation instead of disk-based approaches like Hadoop MapReduce. It provides a unified engine for batch processing, real-time streaming, machine learning, and SQL queries, scalable across clusters with APIs in multiple languages.
- **Hadoop Yarn:** Hadoop YARN is the resource management layer of Hadoop, introduced to efficiently allocate CPU and memory across a cluster for various applications. It splits duties between the ResourceManager, which oversees the entire cluster, and NodeManagers, which handle tasks and resources on individual nodes.

## Prerequesites

- Apache Spark ( found in Docker ) version 3.5.
- Apache Hadoop ( found in Docker ) version 3.3.6.
- Maven.
- Java 8 (new versions are incompatible with Hadoop, I guess the latest version supported is Java 17).
- Docker.
- You would need to install **hadoop windows** for ***Local Testing***: files included are *winutils.exe*, *hadoop.dll* and *hdfs.dll*. You can find these [here](https://github.com/cdarlint/winutils).

**NOTE:** Don't forget to add them to your path and add these variables too: *JAVA_HOME* and *HADOOP_HOME*.

**NOTE2:** Downloading a good Java 8 in windows feels like a hustle so after many trials here is the best one: Installers provided by [Adoptium](https://adoptium.net/fr/temurin/releases/?package=jdk&version=8&os=windows&arch=x64).

## Lab Work

Setup and run spark:

1. Attach a shell in the Master Node Container in Docker.
2. Create a `file1.txt`.
3. Run this command `hadoop fs -mkdir -p .` to add the current folder to **HDFS**.
4. Run this command `hdfs dfs -put file1.txt` to add the file to **HDFS**.
5. Use `spark-shell` to open a shell that you can provide the scala code in `count.scala`.
6. After running this code you should get the files from **HDFS** using this command: `hdfs dfs -get file1.count`.
7. Then read the results.

Use Spark Transformations with Scala:

1. Use `spark-shell` to open a shell that you can provide the scala code in `countBasedOnTransformations.scala`.
