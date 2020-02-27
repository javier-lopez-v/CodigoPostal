package com.javier.codigo.codigoposta.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "localidades")
public class Localidad implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_localidad")
	private Long idLocalidad;

	@Column(name = "nombre_localidad")
	private String nombreLocalidad;
	
//	@JsonManagedReference
//    @ManyToOne( cascade=CascadeType.ALL)
//	@JoinColumn(name = "id_municipio")
//    private Municipio municipio;
	
	//@JsonManagedReference
//    @OneToOne( cascade=CascadeType.ALL)
//	@JoinColumn(name = "id_municipio")
//    private Municipio municipio;
	

	
	@JsonManagedReference
    @ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_codigo_postal")
    private CodigoPostal codigoPostal;
	
	@JsonManagedReference
    @ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_zona")
    private Zona zona;
	
	@JsonManagedReference
    @ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_asentamiento")
    private Asentamiento asentamiento;

	private static final long serialVersionUID = 2430707252851383883L;

}
