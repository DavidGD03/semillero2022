/**
 * SemilleroJPQLRest.java
 */
package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina diversos ejemplos con JPQL para hacer consultas en la BD
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SemilleroJPQLRest {

	/**
	 * Constante que contendra el log de la clase SemilleroJPQLRest
	 */
	private final static Logger LOG = Logger.getLogger(SemilleroJPQLRest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Comic> generarOperacionComic() {
		Comic comic = null;
		List<Comic> listAllComics = null;
		try {
			// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
			// SELECT * FROM COMIC WHERE ID = 6;
			comic = em.find(Comic.class, 6L);
			LOG.info("DATA COMIC" + comic.toString());
			
			//Consults en JPQL para obtener un comic con el id 6 pero quemado o hardcodeado haciendo uso del metodo getSingleResult
			String consulta = "SELECT cm FROM Comic cm WHERE cm.id = 6 ";
			Query queryUnComic = em.createQuery(consulta);
			comic = (Comic) queryUnComic.getSingleResult();
			
			//Consulta en JPQL para obtener un comic con el id 6 tematicaenum y color haciendo uso del metodo getSingleResult y setParameter
			String consultaDos = "SELECT cm FROM Comic cm WHERE cm.id = :idComic "
					+ " AND cm.tematicaEnum = :tematicaEnum AND cm.color = :colorComic ";
			Query queryUnComicDos = em.createQuery(consultaDos);
			queryUnComicDos.setParameter("idComic", comic.getId());
			queryUnComicDos.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryUnComicDos.setParameter("colorComic", Boolean.TRUE);
			comic = (Comic) queryUnComicDos.getSingleResult();
			
			// Query que genera una exception de tipo NoResultException debido a que la consulta no retorna nada
//			String consultaTres = "SELECT cm FROM Comic cm WHERE cm.id = :idComic "
//					+ " AND cm.tematicaEnum = :tematicaEnum AND cm.color = :colorComic ";
//			Query queryUnComicTres = em.createQuery(consultaTres);
//			queryUnComicTres.setParameter("idComic", comic.getId());
//			queryUnComicTres.setParameter("tematicaEnum", TematicaEnum.HUMORISTICO);
//			queryUnComicTres.setParameter("colorComic", Boolean.TRUE);
//			comic = (Comic) queryUnComicTres.getSingleResult();
			
			// Query que genera una exception de tipo NonUniqueResultException debido a que la consulta retorna mas de 1 registro
			String consultaListaComics = "SELECT cm FROM Comic cm WHERE cm.tematicaEnum = :tematicaEnum"
					+ " AND cm.color = :colorComic ";
			Query queryListComics = em.createQuery(consultaListaComics);
			queryListComics.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryListComics.setParameter("colorComic", Boolean.TRUE);
			List<Comic> listComics = queryListComics.getResultList();
			
			for (Comic comicList : listComics) {
				LOG.info("DATA COMIC" + comicList.toString());
			}
			
			// Query que genera una exception de tipo NonUniqueResultException debido a que la consulta retorna mas de 1 registro
//			String consultaCuatro = "SELECT cm FROM Comic cm WHERE cm.tematicaEnum = :tematicaEnum "
//					+ " AND cm.color = :colorComic ";
//			Query queryUnComicCuatro = em.createQuery(consultaCuatro);
//			queryUnComicCuatro.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
//			queryUnComicCuatro.setParameter("colorComic", Boolean.TRUE);
//			comic = (Comic) queryUnComicCuatro.getSingleResult();
			
//			Comic comicSuperman = new Comic();
//			comicSuperman.setNombre("Batman");
//			comicSuperman.setEditorial("DC");
//			comicSuperman.setColeccion("DC");
//			comicSuperman.setNumeroPaginas(100);
//			comicSuperman.setPrecio(new BigDecimal(300));
//			comicSuperman.setCantidad(10L);
//			comicSuperman.setEstadoEnum(EstadoEnum.ACTIVO);
//			
//			//Se crea un nuevo comic
//			em.persist(comicSuperman);
//			
//			comic = em.find(Comic.class, 8L);
//			comic.setTematicaEnum(TematicaEnum.CIENCIA_FICCION);
//			comic.setColor(Boolean.FALSE);
//			comic.setAutores("DIEGO");
//			
//			//Se Actualiza el comic con id 8
//			em.merge(comic);
//			
//			//Se elimina el comic con id 7			
//			comic = em.find(Comic.class, 7L);
//			em.remove(comic);
			
			// Se actualiza el registro 9 mediante JPQL
			String actualizarComic = "UPDATE Comic c SET c.estadoEnum = :estadoEnum "
								   + " WHERE c.id = :idComic ";
			Query queryActualizarComic = em.createQuery(actualizarComic);
			queryActualizarComic.setParameter("estadoEnum", EstadoEnum.INACTIVO);
			queryActualizarComic.setParameter("idComic", 9L);
			queryActualizarComic.executeUpdate();
			
			// Se eliminan los registros mediante JPQL
			String eliminarComics = "DELETE FROM Comic  "
					   + " WHERE id IN ( :idsComics ) ";
			Query queryEliminarComics = em.createQuery(eliminarComics);
			queryEliminarComics.setParameter("idsComics", Arrays.asList(4L,5L));
			queryEliminarComics.executeUpdate();
			
			// Consulta algunos campos de la entidad y retorna una lista de objetos
			String consultaCampos = "SELECT c.nombre, c.estadoEnum, c.precio FROM Comic c "
								  + " WHERE c.id = :idComic ";
			Query queryCampos = em.createQuery(consultaCampos);
			queryCampos.setParameter("idComic", 9L);
			// Lo casteamos como un array de objetos
			Object[] data = (Object[]) queryCampos.getSingleResult();
			String nombre = (String) data[0];
			EstadoEnum estadoEnum = (EstadoEnum) data[1];
			BigDecimal precio = (BigDecimal) data[2];
			
			LOG.info("OBJETOS CONSULTA COMIC " + nombre + " " + estadoEnum.name() + " " + precio);
			
			// Consulta unos campos de la entidad usando el contructor de comicDTO y retorna una lista de comicsDTO
			String consultaCamposContructor = "SELECT new com.hbt.semillero.dto.ComicDTO( c.nombre, c.estadoEnum, c.precio ) "
					  + " FROM Comic c "
					  + " WHERE c.id = :idComic ";
			Query queryCamposConstructor = em.createQuery(consultaCamposContructor);
			queryCamposConstructor.setParameter("idComic", 9L);
			ComicDTO comicDTO = (ComicDTO) queryCamposConstructor.getSingleResult();

			LOG.info("COMICDTO CONSULTA " + comicDTO.getNombre() + " " + comicDTO.getEstadoEnum() + " " + comicDTO.getPrecio());
			
			String consultaAllComics = "SELECT cm FROM Comic cm";
			Query queryAllComics = em.createQuery(consultaAllComics);
			listAllComics = queryAllComics.getResultList();
			
			// Consulta estructurada como nativa del motor las conocidas nativeQuery
			String consultaNative = "SELECT new com.hbt.semillero.dto.ComicDTO( SCNOMBRE, SCESTADO, SCPRECIO ) "
					  + " FROM COMIC c "
					  + " WHERE c.SCID = :idComic ";
			Query queryNativo = em.createNativeQuery(consultaNative);
			queryNativo.setParameter("idComic", 9L);
			ComicDTO comicDTONative = (ComicDTO) queryNativo.getSingleResult();
			
			//Paginacion por base datos, para manejar tablas con un gran volumen de datos
			String consultaPaginada = "SELECT new com.hbt.semillero.dto.ComicDTO( c.nombre, c.estadoEnum, c.precio ) "
					  + " FROM Comic c "
					  + " WHERE c.id = :idComic "
					  + " ORDER BY c.nombre ASC ";
			Query queryPaginado = em.createQuery(consultaPaginada);
			queryPaginado.setParameter("idComic", 9L);
			queryPaginado.setFirstResult(11);
			queryPaginado.setMaxResults(15);
			
			//ComicDTO comicDTO = (ComicDTO) queryPaginado.getSingleResult();
			
		} catch(NonUniqueResultException | NoResultException nure) {
			LOG.error("SE HA PRESENTADO UN ERROR AL CONSULTAR LOS REGISTROS: " + nure.getMessage());
		} catch (Exception e) {
			LOG.error("SE HA PRESENTADO UN ERROR TECNICO" + e.getMessage());
		}
		
		return listAllComics;
	}
	
	
	
	
	
	
}
