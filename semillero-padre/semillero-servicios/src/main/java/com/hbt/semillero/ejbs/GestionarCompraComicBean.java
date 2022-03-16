/**
 * GestionarCompraComicBean.java
 */
package com.hbt.semillero.ejbs;

import java.time.LocalDate;

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

import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

/**
 * <b>Descripción:<b> Clase que determina el Bean para comprar los comics
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {
	
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
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO comprarComic(Long idComic, Integer cantidad) throws Exception {
		LOG.info("Inicia ejecucion de comprarComic()");
		
		CompraComicDTO compraComicDTO = new CompraComicDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		String consultaCampos = "SELECT c.nombre, c.estadoEnum, c.cantidad FROM Comic c WHERE c.id = :idComic";
		try {
			
			Query queryCompraComic	= em.createQuery(consultaCampos);
			queryCompraComic.setParameter("idComic", idComic);	
			Object[] data = (Object[]) queryCompraComic.getSingleResult();
			
			compraComicDTO.setNombre((String)data[0]);
			compraComicDTO.setEstadoEnum((EstadoEnum)data[1]);
			compraComicDTO.setCantidad((Integer)data[2]);
			
			Integer cantidadActualComic = compraComicDTO.getCantidad();
			if(compraComicDTO.getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
				resultadoDTO.setExitoso(false);
				String mensajeInactivo = "El comic seleccionado no cuenta con stock en bodega";
				resultadoDTO.setMensajeEjecucion(mensajeInactivo);
				throw new Exception(mensajeInactivo);
			}
			
			if(cantidad > compraComicDTO.getCantidad()) {
				resultadoDTO.setExitoso(false);
				String mensajeCantidad = "La cantidad existente del comic es: " + cantidadActualComic + ", y supera la ingresada";
				resultadoDTO.setMensajeEjecucion(mensajeCantidad);
				throw new Exception(mensajeCantidad);
			}
			
			Integer nuevaCantidad = cantidadActualComic - cantidad;
			compraComicDTO.setCantidad(nuevaCantidad);
			
			if(cantidad == compraComicDTO.getCantidad()) {
				compraComicDTO.setEstadoEnum(EstadoEnum.INACTIVO);
			}
			
			compraComicDTO.setFechaVenta(LocalDate.now());
			
			String updateCampos = "UPDATE Comic c SET c.estadoEnum = :estadoEnum, c.cantidad = :cantidad, c.fechaVenta = :fechaVenta WHERE c.id = :idComic";
			Query queryUpdateCompraComic = em.createQuery(updateCampos);
			queryUpdateCompraComic.setParameter("idComic", idComic);
			queryUpdateCompraComic.setParameter("estadoEnum", compraComicDTO.getEstadoEnum());	
			queryUpdateCompraComic.setParameter("cantidad", compraComicDTO.getCantidad());	
			queryUpdateCompraComic.setParameter("fechaVenta", compraComicDTO.getFechaVenta());	
			queryUpdateCompraComic.executeUpdate();
			
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("La compra del comic " + compraComicDTO.getNombre() + " fue exitosa");
			
		} catch (NonUniqueResultException nure) {
			LOG.error(MESSAGE_ERROR + nure.getMessage());
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("La consulta arrojo mas de un registro");
		} catch (NoResultException nre) {
			LOG.error(MESSAGE_ERROR + nre.getMessage());
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("La consulta no arrojo resultados");
		} catch (Exception e) {
			LOG.error(MESSAGE_ERROR + e.getMessage());
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("Se ha presentado un error tecnico");
		}
		LOG.info("Finaliza ejecucion de comprarComic()");
		return resultadoDTO;
	}


}
