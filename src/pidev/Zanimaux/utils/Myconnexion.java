/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.Zanimaux.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Touha
 */
public class Myconnexion {
     public static Myconnexion instance;
    public Connection cnx;

    private Myconnexion() {
        try {
            
                                                  
            String url = "jdbc:mysql://localhost:3306/pet";
            String login = "root";
            String pwd = "";

            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("connextion établie");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return cnx;
    }

    public static Myconnexion getInstance() {
        if (instance == null) {
            instance = new Myconnexion();
        }
        return instance;
    }

}

    

