/**
 * IGestionarCompraComic.java
 */
package com.hbt.semillero.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dto.ResultadoDTO;

/**
 * <b>Descripción:<b> Clase que determina el EJB para comprar los comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Local
public interface IGestionarCompraComic {
	
	/**
	 * 
	 * Metodo encargado de comprar determinado comic
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param idComic id del comic que será comprado
	 * @param cantidad cantidad de comics que serán comprados
	 * @return resultado de la ejecución
	 * @throws Exception
	 */
	public ResultadoDTO comprarComic(Long idComic, Integer cantidad) throws Exception;

}
