package com.uberall.locationEndPoint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uberall.locationEndPoint.model.StoreInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.InputStream;

@SpringBootApplication
public class LocationEndPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationEndPointApplication.class, args);
	}
}
