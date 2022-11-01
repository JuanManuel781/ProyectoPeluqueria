package com.unab.seguridad_33.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.seguridad_33.entity.Roles;
import com.unab.seguridad_33.irepository.IRolesRepository;
import com.unab.seguridad_33.iservice.IRolesService;

@Service
public class RolesService implements IRolesService {
	
	@Autowired
	private IRolesRepository repository;

	@Override
	public List<Roles> all() {
		// TODO Auto-generated method stub
		return  this.repository.findAll();
	}

	@Override
	public Optional<Roles> findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public Roles save(Roles roles) {
		// TODO Auto-generated method stub
		return this.repository.save(roles);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
		
	}
}
