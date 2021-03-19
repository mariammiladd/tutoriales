package com.mitocode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mitocode.service.IPersonaService;

@SpringBootApplication
public class TutorialConsolaDependenciasApplication implements CommandLineRunner {

	// private static Logger LOG =
	// LoggerFactory.getLogger(TutorialConsolaDependenciasApplication.class);
	@Autowired
	private IPersonaService service;

	public static void main(String[] args) {
		SpringApplication.run(TutorialConsolaDependenciasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// LOG.info("Esto es una aplicación de consola");
		service.registrar("Mitocode");
	}

}
