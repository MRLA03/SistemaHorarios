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
import mx.dreamcatchersoftware.entidad.Carrera;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.helper.SalaHelper;

/**
 *
 * @author acer
 */
@ManagedBean(name = "salaUI")
@SessionScoped
public class SalaUI {
    private final SalaHelper salaHelper;
    private Sala sala;
    private String palabraBuscada;
    private List<Sala> resultados;    
    
    public SalaUI(){
        salaHelper = new SalaHelper();
    }
    
    @PostConstruct
    public void init(){
        sala= new Sala();
        resultados = new ArrayList<>();                
    }

    public void registrarSala() throws IOException{
        Sala sa = new Sala();
        if(sala.getNombreSala().isEmpty() || sala.getCapacidad()==null || sala.getIdEdificio()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else{
            salaHelper.registrarSala(sala.getNombreSala(), sala.getCapacidad(), sala.getIdEdificio(), sala.getNota());
        }
        resultados=consultarSala();
    }
    
    public List consultarSala(){
        return salaHelper.consultarSala();
    }
    
    public void busquedaDinamica(){
        
        if(palabraBuscada != null && !palabraBuscada.isEmpty()){
            try{
                resultados = salaHelper.consultarSalaNombreClave(palabraBuscada);
            }catch(Exception e){
                
            }
        }else{
            resultados = salaHelper.consultarSala();
        }
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getPalabraBuscada() {
        return palabraBuscada;
    }

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

    public List<Sala> getResultados() {
        return resultados;
    }

    public void setResultados(List<Sala> resultados) {
        this.resultados = resultados;
    }

       
}
