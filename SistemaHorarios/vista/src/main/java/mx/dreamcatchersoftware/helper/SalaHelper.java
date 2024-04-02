package mx.dreamcatchersoftware.helper;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author Usuario
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sala ya Existente",""));                   
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
    
    public Sala consultarSalaId(String busqueda){//Este metodo es para usarlo en modificacion
        return ServiceFacadeLocator.getInstanceFacadeSala().consultarSalaId(busqueda);
    }
    
    public List consultarSalaNombreClave(String busqueda){
        return ServiceFacadeLocator.getInstanceFacadeSala().consultarSalaIdNombre(busqueda);
    }
    
    public List filtrarSalaEdificio(List<Sala> salas, int id_Edificio){
        return ServiceFacadeLocator.getInstanceFacadeSala().filtrarSalaEdificio(salas, id_Edificio);
    }
    
    /*public int modificarSala(int id_sala, String nombre_sala, int capacidad, Edificio id_edificio, String nota) {
        try{
            if(ServiceFacadeLocator.getInstanceFacadeSala().modificarSala(id_sala,nombre_sala, capacidad, id_edificio.getIdEdificio(), nota)==1){
                ServiceFacadeLocator.getInstanceFacadeSala().modificarSala(id_sala,nombre_sala, capacidad, id_edificio.getIdEdificio(), nota)
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));                                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));               
        }
        return ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera(clave_carrera, nombre_carrera, plan, bancoh);
    }*/
    
    public int modificarSala(int id_sala, String nombre_sala, int capacidad, Edificio id_edificio, String nota) {
        int val=0;
        try{            
            val = ServiceFacadeLocator.getInstanceFacadeSala().modificarSala(id_sala,nombre_sala, capacidad, id_edificio.getIdEdificio(), nota);
            if(val == 1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación Exitosa", ""));
            }else if(val == 0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Modificar",""));                   
            }else if(val == 3){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el Edificio",""));                   
            }
            
            /*else if(val == 2){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La Sala no existe",""));                   
            }*/
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));   
        }
        return val;
    }    
}
