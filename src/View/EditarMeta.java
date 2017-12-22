package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import Controller.Agenda;
import Model.Tarefa;
import Model.Tipo;
import Model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class EditarMeta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTextField campoTitulo;
	private JTextField campoDescricao;
	private JTextField campoTags;
	
	Icon sucesso = new ImageIcon(getClass().getResource("/img/correct_icon.png"));
	Icon aviso = new ImageIcon(getClass().getResource("/img/warning_icon.png"));
	
	Agenda agenda = new Agenda();
	Usuario usuario = Login.getSessao();
	Tarefa meta = null;
	
	//TIPOS:
	Tipo arte = new Tipo("Arte");
	Tipo comercio = new Tipo("Comércio");
	Tipo diversao = new Tipo("Diversão");
	Tipo escola = new Tipo("Escola");
	Tipo gastronomia = new Tipo("Gastronomia");
	Tipo informatica = new Tipo("Informática");
	Tipo literatura = new Tipo("Literatura");
	Tipo trabalho = new Tipo("Trabalho");
	Tipo viajem = new Tipo("Viajem");
	Tipo outro = new Tipo("Outro");
	private JTextField campoBusca;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarMeta frame = new EditarMeta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditarMeta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smark | Editar Meta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 622);
		body = new JPanel();
		body.setFocusable(false);
		body.setBackground(Color.WHITE);
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(body);
		body.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Novo T\u00EDtulo:");
		lblTitulo.setForeground(new Color(138, 43, 226));
		lblTitulo.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTitulo.setBounds(166, 237, 126, 36);
		body.add(lblTitulo);
		
		campoTitulo = new JTextField();
		campoTitulo.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoTitulo.setBackground(Color.LIGHT_GRAY);
		campoTitulo.setBounds(283, 238, 420, 36);
		body.add(campoTitulo);
		campoTitulo.setColumns(10);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEditar inicial = new MenuEditar();
				inicial.setVisible(true);
				EditarMeta.this.dispose();
			}
		});
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		
		JLabel logo_reduced = new JLabel("");
		logo_reduced.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/img/logo_reduced.png")));
		logo_reduced.setBounds(50, 35, 233, 69);
		body.add(logo_reduced);
		
		JLabel lista1 = new JLabel("");
		lista1.setIcon(new ImageIcon(Login.class.getResource("/img/lista.png")));
		lista1.setBounds(0, 196, 170, 9);
		body.add(lista1);
		
		JLabel lblCadastro = new JLabel("EDITAR META");
		lblCadastro.setForeground(new Color(138, 43, 226));
		lblCadastro.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		lblCadastro.setBounds(390, 183, 182, 30);
		body.add(lblCadastro);
		
		campoDescricao = new JTextField();
		campoDescricao.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoDescricao.setColumns(10);
		campoDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoDescricao.setBackground(Color.LIGHT_GRAY);
		campoDescricao.setBounds(283, 298, 420, 36);
		body.add(campoDescricao);
		
		campoTags = new JTextField();
		campoTags.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoTags.setColumns(10);
		campoTags.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoTags.setBackground(Color.LIGHT_GRAY);
		campoTags.setBounds(283, 356, 154, 36);
		body.add(campoTags);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 558, 894, 36);
		body.add(panel);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setForeground(new Color(138, 43, 226));
		lblDescricao.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblDescricao.setBounds(180, 297, 112, 36);
		body.add(lblDescricao);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setForeground(new Color(138, 43, 226));
		lblTags.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTags.setBounds(224, 355, 68, 36);
		body.add(lblTags);
		
		JLabel lblNivelDe = new JLabel("Nivel de ");
		lblNivelDe.setForeground(new Color(138, 43, 226));
		lblNivelDe.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblNivelDe.setBounds(490, 345, 77, 25);
		body.add(lblNivelDe);
		
		JLabel lblPrioridade = new JLabel("Prioridade:");
		lblPrioridade.setForeground(new Color(138, 43, 226));
		lblPrioridade.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblPrioridade.setBounds(463, 366, 104, 25);
		body.add(lblPrioridade);
		
		JComboBox comboBoxPrioridade = new JComboBox();
		comboBoxPrioridade.setBorder(null);
		comboBoxPrioridade.setBackground(Color.LIGHT_GRAY);
		comboBoxPrioridade.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		comboBoxPrioridade.setModel(new DefaultComboBoxModel(new String[] {"Muito Alta", "Alta", "M\u00E9dia", "Baixa", "Muito Baixa"}));
		comboBoxPrioridade.setMaximumRowCount(5);
		comboBoxPrioridade.setBounds(577, 356, 126, 36);
		body.add(comboBoxPrioridade);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(138, 43, 226));
		lblTipo.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTipo.setBounds(224, 421, 59, 36);
		body.add(lblTipo);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Arte", "Com\u00E9rcio", "Divers\u00E3o", "Escola", "Gastronomia", "Inform\u00E1tica", "Literatura", "Trabalho", "Viajem", "Outro"}));
		comboBoxTipo.setMaximumRowCount(10);
		comboBoxTipo.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		comboBoxTipo.setBorder(null);
		comboBoxTipo.setBackground(Color.LIGHT_GRAY);
		comboBoxTipo.setBounds(283, 422, 420, 36);
		body.add(comboBoxTipo);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(EditarMeta.class.getResource("/img/edit_icon.png")));
		btnEditar.setToolTipText("Edi\u00E7\u00E3o concluida");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(campoTitulo.getText().equals("") || campoDescricao.getText().equals("") || campoTags.getText().equals("")) {	
					JOptionPane.showMessageDialog(EditarMeta.this, "Preencha todos os campos corretamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				} else {
					int prioridade = 5;
					if (comboBoxPrioridade.getSelectedItem().equals("Muito Alta")) 
						prioridade = 5;
					 else if (comboBoxPrioridade.getSelectedItem().equals("Alta")) 
						prioridade = 4;
					 else if (comboBoxPrioridade.getSelectedItem().equals("Média")) 
						prioridade = 3;
					 else if (comboBoxPrioridade.getSelectedItem().equals("Baixa"))
						prioridade = 2;
					 else if (comboBoxPrioridade.getSelectedItem().equals("Muito Baixa")) 
						prioridade = 1;
					
					meta.setTitulo(campoTitulo.getText().trim().toLowerCase());
					meta.setDescricao(campoDescricao.getText().trim());
					meta.setTags(campoTags.getText().trim());
					meta.setPrioridade(prioridade);
					
					if (comboBoxTipo.getSelectedItem().equals("Arte")) {
						arte.adicionarTarefa(meta);
						meta.setTipo(0);
					} else if (comboBoxTipo.getSelectedItem().equals("Comércio")) {
						comercio.adicionarTarefa(meta);
						meta.setTipo(1);
					} else if (comboBoxTipo.getSelectedItem().equals("Diversão")) {
						diversao.adicionarTarefa(meta);
						meta.setTipo(2);
					} else if (comboBoxTipo.getSelectedItem().equals("Escola")) {
						escola.adicionarTarefa(meta);
						meta.setTipo(3);
					} else if (comboBoxTipo.getSelectedItem().equals("Gastronomia")) {
						gastronomia.adicionarTarefa(meta);
						meta.setTipo(4);
					} else if (comboBoxTipo.getSelectedItem().equals("Informática")) {
						informatica.adicionarTarefa(meta);
						meta.setTipo(5);
					} else if (comboBoxTipo.getSelectedItem().equals("Literatura")) {
						literatura.adicionarTarefa(meta);
						meta.setTipo(6);
					} else if (comboBoxTipo.getSelectedItem().equals("Trabalho")) {
						trabalho.adicionarTarefa(meta);
						meta.setTipo(7);
					} else if (comboBoxTipo.getSelectedItem().equals("Viajem")) {
						viajem.adicionarTarefa(meta);
						meta.setTipo(8);
					} else if (comboBoxTipo.getSelectedItem().equals("Outro")) {
						outro.adicionarTarefa(meta);
						meta.setTipo(9);
					}
					
					if(usuario != null){
						if(agenda.editarMeta(meta, usuario)){
							JOptionPane.showMessageDialog(EditarMeta.this, "Meta atualizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, sucesso);
							clear(comboBoxTipo, comboBoxTipo);
						}
					}else{
						JOptionPane.showMessageDialog(EditarMeta.this, "Sessão do usuário encerrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
					}
				}
			}
		});
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnEditar.setBounds(772, 495, 68, 36);
		body.add(btnEditar);
		
		JButton btnRemover = new JButton("");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(agenda.removerMeta(meta.getTitulo(), usuario)){
					JOptionPane.showMessageDialog(EditarMeta.this, "Meta removida com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, sucesso);
					clear(comboBoxTipo, comboBoxTipo);
				} else {
					JOptionPane.showMessageDialog(EditarMeta.this, "Opss, não foi possível remover meta!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		btnRemover.setIcon(new ImageIcon(EditarMeta.class.getResource("/img/remove_icon.png")));
		btnRemover.setToolTipText("Remover");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnRemover.setEnabled(false);
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.setBounds(772, 401, 68, 36);
		body.add(btnRemover);
		
		JButton btnConcluir = new JButton("");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(agenda.concluirMeta(meta.getTitulo(), usuario)){
					JOptionPane.showMessageDialog(EditarMeta.this, "Tarefa concluída com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, sucesso);
					clear(comboBoxTipo, comboBoxTipo);
				} else {
					JOptionPane.showMessageDialog(EditarMeta.this, "Opss, não foi possível concluir tarefa!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		btnConcluir.setIcon(new ImageIcon(EditarMeta.class.getResource("/img/conclude_icon.png")));
		btnConcluir.setToolTipText("Concluir");
		btnConcluir.setForeground(Color.WHITE);
		btnConcluir.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnConcluir.setEnabled(false);
		btnConcluir.setBackground(Color.LIGHT_GRAY);
		btnConcluir.setBounds(772, 448, 68, 36);
		body.add(btnConcluir);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario != null){
					if(!campoBusca.getText().equals("")) 
						meta = agenda.buscarMetaPorTitulo(campoBusca.getText().trim().toLowerCase(), usuario);
					else {
						JOptionPane.showMessageDialog(EditarMeta.this, "Digite um título válido!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
					}
					if (meta != null) {
						btnEditar.setBackground(new Color(138, 43, 226));
						btnRemover.setBackground(new Color(165, 42, 42));
						btnConcluir.setBackground(new Color(32, 178, 170));
						btnEditar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnConcluir.setEnabled(true);
						
						//CAMPOS PARA EDITAR
						campoBusca.setText("");
						campoTitulo.setText(meta.getTitulo());
						campoDescricao.setText(meta.getDescricao());
						campoTags.setText(meta.getTags());
						comboBoxPrioridade.setSelectedIndex(((meta.getPrioridade())-5)*-1);
						
						comboBoxTipo.setSelectedIndex(meta.getTipo());
						
					}else{ 
						JOptionPane.showMessageDialog(EditarMeta.this, "Tarefa não encontrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
					}
				} else {
					JOptionPane.showMessageDialog(EditarMeta.this, "Sessão encerrada!!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(EditarMeta.class.getResource("/img/search_icon.png")));
		button.setBorder(null);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		button.setBackground(new Color(138, 43, 226));
		button.setBounds(651, 115, 52, 35);
		body.add(button);
		
		campoBusca = new JTextField();
		campoBusca.setForeground(Color.DARK_GRAY);
		campoBusca.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoBusca.setBounds(283, 115, 372, 36);
		body.add(campoBusca);
		campoBusca.setColumns(10);
		
		JLabel lblTtuloDaTarefa = new JLabel("T\u00EDtulo da meta:");
		lblTtuloDaTarefa.setForeground(Color.GRAY);
		lblTtuloDaTarefa.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
		lblTtuloDaTarefa.setBounds(406, 91, 149, 14);
		body.add(lblTtuloDaTarefa);
	}
	
	public void clear(JComboBox<?> comboBoxPrioridade, JComboBox<?> comboBoxTipo){
		campoTitulo.setText("");
		campoDescricao.setText("");
		campoTags.setText("");
		comboBoxPrioridade.setSelectedIndex(0);
		comboBoxTipo.setSelectedIndex(0);
	}
	public void setTarefa(Tarefa umaTarefa){
		meta = umaTarefa;
		if (meta != null) {
			campoBusca.setText(meta.getTitulo());
		}
	}
}
