/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AnimalDAO;
import DAO.DonoDAO;
import Model.Animal;
import Model.Dono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Merenkov
 */
public class Dono_Controller {
    private static Dono dono;
    
    public static void salvar_Dono(String nome, String apelido, String genero, String contacto1, String contacto2, String contacto3, String bairro, String rua, int casa){
        dono = new Dono(nome, apelido, genero, contacto1, contacto2, contacto3, bairro, rua, casa);
        DonoDAO dao = new DonoDAO();
        dao.inserir_Dono(dono);
    }
    
    public static int resgatarIdDono(){
        DonoDAO id = new DonoDAO();
        return id.idDono(dono);
    }
    
    public static ArrayList<String[]> getDonos(){
        DonoDAO dao = new DonoDAO();
        ArrayList<String[]> dadosDn = new ArrayList<>();
        List<Dono> dados = dao.todosDonos();
        
        for (int i = 0; i < dados.size(); i++) {
            String[] a = new String[6];
            
            a[0] = ""+dados.get(i).getIdDono();
            a[1] = dados.get(i).getNome_dono();
            a[2] = dados.get(i).getApelido();
            a[3] = ""+ dados.get(i).getGenero();
            a[4] = dados.get(i).getContacto1();
            a[5] = ""+ dados.get(i).getIdAnimal();
            dadosDn.add(a);
        }
        return dadosDn;
    }
    
   public static ArrayList<String[]> getIdDonos(List<Dono> anPorId){
        AnimalDAO dao = new AnimalDAO();
        ArrayList<String[]> dadosDn = new ArrayList<>();
        List<Dono> dados = anPorId;
        
        for (int i = 0; i < dados.size(); i++) {
            String[] a = new String[6];
            a[0] = ""+dados.get(i).getIdDono();
            a[1] = dados.get(i).getNome_dono();
            a[2] = dados.get(i).getApelido();
            a[3] = ""+ dados.get(i).getGenero();
            a[4] = dados.get(i).getContacto1();
            a[5] = ""+ dados.get(i).getIdAnimal();
            dadosDn.add(a);
        }
        return dadosDn;
    }
    
    public static ArrayList<String[]> pesquisar_Dono(int idDono){
        Dono dono = new Dono();
        dono.setIdDono(idDono);
        DonoDAO dao = new DonoDAO();
        return getIdDonos(dao.getDonosIdDao(dono));
        
    }
    
    public static ArrayList<String[]> pesquisar_Dono(String apelido){
        Dono dono = new Dono();
        dono.setApelido(apelido);
        DonoDAO dao = new DonoDAO();
        return getIdDonos(dao.getDonosApelidoDao(dono));
        
    } 
}
