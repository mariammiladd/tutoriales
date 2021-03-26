package com.init.cursos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.cursos.model.Reserva;
import com.init.cursos.repository.ReservaDAO;

@Service
public class ReservaService {
	@Autowired
	public ReservaDAO reserva;

	public boolean realizaReserva(Reserva r) {
		Reserva ok = reserva.save(r);
		if (ok != null) {
			return true;
		}
		return false;
	}

	public List<Reserva> listarReservas(int idPersona) {
		List<Reserva> reservas = reserva.findAll();
		ArrayList<Reserva> reservasPersona = new ArrayList<Reserva>();
		for (int i = 0; i < reservas.size(); i++) {
			Reserva aux = reservas.get(i);
			if (aux.getIdPersona().getId().equals(idPersona)) {
				reservasPersona.add(aux);
			}
		}
		return reservasPersona;
	}

	public void cancelarReserva(Reserva r) {
		reserva.delete(r);
	}

}
