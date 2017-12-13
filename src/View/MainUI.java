package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Agenda;
import Controller.UsuarioDAO;
import Model.Tarefa;
import Model.Tipo;
import Model.Usuario;

public class MainUI {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		Agenda agenda = new Agenda();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		boolean autenticado = false;
		
		Tipo musica = new Tipo("Música");
		Tipo design = new Tipo("Design");
		Tipo estudo = new Tipo("Estudo");
		
		while(!autenticado){
			menuLogin();
			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				System.out.println();
				System.out.println("Username ou Email: ");
				String login = scanner.nextLine();
				login = scanner.nextLine();
				System.out.println("Senha: ");
				String senha = scanner.nextLine();
				usuario = dao.autenticar(login, senha);
				
				if (usuario != null) 
					autenticado = true;
				else
					System.out.println("Usuário não encontrado!");
				
				break;
			
			case 2:
				System.out.println();
				System.out.println("Nome: ");
				String nome = scanner.nextLine();
				nome = scanner.nextLine();
				System.out.println("Username: ");
				String username = scanner.nextLine();
				System.out.println("Email: ");
				String email = scanner.nextLine();
				System.out.println("Senha: ");
				String senhaUser = scanner.nextLine();
				usuario = new Usuario(nome, username, email, senhaUser);
				
				if (dao.cadastrarUsuario(usuario)){
					System.out.println("Usuário cadastrado!");
				} else {
					System.out.println("Usuário não cadastrado!");
				}
				
				break;
	
			default:
				break;
			}
		}
		
		if(autenticado){
			menu();
			int opc = scanner.nextInt();
			
			switch (opc) {
			case 1:
				System.out.println(usuario.getId());
				System.out.print("Quantas tarefas deseja adicionar: ");
				int x = scanner.nextInt();
				
				for(int i = 0; i < x; i++) {
					System.out.println("Digite um título: ");
					String titulo = scanner.nextLine();
					titulo = scanner.nextLine();
					
					System.out.println("Digite um descrição: ");
					String descricao = scanner.nextLine();
					
					System.out.println("Digite um Tags: ");
					String tags = scanner.nextLine();
					
					System.out.println("Digite um prioridade: ");
					int prioridade = scanner.nextInt();
					
					System.out.println("Digite um data: ");
					String data = scanner.nextLine();
					data = scanner.nextLine();
					
					Tarefa firstTask = new Tarefa(titulo, descricao, tags, prioridade, data);
					Tarefa firstMeta = new Tarefa(titulo, descricao, tags, prioridade);
					
					System.out.println("Escolha o tipo da tarefa: ");
					System.out.println("1. " + musica.getNome_tipo());
					System.out.println("2. " + design.getNome_tipo());
					System.out.println("3. " + estudo.getNome_tipo());
					System.out.print(">> ");
					int opc2 = scanner.nextInt();
					
					if (opc2 == 1) 
						musica.adicionarTarefa(firstTask);
					else if (opc2 == 2) 
						design.adicionarTarefa(firstTask);
					else if (opc2 == 3) 
						estudo.adicionarTarefa(firstTask);
					
					agenda.cadastrarTarefa(firstTask, usuario);
					
					if(agenda.cadastrarMeta(firstMeta, usuario)) {
						System.out.println("Meta cadastrada!");
					} else {
						System.out.println("Não foi possível cadastrar Meta!");
					}
				}
				break;
				
			case 2:
				System.out.println("Título da Tarefa: ");
				String tituloRemover = scanner.nextLine();
				tituloRemover = scanner.nextLine();
				agenda.removerTarefa(tituloRemover, usuario);		
				break;
				
			case 3:
				System.out.println("Digite o título: ");
				String titulo = scanner.nextLine();
				titulo = scanner.nextLine();
				
				System.out.println("Digite novo título: ");
				String tituloeditar = scanner.nextLine();
				
				System.out.println("Digite nova descrição: ");
				String descricao = scanner.nextLine();
				
				System.out.println("Digite nova Tags: ");
				String tags = scanner.nextLine();
				
				System.out.println("Digite nova prioridade: ");
				int prioridade = scanner.nextInt();
				
				System.out.println("Digite nova data: ");
				String data = scanner.nextLine();
				data = scanner.nextLine();
				
				Tarefa tarefaEditar = new Tarefa(tituloeditar, descricao, tags, prioridade, data);
				
				agenda.editarTarefa(titulo, tarefaEditar);
				break;
				
			case 4:
				tarefas = agenda.exibirTodasTarefas(usuario);
				System.out.println("=== TAREFAS ===");
				for (Tarefa tarefa : tarefas) {
					System.out.println();
					System.out.println("Título: " + tarefa.getTitulo());
					System.out.println("Descrição: " + tarefa.getDescricao());
					System.out.println("Tags: " + tarefa.getTags());
					System.out.println("Prioridade: " + tarefa.getPrioridade());
					System.out.println("Data: " + tarefa.getData());
					System.out.println("Estado: " + tarefa.getEstado());
					System.out.println("=============================");
				}
				break;
				
			case 5:
				tarefas = agenda.exibirTarefasConcluidas(usuario);
				
				for (Tarefa tarefa : tarefas) {
					System.out.println();
					System.out.println("Título: " + tarefa.getTitulo());
					System.out.println("Descrição: " + tarefa.getDescricao());
					System.out.println("Tags: " + tarefa.getTags());
					System.out.println("Prioridade: " + tarefa.getPrioridade());
					System.out.println("Data: " + tarefa.getData());
					System.out.println("Estado: " + tarefa.getEstado());
					System.out.println("=============================");
				}
				
				break;
				
			case 6:
				System.out.println("Digite o título da tarefa: ");
				String tituloConcluir = scanner.nextLine();
				tituloConcluir = scanner.nextLine().trim();
				agenda.concluirTarefa(tituloConcluir, usuario);
				break;
				
			default:
				break;
			}
		}
		scanner.close();
		
		//Vizualisar taredas por tipos
		/*
		ArrayList<Tarefa> tarefas_musica = musica.getLista_tarefas();
		System.out.println(tarefas_musica);
		
		ArrayList<Tarefa> tarefas_design = design.getLista_tarefas();
		System.out.println(tarefas_design);
		
		ArrayList<Tarefa> tarefas_estudo = estudo.getLista_tarefas();
		System.out.println(tarefas_estudo);
		*/
	}
	
	static void menuLogin(){
		System.out.println();
		System.out.println("=== LOGIN ===");
		System.out.println("1. Login");
		System.out.println("2. Cadastrar Usuário");
	}
	
	
	static void menu(){
		System.out.println();
		System.out.println("=== MENU ===");
		System.out.println("1. Cadastrar Tarefa");
		System.out.println("2. Remover Tarefa");
		System.out.println("3. Editar Tarefa");
		System.out.println("4. Listar Tarefas");
		System.out.println("5. Listar Tarefas Concluidas");
		System.out.println("6. Concluir Tarefa");
	}
}
