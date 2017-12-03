package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Agenda;
import Model.Tarefa;
import Model.Tipo;
import Model.Usuario;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("olá, mundo!");
		System.out.println("Testando commit e push pelo eclipse!");
		
		System.out.println("---------------------------------");
		
		System.out.println("::::: Testando CADASTRAR TAREFA :::::");
		
		Scanner scanner = new Scanner(System.in);
		
		Tipo musica = new Tipo("Música");
		Tipo design = new Tipo("Design");
		Tipo estudo = new Tipo("Estudo");
		
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
			Usuario user = new Usuario();
			user.setId(1);
			
			System.out.println("Escolha o tipo da tarefa: ");
			System.out.println("1. " + musica.getNome_tipo());
			System.out.println("2. " + design.getNome_tipo());
			System.out.println("3. " + estudo.getNome_tipo());
			System.out.print(">> ");
			int opc = scanner.nextInt();
			
			if (opc == 1) 
				musica.adicionarTarefa(firstTask);
			else if (opc == 2) 
				design.adicionarTarefa(firstTask);
			else if (opc == 3) 
				estudo.adicionarTarefa(firstTask);
			
			Agenda agenda = new Agenda();
			
			agenda.cadastrarTarefa(firstTask, user);
			
			if(agenda.cadastrarMeta(firstMeta, user)) {
				System.out.println("Meta cadastrada!");
			} else {
				System.out.println("Não foi possível cadastrar Meta!");
			}
		}
		scanner.close();
		
		//Vizualisar taredas por tipos
		
		ArrayList<Tarefa> tarefas_musica = musica.getLista_tarefas();
		System.out.println(tarefas_musica);
		
		ArrayList<Tarefa> tarefas_design = design.getLista_tarefas();
		System.out.println(tarefas_design);
		
		ArrayList<Tarefa> tarefas_estudo = estudo.getLista_tarefas();
		System.out.println(tarefas_estudo);
		
	}
}
