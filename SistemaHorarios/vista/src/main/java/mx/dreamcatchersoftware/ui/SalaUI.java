package mx.dreamcatchersoftware.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.dreamcatchersoftware.entidad.Sala;
import mx.dreamcatchersoftware.helper.SalaHelper;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "salaUI")
@SessionScoped
public class SalaUI {
    private final SalaHelper salaHelper;
    private Sala sala;
    private String palabraBuscada;
    private List<Sala> resultados;   
    private String paramName;
    private int filtrarEdificio;
    
    public SalaUI(){
        salaHelper = new SalaHelper();        
    }
    
    @PostConstruct
    public void init(){
        sala= new Sala();
        resultados = new ArrayList<>();  
        resultados=consultarSala();
        paramName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paramName");
        filtrarEdificio=-1;
    }

    public void registrarSala() throws IOException{
        Sala sa = new Sala();
        if(sala.getNombreSala().isEmpty() || sala.getCapacidad()==null || sala.getIdEdificio()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else{
            int val = salaHelper.registrarSala(sala.getNombreSala(), sala.getCapacidad(), sala.getIdEdificio(), sala.getNota());
            if(val==1){
                Limpiar();
            }

        }
        resultados=consultarSala();
    }
    
    public void modificarSala() {
        Sala sa = new Sala();
        if(sala.getNombreSala().isEmpty() || sala.getCapacidad()==null || sala.getIdEdificio()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Faltan campos por llenar",""));
        }else{
            int val = salaHelper.modificarSala(sala.getIdSala(),sala.getNombreSala(), sala.getCapacidad(), sala.getIdEdificio(), sala.getNota());
            if(val==1){
                Limpiar();
            }
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
                if(filtrarEdificio != -1){
                    resultados = salaHelper.filtrarSalaEdificio(resultados, filtrarEdificio);
                }
            }catch(Exception e){
                
            }
        }else{
            resultados = salaHelper.consultarSala();
            if(filtrarEdificio != -1){
                resultados = salaHelper.filtrarSalaEdificio(resultados, filtrarEdificio);
            }
        }
    }

    public void consultaId(){
        sala = salaHelper.consultarSalaId(paramName);
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

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public int getFiltrarEdificio() {
        return filtrarEdificio;
    }

    public void setFiltrarEdificio(int filtrarEdificio) {
        this.filtrarEdificio = filtrarEdificio;
    }
    
    public void Limpiar(){
        this.sala = new Sala();
    }    
}
