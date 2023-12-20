/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalDAO {
    private Connection conexao;
    
    public AnimalDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir_Animal(Animal animal){
        String sql1 = "INSERT INTO animal(nome,genero,especie,raca,cor,idade,idDono) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql1);
            ps.setString(1, animal.getNome_do_animal());
            ps.setString(2, animal.getGenero_do_animal());
            ps.setString(3, animal.getTipo_de_animal());
            ps.setString(4, animal.getRaca_do_animal());
            ps.setString(5, animal.getCor_do_animal());
            ps.setInt(6, animal.getIdade_do_animal());
            ps.setInt(7, animal.getId_do_Dono());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public List<Animal> todosAnimais(){
        try {
            String sql = "SELECT * from Animal";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Animal> lista = new ArrayList<>();
            while(rs.next()){
                Animal an = new Animal();
                an.setIdAnimal(rs.getInt("idAnimal"));
                an.setNome_do_animal(rs.getString("Nome"));
                an.setGenero_do_animal(rs.getString("Genero"));
                an.setTipo_de_animal(rs.getString("especie"));
                an.setRaca_do_animal(rs.getString("raca"));
                an.setCor_do_animal(rs.getString("cor"));
                an.setIdade_do_animal(rs.getByte("idade"));
                an.setId_do_Dono(rs.getInt("idDono"));
                lista.add(an);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<Animal> getIdAnimaisDao(Animal animal){
        try {
            String sql = "SELECT * from Animal where idAnimal = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, animal.getIdAnimal());
            ResultSet rs = ps.executeQuery();
            List<Animal> lista = new ArrayList<>();
            while(rs.next()){
                Animal an = new Animal();
                an.setIdAnimal(rs.getInt("idAnimal"));
                an.setNome_do_animal(rs.getString("Nome"));
                an.setGenero_do_animal(rs.getString("Genero"));
                an.setTipo_de_animal(rs.getString("especie"));
                an.setRaca_do_animal(rs.getString("raca"));
                an.setCor_do_animal(rs.getString("cor"));
                an.setIdade_do_animal(rs.getByte("idade"));
                an.setId_do_Dono(rs.getInt("idDono"));
                lista.add(an);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<Animal> getAnimaisNomeDao(Animal animal){
        try {
            String sql = "SELECT * from Animal where nome = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, animal.getNome_do_animal());
            ResultSet rs = ps.executeQuery();
            List<Animal> lista = new ArrayList<>();
            while(rs.next()){
                Animal an = new Animal();
                an.setIdAnimal(rs.getInt("idAnimal"));
                an.setNome_do_animal(rs.getString("Nome"));
                an.setGenero_do_animal(rs.getString("Genero"));
                an.setTipo_de_animal(rs.getString("especie"));
                an.setRaca_do_animal(rs.getString("raca"));
                an.setCor_do_animal(rs.getString("cor"));
                an.setIdade_do_animal(rs.getByte("idade"));
                an.setId_do_Dono(rs.getInt("idDono"));
                lista.add(an);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
}


