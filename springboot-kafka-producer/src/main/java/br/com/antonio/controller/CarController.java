package br.com.antonio.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.antonio.controller.dto.CarDTO;
import br.com.antonio.producer.CarProducer;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarProducer carProducer;

	@PostMapping
	public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO) {
		CarDTO car = CarDTO.builder().id(new Random().nextLong()).color(carDTO.getColor()).model(carDTO.getModel()).build();
		carProducer.send(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(car);
	}

}
