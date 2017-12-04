package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public boolean autenticar(Usuario user){
		boolean retorno = false;
		String login = user.getUsername();
		String senha = user.getSenha();
		String pesquisarLogin = "SELECT username FROM usuario WHERE username = "+"\""+ login +"\";";
		String pesquisarSenha = "SELECT senha FROM usuario WHERE senha = "+"\""+ senha +"\";";
		try {
			Connection conexao = FabricaDeConexao.getConnection();
			PreparedStatement verLogin = conexao.prepareStatement(pesquisarLogin);
			PreparedStatement verSenha = conexao.prepareStatement(pesquisarSenha);
			if (verLogin != null && verSenha != null) {
				retorno = true;
			} else {
				retorno = false;
			}
			verLogin.close();
			verSenha.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
}
