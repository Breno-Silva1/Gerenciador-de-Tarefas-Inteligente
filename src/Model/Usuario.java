package Model;

public class Usuario {
	private int id;
	private String nome;
	private String username;
	private String email;
	private String senha;

	public Usuario(String nome, String username, String email, String senha) {
		super();
		this.nome = nome;
		this.username = username;
		this.email = email;
		this.senha = senha;
	}
	public Usuario(int id, String nome, String username, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.email = email;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
