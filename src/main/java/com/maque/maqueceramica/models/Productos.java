package com.maque.maqueceramica.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String sku;
	private String nombre;
	private String descripcion;
	private double precio;
	private String uRL_Imagen;
	private String cantidad;

	@OneToMany(mappedBy = "productos")
	private List<Carrito> carritos;

	@ManyToOne
	@JoinColumn(name = "categorias_id")
	private Categorias categorias;

	public Productos(Long id, String sku, String nombre, String descripcion, double precio, String uRL_Imagen,
			String cantidad, List<Carrito> carritos, Categorias categorias) {
		super();
		this.id = id;
		this.sku = sku;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.uRL_Imagen = uRL_Imagen;
		this.cantidad = cantidad;
		this.carritos = carritos;
		this.categorias = categorias;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Productos() {

	}

	public Productos(Long id, String sku, String nombre, String descripcion, double precio, String uRL_Imagen) {
		this.id = id;
		this.sku = sku;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.uRL_Imagen = uRL_Imagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getuRL_Imagen() {
		return uRL_Imagen;
	}

	public void setuRL_Imagen(String uRL_Imagen) {
		this.uRL_Imagen = uRL_Imagen;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", sku=" + sku + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", uRL_Imagen=" + uRL_Imagen + ", carritos=" + carritos + ", categorias="
				+ categorias + "]";
	}

}
