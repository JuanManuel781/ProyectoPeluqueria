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

import com.unab.seguridad_33.entity.Roles;
import com.unab.seguridad_33.iservice.IRolesService;

/* Para que puerto o ip quiere escuchar la peticion en este caso con el
 * (*) se define que de cualquier parte o cualquier ip */
@CrossOrigin(origins = "*")
/* Se encarga de restablecer respuesta  */
@RestController
/* nombre como se va a llamar la api */ 
@RequestMapping("api/roles")
public class RolesController {
	
	@Autowired
	private IRolesService service;
	
	@GetMapping
	public List<Roles> all(){
		return service. all();
	}
	
	@GetMapping("{id}")
	public Optional<Roles> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Roles save(@RequestBody Roles roles) {
		return service.save(roles);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Roles update(@PathVariable Integer id, @RequestBody Roles roles) {
		Optional<Roles> op= service.findById(id);
		if (!op.isEmpty()) {
			Roles rolesUpdate = op.get();
			rolesUpdate.setDescripcion(roles.getDescripcion());
			return service.save(rolesUpdate);
		}
		return roles;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	

}
