package com.telnet.api;

import com.telnet.api.model.Backend;
import com.telnet.api.repository.BackendRepository;
import com.telnet.api.service.TelnetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BackendRepository backendRepository, TelnetService telnetService) {
		return args -> {
			Backend backend1 = new Backend("BackendName", "google.com", 443);
			Backend backend2 = new Backend("BackendName", "google.com", 442);
			Backend backend3 = new Backend("BackendName", "google.com", 442);
			Backend backend4 = new Backend("BackendName", "google.com", 443);

			List<Backend> backends = new ArrayList<>();
			backends.add(backend1);
			backends.add(backend2);
			backends.add(backend3);
			backends.add(backend4);

			backendRepository.saveAll(backends);

		};
	}

}
