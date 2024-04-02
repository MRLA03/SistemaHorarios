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
    /* NOTA: LAS VALIDACIONES QUE SE MANEJAN AQUI SON LAS SIGUIENTES
        * VALIDACION DE UNICIDAD: Validar los valores que sean unicos
        * VALIDACION DE INTEGRIDAD REFERENCIAL: Validar que los datos cumplan con las relaciones de la base de datos
        * VALIDACION DE REGLAS DE NEGOCIO: Validacion de las reglas especificas del sistema 
        * VALIDACION DE PERMISOS: Validar que ciertos usuarios puedan acceder a ciertas partes dependiendo de sus permisos si es que existen
    */
    
    public int registrarCarrera(String clave_carrera, String nombre_carrera, String plan, int bancoh){
        int val=0;// 0 Si no cumple las validaciones
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
            }            
        }catch(Exception e){
            System.out.println("\n Error al registrar Carrera: "+e);
            val=0;
        }
        return val;
    }
    
    public List consultarCarrera(){
        List<Carrera> carreras = new ArrayList<>();
        try{
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera ORDER BY nombreCarrera;");
        }catch(Exception e){
            System.out.println("\n Error al consultar Carreras: "+e);
        }
        return carreras;
    }

    public List consultarCarreraNombreClave(String busqueda){
        List<Carrera> carreras = new ArrayList<>();
        try{
            carreras = ServiceLocator.getInstanceCarreraDAO().executeQuery("SELECT * FROM carrera WHERE nombreCarrera LIKE '%"+busqueda+"%' OR claveCarrera LIKE '%"+busqueda+"%' ORDER BY nombreCarrera;");
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
                car.setNombreCarrera(nombre_carrera);
                car.setPlan(plan);
                car.setBancoHoras(bancoh);
                ServiceLocator.getInstanceCarreraDAO().update(car);//del DAO PARA ACTUALIZAR
                val = 1; //Todo correcto
            } else {
                System.out.println("No se encontró ninguna carrera con la clave especificada.");
            }
        } catch (Exception e) {
            System.out.println("\n Error al modificar Carrera: " + e);
        }
        return val;
    }    
}
