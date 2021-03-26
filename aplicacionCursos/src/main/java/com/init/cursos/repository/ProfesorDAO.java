package com.init.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.cursos.model.Profesor;

public interface ProfesorDAO extends JpaRepository<Profesor, Long> {

}
