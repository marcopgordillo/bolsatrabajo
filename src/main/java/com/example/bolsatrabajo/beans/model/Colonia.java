/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bolsatrabajo.beans.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mgordillo
 */
@Entity
@Table(name = "colonia")
@NamedQuery(name = "Colonia.findAll", query = "SELECT c FROM Colonia c")
public class Colonia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colonia_id")
    private long coloniaId;
    
    @Column(name = "nombre_colonia")
    private String nombreColonia;
    
    @Column(name = "codigo_postal")
    private long codigoPostal;

    public Colonia() {
    }   

    public Colonia(long coloniaId, String nombreColonia, long codigoPostal) {
        this.coloniaId = coloniaId;
        this.nombreColonia = nombreColonia;
        this.codigoPostal = codigoPostal;
    }

    public long getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(long coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getNombreColonia() {
        return nombreColonia;
    }

    public void setNombreColonia(String nombreColonia) {
        this.nombreColonia = nombreColonia;
    }

    public long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.coloniaId ^ (this.coloniaId >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Colonia other = (Colonia) obj;
        if (this.coloniaId != other.coloniaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Colonia{" + "coloniaId=" + coloniaId + ", nombreColonia=" + nombreColonia + ", codigoPostal="
                + codigoPostal + '}';
    }
}
