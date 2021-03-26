package com.init.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.cursos.model.Reserva;
import com.init.cursos.service.ReservaService;

@RestController
@RequestMapping("home")
public class ReservaController {
	@Autowired
	public ReservaService service;

	@PostMapping(value = "/realizaReserva")
	public ResponseEntity<Reserva> realizaReserva(@RequestBody Reserva reserva) {
		boolean realizado = service.realizaReserva(reserva);
		if (realizado) {
			return ResponseEntity.ok(reserva);
		}
		return ResponseEntity.ok(null);
	}

	@GetMapping(value = "/reservas")
	public ResponseEntity<List<Reserva>> listarReservas(@PathVariable("personaId") int personaId) {
		List<Reserva> reservas = service.listarReservas(personaId);
		return ResponseEntity.ok(reservas);
	}

}
