/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generadorHorarios.modelos;

import java.io.*;

/**
 *
 * @author alfr3
 */
public class Horario {
  private final int COLUMNAS=5, RENGLONES=28;
  private int casilla[][] = new int[RENGLONES][COLUMNAS];

  public Horario() {
    borrarHoriario();
  }
  
  public Horario(String horario) {
    int cantTotal =RENGLONES*COLUMNAS;
    int cont0=0;
    for(int cont1=0; cont1<RENGLONES; cont1++){
        for(int cont2=0; cont2<COLUMNAS; cont2++){
          casilla[cont1][cont2]= Integer.parseInt(String.valueOf(horario.charAt(cont0)));cont0++;
        }
    }
  }

  private void borrarHoriario(){
    for(int cont1=0; cont1<RENGLONES; cont1++){
        for(int cont2=0; cont2<COLUMNAS; cont2++){
          casilla[cont1][cont2]=0;
        }
    }
  }
  
  public String convertirHorarioToString(){
    String horarioString ="";
    for(int cont1=0; cont1<RENGLONES; cont1++){
        for(int cont2=0; cont2<COLUMNAS; cont2++){
          horarioString = horarioString+String.valueOf(casilla[cont1][cont2]);
        }
    }
    return horarioString;
  }
  

  public void escribeEnCasilla( int hora, int dia, int info){
      casilla[hora][dia]=info;
  }

  public int leeCasilla(int hora, int dia){
      return casilla[hora][dia];
  }

  public void guardarHorario(DataOutput archSalida){
    try{
      int i, j;
      for(j=0; j<RENGLONES; j++)for(i=0; i<COLUMNAS; i++){
        archSalida.writeInt(this.casilla[j][i]);
      }
    }
    catch(IOException e) {System.out.println("Error: "+e.getMessage());}
  }

  public void cargarHorario(DataInput arch){
    try{
      int i, j;
      for(j=0; j<RENGLONES; j++) for(i=0; i<COLUMNAS; i++){
        this.casilla[j][i] = arch.readInt();
      }
    }
    catch(IOException e) {System.out.println("Error: "+e.getMessage());}
  }

  public void setHorario(Horario horEnt){
    int i, j;
    for(j=0; j<RENGLONES; j++) for(i=0; i<COLUMNAS; i++){
      this.casilla[j][i]=horEnt.casilla[j][i];
    }
  }
  
  public void setDisponibilidad(int dia, int hora, int valor){
      this.casilla[hora][dia] = valor;
  }

  public void setHorario(int[][] horEnt){
    this.casilla=horEnt;
  }

  public Horario getHorario(){
    int i, j;
    Horario horSal = new Horario();
    for(j=0; j<RENGLONES; j++)for(i=0; i<COLUMNAS; i++){
      horSal.casilla[j][i]=this.casilla[j][i];
    }
    return horSal;
  }
  
  public void imprimirHorario(){
      for(int cont =0; cont < COLUMNAS ;cont++){
          for(int cont2=0;cont2 < RENGLONES;cont2++){
              System.out.println(cont2+" - "+getDia(cont)+". "+casilla[cont2][cont]);
          }
      }
  }
  
  private String getDia(int n){
      switch(n){
          case 0: return "Lunes";
          case 1: return "Martes";
          case 2: return "Miercoles";
          case 3: return "Jueves";
          case 4: return "Viernes";
          default : return "sepa";
      }
  }
  
}