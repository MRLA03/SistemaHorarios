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
        List<Carrera> carreras = ServiceFacadeLocator.getInstanceFacadeCarrera().consultarCarreraClaveNombre("C1");
        System.out.println("VAL: "+carreras.get(0).getBancoHoras());
        if (carreras != null) {
        carreras.forEach((car) -> {
            System.out.println(car.getClaveCarrera()+" "+car.getNombreCarrera() + "\n");
        });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }

    }
}
