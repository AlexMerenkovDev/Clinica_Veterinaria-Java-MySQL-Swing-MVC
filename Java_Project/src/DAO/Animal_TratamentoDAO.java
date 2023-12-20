/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Animal;
import Model.Animal_Tratamento;
import Model.Tratamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Merenkov
 */
public class Animal_TratamentoDAO {
    private Connection conexao;
    
    public Animal_TratamentoDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Animal_TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir_idAnimal_idTratamento(Animal_Tratamento animal_Tratamento){
        String sql1 = "INSERT INTO Animal_Tratamento(idAnimal,idTratamento) VALUES(?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql1);
            ps.setInt(1, animal_Tratamento.getIdAnimal());
            ps.setInt(2, animal_Tratamento.getIdTratamento());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void actualizar(Estudante estudante) {
//        try {
//            String sql = "UPDATE estudante SET nome = ?, curso = ? teste1 = ?, teste2 = ? WHERE codigo = ?";
//            PreparedStatement ps = conexao.prepareStatement(sql);
//            ps.setString(1, estudante.getNome());
//            ps.setString(2, estudante.getCurso());
//            ps.setDouble(3, estudante.getTeste1());
//            ps.setDouble(4, estudante.getTeste2());
//            ps.setInt(5, estudante.getCodigo());
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Animal_TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public void apagar (Estudante e){
//        String sql = "DELETE FROM estudante WHERE cartao = ?";
//        try{ 
//            PreparedStatement ps = conexao.prepareStatement(sql);
//            ps.setInt(1, e.getCodigo());
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Animal_TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public List<Animal> todos(){
        try {
            String sql = "SELECT * from Animal";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Animal> lista = new ArrayList<>();
            while(rs.next()){
                Animal an = new Animal();
//                an.setCodigo(rs.getInt("Codigo"));
                 an.setNome_do_animal(rs.getString("Nome"));
//                an.setCurso(rs.getString("Curso"));
//                an.setTeste1(rs.getDouble("Teste1"));
//                an.setTeste2(rs.getDouble("Teste2"));
                lista.add(an);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Animal_TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
