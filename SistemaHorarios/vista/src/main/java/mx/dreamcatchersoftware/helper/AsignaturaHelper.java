/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.helper;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

public class AsignaturaHelper implements Serializable {

    public int registrarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase, int horas_taller, int horas_practica, int horas_laboratorio) {
        try {
            if (ServiceFacadeLocator.getInstanceFacadeAsignatura().registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio) != 0) {
                return ServiceFacadeLocator.getInstanceFacadeAsignatura().registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave ya existente", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos", ""));
        }
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio);
    }

    public List consultarAsignatura() {
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignatura();
    }

    public List consultarAsignaturaNombreClave(String busqueda) {
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignaturaNombreClave(busqueda);
    }

}
