package oo.lista2.exercicio6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class Vendedor {
	private List<Produto> lista = new ArrayList<Produto>();
	private Produto produto = null;
	private Scanner scan = new Scanner(System.in);
	private double salario;
	
	void addProduto() {
		produto = new Produto();
		System.out.println("Digite o nome do produto : ");
		produto.setNome(scan.next());
		System.out.println("Digite o quantidade : ");
		produto.setQuantidade(scan.nextInt());
		System.out.println("Digite o preco : ");
		produto.setPreco(scan.nextDouble());
		lista.add(produto);
	}
	
	void salario() {
		double salario = 800;
		if(lista != null) {
			for(Produto produto: lista) {
				salario += produto.getPreco() * produto.getQuantidade();
			}
		}
		this.salario = salario;
	}
	
	void imprimiRendimento() {
		salario();
		System.out.println("O rendimento foi de = "+this.salario);
	}
	
	
}
