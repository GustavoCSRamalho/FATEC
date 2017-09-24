package oo.lista7.aplicacao;

import java.io.IOException;

import oo.lista7.acesso.Acesso;
import oo.lista7.engine.SecretarioFinanceiro;
import oo.lista7.entradadados.Dados;

final class Execucao {
	private static Acesso acesso;
	private static SecretarioFinanceiro secretario;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		acesso = new Acesso();
		secretario = new SecretarioFinanceiro();
		boolean funciona = true;
		boolean login = false;
		int opcao;
		do {
			if(!login) {
				System.out.println("Digite 1 para fazer o login e 2 para sair da aplicacao: ");
				opcao = Dados.scan.nextInt();
				if(opcao == 1) {
					boolean logou = acesso.validaUsuario();
					if(logou)	login = true;
				}else {
					funciona = false;
				}
			}
			if(login) {
				opcao = secretario.imprimirOpcoes();
				switch(opcao) {
				case 1:
					secretario.entradaCaixa();
					break;
				case 2:
					secretario.saidaCaixa();
					break;
				case 3:
					secretario.imprimirHistorico();
					break;
				case 4:
					secretario.salvaDados();
					break;
				case 5:
					secretario.recuperaDados();
					break;
				case 6:
					login = false;
					secretario = new SecretarioFinanceiro();
					System.out.println("\nDeslogado!\n");
					break;
				}
			}
		}while(funciona);
		System.out.println("Programa finalizado!");
	}
}
