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
            //validar que no haya campos vacios! 
            //NOTA DE ALEJANDRO: NO ME SIRVE EN LA VISTA
            if (nombre_carrera.isEmpty() || plan.isEmpty() || Integer.toString(bancoh).isEmpty()) {
                System.out.println("No se permite tener campos vacios");
                return val;
            }
            //NOTA DE ALEJANDRO: AGARRA BAJO CIERTAS CONDICIONES POR LO QUE NO ME SRIVE DE MOMENTO           
            if (!nombre_carrera.matches("[a-zA-Z//s]+")) {
                System.out.println("El nombre de la carrera solo debe contener Letras");
                return val;
            }
            //validar que el banco de horas solo deba tener numeros enteros(al final esta excepcion puede que no sea necesaria ya que bancoh es tipo entero)
            //NOTA DE ALEJANDRO: ANTES DE QUE PUEDA COMPROBAR SI SIRVE, EL SISTEMA YA ME SUELTA LA EXCEPCION
            if (String.valueOf(bancoh).matches("[^0-9]")) {
                System.out.println("El banco de horas debe ser un número entero.");
                return val;
            }

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
        } catch (Exception e) {// ocupe ayuda 
            System.out.println("\n Error al modificar Carrera: " + e);
        }
        return val;
    }    
}
