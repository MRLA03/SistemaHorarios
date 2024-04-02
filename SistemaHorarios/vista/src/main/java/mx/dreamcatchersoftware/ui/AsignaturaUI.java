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
import mx.dreamcatchersoftware.entidad.Asignatura;
import mx.dreamcatchersoftware.entidad.Carrera;
import mx.dreamcatchersoftware.helper.AsignaturaHelper;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "asignaturaUI")
@SessionScoped
public class AsignaturaUI {
    private final AsignaturaHelper asignaturaHelper;
    private Asignatura asignatura;
    private String palabraBuscada;
    private List<Asignatura> resultados;
    private String paramName;

    public AsignaturaUI(){
        asignaturaHelper = new AsignaturaHelper();
  }
    
    @PostConstruct
    public void init(){
        asignatura= new Asignatura();
        resultados = new ArrayList<>();
        resultados=consultarAsignatura();        
        paramName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paramName");        
    }

    public void registrarAsignatura() throws IOException{
        Asignatura ca = new Asignatura();
        if(asignatura.getClaveAsignatura().isEmpty() || asignatura.getNombreAsignatura().isEmpty() || asignatura.getHoraClase()==null || asignatura.getHoraTaller()==null || asignatura.getHoraLaboratorio()==null || asignatura.getHoraPractica()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else if(asignatura.getNombreAsignatura().matches("^[\\p{L}a-zA-Z\\s]+$")==false){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El nombre solo puede tener letras",""));

        }else{
            asignaturaHelper.registrarAsignatura(asignatura.getClaveAsignatura(), asignatura.getNombreAsignatura(), asignatura.getHoraClase(), asignatura.getHoraTaller(), asignatura.getHoraPractica(), asignatura.getHoraLaboratorio());            
        }
        resultados=consultarAsignatura();
    }
    
    public List consultarAsignatura(){
        return asignaturaHelper.consultarAsignatura();
    }
    
    public void consultarAsignaturaId(){
        asignatura=asignaturaHelper.consultarAsignaturaId(paramName);
    }
    
    public void busquedaDinamica(){
        
        if(palabraBuscada != null && !palabraBuscada.isEmpty()){
            try{
                resultados = asignaturaHelper.consultarAsignaturaNombreClave(palabraBuscada);
            }catch(Exception e){
                
            }
        }else{
            resultados = asignaturaHelper.consultarAsignatura();
        }
    }

    public void modificarAsignatura() throws IOException{
        if(asignatura.getNombreAsignatura().isEmpty() || asignatura.getHoraClase()==null || asignatura.getHoraTaller()==null || asignatura.getHoraPractica()==null || asignatura.getHoraLaboratorio()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));            
        }else if(asignatura.getNombreAsignatura().matches("^[a-zA-Z\\s]+$")==false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El nombre solo puede tener letras",""));                        
        }else{
            asignaturaHelper.modificarAsignatura(asignatura.getClaveAsignatura(), asignatura.getNombreAsignatura(), asignatura.getHoraClase(), asignatura.getHoraTaller(), asignatura.getHoraPractica(), asignatura.getHoraLaboratorio());
        }        
        resultados=consultarAsignatura();
    }
        
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public String getPalabraBuscada() {
        return palabraBuscada;
    }

    public List<Asignatura> getResultados() {
        return resultados;
    }

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

    public void setResultados(List<Asignatura> resultados) {
        this.resultados = resultados;
    }
    
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }    
    
    public void limpiar(){
        this.asignatura  = new Asignatura();
    }
}