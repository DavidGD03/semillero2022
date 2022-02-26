/**
 * TipoVehiculoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina los valores que contendra el tipo de tematica para la tabla comic
 * <b>Caso de Uso:<b> SEMILLERO 2022 
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public enum TematicaEnum {

	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.cienciaFiccion"),
	HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror"),
	
	;
	
	
	private String descripcion;
	
	TematicaEnum(String descripcion) {
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