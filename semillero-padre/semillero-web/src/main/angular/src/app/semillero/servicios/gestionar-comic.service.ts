import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { ComicDTO } from '../dto/comic-dto';
import { AbstractService } from './template.service';

/**
 * @description Clase servicio que contiene las invocaciones de los REST para gestionar
 * comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 * @see CUPA1099 : Consultar pagos
 * @see Semillero2022
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarComicService extends AbstractService {

  /**
   * Atributo que determina si el resultado es exitoso o no
   */
  private resultado : boolean;

  /**
   * Constructor de la clase GestionarComicService
   * @param injector sirve para injectar el service en el contructor de cualquier componente
   * @param httpClient permite realizar una peticion de tipo GET o POST
   */
  constructor(private injector : Injector, private httpClient : HttpClient) {
    super(injector);
  }

  /**
   * @description Metodo encargado de invocar el servicio de consultar
   * todos los comics
   * @returns lista de comics obtenidos
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarComics() : Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/consultarComics');
  }

  /**
   * @description Metodo encargado de crear un comic
   * @returns ResultadoDTO con la respuesta exito o no
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public crearComic(comicDTO : ComicDTO) : Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/crearComic', comicDTO);
  }

  /**
   * @description Metodo encargado de consultar el tamanio del nombre de un comic
   * @returns Objecto con la lista de los que sobrepasa o no la longitud enviada
   * como parametro para los nombres de cada comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarComicTamanioNombre(longitudNombre : string)  {
    // Clase que permite enviar los parametros al servicio
    let parametros = new HttpParams()
    .set("lengthComic", longitudNombre);
    // let comicDTO = new ComicDTO();
    // parametros.set("lengthComic", JSON.stringify(comicDTO));
    //parametros.set("lengthComic", longitudNombre);
    //return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/consultarComicTamanioNombre?lengthComic=' + longitudNombre);
    return this.httpClient.get<any>('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/consultarComicTamanioNombre', {params : parametros});
    //this.get<any>('semillero-servicios','gestionarComicRest/consultarComicTamanioNombre', { longitudNombre });
  }

  public comprarComic(idComic : string, cantidad : string)  {
    // Clase que permite enviar los parametros al servicio
    let parametros = new HttpParams()
    .set("idComic", idComic)
    .set("cantidad", cantidad);
    return this.httpClient.get<any>('http://localhost:8085/semillero-servicios/rest/gestionarCompraComicRest/comprarComic', {params : parametros});
  }
}
