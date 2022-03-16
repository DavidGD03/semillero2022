import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ComicDTO } from '../../dto/comic-dto';
import { GestionarComicService } from '../../servicios/gestionar-comic.service';

@Component({
  selector: 'app-gestionar-comic',
  templateUrl: './gestionar-comic.component.html',
  styleUrls: ['./gestionar-comic.component.css']
})
export class GestionarComicComponent implements OnInit {

  public gestionarComicForm : FormGroup;

  public comicDTO : ComicDTO;

  public comicDTOInfo : ComicDTO;

  public listaComics : Array<ComicDTO>;

  public mostrarItem : boolean;

  public mostrarData : boolean;

  public formularioValido : boolean;

  public agregoValidacionColeccion : boolean;

  public mensajeEjecucion : string;

  public dataTamanioNombre : any;

  constructor(private formBuilder : FormBuilder, private router : Router,
    private gestionarComicService : GestionarComicService) {

    this.gestionarComicForm = this.formBuilder.group({
      nombre : [null, Validators.required],
      editorial : [null, Validators.required],
      tematicaEnum : [null],
      coleccion : [null],
      numeroPaginas : [null, Validators.required],
      precio : [null, Validators.required],
      autores : [null],
      color : [true],
      cantidad : [3]
    });
  }

  ngOnInit() {
    this.listaComics = new Array<ComicDTO>();
    this.comicDTO = new ComicDTO();
    this.formularioValido = true;
    this.obtenerComics();
  }

  private obtenerComics() : void {
    this.gestionarComicService.consultarComics().subscribe(comics => { // el subscribe sirve para trabajar con procesos asincronos, y esperar la respuesta de Java
      // ponemos dentro del subscribe cualquier código que requiera la respuesta de ese servicio, ya que sino saldra undefined
        if(comics[0].exitoso) {
          this.listaComics = comics;
        } else {
          alert(comics[0].mensajeEjecucion);
        }
    }, error => {
      console.log(error);
    });
  }

  public crearComic() : void {
    if(this.gestionarComicForm.invalid) {
      this.formularioValido = false;
      return;
    }

    this.formularioValido = true;
    this.comicDTO = this.gestionarComicForm.value;// opcion 1 asignar modelo
    this.comicDTO.estadoEnum = 'ACTIVO';

    // opcion 2 asignar modelo
    // this.comicDTO.nombre = this.f.nombre.value;
    // this.comicDTO.editorial = this.f.editorial.value;
    // this.comicDTO.tematicaEnum = this.f.tematicaEnum.value;
    // this.comicDTO.coleccion = this.f.coleccion.value;
    // this.comicDTO.numeroPaginas = this.f.numeroPaginas.value;
    // this.comicDTO.precio = this.f.precio.value;
    // this.comicDTO.autores = this.f.autores.value;
    // this.comicDTO.color = this.f.color.value;
    // this.comicDTO.cantidad = this.f.cantidad.value;


    // this.listaComics.push(this.comicDTO);
    // this.comicDTO = new ComicDTO();
    this.gestionarComicService.crearComic(this.comicDTO).subscribe(respuesta => {
      if(respuesta.exitoso) {
        this.obtenerComics();
      }
      this.mostrarItem = true;
      this.mensajeEjecucion = respuesta.mensajeEjecucion;
      this.limpiarDatosComic();
    }, error => {
      console.log(error);
    });
  }

  private limpiarDatosComic() : void {
    this.gestionarComicForm.reset();//Opcion 1 limpiar
    this.f.color.setValue(true);
    this.f.cantidad.setValue(3);
    //Opcion 2 limpiar
    // this.f.nombre.setValue(null);
    // this.f.editorial.setValue(null);
    // this.f.tematicaEnum.setValue(null);
    // this.f.coleccion.setValue(null);
    // this.f.numeroPaginas.setValue(null);
    // this.f.precio.setValue(null);
    // this.f.autores.setValue(null);
    // this.f.color.setValue(true);
    // this.f.cantidad.setValue(3);
  }

  public cerrar() : void {
    this.mostrarItem = false;
    this.mostrarData = false;
  }

  public imprimirInfoComic(filaSeleccionada : number) {
    this.comicDTOInfo = this.listaComics[filaSeleccionada];
    this.mostrarData = true;
  }

  public agregarValidacionColeccion() : void {
    let tematicasRequeridas = ["AVENTURAS","HORROR"];
    let tematicaSeleccionada = this.f.tematicaEnum.value;

    // this.f.coleccion.clearValidators();
    // this.f.coleccion.updateValueAndValidity();
    // this.agregoValidacionColeccion = false;
    //this.f.coleccion.enable();
    this.gestionarComicForm.enable();
    if(tematicasRequeridas.indexOf(tematicaSeleccionada) >= 0) {
      //this.f.coleccion.disable();
      // this.f.coleccion.setValidators(Validators.required);
      // this.f.coleccion.updateValueAndValidity();
      // this.agregoValidacionColeccion = true;
      this.gestionarComicForm.disable();
      this.f.tematicaEnum.enable();
    }
  }

  public irABienvenida(comicDTO : ComicDTO) : void {
    this.router.navigate(['bienvenida', comicDTO], { skipLocationChange : true } )
  }

  public comprarComic(comicDTO : ComicDTO) : void {
    this.router.navigate(['comprar-comic', comicDTO], { skipLocationChange : true } )
  }

  public consultarComicTamanioNombre() : any {
    let longitudNombre = this.f.coleccion.value;
    this.gestionarComicService.consultarComicTamanioNombre(longitudNombre).subscribe(data => {
      if(data.exitoso) {
        this.dataTamanioNombre = data;
      } else {
        alert(data.mensajeEjecucion);
      }
    }, error => {
      console.log(error);
    });
  }

  get f() {
    return this.gestionarComicForm.controls;
  }
}
