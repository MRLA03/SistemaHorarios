/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Carrera;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author libra
 */
public class DelegateCarrera {

    public int registrarCarrera(String clave_carrera, String nombre_carrera, String plan, int bancoh) {
        int val = 0;// 0 Si no cumple las validaciones
        List<Carrera> carreras = new ArrayList<>();
        Carrera car = new Carrera();        
        try{
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE claveCarrera = '"+clave_carrera+"';");            
            if(carreras.isEmpty()){
                car.setClaveCarrera(clave_carrera);                
                car.setNombreCarrera(nombre_carrera);                
                car.setPlan(plan);                
                car.setBancoHoras(bancoh);
                ServiceLocator.getInstanceCarreraDAO().save(car);
                val=1;// 1 Si todo es correcto
            }else{
                val=2;
            }            
        }catch(Exception e){
            System.out.println("\n Error al registrar Carrera: "+e);
            val=0;
        }
        
        return val;
    }

    public List consultarCarrera() {
        List<Carrera> carreras = new ArrayList<>();
        try {
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera ORDER BY nombreCarrera;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return carreras;
    }
    
    public List consultarCarreraNombre(String busquedaNombre){
        List<Carrera> carreras = new ArrayList<>();
        try{
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE nombreCarrera LIKE '%"+busquedaNombre+"%' ORDER BY nombreCarrera;");
        }catch(Exception e){
            System.out.println("\n Error al consultar Carreras: "+e);
        }
        return carreras;
    }
    
    public Carrera consultarCarreraId(String busqueda){
        List<Carrera> carreras = new ArrayList<>();
        try {
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE idMaestro = "+busqueda+";");            
        } catch (Exception e) {
            System.out.println("\n Error al consultar Sala por Id o Nombre: " + e);
        }
        return carreras.get(0);
    }
    
    public List consultarCarreraClave(String busquedaClave){
        List<Carrera> carreras = new ArrayList<>();        
        try{
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE claveCarrera LIKE '%"+busquedaClave+"%' ORDER BY claveCarrera;");
        }catch(Exception e){
            System.out.println("\n Error al consultar Carreras: "+e);
        }
        return carreras;
    }
    
    public List consultarCarreraNombreClave(String busqueda){
        List<Carrera> carreras = new ArrayList<>();
        try{
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE LOWER(nombreCarrera) LIKE LOWER('%"+busqueda+"%') OR claveCarrera LIKE '%"+busqueda+"%' ORDER BY nombreCarrera;");
        }catch(Exception e){
            System.out.println("\n Error al consultar Carreras: "+e);
        }
        return carreras;
    }

    public int modificarCarrera(String clave_carrera, String nombre_carrera, String plan, int bancoh) {
        int val = 0; // 0 si no cumple las validaciones
        try {
            List<Carrera> carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE claveCarrera = '" + clave_carrera + "'");
            if (!carreras.isEmpty()) {
                Carrera car = carreras.get(0);

                //Actualiza
                car.setIdCarrera(carreras.get(0).getIdCarrera());
                car.setNombreCarrera(nombre_carrera);
                car.setPlan(plan);
                car.setBancoHoras(bancoh);

                ServiceLocator.getInstanceCarreraDAO().update(car);//del DAO PARA ACTUALIZAR
                val = 1; //Todo correcto
            } else {
                System.out.println("No se encontró ninguna carrera con la clave especificada.");
                val = 2;
            }
        } catch (Exception e) {// ocupe ayuda 
            System.out.println("\n Error al modificar Carrera: " + e);
        }
        return val;
    }    
}
