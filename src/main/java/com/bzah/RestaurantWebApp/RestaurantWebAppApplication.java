package com.bzah.RestaurantWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class RestaurantWebAppApplication {


	static Orders orders = new Orders();

	public static void main(String[] args) {
		SpringApplication.run(RestaurantWebAppApplication.class, args);
	}

}
