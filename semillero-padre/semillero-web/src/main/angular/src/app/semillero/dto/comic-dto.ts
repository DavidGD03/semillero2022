
export class ComicDTO {

  /**
   * Atributo que determina el id del comic
   */
  public id: number;

  /**
   * Atributo que determina el id del comic
   */
  public nombre: string;
  /**
   * Atributo que determina el id del comic
   */
  public editorial: string;
  /**
   * Atributo que determina el id del comic
   */
  public tematicaEnum: string;
  /**
   * Atributo que determina el id del comic
   */
  public coleccion: string;

  public numeroPaginas: number;

  public precio: number;

  public autores: string;

  public color: boolean;

  public cantidad: number;

  public fechaVenta: Date;

  public estadoEnum : string;
  constructor() {
  }
}
