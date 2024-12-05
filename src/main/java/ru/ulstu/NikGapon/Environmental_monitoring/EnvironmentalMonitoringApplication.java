package ru.ulstu.NikGapon.Environmental_monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EnvironmentalMonitoringApplication {

	public static void main(String[] args) {

		SpringApplication.run(EnvironmentalMonitoringApplication.class, args);
	}

}
