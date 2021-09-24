package capturaMaestros.variables;
import java.io.*;


/**
 * Title:        CapturaMaestros
 * Description: Programa para generar archivo de datos de los maestros.
 * Nombre, apellido, tipo de maestro (planta o auxiliar), y horario disponible
 * Copyright:    Copyright (c) 2001
 * Company:      ITSON
 * @author adolfo
 * @version 1.0
 */

public class Maestro{

  private String  id;
  private String  nom, apell;
  public Horario horario= new Horario();

  public Maestro() {
  }
  public Maestro(String id, String nom, String apell) {
    setNombre(nom,apell);
    setID(id);
  }


  public void guardarMaestro(DataOutput archSalida){
    try{
      //archSalida.writeChar((int)this.tipo);
      archSalida.writeBytes(this.id);
      archSalida.writeByte(0);
      archSalida.writeBytes(this.nom);
      archSalida.writeByte(0);
      archSalida.writeBytes(this.apell);
      archSalida.writeByte(0);
      horario.guardarHorario(archSalida);
    }
    catch(Exception e) {
      System.out.print("\n error de archivo salida\n");
      e.printStackTrace();
    }
  }

  public void cargarMaestro(DataInput arch){
  // Retorna un objeto de la clase Maestro leido del archivo
    try{
     // System.out.print((this.tipo=arch.readChar()) + " ");
      //System.out.print((this.id = arch.readInt()) +"\n");
      System.out.print((this.id = readString(arch)) +"\n");
      System.out.print((this.nom = readString(arch)) +" ");
      System.out.print((this.apell = readString(arch)) +"  \n");
      this.horario.cargarHorario(arch);
      System.out.print(" \n \n");
    }
    catch(Exception e) {
      System.out.print("\n error de lectura en archivo\n");
      e.printStackTrace();
    }
  }

 private String readString(DataInput arch){
    char[] bufCadena =  new char[20];
    int apChar=0;
    try{
      do{
        bufCadena[apChar++] = (char)arch.readByte();
      }while(bufCadena[apChar-1]!=0);
    }
    catch(Exception e) {
      System.out.print("\n error de archivo entrada\n");
      e.printStackTrace();
    }
    return new String(bufCadena,0,apChar-1);
  }

  public void setNombre(String nom, String apell){
    this.nom= nom;
    this.apell=apell;
  }

  public void setID(String id){
    this.id = id;
  }

  public String getID(){
    return id;
  }

  public String getNombre(){
    return new String(this.apell+"  "+this.nom);
  }

  public String getNomPila(){
    return new String(this.nom);
  }

  public String getApell(){
    return new String(this.apell);
  }


  public void printMaestro(String men){
    System.out.println(
      new String("printMaestro: "+men+" "+id+"   "+nom+" "+apell) );
  }

  public Object clone(){
    Maestro nuevoMaestro=new Maestro(id ,this.getNomPila(),this.getApell());
    nuevoMaestro.horario.setHorario(this.horario.getHorario());
    return nuevoMaestro;
  }

  public void copiarMaestro(Maestro original){
    String iD = original.getID();
    this.setID(iD);

    this.setNombre(original.getNomPila(),original.getApell());
    this.horario.setHorario(original.horario.getHorario());
  }

  public void copiarClavNom(Maestro original){
    String iD = original.getID();
    this.setID(iD);
  System.out.println("  ID(int)="+iD);
    this.setNombre(original.getNomPila(),original.getApell());
  }

 /* public boolean isMaestroOk(){
  //verifica que maest:   El primer caracter sea "P" o "A",
  //                        los Ultimos 4 caracteres sean numero.
    String iD = this.getID();

    int longitud = iD.length();
    char tipo =Character.toTitleCase(iD.charAt(0));
    String numStr= iD.substring(1,longitud);
    int num;

    if(longitud<=3){

      return false;
    }
    if((tipo!='A')&&(tipo!='P')){
      return false;
    }
    try{
      num=(Integer.parseInt(numStr));
      if ((num<0)||(num>9999)) return false;
    }
    catch(NumberFormatException e){
      return false;
    }

    this.setID(tipo,num);
    return  true;
  }*/

  public Horario getHorario(){
      return horario;
  }
}