package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import Model.Usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel body;
	Usuario usuario = Login.getSessao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Tela Inicial");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 622);
		body = new JPanel();
		body.setBackground(Color.WHITE);
		body.setBorder(null);
		setContentPane(body);
		body.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRA HOJE:");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 22));
		lblNewLabel.setBounds(232, 182, 109, 36);
		body.add(lblNewLabel);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEditar menue = new MenuEditar();
				menue.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		btnEditar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setBounds(50, 495, 126, 36);
		body.add(btnEditar);
		
		JButton btnCadastrar = new JButton("ADICIONAR NOVA");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarTarefaMeta cadastrarTarefaMeta = new CadastrarTarefaMeta();
				cadastrarTarefaMeta.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(3, 209, 170));
		btnCadastrar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnCadastrar.setBounds(691, 495, 158, 36);
		body.add(btnCadastrar);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_1.setBounds(232, 229, 40, 40);
		body.add(panel_1);
		
		JCheckBox check1 = new JCheckBox("");
		check1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		check1.setHorizontalTextPosition(SwingConstants.CENTER);
		check1.setHorizontalAlignment(SwingConstants.CENTER);
		check1.setPreferredSize(new Dimension(30, 30));
		check1.setMinimumSize(new Dimension(30, 30));
		check1.setMaximumSize(new Dimension(30, 30));
		check1.setMargin(new Insets(5, 5, 5, 5));
		check1.setSize(50, 50);
		check1.setSize(new Dimension(50, 50));
		panel_1.add(check1);
		check1.setBorder(null);
		check1.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		
		JButton btnVerTarefas = new JButton("VER TAREFAS");
		btnVerTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTarefasEMetas menuTarefasEMetas;
				try {
					menuTarefasEMetas = new MenuTarefasEMetas();
					menuTarefasEMetas.setVisible(true);
					TelaInicial.this.dispose();
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVerTarefas.setForeground(Color.WHITE);
		btnVerTarefas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVerTarefas.setBackground(new Color(138, 43, 226));
		btnVerTarefas.setBounds(560, 495, 126, 36);
		body.add(btnVerTarefas);
		
		JButton info1 = new JButton("!");
		info1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info1.setToolTipText("Editar");
		info1.setFocusable(false);
		info1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info1.setBackground(new Color(138, 43, 226));
		info1.setForeground(new Color(255, 255, 255));
		info1.setFont(new Font("Arial", Font.BOLD, 20));
		info1.setBounds(611, 229, 46, 40);
		body.add(info1);
		
		JLabel tarefa_meta1 = new JLabel("");
		tarefa_meta1.setBounds(282, 234, 314, 30);
		body.add(tarefa_meta1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_2.setBounds(272, 229, 339, 40);
		body.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_3.setBounds(232, 268, 40, 40);
		body.add(panel_3);
		
		JCheckBox check2 = new JCheckBox("");
		check2.setSize(new Dimension(50, 50));
		check2.setPreferredSize(new Dimension(30, 30));
		check2.setMinimumSize(new Dimension(30, 30));
		check2.setMaximumSize(new Dimension(30, 30));
		check2.setMargin(new Insets(5, 5, 5, 5));
		check2.setHorizontalTextPosition(SwingConstants.CENTER);
		check2.setHorizontalAlignment(SwingConstants.CENTER);
		check2.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		check2.setBorder(null);
		check2.setAlignmentY(1.0f);
		panel_3.add(check2);
		
		JLabel tarefa_meta2 = new JLabel("");
		tarefa_meta2.setBounds(282, 273, 314, 30);
		body.add(tarefa_meta2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_4.setBounds(272, 268, 339, 40);
		body.add(panel_4);
		
		JButton info2 = new JButton("!");
		info2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info2.setToolTipText("Editar");
		info2.setForeground(Color.WHITE);
		info2.setFont(new Font("Arial", Font.BOLD, 20));
		info2.setFocusable(false);
		info2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info2.setBackground(new Color(138, 43, 226));
		info2.setBounds(611, 268, 46, 40);
		body.add(info2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_5.setBounds(232, 307, 40, 40);
		body.add(panel_5);
		
		JCheckBox check3 = new JCheckBox("");
		check3.setSize(new Dimension(50, 50));
		check3.setPreferredSize(new Dimension(30, 30));
		check3.setMinimumSize(new Dimension(30, 30));
		check3.setMaximumSize(new Dimension(30, 30));
		check3.setMargin(new Insets(5, 5, 5, 5));
		check3.setHorizontalTextPosition(SwingConstants.CENTER);
		check3.setHorizontalAlignment(SwingConstants.CENTER);
		check3.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		check3.setBorder(null);
		check3.setAlignmentY(1.0f);
		panel_5.add(check3);
		
		JLabel tarefa_meta3 = new JLabel("");
		tarefa_meta3.setBounds(282, 312, 314, 30);
		body.add(tarefa_meta3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_6.setBounds(272, 307, 339, 40);
		body.add(panel_6);
		
		JButton info3 = new JButton("!");
		info3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info3.setToolTipText("Editar");
		info3.setForeground(Color.WHITE);
		info3.setFont(new Font("Arial", Font.BOLD, 20));
		info3.setFocusable(false);
		info3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info3.setBackground(new Color(138, 43, 226));
		info3.setBounds(611, 307, 46, 40);
		body.add(info3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_7.setBounds(232, 346, 40, 40);
		body.add(panel_7);
		
		JCheckBox check4 = new JCheckBox("");
		check4.setSize(new Dimension(50, 50));
		check4.setPreferredSize(new Dimension(30, 30));
		check4.setMinimumSize(new Dimension(30, 30));
		check4.setMaximumSize(new Dimension(30, 30));
		check4.setMargin(new Insets(5, 5, 5, 5));
		check4.setHorizontalTextPosition(SwingConstants.CENTER);
		check4.setHorizontalAlignment(SwingConstants.CENTER);
		check4.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		check4.setBorder(null);
		check4.setAlignmentY(1.0f);
		panel_7.add(check4);
		
		JLabel tarefa_meta4 = new JLabel("");
		tarefa_meta4.setBounds(282, 351, 314, 30);
		body.add(tarefa_meta4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_8.setBounds(272, 346, 339, 40);
		body.add(panel_8);
		
		JButton info4 = new JButton("!");
		info4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info4.setToolTipText("Editar");
		info4.setForeground(Color.WHITE);
		info4.setFont(new Font("Arial", Font.BOLD, 20));
		info4.setFocusable(false);
		info4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info4.setBackground(new Color(138, 43, 226));
		info4.setBounds(611, 346, 46, 40);
		body.add(info4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_9.setBounds(232, 385, 40, 40);
		body.add(panel_9);
		
		JCheckBox check5 = new JCheckBox("");
		check5.setSize(new Dimension(50, 50));
		check5.setPreferredSize(new Dimension(30, 30));
		check5.setMinimumSize(new Dimension(30, 30));
		check5.setMaximumSize(new Dimension(30, 30));
		check5.setMargin(new Insets(5, 5, 5, 5));
		check5.setHorizontalTextPosition(SwingConstants.CENTER);
		check5.setHorizontalAlignment(SwingConstants.CENTER);
		check5.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		check5.setBorder(null);
		check5.setAlignmentY(1.0f);
		panel_9.add(check5);
		
		JLabel tarefa_meta5 = new JLabel("");
		tarefa_meta5.setBounds(282, 390, 314, 30);
		body.add(tarefa_meta5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_10.setBounds(272, 385, 339, 40);
		body.add(panel_10);
		
		JButton info5 = new JButton("!");
		info5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info5.setToolTipText("Editar");
		info5.setForeground(Color.WHITE);
		info5.setFont(new Font("Arial", Font.BOLD, 20));
		info5.setFocusable(false);
		info5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info5.setBackground(new Color(138, 43, 226));
		info5.setBounds(611, 385, 46, 40);
		body.add(info5);
		
		JButton btnX = new JButton("x");
		btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnX.setToolTipText("Remover");
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Arial", Font.BOLD, 20));
		btnX.setFocusable(false);
		btnX.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnX.setBackground(new Color(165, 42, 42));
		btnX.setBounds(657, 229, 46, 40);
		body.add(btnX);
		
		JButton button = new JButton("x");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setToolTipText("Remover");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 20));
		button.setFocusable(false);
		button.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		button.setBackground(new Color(165, 42, 42));
		button.setBounds(657, 268, 46, 40);
		body.add(button);
		
		JButton button_1 = new JButton("x");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setToolTipText("Remover");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial", Font.BOLD, 20));
		button_1.setFocusable(false);
		button_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		button_1.setBackground(new Color(165, 42, 42));
		button_1.setBounds(657, 307, 46, 40);
		body.add(button_1);
		
		JButton button_2 = new JButton("x");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setToolTipText("Remover");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial", Font.BOLD, 20));
		button_2.setFocusable(false);
		button_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		button_2.setBackground(new Color(165, 42, 42));
		button_2.setBounds(657, 346, 46, 40);
		body.add(button_2);
		
		JButton button_3 = new JButton("x");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setToolTipText("Remover");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arial", Font.BOLD, 20));
		button_3.setFocusable(false);
		button_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		button_3.setBackground(new Color(165, 42, 42));
		button_3.setBounds(657, 385, 46, 40);
		body.add(button_3);
		
		if(usuario != null){
			JLabel nomeUsuario = new JLabel(usuario.getNome().toUpperCase());
			nomeUsuario.setForeground(new Color(138, 43, 226));
			nomeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			nomeUsuario.setFont(new Font("Source Sans Pro", Font.BOLD, 24));
			nomeUsuario.setBounds(611, 53, 214, 30);
			body.add(nomeUsuario);
		}
		
		JButton sairIcon = new JButton("");
		sairIcon.setToolTipText("SAIR");
		sairIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario = null;
				Login.setSessao(usuario);
				Login login = new Login();
				login.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		sairIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sairIcon.setBackground(Color.WHITE);
		sairIcon.setBorderPainted(false);
		sairIcon.setBorder(null);
		sairIcon.setFocusPainted(false);
		sairIcon.setFocusTraversalKeysEnabled(false);
		sairIcon.setFocusable(false);
		sairIcon.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/out_icon.png")));
		sairIcon.setBounds(795, 84, 30, 30);
		body.add(sairIcon);
		
		Date dataDeHoje = new Date();
		DateFormat df = DateFormat.getDateInstance();
		String data = df.format(dataDeHoje);
		
		JLabel lblDdmouthyyyy = new JLabel(data);
		lblDdmouthyyyy.setForeground(new Color(3, 209, 170));
		lblDdmouthyyyy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDdmouthyyyy.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		lblDdmouthyyyy.setBounds(630, 86, 155, 28);
		body.add(lblDdmouthyyyy);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(138, 43, 226));
		panel_11.setBounds(835, 58, 5, 52);
		body.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/background_icons_rigth.png")));
		lblNewLabel_1.setBounds(584, 0, 308, 189);
		body.add(lblNewLabel_1);
		
	}
}
