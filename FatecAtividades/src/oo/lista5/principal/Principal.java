package oo.lista5.principal;

import java.io.IOException;

import oo.lista5.engine.Agenda;
import oo.lista5.modelos.Aluno;
import oo.lista5.modelos.Contato;
import oo.lista5.modelos.Pessoa;

final class Principal {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		boolean funciona = true;
		Agenda agenda = new Agenda();
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
