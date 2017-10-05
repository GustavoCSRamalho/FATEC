package oo.lista2.exercicio5;

import java.util.Scanner;

public class Lista2Exercicio5 {
	public static void main(String[] args) {
		Lista2Exercicio5Cliente cliente = new Lista2Exercicio5Cliente();
		Scanner scan = new Scanner(System.in);
		boolean funciona = true;
		String conf = "";
		while(funciona) {
			System.out.println("Digite o numero da conta do cliente : ");
			cliente.setNumeroConta(scan.nextLong());
			System.out.println("Digite o saldo inicial do mes : ");
			cliente.setSaldoInicialMes(scan.nextDouble());
			System.out.println("Total cobrado mes ; ");
			cliente.setTotalMes(scan.nextDouble());
			System.out.println("Total dos creditos aplicados ao cliente : ");
			cliente.setTotalCreditoCliente(scan.nextDouble());
			System.out.println("Total do limite autorizado : ");
			cliente.setLimiteAutorizado(scan.nextDouble());
			cliente.novoSaldo();
			System.out.println("Deseja continuar ? (y/n)");
			conf = scan.next();
			if(conf.equals("n"))	funciona = false;
		}
	}
}
