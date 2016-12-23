package reservation.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reservation.controller.ReservationController;

@SpringBootApplication
//@ComponentScan(basePackageClasses = ReservationController.class)
public class ReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}
}


@RestController
@RequestMapping("/message")
class TestController{
	
	@Value("${bar}")
	private String message;
	
}
