package com.javier.codigo.codigoposta.models.response;


import java.util.ArrayList;
import java.util.List;

import com.javier.codigo.codigoposta.models.entity.Localidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Settlement {
	
	private String name;
	
	private String zone_type;
	
	private String settlement_type;

	public List<Settlement> setLocalidades(List<Localidad> localidades) {
		List<Settlement> settlements = new ArrayList<Settlement>();
		
		localidades.forEach(l->{
			settlements.add(new Settlement(l.getNombreLocalidad(), l.getZona().getTipoZona(), l.getAsentamiento().getTipoAsentamiento()));
		});
		
		return settlements;
	}
	
}
