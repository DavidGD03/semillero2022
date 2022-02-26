/**
 * Avion.java
 */
package com.hbt.semillero.dto;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:<b> Clase que determina los metodos del vehiculo avión
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class Avion extends Vehiculo implements AccionesVehiculoInterface {

	@Override
	public int obtenerVelocidadMaxima() {
		return 1000;
	}

	@Override
	public Long obternerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return 3000L;
	}
	
	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception {
		if(TipoVehiculoEnum.AEREO.getIdentificador() == (tipoVehiculoEmun.getIdentificador())) {
			System.out.println("El vehiculo si es del mismo tipo");
			return true;
		} else {
			throw new Exception("El tipo de vehiculo asignado es erroneo, debe ser Aereo");
		}
	}

}









