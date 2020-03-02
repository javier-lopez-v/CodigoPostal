package com.javier.codigo.codigopostal.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "codigo_postal")
public class CodigoPostal implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_codigo_postal")
	private Long idCodigoPostal;

	@Column(name = "codigo_postal")
	private String numeroCodigoPostal;
	
	//@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_codigo_postal")
	private List<Localidad> localidades;
	
    @OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_municipio")
    private Municipio municipio;
	
	private static final long serialVersionUID = 5084377028252322701L;

}
