package com.javier.codigo.codigoposta.models.response;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorException extends Throwable{



	private static final long serialVersionUID = -4903913495112810592L;

	private String developerMessage;
	
	private HttpStatus status;
	
	private Integer code;
	


	
}
