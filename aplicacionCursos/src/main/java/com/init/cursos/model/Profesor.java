package com.init.cursos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Profesor {

	@Id
	@Column(name = "idProfesor")
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

}
