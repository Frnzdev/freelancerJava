package com.codify.labor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Map;

@EnableFeignClients
@SpringBootApplication
public class LaborApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaborApplication.class, args);
	}

}
