/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.integracion;

import mx.dreamcatchersoftware.facade.FacadeAsignatura;
import mx.dreamcatchersoftware.facade.FacadeCarrera;
import mx.dreamcatchersoftware.facade.FacadeEdificio;
import mx.dreamcatchersoftware.facade.FacadeSala;



/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
   
    private static FacadeCarrera facadeCarrera;
    private static FacadeAsignatura facadeAsignatura;
    private static FacadeEdificio facadeEdificio;
    private static FacadeSala facadeSala;
    
    public static FacadeCarrera getInstanceFacadeCarrera() {
        if (facadeCarrera == null) {
            facadeCarrera = new FacadeCarrera();
            return facadeCarrera;
        } else {
            return facadeCarrera;
        }
    }
    
    public static FacadeAsignatura getInstanceFacadeAsignatura() {
        if (facadeAsignatura == null) {
            facadeAsignatura = new FacadeAsignatura();
            return facadeAsignatura;
        } else {
            return facadeAsignatura;
        }
    }
    
    public static FacadeEdificio getInstanceFacadeEdificio() {
        if (facadeEdificio == null) {
            facadeEdificio = new FacadeEdificio();
            return facadeEdificio;

        } else {
            return facadeEdificio;
        }
    }

    public static FacadeSala getInstanceFacadeSala() {
        if (facadeSala == null) {
            facadeSala = new FacadeSala();
            return facadeSala;
        } else {
            return facadeSala;
        }
    }    
}
