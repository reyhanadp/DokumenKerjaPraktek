/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.ekostan.daoimpl;

import id.ac.unikom.adsi.ekostan.dao.PemilikDAO;
import id.ac.unikom.adsi.ekostan.entity.Pemilik;
import id.ac.unikom.adsi.ekostan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zmart D3viL
 */
public class PemilikDAOImpl implements PemilikDAO {
    private final Connection conn;
    
    public PemilikDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public Pemilik login(String username, String password) {
        Pemilik pemilik = null;
        
        PreparedStatement state = null;
        String SELECT = "SELECT * FROM user WHERE " + 
                "username = ? AND password = ?";
        
        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, username);
            state.setString(2, password);

            ResultSet result = state.executeQuery();
            if (result != null && result.next()) {
                pemilik = new Pemilik();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PemilikDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return pemilik;  

    }
}
