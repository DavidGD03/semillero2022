package com.hbt.semillero.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * <b>Descripción:<b> Clase que determina el DTO para obtener los comics que superan o no cierto
 * numero de caracteres en su nombre, junto con el resultado de su ejecución
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author David Felipe Rojas Casadiego
 * @version 1.0
 */
public class ConsultaComicTamanioNombreDTO extends ResultadoDTO implements Serializable {

	/**
	 * Atributo que determina el serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista con los comics que no superan cierto tamaño en su nombre
	 */
	private ArrayList<ConsultaComicNombreDTO> comicsNoSuperanTamanio = new ArrayList<>();
	
	/**
	 * Lista con los comics que sí superan cierto tamaño en su nombre
	 */
	private ArrayList<ConsultaComicNombreDTO> comicsSuperanTamanio = new ArrayList<>();
	
	public ConsultaComicTamanioNombreDTO() {
		//Constructor vacio
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param comicsNoSuperanTamanio Lista con los comics que no superan cierto tamaño en su nombre
	 * @param comicsSuperanTamanio Lista con los comics que sí superan cierto tamaño en su nombre
	 * @param exitoso Atributo que determina si el request fue exitoso o no
	 * @param mensaje Atributo que determina el response si fue exitoso o no
	 */
	public ConsultaComicTamanioNombreDTO(ArrayList<ConsultaComicNombreDTO> comicsNoSuperanTamanio, ArrayList<ConsultaComicNombreDTO> comicsSuperanTamanio, boolean exitoso, String mensaje) {
		super(exitoso, mensaje);
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
		this.comicsSuperanTamanio = comicsSuperanTamanio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo comicsNoSuperanTamanio
	 * @return El comicsNoSuperanTamanio asociado a la clase
	 */
	public ArrayList<ConsultaComicNombreDTO> getComicsNoSuperanTamanio() {
		return comicsNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comicsNoSuperanTamanio
	 * @param comicsNoSuperanTamanio El nuevo comicsNoSuperanTamanio a modificar.
	 */
	public void setComicsNoSuperanTamanio(ArrayList<ConsultaComicNombreDTO> comicsNoSuperanTamanio) {
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo comicsSuperanTamanio
	 * @return El comicsSuperanTamanio asociado a la clase
	 */
	public ArrayList<ConsultaComicNombreDTO> getComicsSuperanTamanio() {
		return comicsSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comicsSuperanTamanio
	 * @param comicsSuperanTamanio El nuevo comicsSuperanTamanio a modificar.
	 */
	public void setComicsSuperanTamanio(ArrayList<ConsultaComicNombreDTO> comicsSuperanTamanio) {
		this.comicsSuperanTamanio = comicsSuperanTamanio;
	}
	
	
}
