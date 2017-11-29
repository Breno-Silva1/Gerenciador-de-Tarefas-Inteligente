package Model;

import java.util.Calendar;

public class Tarefa {
	private int id;
	private String titulo;
	private String descricao;
	private String tags;
	private int prioridade;
	private Calendar data;
	private boolean concluida;
	
	public Tarefa() {
		
	}
	
	public Tarefa(int id, String titulo, String descricao, String tags, int prioridade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tags = tags;
		this.prioridade = prioridade;
	}

	
	public Tarefa(int id, String titulo, String descricao, String tags, int prioridade, Calendar data) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tags = tags;
		this.prioridade = prioridade;
		this.data = data;
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public boolean getEstado() {
		return concluida;
	}

	public void setEstado(boolean estado) {
		this.concluida = estado;
	}

}
