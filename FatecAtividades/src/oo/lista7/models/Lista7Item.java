package oo.lista7.models;

import java.io.Serializable;

public class Lista7Item implements Serializable{
	private String nome;
	private Double valor;
	private String tipo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return "\nMotivo: "+getNome()+"\nValor: "+getValor();
	}
}
