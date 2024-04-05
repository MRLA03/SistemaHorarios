/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mx.dreamcatchersoftware.entidad.Maestro;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author Usuario
 */
public class DelegateMaestro {
    public int registrarMaestro(String numero_empleado, String nombre_maestro, int tipo_maestro, int horas_IE, int horas_ad, int horas_max) {
        int val = 0;// 0 Si no cumple las validaciones
        List<Maestro> maestros = new ArrayList<>();
        Maestro mae = new Maestro();                
        try{
            maestros = ServiceLocator.getInstanceMaestroDAO().executeQuery("SELECT * FROM maestro WHERE nEmpleado = '"+numero_empleado+"';");
            if(maestros.isEmpty()){                                
                    mae.setIdMaestro(12);
                    mae.setNEmpleado(numero_empleado);
                    mae.setNombreMaestro(nombre_maestro);
                    mae.setTipo(tipo_maestro);// 0 Maestro Tiempo Completo, 1 Maestro Asignatura, 2 Tecnico
                    mae.setHrsIE(horas_IE);
                    mae.setHrsad(horas_ad);// Horas en otro plan educativo
                    mae.setHmax(horas_max);
                    ServiceLocator.getInstanceMaestroDAO().save(mae);
                    val=1;                
            }else{
                val=2;// Ya existe el Maestro
            }
        }catch(Exception e){
            System.out.println("\n Error al registrar Maestro: "+e);
            val=0;// Hay una Excepcion
        }
        return val;
    }  
    
    public List consultarMaestro(){
        List<Maestro> maestros = new ArrayList<>();
        try {
            maestros = ServiceLocator.getInstanceMaestroDAO().executeQuery("SELECT * FROM maestro ORDER BY nombreMaestro;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return maestros;
    }
    
    public Maestro consultarMaestroId(String busqueda){
        List<Maestro> maestros = new ArrayList<>();
        try {
            maestros = ServiceLocator.getInstanceMaestroDAO().executeQuery("SELECT * FROM maestro WHERE idMaestro = "+busqueda+";");            
        } catch (Exception e) {
            System.out.println("\n Error al consultar Sala por Id o Nombre: " + e);
        }
        return maestros.get(0);
    }
    
    public List consultarMaestroNombreNEmpleado(String busqueda){
        List<Maestro> maestros = new ArrayList<>();
        try {
            maestros = ServiceLocator.getInstanceMaestroDAO().executeQuery("SELECT * FROM maestro WHERE nEmpleado LIKE '%"+busqueda+"%' OR LOWER(nombreMaestro) LIKE LOWER('%"+busqueda+"%') ORDER BY nombreMaestro;");            
        } catch (Exception e) {
            System.out.println("\n Error al consultar Sala por Id o Nombre: " + e);
        }
        return maestros;
    }
    
    public List filtrarMaestroTipoEmpleado(List<Maestro> maestros, int tipo_Empleado){
        List<Maestro> maestrosFiltradas = new ArrayList<>();
        try{
            maestrosFiltradas = maestros.stream().filter(maestro -> maestro.getTipo() == tipo_Empleado)
                .collect(Collectors.toList());
        }catch(Exception e){
            System.out.println("\n Error al filtrar Sala por Edificio: " + e);
        }
        
        return maestrosFiltradas;
    }
    
    public int modificarMaestro(String numero_empleado, String nombre_maestro, int tipo_maestro, int horas_IE, int horas_ad, int horas_max) {
        int val = 0;// 0 Si no cumple las validaciones
        List<Maestro> maestros = new ArrayList<>();
        Maestro mae = new Maestro();                
        try{
            maestros = ServiceLocator.getInstanceMaestroDAO().executeQuery("SELECT * FROM maestro WHERE nEmpleado = '"+numero_empleado+"';");
            if(!maestros.isEmpty()){                                
                    mae.setIdMaestro(maestros.get(0).getIdMaestro());
                    mae.setNEmpleado(numero_empleado);
                    mae.setNombreMaestro(nombre_maestro);
                    mae.setTipo(tipo_maestro);// 0 Maestro Tiempo Completo, 1 Maestro Asignatura, 2 Tecnico
                    mae.setHrsIE(horas_IE);
                    mae.setHrsad(horas_ad);// Horas en otro plan educativo
                    mae.setHmax(horas_max);
                    ServiceLocator.getInstanceMaestroDAO().update(mae);
                    val=1;                
            }else{
                val=2;// No existe el Maestro
            }
        }catch(Exception e){
            System.out.println("\n Error al registrar Maestro: "+e);
            val=0;// Hay una Excepcion
        }
        return val;
    }    
}
