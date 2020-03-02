package com.javier.codigo.codigopostal.models.response;

import java.util.List;

import com.javier.codigo.codigopostal.models.entity.CodigoPostal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGeneric {

	private String zip_code;
	
	private String locality;
	
	private String federal_entity;
	private String municipality;
	private List<Settlement> settlements;
	
	public ResponseGeneric(CodigoPostal codigoPostal) {
		this.locality = codigoPostal.getMunicipio().getEstado().getNombreEstado();
		this.zip_code = codigoPostal.getNumeroCodigoPostal();
		this.federal_entity = codigoPostal.getMunicipio().getEstado().getCiudad();
		this.municipality = codigoPostal.getMunicipio().getNombreMunicipio();
		this.settlements = new Settlement().setLocalidades(codigoPostal.getLocalidades());
	}
	

}


