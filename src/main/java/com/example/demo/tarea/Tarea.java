package com.example.demo.tarea;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity(name="tarea")
@Table(name="tarea")
public class Tarea {
	@Id
	@SequenceGenerator(
			name = "tarea_sequence",
			sequenceName = "tarea_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "tarea_sequence"
			)
	
	private long id;
	private String titulo;
	private String descripcion;
	private LocalDate momento;
	private boolean completada;
	
	
	public Tarea(String titulo, String descripcion, LocalDate momento, boolean completada) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.momento = momento;
		this.completada = completada;
	}


	public Tarea() {
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getMomento() {
		return momento;
	}


	public void setMomento(LocalDate momento) {
		this.momento = momento;
	}


	public boolean isCompletada() {
		return completada;
	}


	public void setCompletada(boolean completada) {
		this.completada = completada;
	}


	public long getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
