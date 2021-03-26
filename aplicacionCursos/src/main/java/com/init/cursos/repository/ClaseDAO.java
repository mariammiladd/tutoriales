package com.init.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.cursos.model.Clase;

public interface ClaseDAO extends JpaRepository<Clase, Integer> {

}
