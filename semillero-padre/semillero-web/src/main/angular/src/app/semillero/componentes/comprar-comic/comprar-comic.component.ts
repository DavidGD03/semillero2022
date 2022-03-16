import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GestionarComicService } from '../../servicios/gestionar-comic.service';

@Component({
  selector: 'app-comprar-comic',
  templateUrl: './comprar-comic.component.html',
  styleUrls: ['./comprar-comic.component.css']
})
export class ComprarComicComponent implements OnInit {

  public comprarComicForm : FormGroup;
  public formularioValido : boolean;
  public mensajeEjecucion : string;
  public nombreComic : string;

  constructor(private formBuilder : FormBuilder, private router : Router,
    private gestionarComicService : GestionarComicService, private activatedRoute: ActivatedRoute) {

    this.comprarComicForm = this.formBuilder.group({
      cantidad : [3, Validators.required, Validators.min(0)] // Verificamos que la cantidad sea mayor que cero
    });
    let data = this.activatedRoute.snapshot.params;
    let nombreComic = data[1]
  }

  ngOnInit() {
    this.formularioValido = true;
  }

  /**
   * Metodo para realizar la compra de comics
   */
  private comprarComics() : void {
    let data = this.activatedRoute.snapshot.params;
    let idComic = data[0];
    let cantidad = this.f.cantidad.value;
    this.gestionarComicService.comprarComic(idComic, cantidad).subscribe(comics => { // el subscribe sirve para trabajar con procesos asincronos, y esperar la respuesta de Java
      // ponemos dentro del subscribe cualquier código que requiera la respuesta de ese servicio, ya que sino saldra undefined
        if(comics[0].exitoso) {
          this.mensajeEjecucion = comics[0];
        } else {
          alert(comics[0].mensajeEjecucion);
        }
    }, error => {
      console.log(error);
    });
  }

  /**
   * Metodo para volver a la pantalla de gestionar comics
   */
  public cancelarCompra() : void {
    this.router.navigate(['gestionar-comic'], { skipLocationChange : true } )
  }

  get f() {
    return this.comprarComicForm.controls;
  }

}
