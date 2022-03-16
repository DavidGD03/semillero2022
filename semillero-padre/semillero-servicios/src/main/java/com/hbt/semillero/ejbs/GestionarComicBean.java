/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejbs;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaComicNombreDTO;
import com.hbt.semillero.dto.ConsultaComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina el Bean para gestionar los comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * Constante que contiene la informacion de los logs a manejar en la clase GestionarComicBean
	 */
	private final static Logger LOG = Logger.getLogger(GestionarComicBean.class);

	/**
	 * Variable estática para presentar un mensaje de error
	 */
	private final static String MESSAGE_ERROR = "SE HA PRESENTADO EL SIGUIENTE ERROR: ";

	/**
	 * EntityManager para ejecutar querys en la BD
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		LOG.info("Inicia ejecucion de consultarNombrePrecioComic()");

		ConsultaNombrePrecioComicDTO consultaNombrePrecio = new ConsultaNombrePrecioComicDTO();
		String consultarNombrePrecio = "SELECT c.nombre, c.precio FROM Comic c WHERE c.id = :idComic";
		
		try {
			
			Query queryNombrePrecio	= em.createQuery(consultarNombrePrecio);
			queryNombrePrecio.setParameter("idComic", idComic);	
			Object[] data = (Object[]) queryNombrePrecio.getSingleResult();
			consultaNombrePrecio.setNombre((String)data[0]);
			consultaNombrePrecio.setPrecio((BigDecimal)data[1]);
			consultaNombrePrecio.setExitoso(true);
			consultaNombrePrecio.setMensajeEjecucion("La consulta se ejecuto exitosamente");
			
		} catch (NonUniqueResultException nure) {
			LOG.error(MESSAGE_ERROR + nure.getMessage());
			consultaNombrePrecio.setExitoso(false);
			consultaNombrePrecio.setMensajeEjecucion("La consulta arrojo mas de un registro");
		} catch (NoResultException nre) {
			LOG.error(MESSAGE_ERROR + nre.getMessage());
			consultaNombrePrecio.setExitoso(false);
			consultaNombrePrecio.setMensajeEjecucion("La consulta no arrojo resultados");
		} catch (Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			consultaNombrePrecio.setExitoso(false);
			consultaNombrePrecio.setMensajeEjecucion("Se ha presentado un error tecnico");
		}

		//		List<ConsultaNombrePrecioComicDTO> listaResult = queryNombrePrecio.getResultList();
		//		if(!listaResult.isEmpty()) {
		//			String nombre = listaResult.get(0).getNombre();
		//			BigDecimal precio = listaResult.get(0).getPrecio();
		//			consultaNombrePrecio = new ConsultaNombrePrecioComicDTO(nombre,precio, true, "Se ha consultado exitosamente");			
		//		} else {
		//			consultaNombrePrecio = new ConsultaNombrePrecioComicDTO(null,null, false, "La consulta no arrojo resultados");
		//		}
		LOG.info("Finaliza ejecucion de consultarNombrePrecioComic()");
		return consultaNombrePrecio;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		resultadoDTO.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return resultadoDTO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) throws Exception {
		LOG.info("Inicia ejecucion de consultarComicTamanioNombre()");
		
		/**
		 * Máxima longitud permitida de caracteres en el parametro lengthComic
		 */
		Short maxComicLength = 12;
		
		/**
		 * DTO con la lista de los nombres de comics que superen o no cierto numero
		 * de caracteres más el resultado de ejecución
		 */
		ConsultaComicTamanioNombreDTO consultaNombre = new ConsultaComicTamanioNombreDTO();
		
		// Condicional para verificar que cumpla con la máxima longitud permitida de caracteres
		if(lengthComic > maxComicLength) {
			throw new Exception("La longitud máxima permitida es de 12 caracteres");
		}
		
		// Consulta usando los campos del constructor del DTO
		String consultaCamposContructor = "SELECT new com.hbt.semillero.dto.ConsultaComicNombreDTO( c.nombre ) "
				  + " FROM Comic c ";
		
		try {
			// Lista con todos los nombres de los comics que están en la BD
			ArrayList<ConsultaComicNombreDTO> listaNombresComicsFull = new ArrayList<>();
			Query queryNombre	= em.createQuery(consultaCamposContructor);
			listaNombresComicsFull = (ArrayList<ConsultaComicNombreDTO>) queryNombre.getResultList();
			
			ArrayList<ConsultaComicNombreDTO> listaComicsSuperanTamanio = this.obtenerComicsSuperanTamanio(listaNombresComicsFull, lengthComic);
			ArrayList<ConsultaComicNombreDTO> listaComicsNoSuperanTamanio = this.obtenerComicsNoSuperanTamanio(listaNombresComicsFull, lengthComic);
			
			consultaNombre.setComicsSuperanTamanio(listaComicsSuperanTamanio);
			consultaNombre.setComicsNoSuperanTamanio(listaComicsNoSuperanTamanio);
			consultaNombre.setExitoso(true);
			consultaNombre.setMensajeEjecucion("Comics procesados exitosamente");
			
		} catch (Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			consultaNombre.setExitoso(false);
			consultaNombre.setMensajeEjecucion("Se ha presentado un error tecnico");
		}

		LOG.info("Finaliza ejecucion de consultarComicTamanioNombre()");
		return consultaNombre;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<ComicDTO> consultarComics() {
		LOG.info("Inicia ejecucion de obtenerComics()");

		ArrayList<ComicDTO> listaComics = new ArrayList<>();
		String consultarComics = "SELECT c FROM Comic c";
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		
		try {
			
			Query queryComics	= em.createQuery(consultarComics);
			listaComics = (ArrayList<ComicDTO>) queryComics.getResultList();
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("La consulta se ejecuto exitosamente");
			
		} catch (Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("Se ha presentado un error tecnico");
		}
		return listaComics;
	}
	
	
	/**
	 * 
	 * Metodo encargado de obtener una lista con los comics que sí superan cierto numero de caracteres en su nombre
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param listaNombresComicsFull que contiene una lista con todos los nombres de los comics existentes en la BD
	 * @param lengthComic que es el numero de caracteres que sí se deben superar
	 * @return lista con los comics que no superan el tamaño de lengthComic
	 */
	private ArrayList<ConsultaComicNombreDTO> obtenerComicsSuperanTamanio(ArrayList<ConsultaComicNombreDTO> listaNombresComicsFull, Short lengthComic) {
		ArrayList<ConsultaComicNombreDTO> listaComicsSuperanTamanio = new ArrayList<>();
		for (ConsultaComicNombreDTO consultaComicNombreDTO : listaNombresComicsFull) {
			if(consultaComicNombreDTO.getNombre().length()>lengthComic) {
				listaComicsSuperanTamanio.add(consultaComicNombreDTO);
			}
		}
		return listaComicsSuperanTamanio;
	}
	
	/**
	 * 
	 * Metodo encargado de obtener una lista con los comics que no superan cierto numero de caracteres en su nombre
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param listaNombresComicsFull que contiene una lista con todos los nombres de los comics existentes en la BD
	 * @param lengthComic que es el numero de caracteres que no se deben superar
	 * @return lista con los comics que no superan el tamaño de lengthComic
	 */
	private ArrayList<ConsultaComicNombreDTO> obtenerComicsNoSuperanTamanio(ArrayList<ConsultaComicNombreDTO> listaNombresComicsFull, Short lengthComic) {
		ArrayList<ConsultaComicNombreDTO> listaComicsNoSuperanTamanio = new ArrayList<>();
		for (ConsultaComicNombreDTO consultaComicNombreDTO : listaNombresComicsFull) {
			if(consultaComicNombreDTO.getNombre().length()<=lengthComic) {
				listaComicsNoSuperanTamanio.add(consultaComicNombreDTO);
			}
		}
		return listaComicsNoSuperanTamanio;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir los DTO's de Comic en su entidad Comic
	 * <b>Caso de Uso</b> SEMILLERO 2022
	 * @author David Felipe Rojas Casadiego
	 * 
	 * @param comicDTO que será transformado a comic
	 * @return comic transformado desde el DTO
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}
}
