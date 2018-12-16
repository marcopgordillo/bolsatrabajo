/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bolsatrabajo.beans.servicio;

import com.example.bolsatrabajo.beans.model.Colonia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mgordillo
 */
@Stateless
public class ColoniaService {
    @PersistenceContext
    EntityManager em;

    public List<Colonia> findAll() {
        return em.createNamedQuery("Colonia.findAll").getResultList();
    }
}
