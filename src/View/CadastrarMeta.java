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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarMeta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel body;
	private JTextField campoTitulo;
	private JTextField campoDescricao;
	private JTextField campoTags;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMeta frame = new CadastrarMeta();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastrarMeta() {
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
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setForeground(new Color(138, 43, 226));
		lblTitulo.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTitulo.setBounds(215, 173, 77, 36);
		body.add(lblTitulo);
		
		campoTitulo = new JTextField();
		campoTitulo.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoTitulo.setBackground(Color.LIGHT_GRAY);
		campoTitulo.setBounds(283, 174, 420, 36);
		body.add(campoTitulo);
		campoTitulo.setColumns(10);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarTarefaMeta cadastrarTarefaMeta = new CadastrarTarefaMeta();
				cadastrarTarefaMeta.setVisible(true);
				CadastrarMeta.this.dispose();
			}
		});
		btnVoltar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169)));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(50, 495, 126, 36);
		body.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
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
		
		JLabel lblMeta = new JLabel("CADASTRAR META");
		lblMeta.setForeground(new Color(138, 43, 226));
		lblMeta.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
		lblMeta.setBounds(353, 114, 271, 30);
		body.add(lblMeta);
		
		campoDescricao = new JTextField();
		campoDescricao.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoDescricao.setColumns(10);
		campoDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoDescricao.setBackground(Color.LIGHT_GRAY);
		campoDescricao.setBounds(283, 234, 420, 36);
		body.add(campoDescricao);
		
		campoTags = new JTextField();
		campoTags.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		campoTags.setColumns(10);
		campoTags.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		campoTags.setBackground(Color.LIGHT_GRAY);
		campoTags.setBounds(283, 292, 154, 36);
		body.add(campoTags);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 558, 894, 36);
		body.add(panel);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setForeground(new Color(138, 43, 226));
		lblDescricao.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblDescricao.setBounds(180, 233, 112, 36);
		body.add(lblDescricao);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setForeground(new Color(138, 43, 226));
		lblTags.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTags.setBounds(224, 291, 68, 36);
		body.add(lblTags);
		
		JLabel lblNivelDe = new JLabel("Nivel de ");
		lblNivelDe.setForeground(new Color(138, 43, 226));
		lblNivelDe.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblNivelDe.setBounds(490, 281, 77, 25);
		body.add(lblNivelDe);
		
		JLabel lblPrioridade = new JLabel("Prioridade:");
		lblPrioridade.setForeground(new Color(138, 43, 226));
		lblPrioridade.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblPrioridade.setBounds(463, 302, 104, 25);
		body.add(lblPrioridade);
		
		JComboBox comboBoxPrioridade = new JComboBox();
		comboBoxPrioridade.setBorder(null);
		comboBoxPrioridade.setBackground(Color.LIGHT_GRAY);
		comboBoxPrioridade.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		comboBoxPrioridade.setModel(new DefaultComboBoxModel(new String[] {"Muito Alta", "Alta", "M\u00E9dia", "Baixa", "Muito Baixa"}));
		comboBoxPrioridade.setMaximumRowCount(5);
		comboBoxPrioridade.setBounds(577, 292, 126, 36);
		body.add(comboBoxPrioridade);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(138, 43, 226));
		lblTipo.setFont(new Font("Source Sans Pro", Font.BOLD, 19));
		lblTipo.setBounds(224, 357, 59, 36);
		body.add(lblTipo);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Arte", "Com\u00E9rcio", "Divers\u00E3o", "Escola", "Gastronomia", "Inform\u00E1tica", "Literatura", "Trabalho", "Viajem", "Outro"}));
		comboBoxTipo.setMaximumRowCount(10);
		comboBoxTipo.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		comboBoxTipo.setBorder(null);
		comboBoxTipo.setBackground(Color.LIGHT_GRAY);
		comboBoxTipo.setBounds(283, 358, 420, 36);
		body.add(comboBoxTipo);
	}
}
