package com.lubricadora.yornel.lubrica.Model;

import com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Cliente entity. @author MyEclipse Persistence Tools
 */
public class Cliente implements java.io.Serializable {

	// Fields

	private Long id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private Timestamp creado;
	private Timestamp editado;
	@SuppressWarnings("rawtypes")
	private Set carros = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set ingresoClientes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cliente() {
	}

	/** minimal constructor */
	public Cliente(String cedula, String nombre, String apellido,
			String direccion, String telefono, Timestamp creado,
			Timestamp editado) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.creado = creado;
		this.editado = editado;
	}

	/** full constructor */
	@SuppressWarnings("rawtypes")
	public Cliente(String cedula, String nombre, String apellido,
			String direccion, String telefono, Timestamp creado,
			Timestamp editado, Set carros, Set ingresoClientes) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.creado = creado;
		this.editado = editado;
		this.carros = carros;
		this.ingresoClientes = ingresoClientes;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Timestamp getEditado() {
		return this.editado;
	}

	public void setEditado(Timestamp editado) {
		this.editado = editado;
	}

	@SuppressWarnings("rawtypes")
	public Set getCarros() {
		return this.carros;
	}

	@SuppressWarnings("rawtypes")
	public void setCarros(Set carros) {
		this.carros = carros;
	}

	@SuppressWarnings("rawtypes")
	public Set getIngresoClientes() {
		return this.ingresoClientes;
	}

	@SuppressWarnings("rawtypes")
	public void setIngresoClientes(Set ingresoClientes) {
		this.ingresoClientes = ingresoClientes;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}