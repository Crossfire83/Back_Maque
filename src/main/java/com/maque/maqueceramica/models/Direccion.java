package com.maque.maqueceramica.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direccion_usuario")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String calle_numero;
	private String interior;
	private String colonia;
	private String ciudad;
	private String estado;
	private String cp;
	private String entre_calles;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	
	@OneToOne(mappedBy = "direccion")
    private Pedidos pedido;
	
	public Direccion() {

	}

	public Direccion(Long id, String calle_numero, String interior, String colonia, String ciudad, String estado,
			String cp, String entre_calles) {
		this.id = id;
		this.calle_numero = calle_numero;
		this.interior = interior;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.estado = estado;
		this.cp = cp;
		this.entre_calles = entre_calles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle_numero() {
		return calle_numero;
	}

	public void setCalle_numero(String calle_numero) {
		this.calle_numero = calle_numero;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEntre_calles() {
		return entre_calles;
	}

	public void setEntre_calles(String entre_calles) {
		this.entre_calles = entre_calles;
	}
}
