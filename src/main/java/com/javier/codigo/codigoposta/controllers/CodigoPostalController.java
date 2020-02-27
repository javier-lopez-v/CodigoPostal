package com.javier.codigo.codigoposta.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javier.codigo.codigoposta.models.response.ErrorResponse;
import com.javier.codigo.codigoposta.models.response.ResponseGeneric;
import com.javier.codigo.codigoposta.models.service.ICodigoPostalServce;


@RestController
public class CodigoPostalController {

	private static Logger log = LoggerFactory.getLogger(CodigoPostalController.class);

	@Autowired
	ICodigoPostalServce codigoPostalService;

	@GetMapping("/zip-codes/{codigoPostal}")
	public ResponseEntity<?> codigoPostal(@PathVariable String codigoPostal) {

		ResponseGeneric responce;
		try {
			responce = codigoPostalService.codigoPostalByCode(codigoPostal);
			if (responce == null) {
				return new ResponseEntity<>(new ErrorResponse(), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<ResponseGeneric>(responce, HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(new ErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
