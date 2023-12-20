package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KIP
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Tratamentos_View extends JFrame implements ActionListener {

    private JLabel imagemFundo, labelImagem;
    private JPanel contentPane, painelCabecalho, painelVaci, painelHigie, painelCheck, painelDiagn;
    private JButton vacinacao, higienizacao, check, diagnostico, back;
    // public Tratamentos tarefa;

    Image img = Toolkit.getDefaultToolkit().getImage("vac.jpg");

    public Tratamentos_View() throws IOException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(990, 745);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        
        contentPane = new JPanel();
        labelImagem = new JLabel();
        painelVaci = new JPanel();
        //tarefa = new Tratamentos();
//        BufferedImage myImage = ImageIO.read(new File("boggy.jpg"));
//        this.setContentPane(new Login.ImagePanel(myImage));
//        //
//        
//  // public SwingDemo() throws IOException {
//      this.setContentPane(new JPanel() {
//         @Override
//         public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//             
//            g.drawImage(img, 0, 0, null);
//         }
//      });
//        ///
        contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
//        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*  
        Painel onde tem o cabeçalho
         */
        painelCabecalho = new JPanel();
        painelCabecalho.setBackground(new Color(0, 149, 135, 255));
        painelCabecalho.setBounds(0, 26, 974, 80);
        contentPane.add(painelCabecalho);
        painelCabecalho.setLayout(null);

        JLabel tema = new JLabel("Escolha o Tipo de Tratamento");
        tema.setForeground(Color.WHITE);
        tema.setFont(new Font("Segoe UI", Font.BOLD, 30));
        tema.setHorizontalAlignment(SwingConstants.CENTER);
        tema.setBounds(110, 10, 749, 57);;
        painelCabecalho.add(tema);

        painelVaci = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        painelVaci.setOpaque(false);
        painelVaci.setBackground(new Color(0, 0, 0, 80));
        painelVaci.setBounds(120, 140, 253, 247);
        painelVaci.setLayout(null);
        contentPane.add(painelVaci);

        vacinacao = new JButton("Vacinação", new ImageIcon("vac2.png"));
        vacinacao.setFont(new Font("Segoe UI", Font.BOLD, 25));
        vacinacao.setHorizontalAlignment(SwingConstants.CENTER);
        vacinacao.setHorizontalTextPosition(JLabel.CENTER);
        vacinacao.setVerticalTextPosition(JLabel.BOTTOM);
        vacinacao.setBounds(0, 0, 253, 247);
        vacinacao.setFocusable(true);
        vacinacao.setForeground(Color.WHITE);
        vacinacao.setBorder(new EmptyBorder(0, 0, 0, 0));
        vacinacao.setBackground(Color.black);
        vacinacao.setFocusPainted(false);
        vacinacao.setBorderPainted(false);
        vacinacao.setOpaque(false);
        painelVaci.add(vacinacao);

        painelHigie = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        painelHigie.setOpaque(false);
        painelHigie.setBackground(new Color(0, 0, 0, 80));
        painelHigie.setBounds(580, 140, 253, 247);
        painelHigie.setLayout(null);
        contentPane.add(painelHigie);

        higienizacao = new JButton("Higienização", new ImageIcon("handwash.png"));
        higienizacao.setFont(new Font("Segoe UI", Font.BOLD, 25));
        higienizacao.setHorizontalAlignment(SwingConstants.CENTER);
        higienizacao.setHorizontalTextPosition(JLabel.CENTER);
        higienizacao.setVerticalTextPosition(JLabel.BOTTOM);
        higienizacao.setBounds(0, 0, 253, 247);
        higienizacao.setFocusable(true);
        higienizacao.setForeground(Color.WHITE);
        higienizacao.setBorder(new EmptyBorder(0, 0, 0, 0));
        higienizacao.setBackground(Color.black);
        higienizacao.setFocusPainted(false);
        higienizacao.setBorderPainted(false);
        higienizacao.setOpaque(false);
        painelHigie.add(higienizacao);

        painelCheck = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        painelCheck.setOpaque(false);
        painelCheck.setBackground(new Color(0, 0, 0, 80));
        painelCheck.setBounds(580, 400, 253, 247);
        painelCheck.setLayout(null);
        contentPane.add(painelCheck);

        check = new JButton("Imprimir Recibo", new ImageIcon("receipt.png"));
        check.setFont(new Font("Segoe UI", Font.BOLD, 25));
        check.setHorizontalAlignment(SwingConstants.CENTER);
        check.setHorizontalTextPosition(JLabel.CENTER);   //           
        check.setVerticalTextPosition(JLabel.BOTTOM);
        check.setBounds(0, 0, 253, 247);
        check.setFocusable(true);
        check.setForeground(Color.WHITE);
        check.setBorder(new EmptyBorder(0, 0, 0, 0));
        check.setBackground(Color.black);
        check.setFocusPainted(false);
        check.setBorderPainted(false);
        check.setOpaque(false);
        painelCheck.add(check);

        ///
        painelDiagn = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        painelDiagn.setOpaque(false);
        painelDiagn.setBackground(new Color(0, 0, 0, 80));
        painelDiagn.setBounds(120, 400, 253, 247);
        painelDiagn.setLayout(null);
        contentPane.add(painelDiagn);

        diagnostico = new JButton("Diagnostico", new ImageIcon("check.png"));
        diagnostico.setFont(new Font("Segoe UI", Font.BOLD, 25));
        diagnostico.setHorizontalAlignment(SwingConstants.CENTER);
        diagnostico.setHorizontalTextPosition(JLabel.CENTER);   //           
        diagnostico.setVerticalTextPosition(JLabel.BOTTOM);
        diagnostico.setBounds(0, 0, 253, 215);
        diagnostico.setFocusable(true);
        diagnostico.setForeground(Color.WHITE);
        diagnostico.setBorder(new EmptyBorder(0, 0, 0, 0));
        diagnostico.setBackground(Color.black);
        diagnostico.setFocusPainted(false);
        diagnostico.setBorderPainted(false);
        diagnostico.setOpaque(false);
        painelDiagn.add(diagnostico);

        ///eventos
        diagnostico.addActionListener(this);
        vacinacao.addActionListener(this);
        higienizacao.addActionListener(this);
        check.addActionListener(this);
        ///

//butao voltar
        back = new JButton("< Voltar");
        back.setBounds(410, 666, 150, 30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vacinacao) {
            setVisible(false);
            Vacinacao_View vc = new Vacinacao_View();

        }
        if (e.getSource() == check) {
            dispose();
            Recibo_View rc = new Recibo_View();
            rc.setLocationRelativeTo(null);
            rc.setVisible(true);
        }
        if (e.getSource() == higienizacao) {
            dispose();
            Higienizacao_View hg = new Higienizacao_View();
            hg.setLocationRelativeTo(null);
            hg.setVisible(true);
        }
        if (e.getSource() == diagnostico) {
            dispose();
            DiagnosticoTrat_View dg = new DiagnosticoTrat_View();
            dg.setLocationRelativeTo(null);
            dg.setVisible(true);
        }
        if(e.getSource()==back){
            try {
                TelaInicial_View tl = new TelaInicial_View();
                dispose();
                tl.setLocationRelativeTo(null);
                tl.show();
            } catch (IOException ex) {
                Logger.getLogger(Tratamentos_View.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    public static void main(String[] args) throws IOException {
        new Tratamentos_View();
    }
    
}
