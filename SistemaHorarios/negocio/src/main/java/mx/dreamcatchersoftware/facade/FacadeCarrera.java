/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateCarrera;

/**
 *
 * @author libra
 */
public class FacadeCarrera {
    
    private final DelegateCarrera delegateCarrera;
    
    public FacadeCarrera() {
        this.delegateCarrera = new DelegateCarrera();
    }
    
    public int registrarCarrera(String clave_carrera, String nombre_carrera, String plan, int bancoh){
        return delegateCarrera.registrarCarrera(clave_carrera, nombre_carrera, plan, bancoh);
    }

    public List consultarCarrera(){
        return delegateCarrera.consultarCarrera();
    }

    public List consultarCarreraNombreClave(String busqueda){
        return delegateCarrera.consultarCarreraNombreClave(busqueda);
    }    
    
    public List consultarCarrera(){
        return delegateCarrera.consultarCarrera();
    }
    
    public List consultarCarreraNombre(String busquedaNombre){
        return delegateCarrera.consultarCarreraNombre(busquedaNombre);
    }
    
    public List consultarCarreraClave(String busquedaClave){
        return delegateCarrera.consultarCarreraClave(busquedaClave);
    }
    
    public List consultarCarreraClaveNombre(String busqueda){
        return delegateCarrera.consultarCarreraClaveNombre(busqueda);
    }
}
