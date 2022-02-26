/**
 * Barco.java
 */
package com.hbt.semillero.dto;

import java.math.BigDecimal;

import com.hbt.semillero.abstracts.AccionesVehiculoAbstract;
import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:<b> Clase que determina los métodos del vehículo barco
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class Barco implements AccionesVehiculoInterface {

	private int numeroVelas;
	private String nombreCapitan;
	private String puertoLlegada;
	
	public Barco() {
		//super(new BigDecimal(500));
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo numeroVelas
	 * @return El numeroVelas asociado a la clase
	 */
	public int getNumeroVelas() {
		return numeroVelas;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numeroVelas
	 * @param numeroVelas El nuevo numeroVelas a modificar.
	 */
	public void setNumeroVelas(int numeroVelas) {
		this.numeroVelas = numeroVelas;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombreCapitan
	 * @return El nombreCapitan asociado a la clase
	 */
	public String getNombreCapitan() {
		return nombreCapitan;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombreCapitan
	 * @param nombreCapitan El nuevo nombreCapitan a modificar.
	 */
	public void setNombreCapitan(String nombreCapitan) {
		this.nombreCapitan = nombreCapitan;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo puertoLlegada
	 * @return El puertoLlegada asociado a la clase
	 */
	public String getPuertoLlegada() {
		return puertoLlegada;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo puertoLlegada
	 * @param puertoLlegada El nuevo puertoLlegada a modificar.
	 */
	public void setPuertoLlegada(String puertoLlegada) {
		this.puertoLlegada = puertoLlegada;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Barco [numeroVelas=" + numeroVelas + ", nombreCapitan=" + nombreCapitan + ", puertoLlegada="
				+ puertoLlegada + "]" + super.toString();
	}

	@Override
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long obternerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
