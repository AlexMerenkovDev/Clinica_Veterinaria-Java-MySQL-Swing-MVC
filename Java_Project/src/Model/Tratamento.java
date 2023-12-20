package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dinod
 */
import java.security.Timestamp;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Tratamento {
    
    private int idAnimal;
    private String nome;
    private int idTratamento;
    private double custo;
    private String data;
    private String tratamento;
    private String designacao;
    private DecimalFormat moeda = new DecimalFormat ("###, ###.00 Mt");


    public Tratamento(String tratamento, double custo, String designacao) {
        this.custo = custo;
        this.tratamento = tratamento;
        this.designacao = designacao;
    }

    public Tratamento() {
        
    }
    
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    public int getIdTratamento(){
        return idTratamento;
    }
    public double getCusto(){
        return custo;
    }
    
    public String getTratamento(){
        return tratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "  " + tratamento + "                custo: " + moeda.format(custo);
    }

    

    

    

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
    
}
