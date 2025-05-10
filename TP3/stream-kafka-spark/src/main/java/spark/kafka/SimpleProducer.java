package spark.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class SimpleProducer {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Specify the Topic's name!");
            return;
        }

        String topicName = args[0];
        System.out.println("Topic: " + topicName);

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Kafka exposed by hadoop-master
        props.put("acks", "all");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("delivery.timeout.ms", 120000); // 2 minutes
        props.put("request.timeout.ms", 30000); // 30 seconds
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 10; i++) {
                String key = Integer.toString(i);
                String value = Integer.toString(i);
                ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
                producer.send(record, (RecordMetadata metadata, Exception exception) -> {
                    if (exception == null) {
                        System.out.println("Message " + key + " sent to partition " + metadata.partition() +
                                ", offset " + metadata.offset());
                    } else {
                        System.err.println("Error sending message " + key + ": " + exception.getMessage());
                    }
                });
            }
            producer.flush(); // Ensure all messages are sent
        }
        System.out.println("All messages sent!");
    }
}