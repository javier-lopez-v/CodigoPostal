package com.javier.codigo.codigopostal.service;

import com.javier.codigo.codigopostal.models.response.ResponseGeneric;

public interface ICodigoPostalServce {
	ResponseGeneric codigoPostalByCode(String codigoPostal);
	
	ResponseGeneric codigoPostalByCodeExel(String codigoPostal);
}
