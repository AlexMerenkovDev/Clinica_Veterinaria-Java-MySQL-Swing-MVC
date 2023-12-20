package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dinod
 */
public class Dono {
    
    private int idDono;
    private String nome_dono;
    private String apelido;
    private String genero;
    private String contacto1;
    private String contacto2;
    private String contacto3;
    private String bairro;
    private String rua;
    private int casa;
    private int idAnimal;

    public Dono(String nome, String apelido, String genero, String contacto1, String contacto2, String contacto3, String bairro, String rua, int casa) {
        this.nome_dono = nome;
        this.apelido = apelido;
        this.genero = genero;
        this.contacto1 = contacto1;
        this.contacto2 = contacto2;
        this.contacto3 = contacto3;
        this.bairro = bairro;
        this.rua = rua;
        this.casa = casa;
    }
    
    public Dono() {
       
    }

    public void setNome_dono(String nome_dono) {
        this.nome_dono = nome_dono;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setContacto1(String contacto1) {
        this.contacto1 = contacto1;
    }

    public void setContacto2(String contacto2) {
        this.contacto2 = contacto2;
    }

    public void setContacto3(String contacto3) {
        this.contacto3 = contacto3;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }

    
    public String getApelido() {
        return apelido;
    }

    
    
    
    public String getNome_dono(){
        return nome_dono;
    }
    public String getGenero(){
        return genero;
    }
    public String getContacto1(){
        return contacto1;
    }
    public String getContacto2(){
        return contacto2;
    }
    public String getContacto3(){
        return contacto3;
    }
    public String getBairro(){
        return bairro;
    }
    public String getRua(){
        return rua;
    }
    public int getCasa(){
        return casa;
    }
    
    
  
    public void setNome_dono(){
        this.nome_dono=nome_dono;
    }
    public void setGenero_dono(){
        this.genero=genero;
    }
    public void setContacto1(){
        this.contacto1=contacto1;
    }
    public void setContacto2(){
        this.contacto2=contacto2;
    }
    public void setContacto3(){
        this.contacto3=contacto3;
    }
    public void setBairro(){
        this.bairro=bairro;
    }
    public void setRua(){
        this.rua=rua;
    }
    public void setCasa(){
        this.casa=casa;
    }
}