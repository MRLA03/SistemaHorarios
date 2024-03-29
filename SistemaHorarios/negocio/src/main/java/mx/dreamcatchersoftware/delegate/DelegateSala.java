/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.integracion.ServiceLocator;


/**
 *
 * @author acer
 */
public class DelegateSala {
    
    public int registrarCarrera(String nombre_sala, int capacidad, int id_edificio, String nota) {
        int val = 0;// 0 Si no cumple las validaciones
        List<Sala> salas = new ArrayList<>();
        Sala sal = new Sala();        
        Edificio edif = new Edificio();
        try{
            salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala WHERE nombreSala = '"+nombre_sala+"' AND id_edificio = "+id_edificio+";");
            if(salas.isEmpty()){
                
                sal.setIdSala(12);
                sal.setNombreSala(nombre_sala);
                sal.setCapacidad(capacidad);
                
                val=1;
            }else{
                val=2;
            }
        }catch(Exception e){
            
        }
        return val =0;
    }
}
