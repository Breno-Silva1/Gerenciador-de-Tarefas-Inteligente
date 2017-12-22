package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class TarefasEMetas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel body;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarefasEMetas frame = new TarefasEMetas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TarefasEMetas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smark | Tarefas e Metas");
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
				MenuTarefasEMetas menu;
				try {
					menu = new MenuTarefasEMetas();
					menu.setVisible(true);
					TarefasEMetas.this.dispose();
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("ADICIONAR NOVA");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarTarefaMeta cadastrarTarefaMeta = new CadastrarTarefaMeta();
				cadastrarTarefaMeta.setVisible(true);
				TarefasEMetas.this.dispose();
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
		panel_1.setBounds(233, 196, 40, 40);
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
		
		JButton info1 = new JButton("!");
		info1.setFocusable(false);
		info1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info1.setBackground(new Color(138, 43, 226));
		info1.setForeground(new Color(255, 255, 255));
		info1.setFont(new Font("Arial", Font.BOLD, 20));
		info1.setBounds(612, 196, 46, 40);
		body.add(info1);
		
		JLabel tarefa_meta1 = new JLabel("");
		tarefa_meta1.setBounds(283, 201, 314, 30);
		body.add(tarefa_meta1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_2.setBounds(273, 196, 339, 40);
		body.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_3.setBounds(233, 235, 40, 40);
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
		tarefa_meta2.setBounds(283, 240, 314, 30);
		body.add(tarefa_meta2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_4.setBounds(273, 235, 339, 40);
		body.add(panel_4);
		
		JButton info2 = new JButton("!");
		info2.setForeground(Color.WHITE);
		info2.setFont(new Font("Arial", Font.BOLD, 20));
		info2.setFocusable(false);
		info2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info2.setBackground(new Color(138, 43, 226));
		info2.setBounds(612, 235, 46, 40);
		body.add(info2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_5.setBounds(233, 274, 40, 40);
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
		tarefa_meta3.setBounds(283, 279, 314, 30);
		body.add(tarefa_meta3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_6.setBounds(273, 274, 339, 40);
		body.add(panel_6);
		
		JButton info3 = new JButton("!");
		info3.setForeground(Color.WHITE);
		info3.setFont(new Font("Arial", Font.BOLD, 20));
		info3.setFocusable(false);
		info3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info3.setBackground(new Color(138, 43, 226));
		info3.setBounds(612, 274, 46, 40);
		body.add(info3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_7.setBounds(233, 313, 40, 40);
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
		tarefa_meta4.setBounds(283, 318, 314, 30);
		body.add(tarefa_meta4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_8.setBounds(273, 313, 339, 40);
		body.add(panel_8);
		
		JButton info4 = new JButton("!");
		info4.setForeground(Color.WHITE);
		info4.setFont(new Font("Arial", Font.BOLD, 20));
		info4.setFocusable(false);
		info4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info4.setBackground(new Color(138, 43, 226));
		info4.setBounds(612, 313, 46, 40);
		body.add(info4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_9.setBounds(233, 352, 40, 40);
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
		tarefa_meta5.setBounds(283, 357, 314, 30);
		body.add(tarefa_meta5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_10.setBounds(273, 352, 339, 40);
		body.add(panel_10);
		
		JButton info5 = new JButton("!");
		info5.setForeground(Color.WHITE);
		info5.setFont(new Font("Arial", Font.BOLD, 20));
		info5.setFocusable(false);
		info5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		info5.setBackground(new Color(138, 43, 226));
		info5.setBounds(612, 352, 46, 40);
		body.add(info5);
		
		JLabel label = new JLabel("SUAS TAREFAS E METAS");
		label.setForeground(new Color(138, 43, 226));
		label.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		label.setBounds(287, 140, 319, 30);
		body.add(label);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_11.setBounds(233, 391, 40, 40);
		body.add(panel_11);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setSize(new Dimension(50, 50));
		checkBox.setPreferredSize(new Dimension(30, 30));
		checkBox.setMinimumSize(new Dimension(30, 30));
		checkBox.setMaximumSize(new Dimension(30, 30));
		checkBox.setMargin(new Insets(5, 5, 5, 5));
		checkBox.setHorizontalTextPosition(SwingConstants.CENTER);
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		checkBox.setBorder(null);
		checkBox.setAlignmentY(1.0f);
		panel_11.add(checkBox);
		
		JButton button = new JButton("!");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 20));
		button.setFocusable(false);
		button.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		button.setBackground(new Color(138, 43, 226));
		button.setBounds(612, 391, 46, 40);
		body.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(283, 396, 314, 30);
		body.add(label_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_12.setBounds(273, 391, 339, 40);
		body.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
		panel_13.setBounds(233, 430, 40, 40);
		body.add(panel_13);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setSize(new Dimension(50, 50));
		checkBox_1.setPreferredSize(new Dimension(30, 30));
		checkBox_1.setMinimumSize(new Dimension(30, 30));
		checkBox_1.setMaximumSize(new Dimension(30, 30));
		checkBox_1.setMargin(new Insets(5, 5, 5, 5));
		checkBox_1.setHorizontalTextPosition(SwingConstants.CENTER);
		checkBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		checkBox_1.setBorder(null);
		checkBox_1.setAlignmentY(1.0f);
		panel_13.add(checkBox_1);
		
		JButton button_1 = new JButton("!");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial", Font.BOLD, 20));
		button_1.setFocusable(false);
		button_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		button_1.setBackground(new Color(138, 43, 226));
		button_1.setBounds(612, 430, 46, 40);
		body.add(button_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(283, 435, 314, 30);
		body.add(label_2);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154), new Color(0, 250, 154)));
		panel_14.setBounds(273, 430, 339, 40);
		body.add(panel_14);
		
		JButton button_2 = new JButton("1");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial", Font.BOLD, 10));
		button_2.setFocusable(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(138, 43, 226));
		button_2.setBounds(380, 483, 20, 20);
		body.add(button_2);
		
		JButton button_3 = new JButton("2");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arial", Font.BOLD, 10));
		button_3.setFocusable(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(138, 43, 226));
		button_3.setBounds(437, 483, 20, 20);
		body.add(button_3);
		
		JButton button_4 = new JButton("3");
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Arial", Font.BOLD, 10));
		button_4.setFocusable(false);
		button_4.setBorder(null);
		button_4.setBackground(new Color(138, 43, 226));
		button_4.setBounds(488, 483, 20, 20);
		body.add(button_4);
		
	}
}
