package View;

import java.util.Scanner;

import Controller.Agenda;
import Model.Tarefa;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ol� mundo!");
		System.out.println("Testando commit e push pelo eclipse!");
		
		System.out.println("---------------------------------");
		System.out.println("Testando CADASTRAR TAREFA: ");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um t�tulo: ");
		String titulo = scanner.nextLine();
		System.out.println("Digite um descri��o: ");
		String descricao = scanner.nextLine();
		System.out.println("Digite um Tags: ");
		String tags = scanner.nextLine();
		System.out.println("Digite um prioridade: ");
		int prioridade = scanner.nextInt();
		System.out.println("Digite um data: ");
		String data = scanner.nextLine();
		data = scanner.nextLine();
		
		Tarefa firstTask = new Tarefa(titulo, descricao, tags, prioridade, data);
		
		Agenda agenda = new Agenda();
		
		if(agenda.cadastrarTarefa(firstTask)) {
			System.out.println("Tarefa cadastrada!");
		} else {
			System.out.println("N�o foi poss�vel cadastrar tarefa!");
		}
		
		scanner.close();
		
	}
}
