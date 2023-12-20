package View;

import Controller.Animal_Tratamento_Controller;
import Controller.Tratamentos_Controller;
import DAO.TratamentoDAO;
import Model.Historico_TableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KIP
 */
public class Historico_View extends JFrame  implements ActionListener {

    private JTable tabela;
    private JScrollPane scroll;
    private JPanel painel, panelTexto;
    private JLabel texto;
    private JButton backBtn;
    Historico_TableModel tableModel;

    public Historico_View() {

        // tabela = new JTable();
        scroll = new JScrollPane();
        painel = new JPanel();
        panelTexto = new JPanel();
        texto = new JLabel("Historico de Tratamentos");
        backBtn = new JButton("< Voltar");
        tabelaHistorico();
    }

    public void tabelaHistorico() {
//frame or window
        this.setSize(900, 650);
        this.setLocationRelativeTo(null);
        // this.show();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.white);
//panel texto
        panelTexto.setBackground(new Color(0, 149, 135, 255));
        panelTexto.setBounds(0, 10, 900, 70);
        //contentPane.add(painelCabecalho);
        panelTexto.setLayout(null);

        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Segoe UI", Font.BOLD, 30));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(230, 3, 400, 57);
        panelTexto.add(texto);

        //panel table
        painel.setLayout(null);
        painel.setBounds(0, 90, 900, 450);
        painel.setLayout(new FlowLayout());
        Border borderT = BorderFactory.createEtchedBorder();
        painel.setBorder(new EmptyBorder(2, 5, 0, 0));
        painel.setBackground(Color.white);

//table
        
        tableModel = new Historico_TableModel();
        tabela = new JTable();
        tabela.setModel(tableModel);
        tabela.setAutoCreateRowSorter(true);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tabela.setRowHeight(29);
        tabela.setPreferredScrollableViewportSize(new Dimension(800, 400));

//scroll
        scroll = new JScrollPane(tabela);
        scroll.setBounds(0, 10, 600, 500);
        scroll.setBackground(Color.WHITE);
        painel.add(scroll);

        //frame add
        this.add(panelTexto);
        this.add(painel);
        this.setVisible(true);
//        Tratamentos_Controller.preecherTabela();

//button
        backBtn.setBounds(355, 550, 150, 30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        this.add(backBtn);
    }

    public static void main(String[] args) {
        new Historico_View();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
            dispose();
            try {
                TelaInicial_View ti = new TelaInicial_View();
                ti.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Vacinacao_View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

