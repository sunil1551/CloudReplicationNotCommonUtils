package com.carnival.replication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource("file:${APP_PROP_PATH}/application-${SPRING_PROFILES_ACTIVE}.properties")
public class CloudReplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudReplicationApplication.class, args);
	}
}