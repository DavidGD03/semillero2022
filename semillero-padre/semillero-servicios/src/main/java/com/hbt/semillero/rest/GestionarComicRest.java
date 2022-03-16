/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina los diferentes servicios REST para la gestión de comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Path("/gestionarComicRest")
public class GestionarComicRest {
	
	/**
	 * EJB para gestionar los comics
	 */
	@EJB
	private IGestionarComicLocal gestionarComicLocal;  
	
	/**
	 * 
	 * Metodo encargado de consultar el nombre y precio de determinado comic
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param idComic que será consultado
	 * @return nombre y precio del comic especificado
	 */
	@GET
	@Path("/consultarNombrePrecioComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);		
	}
	
	/**
	 * 
	 * Metodo encargado de crear un comic
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param comicDTO DTO del comic que será creado
	 * @return DTO con el resultado de la ejecución para la creación del comic
	 */
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(ComicDTO comicDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarComicLocal.crearComic(comicDTO);	
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;	
	}
	
	/**
	 * 
	 * Metodo encargado de consultar comics con determinado número de caracteres en su nombre
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param lengthComic que es el máximo número de caracteres del nombre del comic
	 * @return DTO con los comics que superan y no superan dicho límite de caracteres, más su resultado de ejecución
	 */
	@GET
	@Path("/consultarComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConsultaComicTamanioNombreDTO consultarComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic) {
		ConsultaComicTamanioNombreDTO consultaComicTamanioNombreDTO = new ConsultaComicTamanioNombreDTO();
		try {
			consultaComicTamanioNombreDTO = this.gestionarComicLocal.consultarComicTamanioNombre(lengthComic);	
		} catch (Exception e) {
			consultaComicTamanioNombreDTO.setExitoso(false);
			consultaComicTamanioNombreDTO.setMensajeEjecucion(e.getMessage());
		}
		return consultaComicTamanioNombreDTO;		
	}
	
	@GET
	@Path("/consultarComics")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ComicDTO> consultarComics() throws Exception {
		return this.gestionarComicLocal.consultarComics();		
	}
			
	
}

