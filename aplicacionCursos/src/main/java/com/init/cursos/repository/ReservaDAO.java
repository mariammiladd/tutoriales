package com.init.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.cursos.model.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Long> {

}
