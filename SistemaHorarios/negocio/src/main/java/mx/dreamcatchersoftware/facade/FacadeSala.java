/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateSala;
import mx.dreamcatchersoftware.entidad.Sala;

/**
 *
 * @author acer
 */
public class FacadeSala {
    private final DelegateSala delegateSala;
    
    public FacadeSala() {
        this.delegateSala = new DelegateSala();
    }

    public int registrarSala(String nombre_sala, int capacidad, int id_edificio, String nota) {
        return delegateSala.registrarSala(nombre_sala, capacidad, id_edificio, nota);
    }
    
    public List consultarSala(){
        return delegateSala.consultarSala();
    }
    
    public List consultarSalaIdNombre(String busqueda){
        return delegateSala.consultarSalaIdNombre(busqueda);
    }
    
    public List filtrarSalaEdificio(List<Sala> salas, int id_Edificio){
        return delegateSala.filtrarSalaEdificio(salas, id_Edificio);
    }
}
