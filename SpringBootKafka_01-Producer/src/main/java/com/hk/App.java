package com.hk;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class App 
{
    public static void main( String[] args ) {
    	try (Scanner s = new Scanner(System.in)) {
			Properties properties = new Properties();
			properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			
			try (KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties)) {
				while(true) {
					ProducerRecord<String, String> producerRecord =
									new ProducerRecord<String, String>("topic-02", s.nextLine());
				    
				    producer.send(producerRecord);
				    producer.flush();
				}
			}
		}
    }
}
