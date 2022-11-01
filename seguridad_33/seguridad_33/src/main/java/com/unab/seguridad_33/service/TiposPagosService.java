package com.unab.seguridad_33.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unab.seguridad_33.entity.TiposPagos;
import com.unab.seguridad_33.irepository.ITiposPagosRepository;
import com.unab.seguridad_33.iservice.ITiposPagosService;

@Service
public class TiposPagosService implements ITiposPagosService {

	@Autowired
	private ITiposPagosRepository repository;

	@Override
	public List<TiposPagos> all() {
		// TODO Auto-generated method stub
		return  this.repository.findAll();
	}

	@Override
	public Optional<TiposPagos> findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public TiposPagos save(TiposPagos tiposPagos) {
		// TODO Auto-generated method stub
		return this.repository.save(tiposPagos);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
		
	}
}
