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
 *
 * @author DELL
 */
public class testEdificio {
    
    public static void main(String[] args) {
    int val6 = ServiceFacadeLocator.getInstanceFacadeEdificio().registrarEdificio("3","Agua");
        System.out.println("VAL Edificio: " + val6);
        System.out.println();
    
    
    
    
    List<Edificio> edificios = ServiceFacadeLocator.getInstanceFacadeEdificio().consultarEdificio();
        System.out.println("Edificios registrados:");
        for (Edificio edificio : edificios) {
            System.out.println("Clave: " + edificio.getClaveEdificio());
            System.out.println("Nombre: " + edificio.getNombreEdificio());
            System.out.println();
        }

        }
        
    }

