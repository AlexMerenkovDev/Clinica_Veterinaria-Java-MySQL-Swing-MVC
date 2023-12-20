package View;


import Controller.Animal_Tratamento_Controller;
import Controller.Tratamentos_Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicBorders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KIP
 */
public class Higienizacao_View extends JFrame implements ActionListener {

    private JCheckBox hg1, hg2, hg3, hg4;
    private JLabel textoLbl;
    private JPanel painelCheck, painelTexto;
    private JButton okBtn, backBtn;
    private String tratamento1, tratamento2, tratamento3, tratamento4;

    public Higienizacao_View() {
        textoLbl = new JLabel("Escolha os Tipos de Higienização");
        hg1 = new JCheckBox("Exterminar Pulgas e Caracas - 2000Mt");
        hg2 = new JCheckBox("Cortar Pelos - 1000Mt");
        hg3 = new JCheckBox("Dar Banho - 500Mt");
        hg4 = new JCheckBox("Higienização Completa - 3000Mt");
        okBtn = new JButton("Confirmar");
        backBtn = new JButton("< Voltar");
        painelCheck = new JPanel();
        painelTexto = new JPanel();
        animalHigien();
    }

    public void animalHigien() {
        setSize(800, 500);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(247, 247, 242));
        setLocationRelativeTo(null);

//painel do texto
        painelTexto.setLayout(null);
        painelTexto.setBackground(new Color(0, 149, 135, 255));
        painelTexto.setOpaque(true);
        painelTexto.setForeground(new Color(255, 255, 255));
        //jpTexto.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //jpTexto.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        //   jpTexto.setBorder(borderT);
        painelTexto.setBounds(0, 10, 800, 50);

        //label texto
        textoLbl.setBounds(175, 0, 800, 50);
        textoLbl.setForeground(Color.white);
        textoLbl.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        painelTexto.add(textoLbl);
        //  texto.setFont(new Font("Segoe UI", Font.ITALIC, 25));

        //painel do check button
//        Border border = BorderFactory.createLineBorder(Color.white);
//        painelCheck.setBorder(border);
        painelCheck.setLayout(null);
        painelCheck.setBounds(100, 120, 530, 300);
        //
        painelCheck.setBackground(new Color(247, 247, 242));
        painelCheck.setOpaque(true);
        painelCheck.setForeground(new Color(255, 255, 255));
        painelCheck.setFont(new Font("Arial", Font.BOLD, 20));

//componentes check posicao e type text
        hg1.setBounds(10, 15, 450, 50);
        hg1.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        hg1.setBackground(new Color(247, 247, 242));
        hg1.setForeground(new Color(ColorSpace.TYPE_BCLR));
        hg1.setHorizontalAlignment(SwingConstants.CENTER);
        
        hg1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == hg1)
                    tratamento1 = (String)hg1.getText();
            }
        });
        
        //

        hg2.setBounds(10, 55, 450, 60);
        hg2.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        hg2.setBackground(new Color(247, 247, 242));
        hg2.setForeground(new Color(ColorSpace.TYPE_BCLR));
        hg2.setHorizontalAlignment(SwingConstants.CENTER);
        
        hg2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == hg2)
                    tratamento2 = (String)hg2.getText();
            }
        });
        
        //
        hg3.setBounds(10, 95, 450, 70);
        hg3.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        hg3.setBackground(new Color(247, 247, 242));
        hg3.setForeground(new Color(ColorSpace.TYPE_BCLR));
        hg3.setHorizontalAlignment(SwingConstants.CENTER);
        
        hg3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == hg3)
                    tratamento3 = (String)hg3.getText();
            }
        });
//  
        hg4.setBounds(10, 140, 450, 80);
        hg4.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        hg4.setBackground(new Color(247, 247, 242));
        hg4.setForeground(new Color(ColorSpace.TYPE_BCLR));
        hg4.setHorizontalAlignment(SwingConstants.CENTER);
        
        hg4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == hg4)
                    tratamento4 = (String)hg4.getText();
            }
        });
        
//eventos
        okBtn.addActionListener(this);
        backBtn.addActionListener(this);
        //
        painelCheck.add(hg1).setFocusable(false);
        painelCheck.add(hg2).setFocusable(false);
        painelCheck.add(hg3).setFocusable(false);
        painelCheck.add(hg4).setFocusable(false);

        //buttons
        okBtn.setBounds(600, 420, 150, 30);
        okBtn.setFocusable(false);

        backBtn.setBounds(430, 420, 150, 30);
        backBtn.setFocusable(false);
//add components zone
        add(painelCheck);
        add(painelTexto);
        add(okBtn);
        add(backBtn);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != null) {
            if (e.getSource() == okBtn) {
                JOptionPane.showConfirmDialog(null, "Pretende fazer os tratamentos selecionados?", "Comfirmação", JOptionPane.YES_NO_OPTION);
                
                int c = 0;
                
                int idAnimal =IdAnimal_View.idAnimal;
                
                if (tratamento1 == hg1.getText()) {
                    Tratamentos_Controller.fazerTratamento("Exterminar Pulgas e Caracas", 2000, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                if (tratamento2 == hg2.getText()) {
                    Tratamentos_Controller.fazerTratamento("Cortar Pelos", 1000, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                if (tratamento3 == hg3.getText()) {
                    Tratamentos_Controller.fazerTratamento("Dar Banho", 500, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                if (tratamento4 == hg4.getText()) {
                    Tratamentos_Controller.fazerTratamento("Higienização Completa", 3000, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }

                if(c != 0){
                    JOptionPane.showMessageDialog(null, "Tratamento Feito Com Sucesso!!", "higienizado",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                
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
    
    public static void main(String[] args) {
        new Higienizacao_View();
    }
}
