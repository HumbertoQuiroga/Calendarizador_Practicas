/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generadorHorarios.controllers;

import com.generadorHorarios.exceptions.MaestroNotFoundException;
import com.generadorHorarios.modelos.Maestro;
import com.generadorHorarios.servicios.MaestroServicios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alfr3
 */
@RestController
@RequestMapping("/maestro")
public class MaestrosController {
    
    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson = builder.create();
    private final MaestroServicios maestroServicios;
    
    public MaestrosController(MaestroServicios maestroServicios){
        this.maestroServicios = maestroServicios;
    }
    
    @GetMapping
    public ResponseEntity<List<Maestro>> obtenerTodosLosMaestros(){
        List<Maestro> maestros = maestroServicios.buscarMaestros();
        return new ResponseEntity<>(maestros, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Maestro> obtenerMaestroPorID(@PathVariable("id") String id){
        try{
            Maestro maestro = maestroServicios.buscarMestroPorID(id);
            return new ResponseEntity<>(maestro, HttpStatus.OK);
        }catch(MaestroNotFoundException e){return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
    }
    
     @GetMapping("/nombres/{nombres}")
    public ResponseEntity<Maestro> obtenerMaestroPorNombre(@PathVariable("nombres") String nombres){
        try{
            Maestro maestro = maestroServicios.buscarMaestroPorNombre(nombres);
            maestroServicios.agregarMaestroAlArreglo(maestro);
            maestroServicios.almacenarMaestro();
            return new ResponseEntity<>(maestro, HttpStatus.OK);
        }catch(MaestroNotFoundException e){return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
    }
    
    @PostMapping()
    public ResponseEntity<Maestro> agregarMaestro(@RequestBody Maestro maestro){
        Maestro new_maestro = maestroServicios.agregarMaestro(maestro);
        
        maestroServicios.agregarMaestroAlArreglo(maestro);
        maestroServicios.almacenarMaestro();
        return new ResponseEntity<>(new_maestro, HttpStatus.CREATED);
    }
    
    @PutMapping("/maestros")
    public ResponseEntity<Maestro> updateMaestroPorID(@RequestBody Maestro maestro){
        try{
            Maestro new_maestro = maestroServicios.agregarMaestro(maestro);
            
            maestroServicios.agregarMaestroAlArreglo(maestro);
            maestroServicios.almacenarMaestro();
            return new ResponseEntity<>(maestro, HttpStatus.OK);
        }catch(MaestroNotFoundException e){return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
    }
    
}
