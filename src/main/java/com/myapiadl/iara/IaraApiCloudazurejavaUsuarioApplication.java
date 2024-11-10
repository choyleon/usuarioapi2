package com.myapiadl.iara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IaraApiCloudazurejavaUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(IaraApiCloudazurejavaUsuarioApplication.class, args);
	}

}
