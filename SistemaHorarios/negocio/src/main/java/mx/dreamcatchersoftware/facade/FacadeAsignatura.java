/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import mx.dreamcatchersoftware.delegate.DelegateAsignatura;

/**
 *
 * @author libra
 */
public class FacadeAsignatura {
    private final DelegateAsignatura delegateAsignatura;
    
    public FacadeAsignatura() {
        this.delegateAsignatura = new DelegateAsignatura();
    }
    
    public int registrarAsignatura(String clave_asignatura, String nombre_asignatura, int horas_clase, int horas_taller, int horas_practicas,  int horas_laboratorio){
        return delegateAsignatura.registrarAsignatura(clave_asignatura, nombre_asignatura, horas_clase, horas_taller, horas_practicas, horas_laboratorio);
    }    
    
    
    
}
