/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bolsatrabajo.beans.ciclovida;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * @author mgordillo
 */
public class DepurationListener implements PhaseListener {
    private static final Log log = LogFactory.getLog(DepurationListener.class);


    @Override
    public void afterPhase(PhaseEvent event) {
        if (log.isInfoEnabled()) {
            log.info("AFTER PHASE: " + event.getPhaseId().toString());
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if (log.isInfoEnabled()) {
            log.info("BEFORE PHASE: " + event.getPhaseId().toString());
        }

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
