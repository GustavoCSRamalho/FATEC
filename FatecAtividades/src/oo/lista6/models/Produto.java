package oo.lista6.models;

import java.io.Serializable;

public class Produto implements Serializable{
	private String nome;
	private int quantidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return "\nNome do produto: "+getNome()+"\nQuantidade: "+getQuantidade();
	}
}
