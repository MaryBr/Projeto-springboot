package br.com.erudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class application {

	public static void main(String[] args) {
		System.out.println("Iníciando calculadora...");
		SpringApplication.run(application.class, args);
		System.out.println("Fim calculadora");
	}
}
