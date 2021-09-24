/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generadorHorarios.repository;

import com.generadorHorarios.modelos.Maestro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alfr3
 */
public interface MaestroRepo extends JpaRepository<Maestro, String>{
    Optional<Maestro> findMaestroById(String id);
}
