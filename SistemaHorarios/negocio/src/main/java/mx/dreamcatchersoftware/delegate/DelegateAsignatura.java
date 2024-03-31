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
            //validar que no haya campos vacios!
            if (nombre_asignatura.isEmpty() || Integer.toString(horas_clase).isEmpty() || Integer.toString(horas_taller).isEmpty() || Integer.toString(horas_practica).isEmpty() || Integer.toString(horas_laboratorio).isEmpty()) {
                System.out.println("No se permite tener campos vacios");
                return val;
            }
            //validar que el nombre de la carrera solo contenga letras
            if (!nombre_asignatura.matches("[a-zA-Z//s]+")) {
                System.out.println("El nombre de la asignatura solo debe contener Letras");
                return val;
            }
            //validar que el banco de horas solo deba tener numeros enteros(al final esta excepcion puede que no sea necesaria ya que bancoh es tipo entero)
            if (String.valueOf(horas_clase).matches("[^0-9]") || String.valueOf(horas_taller).matches("[^0-9]")|| String.valueOf(horas_practica).matches("[^0-9]") || String.valueOf(horas_laboratorio).matches("[^0-9]")) {
                System.out.println("El banco de horas debe ser un número entero.");
                return val;
            }

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
            }
        } catch (Exception e) {// ocupe ayuda 
            System.out.println("\n Error al modificar Asignatura: " + e);
        }
        return val;
    }
}
