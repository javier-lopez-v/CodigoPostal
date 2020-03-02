package com.javier.codigo.codigopostal.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javier.codigo.codigopostal.models.response.CodigoPostalMap;
import com.javier.codigo.codigopostal.models.response.ResponseGeneric;
import com.javier.codigo.codigopostal.repository.CodigoPostalRepository;
import com.javier.codigo.codigopostal.service.ICodigoPostalServce;

@Service
public class CodigoPostalServiceImpl implements ICodigoPostalServce {

	@Autowired
	CodigoPostalRepository codigoPostalRepository;
	
	@Autowired 
	CodigoPostalMap  codigoPostalMap;

	@Override
	public ResponseGeneric codigoPostalByCode(String codigoPostalNumero) {

		//BooleanExpression qCodigoPosta = QCodigoPostal.codigoPostal.numeroCodigoPostal.eq(codigoPostalNumero);

		//CodigoPostal codigoPostal = codigoPostalRepository.findOne(qCodigoPosta).orElse(null);
		return null;
		//return codigoPostal == null ? null : new ResponseGeneric(codigoPostal);
	}

	@Override
	public ResponseGeneric codigoPostalByCodeExel(String codigoPostalNumero) {

		ResponseGeneric responseGeneric = codigoPostalMap.getResponceGeneric(codigoPostalNumero);
		return responseGeneric;
	}


	

}
