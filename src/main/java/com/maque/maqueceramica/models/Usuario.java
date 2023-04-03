package com.maque.maqueceramica.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	private String telefono;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pedidos> pedidos;

	@OneToMany(mappedBy = "usuario")
	private List<Direccion> direcciones;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
	@JoinColumn(unique = true)
	private Carrito carrito;

	@OneToMany(mappedBy = "usuario")
	private List<Pago> pagos;
	
	@OneToOne(mappedBy = "usuario")
	private Cuenta cuenta;



	public Usuario() {
	}

	public Usuario(Long id, String nombre, String apellido, String correo, String password, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
