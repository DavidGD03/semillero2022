/**
 * Vehiculo.java
 */
package com.hbt.semillero.dto;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * <b>Descripción:<b> Clase que determina la abstraccion de las caracteristicas de un vehiculo
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class Vehiculo {
	
	
	private String modelo;
	private TipoVehiculoEnum tipo;
	private double peso;
	private String color;
	private int capacidad;
	private BigDecimal precio;
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Vehiculo() {
		// Constructor vacio
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param modelo
	 * @param tipo
	 * @param peso
	 * @param color
	 * @param capacidad
	 * @param precio
	 */
	public Vehiculo(String modelo, TipoVehiculoEnum tipo, double peso, String color, int capacidad, 
			BigDecimal precio) {
		this.modelo = modelo;
		this.tipo = tipo;
		this.peso = peso;
		this.color = color;
		this.capacidad = capacidad;
		this.precio = precio;
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param precio
	 */
	public Vehiculo(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo modelo
	 * @return El modelo asociado a la clase
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo modelo
	 * @param modelo El nuevo modelo a modificar.
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo tipo
	 * @return El tipo asociado a la clase
	 */
	public TipoVehiculoEnum getTipo() {
		return tipo;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo tipo
	 * @param tipo El nuevo tipo a modificar.
	 */
	public void setTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo peso
	 * @return El peso asociado a la clase
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo peso
	 * @param peso El nuevo peso a modificar.
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo capacidad
	 * @return El capacidad asociado a la clase
	 */
	public int getCapacidad() {
		return capacidad;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo capacidad
	 * @param capacidad El nuevo capacidad a modificar.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", tipo=" + tipo + ", peso=" + peso + ", color=" + color + ", capacidad="
				+ capacidad + ", precio=" + precio + "]";
	}
}
