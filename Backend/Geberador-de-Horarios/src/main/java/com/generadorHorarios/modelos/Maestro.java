/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generadorHorarios.modelos;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author alfr3
 */
@Entity
public class Maestro implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private String id;
    private String nombres;
    private String apellidos;
    private String disponibilidad;

    public Maestro() {

    }

    public Maestro(String id, String nombres, String apellidos, String disponibilidad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.disponibilidad = disponibilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void guardarMaestro(DataOutput archSalida) {
        Horario horario = new Horario(this.disponibilidad);
        try {
            archSalida.writeBytes(this.id);
            archSalida.writeByte(0);
            archSalida.writeBytes(this.nombres);
            archSalida.writeByte(0);
            archSalida.writeBytes(this.apellidos);
            archSalida.writeByte(0);
            horario.guardarHorario(archSalida);
        } catch (IOException e) {
            System.out.print("Error: " + e.getMessage());
        }
    }

    public void cargarMaestro(DataInput arch) {
        try {
            System.out.print((this.id = readString(arch)) + "\n");
            System.out.print((this.nombres = readString(arch)) + " ");
            System.out.print((this.apellidos = readString(arch)) + "  \n");
            //this.horario.cargarHorario(arch);
            System.out.print(" \n \n");
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
    }

    private String readString(DataInput arch) {
        char[] bufCadena = new char[20];
        int apChar = 0;
        try {
            do {
                bufCadena[apChar++] = (char) arch.readByte();
            } while (bufCadena[apChar - 1] != 0);
        } catch (IOException e) {
            System.out.print("Error: " + e.getMessage());
        }
        return new String(bufCadena, 0, apChar - 1);
    }

    @Override
    public String toString() {
        return "Maestro{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", disponibilidad=" + disponibilidad + '}';
    }
    
    

}
