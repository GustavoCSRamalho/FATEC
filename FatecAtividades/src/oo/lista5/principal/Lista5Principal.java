package oo.lista5.principal;

import java.io.IOException;

import oo.lista5.engine.Lista5Agenda;
import oo.lista5.modelos.Lista5Aluno;
import oo.lista5.modelos.Lista5Contato;
import oo.lista5.modelos.Lista5Pessoa;

final class Lista5Principal {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		boolean funciona = true;
		Lista5Agenda agenda = new Lista5Agenda();
		agenda.criaArquivo();
		int opcao = 0;
		do {
			opcao = agenda.listarOpcoes();
			switch(opcao) {
			case 1:
				agenda.inserirContato();
			 	break;
			case 2:
				agenda.editarPessoa();
				break;
			case 3:
				agenda.removerPessoa();
				break;
			case 4:
				agenda.listarTodos();
				break;
			case 5:
				agenda.salvarAgenda();
				break;
			case 6:
				agenda.recuperaDados();
				break;
			case 7:
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("Programa finalizado!");

	}
}
