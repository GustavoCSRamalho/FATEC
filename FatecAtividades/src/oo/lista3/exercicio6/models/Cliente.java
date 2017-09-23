package oo.lista3.exercicio6.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private List<Double> gastoMeses;
	
	public Cliente() {
		this.gastoMeses = new ArrayList<Double>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Double> getGastoMeses() {
		return gastoMeses;
	}

	public void setGastoMeses(List<Double> gastoMeses) {
		this.gastoMeses = gastoMeses;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "\nNome: "+getNome()+"\nTelefone: "+getTelefone()+"\nEmail: "+getEmail()+
				"\nEndereco: "+getEndereco()+"\n";
	}
}
