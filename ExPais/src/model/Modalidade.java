package model;

public class Modalidade {

	private int id;
	private String nome;
	private int ouro;
	private int prata;
	private int bronze;
	
	
	public Modalidade() {
		id = 0;
		nome = "";
		ouro = 0;
		prata = 0;
		bronze = 0;
	}
	
	public Modalidade(int id, String nome, int ouro, int prata, int bronze) {
		this.id = id;
		this.nome = nome;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
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
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	public int getPrata() {
		return prata;
	}
	public void setPrata(int prata) {
		this.prata = prata;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	


}
