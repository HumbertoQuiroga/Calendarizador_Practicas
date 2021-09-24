package capturaMaestros.variables;

import java.util.Vector;
import java.io.*;
import capturaMaestros.variables.*;
/**
 * Title:        CapturaMaestros
 * Description:  Programa para generar archivo de datos de los maestros.
 * Nombre, apellido, tipo de maestro (planta o auxiliar), y horario disponible
 * Copyright:    Copyright (c) 2001
 * Company:      ITSON
 * @author adolfo
 * @version 1.0
 */

public class VectorMaestros extends Vector {

  public VectorMaestros() {
    super(1,1);
  }
  public VectorMaestros(File nomArch){
    super(1,1);
    cargaTodo(nomArch);
  }

  public void almacenaTodo(File nomArch){
    int longitud = this.size();
    int i;
    DataOutput archSalida;
    try{
      archSalida = new DataOutputStream(new FileOutputStream(nomArch));
      archSalida.writeInt(longitud); //Guarda numero de maestros
      for(i=0; i<longitud; i++){     //Guarda cada maestro
          //,iestra lo que guarda
           /*if(((Maestro)this.get(i)).getNombre().startsWith("AA")){
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 0, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 1, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 2, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 3, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 4, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 5, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 6, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 7, 1);
               ((Maestro)this.get(i)).getHorario().setDisponibilidad(0, 8, 1);
               System.out.println(i+((Maestro)this.get(i)).getNombre()+ ((Maestro)this.get(i)).getApell());
               ((Maestro)this.get(i)).getHorario().imprimirHorario();
           }*/
        ((Maestro)this.get(i)).guardarMaestro(archSalida);
      }
      //new Maestro("00000182033", "JESUS ALFREDO", "PEREZ DIERO").guardarMaestro(archSalida);
    }
    catch(Exception e) {
      System.out.print("\n error de archivo salida\n");
      e.printStackTrace();
    }
  }

  public void cargaTodo(File nomArch){
    int longitud;
    DataInput arch;
    this.removeAllElements();
    this.trimToSize();

    try{
      arch = new DataInputStream(new FileInputStream(nomArch));
      longitud =arch.readInt();   //Lee numero de maestros
     // this.addElement(new Maestro(new String("00000182033"), "JESUS ALFREDO", "PEREZ DIERO"));
      for(int i=0; i<longitud; i++){  //LEE CADA MAESTRO
        Maestro buffer=new Maestro(); // Crea objetos Maestro
        buffer.cargarMaestro(arch);   // Asigna valores de archivo

        this.addElement(buffer);      // Lo agrega al vector
      }
    }
    catch(Exception e) {
      System.out.print("\n Error leyendo archivo de datos de maestros \n");
      e.printStackTrace();
    }
  }

  /*public void creaEjemplo(int a){
    Maestro ejem1=new Maestro('p',111,"Adolfo","espinoza");
    ejem1.horario.escribeEnCasilla(1,1,1);
    //Maestro ejem2=new Maestro('a',22+String.valueOf(i),"ppppp","gomez");
    for(int i=0; i<a; i++){
      //this.addElement(ejem1);
      Maestro ejem2=new Maestro('a',100+i,"ppppp","gomez");//
      this.addElement(ejem2);
    }
  }*/

  public VectorMaestros sortApell(){
    VectorMaestros vectorOrdenado = new VectorMaestros();
    Maestro maestroAux;
    int longitudOrig=this.size();
    int longitudOrden=this.size();

    vectorOrdenado.removeAllElements();
    vectorOrdenado.trimToSize();

    vectorOrdenado.addElement(((Maestro)(this.get(0))).clone());

    for(int i=1; i<longitudOrig; i++){

      maestroAux=( (Maestro)(((Maestro)(this.get(i))).clone()) );

      longitudOrden=vectorOrdenado.size();
      for(int j=0; j<=longitudOrden;j++){
        if(j==longitudOrden){
          vectorOrdenado.addElement(maestroAux);
        }
        else{
          if(maestroAux.getApell().compareTo(
          ((Maestro)(vectorOrdenado.get(j))).getApell())<=0){
            //Inserta elemento
            vectorOrdenado.add(  j, maestroAux );
            break;
          }
        }
      }
    }
    return vectorOrdenado;
  }
}