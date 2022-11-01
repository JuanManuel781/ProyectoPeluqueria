package com.unab.seguridad_33.irepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.seguridad_33.entity.Agendamientos;


public interface IAgendamientosRepository extends JpaRepository<Agendamientos, Integer> {

}
