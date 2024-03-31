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
/**
 *
 * @author DELL
 */
@ManagedBean(name = "edificioUI")
@SessionScoped
public class EdificioUI {
    private final EdificioHelper edificioHelper;
    private Edificio sala;
    private String palabraBuscada;
    private List<Edificio> resultados;    
    
    public EdificioUI(){
        edificioHelper = new EdificioHelper();
    }
    
    @PostConstruct
    public void init(){
        sala= new Edificio();
        resultados = new ArrayList<>();                
    }    
    
    public List consultarEdificio(){
        return edificioHelper.consultarEdificio();
    }
}
