/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.ekostan.daoimpl;

import id.ac.unikom.adsi.ekostan.dao.PenyewaDAO;
import id.ac.unikom.adsi.ekostan.entity.Penyewa;
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
public class PenyewaDAOImpl implements PenyewaDAO {
    
    private final Connection conn;

    public PenyewaDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Penyewa> getPenyewa() {
        return getPenyewa(null);
    }

    @Override
    public ArrayList<Penyewa> getPenyewa(String namaPenyewa) {
        ArrayList<Penyewa> arrayPenyewa = null;
        PreparedStatement state = null;
        
        boolean isSearching = namaPenyewa != null && !namaPenyewa.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM penyewa WHERE nama_penyewa LIKE ?";
        } else {
            SELECT = "SELECT * FROM penyewa";
        }
        
        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, namaPenyewa + "%");
            }
            
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPenyewa = new ArrayList<>();
                
                while (result.next()) {
                    Penyewa penyewa = new Penyewa();
                    penyewa.setIdPenyewa(result.getString(1));
                    penyewa.setNamaPenyewa(result.getString(2));
                    penyewa.setJenisKelamin(result.getString(3));
                    penyewa.setAlamat(result.getString(4));
                    penyewa.setNoTelp(result.getString(5));
                    
                    arrayPenyewa.add(penyewa);
                }
            }
            
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return arrayPenyewa;
    }

    @Override
    public boolean tambah(String idPenyewa, String namaPenyewa, String jenisKelamin, String alamat, String noTelp) {
        String INSERT = "INSERT INTO penyewa "
                + "(id_penyewa, nama_penyewa, jenis_kelamin, alamat, no_telp) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, idPenyewa);
            state.setString(2, namaPenyewa);
            state.setString(3, jenisKelamin);
            state.setString(4, alamat);
            state.setString(5, noTelp);
            
            int result = state.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    @Override
    public boolean update(String idPenyewa, String namaPenyewa, String jenisKelamin, String alamat, String noTelp) {
        String UPDATE = "UPDATE penyewa "
                + "SET nama_penyewa = ?, jenis_kelamin = ? , "
                + "alamat = ?, no_telp = ? WHERE id_penyewa = ? ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(5, idPenyewa);
            state.setString(1, namaPenyewa);
            state.setString(2, jenisKelamin);
            state.setString(3, alamat);
            state.setString(4, noTelp);            

            int result = state.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    @Override
    public boolean delete(String idPenyewa) {
        String DELETE = "DELETE FROM penyewa WHERE id_penyewa = ?";
        PreparedStatement pst = null;
        
        try {
            pst = conn.prepareStatement(DELETE);
            pst.setString(1, idPenyewa);

            int qty = pst.executeUpdate();
            return qty > 0;
        } catch (SQLException e) {
            Logger.getLogger(PenyewaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
}
