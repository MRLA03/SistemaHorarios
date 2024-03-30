/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Asignatura;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author acer
 */
public class testAsignatura {
    public static void main(String [] args){
//Consultar asignatura
        /*List<Asignatura> asig = ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignaturaNombreClave("si");
            
            // Imprimir los detalles de las carreras modificadas (si las hay)
            if (!asig.isEmpty()) {
                for (Asignatura asignatura : asig) {
                    System.out.println("Asignatura:");
                    System.out.println("Clave: " + asignatura.getClaveAsignatura());
                    System.out.println("Nombre: " + asignatura.getNombreAsignatura());
                    System.out.println("HC: " + asignatura.getHoraClase());
                    System.out.println("HT: " + asignatura.getHoraTaller());
                    System.out.println("HP: " + asignatura.getHoraPractica());
                    System.out.println("HL: " + asignatura.getHoraLaboratorio());
                }
            }*/
        
//Modificar asignatura
        int val2 = ServiceFacadeLocator.getInstanceFacadeAsignatura().modificarAsignatura("si","no",4,5,6,2);
        
        // Verificar si la modificación fue exitosa
        if (val2 == 1) {
            // Consultar la carrera modificada
            List<Asignatura> asignaturamodificada = ServiceFacadeLocator.getInstanceFacadeAsignatura().consultarAsignaturaNombreClave("si");
            
            // Imprimir los detalles de las carreras modificadas (si las hay)
            if (!asignaturamodificada.isEmpty()) {
                for (Asignatura asignatura : asignaturamodificada) {
                    System.out.println("Carrera modificada:");
                    System.out.println("Clave: " + asignatura.getClaveAsignatura());
                    System.out.println("Nombre: " + asignatura.getNombreAsignatura());
                    System.out.println("HC: " + asignatura.getHoraClase());
                    System.out.println("HT: " + asignatura.getHoraTaller());
                    System.out.println("HP: " + asignatura.getHoraPractica());
                    System.out.println("HL: " + asignatura.getHoraLaboratorio());
                }
            } else {
                System.out.println("No se encontró ninguna asignatura con la clave especificada.");
            }
        } else {
            System.out.println("La modificación de la asignatura no se pudo completar.");
        }
    }
}
