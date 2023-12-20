/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Tratamentos_Controller;
import DAO.TratamentoDAO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex Merenkov
 */
public class Historico_TableModel extends AbstractTableModel{

    private DecimalFormat moeda = new DecimalFormat ("###, ###.00 Mt");
    TratamentoDAO dao = new TratamentoDAO();
    
    ArrayList<String[]> dados = Tratamentos_Controller.getTratamentos();
    String colunasNames[] = {"id do animal", "Nome do animal", "tratamento", "Custo", "Data"};

    
    
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
        }
        return null;
    }
    
    public void addLinha(String[] t){
        this.dados.add(t);
        this.fireTableDataChanged();
        
    }
    
}
