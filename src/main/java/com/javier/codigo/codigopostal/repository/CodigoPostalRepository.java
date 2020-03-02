package com.javier.codigo.codigopostal.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.javier.codigo.codigopostal.models.entity.CodigoPostal;

public interface CodigoPostalRepository extends CrudRepository<CodigoPostal, Long>, QuerydslPredicateExecutor<CodigoPostal>{

}
