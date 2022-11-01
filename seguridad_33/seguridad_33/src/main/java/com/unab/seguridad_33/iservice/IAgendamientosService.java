package com.unab.seguridad_33.iservice;

import java.util.List;
import java.util.Optional;

import com.unab.seguridad_33.entity.Agendamientos;


public interface IAgendamientosService {

	public List<Agendamientos> all();
	
	public Optional<Agendamientos> findById(Integer id);
	
	public Agendamientos save(Agendamientos agendamientos);
	
	public void delete(Integer id);

}
