package Model;

import java.util.ArrayList;

public class Tipo {
	private String nome_tipo;
	private ArrayList<Tarefa> lista_tarefas;
	
	public Tipo(String nome) {
		this.nome_tipo = nome;
		lista_tarefas = new ArrayList<>();
	}
	
	public void adicionarTarefa(Tarefa tarefa){
		this.lista_tarefas.add(tarefa);
	}
	
	public String getNome_tipo() {
		return nome_tipo;
	}

	public void setNome_tipo(String nome_tipo) {
		this.nome_tipo = nome_tipo;
	}

	public ArrayList<Tarefa> getLista_tarefas() {
		return lista_tarefas;
	}

	public void setLista_tarefas(ArrayList<Tarefa> lista_tarefas) {
		this.lista_tarefas = lista_tarefas;
	}
	
}
