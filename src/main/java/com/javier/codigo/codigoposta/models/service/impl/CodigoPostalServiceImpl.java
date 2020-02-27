package com.javier.codigo.codigoposta.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javier.codigo.codigoposta.models.entity.CodigoPostal;
import com.javier.codigo.codigoposta.models.entity.QCodigoPostal;
import com.javier.codigo.codigoposta.models.response.ResponseGeneric;
import com.javier.codigo.codigoposta.models.service.ICodigoPostalServce;
import com.javier.codigo.codigoposta.repository.CodigoPostalRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class CodigoPostalServiceImpl implements ICodigoPostalServce {

	@Autowired
	CodigoPostalRepository codigoPostalRepository;

	@Override
	public ResponseGeneric codigoPostalByCode(String codigoPostalNumero) {

		BooleanExpression qCodigoPosta = QCodigoPostal.codigoPostal.numeroCodigoPostal.eq(codigoPostalNumero);

		CodigoPostal codigoPostal = codigoPostalRepository.findOne(qCodigoPosta).orElse(null);

		return codigoPostal == null ? null : new ResponseGeneric(codigoPostal);
	}

}
