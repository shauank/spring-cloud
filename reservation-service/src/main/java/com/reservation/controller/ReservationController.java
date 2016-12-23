package com.reservation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RefreshScope

public class ReservationController {

	@Value("${dbpassword}")
	private String message;

	@RequestMapping(method = RequestMethod.GET)
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<>();
		Arrays.asList("Dev", "Ria", "John").forEach(name -> reservations.add(new Reservation(name + this.message)));

		return reservations;
	}
}
