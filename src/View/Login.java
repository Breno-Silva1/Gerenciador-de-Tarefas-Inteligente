package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UsuarioDAO;
import Model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	UsuarioDAO dao = new UsuarioDAO();
	static Usuario usuario = null;
	Icon sucesso = new ImageIcon(getClass().getResource("/img/correct_icon.png"));
	Icon aviso = new ImageIcon(getClass().getResource("/img/warning_icon.png"));
			
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 622);
		body = new JPanel();
		body.setBackground(Color.WHITE);
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(body);
		body.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/img/logo.png")));
		logo.setBounds(319, 44, 255, 218);
		body.add(logo);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio ou Email:");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblNewLabel.setBounds(319, 308, 165, 14);
		body.add(lblNewLabel);
		
		campoLogin = new JTextField();
		campoLogin.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoLogin.setBackground(Color.LIGHT_GRAY);
		campoLogin.setBounds(319, 333, 255, 36);
		body.add(campoLogin);
		campoLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(138, 43, 226));
		lblSenha.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblSenha.setBounds(319, 387, 165, 14);
		body.add(lblSenha);
		
		JButton btnCriarConta = new JButton("CRIAR CONTA");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
				Login.this.dispose();
				cadastrarUsuario.setVisible(true);
				
			}
		});
		btnCriarConta.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		btnCriarConta.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnCriarConta.setBackground(Color.LIGHT_GRAY);
		btnCriarConta.setBounds(319, 467, 126, 36);
		body.add(btnCriarConta);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!(campoLogin.getText().equals("")) && !(campoSenha.getText().equals(""))){
					usuario = dao.autenticar(campoLogin.getText(), campoSenha.getText());
					if (usuario != null) {
						Login.this.dispose();
						TelaInicial telaInicial = new TelaInicial();
						telaInicial.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(Login.this, "Login ou senha incorreto!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
					}
				} else {
					JOptionPane.showMessageDialog(Login.this, "Preencha todos os campos corretamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(138, 43, 226));
		btnEntrar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnEntrar.setBounds(448, 467, 126, 36);
		body.add(btnEntrar);
		
		JLabel lista2 = new JLabel("");
		lista2.setIcon(new ImageIcon(Login.class.getResource("/img/lista.png")));
		lista2.setBounds(639, 196, 255, 9);
		body.add(lista2);
		
		JLabel lista1 = new JLabel("");
		lista1.setIcon(new ImageIcon(Login.class.getResource("/img/lista.png")));
		lista1.setBounds(0, 196, 255, 9);
		body.add(lista1);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 558, 894, 36);
		body.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/background_icons.png")));
		lblNewLabel_1.setBounds(39, 0, 884, 194);
		body.add(lblNewLabel_1);
		
		campoSenha = new JPasswordField();
		campoSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoSenha.setBackground(Color.LIGHT_GRAY);
		campoSenha.setBounds(319, 412, 255, 36);
		body.add(campoSenha);
	}
	public static Usuario getSessao(){
		return usuario;
	}
	public static void setSessao(Usuario umUsuario){
		usuario = umUsuario;
	}
}
