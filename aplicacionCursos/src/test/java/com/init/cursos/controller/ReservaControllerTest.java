package com.init.cursos.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.init.cursos.model.Clase;
import com.init.cursos.model.Persona;
import com.init.cursos.model.Profesor;
import com.init.cursos.model.Reserva;
import com.init.cursos.repository.ReservaDAO;
import com.init.cursos.service.ReservaService;

public class ReservaControllerTest {

	@Autowired
	ReservaController controller;

	ReservaService service;

	ReservaDAO reservaDAO;

	@BeforeEach
	public void init() {
		controller = new ReservaController();

		service = Mockito.mock(ReservaService.class);
		reservaDAO = Mockito.mock(ReservaDAO.class);

		service.reserva = reservaDAO;
		controller.service = service;

		/*
		 * Profesor profesor = new Profesor(1, "Alejandro"); Clase clase1 = new Clase(1,
		 * profesor, "pilates"); Clase clase2 = new Clase(2, profesor, "boxeo");
		 * 
		 * ArrayList<Reserva> reservas = new ArrayList<>(); Persona persona = new
		 * Persona(1, "Mariam", reservas);
		 * 
		 * Reserva reserva1 = new Reserva(1, clase1, persona); Reserva reserva2 = new
		 * Reserva(2, clase2, persona);
		 * 
		 * reservas.add(reserva1); reservas.add(reserva2);
		 * 
		 * ArrayList<Reserva> reservas2 = new ArrayList<>();
		 * 
		 * when(reservaDAO.save(reserva1)).thenReturn(reserva1);
		 * when(reservaDAO.save(reserva2)).thenReturn(reserva2);
		 * when(reservaDAO.save(null)).thenReturn(null);
		 * when(service.realizaReserva(reserva1)).thenReturn(true);
		 * when(service.realizaReserva(reserva2)).thenReturn(true);
		 * when(service.realizaReserva(null)).thenReturn(false);
		 * 
		 * when(reservaDAO.findAll()).thenReturn(reservas);
		 * when(service.listarReservas(1)).thenReturn(reservas);
		 * when(service.listarReservas(2)).thenReturn(reservas2);
		 */
	}

	@Test
	public void testRealizarReservaCorrecto() {

		Profesor profesor = new Profesor(1, "Alejandro");
		Clase clase1 = new Clase(1, profesor, "pilates");
		ArrayList<Reserva> reservas = new ArrayList<>();
		Persona persona = new Persona(1, "Mariam", reservas);
		Reserva reserva = new Reserva(1, clase1, persona);

		when(service.realizaReserva(reserva)).thenReturn(true);

		ResponseEntity<Reserva> bb = controller.realizaReserva(reserva);
		assertEquals(bb.getBody().getId(), reserva.getId());
		assertEquals(bb.getBody().getIdClase(), reserva.getIdClase());
		assertEquals(bb.getBody().getIdPersona(), reserva.getIdPersona());

		verify(service).realizaReserva(reserva);

	}

	@Test
	public void testRealizarReservaIncorrecto() {

		ResponseEntity<Reserva> bb = controller.realizaReserva(null);
		assertNull(bb.getBody());

		verify(service).realizaReserva(null);

	}

	@Test
	public void testListarReservas() {

		Profesor profesor = new Profesor(1, "Alejandro");
		Clase clase1 = new Clase(1, profesor, "pilates");
		Clase clase2 = new Clase(2, profesor, "boxeo");

		ArrayList<Reserva> reservas = new ArrayList<>();
		Persona persona = new Persona(1, "Mariam", reservas);

		Reserva reserva1 = new Reserva(1, clase1, persona);
		Reserva reserva2 = new Reserva(2, clase2, persona);

		reservas.add(reserva1);
		reservas.add(reserva2);

		when(service.listarReservas(1)).thenReturn(reservas);

		ResponseEntity<List<Reserva>> bb = controller.listarReservas(1);
		assertArrayEquals(bb.getBody().toArray(), reservas.toArray());

		verify(service).listarReservas(1);

	}

	@Test
	public void testListarReservasVacio() {

		ArrayList<Reserva> reservas = new ArrayList<>();

		ResponseEntity<List<Reserva>> bb = controller.listarReservas(2);
		assertArrayEquals(bb.getBody().toArray(), reservas.toArray());

		verify(service).listarReservas(2);

	}
}
