/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class testSala {
    public static void main(String[] args){
// REGISTRAR SALA
        /*int val = ServiceFacadeLocator.getInstanceFacadeSala().registrarSala("A", 20, 1, "Proyector");
        System.out.println("VAL: "+val);*/
// CONSULTAR SALA
        /*List<Sala> salas = ServiceFacadeLocator.getInstanceFacadeSala().consultarSala();
        if (salas !=null) {
            salas.forEach((sal) -> {
                System.out.println(sal.getIdEdificio().getNombreEdificio()+" : "+sal.getNombreSala()+ "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// CONSULTAR SALA POR ID O POR NOMBRE DE SALA YA SEA PARCIAL O COMPLETA
        /*List<Sala> salas = ServiceFacadeLocator.getInstanceFacadeSala().consultarSalaIdNombre("A");
        if (salas !=null) {
            salas.forEach((sal) -> {
                System.out.println(sal.getIdEdificio().getNombreEdificio()+" : "+sal.getNombreSala()+ "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
//  FILTRAR SALAS POR EDIFICIO
        /*System.out.println("\nSALAS FILTRADO POR EDIFICIO");
        salas = ServiceFacadeLocator.getInstanceFacadeSala().filtrarSalaEdificio(salas, 1);
        if (salas !=null) {
            salas.forEach((sal) -> {
                System.out.println(sal.getIdEdificio().getNombreEdificio()+" : "+sal.getNombreSala()+ "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// MODIFICAR
        int val = ServiceFacadeLocator.getInstanceFacadeSala().modificarCarrera(3, "AudioVisual - B", 50, 1, "Proyector, sillas tipo auditorio");
        System.out.println("VAL: "+val);
    }
}
