package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	// Autenticar usuário!
	public Usuario autenticar(String login, String senha){
		Usuario user = null;
		String pesquisarLoginESenha = "SELECT username FROM usuario WHERE username = ? AND senha = ? OR email = ? AND senha = ?;";
		try {
			Connection conexao = FabricaDeConexao.getConnection();
			PreparedStatement verLogin = conexao.prepareStatement(pesquisarLoginESenha);
			verLogin.setString(1, login);
			verLogin.setString(2, senha);
			verLogin.setString(3, login);
			verLogin.setString(4, senha);
			
			ResultSet rs = verLogin.executeQuery();
			
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String senhabd = rs.getString("senha");
				user = new Usuario(id, nome, username, email, senhabd);
			}
			verLogin.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
