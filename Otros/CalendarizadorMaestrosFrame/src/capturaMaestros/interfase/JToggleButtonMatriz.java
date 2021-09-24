package capturaMaestros.interfase;

import javax.swing.JButton;

/**
 * Title:        CapturaMaestros
 * Description:  Programa para generar archivo de datos de los maestros.
 * Nombre, apellido, tipo de maestro (planta o auxiliar), y horario disponible
 * Copyright:    Copyright (c) 2001
 * Company:      ITSON
 * @author adolfo
 * @version 1.0
 */

public class JToggleButtonMatriz extends JButton {
  private int posRenglon, posColumna;

  public JToggleButtonMatriz(int r, int c) {
    super();
    setRC(r,c);
  }

  public void setR(int r){
    this.posRenglon=r;
  }
  public void setC(int c){
    this.posColumna=c;
  }
  public void setRC(int r, int c){
    this.posRenglon=r;
    this.posColumna=c;
  }

  public int getRenglon(){
    return this.posRenglon;
  }
  public int getColumna(){
    return this.posColumna;
  }


}