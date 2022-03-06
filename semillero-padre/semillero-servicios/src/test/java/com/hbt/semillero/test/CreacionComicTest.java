/**
 * CreacionComicTest.java
 */
package com.hbt.semillero.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina los diversos test para el filtrado de comics por estado y el mensaje de error generado.
 * <b>Caso de Uso:<b> SEMILLERO2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class CreacionComicTest {
	
	private final static Logger LOG = Logger.getLogger(CreacionComicTest.class);
	
	/**
	 * Array con los 10 comics creados inicialmente
	 */
	ArrayList<ComicDTO> comicsCreados = new ArrayList<>();
	
	/**
	 * 
	 * Metodo encargado de realizar la creación de 10 comics mediante el constructor de su DTO
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @return
	 */
	private ArrayList<ComicDTO> crearComics() {
		ArrayList<ComicDTO> comics = new ArrayList<>();
		comics.add(new ComicDTO(11L, "Wolverine 2", "Marvel Comics", TematicaEnum.FANTASTICO,"Edicion Premium Marvel", 300, new BigDecimal(45000), "Stan Lee", true, LocalDate.of(2022, 1, 25),
				EstadoEnum.ACTIVO, 8)); // Primer cómic
		comics.add(new ComicDTO(12L, "Daredevil", "Panini Comics", TematicaEnum.AVENTURAS,"Marvel Deluxe", 230, new BigDecimal(70000), "Marco Checchetto", true, LocalDate.of(2021, 12, 12),
				EstadoEnum.ACTIVO, 10)); // Segundo cómic
		comics.add(new ComicDTO(13L, "My Hero Academia", "Planeta Comic", TematicaEnum.HUMORISTICO,"Manga Shonen", 185, new BigDecimal(65000), "Kohei Horikoshi", true, LocalDate.of(2021, 10, 21),
				EstadoEnum.ACTIVO, 15)); // Tercer cómic
		comics.add(new ComicDTO(14L, "Star Wars", "Mundo Comic", TematicaEnum.CIENCIA_FICCION,"Star Wars Comics", 170, new BigDecimal(55000), "Jason Aaron", false, LocalDate.of(2022, 1, 12),
				EstadoEnum.ACTIVO, 5)); // Cuarto cómic
		comics.add(new ComicDTO(15L, "your name", "Viva Comic", TematicaEnum.FANTASTICO,"Manga: Biblioteca Makoto Shinkai", 320, new BigDecimal(40000), "Makoto Shinkai", false, LocalDate.of(2021, 11, 15),
				EstadoEnum.ACTIVO, 3)); // Quinto cómic
		comics.add(new ComicDTO(16L, "Dragon Ball Super", "Planeta Comic", TematicaEnum.AVENTURAS,"Manga Shonen", 280, new BigDecimal(80000), "Akira Toriyama", true, LocalDate.of(2021, 9, 21),
				EstadoEnum.ACTIVO, 14)); // Sexto cómic
		comics.add(new ComicDTO(17L, "Uzumaki Integral", "Libertad", TematicaEnum.FANTASTICO,"Manga Seinen", 350, new BigDecimal(75000), "Junji Ito", true, LocalDate.of(2022, 2, 10),
				EstadoEnum.INACTIVO, 13)); // Séptimo cómic
		comics.add(new ComicDTO(18L, "SpaceDrum", "Santillana", TematicaEnum.CIENCIA_FICCION,"Edicion Exclusiva", 221, new BigDecimal(62000), "Eric Cuaresma (Kalathras)", false, LocalDate.of(2021, 12, 05),
				EstadoEnum.INACTIVO, 7)); // Octavo cómic
		comics.add(new ComicDTO(19L, "Los Vengadores", "Marvel Comics", TematicaEnum.FANTASTICO,"Edicion Limitada", 267, new BigDecimal(52500), "Steve McNiven", false, LocalDate.of(2021, 8, 15),
				EstadoEnum.INACTIVO, 5)); // Noveno cómic
		comics.add(new ComicDTO(20L, "Batman", "DC Comics", TematicaEnum.FANTASTICO,"Novelas gráficas", 411, new BigDecimal(38900), "Grant Morrison", true, LocalDate.of(2022, 2, 20),
				EstadoEnum.INACTIVO, 16)); // Décimo cómic
		return comics;
	}
	
	/**
	 * 
	 * Metodo encargado de obtener los comics cuyo estado actual es "activo"
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param comics
	 * @return El array comicsActivos con todos los comics cuyo estado es "activo"
	 */
	private ArrayList<ComicDTO> obtenerComicsActivos(ArrayList<ComicDTO> comics) {
		ArrayList<ComicDTO> comicsActivos = new ArrayList<>();
		
		// Recorremos todos los 10 comics
		for (int i = 0; i < comics.size(); i++) {
			ComicDTO comicActual=comics.get(i);
			// Verificamos si el comic de la iteración actual tiene su estado como activo. De ser así, lo agregamos a un array
			if (comicActual.getEstadoEnum()==EstadoEnum.ACTIVO) {
				comicsActivos.add(comicActual);
			}
		}
		return comicsActivos;
	}
	
	/**
	 * 
	 * Metodo encargado de obtener los comics cuyo estado actual es "inactivo"
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param comics
	 * @return El array comicsInactivos con todos los comics cuyo estado es "inactivo"
	 */
	private ArrayList<ComicDTO> obtenerComicsInactivos(ArrayList<ComicDTO> comics) {
		ArrayList<ComicDTO> comicsInactivos = new ArrayList<>();
		
		// Recorremos todos los 10 comics
		for (int i = 0; i < comics.size(); i++) {
			ComicDTO comicActual=comics.get(i);
			// Verificamos si el comic de la iteración actual tiene su estado como inactivo. De ser así, lo agregamos a un array
			if (comicActual.getEstadoEnum()==EstadoEnum.INACTIVO) {
				comicsInactivos.add(comicActual);
			}
		}
		return comicsInactivos;
	}
	
	/**
	 * 
	 * Metodo encargado de generar una excepción donde se muestra la cantidad de comics totales, activos e inactivos, junto con el nombre de los inactivos.
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param comics
	 * @return
	 * @throws Exception con el mensaje requerido
	 */
	private String generarExcepcion(ArrayList<ComicDTO> comics) throws Exception {
		ArrayList<ComicDTO> comicsActivos = obtenerComicsActivos(comics);
		ArrayList<ComicDTO> comicsInactivos = obtenerComicsInactivos(comics);
		
		int tamanioListaTotal = comics.size();
		int numeroTotalActivos = comicsActivos.size();
		int numeroTotalInactivos = comicsInactivos.size();
		String nombresComicsInactivos = "";
		
		// Recorremos todos los comics inactivos para ir concatenando sus nombres
		for (int i = 0; i < comicsInactivos.size(); i++) {
			ComicDTO comicActual=comicsInactivos.get(i);
			String nombreComicActual = comicActual.getNombre();
			
			// Condicional para poner la letra "y" y un "." en caso de que sea el último comic inactivo.
			if (i==comicsInactivos.size()-1) {
				nombreComicActual = "y " + nombreComicActual + ".";		
					}
			else {
			nombreComicActual += ", "; 
			}
			nombresComicsInactivos += nombreComicActual;
		}
		
		String mensaje = "Se ha detectado que de " + tamanioListaTotal + " comics se encontraron que " + numeroTotalActivos + " se encuentran activos y " + numeroTotalInactivos + " inactivos. Los comics inactivos son "
				+ nombresComicsInactivos;
		throw new Exception(mensaje);
	}
	
	/**
	 * 
	 * Metodo encargado de inicializar el logger y crear 10 comics
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 *
	 */
	@BeforeTest
	public void inicializar() {
		// Inicializa el logger con una configuracion por default o basica
		BasicConfigurator.configure();
		LOG.info("::::::::::::: INICIAN PRUEBAS UNITARIAS :::::::::::::");
		comicsCreados = crearComics();
		LOG.info("::::::::::::: CREACIÓN EXITOSA DE COMICS :::::::::::::");
	}
	
	/**
	 * 
	 * Metodo encargado de validar la lista de los comics cuyo estado actual es "activo"
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 *
	 */
	@Test
	public void validarListaComicsActivos() {
		LOG.info("Inicia ejecucion del test validarListaComicsActivos()");
		
		try {
			ArrayList<ComicDTO> comicsActivos=this.obtenerComicsActivos(comicsCreados);
			int numeroComic = 1;
			
			System.out.println(":::::::::::::::: LISTA DE COMICS ACTIVOS ::::::::::::::::");
			
			// Recorro toda la lista de comics activos para irlos imprimiendo
			for (int i = 0; i < comicsActivos.size(); i++) {
				ComicDTO comicActual=comicsActivos.get(i);
				System.out.println("::::::::::::: COMIC NUMERO: " + numeroComic + " ::::::::::::: \n");
				//System.out.println("Comic número: "+numeroComic + "\n");
				System.out.println(comicActual.toString() + "\n");
				numeroComic++;
			
			// Creo otro array con únicamente los comics activos para luego comparar mediante un assert
			ArrayList<ComicDTO> comicsActivosReales = new ArrayList<>();
			comicsActivosReales.add(new ComicDTO(11L, "Wolverine 2", "Marvel Comics", TematicaEnum.FANTASTICO,"Edicion Premium Marvel", 300, new BigDecimal(45000), "Stan Lee", true, LocalDate.of(2022, 1, 25),
					EstadoEnum.ACTIVO, 8)); // Primer cómic
			comicsActivosReales.add(new ComicDTO(12L, "Daredevil", "Panini Comics", TematicaEnum.AVENTURAS,"Marvel Deluxe", 230, new BigDecimal(70000), "Marco Checchetto", true, LocalDate.of(2021, 12, 12),
					EstadoEnum.ACTIVO, 10)); // Segundo cómic
			comicsActivosReales.add(new ComicDTO(13L, "My Hero Academia", "Planeta Comic", TematicaEnum.HUMORISTICO,"Manga Shonen", 185, new BigDecimal(65000), "Kohei Horikoshi", true, LocalDate.of(2021, 10, 21),
					EstadoEnum.ACTIVO, 15)); // Tercer cómic
			comicsActivosReales.add(new ComicDTO(14L, "Star Wars", "Mundo Comic", TematicaEnum.CIENCIA_FICCION,"Star Wars Comics", 170, new BigDecimal(55000), "Jason Aaron", false, LocalDate.of(2022, 1, 12),
					EstadoEnum.ACTIVO, 5)); // Cuarto cómic
			comicsActivosReales.add(new ComicDTO(15L, "your name", "Viva Comic", TematicaEnum.FANTASTICO,"Manga: Biblioteca Makoto Shinkai", 320, new BigDecimal(40000), "Makoto Shinkai", false, LocalDate.of(2021, 11, 15),
					EstadoEnum.ACTIVO, 3)); // Quinto cómic
			comicsActivosReales.add(new ComicDTO(16L, "Dragon Ball Super", "Planeta Comic", TematicaEnum.AVENTURAS,"Manga Shonen", 280, new BigDecimal(80000), "Akira Toriyama", true, LocalDate.of(2021, 9, 21),
					EstadoEnum.ACTIVO, 14)); // Sexto cómic
			
			// Comparo la lista que creé anteriormente de comics activos reales con los comics activos generados por el método
			Assert.assertEquals(comicsActivos.toString(), comicsActivosReales.toString());
			}
			
		} catch (Exception e) {
			LOG.error("Ha sucedido un error: " + e.getMessage());
		}
		
		LOG.info("Finaliza la ejecucion del test validarListaComicsActivos()");
	}
	
	/**
	 * 
	 * Metodo encargado de validar el mensaje del error producido por la excepción
	 * <b>Caso de Uso</b> SEMILLERO2022
	 * @author David Felipe Rojas Casadiego
	 *
	 */
	@Test
	public void validarErrorProducido() {
		LOG.info("Inicia ejecucion del test validarErrorProducido()");
		
		try {
			this.generarExcepcion(comicsCreados);
			
		} catch (Exception e) {
			String errorEsperado = "Se ha detectado que de 10 comics se encontraron que 6 se encuentran activos y 4 inactivos. Los comics inactivos son Uzumaki Integral, SpaceDrum, Los Vengadores, y Batman.";
			LOG.error("El error generado es: " + e.getMessage());
			
			// Comparo la excepción obtenida con la que debería obtener.
			Assert.assertEquals(e.getMessage(), errorEsperado);
		}
		
		LOG.info("Finaliza la ejecucion del test validarErrorProducido()");
	}
	
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
