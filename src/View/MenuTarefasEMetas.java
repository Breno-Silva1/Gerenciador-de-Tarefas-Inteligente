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

	private static final long serialVersionUID = 1L;
	private JPanel body;

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
	
	public MenuTarefasEMetas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Menu Tarefas e Metas");
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
		
		JButton btnTarefas = new JButton("TAREFAS");
		btnTarefas.setFocusable(false);
		btnTarefas.setForeground(Color.WHITE);
		btnTarefas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnTarefas.setBackground(new Color(138, 43, 226));
		btnTarefas.setBounds(230, 248, 200, 45);
		body.add(btnTarefas);
		
		JButton btnMetas = new JButton("METAS");
		btnMetas.setFocusable(false);
		btnMetas.setForeground(Color.WHITE);
		btnMetas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMetas.setBackground(new Color(0, 250, 154));
		btnMetas.setBounds(459, 248, 200, 45);
		body.add(btnMetas);
		
		JButton btnTPendentes = new JButton("TAREFAS PENDENTES");
		btnTPendentes.setFocusable(false);
		btnTPendentes.setForeground(Color.WHITE);
		btnTPendentes.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnTPendentes.setBackground(new Color(138, 43, 226));
		btnTPendentes.setBounds(230, 374, 200, 46);
		body.add(btnTPendentes);
		
		JButton btnTConcluidas = new JButton("TAREFAS CONCLU\u00CDDAS");
		btnTConcluidas.setFocusable(false);
		btnTConcluidas.setForeground(Color.WHITE);
		btnTConcluidas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnTConcluidas.setBackground(new Color(138, 43, 226));
		btnTConcluidas.setBounds(230, 311, 200, 46);
		body.add(btnTConcluidas);
		
		JButton btnMPendentes = new JButton("METAS PENDENTES");
		btnMPendentes.setForeground(Color.WHITE);
		btnMPendentes.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMPendentes.setFocusable(false);
		btnMPendentes.setBackground(new Color(0, 250, 154));
		btnMPendentes.setBounds(459, 374, 200, 46);
		body.add(btnMPendentes);
		
		JButton btnMConcluidas = new JButton("METAS CONCLU\u00CDDAS");
		btnMConcluidas.setForeground(Color.WHITE);
		btnMConcluidas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMConcluidas.setFocusable(false);
		btnMConcluidas.setBackground(new Color(0, 250, 154));
		btnMConcluidas.setBounds(459, 311, 200, 46);
		body.add(btnMConcluidas);
	}
}
