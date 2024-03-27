/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;


/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {        
//REGISTRAR CARRERA       
        int val = ServiceFacadeLocator.getInstanceFacadeCarrera().registrarCarrera("6", "Licenciado en Sistemas Computacionales", "2009-2", 130);
        System.out.println("VAL: "+val);
    }
}
