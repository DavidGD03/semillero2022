package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * 
 * <b>Descripción:<b> Clase que contendra la respuesta de un servicio o endpoint cuando sea success o error
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class ResultadoDTO implements Serializable {
	
	/**
	 * Atributo que determina el serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que determina si el request fue exitoso o no
	 */
	private boolean exitoso;
	/**
	 * Atributo que determina el mensaje response si fue exitoso o no
	 */
	private String mensajeEjecucion;

	public ResultadoDTO() {
		
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param exitoso Atributo que determina si el request fue exitoso o no
	 * @param mensajeEjecucion Atributo que determina el response si fue exitoso o no
	 */
	public ResultadoDTO(boolean exitoso, String mensajeEjecucion) {
		// Se asigna el valor que venga por default en los parametros del contructor
		this.exitoso = exitoso;
		this.mensajeEjecucion = mensajeEjecucion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo exitoso
	 * @return El exitoso asociado a la clase
	 */
	public boolean isExitoso() {
		return exitoso;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo exitoso
	 * @param exitoso El nuevo exitoso a modificar.
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo mensajeEjecucion
	 * @return El mensajeEjecucion asociado a la clase
	 */
	public String getMensajeEjecucion() {
		return mensajeEjecucion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo mensajeEjecucion
	 * @param mensajeEjecucion El nuevo mensajeEjecucion a modificar.
	 */
	public void setMensajeEjecucion(String mensajeEjecucion) {
		this.mensajeEjecucion = mensajeEjecucion;
	}
}
