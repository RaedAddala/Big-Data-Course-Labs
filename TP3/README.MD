# Lab 3: Data Ingestion using MoM Apache Kafka

You can find [here](https://insatunisia.github.io/TP-BigData/tp3/) the Lab's Page.

Using Windows and VSCode I encountered some problems, so I used commands rather than relying on the extensions or VSCode itself when it comes to building the code. This makes it applied to other platforms and text editors or IDEs.

## Lab Objective

Running ***Apache Kafka with Zookeeper*** for **data ingestion** and integrating them with ***Apache Spark***.

### Explaining briefly the terms

- **Apache Kafka:** Apache Kafka is an open-source distributed streaming platform designed for high-throughput, fault-tolerant, real-time data processing. It enables the publishing, subscribing, storing, and processing of data streams in a scalable manner, commonly used for event-driven architectures and log aggregation.
- **Apache Zookeeper:** Apache ZooKeeper is an open-source, distributed coordination service for managing large-scale systems. It provides a centralized infrastructure for configuration management, naming, synchronization, and group services, ensuring reliable communication and consistency across distributed applications.
- **Apache Spark:** Apache Spark is an open-source framework for big data processing, excelling in speed by using in-memory computation instead of disk-based approaches like Hadoop MapReduce. It provides a unified engine for batch processing, real-time streaming, machine learning, and SQL queries, scalable across clusters with APIs in multiple languages.
- **Hadoop Yarn:** Hadoop YARN is the resource management layer of Hadoop, introduced to efficiently allocate CPU and memory across a cluster for various applications. It splits duties between the ResourceManager, which oversees the entire cluster, and NodeManagers, which handle tasks and resources on individual nodes.

**Here is a Kafka Setup example**:
![An example of Kafka](kafkaFlow.png).

**Here is the architecture with Zookeeper on consideration:**
![Zookeeper context](Zookeeper.png).
This text is written in french. So here is what it means:

1. Ask for the Kafka Broker's adress.
2. Send the data in streaming.
3. Find the messages.
4. Update the offsets.

## Prerequesites

- Apache Zookeeper (found in Docker ) version 3.8.3.
- Apache Kafka ( found in Docker ) version 3.6.1.
- Apache Spark ( found in Docker ) version 3.5.
- Apache Hadoop ( found in Docker ) version 3.3.6.
- Maven.
- Java 8 (new versions are incompatible with Hadoop, I guess the latest version supported is Java 17).
- Docker.
- You would need to install **hadoop windows** for ***Local Testing***: files included are *winutils.exe*, *hadoop.dll* and *hdfs.dll*. You can find these [here](https://github.com/cdarlint/winutils).

**NOTE:** Don't forget to add them to your path and add these variables too: *JAVA_HOME* and *HADOOP_HOME*.

**NOTE2:** Downloading a good Java 8 in windows feels like a hustle so after many trials here is the best one: Installers provided by [Adoptium](https://adoptium.net/fr/temurin/releases/?package=jdk&version=8&os=windows&arch=x64).

## How to run each one of the servers

I setted up the `pom.xml` so you can run the three main functions without changing the file.

- Run SparkKafkaWordCount `mvn exec:java -Pwordcount`.
- Run SimpleProducer `mvn exec:java -Pproducer -Dtopic=Hello-Kafka`
- Run SimpleConsumer `mvn exec:java -Pconsumer`.

## Lab Tips

To troubleshoot problems there are some scripts that can help you out. For example: `kafka-broker-api-versions.sh --bootstrap-server localhost:9092`.
