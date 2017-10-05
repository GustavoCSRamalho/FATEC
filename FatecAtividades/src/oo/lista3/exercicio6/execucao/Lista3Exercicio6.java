package oo.lista3.exercicio6.execucao;

import oo.lista3.exercicio6.engine.Lista3Exercicio6Aplicativo;

final class Lista3Exercicio6 {
	private static Lista3Exercicio6Aplicativo aplicativo;
	public static void main(String[] args) {
		aplicativo = new Lista3Exercicio6Aplicativo();
		boolean funciona = true;
		int opcao;
		do {
			opcao = aplicativo.opcoes();
			switch(opcao) {
			case 1:
				aplicativo.cadastrarCliente();
				break;
			case 2:
				aplicativo.editarCliente();
				break;
			case 3:
				aplicativo.excluirCliente();
				break;
			case 4:
				aplicativo.montanteGastoClientes();
				break;
			case 5:
				aplicativo.montateTotalGastoClientes();
				break;
			case 6:
				aplicativo.maiorGastoMes();
				break;
			case 7:
				aplicativo.maiorGastoAno();
				break;
			case 8:
				aplicativo.listarClientes();
				break;
			case 9:
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("Programa finalizado!");
	}
}
