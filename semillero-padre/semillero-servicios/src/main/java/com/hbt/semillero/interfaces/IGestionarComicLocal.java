/**
 * IGestionarComicLocal.java
 */
package com.hbt.semillero.interfaces;

import java.util.ArrayList;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * <b>Descripción:<b> Clase que determina el EJB para gestionar los comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Local
public interface IGestionarComicLocal {
	
	/**
	 * 
	 * Metodo encargado de consultar el nombre y precio de un comic determinado
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param idComic Id del comic a consultar
	 */
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
	/**
	 * 
	 * Metodo encargado de crear un comic
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param comicDTO DTO del comic a crear
	 * @throws Exception
	 */
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	/**
	 * 
	 * Metodo encargado de consultar comics dependiendo del tamaño de su nombre
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param lengthComic Tamaño del nombre del comic
	 * @throws Exception
	 */
	public ConsultaComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) throws Exception;
	
	public ArrayList<ComicDTO> consultarComics() throws Exception;
}

