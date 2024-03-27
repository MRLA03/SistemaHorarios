/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.integracion;

import mx.dreamcatchersoftware.facade.FacadeCarrera;



/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
   
    private static FacadeCarrera facadeCarrera;
    
    public static FacadeCarrera getInstanceFacadeCarrera() {
        if (facadeCarrera == null) {
            facadeCarrera = new FacadeCarrera();
            return facadeCarrera;
        } else {
            return facadeCarrera;
        }
    }  
}
