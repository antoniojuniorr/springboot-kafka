package br.com.antonio.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.antonio.dto.CarDTO;


@Component
public class CarConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);
	
	@Value(value = "${topic.name}")
	private String topic;
	
	@KafkaListener(topics = "${topic.name}", groupId = "group_id")
	public void listenTopicCar(ConsumerRecord<String, CarDTO> record) {
		logger.info("Receive Message Value {} " + record.value());
		logger.info("Receive Message Topic {} " + record.topic());
	}
	
	
}
