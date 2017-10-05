package oo.lista1.revisaoestruturaselecao;

public class Lista1RevisaoIfElse {
	public static void main(String[] args) {
		java.util.Scanner leitor = new java.util.Scanner(System.in);
		int numero1 = 0;
		int numero2 = 0;
		System.out.println("Insira um valor inteira para o numero 1: ");
		numero1 = leitor.nextInt();
		System.out.println("Insira um valor inteira para o numero 2: ");
		numero2 = leitor.nextInt();
		
		if(numero1 > numero2) {
			System.out.println("Numero 1 maior que o numero 2");
		}
		if(numero1 < numero2) {
			System.out.println("Numero 2 maior que o numero 1");
		}
		if(numero1 == numero2) {
			System.out.println("Numero 1 igual ao numero 2");
		}
		if(numero1 != numero2) {
			System.out.println("Numero 1 diferente do numero 2");
		}
		
		System.out.println("---------------------------------------");
		System.out.println("Segundo jeito : ");
		
		if(numero1 > numero2) {
			System.out.println("Numero 1 maior que o numero 2");
		}
		else{
			System.out.println("Numero 2 maior que o numero 1");
		}
		if(numero1 == numero2) {
			System.out.println("Numero 1 igual ao numero 2");
		}
		else{
			System.out.println("Numero 1 diferente do numero 2");
		}

	}
}
