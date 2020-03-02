package com.javier.codigo.codigopostal.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "municipios")
public class Municipio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_municipio")
	private Long idMunicipio;

	@Column(name = "nombre_municipio")
	private String nombreMunicipio;
	
    @OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_estado")
    private Estado estado;
	
//	@JsonManagedReference
//    @ManyToOne( cascade=CascadeType.ALL)
//	@JoinColumn(name = "id_estado")
//    private Estado estado;
	
//	//@JsonBackReference
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_municipio")
//	private List<Localidad> localidades;

	private static final long serialVersionUID = 5751034090514511523L;

}
