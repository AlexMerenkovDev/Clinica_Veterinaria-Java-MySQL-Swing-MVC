/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Tratamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author Alex Merenkov
 */
public class TratamentoDAO {
    
    private Connection conexao;
    
    public TratamentoDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir_Tratamento(Tratamento tratamento){
        String sql1 = "INSERT INTO tratamento(tratamento,custo, designacao) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql1);
            ps.setString(1, tratamento.getTratamento());
            ps.setDouble(2, tratamento.getCusto());
            ps.setString(3, tratamento.getDesignacao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int idTratamento(Tratamento tratamento){
        int a = 0;
        try {
            String sql = "SELECT idTratamento from Tratamento WHERE tratamento = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, tratamento.getTratamento());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                a = rs.getInt("idTratamento");
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
    
    public List<Tratamento> todosTratamentos(){
        try {
            String sql = "SELECT * from tratamentosView";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tratamento> lista = new ArrayList<>();
            while(rs.next()){
                Tratamento tr = new Tratamento();
//                tr.setIdAnimal(rs.getInt("idAnimal"));
//                tr.setNome(rs.getString("Nome"));
                tr.setTratamento(rs.getString("tratamento"));
                tr.setCusto(rs.getDouble("custo"));
                tr.setData(rs.getString("data"));
                lista.add(tr);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<Tratamento> tratamentosFeitos(){
        try {
            String sql = "SELECT * from historico_tratamentos where idAnimal = ? and ";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tratamento> lista = new ArrayList<>();
            while(rs.next()){
                Tratamento tr = new Tratamento();
                tr.setIdAnimal(rs.getInt("idAnimal"));
                tr.setNome(rs.getString("Nome"));
                tr.setTratamento(rs.getString("tratamento"));
                tr.setCusto(rs.getDouble("custo"));
                tr.setData(rs.getString("data"));
                lista.add(tr);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }    
    
    public List<Tratamento> tratamentosFeitosRecibo(Tratamento tratamento){
        try {
            String sql = "SELECT * from tratamentos_feitos where idAnimal = ?";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, tratamento.getIdAnimal());
            ResultSet rs = ps.executeQuery();
            List<Tratamento> lista = new ArrayList<>();
            while(rs.next()){
                Tratamento tr = new Tratamento();
                tr.setIdAnimal(rs.getInt("idAnimal"));
                tr.setNome(rs.getString("Nome"));
                tr.setTratamento(rs.getString("tratamento"));
                tr.setCusto(rs.getDouble("custo"));
                tr.setData(rs.getString("data"));
                lista.add(tr);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }    
    
}
