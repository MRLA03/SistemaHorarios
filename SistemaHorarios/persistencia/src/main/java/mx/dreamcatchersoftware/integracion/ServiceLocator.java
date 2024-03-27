/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.integracion;

import mx.dreamcatchersoftware.DAO.CarreraDAO;

public class ServiceLocator {
    private static CarreraDAO CarreraDAO;

    public static CarreraDAO getInstanceCarreraDAO(){
        if(CarreraDAO == null){
            CarreraDAO = new CarreraDAO();
            return CarreraDAO;
        } else{
            return CarreraDAO;
        }
    }       
}
