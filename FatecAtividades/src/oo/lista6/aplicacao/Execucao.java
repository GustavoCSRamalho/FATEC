package oo.lista6.aplicacao;

import java.io.IOException;

import oo.lista6.engine.Aplicativo;

final class Execucao {
	private static Aplicativo aplicativo;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		aplicativo = new Aplicativo();
		boolean funciona = true;
		int opcao;
		aplicativo.criaArquivo();
		do {
			opcao = aplicativo.listarOpcoes();
			switch(opcao) {
			case 1:
				aplicativo.adicionaProduto();
				break;
			case 2:
				aplicativo.editarProduto();
				break;
			case 3:
				aplicativo.deletaProduto();
				break;
			case 4:
				aplicativo.relatório();
				break;
			case 5:
				aplicativo.salvaDados();
				break;
			case 6:
				aplicativo.recuperaDados();
				break;
			case 7:
				funciona = false;
				break;
			}
		}
		while(funciona);
		System.out.println("Programa finalizado!");
	}
}
