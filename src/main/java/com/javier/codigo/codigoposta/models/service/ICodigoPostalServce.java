package com.javier.codigo.codigoposta.models.service;

import com.javier.codigo.codigoposta.models.response.ResponseGeneric;

public interface ICodigoPostalServce {
	ResponseGeneric codigoPostalByCode(String codigoPostal);
}
