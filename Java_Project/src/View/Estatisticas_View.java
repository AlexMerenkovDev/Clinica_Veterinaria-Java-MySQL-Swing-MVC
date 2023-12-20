package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
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
public class Estatisticas_View extends JFrame {

    private JTable tabela;
    private JScrollPane scroll;
    private JPanel painel, panelTexto;
    private JLabel texto;

    public Estatisticas_View() {
        // tabela = new JTable();
        scroll = new JScrollPane();
        painel = new JPanel();
        panelTexto = new JPanel();
        texto = new JLabel("Estatisticas");
        tabelaEstatistica();
    }

    public void tabelaEstatistica() {
//frame or window
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        // this.show();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
//panel texto
        panelTexto.setBackground(new Color(0, 149, 135, 255));
        panelTexto.setBounds(0, 10, 900, 55);
        //contentPane.add(painelCabecalho);
        panelTexto.setLayout(null);

        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Segoe UI", Font.BOLD, 30));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(300, 6, 350, 57);
        panelTexto.add(texto);

        //panel table
        painel.setLayout(null);
        painel.setBounds(20, 69, 900, 450);
        painel.setLayout(new FlowLayout());
        Border borderT = BorderFactory.createEtchedBorder();
        painel.setBorder(new EmptyBorder(2, 5, 0, 0));
        painel.setBackground(Color.white);

//table
        String colunasNames[] = {"Enfermidades", "Tratamentos Mais Comuns", "Raca Mais Tratada"};
        Object[][] data = {
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null}
        };

        tabela = new JTable(data, colunasNames);
        tabela.setPreferredScrollableViewportSize(new Dimension(700, 60));
        tabela.setFillsViewportHeight(true);
        // tabela.setBackground(Color.red);
        //scroll
        scroll = new JScrollPane(tabela);
        scroll.setBounds(5, 10, 600, 500);
        scroll.setBackground(Color.WHITE);
        painel.add(scroll);

        //frame add
        this.add(panelTexto);
        add(painel);
    }

   
}
