package com.zuul;

import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zuul.filter.LoggerFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Bean
	public LoggerFilter loggerFilter() {
		return new LoggerFilter();
	}
}

@RestController
@RequestMapping("/balanced")
class TestController {
	
	@RequestMapping("/intReservations")
	public List<Integer> getListOfReservations(){
		return Arrays.asList(1,2,3,4,5,5);
	}

	/*
	 * @LoadBalanced public RestTemplate restTempalte;
	 */

	@Autowired
	RestTemplate restTempalte;

	@RequestMapping("/reservations")
	public String getBalencedReservations() {
//		URI URI = this.loadbalancer.choose("reservation").getUri();
//		List entity = this.restTempalte.getForObject(URI.toString() + "/reservations", List.class, new HashMap<>());
		
	    String greeting = this.restTempalte.getForObject("http://reservation/reservations", String.class);


		return "hello";
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
