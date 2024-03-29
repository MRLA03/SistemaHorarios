/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Carrera;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;


/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {        
// REGISTRAR CARRERA       
        /*int val = ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera("6", "Licenciado en Sistemas Computacionales", "2009-2", 130);
        System.out.println("VAL: "+val);*/
// CONSULTAR CARRERAS
        /*List<Carrera> carreras = ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarrera();
        if (carreras != null) {
        carreras.forEach((car) -> {
            System.out.println(car.getClaveCarrera()+" "+car.getNombreCarrera() + "\n");
        });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// CONSULTAR CARRERAS POR NOMBRE PARCIAL O COMPLETO   
        /*List<Carrera> carreras = ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarreraNombre("civ");
        if (carreras != null) {
        carreras.forEach((car) -> {
            System.out.println(car.getClaveCarrera()+" "+car.getNombreCarrera() + "\n");
        });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// CONSULTAR CARRERAS POR CLAVE PARCIAL O COMPLETA
        /*List<Carrera> carreras = ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarreraClave("6");
        if (carreras != null) {
        carreras.forEach((car) -> {
            System.out.println(car.getClaveCarrera()+" "+car.getNombreCarrera() + "\n");
        });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// CONSULTAR CARRERAS POR CLAVE O NOMBRE YA SEA PARCIAL O COMPLETA
        List<Carrera> carreras = ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarreraNombreClave("C1");
        System.out.println("VAL: "+carreras.get(0).getBancoHoras());
        if (carreras != null) {
        carreras.forEach((car) -> {
            System.out.println(car.getClaveCarrera()+" "+car.getNombreCarrera() + "\n");
        });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }
// MODIFICAR
        int val2 = ServiceFacadeLocator.getInstanceFacadeCarrera().modificarCarrera("101", "matematicas", "200222222-2", 100000);
    // VERIFICAR
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

    
    

    }
}