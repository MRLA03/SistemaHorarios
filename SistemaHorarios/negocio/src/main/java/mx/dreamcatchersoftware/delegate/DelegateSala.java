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
 * @author Usuario
 */
public class DelegateSala {
    /* NOTA: LAS VALIDACIONES QUE SE MANEJAN AQUI SON LAS SIGUIENTES
        * VALIDACION DE UNICIDAD: Validar los valores que sean unicos
        * VALIDACION DE INTEGRIDAD REFERENCIAL: Validar que los datos cumplan con las relaciones de la base de datos
        * VALIDACION DE REGLAS DE NEGOCIO: Validacion de las reglas especificas del sistema 
        * VALIDACION DE PERMISOS: Validar que ciertos usuarios puedan acceder a ciertas partes dependiendo de sus permisos si es que existen
    */    
    
    public int registrarSala(String nombre_sala, int capacidad, Edificio id_edificio, String nota) {
        int val = 0;// 0 Si no cumple las validaciones
        List<Sala> salas = new ArrayList<>();
        Sala sal = new Sala();        
        List<Edificio> edificios = new ArrayList<>();
        try{
            salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala WHERE nombreSala = '"+nombre_sala+"' AND idEdificio = "+id_edificio.getIdEdificio()+";");
            if(salas.isEmpty()){
                edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE idEdificio = "+id_edificio.getIdEdificio()+";");
                if(!edificios.isEmpty()){
                    sal.setNombreSala(nombre_sala);
                    sal.setCapacidad(capacidad);
                    sal.setIdEdificio(id_edificio);
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
    
    public Sala consultarSalaId(String busqueda){
        List<Sala> salas = new ArrayList<>();
        try {
            salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala WHERE idSala = "+busqueda+";");            
        } catch (Exception e) {
            System.out.println("\n Error al consultar Sala por Id o Nombre: " + e);
        }
        return salas.get(0);
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
    
    //FALTA VALIDAR LO DEL NOMBRE EN EL SALON AQUI
    public int modificarSala(int id_sala,String nombre_sala, int capacidad, Edificio id_edificio, String nota) {
        int val = 0; // 0 si no cumple las validaciones     
        try{
            List<Sala> salas = ServiceLocator.getInstanceSalaDAO().executeQuery("SELECT * FROM sala WHERE idSala = "+id_sala+";");
            Sala sal = new Sala();
            List<Edificio> edificios = new ArrayList<>();            
            if(!salas.isEmpty()){//Validar que exista la sala
                edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE idEdificio = "+id_edificio.getIdEdificio()+";");
                if(!edificios.isEmpty()){
                    sal = salas.get(0);
                    sal.setNombreSala(nombre_sala);
                    sal.setCapacidad(capacidad);
                    sal.setIdEdificio(id_edificio);
                    sal.setNota(nota);
                    ServiceLocator.getInstanceSalaDAO().update(sal);
                    val=1;// Todo bien
                }else{
                    val = 3;// Existe la Sala, pero el Edificio que ingreso no existe
                }
            }else{
                val=2;// No existe esa Sala
            }
        }catch(Exception e){
            System.out.println("\n Error al modificar Sala: "+e);
            val=0;// Hay una Excepcion
        }
        return val;
    }    
}
