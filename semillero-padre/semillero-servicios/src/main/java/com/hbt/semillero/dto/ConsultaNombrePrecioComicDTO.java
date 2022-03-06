package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * <b>Descripción:<b> Clase que determina el DTO para obtener el nombre y precio de los comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	/**
	 * Atributo que determina el serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Nombre del comic
	 */
	private String nombre;
	
	/**
	 * Precio del comic
	 */
	private BigDecimal precio;	

	public ConsultaNombrePrecioComicDTO() {
		//Constructor vacio
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param nombre Atributo del nombre del comic
	 * @param precio Atributo del precio del comic
	 * @param exitoso Atributo heredado del resultado de la ejecucion
	 * @param mensaje Atributo heredado del mensaje de la ejecucion
	 */
	public ConsultaNombrePrecioComicDTO(String nombre, BigDecimal precio, boolean exitoso, String mensaje) {
		super(exitoso, mensaje);
		this.nombre = nombre;
		this.precio = precio;
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

}
