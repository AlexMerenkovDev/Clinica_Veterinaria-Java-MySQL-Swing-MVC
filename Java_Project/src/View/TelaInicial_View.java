package View;




import View.Login_View;
import View.RegistroAnimalDono_View;
import View.Tratamentos_View;
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
public class TelaInicial_View extends JFrame implements ActionListener{
    private JLabel imagemFundo, labelImagem;
    private JPanel contentPane, painelCabecalho, painelRegistar, painelTratamento, painelEstatisticas, painelhistorico, painelPesquisarAnimal, painelPesquisarDono;
    private JButton registarBtn, tratamentoBtn, estatisticasBtn, historicoBtn, pesquisarAnimalBtn, PesquisarDonoBtn;
    public int cont6=0, cont7=0, cont9=0, cont10=0, cont8;
//    public Tarefa tarefa;
    

    public TelaInicial_View() throws IOException {
        
        //tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1000, 700);
	setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        labelImagem = new JLabel();
        
//        tarefa = new Tarefa();
        
        
        contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
	contentPane.setBackground(new Color(255, 255, 255));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        BufferedImage myImage = ImageIO.read(new File("tela.jpg"));
        this.setContentPane(new Login_View.ImagePanel(myImage));
        
        
//Painel onde tem o cabeçalho
        //painel
        painelCabecalho = new JPanel();                              
        painelCabecalho.setBackground(new Color(0,149,135,255));
        painelCabecalho.setBounds(0, 10, 1000, 75);
      //  painelCabecalho.setOpaque(false);
        add(painelCabecalho);
        painelCabecalho.setLayout(null);
        
        //tema
        JLabel tema = new JLabel("Sistema de Gestão de Veterinaria");
        tema.setForeground(Color.WHITE);
	tema.setFont(new Font("Segoe UI", Font.BOLD, 30));
	tema.setHorizontalAlignment(SwingConstants.CENTER);
	tema.setBounds(130, 12, 749, 50);
        tema.setOpaque(false);
	painelCabecalho.add(tema);
        
       
//painel registrar animal

        painelRegistar = new JPanel();
        painelRegistar.setBackground(Color.WHITE);
        painelRegistar.setBounds(20, 125, 230, 230);
        painelRegistar.setLayout(null);
        add(painelRegistar);
        
        
        registarBtn = new JButton("Registar Animal", new ImageIcon("notes.png"));       
        registarBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
	registarBtn.setHorizontalAlignment(SwingConstants.CENTER);                   
	registarBtn.setHorizontalTextPosition(JLabel.CENTER);                    
	registarBtn.setVerticalTextPosition(JLabel.BOTTOM);
	registarBtn.setBounds(0, 0, 230, 230);
	registarBtn.setForeground(Color.BLACK);
	registarBtn.setBorder(new EmptyBorder(0,0,0,0));
	registarBtn.setFocusPainted(false);
	registarBtn.setBorderPainted(false);
	registarBtn.setOpaque(true);
        registarBtn.addActionListener(this);
        painelRegistar.add(registarBtn);
        
//painel de tratamentos        
        painelTratamento = new JPanel();
        painelTratamento.setBackground(Color.WHITE);
        painelTratamento.setBounds(360, 125, 230, 230);
        painelTratamento.setLayout(null);
        add(painelTratamento);
        
        
        tratamentoBtn = new JButton("Fazer Tratamentos", new ImageIcon("first-aid-sign.png"));       
        tratamentoBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
	tratamentoBtn.setHorizontalAlignment(SwingConstants.CENTER);                   
	tratamentoBtn.setHorizontalTextPosition(JLabel.CENTER);                    
	tratamentoBtn.setVerticalTextPosition(JLabel.BOTTOM);
	tratamentoBtn.setBounds(0, 0, 230, 230);     
        tratamentoBtn.setFocusable(true);
	tratamentoBtn.setForeground(Color.BLACK);
	tratamentoBtn.setBorder(new EmptyBorder(0,0,0,0));
	tratamentoBtn.setFocusPainted(false);
	tratamentoBtn.setBorderPainted(false);
	tratamentoBtn.setOpaque(false);
        tratamentoBtn.addActionListener(this);
        painelTratamento.add(tratamentoBtn);

        
//painel de estatisticas
        
        painelEstatisticas = new JPanel();
        painelEstatisticas.setBackground(Color.WHITE);
        painelEstatisticas.setBounds(700, 125, 230, 230);
        painelEstatisticas.setLayout(null);
        add(painelEstatisticas);

    
        estatisticasBtn = new JButton("Estatíticas", new ImageIcon("statistics.png"));       
        estatisticasBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
	estatisticasBtn.setHorizontalAlignment(SwingConstants.CENTER);                   
	estatisticasBtn.setHorizontalTextPosition(JLabel.CENTER);              
	estatisticasBtn.setVerticalTextPosition(JLabel.BOTTOM);
	estatisticasBtn.setBounds(0, 0, 230, 230);     
        estatisticasBtn.setFocusable(true);
	estatisticasBtn.setForeground(Color.BLACK);
	estatisticasBtn.setBorder(new EmptyBorder(0,0,0,0));
	estatisticasBtn.setFocusPainted(false);
	estatisticasBtn.setBorderPainted(false);
	estatisticasBtn.setOpaque(false);
        estatisticasBtn.addActionListener(this);
        painelEstatisticas.add(estatisticasBtn);
        
        
//painel pesquisar animal

        painelPesquisarAnimal = new JPanel();
        painelPesquisarAnimal.setBackground(Color.WHITE);
        painelPesquisarAnimal.setBounds(20, 375, 230, 230);
        painelPesquisarAnimal.setLayout(null);
        this.add(painelPesquisarAnimal);
        
        
        pesquisarAnimalBtn = new JButton("Pesquisar Animal", new ImageIcon("pawprint.png"));       
        pesquisarAnimalBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
	pesquisarAnimalBtn.setHorizontalAlignment(SwingConstants.CENTER);                   
	pesquisarAnimalBtn.setHorizontalTextPosition(JLabel.CENTER);                    
	pesquisarAnimalBtn.setVerticalTextPosition(JLabel.BOTTOM);
	pesquisarAnimalBtn.setBounds(0, 0, 230, 230);
	pesquisarAnimalBtn.setForeground(Color.BLACK);
	pesquisarAnimalBtn.setBorder(new EmptyBorder(0,0,0,0));
	pesquisarAnimalBtn.setFocusPainted(false);
	pesquisarAnimalBtn.setBorderPainted(false);
	pesquisarAnimalBtn.setOpaque(true);
        pesquisarAnimalBtn.addActionListener(this);
        painelPesquisarAnimal.add(pesquisarAnimalBtn);
        
//painel de Pesquisar Dono
        
        painelPesquisarDono = new JPanel();
        painelPesquisarDono.setBackground(Color.WHITE);
        painelPesquisarDono.setBounds(360, 375, 230, 230);
        painelPesquisarDono.setLayout(null);
        add(painelPesquisarDono);
        
        
        PesquisarDonoBtn = new JButton("Pesquisar Dono", new ImageIcon("dog-man.png"));      
        PesquisarDonoBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
	PesquisarDonoBtn.setHorizontalAlignment(SwingConstants.CENTER);                   
	PesquisarDonoBtn.setHorizontalTextPosition(JLabel.CENTER);                    
	PesquisarDonoBtn.setVerticalTextPosition(JLabel.BOTTOM);
	PesquisarDonoBtn.setBounds(0, 0, 230, 230);     
        PesquisarDonoBtn.setFocusable(true);
	PesquisarDonoBtn.setForeground(Color.BLACK);
	PesquisarDonoBtn.setBorder(new EmptyBorder(0,0,0,0));
	PesquisarDonoBtn.setFocusPainted(false);
	PesquisarDonoBtn.setBorderPainted(false);
	PesquisarDonoBtn.setOpaque(false);
        PesquisarDonoBtn.addActionListener(this);
        painelPesquisarDono.add(PesquisarDonoBtn);

//painel de Histórico
        
        painelhistorico = new JPanel();
        painelhistorico.setBackground(Color.WHITE);
        painelhistorico.setBounds(700, 375, 230, 230);
        painelhistorico.setLayout(null);
        add(painelhistorico);
        
        historicoBtn = new JButton("Histórico", new ImageIcon("historical.png"));  //Histórico     
        historicoBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
	historicoBtn.setHorizontalAlignment(SwingConstants.CENTER);                   
	historicoBtn.setHorizontalTextPosition(JLabel.CENTER);              
	historicoBtn.setVerticalTextPosition(JLabel.BOTTOM);
	historicoBtn.setBounds(0, 0, 230, 230);     
        historicoBtn.setFocusable(true);
	historicoBtn.setForeground(Color.BLACK);
	historicoBtn.setBorder(new EmptyBorder(0,0,0,0));
	historicoBtn.setFocusPainted(false);
	historicoBtn.setBorderPainted(false);
	historicoBtn.setOpaque(false);
        historicoBtn.addActionListener(this);
        painelhistorico.add(historicoBtn);
        
//        labelImagem.setBounds(0, 11, 800, 683);   
//        contentPane.add(labelImagem);
//        String directorio = new File("").getAbsolutePath();
//        
//        Image imagem = null;
//            try {
//                imagem = ImageIO.read(new File(directorio + "/Imagem Fundo.png"));
//            } catch (IOException ex) {
//                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);}
            
        //labelImagem.setIcon(new ImageIcon(imagem.getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), Image.SCALE_SMOOTH)));
            
        //labelImagem.setIcon(new ImageIcon(imagem.getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), Image.SCALE_SMOOTH)));

        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == registarBtn){
            RegistroAnimalDono_View cc = new RegistroAnimalDono_View();
            this.setVisible(false);
            cc.setLocationRelativeTo(null);
        }
//        
        if(ae.getSource() == tratamentoBtn){
            IdAnimal_View pc = new IdAnimal_View();
            this.setVisible(false);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);
        }
//        
        if(ae.getSource() == estatisticasBtn){
            Estatisticas_View pc = new Estatisticas_View();
//            this.setVisible(false);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);
        } 

        if(ae.getSource() == pesquisarAnimalBtn){
            VisualizarAnimal_View pc = new VisualizarAnimal_View();
            this.setVisible(false);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);
        }
        
        if(ae.getSource() == PesquisarDonoBtn){
            VisualizarDono_View pc = new VisualizarDono_View();
            this.setVisible(false);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);
        }
        
        if(ae.getSource() == historicoBtn){
            Historico_View pc = new Historico_View();
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);
            this.setVisible(false);
        }

    }
    
    public static void main(String[] args) throws IOException {
        TelaInicial_View ti = new TelaInicial_View();
        ti.setVisible(true);}
}
