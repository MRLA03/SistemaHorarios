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

    
    public List consultarEdificio() {
        List<Edificio> edificios = new ArrayList<>();
        try {
            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio ORDER BY nombreEdificio;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return edificios;
    }
}
