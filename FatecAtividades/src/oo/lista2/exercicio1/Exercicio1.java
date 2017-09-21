package oo.lista2.exercicio1;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		System.out.println("Digite o primeiro numero : ");
		num1 = scan.nextInt();
		System.out.println("Digite o segundo numero : ");
		num2 = scan.nextInt();
		
		System.out.println("Soma  = "+(num1+num2));
		System.out.println("Subtracao = "+(num1 - num2));
		System.out.println("Divisao = "+(num1*1.0/num2*1.0));
		System.out.println("Produto = "+(num1 * num2));
	}

}
