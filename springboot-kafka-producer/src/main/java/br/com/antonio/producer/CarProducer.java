package br.com.antonio.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.antonio.controller.dto.CarDTO;

@Service
public class CarProducer {

	private static final Logger logger = LoggerFactory.getLogger(CarProducer.class);
	
	private final String topic;
	private final KafkaTemplate<String, CarDTO> kafkaTemplate;

	public CarProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, CarDTO> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(CarDTO carDTO) {
		this.kafkaTemplate.send(topic, carDTO).addCallback(
				success -> logger.info("Messagen send {} " + success.getProducerRecord().value()),
				failure -> logger.info("Messagen send {} " + failure.getMessage()));
	}

}
