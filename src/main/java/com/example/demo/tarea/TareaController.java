package com.example.demo.tarea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.example.demo.tarea.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController


@RequestMapping(path = "api/agenda")

public class TareaController {


	@Autowired
	private final TareaService tareaService;
	
	public TareaController(TareaService tareaService) {
		this.tareaService = tareaService;
	}
	
	
	
	@GetMapping
	public List<Tarea> getStudents() {
		return tareaService.getTareas();
	}
	
	
	
	@PostMapping(value = "/api/agenda", consumes = {"application/json"}) 
	public void registerNewTarea(@RequestBody Tarea tarea) {
		tareaService.addNewTarea(tarea);
	}
	
	@PostMapping
	public void registrarTarea(@RequestParam(required = true) String titulo, @RequestParam(required = true) String descripcion, @RequestParam(required = true) String momento, @RequestParam(required = true) boolean completada ) throws Throwable {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate localDate = LocalDate.parse(momento, formatter);
		Tarea temp = new Tarea(titulo, descripcion, localDate, completada);
		tareaService.addNewTarea(temp);
	}
	
	@DeleteMapping(path = "{tareaId}")
	public void deleteTarea(@PathVariable("tareaId") Long tareaId) {
		tareaService.deleteTarea(tareaId);
	}
	
	@PutMapping(path = "{tareaId}")
	public void updateTarea(@PathVariable("tareaId") Long tareaId, @RequestParam(required = false) String titulo, @RequestParam(required = false) String descripcion, @RequestParam(required = false) LocalDate momento, @RequestParam(required = false) boolean completada ) throws Throwable {
		tareaService.updateTarea(tareaId, titulo, descripcion, momento, completada);
	}
	

}

