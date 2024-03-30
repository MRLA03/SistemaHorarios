/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;

import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author DELL
 */
public class DelegateEdificio {

    public int registrarEdificio(String clave_Edificio, String nombre_Edificio) {
        int val = 0;
        List<Edificio> edificios = new ArrayList<>();
        Edificio ed = new Edificio();

        try {
            if (clave_Edificio.isEmpty() || nombre_Edificio.isEmpty()) {
                System.out.println("NO debe ingresar campos vacios");
                return val;
            }

            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE claveEdificio = '" + clave_Edificio + "';");
            if (!edificios.isEmpty()) {
                System.out.println("ya existe una clave o nombre de edificio igual");
                return val;
            }

            if (edificios.isEmpty()) {
                ed.setClaveEdificio(clave_Edificio);
                ed.setNombreEdificio(nombre_Edificio);

                ServiceLocator.getInstanceEdificioDAO().save(ed);
                val = 1;// Todo correcto
            }
        } catch (Exception e) {
            System.out.println("\n Error al registrar Edificio, Hay una misma clave o nombre: " + e);
            val = 0;
        }
        System.out.println("registroo");
        return val;
    }

  
    public List consultarEdificio() {
        List<Edificio> edificios = new ArrayList<>();
        try {
            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio ORDER BY nombreEdificio;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return edificios;
    }

    
    public List consultarEdificioNombreClave(String busqueda) {
        List<Edificio> edificios = new ArrayList<>();
        try {
            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE nombreEdificio LIKE '%" + busqueda + "%' OR claveEdificio LIKE '%" + busqueda + "%' ORDER BY nombreEdificio;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return edificios;
    }

    
    public int modificarEdificio(String clave_Edificio, String nombre_Edificio) {
        int val = 0; 
        try {
            if(clave_Edificio.isEmpty()|| nombre_Edificio.isEmpty()){
            System.out.println("No se permiten campos vacios");
        }
            
           
            List<Edificio> edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE claveedificio = '" + clave_Edificio + "'");
            if (!nombre_Edificio.isEmpty()) {
            System.out.println("Ya existe un edificio con el mismo nombre.");
            return val;
        }
            
            
            if (!edificios.isEmpty()) {
                Edificio ed = edificios.get(0);

                //Actualiz
                ed.setNombreEdificio(nombre_Edificio);

                ServiceLocator.getInstanceEdificioDAO().update(ed);
                val = 1; //Todo correcto
            } else {
                System.out.println("No se encontró ninguna Edificio con la clave especificada.");
            }
        } catch (Exception e) {
            System.out.println("\n Error al modificar el Edificio: " + e);
        }
        return val;
    }

}

