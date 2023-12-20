/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Animal_Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author KIP
 */
public class IdAnimal_View extends JFrame implements ActionListener {

    private JLabel id, texto;
    private JTextField cod;
    private JButton saveBtn;
    private JPanel pn, pntexto;
    public static int idAnimal;
    

    public IdAnimal_View() {
        pn = new JPanel();
        pntexto = new JPanel();
        receberID();
    }

    public void receberID() {
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        //painel texto
        pntexto.setLayout(null);
        pntexto.setBounds(0, 15, 500, 40);
        pntexto.setBackground(new Color(0, 149, 135, 255));

        //label texto
        texto = new JLabel("ID do Animal");
        texto.setBounds(120, 0, 400, 45);
        texto.setFont(new Font("Segoe UI", Font.BOLD, 25));
        texto.setForeground(Color.white);
        pntexto.add(texto);

        // panel Jtext
        pn.setBackground(Color.white);
        pn.setBounds(0, 60, 400, 300);

        //jlabel cod
        id = new JLabel("ID");
        id.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));

        //texto id Jtext
        cod = new JTextField();
        cod.setLayout(new BorderLayout());
        cod.add(id, BorderLayout.LINE_START);
        cod.setBounds(123, 30, 140, 25);
        cod.setToolTipText("Digite o Codigo do Animal Que Dejesa Efectuar o Tratamento");
        cod.getDocument().addDocumentListener(new MyDocumentListener());

        //jbutton 
        saveBtn = new JButton("Search", new ImageIcon("Search-icon (1).png"));
        saveBtn.setBounds(130, 65, 120, 20);
        saveBtn.setBackground(new Color(0, 149, 135, 255));
        saveBtn.setFocusable(false);
        saveBtn.addActionListener(this);
        pn.add(saveBtn);

        pn.add(cod);
        pn.setLayout(null);
        this.add(pn);
        this.add(pntexto);
        show();

    }

//    public static void main(String[] args) {
//        new IdAnimal_View();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            idAnimal = Integer.parseInt(cod.getText());

            if (idAnimal < 1 || idAnimal > 999999999) {
                JOptionPane.showMessageDialog(null, "CODIGO NAO EXISTE");
            } else {
                // c++;
                if (Animal_Controller.verificar_idAnimal(idAnimal) == false) {
                    JOptionPane.showMessageDialog(null, "CODIGO NAO ENCOTRADO");
                } else {
                    try {
                        dispose();
                        Tratamentos_View tr = new Tratamentos_View();
                        tr.setLocationRelativeTo(null);
                        tr.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(IdAnimal_View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
            if ((doc.getLength() != 0) && (doc.equals(cod.getDocument()))) {
                id.setVisible(false);
            }
        }
    }

}
