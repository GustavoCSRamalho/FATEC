package oo.lista2.exercicio7;

import java.util.Scanner;

final class Exercicio7 {
	private static Scanner scan;
	public static void main(String[] args) {
		 scan = new Scanner(System.in);
		 Empregado empregado = null;
		 empregado = new Empregado();
		 boolean funciona = true;
		 String conf = "";
		 int opcao;
		 while(funciona) {
			 
			 opcao = Exercicio7.imprimirOpcoes();
			 switch(opcao) {
			 case 1:
				 System.out.println("Adicione o valor da hora : ");
				 empregado.setValorHora(scan.nextDouble());
				 break;
			 case 2:
				 System.out.println("Digite as horas trabalhadas : ");
				 empregado.setHorasTrabalhadas(scan.nextInt());
				 break;
			 case 3:
				 empregado.imprimeSalario();
				 break;
			 case 4:
				 funciona = false;
				 System.out.println("Programa finalizado!");
				 break;
			 }
		 }
	}
	private static int imprimirOpcoes() {
		System.out.println("1 - Adicionar valor hora .\n2 - Adicionar hora trabalha.\n3 - Imprimir salario.\n"
				+ "4 - Sair.\n");
		return scan.nextInt();
	}
}
