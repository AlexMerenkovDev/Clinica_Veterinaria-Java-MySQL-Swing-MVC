/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AnimalDAO;
import DAO.AnimalDAO;
import Model.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Merenkov
 */
public class Animal_Controller {
    
    private  static List<Animal> todosAnimais;
    
    public static void salvar_Animal(String nome, String cor, String especie, String raca,
            int idade, String genero, int idDono){
        Animal an = new Animal(nome, cor, especie, raca, idade, genero, idDono);
        AnimalDAO dao = new AnimalDAO();
        dao.inserir_Animal(an);
    }
    
    public static boolean verificar_idAnimal(int idAnimal){
        AnimalDAO an = new AnimalDAO();
        
        todosAnimais = an.todosAnimais();
        
        boolean existe = false;
        
        for (int i = 0; i < todosAnimais.size(); i++) {
            if (idAnimal == todosAnimais.get(i).getIdAnimal()) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public static ArrayList<String[]> getAnimais(){
        AnimalDAO dao = new AnimalDAO();
        ArrayList<String[]> dadosAn = new ArrayList<>();
        List<Animal> dados = dao.todosAnimais();
        
        for (int i = 0; i < dados.size(); i++) {
            String[] a = new String[6];
            a[0] = ""+ dados.get(i).getIdAnimal();
            a[1] = dados.get(i).getNome_do_animal();
            a[2] = dados.get(i).getRaca_do_animal();
            a[3] = ""+ dados.get(i).getIdade_do_animal();
            a[4] = dados.get(i).getCor_do_animal();
            a[5] = dados.get(i).getTipo_de_animal();
            dadosAn.add(a);
        }
        return dadosAn;
    }
    
    public static ArrayList<String[]> getIdAnimais(List<Animal> anPorId){
        AnimalDAO dao = new AnimalDAO();
        ArrayList<String[]> dadosAn = new ArrayList<>();
        List<Animal> dados = anPorId;
        
        for (int i = 0; i < dados.size(); i++) {
            String[] a = new String[6];
            a[0] = ""+ dados.get(i).getIdAnimal();
            a[1] = dados.get(i).getNome_do_animal();
            a[2] = dados.get(i).getRaca_do_animal();
            a[3] = ""+ dados.get(i).getIdade_do_animal();
            a[4] = dados.get(i).getCor_do_animal();
            a[5] = dados.get(i).getTipo_de_animal();
            dadosAn.add(a);
        }
        return dadosAn;
    }
    
    public static ArrayList<String[]> pesquisar_Animal(int idAnimal){
        Animal an = new Animal();
        an.setIdAnimal(idAnimal);
        AnimalDAO dao = new AnimalDAO();
//        dao.getIdAnimais(an);
        return getIdAnimais(dao.getIdAnimaisDao(an));
        
    }
    
    public static ArrayList<String[]> pesquisar_Animal(String nome){
        Animal an = new Animal();
        an.setNome_do_animal(nome);
        AnimalDAO dao = new AnimalDAO();
//        dao.getIdAnimais(an);
        return getIdAnimais(dao.getAnimaisNomeDao(an));
        
    }
    
}
