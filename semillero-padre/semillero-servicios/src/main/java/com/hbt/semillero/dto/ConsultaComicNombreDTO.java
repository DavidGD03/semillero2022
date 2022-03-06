package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * 
 * <b>Descripción:<b> Clase que determina el DTO para consultar los nombres de los comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class ConsultaComicNombreDTO implements Serializable {

	/**
	 * Atributo que determina el serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo que determina el nombre del comic
	 */
	private String nombre;

	public ConsultaComicNombreDTO() {
		//Constructor vacio
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param nombre Atributo que determina el nombre del comic
	 */
	public ConsultaComicNombreDTO(String nombre) {
		this.nombre = nombre;
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
}
