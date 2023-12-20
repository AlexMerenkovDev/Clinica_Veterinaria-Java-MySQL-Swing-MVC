/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Alex
 */
public class Animal implements Serializable{
   
   private int idAnimal;
   private String nome_do_animal;
   private String cor_do_animal;
   private String tipo_de_animal;
   private String raca_do_animal;
   private int idade_do_animal;
   private int id_do_Dono;
   private String genero_do_animal;
//   private int idDono;
   
//    public Animal(String nome_do_animal, String cor_do_animal, String tipo_de_animal, String raca_do_animal, int idade_do_animal, String genero_do_animal, int idDono) {
//        
//        this.nome_do_animal = nome_do_animal;
//        this.cor_do_animal = cor_do_animal;
//        this.tipo_de_animal = tipo_de_animal;
//        this.raca_do_animal = raca_do_animal;
//        this.idade_do_animal = idade_do_animal;
//        this.genero_do_animal = genero_do_animal;
//        this.idDono = idDono;
//    }

    
//    private void calcPrecTotal() {
//        float soma = 0;
//        
//        for (byte i=0; i<tratamento.size(); i++) {
//            soma += tratamento.elementAt(i).getPrecoTratam();
//        }
//        precoTotal = soma;
//    }

    public Animal(String nome, String cor, String especie, String raca, int idade, String genero, int idDono) {
        this.nome_do_animal = nome;
        this.cor_do_animal = cor;
        this.tipo_de_animal = especie;
        this.raca_do_animal = raca;
        this.idade_do_animal = idade;
        this.genero_do_animal = genero;
        this.id_do_Dono = idDono;
    }
    
    public Animal() {
        
    }
    
     public String getNome_do_animal() {
        return nome_do_animal;
    }

    public void setNome_do_animal(String nome_do_animal) {
        this.nome_do_animal = nome_do_animal;
    }

    public String getCor_do_animal() {
        return cor_do_animal;
    }

    public void setCor_do_animal(String cor_do_animal) {
        this.cor_do_animal = cor_do_animal;
    }

    public String getTipo_de_animal() {
        return tipo_de_animal;
    }

    public void setTipo_de_animal(String tipo_de_animal) {
        this.tipo_de_animal = tipo_de_animal;
    }

    public String getRaca_do_animal() {
        return raca_do_animal;
    }

    public void setRaca_do_animal(String raca_do_animal) {
        this.raca_do_animal = raca_do_animal;
    }

    public int getIdade_do_animal() {
        return idade_do_animal;
    }

    public void setIdade_do_animal(byte idade_do_animal) {
        this.idade_do_animal = idade_do_animal;
    }

    public String getGenero_do_animal() {
        return genero_do_animal;
    }

    public void setGenero_do_animal(String genero_do_animal) {
        this.genero_do_animal = genero_do_animal;
    }

    public int getId_do_Dono() {
        return id_do_Dono;
    }

    public void setId_do_Dono(int id_do_Dono) {
        this.id_do_Dono = id_do_Dono;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    
    
    public String toString (){
        return "\n=========== DADOS do Animal ============\n"
                +"\n idAnimal: "+idAnimal
                +"\n Nome do animal: "+nome_do_animal
                +"\n Cor do animal: "+cor_do_animal
                +"\n Tipo do animal: "+tipo_de_animal
                +"\n Raca do animal: "+raca_do_animal
                +"\n Idade do animal: "+idade_do_animal
                +"\n Gênero do animal: "+genero_do_animal
                +"\n idDono: "+id_do_Dono;
    }
   
}
