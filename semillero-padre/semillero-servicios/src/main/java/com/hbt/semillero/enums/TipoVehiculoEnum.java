/**
 * TipoVehiculoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina los valores que contendra el tipo de vehiculo
 * <b>Caso de Uso:<b> SEMILLERO 2022 
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public enum TipoVehiculoEnum {

	TERRESTRE("Terrestre", 1),
	ACUATICO("Acuatico", 2),
	AEREO("Aereo", 3),
	ESPACIAL("Espacial", 4);

	private String tipo;
	private int identificador;
	
	TipoVehiculoEnum(String tipo, int identificador) {
		this.tipo = tipo;
		this.identificador = identificador;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo tipo
	 * @return El tipo asociado a la clase
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo identificador
	 * @return El identificador asociado a la clase
	 */
	public int getIdentificador() {
		return identificador;
	}
}