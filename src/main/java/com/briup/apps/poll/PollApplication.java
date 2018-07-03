package com.briup.apps.poll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class PollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollApplication.class, args);
	}
}
