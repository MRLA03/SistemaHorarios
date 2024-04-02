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
import mx.dreamcatchersoftware.entidad.Maestro;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.helper.MaestroHelper;

/**
 *
 * @author acer
 */
@ManagedBean(name = "maestroUI")
@SessionScoped
public class MaestroUI {
    private final MaestroHelper maestroHelper;
    private Maestro maestro;
    private String palabraBuscada;
    private List<Maestro> resultados;   
    private String paramName; 
    private int filtrarTipoEmpleado;
    private String tipoEmpleado;
    boolean modificacionExitosa;
    
    public MaestroUI(){
        maestroHelper = new MaestroHelper();        
    }
    
    @PostConstruct
    public void init(){
        maestro= new Maestro();
        resultados = new ArrayList<>();  
        resultados= consultarMaestro();
        paramName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paramName");        
        filtrarTipoEmpleado = -1;
        tipoEmpleado="";
        modificacionExitosa = false;
    }  
    
    public void registrarMaestro() throws IOException{
        Sala ma = new Sala();
        if(maestro.getNEmpleado().isEmpty() || maestro.getNombreMaestro().isEmpty() || maestro.getTipo() ==null || maestro.getHmax()==null){            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else{
            if(maestro.getHrsIE()==null){
                maestro.setHrsIE(0);
            }
            if(maestro.getHrsad()==null){
                maestro.setHrsad(0);
            }
            int val = maestroHelper.registrarMaestro(maestro.getNEmpleado(), maestro.getNombreMaestro(), maestro.getTipo(), maestro.getHrsIE(), maestro.getHrsad(), maestro.getHmax());
            /*if(val==1){
                Limpiar();
            }*/

        }
        resultados=consultarMaestro();
    }
    
    public void modificarMaestro() throws IOException{
        Sala ma = new Sala();
        if(maestro.getNEmpleado().isEmpty() || maestro.getNombreMaestro().isEmpty() || maestro.getTipo() ==null || maestro.getHmax()==null){            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else{
            if(maestro.getHrsIE()==null){
                maestro.setHrsIE(0);
            }
            if(maestro.getHrsad()==null){
                maestro.setHrsad(0);
            }
            int val = maestroHelper.modificarMaestro(maestro.getNEmpleado(), maestro.getNombreMaestro(), maestro.getTipo(), maestro.getHrsIE(), maestro.getHrsad(), maestro.getHmax());
            /*if(val==1){
                modificacionExitosa =true;
                Limpiar();
            }*/

        }
        resultados=consultarMaestro();
    }
    
    public List consultarMaestro(){
        return maestroHelper.consultarMaestro();
    }
    
    public void busquedaDinamica(){
        
        if(palabraBuscada != null && !palabraBuscada.isEmpty()){
            try{
                resultados = maestroHelper.consultarSalaNombreNEmpleado(palabraBuscada);
                if(filtrarTipoEmpleado != -1){
                    resultados = maestroHelper.filtrarMaestroTipoEmpleado(resultados, filtrarTipoEmpleado);
                }
            }catch(Exception e){
                
            }
        }else{
            resultados = maestroHelper.consultarMaestro();
            if(filtrarTipoEmpleado != -1){
                resultados = maestroHelper.filtrarMaestroTipoEmpleado(resultados, filtrarTipoEmpleado);
            }
        }
    }

    public void consultaId(){
        maestro = maestroHelper.consultarMaestroId(paramName);
    }
    
    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public String getPalabraBuscada() {
        return palabraBuscada;
    }

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

    public List<Maestro> getResultados() {
        return resultados;
    }

    public void setResultados(List<Maestro> resultados) {
        this.resultados = resultados;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }      
    
    public String tipoEmpleadoString(){
        String mostrar ="";
        switch(this.maestro.getTipo()){
            case 0:
                mostrar = "Tiempo Completo";
                break;
            case 1:
                mostrar = "Asignatura";
                break;
            case 2:
                mostrar = "Técnico";
                break;
        }
        return mostrar;
    }

    public int getFiltrarTipoEmpleado() {
        return filtrarTipoEmpleado;
    }

    public void setFiltrarTipoEmpleado(int filtrarTipoEmpleado) {
        this.filtrarTipoEmpleado = filtrarTipoEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public boolean isModificacionExitosa() {
        return modificacionExitosa;
    }

    public void setModificacionExitosa(boolean modificacionExitosa) {
        this.modificacionExitosa = modificacionExitosa;
    }
    
    public void limpiar(){
        this.maestro = new Maestro();
    }
}
