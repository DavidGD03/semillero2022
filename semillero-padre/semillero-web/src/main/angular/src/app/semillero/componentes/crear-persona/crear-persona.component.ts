import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  public nombreInstructor : string;

  private listaComic : Array<any>;

  public imagePath : string;

  public respuesta1 : string;
  public respuesta2 : string;
  public respuesta3 : string;
  public respuesta4 : string;
  public height : number;
  public width : number;

  constructor() { }

  ngOnInit() {
    this.nombreInstructor = "DIEGO ALVAREZ";
    this.listaComic = new Array<any>();
    this.respuesta1 = "";
    this.respuesta4 = null;
    this.height = 100;
    this.width = 300;
    this.imagePath = "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__480.jpg";

    let comic1 : any = {
      nombre : "Dragon ball",
      color : true,
      tematicaEnum : "FANTASIA",
      precio : 390
    }

    let comic2 : any = {
      nombre : "Chapulin colorado",
      color : true,
      tematicaEnum : "HUMOR",
      precio : 900
    }

    let comic3 : any = {
      nombre : "Mr bean",
      color : false,
      tematicaEnum : "HUMOR",
      precio : 390
    }

    this.listaComic.push(comic1);
    this.listaComic.push(comic2);
    this.listaComic.push(comic3);

    this.listaComic.forEach((dataComic, index) => {
      console.log("data comic numero" + index + " " + JSON.stringify(dataComic));
      this.respuesta1 += "data comic numero" + index + " " + JSON.stringify(dataComic);
    }); // el foreach no retorna nada

    for (let i = 0; i < this.listaComic.length ; i++) {
      const dataComic = this.listaComic[i];
      console.log("data comic BUCLE 2 numero" + i + " " + JSON.stringify(dataComic));
      this.respuesta2 += "data comic numero" + i + " " + JSON.stringify(dataComic);
    } // el for normal tiene scope a las otras variables

    let listaBuild = this.listaComic.map((dataComic, index) => {
      return { value : dataComic, label : index }
    }); // el map puede retornar una lista

    console.log("Bucle que retorna otro tipo de lista" + JSON.stringify(listaBuild));
    this.respuesta3 = "Bucle que retorna otro tipo de lista" + JSON.stringify(listaBuild);

    this.listaComic.splice(0,2); // Borrar elementos de la lista
    this.respuesta4 = "Data final despues de delete" + JSON.stringify(this.listaComic);
  }

  public imprimirPath() : void {
    alert(this.imagePath);
  }

}
