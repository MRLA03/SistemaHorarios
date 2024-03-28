/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.ui;

import java.io.IOException;
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

    public CarreraUI(){
        carreraHelper = new CarreraHelper();
    }
    
    @PostConstruct
    public void init(){
        carrera= new Carrera();        
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
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
}
