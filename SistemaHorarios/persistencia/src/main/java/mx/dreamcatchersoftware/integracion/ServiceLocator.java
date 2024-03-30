/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.integracion;

import mx.dreamcatchersoftware.DAO.CarreraDAO;
import mx.dreamcatchersoftware.DAO.AsignaturaDAO;
import mx.dreamcatchersoftware.DAO.EdificioDAO;

public class ServiceLocator {

    private static CarreraDAO CarreraDAO;
    private static AsignaturaDAO AsignaturaDAO;
    private static EdificioDAO EdificioDAO;

    public static CarreraDAO getInstanceCarreraDAO() {
        if (CarreraDAO == null) {
            CarreraDAO = new CarreraDAO();
            return CarreraDAO;
        } else {
            return CarreraDAO;
        }
    }

    public static AsignaturaDAO getInstanceAsignaturaDAO() {
        if (AsignaturaDAO == null) {
            AsignaturaDAO = new AsignaturaDAO();
            return AsignaturaDAO;
        } else {
            return AsignaturaDAO;
        }
    }

    public static EdificioDAO getInstanceEdificioDAO() {
        if (EdificioDAO == null) {
            EdificioDAO = new EdificioDAO();
            return EdificioDAO;
        } else {
            return EdificioDAO;
        }
    }

}
