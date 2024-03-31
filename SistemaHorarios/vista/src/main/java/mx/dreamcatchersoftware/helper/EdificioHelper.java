/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.helper;

import java.util.List;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author DELL
 */
public class EdificioHelper {
    public List consultarEdificio(){
        return ServiceFacadeLocator.getInstanceFacadeEdificio().consultarEdificio();
    }
}
