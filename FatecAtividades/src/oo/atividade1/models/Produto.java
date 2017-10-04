package oo.atividade1.models;

import java.io.Serializable;

public class Produto implements Serializable{
	private String nome;
	private double preco;
	private int quantidade;
	private int quantidadeVendido;
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
	
	public int getQuantidadeVendido() {
		return quantidadeVendido;
	}
	public void setQuantidadeVendido(int quantidadeVendido) {
		this.quantidadeVendido = quantidadeVendido;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String toString() {
		return "\nNome produto: "+nome+"\nQuantidade: "+quantidade+"\nVendidos : "
	+quantidadeVendido+"\n";
	}
}
