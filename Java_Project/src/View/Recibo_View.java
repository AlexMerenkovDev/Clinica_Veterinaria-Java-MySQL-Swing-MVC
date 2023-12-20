/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Tratamentos_Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import DAO.ReciboDAO;

/**
 *
 * @author Win Savanguana
 */
public class Recibo_View extends JFrame implements ActionListener {

    private JButton print, back;
    private JPanel painel, painelcima;
    private JTextArea text;
    private JLabel label;
    private Font ft;

    Recibo_View() {
        label = new JLabel("Recibo");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 30));
        label.setBounds(230, 20, 100, 25);

        text = new JTextArea(Tratamentos_Controller.tratamentosParaRecibo(), 12, 15);
        text.setBounds(65, 0, 425, 360);
        text.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        print = new JButton(" Imprimir ");
        print.setBounds(470, 375, 100, 25);
        print.setFocusable(false);
        print.addActionListener(this);

        back = new JButton(" Voltar ");
        back.setBounds(363, 375, 100, 25);
        back.setFocusable(false);
        back.addActionListener(this);

        painelcima = new JPanel();
        painelcima.setBackground(new Color(0, 149, 135, 255));
        painelcima.setLayout(null);
        painelcima.setBounds(0, 25, 600, 75);
        painelcima.add(label);

        painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 130, 600, 400);
        painel.add(text);
        painel.add(print);
        painel.add(back);

        this.setTitle("Recibo");
        this.add(painelcima);
        this.add(painel);
        this.setLayout(null);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Recibo_View p = new Recibo_View();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            try {
                dispose();
                Tratamentos_View tr = new Tratamentos_View();
                tr.show();
                tr.setLocationRelativeTo(null);

            } catch (IOException ex) {
                Logger.getLogger(Recibo_View.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(e.getSource()==print){
            
        }

    }
 

}
