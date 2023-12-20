/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AnimalDAO;
import DAO.DonoDAO;
import DAO.TratamentoDAO;
import View.Login_View;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Alex Merenkov
 */
public class Executavel {
    public static void main(String[] args) throws IOException {
        
        Login_View lgn = new Login_View();
        lgn.show();
    }
}
