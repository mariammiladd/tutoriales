package com.init.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.cursos.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
