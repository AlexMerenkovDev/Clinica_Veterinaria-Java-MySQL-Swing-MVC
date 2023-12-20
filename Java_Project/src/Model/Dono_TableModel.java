/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Animal_Controller;
import Controller.Dono_Controller;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Dono_TableModel extends AbstractTableModel {
    
    ArrayList<String[]> dados = Dono_Controller.getDonos();
    String colunasNames[] = {"ID", "Nome do Dono", "Apelido", "Genero", "Contacto", "Id do Animal"};

    public Dono_TableModel(ArrayList<String[]> dados) {
        this.dados = dados;
    }
    
    @Override
    public String getColumnName(int coluna) {
        return colunasNames[coluna];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunasNames.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        String a[] = dados.get(linha);
        
        switch(coluna){
            case 0:
                return a[0];
            case 1:
                return a[1];
            case 2:
                return a[2];
            case 3:
                return a[3];
            case 4:
                return a[4];
            case 5:
                return a[5];
        }
        return null;
    }
    
    public void addLinha(String[] d){
        this.dados.add(d);
        this.fireTableDataChanged();
        
    }
}
