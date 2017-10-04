package oo.lista2.exercicio8;

import java.util.Scanner;

public class Exercise8 {
	private static Scanner scan;
	private static int senha;
	public static void main(String[] args) {
		boolean funciona = true;
		scan = new Scanner(System.in);
		
		do{
			int opcao = imprimeOpcoes();
			switch(opcao) {
			case 1:
				iniciarPrograma();
				break;
			case 2:
				funciona = false;
				break;
			}
			
		}while(funciona);
		System.out.println("Programa finalizado!");
		
		
	}
	
	private static void iniciarPrograma() {
		System.out.println("Digite uma senha de quatro digitos: ");
		senha = scan.nextInt();
		System.out.print("\nDesenha digitada: "+senha);
		senha = criptografa(senha);
		System.out.print("\nSenha encriptografada: "+senha);
		senha = descriptografa(senha);
		System.out.println("\nSenha descriptografada: "+senha);
		
	}
	
	private static int imprimeOpcoes() {
		System.out.print("\n1 - Realizar operação\n2 - Sair\n");
		int opcao = scan.nextInt();
		return opcao;
	}

	private static int criptografa(int senha) {

		int numero1, numero2,numero3, numero4;

		numero1 = ((senha % 10) + 7) % 10;
		senha /= 10;
		numero2 = (((senha % 10) +7) % 10) * 10;
		senha /= 10;
		numero3 = (((senha % 10) + 7) % 10) * 100;
		numero4 = (((senha / 10) +7) %10 )* 1000;

		
		senha = numero4 + numero3+numero2+numero1;
		return senha;

	}

	private static int descriptografa(int senha) {
		int numero1, numero2,numero3, numero4;
		// separa
		numero1 = (((senha % 10)+10)-7)%10;
		senha /= 10;
		numero2 = ((((senha % 10)+10) - 7) % 10) *10;
		senha /= 10;
		numero3 = ((((senha % 10)+10 ) - 7 ) % 10) *100;
		numero4 = ((((senha / 10)+10) - 7) % 10) *1000;

		senha = numero4+numero3+numero2+numero1;
		return senha;
	}

}
