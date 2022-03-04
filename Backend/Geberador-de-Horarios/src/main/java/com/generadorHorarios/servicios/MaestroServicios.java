/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generadorHorarios.servicios;

import com.generadorHorarios.exceptions.MaestroNotFoundException;
import com.generadorHorarios.modelos.Maestro;
import com.generadorHorarios.repository.MaestroRepo;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfr3
 */
@Service
public final class MaestroServicios {

    private final MaestroRepo maestroRepo;
    private final List<Maestro> listaMaestros;

    @Autowired
    public MaestroServicios(MaestroRepo maestroRepo) {
        this.maestroRepo = maestroRepo;
        this.listaMaestros = buscarMaestros();
    }

    public Maestro agregarMaestro(Maestro maestro) {
        return maestroRepo.save(maestro);
    }

    public List<Maestro> buscarMaestros() {
        return maestroRepo.findAll();
    }
    
    public Maestro buscarMaestroPorNombre(String nombres){
        return maestroRepo.findMaestroByNombres(nombres)
               .orElseThrow(() -> new MaestroNotFoundException(nombres));
    }
    
    public Maestro buscarMestroPorID(String id){
        return maestroRepo.findMaestroById(id)
               .orElseThrow(() -> new MaestroNotFoundException(id));
    }
    
   public Maestro agregarMaestroAlArreglo(Maestro maestro){
       for(int cont=0; cont < listaMaestros.size();cont++){
           if(listaMaestros.get(cont).getId().equals(maestro.getId())){
               listaMaestros.set(cont, maestro);
               return maestro;
           }
       }
       if(this.listaMaestros.add(maestro)){
           return maestro;
       }
       else{return null;}
   }

    public void almacenarMaestro() {
        File archivo = new File("D:\\Escritorio\\Escuela\\Proyecto Practicas\\Calendarizador_Practicas\\Otros\\CalendarizadorMaestrosFrame\\tabMaes.dat");
        int longitud = listaMaestros.size();
        DataOutput archSalida;
        try {
            archSalida = new DataOutputStream(new FileOutputStream(archivo));
            archSalida.writeInt(longitud); 
            for (int i = 0; i < longitud; i++){this.listaMaestros.get(i).guardarMaestro(archSalida);}
        } catch (IOException e) {System.out.println("Error: "+e.getMessage());}
    }
}
