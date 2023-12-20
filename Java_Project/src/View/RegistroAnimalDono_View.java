package View;

import Controller.Dono_Controller;
import Controller.Animal_Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
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
public class RegistroAnimalDono_View extends JFrame implements ActionListener {

    private JLabel nome_donoLbl, apelido_donoLbl, nome_animalLbl, racaLbl, corLbl, generoLbl_animal, generoLbl_dono, idadeLbl,
            bairroLbl, avenidaLbl, casaLbl, contacto1Lbl_1, contacto2Lbl_1, contacto3Lbl_1, contacto1Lbl_2, contacto2Lbl_2, contacto3Lbl_2;
    private JTextField nome_donoTextF, apelido_donoTextF, nome_animaTextF, corTextF, racaTextF, bairroTextF, avenidaTextF,
            casaTextF, contacto1TextF, contacto2TextF, contacto3TextF;
    private JPanel dados_donoPanel, dados_animalPanel, painelCabecalho;
    private JButton registarBtn, voltarBtn;
    private JRadioButton genero_animalRB_F, genero_animalRB_M, genero_donoRB_F, genero_donoRB_M;
    private ButtonGroup RBgroup_animal, RBgroup_dono;
    private JSpinner idade_Spinner;
    private JComboBox especie_animalCBox;
    private String especie, genero_animal, genero_dono;

    public RegistroAnimalDono_View() {

        Janela();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void Janela() {
        setSize(1000, 700);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

//Titulo
        painelCabecalho = new JPanel();
        painelCabecalho.setBackground(new Color(0, 149, 135, 255));
        painelCabecalho.setBounds(0, 10, 1000, 70);
        painelCabecalho.setLayout(null);
        add(painelCabecalho);

        JLabel tema = new JLabel("Registro dos Dados");
        tema.setForeground(Color.WHITE);
        tema.setFont(new Font("Segoe UI", Font.BOLD, 30));
        tema.setBounds(350, 7, 749, 57);
        painelCabecalho.add(tema);

//DADOS DO ANIMAL
        //painel dados animal
        Border bdr = BorderFactory.createLineBorder(Color.BLACK, 1);
        TitledBorder borderT = BorderFactory.createTitledBorder(bdr, "Dados do Animal", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Segoe UI Historic", Font.BOLD, 16), Color.black);
        dados_animalPanel = new JPanel();
        dados_animalPanel.setBounds(65, 100, 870, 200);
        dados_animalPanel.setBorder(borderT);
        dados_animalPanel.setLayout(null);
//        dados_animalPanel.setBackground(Color.white);

        //nome animal textField
        nome_animaTextF = new JTextField();
        nome_animaTextF.setBounds(15, 50, 220, 30);
        nome_animaTextF.setLayout(new BorderLayout());
        nome_animaTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        nome_animalLbl = new JLabel("Nome");
        nome_animalLbl.setForeground(Color.DARK_GRAY);
        nome_animalLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        nome_animaTextF.add(nome_animalLbl, BorderLayout.LINE_START);
        nome_animaTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_animalPanel.add(nome_animaTextF);

        //raca textField
        racaTextF = new JTextField();
        racaTextF.setBounds(15, 130, 150, 30);
        racaTextF.setLayout(new BorderLayout());
        racaTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        racaLbl = new JLabel("Raça");
        racaLbl.setForeground(Color.DARK_GRAY);
        racaLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        racaTextF.add(racaLbl, BorderLayout.LINE_START);
        racaTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_animalPanel.add(racaTextF);

        //Cor JTextField
        corTextF = new JTextField();
        corTextF.setBounds(520, 50, 200, 30);
        corTextF.setLayout(new BorderLayout());
        corTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        corLbl = new JLabel("Cor");
        corLbl.setForeground(Color.DARK_GRAY);
        corLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        corTextF.add(corLbl, BorderLayout.LINE_START);
        corTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_animalPanel.add(corTextF);

        //Especie JComboBox
        String tipo_animais[] = {"<Especie do animal>", "Cão", "Gato", "Pássaro", "Roedor"};
        especie_animalCBox = new JComboBox(tipo_animais);
        especie_animalCBox.setBounds(280, 50, 180, 30);
        especie_animalCBox.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        especie_animalCBox.setBackground(Color.WHITE);
        dados_animalPanel.add(especie_animalCBox);

        ItemListener listen = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == especie_animalCBox) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        especie = (String) e.getItem();
                    }
                }
            }
        };
        especie_animalCBox.addItemListener(listen);

        //idade Spinner
        idadeLbl = new JLabel("Idade");
        idadeLbl.setForeground(Color.BLACK);
        idadeLbl.setBounds(290, 130, 50, 30);
        idadeLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_animalPanel.add(idadeLbl);

        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 30, 1);
        idade_Spinner = new JSpinner(model);
        idade_Spinner.setBounds(350, 130, 50, 30);
        idade_Spinner.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_animalPanel.add(idade_Spinner);

        //genero animal
        generoLbl_animal = new JLabel("Gênero: ");
        generoLbl_animal.setForeground(Color.BLACK);
        generoLbl_animal.setBounds(500, 130, 60, 30);
        generoLbl_animal.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_animalPanel.add(generoLbl_animal);

        genero_animalRB_F = new JRadioButton("F");
        genero_animalRB_F.setBounds(630, 130, 50, 30);
        genero_animalRB_F.setBackground(Color.white);
        genero_animalRB_F.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_animalPanel.add(genero_animalRB_F);

        genero_animalRB_M = new JRadioButton("M");
        genero_animalRB_M.setBounds(580, 130, 50, 30);
        genero_animalRB_M.setBackground(Color.white);
        genero_animalRB_M.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_animalPanel.add(genero_animalRB_M);

        RBgroup_animal = new ButtonGroup();
        RBgroup_animal.add(genero_animalRB_M);
        RBgroup_animal.add(genero_animalRB_F);
        genero_animalRB_M.setSelected(true);

        genero_animalRB_M.setActionCommand("M");
        genero_animalRB_F.setActionCommand("F");

//DADOS DO DONO
        //painel dados Dono
        TitledBorder borderT_dono = BorderFactory.createTitledBorder(bdr, "Dados do Dono", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Segoe UI Historic", Font.BOLD, 16), Color.black);
        dados_donoPanel = new JPanel();
        dados_donoPanel.setBounds(65, 340, 870, 200);
        dados_donoPanel.setBorder(borderT_dono);
        dados_donoPanel.setLayout(null);
//        dados_donoPanel.setBackground(Color.white);

        //nome dono textField
        nome_donoTextF = new JTextField();
        nome_donoTextF.setBounds(15, 50, 150, 30);
        nome_donoTextF.setLayout(new BorderLayout());
        nome_donoTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        nome_donoLbl = new JLabel("Nome");
        nome_donoLbl.setForeground(Color.DARK_GRAY);
        nome_donoLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        nome_donoTextF.add(nome_donoLbl, BorderLayout.LINE_START);
        nome_donoTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(nome_donoTextF);

        //Apelido dono textField
        apelido_donoTextF = new JTextField();
        apelido_donoTextF.setBounds(200, 50, 150, 30);
        apelido_donoTextF.setLayout(new BorderLayout());
        apelido_donoTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        apelido_donoLbl = new JLabel("Apelido");
        apelido_donoLbl.setForeground(Color.DARK_GRAY);
        apelido_donoLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        apelido_donoTextF.add(apelido_donoLbl, BorderLayout.LINE_START);
        apelido_donoTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(apelido_donoTextF);

        //genero dono
        generoLbl_dono = new JLabel("Gênero: ");
        generoLbl_dono.setForeground(Color.BLACK);
        generoLbl_dono.setBounds(380, 50, 60, 30);
        generoLbl_dono.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_donoPanel.add(generoLbl_dono);

        genero_donoRB_M = new JRadioButton("M");
        genero_donoRB_M.setBounds(460, 50, 50, 30);
        genero_donoRB_M.setBackground(Color.white);
        genero_donoRB_M.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_donoPanel.add(genero_donoRB_M);

        genero_donoRB_F = new JRadioButton("F");
        genero_donoRB_F.setBackground(Color.white);
        genero_donoRB_F.setBounds(510, 50, 50, 30);
        genero_donoRB_F.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_donoPanel.add(genero_donoRB_F);

        RBgroup_dono = new ButtonGroup();
        RBgroup_dono.add(genero_donoRB_M);
        RBgroup_dono.add(genero_donoRB_F);
        genero_donoRB_M.setSelected(true);

        genero_donoRB_M.setActionCommand("M");
        genero_donoRB_F.setActionCommand("F");

        //contacto 1 textField
        contacto1Lbl_2 = new JLabel("Contacto-1");
        contacto1Lbl_2.setBounds(580, 50, 80, 30);
        contacto1Lbl_2.setForeground(Color.DARK_GRAY);
        contacto1Lbl_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_donoPanel.add(contacto1Lbl_2);

        contacto1TextF = new JTextField();
        contacto1TextF.setBounds(670, 50, 150, 30);
        contacto1TextF.setLayout(new BorderLayout());
        contacto1TextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        contacto1Lbl_1 = new JLabel("+258");
        contacto1Lbl_1.setForeground(Color.DARK_GRAY);
        contacto1Lbl_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        contacto1TextF.add(contacto1Lbl_1, BorderLayout.LINE_START);
        contacto1TextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(contacto1TextF);

        //contacto 2 textField
        contacto2Lbl_2 = new JLabel("Contacto-2");
        contacto2Lbl_2.setBounds(580, 100, 80, 30);
        contacto2Lbl_2.setForeground(Color.DARK_GRAY);
        contacto2Lbl_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_donoPanel.add(contacto2Lbl_2);

        contacto2TextF = new JTextField();
        contacto2TextF.setBounds(670, 100, 150, 30);
        contacto2TextF.setLayout(new BorderLayout());
        contacto2TextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        contacto2Lbl_1 = new JLabel("+258(opcional)");
        contacto2Lbl_1.setForeground(Color.DARK_GRAY);
        contacto2Lbl_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        contacto2TextF.add(contacto2Lbl_1, BorderLayout.LINE_START);
        contacto2TextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(contacto2TextF);

        //contacto 3 textField
        contacto3Lbl_2 = new JLabel("Contacto-3");
        contacto3Lbl_2.setBounds(580, 150, 80, 30);
        contacto3Lbl_2.setForeground(Color.DARK_GRAY);
        contacto3Lbl_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        dados_donoPanel.add(contacto3Lbl_2);

        contacto3TextF = new JTextField();
        contacto3TextF.setBounds(670, 150, 150, 30);
        contacto3TextF.setLayout(new BorderLayout());
        contacto3TextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        contacto3Lbl_1 = new JLabel("+258(opcional)");
        contacto3Lbl_1.setForeground(Color.DARK_GRAY);
        contacto3Lbl_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        contacto3TextF.add(contacto3Lbl_1, BorderLayout.LINE_START);
        contacto3TextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(contacto3TextF);

        //Bairro textField
        bairroTextF = new JTextField();
        bairroTextF.setBounds(15, 100, 300, 30);
        bairroTextF.setLayout(new BorderLayout());
        bairroTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        bairroLbl = new JLabel("Bairro");
        bairroLbl.setForeground(Color.DARK_GRAY);
        bairroLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        bairroTextF.add(bairroLbl, BorderLayout.LINE_START);
        bairroTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(bairroTextF);

        //Avenida textField
        avenidaTextF = new JTextField();
        avenidaTextF.setBounds(15, 150, 300, 30);
        avenidaTextF.setLayout(new BorderLayout());
        avenidaTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        avenidaLbl = new JLabel("Avenida");
        avenidaLbl.setForeground(Color.DARK_GRAY);
        avenidaLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        avenidaTextF.add(avenidaLbl, BorderLayout.LINE_START);
        avenidaTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(avenidaTextF);

        //Casa textField
        casaTextF = new JTextField();
        casaTextF.setBounds(350, 150, 100, 30);
        casaTextF.setLayout(new BorderLayout());
        casaTextF.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        casaLbl = new JLabel("Casa");
        casaLbl.setForeground(Color.DARK_GRAY);
        casaLbl.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        casaTextF.add(casaLbl, BorderLayout.LINE_START);
        casaTextF.getDocument().addDocumentListener(new MyDocumentListener());
        dados_donoPanel.add(casaTextF);

        add(dados_animalPanel);
        add(dados_donoPanel);

//Botoes
        //registrar
        registarBtn = new JButton("Registar");
        registarBtn.setBounds(800, 600, 150, 30);
        Border bdr_Btn = BorderFactory.createLineBorder(Color.BLUE, 1);
        registarBtn.setBorder(bdr_Btn);
        registarBtn.setLayout(new BorderLayout());
        registarBtn.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        registarBtn.addActionListener(this);
        add(registarBtn);

        //registrar
        voltarBtn = new JButton("< Voltar");
        voltarBtn.setBounds(640, 600, 150, 30);
        voltarBtn.setLayout(new BorderLayout());
        voltarBtn.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        voltarBtn.addActionListener(this);
        add(voltarBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Botao voltar
        if (e.getSource() == voltarBtn) {
            try {
                TelaInicial_View ti = new TelaInicial_View();
                ti.setVisible(true);
                ti.setLocationRelativeTo(null);
            } catch (IOException ex) {
                Logger.getLogger(RegistroAnimalDono_View.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }

        //Botao registrar
        if (e.getSource() == registarBtn) {
            //Animal nome em branco

            if (nome_animaTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Nome Do Animal Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //raca
            if (racaTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Raca Introduzida ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //cor
            if (corTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Cor do Animal Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //nome dono
            if (nome_animaTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Nome Do Dono Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //apelido
            if (nome_animaTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Apelido Do Dono Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //bairro
            if (bairroTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Bairro Do Dono Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //avenida
            if (nome_animaTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Avenida Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            //casa
            if (casaTextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Numero da casa Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (contacto1TextF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "*Contacto (1) Nao Introduzido ", " Campo Em Branco ",
                        JOptionPane.ERROR_MESSAGE);
            }
//            if (contacto2TextF.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "*Contacto (2) Nao Introduzido ", " Campo Em Branco ",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//            if (contacto3TextF.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "*Contacto (3) Nao Introduzido ", " Campo Em Branco ",
//                        JOptionPane.ERROR_MESSAGE);
//            }

            if (validarDados() == true) {

                genero_dono = (String) RBgroup_dono.getSelection().getActionCommand();
                Dono_Controller.salvar_Dono(nome_donoTextF.getText(), apelido_donoTextF.getText(),
                        genero_dono, contacto1TextF.getText(),
                        contacto2TextF.getText(),
                        contacto3TextF.getText(), bairroTextF.getText(), avenidaTextF.getText(),
                        Integer.parseInt(casaTextF.getText()));

                //animal
                genero_animal = (String) RBgroup_animal.getSelection().getActionCommand();
                Animal_Controller.salvar_Animal(nome_animaTextF.getText(), corTextF.getText(), especie, racaTextF.getText(), (int) idade_Spinner.getValue(), genero_animal, Dono_Controller.resgatarIdDono());
                JOptionPane.showMessageDialog(null, "*Registro Efectuado Com Sucesso", " Registro de Dados ",
                        JOptionPane.INFORMATION_MESSAGE);
                nome_animaTextF.setText(""); 
                corTextF.setText("");
                racaTextF.setText("");
                //dono
                nome_donoTextF.setText("");
                apelido_donoTextF.setText("");
                contacto1TextF.setText("");
                contacto2TextF.setText("");
                contacto3TextF.setText("");
                bairroTextF.setText("");
                avenidaTextF.setText("");
                casaTextF.setText("");
                
            } else {
                JOptionPane.showMessageDialog(null, "*Preencha devidamente os Dados", " Dados invalidos ",
                        JOptionPane.ERROR_MESSAGE);
            }
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
            if ((doc.getLength() == 0) && (doc.equals(nome_animaTextF.getDocument()))) {
                nome_animalLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(racaTextF.getDocument()))) {
                racaLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(corTextF.getDocument()))) {
                corLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(nome_donoTextF.getDocument()))) {
                nome_donoLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(apelido_donoTextF.getDocument()))) {
                apelido_donoLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(bairroTextF.getDocument()))) {
                bairroLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(avenidaTextF.getDocument()))) {
                avenidaLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(casaTextF.getDocument()))) {
                casaLbl.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(contacto1TextF.getDocument()))) {
                contacto1Lbl_1.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(contacto2TextF.getDocument()))) {
                contacto2Lbl_1.setVisible(true);
            } else if ((doc.getLength() == 0) && (doc.equals(contacto3TextF.getDocument()))) {
                contacto3Lbl_1.setVisible(true);
            } else if ((doc.getLength() != 0) && (doc.equals(nome_animaTextF.getDocument()))) {
                nome_animalLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(racaTextF.getDocument()))) {
                racaLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(corTextF.getDocument()))) {
                corLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(nome_donoTextF.getDocument()))) {
                nome_donoLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(apelido_donoTextF.getDocument()))) {
                apelido_donoLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(bairroTextF.getDocument()))) {
                bairroLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(avenidaTextF.getDocument()))) {
                avenidaLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(casaTextF.getDocument()))) {
                casaLbl.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(contacto1TextF.getDocument()))) {
                contacto1Lbl_1.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(contacto2TextF.getDocument()))) {
                contacto2Lbl_1.setVisible(false);
            } else if ((doc.getLength() != 0) && (doc.equals(contacto3TextF.getDocument()))) {
                contacto3Lbl_1.setVisible(false);
            }
        }
    }
    //Método para validar dados recebidos

    private boolean validarDados() {
        int cont = 0;
        //nome animal
        if (nome_animaTextF.getText().trim().length() >= 40) {
            JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Nome do Animal Invalido ",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }

        //raca
        if (racaTextF.getText().trim().length() >= 20) {
            JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Raca Invalida ",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }
        //cor
        if (corTextF.getText().trim().length() >= 40) {
            JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Cor do Animal Invalida ",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }//nome dono
        if (nome_donoTextF.getText().trim().length() >= 40) {
            JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Nome do Dono Invalido ",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }
        //bairro
        if (bairroTextF.getText().trim().length() >= 40) {
            JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Bairro Invalido ",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }
        //avenida
        if (avenidaTextF.getText().trim().length() >= 40) {
            try {

                JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Avenida Invalida ",
                        JOptionPane.ERROR_MESSAGE);
                cont++;
            } catch (Exception e) {

            }
        }
//apelido
        if (apelido_donoTextF.getText().trim().length() >= 40) {
            JOptionPane.showMessageDialog(null, "*Número máximo de caracteres ultrapassado!!!", " Apelido Invalido ",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }
        //numero da casa
        try {
            if ((Integer.parseInt(casaTextF.getText().trim()) > 9999)
                    || (Integer.parseInt(casaTextF.getText().trim()) < 0)) {
                JOptionPane.showMessageDialog(null, "Numero de Casa Invalido", "Dado Invalido",
                        JOptionPane.ERROR_MESSAGE);
                cont++;
            }
        } catch (Exception e) {
            System.err.println("Dado invalido Digite um inteiro");
        }

//        //conct1
        if ((Integer.parseInt(contacto1TextF.getText().trim()) > 879999999)
                || (Integer.parseInt(contacto1TextF.getText().trim()) < 820000000)) {
            JOptionPane.showMessageDialog(null, "Contacto Invalido 1", "Contacto Invalido",
                    JOptionPane.ERROR_MESSAGE);
            cont++;
        }
        //cont2
//        if ((Integer.parseInt(contacto2TextF.getText().trim()) > 879999999)
//                || (Integer.parseInt(contacto2TextF.getText().trim()) < 820000000)) {
//            JOptionPane.showMessageDialog(null, "Contacto Invalido 2", "Contacto Invalido",
//                    JOptionPane.ERROR_MESSAGE);
//            cont++;
//        }
        //cont3
//        if ((Integer.parseInt(contacto3TextF.getText().trim()) > 879999999)
//                || (Integer.parseInt(contacto3TextF.getText().trim()) < 820000000)) {
//            JOptionPane.showMessageDialog(null, "Contacto Invalido 3", "Contacto Invalido",
//                    JOptionPane.ERROR_MESSAGE);
//            cont++;
//        }
        if (cont == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new RegistroAnimalDono_View();
    }
}
