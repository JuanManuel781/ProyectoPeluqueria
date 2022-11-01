package com.unab.seguridad_33.iservice;

import java.util.List;
import java.util.Optional;


import com.unab.seguridad_33.entity.Usuarios;

public interface IUsuriosService {
	
	public List<Usuarios> all();
	
	public Optional<Usuarios> findById(Integer id);
	
	public Usuarios save(Usuarios tiposPagos);
	
	public void delete(Integer id);

}
