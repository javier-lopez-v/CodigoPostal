package com.javier.codigo.codigopostal.repository;

import org.springframework.data.repository.CrudRepository;

import com.javier.codigo.codigopostal.models.entity.CodigoPostal;

public interface IcodigoPostalDao extends CrudRepository<CodigoPostal, Long>{

}
