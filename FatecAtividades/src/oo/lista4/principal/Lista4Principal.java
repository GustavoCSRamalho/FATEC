package oo.lista4.principal;

import oo.lista4.engine.Lista4Agenda;
import oo.lista4.modelos.Lista4Aluno;
import oo.lista4.modelos.Lista4Contato;
import oo.lista4.modelos.Lista4Pessoa;

public class Lista4Principal {
	public static void main(String[] args) {
		boolean funciona = true;
		Lista4Agenda agenda = new Lista4Agenda();
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
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("Programa finalizado!");

	}
}
