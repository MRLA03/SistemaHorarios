package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateEdificio;

/**
 *
 * @author Usuario
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
    
   public List consultarEdificioNombreClave(String busqueda){
        return delegateEdificio.consultarEdificioNombreClave(busqueda);
   }   
   
   public int modificarEdificio(String clave_Edificio, String nombre_Edificio) {
    return delegateEdificio.modificarEdificio(clave_Edificio, nombre_Edificio);
   }    
}
