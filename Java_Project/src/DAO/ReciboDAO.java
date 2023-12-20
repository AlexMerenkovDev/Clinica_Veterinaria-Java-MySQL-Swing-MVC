/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author KIP
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import View.Recibo_View;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

public class ReciboDAO {

    private Connection conexao;

    public ReciboDAO() {

        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

//    public void reciboShow() {
//        try {
//            Class.forName("com.mysql.jbdc.Driver");
//            try {
//
//                JasperDesign jpd = JRXmlLoader.load("C:\\Users\\KIP\\Desktop\\VeterinariaGUIv3\\src\\View\\Recibo.java");
//                String sql = "SELECT * from Animal_Dono";
//                JRDesignQuery update = new JRDesignQuery();
//                update.setText(sql);
//                jpd.setQuery(update);
//                JasperReport jr = JasperCompileManager.compileReport(jpd);
//                JasperPrint print = JasperFillManager.fillReport(jr, null, conexao);
//                JasperViewer.viewReport(print);
//            } catch (JRException ex) {
//                Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
