/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.ekostan.tablemodel;

import id.ac.unikom.adsi.ekostan.entity.Penyewa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Zmart D3viL
 */
public class PenyewaTM extends AbstractTableModel{
    private ArrayList<Penyewa> arrayPenyewa;

    public void setArrayPenyewa(ArrayList<Penyewa> arrayPenyewa) {
        this.arrayPenyewa = arrayPenyewa;
    }
    
    @Override
    public int getRowCount() {
        return arrayPenyewa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPenyewa.get(rowIndex).getIdPenyewa();
            case 1:
                return arrayPenyewa.get(rowIndex).getNamaPenyewa();
            case 2:
                return arrayPenyewa.get(rowIndex).getJenisKelamin();
            case 3:
                return arrayPenyewa.get(rowIndex).getAlamat();
            case 4:
                return arrayPenyewa.get(rowIndex).getNoTelp();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Penyewa";
            case 1:
                return "Nama Penyewa";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Alamat";
            case 4:
                return "No Telepon";
        }
        return null;
    }
    
    
}
