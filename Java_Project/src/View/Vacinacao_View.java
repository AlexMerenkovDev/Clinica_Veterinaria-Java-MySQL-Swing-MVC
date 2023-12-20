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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
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
public class Vacinacao_View extends JFrame implements ActionListener {

    private JCheckBox vac1, vac2, vac3, vac4;
    private JLabel texto;
    private JPanel painelCheck, painelTexto;
    private JButton okBtn, backBtn;
    private String tratamento1, tratamento2, tratamento3, tratamento4;

    public Vacinacao_View() {
        texto = new JLabel("Escolha os Tipos de Vacinas");
        vac1 = new JCheckBox("Vacina contra Raiva - 500 Mts");
        vac2 = new JCheckBox("vacina multipla - 700 Mts");
        vac3 = new JCheckBox("vacina contra gripe - 200 Mts");
        vac4 = new JCheckBox("Vacinação completa - 1200 Mts");
        okBtn = new JButton("Confirmar");
        backBtn = new JButton("< Voltar");
        painelCheck = new JPanel();
        painelTexto = new JPanel();
        vacin();
    }

    public void vacin() {
        setSize(800, 500);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(247, 247, 242));
        setLocationRelativeTo(null);

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
        texto.setBounds(250, 0, 800, 50);
        texto.setForeground(Color.white);
        texto.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        painelTexto.add(texto);
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
        vac1.setBounds(10, 15, 450, 50);
        vac1.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        vac1.setBackground(new Color(247, 247, 242));
        vac1.setForeground(new Color(ColorSpace.TYPE_BCLR));
        vac1.setHorizontalAlignment(SwingConstants.CENTER);
        
        vac1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == vac1)
                    tratamento1 = (String)vac1.getText();
            }
        });
        
        //

        vac2.setBounds(10, 55, 450, 60);
        vac2.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        vac2.setBackground(new Color(247, 247, 242));
        vac2.setForeground(new Color(ColorSpace.TYPE_BCLR));
        vac2.setHorizontalAlignment(SwingConstants.CENTER);
        
        vac2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == vac2)
                    tratamento2 = (String)vac2.getText();
            }
        });
        
        //
        vac3.setBounds(10, 95, 450, 70);
        vac3.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        vac3.setBackground(new Color(247, 247, 242));
        vac3.setForeground(new Color(ColorSpace.TYPE_BCLR));
        vac3.setHorizontalAlignment(SwingConstants.CENTER);
        
        vac3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == vac3)
                    tratamento3 = (String)vac3.getText();
            }
        });
//  
        vac4.setBounds(10, 140, 450, 80);
        vac4.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        vac4.setBackground(new Color(247, 247, 242));
        vac4.setForeground(new Color(ColorSpace.TYPE_BCLR));
        vac4.setHorizontalAlignment(SwingConstants.CENTER);
        
        vac4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == vac4)
                    tratamento4 = (String)vac4.getText();
            }
        });
        
//eventos
//        vac1.addActionListener(this);
//        vac2.addActionListener(this);
//        vac3.addActionListener(this);
//        vac4.addActionListener(this);
        //
        painelCheck.add(vac1).setFocusable(false);
        painelCheck.add(vac2).setFocusable(false);
        painelCheck.add(vac3).setFocusable(false);
        painelCheck.add(vac4).setFocusable(false);

        //buttons
        okBtn.setBounds(600, 420, 150, 30);
        okBtn.setFocusable(false);
        okBtn.addActionListener(this);

        backBtn.setBounds(430, 420, 150, 30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);

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
                
                if (tratamento1 == vac1.getText()) {
                    Tratamentos_Controller.fazerTratamento("Vacina contra Raiva", 500, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                if (tratamento2 == vac2.getText()) {
                    Tratamentos_Controller.fazerTratamento("vacina multipla", 700, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                if (tratamento3 == vac3.getText()) {
                    Tratamentos_Controller.fazerTratamento("vacina contra gripe", 200, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                if (tratamento4 == vac4.getText()) {
                    Tratamentos_Controller.fazerTratamento("Vacinação completa", 1200, "");
                    Animal_Tratamento_Controller.relacionar_Animal_Tratamento(idAnimal, Tratamentos_Controller.resgatarIdTratamento());
                c++;
                }
                
                if(c != 0){
                    JOptionPane.showMessageDialog(null, "Tratamento Feito Com Sucesso!!", "Vacinado",
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
        new Vacinacao_View();
    }
}
