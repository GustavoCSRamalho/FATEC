package oo.atividade1.dao;

import java.util.Scanner;

import oo.atividade1.models.Comentarios;
import oo.atividade1.models.Produto;

public class InformacaoDAO {
	private static Scanner scan;
	
	public InformacaoDAO() {
		scan = new Scanner(System.in);
	}
	
	public Produto criaProduto() {
		Produto produto = null;
		produto = new Produto();
		System.out.println("\nInformações do produto: ");
//		bug = scan.next();
		System.out.print("Digite o nome : ");
		String nome = scan.next()+scan.nextLine();
		produto.setNome(nome);
		System.out.print("Digite a quantidade: ");
		int qntd = scan.nextInt();
		produto.setQuantidade(qntd);
		System.out.print("Digite o preço: ");
		double preco = scan.nextDouble();
		produto.setPreco(preco);
		return produto;
	}
	
	public final String nomeProduto() {
		System.out.print("\nDigite o nome do produto a ser comprado: ");
		String nome = scan.nextLine()+scan.nextLine();
		return nome;
	}
	
	public final String nomeProdutoComentario() {
		System.out.print("\nDigite o nome do produto a ser comentado: ");
		String nome = scan.nextLine()+scan.nextLine();
		return nome;
	}
	
	public final String confirmaCompra() {
		System.out.print("\nDeseja comprar este produto ? (y/n)");
		String confirma = scan.next();
		return confirma;
	}
	
	public final Comentarios adicionarComentario() {
		Comentarios comentario = new Comentarios();
		System.out.print("Digite o comentario: ");
		String comentarioDigitado = scan.nextLine();
		comentario.setComentario(comentarioDigitado);
		return comentario;
	}
	
	public final int opcoes() {
		System.out.print("\n1 - Cadastrar um produto\n2 - Vender um produto\n3 - Listar Produtos\n"
				+ "4 - Ranking\n5 - Adiciona comentario\n6 - Lista comentarios\n7 - Sair");
		System.out.print("\n\nOpcao: ");
		int opcao = scan.nextInt();
		return opcao;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
