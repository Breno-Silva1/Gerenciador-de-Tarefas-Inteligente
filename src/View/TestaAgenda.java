package View;
import Controller.*;
import Model.Tarefa;
import Model.Usuario;

public class TestaAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Usuario usuario = new Usuario();
		usuario.setId(1);
		Tarefa[] tarefasDiarias = agenda.exibirTarefasDiarias(usuario);
		
		for (int i = 0; i < tarefasDiarias.length; i++) {
			String tarefaoumeta = "";
			if (i <= 2) {
				tarefaoumeta = "TAREFA"; 
			} else {
				tarefaoumeta = "META";
			}
			System.out.println("==== "+ tarefaoumeta +" 0" + (i+1) + " ====");
			if (tarefasDiarias[i] != null) {
				System.out.println(tarefasDiarias[i].getTitulo());
				System.out.println(tarefasDiarias[i].getData());
				System.out.println(tarefasDiarias[i].getPrioridade());
				System.out.println();
			} else {
				System.out.println("Nulo!");
			}
		}
	}
}
