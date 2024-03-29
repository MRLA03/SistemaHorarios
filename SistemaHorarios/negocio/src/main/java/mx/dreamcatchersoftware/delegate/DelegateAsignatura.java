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
}
