package mx.dreamcatchersoftware.helper;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Carrera;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

public class CarreraHelper implements Serializable{
    public int registrarCarrera(String clave_carrera, String nombre_carrera, String plan, int bancoh){
        try{
            if(ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera(clave_carrera, nombre_carrera, plan,bancoh) !=0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso",""));
                return ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera(clave_carrera, nombre_carrera, plan,bancoh);                 
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave ya existente",""));
                return 0;
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Has caido en una excepcion",""));   
        }
        return ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera(clave_carrera, nombre_carrera, plan,bancoh);         
    }
    
    public List consultarCarrera(){
        return ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarrera();
    }
    
    public List consultarCarreraNombreClave(String busqueda){
        return ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarreraNombreClave(busqueda);
    }
    
    public int modificarCarrera(String clave_carrera, String nombre_carrera, String plan, int bancoh) {
        try{
            if(ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera(clave_carrera, nombre_carrera, plan, bancoh)!=0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion exitosa",""));
                return ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera(clave_carrera, nombre_carrera, plan, bancoh);                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));                                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Has caido en una excepcion",""));               
        }
        return ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera(clave_carrera, nombre_carrera, plan, bancoh);
    }    
}
