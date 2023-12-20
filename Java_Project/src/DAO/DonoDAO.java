/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Animal;
import Model.Dono;
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
public class DonoDAO {
    private Connection conexao;
    
    public DonoDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir_Dono(Dono dono){
        String sql1 = "INSERT INTO Dono(nome,apelido,genero,Contacto1,Contacto2,Contacto3,Bairro,Rua,Casa) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql1);
            ps.setString(1, dono.getNome_dono());
            ps.setString(2, dono.getApelido());
            ps.setString(3, dono.getGenero());
            ps.setString(4, dono.getContacto1());
            ps.setString(5, dono.getContacto2());
            ps.setString(6, dono.getContacto3());
            ps.setString(7, dono.getBairro());
            ps.setString(8, dono.getRua());
            ps.setInt(9, dono.getCasa());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int idDono(Dono dono){
        int a = 0;
        try {
            String sql = "SELECT idDono from Dono WHERE nome = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, dono.getNome_dono());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                a = rs.getInt("idDono");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
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
    
    public List<Dono> todosDonos(){
        try {
            String sql = "SELECT * from Dono";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Dono> lista = new ArrayList<>();
            while(rs.next()){
                Dono dono = new Dono();
                dono.setIdDono(rs.getInt("idDono"));
                dono.setNome_dono(rs.getString("Nome"));
                dono.setApelido(rs.getString("apelido"));
                dono.setGenero(rs.getString("Genero"));
                dono.setContacto1(rs.getString("Contacto1"));
//                dono.setIdAnimal(rs.getInt("idAnimal"));
                lista.add(dono);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<Dono> getDonosIdDao(Dono dono){
        try {
            String sql = "SELECT * from Dono where idDono = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, dono.getIdDono());
            ResultSet rs = ps.executeQuery();
            List<Dono> lista = new ArrayList<>();
            while(rs.next()){
                Dono d = new Dono();
                d.setIdDono(rs.getInt("idDono"));
                d.setNome_dono(rs.getString("Nome"));
                d.setApelido(rs.getString("apelido"));
                d.setGenero(rs.getString("Genero"));
                d.setContacto1(rs.getString("Contacto1"));
//                d.setIdAnimal(rs.getInt("idAnimal"));
                lista.add(d);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<Dono> getDonosApelidoDao(Dono dono){
        try {
            String sql = "SELECT * from Dono where apelido = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, dono.getApelido());
            ResultSet rs = ps.executeQuery();
            List<Dono> lista = new ArrayList<>();
            while(rs.next()){
                Dono d = new Dono();
                d.setIdDono(rs.getInt("idDono"));
                d.setNome_dono(rs.getString("Nome"));
                d.setApelido(rs.getString("apelido"));
                d.setGenero(rs.getString("Genero"));
                d.setContacto1(rs.getString("Contacto1"));
//                d.setIdAnimal(rs.getInt("idAnimal"));
                lista.add(d);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
}