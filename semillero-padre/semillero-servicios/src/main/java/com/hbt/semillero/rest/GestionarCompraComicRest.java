/**
 * GestionarCompraComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

/**
 * <b>Descripción:<b> Clase que determina los diferentes servicios REST para la compra de comics
 * <b>Caso de Uso:<b> SEMILLERO 2022 
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Path("/gestionarCompraComicRest")
public class GestionarCompraComicRest {
	
	/**
	 * EJB para gestionar los comics
	 */
	@EJB
	private IGestionarCompraComic gestionarCompraComic;
	
	/**
	 * 
	 * Metodo encargado de realizar la compra de un comic
	 * <b>Caso de Uso</b> SEMILLERO 2022 
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param idComic ID del comic que será comprado
	 * @param cantidad Cantidad de comics a comprar
	 * @return Resultado de la ejecución
	 */
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO comprarComic(@QueryParam("idComic") Long idComic, @QueryParam("cantidad") Integer cantidad) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarCompraComic.comprarComic(idComic, cantidad);	
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;	
	}

}
