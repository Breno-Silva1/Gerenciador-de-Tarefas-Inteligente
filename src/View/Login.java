package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTextField campoLogin;
	private JTextField campoSenha;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck");
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
		logo.setBounds(326, 44, 255, 218);
		body.add(logo);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio ou Email:");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblNewLabel.setBounds(326, 307, 165, 14);
		body.add(lblNewLabel);
		
		campoLogin = new JTextField();
		campoLogin.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoLogin.setBackground(Color.LIGHT_GRAY);
		campoLogin.setBounds(326, 332, 255, 36);
		body.add(campoLogin);
		campoLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(138, 43, 226));
		lblSenha.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblSenha.setBounds(326, 386, 165, 14);
		body.add(lblSenha);
		
		campoSenha = new JTextField();
		campoSenha.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoSenha.setColumns(10);
		campoSenha.setBackground(Color.LIGHT_GRAY);
		campoSenha.setBounds(326, 411, 255, 36);
		body.add(campoSenha);
		
		JButton btnCriarConta = new JButton("CRIAR CONTA");
		btnCriarConta.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnCriarConta.setForeground(new Color(255, 255, 255));
		btnCriarConta.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnCriarConta.setBackground(Color.LIGHT_GRAY);
		btnCriarConta.setBounds(326, 466, 126, 36);
		body.add(btnCriarConta);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(138, 43, 226));
		btnEntrar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnEntrar.setBounds(455, 466, 126, 36);
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
	}
}
