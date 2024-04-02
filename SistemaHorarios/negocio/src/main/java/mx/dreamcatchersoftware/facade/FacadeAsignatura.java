package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateAsignatura;
import mx.dreamcatchersoftware.entidad.Asignatura;

/**
 *
 * @author Usuario
 */
public class FacadeAsignatura {
    private final DelegateAsignatura delegateAsignatura;
    
    public FacadeAsignatura() {
        this.delegateAsignatura = new DelegateAsignatura();
    }
    
    public int registrarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase, int horas_taller, int horas_practicas,  int horas_laboratorio){
        return delegateAsignatura.registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practicas, horas_laboratorio);
    }    
    public List consultarAsignatura(){
        return delegateAsignatura.consultarAsignatura();
    }
    
    public Asignatura consultarAsignaturaId(String busqueda){
        return delegateAsignatura.consultarAsignaturaId(busqueda);
    }

    public List consultarAsignaturaNombreClave(String busqueda){
        return delegateAsignatura.consultarAsignaturaNombreClave(busqueda);
    }
    
    public int modificarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase,int horas_taller, int horas_practica, int horas_laboratorio) {
        return delegateAsignatura.modificarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practica, horas_laboratorio);
    }    
}
