package org.minejava.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@Configuration
@EnableAdminServer
@SpringBootApplication
@EnableAutoConfiguration // Doubt if needed
public class AdminServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}
}
