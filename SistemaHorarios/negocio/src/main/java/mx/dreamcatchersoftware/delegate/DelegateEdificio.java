package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author Usuario
 */
public class DelegateEdificio {
    /* NOTA: LAS VALIDACIONES QUE SE MANEJAN AQUI SON LAS SIGUIENTES
        * VALIDACION DE UNICIDAD: Validar los valores que sean unicos
        * VALIDACION DE INTEGRIDAD REFERENCIAL: Validar que los datos cumplan con las relaciones de la base de datos
        * VALIDACION DE REGLAS DE NEGOCIO: Validacion de las reglas especificas del sistema 
        * VALIDACION DE PERMISOS: Validar que ciertos usuarios puedan acceder a ciertas partes dependiendo de sus permisos si es que existen
    */    
    public int registrarEdificio(String clave_Edificio, String nombre_Edificio) {
        int val = 0;
        List<Edificio> edificios = new ArrayList<>();
        Edificio ed = new Edificio();
        try {
            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE claveEdificio = '"+clave_Edificio+"';");                        
            if (edificios.isEmpty()) {
                ed.setClaveEdificio(clave_Edificio);
                ed.setNombreEdificio(nombre_Edificio);
                ServiceLocator.getInstanceEdificioDAO().save(ed);
                val = 1;// Todo correcto
            }
        } catch (Exception e) {
            System.out.println("\n Error al registrar Edificio, Hay una misma clave o nombre: " + e);
            val = 0;
        }
        return val;
    }

  
    public List consultarEdificio() {
        List<Edificio> edificios = new ArrayList<>();
        try {
            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio ORDER BY nombreEdificio;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return edificios;
    }

    
    public List consultarEdificioNombreClave(String busqueda) {
        List<Edificio> edificios = new ArrayList<>();
        try {
            edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE LOWER(nombreEdificio) LIKE LOWER('%" + busqueda + "%') OR claveEdificio LIKE '%" + busqueda + "%' ORDER BY nombreEdificio;");
        } catch (Exception e) {
            System.out.println("\n Error al consultar Carreras: " + e);
        }
        return edificios;
    }

    
    public int modificarEdificio(String clave_Edificio, String nombre_Edificio) {
        int val = 0; 
        try {           
            List<Edificio> edificios = ServiceLocator.getInstanceEdificioDAO().executeQuery("SELECT * FROM edificio WHERE claveEdificio = '" + clave_Edificio + "'");                        
            if (!edificios.isEmpty()) {
                Edificio ed = edificios.get(0);
                //Actualiza
                ed.setNombreEdificio(nombre_Edificio);
                ServiceLocator.getInstanceEdificioDAO().update(ed);
                val = 1; //Todo correcto
            } else {
                System.out.println("No se encontró ningun Edificio con la clave especificada.");
            }
        } catch (Exception e) {
            System.out.println("\n Error al modificar el Edificio: " + e);
        }
        return val;
    }    
}
