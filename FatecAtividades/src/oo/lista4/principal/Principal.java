package oo.lista4.principal;

import oo.lista4.engine.Agenda;
import oo.lista4.modelos.Aluno;
import oo.lista4.modelos.Contato;
import oo.lista4.modelos.Pessoa;

public class Principal {
	public static void main(String[] args) {
		boolean funciona = true;
		Agenda agenda = new Agenda();
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
