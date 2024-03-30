/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.integracion.ServiceLocator;


/**
 *
 * @author acer
 */
public class DelegateSala {
    
    public int registrarSala(String nombre_sala, int capacidad, int id_edificio, String nota) {
        int val = 0;// 0 Si no cumple las validaciones
        List<Sala> salas = new ArrayList<>();
        Sala sal = new Sala();        
        List<Edificio> edificios = new ArrayList<>();
        try{
            salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala WHERE nombreSala = '"+nombre_sala+"' AND idEdificio = "+id_edificio+";");
            if(salas.isEmpty()){
                edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE idEdificio = "+id_edificio+";");
                if(!edificios.isEmpty()){
                    sal.setIdSala(12);
                    sal.setNombreSala(nombre_sala);
                    sal.setCapacidad(capacidad);
                    sal.setIdEdificio(edificios.get(0));
                    sal.setNota(nota);
                    ServiceLocator.getInstanceSalaDAO().save(sal);
                    val=1;
                }else{
                    val = 3;// No existe la Sala, pero el Edificio que ingreso tampoco existe
                }
            }else{
                val=2;// Ya existe esa Sala
            }
        }catch(Exception e){
            System.out.println("\n Error al registrar Sala: "+e);
            val=0;// Hay una Excepcion
        }
        return val;
    }

    public List consultarSala(){
        List<Sala> salas = new ArrayList<>();
        try {
            salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala;");
            Collections.sort(salas, new Comparator<Sala>() {
                @Override
                public int compare(Sala sala1, Sala sala2) {
                    // Comparar por nombre de edificio
                    int comparacionEdificio = sala1.getIdEdificio().getNombreEdificio().compareTo(sala2.getIdEdificio().getNombreEdificio());
                    // Si los nombres de edificio son iguales, comparar por nombre de sala
                    if (comparacionEdificio == 0) {
                        return sala1.getNombreSala().compareTo(sala2.getNombreSala());
                    }
                    return comparacionEdificio;
                }
            });
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return salas;
    }
    
    public List consultarSalaIdNombre(String busqueda){
        List<Sala> salas = new ArrayList<>();
        try {
            salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala WHERE CAST(idSala AS CHAR) LIKE '%"+busqueda+"%' OR LOWER(nombreSala) LIKE LOWER('%"+busqueda+"%');");
            Collections.sort(salas, new Comparator<Sala>() {
                @Override
                public int compare(Sala sala1, Sala sala2) {
                    // Comparar por nombre de edificio
                    int comparacionEdificio = sala1.getIdEdificio().getNombreEdificio().compareTo(sala2.getIdEdificio().getNombreEdificio());
                    // Si los nombres de edificio son iguales, comparar por nombre de sala
                    if (comparacionEdificio == 0) {
                        return sala1.getNombreSala().compareTo(sala2.getNombreSala());
                    }
                    return comparacionEdificio;
                }
            });
        } catch (Exception e) {
            System.out.println("\n Error al consultar Sala por Id o Nombre: " + e);
        }
        return salas;
    }
    
    public List filtrarSalaEdificio(List<Sala> salas, int id_Edificio){
        List<Sala> salasFiltradas = new ArrayList<>();
        try{
            salasFiltradas = salas.stream().filter(sala -> sala.getIdEdificio().getIdEdificio() == id_Edificio)
                .collect(Collectors.toList());
        }catch(Exception e){
            System.out.println("\n Error al filtrar Sala por Edificio: " + e);
        }
        
        return salasFiltradas;
    }
}
