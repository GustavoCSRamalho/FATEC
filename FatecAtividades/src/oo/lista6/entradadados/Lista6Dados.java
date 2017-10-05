package oo.lista6.entradadados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import oo.lista6.models.Lista6Produto;

public class Lista6Dados {
	public static Scanner scan;
	private Lista6Produto produto;
	
	public Lista6Dados() {
		scan = new Scanner(System.in);
	}
	
	public Lista6Produto adicionaProduto() {
		produto = new Lista6Produto();
		System.out.println("Digite o nome do produto: ");
		produto.setNome(scan.next());
		System.out.println("Digite a quantidade de produtos: ");
		produto.setQuantidade(scan.nextInt());
		return produto;
	}
	
	public Lista6Produto editarProduto(Lista6Produto produto) {
		String conf = "";
		System.out.println("Deseja alterar o nome do produto: (y/n)");
		conf = scan.next();
		if(conf.equalsIgnoreCase("y")) {
			System.out.println("Digite o novo nome do produto: ");
			produto.setNome(scan.next());
		}
		System.out.println("Deseja alterar a quantidade do produto: y/n()");
		conf = scan.next();
		if(conf.equalsIgnoreCase("y")) {
			System.out.println("Digite a nova quantidade do produto: ");
			produto.setQuantidade(scan.nextInt());
		}
		return produto;
	}
}
