package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Tarefa;
import Model.Usuario;

public class UsuarioDAO {
	
	// *Cadastrar Usuário!
	public boolean cadastrarUsuario(Usuario user){
		boolean retorno = false;
		String new_user = "INSERT INTO usuario (nome, username, email, senha) VALUES (?, ?, ?, ?);";
		try {
			Connection conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(new_user);

			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getSenha());

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
	
	public boolean autenticar(Usuario user){
		boolean retorno = false;
		String insert_tarefa = "INSERT INTO usuario (nome, username, email, senha) VALUES (?, ?, ?, ?);";
		try {
			Connection conexao = FabricaDeConexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(insert_tarefa);

			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getSenha());

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
	
}
