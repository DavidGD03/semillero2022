/**
 * ComicDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.enums.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina la informacion de un comic para transportar
 * la data de este mismo
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class CompraComicDTO implements Serializable {

	/**
	 * Atributo que determina el serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Nombre del comic
	 */
	private String nombre;
	
	/**
	 * Fecha de venta del comic
	 */
	private LocalDate fechaVenta;
	
	/**
	 * Estado de disponibilidad del comic
	 */
	private EstadoEnum estadoEnum;
	
	/**
	 * Cantidad disponible de determinado comic
	 */
	private Integer cantidad;
	
	/**
	 * 
	 * Constructor de la clase por defecto.
	 */
	public CompraComicDTO() {
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param nombre
	 * @param fechaVenta
	 * @param estadoEnum
	 * @param cantidad
	 */
	public CompraComicDTO(String nombre, LocalDate fechaVenta, EstadoEnum estadoEnum, Integer cantidad) {
		this.nombre = nombre;
		this.fechaVenta = fechaVenta;
		this.estadoEnum = estadoEnum;
		this.cantidad = cantidad;
	}

	

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
