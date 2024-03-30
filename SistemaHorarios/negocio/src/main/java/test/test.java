/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.entidad.Carrera;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Edificio;
/**
 * Clase de prueba para probar el registro y modificación de carreras.
 */
public class test {
    public static void main(String[] args) {        
       // Registrar Carrera       
       /* int val = ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera("103","Algorit", "2002-2", 100);
        System.out.println("VAL: " + val);
        System.out.println();
       */
    
    
          /* Modificar
        int val2 = ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera("101", "matematicas", "200222222-2", 100000);

        // Verificar
        if (val2 == 1) {
            // Consultar la carrera modificada
            List<Carrera> carrerasModificadas = ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarreraNombreClave("101");

            // Imprimir los detalles de las carreras modificadas (si las hay)
            if (!carrerasModificadas.isEmpty()) {
                for (Carrera carrera : carrerasModificadas) {
                    System.out.println("Carrera modificada:");
                    System.out.println("Clave: " + carrera.getClaveCarrera());
                    System.out.println("Nombre: " + carrera.getNombreCarrera());
                    System.out.println("Plan: " + carrera.getPlan());
                    System.out.println("Banco de horas: " + carrera.getBancoHoras());
                }
            } else {
                System.out.println("No se encontró ninguna carrera con la clave especificada.");
            }
        } else {
            System.out.println("La modificación de la carrera no se pudo completar.");
        }

    
    */
    }
}
















       
