package mx.dreamcatchersoftware.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Edificio;
import mx.dreamcatchersoftware.helper.EdificioHelper;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "edificioUI")
@SessionScoped
public class EdificioUI {
    /* NOTA: LAS VALIDACIONES QUE SE MANEJAN AQUI SON LAS SIGUIENTES
        * VALIDACION DE CAMPOS OBLIGATORIOS: Validar los campos que sean obligatorios
        * VALIDACION DE FORMATO DE ENTRADA: Verificar que los datos ingresados cumplan con la estructura esperada
        * VALIDACION DE LONGITUD DE ENTRADA: Validar que los datos no excedan una longitud maxima permitida
        * VALIDACION DE SELECCION: Opciones valiadas dentro de campos con opciones predefinidas
        * VALIDACION DE CONSISTENCIA: Validaciones de coherencia (ej. Que una hora de llegada sea posterior a la hora de salida)
    */    
    private final EdificioHelper edificioHelper;
    private Edificio edificio;
    private String palabraBuscada;
    private List<Edificio> resultados;
    private String paramName;
  
    public EdificioUI() {
        edificioHelper = new EdificioHelper();
    }

    @PostConstruct
    public void init() {
        edificio = new Edificio();
        resultados = new ArrayList<>();
        resultados = consultarEdificio();
        paramName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paramName");        
    }

    public void registrarEdificio() throws IOException {
        if (edificio.getClaveEdificio().isEmpty() || edificio.getNombreEdificio().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar", ""));
        }else if (edificio.getClaveEdificio().matches("^[0-9]+$")==false) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La clave del edificio solo debe contener números", ""));
        }else {
            edificioHelper.registrarEdificio(edificio.getClaveEdificio(), edificio.getNombreEdificio());
        }
        resultados = consultarEdificio();
    }

    public List consultarEdificio() {
        return edificioHelper.consultarEdificio();
    }

    public void busquedaDinamica() {
        if(palabraBuscada != null && !palabraBuscada.isEmpty()) {
            try {
                resultados = edificioHelper.consultarEdificioNombreClave(palabraBuscada);
            } catch (Exception e) {

            }
        }else {
            resultados = edificioHelper.consultarEdificio();
        }
    }
    
    public void modificarEdificio() throws IOException{
        if(edificio.getNombreEdificio().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));            
        }else{
            edificioHelper.modificarEdificio(paramName, edificio.getNombreEdificio());
        }        
        resultados =consultarEdificio();       
    }    
        
    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public String getPalabraBuscada() {
        return palabraBuscada;
    }

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

  public List<Edificio> getResultados() {
        return resultados;
    }
    public void setResultados(List<Edificio> resultados) {
        this.resultados = resultados;
    }
    
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
            

     /*public void modificarEdificio() {
    if (edificio.getNombreEdificio().isEmpty()) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar", ""));
    } else {
        int val = edificioHelper.modificarEdificio(edificio.getClaveEdificio(), edificio.getNombreEdificio());
        if (val == 1) {
            Limpiar();
        }
    }
    resultados = consultarEdificio();
}
   */ 

       
}
