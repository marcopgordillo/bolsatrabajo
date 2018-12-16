/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bolsatrabajo.beans.backing;

import com.example.bolsatrabajo.beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
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
public class VacanteForm {
    
    private static final Log log = LogFactory.getLog(VacanteForm.class);

    /**
     * Creates a new instance of VacanteForm
     */
    public VacanteForm() {
        log.info("Creando objeto VacanteForm");
    }
    
    @Inject
    private Candidato candidato;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    // Metodo de flujo de control
    public String enviar(){
        if (this.candidato.getNombre().equals("Juan")) {
            log.info("Entrando al caso de exito");
            return "exito"; // exito.xhtml
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo"; // fallo.xhtml
        }
    }
}
