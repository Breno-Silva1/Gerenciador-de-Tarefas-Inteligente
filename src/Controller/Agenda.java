package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Tarefa;
import Model.Usuario;

public class Agenda {
	
	private ArrayList<Tarefa> tarefas;
	Connection conexao;
	
	public Agenda(){
		this.tarefas = new ArrayList<>();
		this.conexao = null;
	}
	
	public boolean cadastrarTarefa(Tarefa umaTarefa, Usuario usuario){
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
			stmt.setInt(7, usuario.getId());

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
	
	public boolean cadastrarMeta(Tarefa umaTarefa, Usuario usuario){
		boolean retorno = false;
		String insert_tarefa = "INSERT INTO meta (titulo, descricao, tags, prioridade, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(insert_tarefa);

			stmt.setString(1, umaTarefa.getTitulo());
			stmt.setString(2, umaTarefa.getDescricao());
			stmt.setString(3, umaTarefa.getTags());
			stmt.setInt(4, umaTarefa.getPrioridade());
			stmt.setBoolean(5, umaTarefa.getEstado());
			stmt.setInt(6, usuario.getId());

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
	
	public Tarefa buscarTarefaPorTitulo(String titulo){
		String insert_tarefa = "SELECT * FROM meta WHERE titulo = ?;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(insert_tarefa);
			stmt.setString(1, titulo);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String tituloBD = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String tags = rs.getString("descricao");
				int prioridade = rs.getInt("prioridade");
				String data = rs.getString("descricao");
				boolean concluida = rs.getBoolean("estado");
				return new Tarefa(id, tituloBD, descricao, tags, prioridade, data, concluida);
			}
			
			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
