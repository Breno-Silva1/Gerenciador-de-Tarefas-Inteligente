package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Tarefa;

public class Agenda {
	
	private ArrayList<Tarefa> tarefas;
	Connection conexao;
	
	public Agenda(){
		this.tarefas = new ArrayList<>();
		this.conexao = null;
	}
	
	public boolean cadastrarTarefa(Tarefa umaTarefa, int id_usuario){
		boolean retorno = false;
		String insert_tarefa = "INSERT INTO tarefa (titulo, descricao, tags, prioridade, data_tarefa, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(insert_tarefa);

			stmt.setString(1, umaTarefa.getTitulo());
			stmt.setString(2, umaTarefa.getDescricao());
			stmt.setString(3, umaTarefa.getTags());
			stmt.setInt(4, umaTarefa.getPrioridade());
			stmt.setString(5, umaTarefa.getData());
			stmt.setBoolean(6, umaTarefa.getEstado());
			stmt.setInt(7, id_usuario);

			if (stmt.executeUpdate() > 0) {
				retorno = true;
			} else {
				retorno = false;
			}
			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public void removerTarefa(){
		
	}
	
	public void editarTarefa(){
		
	}
	
	public void concluirTarefa(){
		
	}
	
	//Exibir as tarefas
	
	public ArrayList<Tarefa> exibirTodasTarefas(){
		return tarefas;
	}
	
	public ArrayList<Tarefa> exibirTarefasDiarias(){
		return tarefas;
	}
	
	public ArrayList<Tarefa> exibirTarefasNaoCumpridas(){
		return tarefas;
	}
	
	public ArrayList<Tarefa> exibirTarefasConcluidas(){
		return tarefas;
	}
	
}
