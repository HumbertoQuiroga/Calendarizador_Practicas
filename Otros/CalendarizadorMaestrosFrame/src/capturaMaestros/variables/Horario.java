package capturaMaestros.variables;
import java.io.*;


public class Horario {
  private final int COLUMNAS=5, RENGLONES=28;
  private int casilla[][] = new int[RENGLONES][COLUMNAS];

  public Horario() {
    borraTodo();
  }

  public void borraTodo(){
    int i, j;
    for(j=0; j<RENGLONES; j++)for(i=0; i<COLUMNAS; i++){
      casilla[j][i]=0;
    }
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
    catch(Exception e) {
      System.out.print("\n error de archivo salida\n");
      e.printStackTrace();
    }
  }

  public void cargarHorario(DataInput arch){
  // Retorna un objeto de la clase Horario leido del archivo
    try{
      int i, j;
      for(j=0; j<RENGLONES; j++) for(i=0; i<COLUMNAS; i++){
        System.out.print(this.casilla[j][i] = arch.readInt());
      }
    }
    catch(Exception e) {
      System.out.print("\n error de lectura en archivo\n");
      e.printStackTrace();
    }
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