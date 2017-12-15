package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTextField campoNome;
	private JTextField campoLogin;
	private JTextField campoEmail;
	private JTextField campoSenha;
	private JTextField campoConfirmarSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuario frame = new CadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Cadastrar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 622);
		body = new JPanel();
		body.setBackground(Color.WHITE);
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(body);
		body.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblNewLabel.setBounds(215, 173, 77, 36);
		body.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoNome.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoNome.setBackground(Color.LIGHT_GRAY);
		campoNome.setBounds(283, 174, 420, 36);
		body.add(campoNome);
		campoNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("CRIAR CONTA");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(138, 43, 226));
		btnCadastrar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnCadastrar.setBounds(723, 495, 126, 36);
		body.add(btnCadastrar);
		
		JLabel logo_reduced = new JLabel("");
		logo_reduced.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/img/logo_reduced.png")));
		logo_reduced.setBounds(50, 35, 233, 69);
		body.add(logo_reduced);
		
		JLabel lista1 = new JLabel("");
		lista1.setIcon(new ImageIcon(Login.class.getResource("/img/lista.png")));
		lista1.setBounds(0, 196, 170, 9);
		body.add(lista1);
		
		JLabel lblNovaConta = new JLabel("NOVA CONTA");
		lblNovaConta.setForeground(new Color(138, 43, 226));
		lblNovaConta.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		lblNovaConta.setBounds(409, 114, 178, 30);
		body.add(lblNovaConta);
		
		campoLogin = new JTextField();
		campoLogin.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoLogin.setColumns(10);
		campoLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoLogin.setBackground(Color.LIGHT_GRAY);
		campoLogin.setBounds(283, 234, 420, 36);
		body.add(campoLogin);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoEmail.setBackground(Color.LIGHT_GRAY);
		campoEmail.setBounds(283, 292, 420, 36);
		body.add(campoEmail);
		
		campoSenha = new JTextField();
		campoSenha.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoSenha.setColumns(10);
		campoSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoSenha.setBackground(Color.LIGHT_GRAY);
		campoSenha.setBounds(283, 359, 420, 36);
		body.add(campoSenha);
		
		campoConfirmarSenha = new JTextField();
		campoConfirmarSenha.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoConfirmarSenha.setColumns(10);
		campoConfirmarSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoConfirmarSenha.setBackground(Color.LIGHT_GRAY);
		campoConfirmarSenha.setBounds(283, 418, 420, 36);
		body.add(campoConfirmarSenha);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 558, 894, 36);
		body.add(panel);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(new Color(138, 43, 226));
		lblLogin.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblLogin.setBounds(215, 233, 77, 36);
		body.add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(138, 43, 226));
		lblEmail.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblEmail.setBounds(215, 291, 77, 36);
		body.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(138, 43, 226));
		lblSenha.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblSenha.setBounds(215, 358, 77, 36);
		body.add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setForeground(new Color(138, 43, 226));
		lblConfirmarSenha.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblConfirmarSenha.setBounds(122, 417, 170, 36);
		body.add(lblConfirmarSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario.this.dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		
	}
}
