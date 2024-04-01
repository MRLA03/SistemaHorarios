/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Maestro;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author acer
 */
public class testMaestro {
    public static void main(String [] args){
// REGISTRAR MAESTRO
        /*int val = ServiceFacadeLocator.getInstanceFacadeMaestro().registrarMaestro("17024", "Monica Cristina Lam Mora", 0, 4, 0, 40);
        System.out.println("VAL: "+val);*/
// CONSULTAR MAESTRO
        /*List<Maestro> maestros = ServiceFacadeLocator.getInstanceFacadeMaestro().consultarMaestro();
        if (maestros !=null) {
            maestros.forEach((mae) -> {
                System.out.println(mae.getNEmpleado()+" : "+mae.getNombreMaestro()+" : "+mae.getTipo()+ "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// CONSULTAR MAESTRO POR NUMERO DE EMPLEADO O POR NOMBRE DE MAESTRO YA SEA PARCIAL O COMPLETA
        /*List<Maestro> maestros = ServiceFacadeLocator.getInstanceFacadeMaestro().consultarMaestroNombreNEmpleado("24");
        if (maestros !=null) {
            maestros.forEach((mae) -> {
                System.out.println(mae.getNEmpleado()+" : "+mae.getNombreMaestro()+" : "+mae.getTipo()+ "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
//  FILTRAR MAESTRO POR TIPO DE EMPLEADO
        /*System.out.println("\nMAESTROS FILTRADO POR TIPO DE EMPLEADO");
        maestros = ServiceFacadeLocator.getInstanceFacadeMaestro().filtrarMaestroTipoEmpleado(maestros, 0);
        if (maestros !=null) {
            maestros.forEach((mae) -> {
                System.out.println(mae.getNEmpleado()+" : "+mae.getNombreMaestro()+" : "+mae.getTipo()+ "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
// CONSULTAR MAESTRO POR ID        
        /*Maestro mae = ServiceFacadeLocator.getInstanceFacadeMaestro().consultarMaestroId("1");
                System.out.println(mae.getNEmpleado()+" : "+mae.getNombreMaestro()+" : "+mae.getTipo()+ "\n");            */
// MODIFICAR
        int val = ServiceFacadeLocator.getInstanceFacadeMaestro().modificarMaestro("15228", "Luis Enrique Vizcarra Corral", 1, 0, 0, 20);
        System.out.println("VAL: "+val);        
    }
}
