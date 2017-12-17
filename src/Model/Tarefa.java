package Model;


public class Tarefa {
	private int id;
	private String titulo;
	private String descricao;
	private String tags;
	private int prioridade;
	private String data;
	private boolean concluida;
	private int tipo;
	private int usuario_id;
	
	public Tarefa() {
		concluida = false;
	}
	
	public Tarefa(String titulo, String descricao, String tags, int prioridade) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.tags = tags;
		this.prioridade = prioridade;
		concluida = false;
	}

	
	public Tarefa(String titulo, String descricao, String tags, int prioridade, String data) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.tags = tags;
		this.prioridade = prioridade;
		this.data = data;
		concluida = false;
	}
	
	//CONSTRUTOR PARA INTERFACE
	public Tarefa(String titulo, String descricao, String tags, int prioridade, String data, int tipo) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.tags = tags;
		this.prioridade = prioridade;
		this.data = data;
		concluida = false;
		this.tipo = tipo;
	}
	
	//CONSTRUTOR PARA PEGAR DO BD
	public Tarefa(int id, String titulo, String descricao, String tags, int prioridade, String data, boolean concluida) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tags = tags;
		this.prioridade = prioridade;
		this.data = data;
		this.concluida = concluida;
	}
	
	//CONSTRUTOR PARA PEGAR DO BD
		public Tarefa(int id, String titulo, String descricao, String tags, int prioridade, boolean concluida) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.descricao = descricao;
			this.tags = tags;
			this.prioridade = prioridade;
			this.concluida = concluida;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean getEstado() {
		return concluida;
	}

	public void setEstado(boolean estado) {
		this.concluida = estado;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", tags=" + tags
				+ ", prioridade=" + prioridade + ", data=" + data + ", concluida=" + concluida + "]";
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
