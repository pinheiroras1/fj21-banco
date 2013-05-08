package model;

public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	
	public Cliente(){}
	
	public Cliente(String cpf,String nome){
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
