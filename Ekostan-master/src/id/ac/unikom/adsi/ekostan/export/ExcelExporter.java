/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.ekostan.export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Zmart D3viL
 */
public class ExcelExporter {
    public void exportTable(JTable table, File file, String title, String timeExport) throws IOException {
        TableModel tm = table.getModel();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(title);
        bw.write("\n");
        bw.write( "Di export pada tanggal "+timeExport);
        bw.write("\n\n");
        
        for (int i = 0; i < tm.getColumnCount(); i++) {
            bw.write(tm.getColumnName(i) + "\t");
        }
        bw.write("\n");
        
        for (int i = 0; i < tm.getRowCount(); i++) {
            for (int j = 0; j < tm.getColumnCount(); j++) {
                if (tm.getValueAt(i, j) != null) {
                    bw.write(tm.getValueAt(i, j).toString() + "\t");
                } else {
                    bw.write("f \t");
                }
            }
            bw.write("\n");
        }
        
        bw.close();
        System.out.print("Write out to file " + file);
    }
}
