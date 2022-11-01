package com.unab.seguridad_33.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unab.seguridad_33.entity.Usuarios;
import com.unab.seguridad_33.irepository.IUsuariosRepository;
import com.unab.seguridad_33.iservice.IUsuriosService;

@Service
public class UsuariosService implements IUsuriosService{
	
	@Autowired
	private IUsuariosRepository repository;

	@Override
	public List<Usuarios> all() {
		// TODO Auto-generated method stub
		return  this.repository.findAll();
	}

	@Override
	public Optional<Usuarios> findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public Usuarios save(Usuarios usuarios) {
		// TODO Auto-generated method stub
		return this.repository.save(usuarios);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
		
	}

}
