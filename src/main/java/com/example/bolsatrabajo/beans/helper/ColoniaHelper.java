/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bolsatrabajo.beans.helper;

import com.example.bolsatrabajo.beans.model.Colonia;
import com.example.bolsatrabajo.beans.servicio.ColoniaService;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author mgordillo
 */
@RequestScoped
@Named
public class ColoniaHelper {
    
    private static final Log log = LogFactory.getLog(ColoniaHelper.class);
    
    @Inject
    ColoniaService coloniaService;
    
    public List<Colonia> getColonias() {
        List<Colonia> colonias = coloniaService.findAll();
        log.info("Recuperamos el listado de personas del EJB");
        return colonias;
    }
    
    public long getColoniaIdPorNombre(String nombreColonia) {
        long coloniaId = 0;
        List<Colonia> colonias = getColonias();//Lista de colonias
        for (Colonia colonia : colonias) {
            if (colonia.getNombreColonia().equals(nombreColonia)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    public long getColoniaIdPorCP(long codigoPostal) {
        long coloniaId = 0;
        List<Colonia> colonias = getColonias();
        for (Colonia colonia : colonias) {
            if (colonia.getCodigoPostal() == codigoPostal) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems;
        selectItems = new ArrayList<>();
        List<Colonia> colonias = getColonias();
        for (Colonia colonia : colonias) {
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(),
                    colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        return selectItems;
    }
}
