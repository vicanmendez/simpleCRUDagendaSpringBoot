package com.example.demo.tarea;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.tarea.Tarea;
import com.example.demo.tarea.TareaRepository;


@Service
public class TareaService {
private  final TareaRepository tareaRepository;
	
	
	
	public TareaService(TareaRepository tareaRepository) {
		this.tareaRepository = tareaRepository;
	}
	
	
	
	@GetMapping
	public List<Tarea> getTareas() {
		return tareaRepository.findAll();
	}

	public void addNewTarea(Tarea t) {
		tareaRepository.save(t);
		System.out.println(t.toString());
		
		
	}

	public void deleteTarea(Long tareaId) {
		if (tareaRepository.existsById(tareaId)) {
			tareaRepository.deleteById(tareaId);
		} else {
			throw new IllegalStateException("Tarea with id " +tareaId+ " does not exists");
		}
	}

	//The annotation Transactional means that we have not to implement any JPQL query, we will use the setters of our Entity class
	@Transactional
	public void updateTarea(Long tareaId, String titulo, String descripcion, LocalDate momento, boolean completada) throws Throwable {
		//Check if exists
	     Tarea tarea = (Tarea) tareaRepository.findById(tareaId).orElseThrow(() -> new IllegalStateException("Student with id " +tareaId+" does not exist"));
		
		if(titulo != null && titulo.length() > 0 && !Objects.equals(tarea.getTitulo(), titulo)) {
			tarea.setTitulo(titulo);
		}
		
		if(descripcion != null && descripcion.length() > 0 && !Objects.equals(tarea.getDescripcion(), descripcion)) {
			//Before updating the email, we've to check if the email is already taken
			
		
			tarea.setDescripcion(descripcion);
		}
	}

}
