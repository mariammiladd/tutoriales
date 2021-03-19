package com.mitocode.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mitocode.TutorialConsolaDependenciasApplication;

@Repository
@Qualifier("persona1")
public class PersonaRepo1 implements IPersonaRepo {
	private static Logger LOG = LoggerFactory.getLogger(TutorialConsolaDependenciasApplication.class);

	@Override
	public void registrar(String nombre) {
		LOG.info("Se ha registrado la persona " + nombre);

	}

}
