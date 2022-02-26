/**
 * CreacionVehiculoRest.java
 */
package com.hbt.semillero.dto;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * <b>Descripción:<b> Clase que determina el main de crear vehiculos
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class CreacionVehiculoRest {

	/**
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author PC
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Vehiculo moto = new Vehiculo();
		moto.setColor("Negro");
		moto.setModelo("Chapi");
		
		Vehiculo moto2 = new Vehiculo("RXJS", TipoVehiculoEnum.TERRESTRE, 1.5 , "Azul", 2, new BigDecimal(16000000));
		
		Vehiculo moto3 = new Vehiculo(new BigDecimal(11000000));
		
//		System.out.println("Informacion moto 1: Color moto" + moto.getColor() + " Modelo: " + moto.getModelo() );
//		System.out.println("Informacion moto 2: " + moto2.toString());
//		System.out.println("Informacion moto 3: " + moto3.toString());
//		
//		
		Barco barco1 = new Barco();
		//barco1.setColor("Blanco");
		//barco1.setTipo(TipoVehiculoEnum.ACUATICO);
		barco1.acelerar();
		Avion avion1 = new Avion();
		System.out.println("::::: DATA AVION ::::::::");
		System.out.println("obtenerVelocidadMaxima: " + avion1.obtenerVelocidadMaxima());
		System.out.println("obternerPesoMaximoCarga: " + avion1.obternerPesoMaximoCarga());
		try {
			System.out.println("obternerPesoMaximoCarga: " + avion1.determinarTipoVehiculo(TipoVehiculoEnum.ACUATICO));
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		
		Bicicleta bicicleta1 = new Bicicleta();
		System.out.println("::::: DATA BICICLETA ::::::::");
		System.out.println("obtenerVelocidadMaxima: " + bicicleta1.obtenerVelocidadMaxima());
		System.out.println("obternerPesoMaximoCarga: " + bicicleta1.obternerPesoMaximoCarga());
		try {
			System.out.println("obternerPesoMaximoCarga: " + bicicleta1.determinarTipoVehiculo(TipoVehiculoEnum.TERRESTRE));
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
}
