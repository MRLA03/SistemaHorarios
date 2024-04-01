/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@ManagedBean(name = "edificioUI")
@SessionScoped
public class EdificioUI {
    private final EdificioHelper edificioHelper;
    private Edificio edificio;
    private String palabraBuscada;
    private List<Edificio> resultados;
  private String paramNameC;
  
    public EdificioUI() {
        edificioHelper = new EdificioHelper();
    }

    @PostConstruct
    public void init() {
        edificio = new Edificio();
        resultados = new ArrayList<>();
        resultados = consultarEdificio();
         paramNameC = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paramNameC");        
  }

    public void registrarEdificio() throws IOException {
        if (edificio.getClaveEdificio().isEmpty() || edificio.getNombreEdificio().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar", ""));
        }
        else if (!edificio.getClaveEdificio().matches("^[0-9]+$")) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La clave del edificio solo debe contener números", ""));
        } 
 //       else if(!edificio.getClaveEdificio().isEmpty()){
   //      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "la clave del edificio esta repetido", ""));
          
     //   }
        
        else {
            edificioHelper.registrarEdificio(edificio.getClaveEdificio(), edificio.getNombreEdificio());
        }
        resultados = consultarEdificio();
    }

    public List consultarEdificio() {
        return edificioHelper.consultarEdificio();
    }

    public void busquedaDinamica() {
        if (palabraBuscada != null && !palabraBuscada.isEmpty()) {
            try {
                resultados = edificioHelper.consultarEdificioNombreClave(palabraBuscada);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resultados = edificioHelper.consultarEdificio();
        }
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
    
      public String getParamNameC() {
        return paramNameC;
    }

    public void setParamNameC(String paramNameC) {
        this.paramNameC = paramNameC;
    }
    
     /*    
     public void modificarEdificio() throws IOException{
        if(edificio.getNombreEdificio().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));            
        }else{
            edificioHelper.modificarEdificio(paramNameC, edificio.getNombreEdificio());
        }        
        resultados =consultarEdificio();
       
    }

     public void modificarEdificio() {
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