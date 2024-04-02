package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Asignatura;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author Usuario
 */
public class DelegateAsignatura {
    /* NOTA: LAS VALIDACIONES QUE SE MANEJAN AQUI SON LAS SIGUIENTES
        * VALIDACION DE UNICIDAD: Validar los valores que sean unicos
        * VALIDACION DE INTEGRIDAD REFERENCIAL: Validar que los datos cumplan con las relaciones de la base de datos
        * VALIDACION DE REGLAS DE NEGOCIO: Validacion de las reglas especificas del sistema 
        * VALIDACION DE PERMISOS: Validar que ciertos usuarios puedan acceder a ciertas partes dependiendo de sus permisos si es que existen
    */    
    public int registrarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase, int horas_taller, int horas_practicas,  int horas_laboratorio) {
        int val = 0;// 0 Si no cumple las validaciones        
        List<Asignatura> asignaturas = new ArrayList<>();
        Asignatura asg = new Asignatura();        
        try {
            asignaturas = ServiceLocator.getInstanceAsignaturaDAO().executeQuery("SELECT * FROM asignatura WHERE claveAsignatura = '" + clave_asignatura + "';");
            if (asignaturas.isEmpty()) {
                asg.setClaveAsignatura(clave_asignatura);
                asg.setNombreAsignatura(nombre_asignatura);
                asg.setHoraClase(horas_clase);
                asg.setHoraTaller(horas_taller);
                asg.setHoraPractica(horas_practicas);
                asg.setHoraLaboratorio(horas_laboratorio);
                ServiceLocator.getInstanceAsignaturaDAO().save(asg);
                val = 1;// Todo correcto
            }
        } catch (Exception e) {
            System.out.println("\n Error al registrar Asignatura: " + e);
            val = 0;
        }
        return val;
    }
    
    public List consultarAsignatura() {
        List<Asignatura> asignaturas = new ArrayList<>();
        try {
            asignaturas = ServiceLocator.getInstanceAsignaturaDAO().executeQuery("SELECT * FROM asignatura ORDER BY nombreAsignatura;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Asignaturas: " + e);
        }
        return asignaturas;
    }
    
    //NUEVO
    public Asignatura consultarAsignaturaId(String busqueda){
        List<Asignatura> asignaturas = new ArrayList<>();
        try {
            asignaturas = ServiceLocator.getInstanceAsignaturaDAO().executeQuery("SELECT * FROM asignatura WHERE idAsignatura = " + busqueda + ";");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Asignaturas: " + e);
        }
        return asignaturas.get(0);       
    }
    
    public List consultarAsignaturaNombreClave(String busqueda) {
        List<Asignatura> asignaturas = new ArrayList<>();
        try {
            asignaturas = ServiceLocator.getInstanceAsignaturaDAO().executeQuery("SELECT * FROM asignatura WHERE nombreAsignatura LIKE '%" + busqueda + "%' OR claveAsignatura LIKE '%" + busqueda + "%' ORDER BY nombreAsignatura;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Asignaturas: " + e);
        }
        return asignaturas;
    }

    public int modificarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase, int horas_taller, int horas_practica, int horas_laboratorio) {
        int val = 0; // 0 si no cumple las validaciones copiado del luis
        try {
            List<Asignatura> asignaturas = ServiceLocator.getInstanceAsignaturaDAO().executeQuery("SELECT * FROM asignatura WHERE claveasignatura = '" + clave_asignatura + "'");
            if (!asignaturas.isEmpty()) {
                Asignatura asg = asignaturas.get(0);
                //Actualiza
                asg.setNombreAsignatura(nombre_asignatura);
                asg.setHoraClase(horas_clase);
                asg.setHoraTaller(horas_taller);
                asg.setHoraPractica(horas_practica);                
                asg.setHoraLaboratorio(horas_laboratorio);                                
                ServiceLocator.getInstanceAsignaturaDAO().update(asg);//del DAO PARA ACTUALIZAR
                val = 1; //Todo correcto
            } else {
                System.out.println("No se encontró ninguna asignatura con la clave especificada.");
            }
        } catch (Exception e) {// ocupe ayuda 
            System.out.println("\n Error al modificar Asignatura: " + e);
        }
        return val;
    }
}
