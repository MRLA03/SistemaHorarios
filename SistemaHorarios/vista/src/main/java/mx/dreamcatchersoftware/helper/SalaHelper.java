/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.helper;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author acer
 */
public class SalaHelper {
    public int registrarSala(String nombre_sala, int capacidad, Edificio id_edificio, String nota) {
        int val = -1;
        try{            
            val = ServiceFacadeLocator.getInstanceFacadeSala().registrarSala(nombre_sala, capacidad, id_edificio.getIdEdificio(), nota);
            if(val == 1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Exitoso", ""));
            }else if(val == 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Registrar",""));                   
            }else if(val == 2){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave ya Registrada",""));                   
            }else if(val == 3){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el Edificio",""));                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));   
        }
        return val;
    }
    
    public List consultarSala(){
        return ServiceFacadeLocator.getInstanceFacadeSala().consultarSala();
    }
    
    public List consultarSalaNombreClave(String busqueda){
        return ServiceFacadeLocator.getInstanceFacadeSala().consultarSalaIdNombre(busqueda);
    }
    
    /*public int modificarSala(int id_sala,String nombre_sala, int capacidad, Edificio id_edificio, String nota) {
        try{
            if(ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera(clave_carrera, nombre_carrera, plan, bancoh)!=0){
                return ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera(clave_carrera, nombre_carrera, plan, bancoh);                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));                                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));               
        }
        return ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera(clave_carrera, nombre_carrera, plan, bancoh);
    }*/
}
