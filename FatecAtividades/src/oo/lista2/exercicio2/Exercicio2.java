package oo.lista2.exercicio2;

import java.util.Scanner;

public class Exercicio2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		System.out.println("Digite o primeiro numero : ");
		num1 = scan.nextInt();
		System.out.println("Digite o segundo numero : ");
		num2 = scan.nextInt();
		
		System.out.println("Soma  = "+(num1+num2));
		System.out.println("Media = "+((num1*1.0+num2)/2));
		System.out.println("Ordem crescente = "+((num1 > num2) ? num2+" "+num1 : num1+" "+num2));
	}
}
