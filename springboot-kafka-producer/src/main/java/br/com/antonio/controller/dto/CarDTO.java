package br.com.antonio.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
	private Long id;
	private String model;
	private String color;
}
