package View;

import Controller.Animal_Tratamento_Controller;
import Controller.Tratamentos_Controller;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
public class DiagnosticoTrat_View extends JFrame implements ActionListener {

    private JLabel textoLbl, sintomasLbl, precoLbl, doencaLbl;
    private JTextField precoTextF, doencaTextF;
    private JTextArea sintomasTextArea;
    private JPanel painel, painelTexto, painelSintomas;
    private JButton okBtn, backBtn;
    private JScrollPane ScrPane;

    public DiagnosticoTrat_View() {
        //paineis
        painel = new JPanel();
        painelSintomas = new JPanel();
        painelTexto = new JPanel();
        
        //labels
        textoLbl = new JLabel("Diagnóstico");
        sintomasLbl = new JLabel("");
        precoLbl = new JLabel("Preco");
        doencaLbl = new JLabel("Doenca");
        
        //TextFields
        doencaTextF = new JTextField(20);
        precoTextF = new JTextField(20);
        sintomasTextArea = new JTextArea(15, 6);
        
        ScrPane = new JScrollPane(sintomasTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //buttons
        okBtn = new JButton("Confirmar");
        backBtn = new JButton("< Voltar");

        //frame
        setSize(690, 500);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(247, 247, 242));
        setLocationRelativeTo(null);
        //  show();

        //label do texto
        painelTexto.setLayout(null);
        painelTexto.setBackground(new Color(0, 149, 135, 255));
        painelTexto.setOpaque(true);
        painelTexto.setForeground(new Color(255, 255, 255));
        //jpTexto.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //jpTexto.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        //   jpTexto.setBorder(borderT);
        painelTexto.setBounds(0, 10, 800, 50);

        //label texto
        textoLbl.setBounds(250, 0, 800, 50);
        textoLbl.setForeground(Color.white);
        textoLbl.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        painelTexto.add(textoLbl);
        
        add(painelTexto);
        
        //painel doenca
        Border bdr = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        TitledBorder borderT = BorderFactory.createTitledBorder(bdr,"Dados do Dignostico", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Segoe UI Historic", Font.BOLD, 14), Color.black);
        painel.setBounds(60, 70, 550, 330);
        painel.setBorder(borderT);
        painel.setBackground(Color.WHITE);
        painel.setLayout(null);

//doenca 
        doencaTextF.setLayout(new BorderLayout());
        doencaTextF.add(doencaLbl, BorderLayout.LINE_START);
        doencaTextF.setBounds(20, 40, 200, 30);
        doencaTextF.setToolTipText("Digite a Doenca De Acordo Com o Diagnostico");
        doencaTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
        
        doencaLbl.setFont(new Font("Time New Roman", Font.PLAIN, 14));
        doencaLbl.setForeground(Color.DARK_GRAY);
        doencaTextF.getDocument().addDocumentListener(new DiagnosticoTrat_View.MyDocumentListener());
        painel.add(doencaTextF);

//preco
        precoTextF.setLayout(new BorderLayout());
        precoTextF.add(precoLbl, BorderLayout.LINE_START);
        precoTextF.setToolTipText("Digite o Preco do Diagnostico");
        precoTextF.setBounds(20, 80, 200, 30);
        precoTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
        
        precoLbl.setFont(new Font("Times new Roman", Font.PLAIN, 12));
        precoLbl.setFont(new Font("Time New Roman", Font.PLAIN, 14));
        precoLbl.setForeground(Color.DARK_GRAY);
        precoTextF.getDocument().addDocumentListener(new DiagnosticoTrat_View.MyDocumentListener());
        painel.add(precoTextF);

//sintomas
        TitledBorder borderA = BorderFactory.createTitledBorder(bdr,"Sintomas", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Segoe UI Historic", Font.BOLD, 14), Color.black);
        sintomasTextArea.setBorder(borderA);
        sintomasTextArea.setLayout(new BorderLayout());
        sintomasTextArea.setToolTipText("Digite Os Sintomas Do Animal");
        sintomasTextArea.add(sintomasLbl, BorderLayout.CENTER);
        sintomasTextArea.setBounds(80, 120, 400, 180);
        sintomasTextArea.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
        

        painel.add(sintomasTextArea);
        painel.add(ScrPane);

        //button save  
        Border borderB = BorderFactory.createEmptyBorder();
        okBtn.setBounds(350, 415, 150, 30);
//        okBtn.setBackground(Color.WHITE);
//        okBtn.setFocusable(false);
//        okBtn.setBorder(borderB);
        okBtn.addActionListener(this);
        add(okBtn);

        //buton bk
//        backBtn.setBounds(200, 350, 70, 30);
//        backBtn.setBackground(Color.WHITE);
//        backBtn.setFocusable(false);
//        backBtn.setBorder(borderB);
        

        backBtn.setBounds(190, 415, 150, 30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        add(backBtn);

        this.add(painel);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != null) {
            if (e.getSource() == okBtn) {
                JOptionPane.showConfirmDialog(null, "Pretende guardar o diagnóstico?", "Comfirmação", JOptionPane.YES_NO_OPTION);

                int idAnimal = IdAnimal_View.idAnimal;

                
                Tratamentos_Controller.fazerTratamento("diagnóstico", Double.parseDouble(precoTextF.getText()), sintomasTextArea.getText());
                Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());

                JOptionPane.showMessageDialog(null, "Diagnostico Feito Com Sucesso!!", "Diagnosticado",
                            JOptionPane.INFORMATION_MESSAGE);
                
                try {
                    dispose();
                    new Tratamentos_View().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Higienizacao_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (e.getSource() == backBtn) {
                dispose();
                try {
                    Tratamentos_View tr = new Tratamentos_View();
                    tr.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Vacinacao_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // class para remocao do label
    private class MyDocumentListener implements DocumentListener {

        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "inserted into");
        }

        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removed from");
        }

        public void changedUpdate(DocumentEvent e) {
        }

        private void updateLog(DocumentEvent e, String action) {
            Document doc = (Document) e.getDocument();
            if ((doc.getLength() != 0) && (doc.equals(doencaTextF.getDocument()))) {
                doencaLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(precoTextF.getDocument()))) {
                precoLbl.setVisible(false);
            }

        }
    }

    
}
