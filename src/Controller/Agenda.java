package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Tarefa;
import Model.Usuario;

public class Agenda {

	private ArrayList<Tarefa> tarefas;
	Connection conexao;

	public Agenda() {
		this.conexao = null;
	}

	public boolean cadastrarTarefa(Tarefa umaTarefa, Usuario usuario) {
		boolean retorno = false;
		String insert_tarefa = "INSERT INTO tarefa (titulo, descricao, tags, prioridade, data_tarefa, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(insert_tarefa);

			stmt.setString(1, umaTarefa.getTitulo().toLowerCase());
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

	public boolean cadastrarMeta(Tarefa umaTarefa, Usuario usuario) {
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
	
	public boolean expirarTarefaOuMeta(Tarefa tarefa_ou_meta){
		boolean estaExpirado = false;
		Date dataDeHoje = new Date();
		SimpleDateFormat df = new SimpleDateFormat();
		String dataHoje = df.format(dataDeHoje);
		String[] dataHJ = dataHoje.split("/");
		String[] dataTM = tarefa_ou_meta.getData().split("/");
		
		if (Integer.parseInt(dataTM[2]) >= Integer.parseInt(dataHJ[2])) {
			if (Integer.parseInt(dataTM[1]) >= Integer.parseInt(dataHJ[1])) {
				if (Integer.parseInt(dataTM[0]) >= Integer.parseInt(dataHJ[0])) {
					estaExpirado = false;
				} else {
					estaExpirado = true;
				}
			} else {
				estaExpirado = true;
			}
		} else {
			estaExpirado = true;
		}
		return estaExpirado;
	}

	public boolean removerTarefa(String titulo, Usuario usuario) {
		String delete_tarefa = "DELETE FROM tarefa WHERE titulo = ? AND id_usuario = ?";
		boolean retorno = false;
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(delete_tarefa);
			stmt.setString(1, titulo);
			stmt.setInt(2, usuario.getId());
			stmt.executeUpdate();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean removerMeta(String titulo, Usuario usuario) {
		String delete_meta = "DELETE FROM meta WHERE titulo = ? AND id_usuario = ?";
		boolean retorno = false;
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(delete_meta);
			stmt.setString(1, titulo);
			stmt.setInt(2, usuario.getId());
			stmt.executeUpdate();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean editarTarefa(Tarefa tarefa, Usuario usuario) {
		String update_tarefa = "UPDATE tarefa SET titulo = ?, descricao = ?, tags = ?, prioridade = ?, data_tarefa = ? WHERE id_usuario = ? AND id = ?;";
		boolean retorno = false;
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(update_tarefa);
			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setString(3, tarefa.getTags());
			stmt.setInt(4, tarefa.getPrioridade());
			stmt.setString(5, tarefa.getData());
			stmt.setInt(6, usuario.getId());
			stmt.setInt(7, tarefa.getId());

			stmt.executeUpdate();
			retorno = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean editarMeta(Tarefa tarefa, Usuario usuario) {
		String update_meta = "UPDATE meta SET titulo = ?, descricao = ?, tags = ?, prioridade = ? WHERE id_usuario = ? AND id = ?;";
		boolean retorno = false;
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(update_meta);
			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setString(3, tarefa.getTags());
			stmt.setInt(4, tarefa.getPrioridade());
			stmt.setInt(5, usuario.getId());
			stmt.setInt(6, tarefa.getId());

			stmt.executeUpdate();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean concluirTarefa(String titulo, Usuario usuario) {
		String update_tarefa = "UPDATE tarefa SET estado = true WHERE id_usuario = ? AND titulo = ?;";
		boolean retorno = false;
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(update_tarefa);
			stmt.setInt(1, usuario.getId());
			stmt.setString(2, titulo);

			stmt.executeUpdate();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean concluirMeta(String titulo, Usuario usuario) {
		String update_meta = "UPDATE meta SET estado = true WHERE id_usuario = ? AND titulo = ?;";
		boolean retorno = false;
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(update_meta);
			stmt.setInt(1, usuario.getId());
			stmt.setString(2, titulo);

			stmt.executeUpdate();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public Tarefa buscarTarefaPorTitulo(String titulo, Usuario usuario) {
		String selected_tarefa = "SELECT * FROM tarefa WHERE titulo = ? AND id_usuario = ?;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_tarefa);
			stmt.setString(1, titulo);
			stmt.setInt(2, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String tituloBD = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String tags = rs.getString("tags");
				int prioridade = rs.getInt("prioridade");
				String data = rs.getString("descricao");
				boolean concluida = rs.getBoolean("estado");
				Tarefa tarefa = new Tarefa(id, tituloBD, descricao, tags, prioridade, data, concluida);
				return tarefa;
			}

			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Tarefa buscarMetaPorTitulo(String titulo, Usuario usuario) {
		String selected_tarefa = "SELECT * FROM meta WHERE titulo = ? AND id_usuario = ?;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_tarefa);
			stmt.setString(1, titulo);
			stmt.setInt(2, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String tituloBD = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String tags = rs.getString("tags");
				int prioridade = rs.getInt("prioridade");
				boolean concluida = rs.getBoolean("estado");
				Tarefa meta = new Tarefa(id, tituloBD, descricao, tags, prioridade, concluida);
				return meta;
			}

			stmt.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Exibir as tarefas

	public ArrayList<Tarefa> exibirTodasTarefas(Usuario usuario) {
		this.tarefas = new ArrayList<>();
		String selected_tarefa = "SELECT * FROM tarefa WHERE id_usuario = ?;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_tarefa);
			stmt.setInt(1, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setTags(rs.getString("tags"));
				tarefa.setPrioridade(rs.getInt("prioridade"));
				tarefa.setData(rs.getString("data_tarefa"));
				tarefa.setEstado(rs.getBoolean("estado"));
				tarefa.setUsuario_id(usuario.getId());

				tarefas.add(tarefa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarefas;
	}

	public ArrayList<Tarefa> exibirTodasMetas(Usuario usuario) {
		this.tarefas = new ArrayList<>();
		String selected_meta = "SELECT * FROM meta WHERE id_usuario = ?;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_meta);
			stmt.setInt(1, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setTags(rs.getString("tags"));
				tarefa.setPrioridade(rs.getInt("prioridade"));
				tarefa.setEstado(rs.getBoolean("estado"));
				tarefa.setUsuario_id(usuario.getId());

				tarefas.add(tarefa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarefas;
	}

	public Tarefa[] exibirTarefasDiarias(Usuario usuario){
		ArrayList<Tarefa> tarefas = exibirTarefasNaoCumpridas(usuario);
		ArrayList<Tarefa> metas = exibirMetasNaoCumpridas(usuario);
		
		Tarefa[] tarefas_diarias = new Tarefa[3];
		Tarefa[] metas_diarias = new Tarefa[2];
		Tarefa[] tarefas_metas_diarias = new Tarefa[5];
		
		int ano = 0, mes = 0, dia = 0, prioridade = 0, x = 2;
		
		for (Tarefa t : tarefas) {
			String[] data =  t.getData().split("/");
			int comp_ano = Integer.parseInt(data[0]);
			int comp_mes = Integer.parseInt(data[1]);
			int comp_dia = Integer.parseInt(data[2]);
			int comp_prioridade = t.getPrioridade();
			
			if(x > -1){
				if (comp_ano >= ano) {
					if (comp_mes >= mes) {
						if (comp_dia >= dia) {
							if (comp_prioridade > prioridade) {
								tarefas_diarias[x] = t;
								--x;
							}
						}
					}
				}
			} else {
				break;
			}
		} 
		
		int comp_prioridadeMeta = 0, y = 1;
		
		for (Tarefa m : metas) {
			
			int comp_prioridade = m.getPrioridade();
			
			if(y > -1){
				if (comp_prioridade > comp_prioridadeMeta) {
					metas_diarias[y] = m;
					--y;
				}
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (tarefas_metas_diarias[i] == null) {
				tarefas_metas_diarias[i] = tarefas_diarias[i];
			}
		}
		
		for (int i = 3; i < 5; i++) {
			if (tarefas_metas_diarias[i] == null) {
				tarefas_metas_diarias[i] = metas_diarias[i-3];
			}
		}
		
		return tarefas_metas_diarias;
	}

	public ArrayList<Tarefa> exibirTarefasNaoCumpridas(Usuario usuario) {
		this.tarefas = new ArrayList<>();
		String selected_tarefa = "SELECT * FROM tarefa WHERE id_usuario = ? AND estado = false;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_tarefa);
			stmt.setInt(1, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setTags(rs.getString("tags"));
				tarefa.setPrioridade(rs.getInt("prioridade"));
				tarefa.setData(rs.getString("data_tarefa"));
				tarefa.setEstado(rs.getBoolean("estado"));
				tarefa.setUsuario_id(usuario.getId());

				tarefas.add(tarefa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarefas;
	}

	public ArrayList<Tarefa> exibirTarefasConcluidas(Usuario usuario) {
		this.tarefas = new ArrayList<>();
		String selected_tarefa = "SELECT * FROM tarefa WHERE id_usuario = ? AND estado = true;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_tarefa);
			stmt.setInt(1, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setTags(rs.getString("tags"));
				tarefa.setPrioridade(rs.getInt("prioridade"));
				tarefa.setData(rs.getString("data_tarefa"));
				tarefa.setEstado(rs.getBoolean("estado"));
				tarefa.setUsuario_id(usuario.getId());

				tarefas.add(tarefa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarefas;
	}

	public ArrayList<Tarefa> exibirMetasNaoCumpridas(Usuario usuario) {
		this.tarefas = new ArrayList<>();
		String selected_meta = "SELECT * FROM meta WHERE id_usuario = ? AND estado = false;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_meta);
			stmt.setInt(1, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa meta = new Tarefa();
				meta.setId(rs.getInt("id"));
				meta.setTitulo(rs.getString("titulo"));
				meta.setDescricao(rs.getString("descricao"));
				meta.setTags(rs.getString("tags"));
				meta.setPrioridade(rs.getInt("prioridade"));
				meta.setEstado(rs.getBoolean("estado"));
				meta.setUsuario_id(usuario.getId());

				tarefas.add(meta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarefas;
	}

	public ArrayList<Tarefa> exibirMetasConcluidas(Usuario usuario) {
		this.tarefas = new ArrayList<>();
		String selected_meta = "SELECT * FROM meta WHERE id_usuario = ? AND estado = true;";
		try {
			conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(selected_meta);
			stmt.setInt(1, usuario.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Tarefa meta = new Tarefa();
				meta.setId(rs.getInt("id"));
				meta.setTitulo(rs.getString("titulo"));
				meta.setDescricao(rs.getString("descricao"));
				meta.setTags(rs.getString("tags"));
				meta.setPrioridade(rs.getInt("prioridade"));
				meta.setEstado(rs.getBoolean("estado"));
				meta.setUsuario_id(usuario.getId());

				tarefas.add(meta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarefas;
	}

}
