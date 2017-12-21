package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Agenda;
import Model.Tarefa;
import Model.Usuario;

public class MenuTarefasEMetas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTable tableTarefasCumpridasENaoCumpridas;
	private JTable tableTodasTarefas;
	private JTable tableMetasCumpridasENaoCumpridas;
	private JTable tableTodasMetas;
	
	Icon sucesso = new ImageIcon(getClass().getResource("/img/correct_icon.png"));
	Icon aviso = new ImageIcon(getClass().getResource("/img/warning_icon.png"));
	
	Usuario usuario = Login.getSessao();

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
	
	@SuppressWarnings("serial")
	public MenuTarefasEMetas() throws PropertyVetoException {
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
		
		JInternalFrame visualizador = new JInternalFrame("Visualiza\u00E7\u00E3o");
		visualizador.setFrameIcon(new ImageIcon(MenuTarefasEMetas.class.getResource("/img/icon.png")));
		visualizador.setIcon(true);
		visualizador.setSelected(true);
		visualizador.setClosable(true);
		visualizador.setBackground(new Color(230, 230, 250));
		visualizador.setBounds(104, 35, 685, 449);
		body.add(visualizador);
		visualizador.setVisible(false);
		visualizador.getContentPane().setLayout(null);
		
		JLabel tituloVisualizador = new JLabel("");
		tituloVisualizador.setForeground(new Color(138, 43, 226));
		tituloVisualizador.setHorizontalAlignment(SwingConstants.CENTER);
		tituloVisualizador.setFont(new Font("Source Sans Pro", Font.BOLD, 26));
		tituloVisualizador.setBounds(0, 0, 669, 51);
		visualizador.getContentPane().add(tituloVisualizador);
		
		//TABELA DAS TAREFAS
		tableTarefasCumpridasENaoCumpridas = new JTable();
		tableTarefasCumpridasENaoCumpridas.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		tableTarefasCumpridasENaoCumpridas.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		tableTarefasCumpridasENaoCumpridas.setModel(new DefaultTableModel(
			new Object[][] {
				{"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade", "Prazo"},
			},
			new String[] {
				"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade", "Prazo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTarefasCumpridasENaoCumpridas.getColumnModel().getColumn(0).setPreferredWidth(89);
		tableTarefasCumpridasENaoCumpridas.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableTarefasCumpridasENaoCumpridas.getColumnModel().getColumn(2).setPreferredWidth(57);
		tableTarefasCumpridasENaoCumpridas.getColumnModel().getColumn(3).setPreferredWidth(38);
		tableTarefasCumpridasENaoCumpridas.getColumnModel().getColumn(4).setPreferredWidth(53);
		tableTarefasCumpridasENaoCumpridas.setBounds(10, 70, 649, 339);
		visualizador.getContentPane().add(tableTarefasCumpridasENaoCumpridas);
		
		tableTodasTarefas = new JTable();
		tableTodasTarefas.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		tableTodasTarefas.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		tableTodasTarefas.setModel(new DefaultTableModel(
			new Object[][] {
				{"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade", "Prazo", "Estado"},
			},
			new String[] {
				"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade", "Prazo", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTodasTarefas.getColumnModel().getColumn(0).setPreferredWidth(89);
		tableTodasTarefas.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableTodasTarefas.getColumnModel().getColumn(2).setPreferredWidth(57);
		tableTodasTarefas.getColumnModel().getColumn(3).setPreferredWidth(38);
		tableTodasTarefas.getColumnModel().getColumn(4).setPreferredWidth(53);
		tableTodasTarefas.getColumnModel().getColumn(5).setPreferredWidth(48);
		tableTodasTarefas.setBounds(10, 70, 649, 339);
		visualizador.getContentPane().add(tableTodasTarefas);
		
		//TABELA DAS METAS
		tableTodasMetas = new JTable();
		tableTodasMetas.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		tableTodasMetas.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		tableTodasMetas.setModel(new DefaultTableModel(
			new Object[][] {
				{"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade", "Estado"},
			},
			new String[] {
				"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTodasMetas.getColumnModel().getColumn(0).setPreferredWidth(89);
		tableTodasMetas.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableTodasMetas.getColumnModel().getColumn(2).setPreferredWidth(57);
		tableTodasMetas.getColumnModel().getColumn(3).setPreferredWidth(38);
		tableTodasMetas.getColumnModel().getColumn(4).setPreferredWidth(56);
		tableTodasMetas.setBounds(10, 70, 649, 339);
		visualizador.getContentPane().add(tableTodasMetas);
		
		tableMetasCumpridasENaoCumpridas = new JTable();
		tableMetasCumpridasENaoCumpridas.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		tableMetasCumpridasENaoCumpridas.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		tableMetasCumpridasENaoCumpridas.setModel(new DefaultTableModel(
			new Object[][] {
				{"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade"},
			},
			new String[] {
				"T\u00EDtulo", "Descri\u00E7\u00E3o", "Tags", "Prioridade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMetasCumpridasENaoCumpridas.getColumnModel().getColumn(0).setPreferredWidth(89);
		tableMetasCumpridasENaoCumpridas.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableMetasCumpridasENaoCumpridas.getColumnModel().getColumn(2).setPreferredWidth(59);
		tableMetasCumpridasENaoCumpridas.getColumnModel().getColumn(3).setPreferredWidth(38);
		tableMetasCumpridasENaoCumpridas.setBounds(10, 70, 649, 339);
		visualizador.getContentPane().add(tableMetasCumpridasENaoCumpridas);
		
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		/*
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
		*/
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
		btnTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("TAREFAS");
				runJtableTodasTarefas(tableTodasTarefas);
				visualizador.getContentPane().add(tableTodasTarefas);
				visualizador.remove(tableTarefasCumpridasENaoCumpridas);
				visualizador.remove(tableMetasCumpridasENaoCumpridas);
				visualizador.remove(tableTodasMetas);
				visualizador.setVisible(true);
			}
		});
		btnTarefas.setFocusable(false);
		btnTarefas.setForeground(Color.WHITE);
		btnTarefas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnTarefas.setBackground(new Color(138, 43, 226));
		btnTarefas.setBounds(230, 248, 200, 45);
		body.add(btnTarefas);
		
		JButton btnMetas = new JButton("METAS");
		btnMetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("METAS");
				runJtablTodasMetas(tableTodasMetas);
				visualizador.getContentPane().add(tableTodasMetas);
				visualizador.remove(tableTodasTarefas);
				visualizador.remove(tableTarefasCumpridasENaoCumpridas);
				visualizador.remove(tableMetasCumpridasENaoCumpridas);
				visualizador.setVisible(true);
			}
		});
		btnMetas.setFocusable(false);
		btnMetas.setForeground(Color.WHITE);
		btnMetas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMetas.setBackground(new Color(3, 209, 170));
		btnMetas.setBounds(459, 248, 200, 45);
		body.add(btnMetas);
		
		JButton btnTPendentes = new JButton("TAREFAS PENDENTES");
		btnTPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("TAREFAS PENDENTES");
				runJtableTarefas(tableTarefasCumpridasENaoCumpridas, 2);
				visualizador.getContentPane().add(tableTarefasCumpridasENaoCumpridas);
				visualizador.remove(tableMetasCumpridasENaoCumpridas);
				visualizador.remove(tableTodasMetas);
				visualizador.remove(tableTodasTarefas);
				visualizador.setVisible(true);
			}
		});
		btnTPendentes.setFocusable(false);
		btnTPendentes.setForeground(Color.WHITE);
		btnTPendentes.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnTPendentes.setBackground(new Color(138, 43, 226));
		btnTPendentes.setBounds(230, 374, 200, 46);
		body.add(btnTPendentes);
		
		JButton btnTConcluidas = new JButton("TAREFAS CONCLU\u00CDDAS");
		btnTConcluidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("TAREFAS CONCLUÍDAS");
				runJtableTarefas(tableTarefasCumpridasENaoCumpridas, 1);
				visualizador.getContentPane().add(tableTarefasCumpridasENaoCumpridas);
				visualizador.remove(tableTodasTarefas);
				visualizador.remove(tableMetasCumpridasENaoCumpridas);
				visualizador.remove(tableTodasMetas);
				visualizador.setVisible(true);
			}
		});
		btnTConcluidas.setFocusable(false);
		btnTConcluidas.setForeground(Color.WHITE);
		btnTConcluidas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnTConcluidas.setBackground(new Color(138, 43, 226));
		btnTConcluidas.setBounds(230, 311, 200, 46);
		body.add(btnTConcluidas);
		
		JButton btnMPendentes = new JButton("METAS PENDENTES");
		btnMPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("METAS PENDENTES");
				runJtablMetas(tableMetasCumpridasENaoCumpridas, 2);
				visualizador.getContentPane().add(tableMetasCumpridasENaoCumpridas);
				visualizador.remove(tableTarefasCumpridasENaoCumpridas);
				visualizador.remove(tableTodasMetas);
				visualizador.remove(tableTodasTarefas);
				visualizador.setVisible(true);
			}
		});
		btnMPendentes.setForeground(Color.WHITE);
		btnMPendentes.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMPendentes.setFocusable(false);
		btnMPendentes.setBackground(new Color(3, 209, 170));
		btnMPendentes.setBounds(459, 374, 200, 46);
		body.add(btnMPendentes);
		
		JButton btnMConcluidas = new JButton("METAS CONCLU\u00CDDAS");
		btnMConcluidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("METAS CONCLUÍDAS");
				runJtablMetas(tableMetasCumpridasENaoCumpridas, 1);
				visualizador.getContentPane().add(tableMetasCumpridasENaoCumpridas);
				visualizador.remove(tableTarefasCumpridasENaoCumpridas);
				visualizador.remove(tableTodasMetas);
				visualizador.remove(tableTodasTarefas);
				visualizador.setVisible(true);
			}
		});
		btnMConcluidas.setForeground(Color.WHITE);
		btnMConcluidas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMConcluidas.setFocusable(false);
		btnMConcluidas.setBackground(new Color(3, 209, 170));
		btnMConcluidas.setBounds(459, 311, 200, 46);
		body.add(btnMConcluidas);
	}
	
	public void runJtableTodasTarefas(JTable table){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		Agenda agenda = new Agenda();
		
		if(usuario != null){
			ArrayList<Tarefa> tarefas_metas = agenda.exibirTodasTarefas(usuario);
			for (Tarefa tarefa : tarefas_metas) {
				model.addRow(new Object[]{
						tarefa.getTitulo().toUpperCase(),
						tarefa.getDescricao(),
						tarefa.getTags(),
						tarefa.getPrioridade(),
						tarefa.getData(),
						tarefa.getEstado(),
				});
			}
		} else {
			JOptionPane.showMessageDialog(MenuTarefasEMetas.this, "Sessão do usuário encerrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
		}
	}
	
	public void runJtableTarefas(JTable table, int opc){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		Agenda agenda = new Agenda();
		ArrayList<Tarefa> tarefas_metas = null;
		
		if(usuario != null){
			if (opc == 1)
				tarefas_metas = agenda.exibirTarefasConcluidas(usuario);
			else if (opc == 2)
				tarefas_metas = agenda.exibirTarefasNaoCumpridas(usuario);
			
			for (Tarefa tarefa : tarefas_metas) {
				model.addRow(new Object[]{
						tarefa.getTitulo().toUpperCase(),
						tarefa.getDescricao(),
						tarefa.getTags(),
						tarefa.getPrioridade(),
						tarefa.getData(),
				});
			}
		} else {
			JOptionPane.showMessageDialog(MenuTarefasEMetas.this, "Sessão do usuário encerrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
		}
	}
	
	public void runJtablTodasMetas(JTable table){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		Agenda agenda = new Agenda();
		if(usuario != null){
			ArrayList<Tarefa> tarefas_metas = agenda.exibirTodasMetas(usuario);
			for (Tarefa tarefa : tarefas_metas) {
				model.addRow(new Object[]{
						tarefa.getTitulo().toUpperCase(),
						tarefa.getDescricao(),
						tarefa.getTags(),
						tarefa.getPrioridade(),
						tarefa.getEstado(),
				});
			} 
		} else {
			JOptionPane.showMessageDialog(MenuTarefasEMetas.this, "Sessão do usuário encerrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
		}
	}
	
	public void runJtablMetas(JTable table, int opc){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		ArrayList<Tarefa> tarefas_metas = null;
		Agenda agenda = new Agenda();
		if(usuario != null){
			if (opc == 1)
				tarefas_metas = agenda.exibirMetasConcluidas(usuario);
			else if (opc == 2)
				tarefas_metas = agenda.exibirMetasNaoCumpridas(usuario);
			
			for (Tarefa tarefa : tarefas_metas) {
				model.addRow(new Object[]{
						tarefa.getTitulo().toUpperCase(),
						tarefa.getDescricao(),
						tarefa.getTags(),
						tarefa.getPrioridade(),
				});
			} 
		} else {
			JOptionPane.showMessageDialog(MenuTarefasEMetas.this, "Sessão do usuário encerrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
		}
	}
}
