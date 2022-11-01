package com.unab.seguridad_33.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.seguridad_33.entity.Agendamientos;
import com.unab.seguridad_33.irepository.IAgendamientosRepository;
import com.unab.seguridad_33.iservice.IAgendamientosService;

 @Service
public class AgendamientosService implements IAgendamientosService{
	
	 @Autowired
	private IAgendamientosRepository repository;

	@Override
	public List<Agendamientos> all() {
		// TODO Auto-generated method stub
		return  this.repository.findAll();
	}

	@Override
	public Optional<Agendamientos> findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public Agendamientos save(Agendamientos agendamientos) {
		// TODO Auto-generated method stub
		return this.repository.save(agendamientos);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
		
	}

}
