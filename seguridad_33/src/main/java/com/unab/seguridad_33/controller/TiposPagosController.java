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

import com.unab.seguridad_33.entity.TiposPagos;
import com.unab.seguridad_33.iservice.ITiposPagosService;

/* Para que puerto o ip quiere escuchar la peticion en este caso con el
 * (*) se define que de cualquier parte o cualquier ip */
@CrossOrigin(origins = "*")
/* Se encarga de restablecer respuesta  */
@RestController
/* nombre como se va a llamar la api */ 
@RequestMapping("api/tiposPagos")
public class TiposPagosController {
	
	@Autowired
	private ITiposPagosService service;
	
	@GetMapping
	public List<TiposPagos> all(){
		return service. all();
	}
	
	@GetMapping("{id}")
	public Optional<TiposPagos> show(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TiposPagos save(@RequestBody TiposPagos tiposPagos) {
		return service.save(tiposPagos);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TiposPagos update(@PathVariable Integer id, @RequestBody TiposPagos tiposPagos) {
		Optional<TiposPagos> op= service.findById(id);
		if (!op.isEmpty()) {
			TiposPagos tiposPagosUpdate = op.get();
			tiposPagosUpdate.setDescripcion(tiposPagos.getDescripcion());
			
			return service.save(tiposPagosUpdate);
		}
		return tiposPagos;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}


}
