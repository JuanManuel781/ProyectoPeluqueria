package com.unab.seguridad_33.iservice;

import java.util.List;
import java.util.Optional;

import com.unab.seguridad_33.entity.Servicios;

public interface IServiciosService {
	
	public List<Servicios> all();
	
	public Optional<Servicios> findById(Integer id);
	
	public Servicios save(Servicios servicios);
	
	public void delete(Integer id);
	

}
