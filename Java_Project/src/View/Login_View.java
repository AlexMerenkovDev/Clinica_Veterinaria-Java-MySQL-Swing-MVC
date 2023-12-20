package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
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
public class Login_View extends JFrame implements ActionListener {

    private JPanel loginPanel, userPanel, passPanel;
    private JButton btnLogin;
    private JLabel loginLbl, userLbl, passLbl, tituloLbl;
    private JTextField userTextF;
    private JPasswordField passPasswordF;
    private Font ft;
    private Border bd;
    private JCheckBox visible;
    private ImageIcon loginIcon, loginImage;
    private Map<String, String> key;

    public Login_View() throws IOException {
        loginIcon = new ImageIcon("user2.png");
        loginImage = new ImageIcon("user2.png");
        key = new HashMap();
        ft = new Font("Segoe UI", 1, 40);
        visible = new JCheckBox("Mostrar Password");
        loginPanel = new JPanel();
        passPanel = new JPanel();
        userPanel = new JPanel();

        loginLbl = new JLabel();
        tituloLbl = new JLabel("Clinica Veterinaria Animal Feliz");
        userLbl = new JLabel("Usuario");
        passLbl = new JLabel("Senha");

        btnLogin = new JButton("Entrar");

        userTextF = new JTextField(25);
        passPasswordF = new JPasswordField(25);
//        passPasswordF.setPlaceholder("Password");

        janela();
    }

    public void janela() throws IOException {
        // tela
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);
        this.setLayout(null);
        Border borderT = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.white);
        this.setIconImage(loginIcon.getImage());

        //imagem de fundo
        BufferedImage myImage = ImageIO.read(new File("lg.jpg"));
        this.setContentPane(new ImagePanel(myImage));

        //Cabecalho
        tituloLbl.setBounds(200, 25, 700, 100);
        tituloLbl.setFont(ft);
        getContentPane().add(tituloLbl);

        //painel onde temos imagem,usuario, pass e botao
        Border borderT2 = BorderFactory.createEtchedBorder();
        loginPanel.setLayout(null);
        loginPanel.setBounds(350, 150, 300, 300);
        loginPanel.setBorder(borderT);
        loginPanel.setBackground(null);
        loginPanel.setOpaque(false);
        loginPanel.setBorder(borderT2);
        getContentPane().add(loginPanel);

        //imagem painel
        loginLbl.setBounds(85, 1, 150, 160);
        visible.setBounds(40, 230, 140, 20);
        loginLbl.setIcon(loginImage);
        loginLbl.setBackground(Color.white);
        loginLbl.setForeground(Color.white);
        loginLbl.setOpaque(false);
        loginPanel.add(loginLbl);
        loginPanel.add(visible).setFocusable(false);
        visible.addActionListener(this);
        visible.setForeground(Color.WHITE);
        visible.setOpaque(false);
        // getContentPane().add(loginLbl);

        //painel do usuario
        userPanel.setBounds(40, 160, 260, 30);
        userPanel.setBackground(new Color(0, 149, 135, 255));
        userPanel.setLayout(null);
        loginPanel.add(userPanel);
        //getContentPane().add(userPanel);

        userTextF.setBounds(0, 0, 210, 30);
       // userTextF.setOpaque(false);
        userTextF.setToolTipText("Digite o Nome Do Usuario");
        userTextF.setLayout(new BorderLayout());
        userLbl.setForeground(Color.black);
        userTextF.add(userLbl, BorderLayout.LINE_START);
        userTextF.getDocument().addDocumentListener(new Login_View.MyDocumentListener());
        userPanel.setOpaque(false);
        userPanel.add(userTextF);
        

        passPanel.setBounds(40, 200, 260, 30);
        passPanel.setBackground(new Color(0, 149, 135, 255));
        passPanel.setOpaque(false);
        
        passPanel.setLayout(null);
        loginPanel.add(passPanel);

        passPasswordF.setBounds(0, 0, 210, 30);
      //  passPasswordF.setOpaque(false);
        passPasswordF.setLayout(new BorderLayout());
        passPasswordF.add(passLbl, BorderLayout.LINE_START);
        passPasswordF.setToolTipText("Digite a Senha Do Usuario");
        passPasswordF.getDocument().addDocumentListener(new Login_View.MyDocumentListener());
        passPanel.add(passPasswordF);
        // passPanel.add(visible);
        // usuarios
        key.put("Kevin Uqueio", "Sembozakura");
        key.put("alex", "123456");
        key.put("Win Savanguana", "Elica06");
        key.put("Shola Eliana", "Mario");
        key.put("Bernadino Dino", "Papa Formigas");
        key.put("Amelia Languelo", "Golpista");
        key.put("", "");

        //botao confirmar
        btnLogin.addActionListener(this);
       //  btnLogin.setBackground(Color.white);
        btnLogin.setBounds(40, 250, 210, 30);
        btnLogin.setBackground(new Color(0, 149, 135, 255));
        btnLogin.setForeground(Color.black);
//        btnLogin.setOpaque(false);
        loginPanel.add(btnLogin);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // if (e.getSource() == visible) {
            if (visible.isSelected() == true) {
                passPasswordF.setEchoChar((char)0);
            } else if (visible.isSelected() == false) {
                passPasswordF.setEchoChar('*');
            }

        

        String pass = String.valueOf(passPasswordF.getPassword());

        if (e.getSource() == btnLogin) {
            if (key.containsKey(userTextF.getText().trim())) {
                if (key.get(userTextF.getText()).equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Login Feito Com Sucesso!!", "Acesso Permitido",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    TelaInicial_View tInicial;
                    try {
                        tInicial = new TelaInicial_View();
                        this.setVisible(false);
                        tInicial.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Login_View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha Errada", "Acesso Negado",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Username e/ou Senha Errada\nTente Novamente!!!!", "Acesso Negado",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public static class ImagePanel extends JComponent {

        private Image image;

        public ImagePanel(Image image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public static void main(String[] args) throws IOException {
        new Login_View().show();
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
            if ((doc.getLength() != 0) && (doc.equals(userTextF.getDocument()))) {
                userLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(passPasswordF.getDocument()))) {
                passLbl.setVisible(false);
            }

        }
    }

}
