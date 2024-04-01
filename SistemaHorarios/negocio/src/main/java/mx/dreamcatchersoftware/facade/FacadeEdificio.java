/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;
import mx.dreamcatchersoftware.delegate.DelegateEdificio;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Edificio;
/**
 *
 * @author DELL
 */
public class FacadeEdificio {
    private final DelegateEdificio delegateEdificio;
    
    public FacadeEdificio() {
        this.delegateEdificio = new DelegateEdificio();
    }
    
   public int registrarEdificio(String clave_Edificio, String nombre_Edificio){
       return delegateEdificio.registrarEdificio(clave_Edificio, nombre_Edificio);
   } 
    
   public List consultarEdificio(){
       return delegateEdificio.consultarEdificio();
   }
   public Edificio consultaEdificioID(String busqueda){
       return delegateEdificio.consultaEdificioID(busqueda);
   } 
   public List consultarEdificioNombreClave(String busqueda){
        return delegateEdificio.consultarEdificioNombreClave(busqueda);
    }   
   
   public int modificarEdificio(String clave_Edificio, String nombre_Edificio) {
    return delegateEdificio.modificarEdificio(clave_Edificio, nombre_Edificio);
    }
}