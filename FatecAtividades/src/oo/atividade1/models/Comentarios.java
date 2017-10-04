package oo.atividade1.models;

import java.io.Serializable;

public class Comentarios implements Serializable{
	private String nomeProduto;
	private String comentario;
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String toString() {
		return "\nNome do produto: "+nomeProduto+"\nComentario : \n"+comentario+"\n";
	}
}
