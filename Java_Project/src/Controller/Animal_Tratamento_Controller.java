/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Animal_TratamentoDAO;
import Model.Animal_Tratamento;




/**
 *
 * @author Alex Merenkov
 */
public class Animal_Tratamento_Controller {
    
    public static void relacionar_Animal_Tratamento(int idAnimal, int idTratamento){
        Animal_Tratamento at = new Animal_Tratamento(idAnimal, idTratamento);
        Animal_TratamentoDAO dao = new Animal_TratamentoDAO();
        dao.inserir_idAnimal_idTratamento(at);
    }
}
