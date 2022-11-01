package com.unab.seguridad_33.iservice;

import java.util.List;
import java.util.Optional;

import com.unab.seguridad_33.entity.TiposPagos;

public interface ITiposPagosService {
	
	public List<TiposPagos> all();
	
	public Optional<TiposPagos> findById(Integer id);
	
	public TiposPagos save(TiposPagos tiposPagos);
	
	public void delete(Integer id);
	

}
