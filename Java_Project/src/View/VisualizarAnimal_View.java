package View;

import Controller.Animal_Controller;
import Model.Animal_TableModel;
import Model.Historico_TableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KIP
 */
public class VisualizarAnimal_View extends JFrame implements ActionListener {

    private JTable tabela, tabela1;
    private JScrollPane scroll, scroll1;
    private JPanel painel, panelTexto;
    private JTextField pesTextF;
    private JLabel texto, IdMsgLbl, NomeMsgLbl, NotMsgLbl;
    private JButton seachBtn;
    private JButton backBtn;
    private JComboBox dados;
    Animal_TableModel tableModel;

    public VisualizarAnimal_View() {
        // tabela = new JTable();
        scroll = new JScrollPane();
        painel = new JPanel();
        panelTexto = new JPanel();
        texto = new JLabel("Pesquisar Animal");
        backBtn = new JButton("< Voltar");
        tabelaVisualizar();
    }

    public void tabelaVisualizar() {
//frame or window
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        // this.show();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);
//panel texto
        panelTexto.setBackground(new Color(0, 149, 135, 255));
        panelTexto.setBounds(0, 10, 900, 105);
        //contentPane.add(painelCabecalho);
        panelTexto.setLayout(null);

        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Segoe UI", Font.BOLD, 30));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(20, 6, 350, 57);
        panelTexto.add(texto);

        //comboBox
        String see[] = {"<Pesquisar Animal através ...>", "ID", "Nome"};

        dados = new JComboBox(see);
        dados.setBounds(370, 60, 200, 35);
        dados.setBackground((Color.WHITE));
        dados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dados.addActionListener(this);
        panelTexto.add(dados);

        //   botaoMsg
        NotMsgLbl = new JLabel("<- Nao selecionado");
        NotMsgLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        NotMsgLbl.setBackground(new Color(0, 149, 135, 255));

        IdMsgLbl = new JLabel("ID");
        IdMsgLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        IdMsgLbl.setBackground(new Color(0, 149, 135, 255));

        NomeMsgLbl = new JLabel("Nome");
        NomeMsgLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        NomeMsgLbl.setBackground(new Color(0, 149, 135, 255));

        pesTextF = new JTextField();
        pesTextF.setLayout(new BorderLayout());
        pesTextF.add(NotMsgLbl, BorderLayout.LINE_START);
        pesTextF.setEnabled(false);
        pesTextF.setBackground(Color.LIGHT_GRAY);
        pesTextF.getDocument().addDocumentListener(new MyDocumentListener());
        pesTextF.setBounds(580, 60, 130, 35);
        pesTextF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelTexto.add(pesTextF);

        seachBtn = new JButton("Search", new ImageIcon("Search-icon.png"));
        seachBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        seachBtn.setFocusable(false);
        seachBtn.setBounds(720, 60, 130, 35);
        seachBtn.setBackground(Color.white);
        seachBtn.setForeground(new Color(0, 149, 135, 255));
        seachBtn.setEnabled(false);
        seachBtn.addActionListener(this);
        panelTexto.add(seachBtn);

        //panel table
        painel.setLayout(null);
        painel.setBounds(5, 119, 900, 450);
        painel.setLayout(new FlowLayout());
        Border borderT = BorderFactory.createEtchedBorder();
        painel.setBorder(new EmptyBorder(2, 5, 0, 0));
        painel.setBackground(Color.white);

//table
        tableModel = new Animal_TableModel(Animal_Controller.getAnimais());
        tabela = new JTable();
        tabela.setModel(tableModel);
        tabela.setAutoCreateRowSorter(true);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tabela.setRowHeight(29);
        tabela.setPreferredScrollableViewportSize(new Dimension(800, 340));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabela.setDefaultRenderer(String.class, centerRenderer);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tabela.setPreferredScrollableViewportSize(new Dimension(800, 340));
        

        //scroll
        scroll = new JScrollPane(tabela);
        scroll.setBounds(5, 60, 600, 500);
        scroll.setBackground(Color.WHITE);
        painel.add(scroll);

        //button
        backBtn.setBounds(355, 515, 150, 30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        this.add(backBtn);

        //frame add
        this.add(panelTexto);
        this.add(painel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seachBtn) {
            if (dados.getSelectedItem().equals("ID")) {

                tableModel = new Animal_TableModel(Animal_Controller.pesquisar_Animal(Integer.parseInt(pesTextF.getText())));
                tabela.setModel(tableModel);

            } else if (dados.getSelectedItem().equals("Nome")) {
                tableModel = new Animal_TableModel(Animal_Controller.pesquisar_Animal(pesTextF.getText()));
                tabela.setModel(tableModel);
            }

        }

        if (e.getSource() == backBtn) {
            dispose();
            try {
                TelaInicial_View ti = new TelaInicial_View();
                ti.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Vacinacao_View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (dados.getSelectedItem().equals("ID")) {

            pesTextF.setEnabled(true);
            NotMsgLbl.setVisible(false);
            NomeMsgLbl.setVisible(false);
            pesTextF.add(IdMsgLbl, BorderLayout.LINE_START);
//            IdMsgLbl.setVisible(true);
            pesTextF.setBackground(Color.WHITE);
            seachBtn.setEnabled(true);
        } else if (dados.getSelectedItem().equals("Nome")) {
            pesTextF.setEnabled(true);
            NotMsgLbl.setVisible(false);
            IdMsgLbl.setVisible(false);
            pesTextF.add(NomeMsgLbl, BorderLayout.LINE_START);
//            NomeMsgLbl.setVisible(true);
            pesTextF.setBackground(Color.WHITE);
            seachBtn.setEnabled(true);
        } else {
            tableModel = new Animal_TableModel(Animal_Controller.getAnimais());
            tabela.setModel(tableModel);
            IdMsgLbl.setVisible(false);
            NomeMsgLbl.setVisible(false);
            pesTextF.add(NotMsgLbl, BorderLayout.LINE_START);
            NotMsgLbl.setVisible(true);
            pesTextF.setEnabled(false);
            pesTextF.setBackground(Color.LIGHT_GRAY);
            seachBtn.setEnabled(false);
        }
    }

    private class MyDocumentListener implements DocumentListener {

        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "inserted into");
        }

        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removed from");
        }

        public void changedUpdate(DocumentEvent e) {
        }

        public void updateLog(DocumentEvent e, String action) {
            Document doc = (Document) e.getDocument();

            if ((doc.getLength() != 0) && (doc.equals(pesTextF.getDocument()))) {
                IdMsgLbl.setVisible(false);
                NomeMsgLbl.setVisible(false);
            } 
//            else if ((doc.getLength() != 0) && (doc.equals(pesTextF.getDocument()))) {
//                NomeMsgLbl.setVisible(false);
//            }

//            else if ((doc.getLength() == 0) && (doc.equals(pesTextF.getDocument()))) {
//                IdMsgLbl.setVisible(true);
//            } else if ((doc.getLength() == 0) && (doc.equals(pesTextF.getDocument()))) {
//                NomeMsgLbl.setVisible(true);
//            }
        }
    }

    public static void main(String[] args) {
        new VisualizarAnimal_View();
    }

}
