package com.unab.seguridad_33.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unab.seguridad_33.entity.Servicios;
import com.unab.seguridad_33.irepository.IServiciosRepository;
import com.unab.seguridad_33.iservice.IServiciosService;

@Service
public class ServiciosService implements IServiciosService {
	
	 @Autowired
		private IServiciosRepository repository;

		@Override
		public List<Servicios> all() {
			// TODO Auto-generated method stub
			return  this.repository.findAll();
		}

		@Override
		public Optional<Servicios> findById(Integer id) {
			// TODO Auto-generated method stub
			return this.repository.findById(id);
		}

		@Override
		public Servicios save(Servicios servicios) {
			// TODO Auto-generated method stub
			return this.repository.save(servicios);
		}

		@Override
		public void delete(Integer id) {
			// TODO Auto-generated method stub
			this.repository.deleteById(id);
			
		}


}
