package com.tutorial.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.dao.PersonaDAO;
import com.tutorial.model.Persona;

@RestController
@RequestMapping("personas")
public class PersonaREST {
	@Autowired
	private PersonaDAO personaDAO;

	@PostMapping(value = "/guardar")
	public void createPersona(@RequestBody Persona persona) {
		personaDAO.save(persona);

	}

	@RequestMapping(value = "/listar")
	public List<Persona> getPersonas() {
		return personaDAO.findAll();
	}

	@DeleteMapping(value = "/eliminar/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}

	@PutMapping(value = "/actualizar")
	public void updatePersona(@RequestBody Persona persona) {
		personaDAO.save(persona);

	}
}
