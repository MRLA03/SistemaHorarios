/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.helper;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Maestro;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author acer
 */
public class MaestroHelper {
    public int registrarMaestro(String numero_empleado, String nombre_maestro, int tipo_maestro, int horas_IE, int horas_ad, int horas_max) {
        int val = -1;        
        try{            
            val = ServiceFacadeLocator.getInstanceFacadeMaestro().registrarMaestro(numero_empleado, nombre_maestro, tipo_maestro, horas_IE, horas_ad, horas_max);
            if(val == 1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Exitoso", ""));                
            }else if(val == 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Registrar",""));                   
            }else if(val == 2){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave ya Existente",""));                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));   
        }
        return val;
    }
    
    public List consultarMaestro(){
        return ServiceFacadeLocator.getInstanceFacadeMaestro().consultarMaestro();
    }
    
    public Maestro consultarMaestroId(String busqueda){//Este metodo es para usarlo en modificacion
        return ServiceFacadeLocator.getInstanceFacadeMaestro().consultarMaestroId(busqueda);
    }
    
    public List consultarSalaNombreNEmpleado(String busqueda){
        return ServiceFacadeLocator.getInstanceFacadeMaestro().consultarMaestroNombreNEmpleado(busqueda);
    }
    
    public List filtrarMaestroTipoEmpleado(List<Maestro> maestros, int id_Maestro){
        return ServiceFacadeLocator.getInstanceFacadeMaestro().filtrarMaestroTipoEmpleado(maestros, id_Maestro);
    }
    
    public int modificarMaestro(String numero_empleado, String nombre_maestro, int tipo_maestro, int horas_IE, int horas_ad, int horas_max) {
        return ServiceFacadeLocator.getInstanceFacadeMaestro().modificarMaestro(numero_empleado, nombre_maestro, tipo_maestro, horas_IE, horas_ad, horas_max);
    }
        
}
