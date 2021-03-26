package com.init.cursos.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.init.cursos.model.Clase;
import com.init.cursos.model.Persona;
import com.init.cursos.model.Profesor;
import com.init.cursos.model.Reserva;
import com.init.cursos.repository.ReservaDAO;

@SpringBootTest
public class ReservaServiceTest {
	ReservaDAO reservaDAO;

	@Autowired
	ReservaService service;

	@BeforeEach
	public void init() {

		service = new ReservaService();
		reservaDAO = Mockito.mock(ReservaDAO.class);

		service.reserva = reservaDAO;
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
		 * when(reservaDAO.save(reserva1)).thenReturn(reserva1);
		 * when(reservaDAO.save(reserva2)).thenReturn(reserva2);
		 * when(reservaDAO.save(null)).thenReturn(null);
		 */

	}

	@Test
	public void testRealizarReservaCorrecto() {

		Profesor profesor = new Profesor(1, "Alejandro");
		Clase clase1 = new Clase(1, profesor, "pilates");
		ArrayList<Reserva> reservas = new ArrayList<>();
		Persona persona = new Persona(1, "Mariam", reservas);
		Reserva reserva1 = new Reserva(1, clase1, persona);
		when(reservaDAO.save(reserva1)).thenReturn(reserva1);

		boolean bb = service.realizaReserva(reserva1);
		assertTrue(bb);
		System.out.println(bb);
		verify(reservaDAO).save(reserva1);

	}

	@Test
	public void testRealizarReservaIncorrecto() {

		boolean bb = service.realizaReserva(null);
		assertFalse(bb);
		verify(reservaDAO).save(null);

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

		when(reservaDAO.findAll()).thenReturn(reservas);

		List<Reserva> bb = service.listarReservas(1);
		assertArrayEquals(bb.toArray(), reservas.toArray());
		verify(reservaDAO).findAll();

	}

	@Test
	public void testListarReservasVacio() {

		ArrayList<Reserva> reservas = new ArrayList<>();

		List<Reserva> bb = service.listarReservas(2);
		assertArrayEquals(bb.toArray(), reservas.toArray());
		verify(reservaDAO).findAll();

	}
}
