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
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuTarefasEMetas extends JFrame {

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
					MenuTarefasEMetas frame = new MenuTarefasEMetas();
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
	public MenuTarefasEMetas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Cadastrar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 622);
		body = new JPanel();
		body.setFocusable(false);
		body.setBackground(Color.WHITE);
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(body);
		body.setLayout(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				MenuTarefasEMetas.this.dispose();
			}
		});
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("VER TUDO");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefasEMetas tarefasEMetas = new TarefasEMetas();
				tarefasEMetas.setVisible(true);
				MenuTarefasEMetas.this.dispose();
			}
		});
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
		
		JLabel lblMeta = new JLabel("SUAS TAREFAS E METAS");
		lblMeta.setForeground(new Color(138, 43, 226));
		lblMeta.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		lblMeta.setBounds(287, 140, 319, 30);
		body.add(lblMeta);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 558, 894, 36);
		body.add(panel);
		
		JButton btnPendentes = new JButton("TAREFAS");
		btnPendentes.setFocusable(false);
		btnPendentes.setForeground(Color.WHITE);
		btnPendentes.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnPendentes.setBackground(new Color(102, 205, 170));
		btnPendentes.setBounds(287, 258, 145, 45);
		body.add(btnPendentes);
		
		JButton btnMetas = new JButton("METAS");
		btnMetas.setFocusable(false);
		btnMetas.setForeground(Color.WHITE);
		btnMetas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMetas.setBackground(new Color(102, 205, 170));
		btnMetas.setBounds(461, 258, 145, 45);
		body.add(btnMetas);
		
		JButton btnConcluidas = new JButton("PENDENTES");
		btnConcluidas.setFocusable(false);
		btnConcluidas.setForeground(Color.WHITE);
		btnConcluidas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnConcluidas.setBackground(new Color(102, 205, 170));
		btnConcluidas.setBounds(461, 321, 145, 46);
		body.add(btnConcluidas);
		
		JButton btnPendentes_1 = new JButton("CONCLU\u00CDDAS");
		btnPendentes_1.setFocusable(false);
		btnPendentes_1.setForeground(Color.WHITE);
		btnPendentes_1.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnPendentes_1.setBackground(new Color(102, 205, 170));
		btnPendentes_1.setBounds(287, 321, 145, 46);
		body.add(btnPendentes_1);
	}
}
