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
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

public class EdificioHelper implements Serializable {

    public int registrarEdificio(String claveEdificio, String nombreEdificio) {
        try {
            if (ServiceFacadeLocator.getInstanceFacadeEdificio().registrarEdificio(claveEdificio, nombreEdificio) != 0) {
                return ServiceFacadeLocator.getInstanceFacadeEdificio().registrarEdificio(claveEdificio, nombreEdificio);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave ya existente", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos", ""));
        }
        return ServiceFacadeLocator.getInstanceFacadeEdificio().registrarEdificio(claveEdificio, nombreEdificio);
    }

    public List<Edificio> consultarEdificio() {
        return ServiceFacadeLocator.getInstanceFacadeEdificio().consultarEdificio();
    }

    public List<Edificio> consultarEdificioNombreClave(String busqueda) {
        return ServiceFacadeLocator.getInstanceFacadeEdificio().consultarEdificioNombreClave(busqueda);
    }
    /*
     public int modificarEdificio(String clave_Edificio, String nombre_Edificio) {
        try{
            if(ServiceFacadeLocator.getInstanceFacadeEdificio().registrarEdificio(clave_Edificio, nombre_Edificio)!=0){
                return ServiceFacadeLocator.getInstanceFacadeEdificio().modificarEdificio(clave_Edificio, nombre_Edificio);                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));                                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));               
        }
        return ServiceFacadeLocator.getInstanceFacadeEdificio().modificarEdificio(clave_Edificio, nombre_Edificio);
    }
    
     public int modificarEdificio(String clave_Edificio, String nombre_Edificio) {
        int val=0;
        try{            
            val = ServiceFacadeLocator.getInstanceFacadeEdificio().modificarEdificio(clave_Edificio,nombre_Edificio);
            if(val == 1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación Exitosa", ""));
            }else if(val == 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Modificar",""));                   
            }
            
          
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));   
        }
        return val;
    }*/
     
    
}
