/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateMaestro;
import mx.dreamcatchersoftware.entidad.Maestro;

/**
 *
 * @author acer
 */
public class FacadeMaestro {
    private final DelegateMaestro delegateMaestro;
    
    public FacadeMaestro() {
        this.delegateMaestro = new DelegateMaestro();
    }    
    
    public int registrarMaestro(String numero_empleado, String nombre_maestro, int tipo_maestro, int horas_IE, int horas_ad, int horas_max) {
        return delegateMaestro.registrarMaestro(numero_empleado, nombre_maestro, tipo_maestro, horas_IE, horas_ad, horas_max);
    }
    
    public int modificarMaestro(String numero_empleado, String nombre_maestro, int tipo_maestro, int horas_IE, int horas_ad, int horas_max) {
        return delegateMaestro.modificarMaestro(numero_empleado, nombre_maestro, tipo_maestro, horas_IE, horas_ad, horas_max);
    }
    
    public List consultarMaestro(){
        return delegateMaestro.consultarMaestro();
    }
    public Maestro consultarMaestroId(String busqueda){
        return delegateMaestro.consultarMaestroId(busqueda);
    }
    
    public List consultarMaestroNombreNEmpleado(String busqueda){
        return delegateMaestro.consultarMaestroNombreNEmpleado(busqueda);
    }
    
    public List filtrarMaestroTipoEmpleado(List<Maestro> maestros, int tipo_Empleado){
        return delegateMaestro.filtrarMaestroTipoEmpleado(maestros, tipo_Empleado);
    }
}
