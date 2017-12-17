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
	private JTable table;
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
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		table.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
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
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(124);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
		table.getColumnModel().getColumn(3).setPreferredWidth(38);
		table.getColumnModel().getColumn(4).setPreferredWidth(53);
		table.setBounds(0, 70, 669, 350);
		visualizador.getContentPane().add(table);
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
		btnTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("TAREFAS");
				runJtableTarefas(table, 1);
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
				runJtablMetas(table, 1);
				visualizador.setVisible(true);
			}
		});
		btnMetas.setFocusable(false);
		btnMetas.setForeground(Color.WHITE);
		btnMetas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMetas.setBackground(new Color(102, 205, 170));
		btnMetas.setBounds(459, 248, 200, 45);
		body.add(btnMetas);
		
		JButton btnTPendentes = new JButton("TAREFAS PENDENTES");
		btnTPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("TAREFAS PENDENTES");
				runJtableTarefas(table, 3);
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
				runJtableTarefas(table, 2);
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
				visualizador.setVisible(true);
			}
		});
		btnMPendentes.setForeground(Color.WHITE);
		btnMPendentes.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMPendentes.setFocusable(false);
		btnMPendentes.setBackground(new Color(102, 205, 170));
		btnMPendentes.setBounds(459, 374, 200, 46);
		body.add(btnMPendentes);
		
		JButton btnMConcluidas = new JButton("METAS CONCLU\u00CDDAS");
		btnMConcluidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloVisualizador.setText("METAS CONCLUÍDAS");
				visualizador.setVisible(true);
			}
		});
		btnMConcluidas.setForeground(Color.WHITE);
		btnMConcluidas.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnMConcluidas.setFocusable(false);
		btnMConcluidas.setBackground(new Color(102, 205, 170));
		btnMConcluidas.setBounds(459, 311, 200, 46);
		body.add(btnMConcluidas);
	}
	public void runJtableTarefas(JTable table, int opc){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		Agenda agenda = new Agenda();
		ArrayList<Tarefa> tarefas_metas = null;
		
		if(opc == 1)
			tarefas_metas = agenda.exibirTodasTarefas(usuario);
		else if (opc == 2)
			tarefas_metas = agenda.exibirTarefasConcluidas(usuario);
		else if (opc == 3)
			tarefas_metas = agenda.exibirTarefasNaoCumpridas(usuario);
		
		for (Tarefa tarefa : tarefas_metas) {
			model.addRow(new Object[]{
					tarefa.getTitulo(),
					tarefa.getDescricao(),
					tarefa.getTags(),
					tarefa.getPrioridade(),
					tarefa.getData(),
			});
		}
	}
	public void runJtablMetas(JTable table, int opc){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		ArrayList<Tarefa> tarefas_metas = null;
		Agenda agenda = new Agenda();
		
		if(opc == 1)
			tarefas_metas = agenda.exibirTodasMetas(usuario);
		/*else if (opc == 2)
			tarefas_metas = agenda.exibirMetasConcluidas(usuario);
		else if (opc == 3)
			tarefas_metas = agenda.exibirMetasNaoCumpridas(usuario);*/
		
		
		for (Tarefa tarefa : tarefas_metas) {
			model.addRow(new Object[]{
					tarefa.getTitulo(),
					tarefa.getDescricao(),
					tarefa.getTags(),
					tarefa.getPrioridade(),
			});
		}
	}
}
