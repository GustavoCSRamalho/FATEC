package oo.lista3.exercicio5;

import java.util.ArrayList;
import java.util.List;

final class Exercicio5 {
	private static List<Integer> lista;
	public static void main(String[] args) {
		lista = new ArrayList<Integer>();
		preencheLista();
		numeroPrimos();
		System.out.println("\nPrograma finalizado!\n");
		
	}
	private static void preencheLista() {
		for(int i = 2; i <= 999;i++) {
			lista.add((Integer)i);
		}
	}
	
	private static void numeroPrimos() {
		for(Integer numeros : lista) {
			int cont = 0;
			for(int i = 1; i <= numeros.intValue();i++) {
				if(numeros.intValue() % i == 0) {
					cont++;
				}
			}
			if(cont == 2) {
				System.out.printf("\nO numero %d é primo!\n",numeros.intValue());
			}
		}
	}
}
