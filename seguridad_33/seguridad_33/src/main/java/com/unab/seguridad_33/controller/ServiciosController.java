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

import com.unab.seguridad_33.entity.Servicios;
import com.unab.seguridad_33.iservice.IServiciosService;


/* Para que puerto o ip quiere escuchar la peticion en este caso con el
 * (*) se define que de cualquier parte o cualquier ip */
@CrossOrigin(origins = "*")
/* Se encarga de restablecer respuesta  */
@RestController
/* nombre como se va a llamar la api */ 
@RequestMapping("api/servicios")

public class ServiciosController {
	
	@Autowired
	private IServiciosService service;
	
	@GetMapping
	public List<Servicios> all(){
		return service. all();
	}
	
	@GetMapping("{id}")
	public Optional<Servicios> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Servicios save(@RequestBody Servicios servicios) {
		return service.save(servicios);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Servicios update(@PathVariable Integer id, @RequestBody Servicios servicios) {
		Optional<Servicios> op= service.findById(id);
		if (!op.isEmpty()) {
			Servicios serviciosUpdate = op.get();
			serviciosUpdate.setDescripcion(servicios.getDescripcion());
			
			return service.save(serviciosUpdate);
		}
		return servicios;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
