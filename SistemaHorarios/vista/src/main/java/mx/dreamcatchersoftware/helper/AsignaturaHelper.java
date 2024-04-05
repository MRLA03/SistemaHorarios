package mx.dreamcatchersoftware.helper;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Asignatura;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author Usuario
 */
public class AsignaturaHelper implements Serializable{
    public int registrarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase, int horas_taller, int horas_practica, int horas_laboratorio) {
        try {
            if (ServiceFacadeLocator.getInstanceFacadeAsignatura().registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio) != 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso",""));                
                return ServiceFacadeLocator.getInstanceFacadeAsignatura().registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave ya existente", ""));
                return 0;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Has caido en una excepcion",""));               
        }
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio);
    }

    public List consultarAsignatura() {
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignatura();
    }
    
    public Asignatura consultarAsignaturaId(String busqueda){
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignaturaId(busqueda);
    }

    public List consultarAsignaturaNombreClave(String busqueda) {
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignaturaNombreClave(busqueda);
    }

    public int modificarAsignatura(String clave_asignatura, String nombre_asignatura, int Horas_clase, int Horas_taller, int Horas_practica, int Horas_laboratorio) {
        try{
            if(ServiceFacadeLocator.getInstanceFacadeAsignatura().modificarAsignatura(clave_asignatura, nombre_asignatura, Horas_clase, Horas_taller, Horas_practica, Horas_laboratorio)!=0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion exitosa",""));                
                return ServiceFacadeLocator.getInstanceFacadeAsignatura().modificarAsignatura(clave_asignatura, nombre_asignatura, Horas_clase, Horas_taller, Horas_practica, Horas_laboratorio);                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la entrada de datos",""));                                   
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Has caido en una excepcion",""));               
        }
        return ServiceFacadeLocator.getInstanceFacadeAsignatura().modificarAsignatura(clave_asignatura, nombre_asignatura, Horas_clase, Horas_taller, Horas_practica, Horas_laboratorio);
    }    
}
