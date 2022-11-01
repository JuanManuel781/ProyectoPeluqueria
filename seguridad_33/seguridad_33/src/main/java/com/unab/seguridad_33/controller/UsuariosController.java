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


import com.unab.seguridad_33.entity.Usuarios;
import com.unab.seguridad_33.iservice.IUsuriosService;

/* Para que puerto o ip quiere escuchar la peticion en este caso con el
 * (*) se define que de cualquier parte o cualquier ip */
@CrossOrigin(origins = "*")
/* Se encarga de restablecer respuesta  */
@RestController
/* nombre como se va a llamar la api */ 
@RequestMapping("api/usuarios")

public class UsuariosController {
	
	@Autowired
	private IUsuriosService service;
	
	@GetMapping
	public List<Usuarios> all(){
		return service. all();
	}
	
	@GetMapping("{id}")
	public Optional<Usuarios> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuarios save(@RequestBody Usuarios usuarios) {
		return service.save(usuarios);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuarios update(@PathVariable Integer id, @RequestBody Usuarios usuarios) {
		Optional<Usuarios> op= service.findById(id);
		if (!op.isEmpty()) {
			Usuarios usuariosUpdate = op.get();
			usuariosUpdate.setTipo_Documento(usuarios.getTipo_Documento());
			usuariosUpdate.setNumero_Documento(usuarios.getNumero_Documento());
			usuariosUpdate.setNombre(usuarios.getNombre());
			usuariosUpdate.setApellido(usuarios.getApellido());
			usuariosUpdate.setCorreo(usuarios.getCorreo());
			usuariosUpdate.setCelular(usuarios.getCelular());
			usuariosUpdate.setUsuario(usuarios.getUsuario());
			usuariosUpdate.setContrasenia(usuarios.getContrasenia());
			return service.save(usuariosUpdate);
		}
		return usuarios;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
