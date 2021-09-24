package capturaMaestros.interfase;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Selector2d extends JPanel implements MouseListener {

  private int columnas;
  private int renglones;
  private int estado=0;
  private int anteriorColumna;
  private int anteriorRenglon;
  private int [][] estados;
  final private Color ACTIVADO= new Color(0,200,200);
  final private Color DESACTIVADO= new Color(255,255,250);

  private GridLayout gridLayout1 = new GridLayout();

  private JToggleButtonMatriz[][] celda;

  public Selector2d(int renglones,int columnas) {
    this.renglones = renglones;
    this.columnas = columnas;
    celda = new JToggleButtonMatriz[this.renglones][this.columnas];
    estados = new int [renglones][columnas];

    for(int r=0; r<renglones; r++)for(int c=0; c<columnas; c++){
      estados[r][c]=0;
    }

    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

/******
  public Selector2d(int[][] matriz) {
    this.columnas = matriz[0].length;
    this.renglones = matriz.length;

    celda = new JToggleButtonMatriz[this.renglones][this.columnas];
    estados = matriz;
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
*/

  public int[][] getEstados(){
    return estados;
  }

  public void setEstados (int [][] valor){
    estados=valor;
    showEstados();
  }

  private void jbInit() throws Exception {
    gridLayout1.setRows(renglones);
    gridLayout1.setColumns(columnas);
    this.setLayout(gridLayout1);

    for(int contReng=0; contReng<renglones; contReng++){
      for(int contCol=0; contCol<columnas; contCol++){
        celda[contReng][contCol] = new JToggleButtonMatriz(contReng,contCol);
        celda[contReng][contCol].setFocusPainted(false);
        celda[contReng][contCol].setDefaultCapable(false);
        if(estados[contReng][contCol]==0){
          celda[contReng][contCol].setBackground(DESACTIVADO);
        }
        else{
          celda[contReng][contCol].setBackground(ACTIVADO);
        }
        celda[contReng][contCol].addMouseListener(this);
        this.add(celda[contReng][contCol], null);
      }
    }

  }

  public void mouseClicked(MouseEvent e){
    int r=((JToggleButtonMatriz)e.getSource()).getRenglon();
    int c=((JToggleButtonMatriz)e.getSource()).getColumna();
    if(e.isShiftDown()){
      switch(estado){
        case 0: anteriorColumna=c;
                anteriorRenglon=r;
                invierteBoton(r,c);
                estado=1;
                break;
        case 1:
                forzaBotones(anteriorRenglon,anteriorColumna,r,c,
                      estados[anteriorRenglon][anteriorColumna]);
                estado=0;
      }
    }else{
      invierteBoton(r,c);
      estado=0;
    }
  }
  public void mouseEntered(MouseEvent e){
  }
  public void mouseExited(MouseEvent e){
  }
  public void mousePressed(MouseEvent e){
  }
  public void mouseReleased(MouseEvent e){
  }

  private void forzaBotones (int r1, int c1,int r2, int c2, int valor){
    if(r1>r2){ int rAux=r1; r1=r2; r2=rAux;}
    if(c1>c2){ int cAux=c1; c1=c2; c2=cAux;}

    for(int r=r1; r<=r2; r++)
      for(int c=c1; c<=c2; c++){
        asignaValorBoton(r,c,valor);
      }
  }

  private void invierteBoton(int r,int c){
    if(estados[r][c]==1)asignaValorBoton(r,c,0);
    else asignaValorBoton(r,c,1);
  }

  private void asignaValorBoton(int r, int c, int valor){
    estados[r][c]=valor;
    if(valor==1)celda[r][c].setBackground(ACTIVADO);
    else celda[r][c].setBackground(DESACTIVADO);
  }

  private void showEstados(){
    int r=0, c=0;
    for(r=0; r<this.renglones; r++)
      for(c=0; c<this.columnas; c++){
        asignaValorBoton(r,c,estados[r][c]);
      }
  }
}