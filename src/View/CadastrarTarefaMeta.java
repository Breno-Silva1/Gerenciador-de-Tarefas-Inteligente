package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarTarefaMeta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel body;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarTarefaMeta frame = new CadastrarTarefaMeta();
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
	public CadastrarTarefaMeta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Cadastrar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 622);
		body = new JPanel();
		body.setBackground(Color.WHITE);
		body.setBorder(null);
		setContentPane(body);
		body.setLayout(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				CadastrarTarefaMeta.this.dispose();
			}
		});
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		
		JLabel lblCadastrar = new JLabel("CADASTRAR");
		lblCadastrar.setForeground(new Color(138, 43, 226));
		lblCadastrar.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		lblCadastrar.setBounds(369, 113, 164, 30);
		body.add(lblCadastrar);
		
		JButton btnCadastrarMeta = new JButton("META");
		btnCadastrarMeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMeta cadastrarMeta = new CadastrarMeta();
				cadastrarMeta.setVisible(true);
				CadastrarTarefaMeta.this.dispose();
			}
		});
		btnCadastrarMeta.setFocusable(false);
		btnCadastrarMeta.setForeground(new Color(255, 255, 255));
		btnCadastrarMeta.setBackground(new Color(102, 205, 170));
		btnCadastrarMeta.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnCadastrarMeta.setBounds(339, 298, 225, 54);
		body.add(btnCadastrarMeta);
		
		JLabel logo_reduced = new JLabel("");
		logo_reduced.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/img/logo_reduced.png")));
		logo_reduced.setBounds(50, 35, 233, 69);
		body.add(logo_reduced);
		
		JLabel lista1 = new JLabel("");
		lista1.setIcon(new ImageIcon(Login.class.getResource("/img/lista.png")));
		lista1.setBounds(0, 196, 170, 9);
		body.add(lista1);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 558, 894, 36);
		body.add(panel);
		
		JButton btnCadastrarTarefa = new JButton("TAREFAS");
		btnCadastrarTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarTarefa cadastrarTarefa = new CadastrarTarefa();
				cadastrarTarefa.setVisible(true);
				CadastrarTarefaMeta.this.dispose();
			}
		});
		btnCadastrarTarefa.setFocusable(false);
		btnCadastrarTarefa.setForeground(Color.WHITE);
		btnCadastrarTarefa.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnCadastrarTarefa.setBackground(new Color(138, 43, 226));
		btnCadastrarTarefa.setBounds(339, 225, 225, 54);
		body.add(btnCadastrarTarefa);
	}

}
