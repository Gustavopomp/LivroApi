package br.com.guAmaLivro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ApiRestFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestFullApplication.class, args);
	}

}
