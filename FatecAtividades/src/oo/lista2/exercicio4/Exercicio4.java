package oo.lista2.exercicio4;

import java.util.Scanner;

public class Exercicio4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		System.out.println("Digite o primeiro numero : ");
		num1 = scan.nextInt();
		System.out.println("Digite o segundo numero : ");
		num2 = scan.nextInt();
		
		if(num2 % num1 == 0) {
			System.out.println("É multiplo!");
		}else {
			System.out.println("Não é multiplo!");
		}
	}
}
