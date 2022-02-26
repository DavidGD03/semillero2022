package com.hbt.semillero.interfaces;


import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina las interfaces de los vehiculos
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public interface AccionesVehiculoInterface {
	
	public int obtenerVelocidadMaxima();
	
	public Long obternerPesoMaximoCarga();
	
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception;
	
	public default void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}
}