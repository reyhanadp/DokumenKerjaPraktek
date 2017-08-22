/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.ekostan.dao;

import id.ac.unikom.adsi.ekostan.entity.Pemilik;
import java.util.ArrayList;

/**
 *
 * @author Zmart D3viL
 */
public interface PemilikDAO {
    Pemilik login(String username, String password);
    
}
