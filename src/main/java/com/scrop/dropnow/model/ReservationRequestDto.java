package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservationRequestDto {
	private Long id;
	private String vehicle;
	private String type;
	private String pickup;
	private String destination;
	private double price;
	private Long userId;
}
