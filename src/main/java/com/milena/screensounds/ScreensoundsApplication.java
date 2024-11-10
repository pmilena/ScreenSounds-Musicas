package com.milena.screensounds;

import com.milena.screensounds.principal.Principal;
import com.milena.screensounds.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundsApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Principal principal = new Principal(repository);
	principal.exibeMenu();
	}
}
