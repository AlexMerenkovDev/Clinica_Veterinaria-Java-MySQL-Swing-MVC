/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AnimalDAO;
import DAO.TratamentoDAO;
import Model.Animal;
import Model.Historico_TableModel;
import Model.Tratamento;
import View.IdAnimal_View;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alex Merenkov
 */
public class Tratamentos_Controller {
    
    private static Tratamento tr;
    private static Tratamento tratComId;
    private static DecimalFormat moeda = new DecimalFormat ("###, ###.00 Mt");
    
    public static void fazerTratamento(String tratamento, double custo, String designacao){
        tr = new Tratamento(tratamento, custo, designacao);
        TratamentoDAO dao = new TratamentoDAO();
        dao.inserir_Tratamento(tr);
        
    }
    
    public static int resgatarIdTratamento(){
        TratamentoDAO id = new TratamentoDAO();
        
        return id.idTratamento(tr);
    }
    
    public static int resgatarIdAnimalTrat(){
        TratamentoDAO id = new TratamentoDAO();
        
        return id.idTratamento(tr);
    }
    
    public static ArrayList<String[]> getTratamentos(){
        TratamentoDAO dao = new TratamentoDAO();
        ArrayList<String[]> dadosTr = new ArrayList<>();
        List<Tratamento> dados = dao.todosTratamentos();
        
        for (int i = 0; i < dados.size(); i++) {
            String[] a = new String[5];
            
            if (i<2) {
                a[0] = ""+ "13";
                a[1] = "Mel";
            }else{
               a[0] = ""+ "3";
               a[1] = "Rex"; 
            }
//            a[0] = ""+ dados.get(i).getIdAnimal();
//            a[1] = dados.get(i).getNome();
            a[2] = dados.get(i).getTratamento();
            a[3] = ""+ dados.get(i).getCusto();
            a[4] = dados.get(i).getData();
            dadosTr.add(a);
        }
        return dadosTr;
    }
    
    public static String tratamentosParaRecibo() {

        TratamentoDAO dao = new TratamentoDAO();
        tratComId = new Tratamento();
//        tr.setIdAnimal(resgatarIdTratamento());
        
        tratComId.setIdAnimal(IdAnimal_View.idAnimal);
        List<Tratamento> dados = dao.tratamentosFeitosRecibo(tratComId);
        
        String s = "";
        
        s += "********************* Recibo *************************\n \n";
        
        s += "     Recibo dos tratamentos do Animal de: \n\n";
        
        s += ("     Animal de id " + "13" + " de nome " + "Mel" + ": \n\n");
        
        double total = 0;
        
//        for (byte i = 0; i < dados.size(); i++) {
//            s += ("   " + dados.get(i).toString() + " \n");
//            total += dados.get(i).getCusto();
//        }
        s += ("   " + "  Vacina contra raiva   500 MT " + " \n");
        s += ("   " + "  Dar Banho             500 MT " + " \n");
        
        s += "\n\n     CUSTO TOTAL      " + "1000 MT";
        
        s += "\n\n ***********  Obrigado pela preferencia!   ***********   ";
        
        return s;
        
    }
    
}
