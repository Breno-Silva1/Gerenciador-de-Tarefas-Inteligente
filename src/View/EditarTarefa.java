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

import com.toedter.calendar.JDateChooser;

import Controller.Agenda;
import Model.Tarefa;
import Model.Tipo;
import Model.Usuario;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class EditarTarefa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTextField campoTitulo;
	private JTextField campoDescricao;
	private JTextField campoTags;
	
	Icon sucesso = new ImageIcon(getClass().getResource("/img/correct_icon.png"));
	Icon aviso = new ImageIcon(getClass().getResource("/img/warning_icon.png"));
	
	Agenda agenda = new Agenda();
	Usuario usuario = Login.getSessao();
	Tarefa tarefa = null;
	
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
					EditarTarefa frame = new EditarTarefa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditarTarefa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icon.png")));
		setTitle("Smarck | Editar Tarefa");
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
				EditarTarefa.this.dispose();
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
		
		JLabel lblCadastro = new JLabel("EDITAR TAREFA");
		lblCadastro.setForeground(new Color(138, 43, 226));
		lblCadastro.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		lblCadastro.setBounds(400, 182, 214, 30);
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
		
		JLabel lblPrazo = new JLabel("Prazo:");
		lblPrazo.setForeground(new Color(138, 43, 226));
		lblPrazo.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblPrazo.setBounds(215, 422, 77, 36);
		body.add(lblPrazo);
		
		JDateChooser data_tarefa = new JDateChooser();
		data_tarefa.getCalendarButton().setIcon(new ImageIcon(CadastrarTarefa.class.getResource("/img/calendar_icon.png")));
		data_tarefa.setBackground(Color.LIGHT_GRAY);
		data_tarefa.setBounds(283, 422, 154, 36);
		Date dataDeHoje = new Date();
		data_tarefa.setMinSelectableDate(dataDeHoje);
		body.add(data_tarefa);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(138, 43, 226));
		lblTipo.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTipo.setBounds(508, 422, 59, 36);
		body.add(lblTipo);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Arte", "Com\u00E9rcio", "Divers\u00E3o", "Escola", "Gastronomia", "Inform\u00E1tica", "Literatura", "Trabalho", "Viajem", "Outro"}));
		comboBoxTipo.setMaximumRowCount(10);
		comboBoxTipo.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		comboBoxTipo.setBorder(null);
		comboBoxTipo.setBackground(Color.LIGHT_GRAY);
		comboBoxTipo.setBounds(577, 422, 126, 36);
		body.add(comboBoxTipo);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(EditarTarefa.class.getResource("/img/edit_icon.png")));
		btnEditar.setToolTipText("Edi\u00E7\u00E3o concluida");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataDeHoje = new Date();
				DateFormat df = DateFormat.getDateInstance();
				String dataHoje = df.format(dataDeHoje);
				String data = df.format(data_tarefa.getDate());
				
				if(campoTitulo.getText().equals("") || campoDescricao.getText().equals("") || campoTags.getText().equals("") || data_tarefa.getDate() == null) {	
					JOptionPane.showMessageDialog(EditarTarefa.this, "Preencha todos os campos corretamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				} else {
					if (dataDeHoje.before(data_tarefa.getDate()) || dataHoje.equals(data)) {
						
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
						
						tarefa.setTitulo(campoTitulo.getText().trim().toLowerCase());
						tarefa.setDescricao(campoDescricao.getText().trim());
						tarefa.setTags(campoTags.getText().trim());
						tarefa.setData(data);
						tarefa.setPrioridade(prioridade);
						
						if (comboBoxTipo.getSelectedItem().equals("Arte")) {
							arte.adicionarTarefa(tarefa);
							tarefa.setTipo(0);
						} else if (comboBoxTipo.getSelectedItem().equals("Comércio")) {
							comercio.adicionarTarefa(tarefa);
							tarefa.setTipo(1);
						} else if (comboBoxTipo.getSelectedItem().equals("Diversão")) {
							diversao.adicionarTarefa(tarefa);
							tarefa.setTipo(2);
						} else if (comboBoxTipo.getSelectedItem().equals("Escola")) {
							escola.adicionarTarefa(tarefa);
							tarefa.setTipo(3);
						} else if (comboBoxTipo.getSelectedItem().equals("Gastronomia")) {
							gastronomia.adicionarTarefa(tarefa);
							tarefa.setTipo(4);
						} else if (comboBoxTipo.getSelectedItem().equals("Informática")) {
							informatica.adicionarTarefa(tarefa);
							tarefa.setTipo(5);
						} else if (comboBoxTipo.getSelectedItem().equals("Literatura")) {
							literatura.adicionarTarefa(tarefa);
							tarefa.setTipo(6);
						} else if (comboBoxTipo.getSelectedItem().equals("Trabalho")) {
							trabalho.adicionarTarefa(tarefa);
							tarefa.setTipo(7);
						} else if (comboBoxTipo.getSelectedItem().equals("Viajem")) {
							viajem.adicionarTarefa(tarefa);
							tarefa.setTipo(8);
						} else if (comboBoxTipo.getSelectedItem().equals("Outro")) {
							outro.adicionarTarefa(tarefa);
							tarefa.setTipo(9);
						}
						
						if(usuario != null){
							if(agenda.editarTarefa(tarefa, usuario)){
								JOptionPane.showMessageDialog(EditarTarefa.this, "Tarefa atualizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, sucesso);
								clear(comboBoxTipo, comboBoxTipo, data_tarefa);
							}
							
						}else{
							JOptionPane.showMessageDialog(EditarTarefa.this, "Sessão do usuário encerrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
						}
						
					}	else {
						JOptionPane.showMessageDialog(EditarTarefa.this, "Selecione uma data válida!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
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
				if(agenda.removerTarefa(tarefa.getTitulo(), usuario)){
					JOptionPane.showMessageDialog(EditarTarefa.this, "Tarefa removida com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, sucesso);
					clear(comboBoxTipo, comboBoxTipo, data_tarefa);
				} else {
					JOptionPane.showMessageDialog(EditarTarefa.this, "Opss, não foi possível remover tarefa!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		btnRemover.setIcon(new ImageIcon(EditarTarefa.class.getResource("/img/remove_icon.png")));
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
				if(agenda.concluirTarefa(tarefa.getTitulo(), usuario)){
					JOptionPane.showMessageDialog(EditarTarefa.this, "Tarefa concluída com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, sucesso);
					clear(comboBoxTipo, comboBoxTipo, data_tarefa);
				} else {
					JOptionPane.showMessageDialog(EditarTarefa.this, "Opss, não foi possível concluir tarefa!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		btnConcluir.setIcon(new ImageIcon(EditarTarefa.class.getResource("/img/conclude_icon.png")));
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
						tarefa = agenda.buscarTarefaPorTitulo(campoBusca.getText().trim().toLowerCase(), usuario);
					else {
						JOptionPane.showMessageDialog(EditarTarefa.this, "Digite um título válido!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
					}
					if (tarefa != null) {
						btnEditar.setBackground(new Color(138, 43, 226));
						btnRemover.setBackground(new Color(165, 42, 42));
						btnConcluir.setBackground(new Color(32, 178, 170));
						btnEditar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnConcluir.setEnabled(true);
						
						//CAMPOS PARA EDITAR
						campoBusca.setText("");
						campoTitulo.setText(tarefa.getTitulo());
						campoDescricao.setText(tarefa.getDescricao());
						campoTags.setText(tarefa.getTags());
						comboBoxPrioridade.setSelectedIndex(((tarefa.getPrioridade())-5)*-1);
						
						try {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date data = new java.sql.Date(formatter.parse(tarefa.getData()).getTime());
							data_tarefa.setDate(data);
							
						} catch (ParseException e1) {
							//e1.printStackTrace();
						}
						comboBoxTipo.setSelectedIndex(tarefa.getTipo());
						
					}else{ 
						JOptionPane.showMessageDialog(EditarTarefa.this, "Tarefa não encontrada!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
					}
				} else {
					JOptionPane.showMessageDialog(EditarTarefa.this, "Sessão encerrada!!", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
				}
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(EditarTarefa.class.getResource("/img/search_icon.png")));
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
		
		JLabel lblTtuloDaTarefa = new JLabel("T\u00EDtulo da tarefa:");
		lblTtuloDaTarefa.setForeground(Color.GRAY);
		lblTtuloDaTarefa.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
		lblTtuloDaTarefa.setBounds(433, 90, 154, 14);
		body.add(lblTtuloDaTarefa);
		
	}
	public void clear(JComboBox<?> comboBoxPrioridade, JComboBox<?> comboBoxTipo, JDateChooser data_tarefa){
		campoTitulo.setText("");
		campoDescricao.setText("");
		campoTags.setText("");
		comboBoxPrioridade.setSelectedIndex(0);
		comboBoxTipo.setSelectedIndex(0);
		data_tarefa.setDate(null);
	}
}
