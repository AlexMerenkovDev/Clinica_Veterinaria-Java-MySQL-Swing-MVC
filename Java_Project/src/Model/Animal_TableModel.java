/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Animal_Controller;
import DAO.AnimalDAO;
import DAO.TratamentoDAO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex Merenkov
 */
public class Animal_TableModel extends AbstractTableModel {

    
    private ArrayList<String[]> dados;
    private String colunasNames[] =  {"ID", "Nome do Animal", "Raca", "idade", "Cor", "Tipo"};

    public Animal_TableModel(ArrayList<String[]> dados) {
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
    
    public void addLinha(String[] a){
        this.dados.add(a);
        this.fireTableDataChanged();
        
    }
}
