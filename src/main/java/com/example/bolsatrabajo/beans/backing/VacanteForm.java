/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bolsatrabajo.beans.backing;

import com.example.bolsatrabajo.beans.helper.ColoniaHelper;
import com.example.bolsatrabajo.beans.helper.FacesContextHelper;
import com.example.bolsatrabajo.beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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
   
    @Inject
    private Candidato candidato;
    
    private boolean comentarioEnviado= false;
    
    @Inject
    private ColoniaHelper coloniaHelper;
    
    public VacanteForm() {
        log.info("Creando objeto VacanteForm");
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public ColoniaHelper getColoniaHelper() {
        return coloniaHelper;
    }

    public void setColoniaHelper(ColoniaHelper coloniaHelper) {
        this.coloniaHelper = coloniaHelper;
    }
    
    // Metodo de flujo de control
    public String enviar(){
        log.info("enviar() Nombre=" + this.candidato.getNombre());
        log.info("enviar() Apellido=" + this.candidato.getApellido());
        log.info("enviar() Sueldo deseado=" + this.candidato.getSueldoDeseado());

        if (this.candidato.getNombre().equals("Juan")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String clientId = null; //Este es un mensaje global
                facesContext.addMessage(clientId, facesMessage);
                return "index";
            }
            return "exito"; // exito.xhtml
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo"; // fallo.xhtml
        }
    }
    
    //Metodo de tipo Value Change Listener
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        Long newCodigoPostal = (Long) valueChangeEvent.getNewValue();
        log.info("Nuevo codigo postal: " + newCodigoPostal);
        UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String ciudad = "Ciudad de Mexico";
        ciudadInputText.setValue(ciudad);
        ciudadInputText.setSubmittedValue(ciudad);
        UIInput coloniaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
        //Buscamos la colonia por id con ayuda del bean coloniaHelper
        Long coloniaId = this.coloniaHelper.getColoniaIdPorCP(newCodigoPostal);
        coloniaInputText.setValue(coloniaId);
        coloniaInputText.setSubmittedValue(coloniaId);
        //Enviamos la respuesta
        facesContext.renderResponse();
    }
    
    public void ocultarComentario (ActionEvent actionEvent) {
        this.comentarioEnviado = !this.comentarioEnviado;
        FacesContext facesContext =FacesContext.getCurrentInstance();
        FacesContextHelper.limpiarImmediateFacesMessages(facesContext);
    }

}
