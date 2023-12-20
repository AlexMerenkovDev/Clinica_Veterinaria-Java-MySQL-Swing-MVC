/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alex Merenkov
 */
public class Animal_Tratamento {
    private int idAnimal;
    private int idTratamento;

    public Animal_Tratamento(int idAnimal, int idTratamento) {
        this.idAnimal = idAnimal;
        this.idTratamento = idTratamento;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }
    
}
