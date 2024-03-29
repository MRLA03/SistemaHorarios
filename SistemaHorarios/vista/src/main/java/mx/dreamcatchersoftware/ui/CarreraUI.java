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
import mx.dreamcatchersoftware.helper.CarreraHelper;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "carreraUI")
@SessionScoped
public class CarreraUI {
    private final CarreraHelper carreraHelper;
    private Carrera carrera;
    private String palabraBuscada;
    private List<Carrera> resultados;
    
    public CarreraUI(){
        carreraHelper = new CarreraHelper();
    }
    
    @PostConstruct
    public void init(){
        carrera= new Carrera();
        resultados = new ArrayList<>();
        resultados=consultarCarrera();
    }

    public void registrarCarrera() throws IOException{
        Carrera ca = new Carrera();
        if(carrera.getClaveCarrera().isEmpty() || carrera.getNombreCarrera().isEmpty() || carrera.getPlan().isEmpty() || carrera.getBancoHoras()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else if(carrera.getNombreCarrera().matches("^[a-zA-Z\\s]+$")==false){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El nombre solo puede tener letras",""));

        }else{
            carreraHelper.registrarCarrera(carrera.getClaveCarrera(), carrera.getNombreCarrera(), carrera.getPlan(), carrera.getBancoHoras());            
        }
        resultados=consultarCarrera();
    }
    
    public List consultarCarrera(){
        return carreraHelper.consultarCarrera();
    }
    
    public void busquedaDinamica(){
        
        if(palabraBuscada != null && !palabraBuscada.isEmpty()){
            try{
                resultados = carreraHelper.consultarCarreraNombreClave(palabraBuscada);
            }catch(Exception e){
                
            }
        }else{
            resultados = carreraHelper.consultarCarrera();
        }
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getPalabraBuscada() {
        return palabraBuscada;
    }

    public List<Carrera> getResultados() {
        return resultados;
    }

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

    public void setResultados(List<Carrera> resultados) {
        this.resultados = resultados;
    }
    
    
    
    
}
