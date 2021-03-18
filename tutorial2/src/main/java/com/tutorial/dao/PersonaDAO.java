package com.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
