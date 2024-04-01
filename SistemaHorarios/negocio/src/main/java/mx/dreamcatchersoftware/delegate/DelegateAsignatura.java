/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Asignatura;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author libra
 */
public class DelegateAsignatura {
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
            asignaturas = ServiceLocator.getInstanceAsignaturaDAO().executeQuery("SELECT * FROM asignatura WHERE LOWER(nombreAsignatura) LIKE LOWER('%" + busqueda + "%') OR claveAsignatura LIKE '%" + busqueda + "%' ORDER BY nombreAsignatura;");
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

                //Actualiz
                asg.setNombreAsignatura(nombre_asignatura);
                asg.setHoraClase(horas_clase);
                asg.setHoraTaller(horas_taller);
                asg.setHoraPractica(horas_practica);                
                asg.setHoraLaboratorio(horas_laboratorio);
                                
                ServiceLocator.getInstanceAsignaturaDAO().update(asg);//del DAO PARA ACTUALIZAR
                val = 1; //Todo correcto
            } else {
                System.out.println("No se encontró ninguna asignatura con la clave especificada.");
                val  = 2;// En caso de que ya Exista la Asignatura
            }
        } catch (Exception e) {// ocupe ayuda 
            System.out.println("\n Error al modificar Asignatura: " + e);
        }
        return val;
    }
    
}