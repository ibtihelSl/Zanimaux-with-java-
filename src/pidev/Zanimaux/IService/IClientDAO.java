/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import pidev.Zanimaux.entities.Client;

/**
 *
 * @author Touha
 */
public interface IClientDAO {
    public void insertC(Client c)throws SQLException;
    public void deleteC(int id)throws SQLException;
    public void updateC(Client c)throws SQLException;
    public void updateCC(Client c)throws SQLException;
    public List<Client> readAll()throws SQLException;
    public Client findByLogin(String log);
    public Client findByName(String nom);
    public Client findByID(int id);
    public ObservableList<Client> getAll();
    
}
