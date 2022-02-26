/**
 * TipoVehiculoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina los valores que contendra el estado para la tabla comic
 * <b>Caso de Uso:<b> SEMILLERO 2022 
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public enum EstadoEnum {

	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.tematica.inactivo"),
	
	;
	
	
	private String descripcion;
	
	EstadoEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo descripcion
	 * @return El descripcion asociado a la clase
	 */
	public String getDescripcion() {
		return descripcion;
	}
}