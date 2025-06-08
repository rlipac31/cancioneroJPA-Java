package com.richardlipa.cancionero;

import com.richardlipa.cancionero.principal.Principal;
import com.richardlipa.cancionero.repository.ICancionRepository;
import com.richardlipa.cancionero.repository.ICantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CancioneroApplication implements CommandLineRunner {
	@Autowired // anotacion para hacer injencion de dependencias
	private ICantanteRepository repository;
	@Autowired
	private ICancionRepository cancionRepository;


	public static void main(String[] args) {
		SpringApplication.run(CancioneroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("saludos sprint JPA");
		Principal principal = new Principal(repository,cancionRepository);
		principal.muestraElMenu();
	}
}
