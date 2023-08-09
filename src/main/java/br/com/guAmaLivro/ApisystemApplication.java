package br.com.guAmaLivro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ApisystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisystemApplication.class, args);
	}

}
