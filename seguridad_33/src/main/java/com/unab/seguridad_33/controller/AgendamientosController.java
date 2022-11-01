package com.unab.seguridad_33.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.seguridad_33.entity.Agendamientos;
import com.unab.seguridad_33.iservice.IAgendamientosService;


/* Para que puerto o ip quiere escuchar la peticion en este caso con el
 * (*) se define que de cualquier parte o cualquier ip */
@CrossOrigin(origins = "*")
/* Se encarga de restablecer respuesta  */
@RestController
/* nombre como se va a llamar la api */ 
@RequestMapping("api/agendamientos")
public class AgendamientosController {
	@Autowired
	private IAgendamientosService service;
	
	@GetMapping
	public List<Agendamientos> all(){
		return service. all();
	}
	
	@GetMapping("{id}")
	public Optional<Agendamientos> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Agendamientos save(@RequestBody Agendamientos agendamientos) {
		return service.save(agendamientos);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Agendamientos update(@PathVariable Integer id, @RequestBody Agendamientos agendamientos) {
		Optional<Agendamientos> op= service.findById(id);
		if (!op.isEmpty()) {
			Agendamientos agendamientosUpdate = op.get();
			agendamientosUpdate.setFecha(agendamientos.getFecha());
			agendamientosUpdate.setHora(agendamientos.getHora());
			
			
			return service.save(agendamientosUpdate);
		}
		return agendamientos;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}


}
