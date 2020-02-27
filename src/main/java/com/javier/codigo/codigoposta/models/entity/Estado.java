package com.javier.codigo.codigoposta.models.entity;

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
@Table(name = "estados")
public class Estado implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Long idEstado;
	
	@Column(name = "nombre_estado")
	private String nombreEstado;
	
	@Column(name = "ciudad")
	private String ciudad;
	
    @OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_pais")
    private Pais pais;
	
	
//	@JsonManagedReference
//    @ManyToOne( cascade=CascadeType.ALL)
//	@JoinColumn(name = "id_pais")
//    private Pais pais;
	
	//@JsonBackReference
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_estado")
//	private List<Municipio> municipios;

	private static final long serialVersionUID = 436393308485710703L;


}
