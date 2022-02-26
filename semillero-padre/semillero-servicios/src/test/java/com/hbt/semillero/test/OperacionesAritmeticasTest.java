/**
 * OperacionesAritmeticasTest.java
 */
package com.hbt.semillero.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * 
 * <b>Descripción:<b> Clase que determina los diversos test para la operación aritmética "suma"
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class OperacionesAritmeticasTest {

	/**
	 * Constante que contiene la informacion de los logs a manejar en la clase OperacionesAritmeticasTest
	 */
	private final static Logger LOG = Logger.getLogger(OperacionesAritmeticasTest.class);
	
	
	/**
	 * 
	 * Metodo encargado de calcular la suma de dos números
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param numero1
	 * @param numero2
	 * @param resultado
	 * @return resultado de la suma
	 * @throws Exception
	 */
	private int calcularSuma(int numero1, int numero2, int resultado) throws Exception {
		if( (numero1 + numero2) == resultado ) {
			return resultado;
		} else {
			LOG.info("Se ha generado un error funcional probando el test validarResultadoSumaFallido()");
			throw new Exception("La suma ha fallado en el calculo");
		}
	}
	
	/**
	 * 
	 * Metodo encargado de inicializar las pruebas unitarias
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 *
	 */
	@BeforeTest
	public void inicializar() {
		// Inicializa el looger con una configuracion por default o basica
		BasicConfigurator.configure();
		LOG.info("::::::::::::: INICIAN PRUEBAS UNITARIAS :::::::::::::");
	}
	
//	@Test
//	public void validarResultadoSumaSuccess() {
//		LOG.info("Inicia ejecucion del test validarResultadoSumaSuccess()");
//		
//		int resultado = 450;
//		Assert.assertEquals(resultado, this.calcularSuma(300, 150));
//		
//		LOG.info("Finaliza la ejecucion del test validarResultadoSumaSuccess()");
//	}
	
	/**
	 * 
	 * Metodo encargado de validar los resultados de la operación suma
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 *
	 */
	@Test(enabled = false)
	public void validarResultadoSumaEscenarioDosSuccess() {
		LOG.info("Inicia ejecucion del test validarResultadoSumaEscenarioDosSuccess()");
		
		int resultado = 400;
		try {
			this.calcularSuma(300, 150, resultado);
		} catch (Exception e) {
			LOG.error("El error esperado es: " + e.getMessage());
			Assert.assertEquals(e.getMessage(), "La suma ha fallado en el calculo");
		}
		
		
		LOG.info("Finaliza la ejecucion del test validarResultadoSumaEscenarioDosSuccess()");
	}
	
//	@Test
//	public void validarResultadoSumaEscenarioFallido() {
//		LOG.info("Inicia ejecucion del test validarResultadoSumaEscenarioFallido()");
//		
//		int resultado = 400;
//		Assert.assertNotEquals(resultado, this.calcularSuma(300, 150));
//		
//		LOG.info("Finaliza la ejecucion del test validarResultadoSumaEscenarioFallido()");
//	}
	
	/**
	 * 
	 * Metodo encargado de finalizar las pruebas unitarias
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 *
	 */
	@AfterTest
	public void finalizar() {
		LOG.info("::::::::::::: FINALIZAN LAS PRUEBAS UNITARIAS :::::::::::::");
	}
}
