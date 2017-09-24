package oo.lista6.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import oo.lista5.modelos.Pessoa;
import oo.lista6.entradadados.Dados;
import oo.lista6.models.Produto;

public class Aplicativo {
	private List<Produto> listaProdutos;
	private Dados dados;
	
	public Aplicativo() {
//		this.listaProdutos = new ArrayList<Produto>();
		this.dados = new Dados();
	}
	
	public int listarOpcoes() {
		System.out.println("\n1 - Cadastrar produto\n2 - Editar produto\n3 - Remover produto\n"
				+ "4 - Produtos armazenados\n5 - Salvar produtos.\n6 - Listar produtos.\n7 - Sair da conta\n");
		System.out.println("\nDigite uma opcao: \n");
		int opcao = Dados.scan.nextInt();
		if(opcao >= 1 && opcao <= 7) {
			return opcao;
		}else {
			System.out.println("\nDigite uma opcao valida: \n");
			listarOpcoes();
			return 0;
		}
	}
	
	public void salvaDados() throws IOException {
		FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio6/produtos.txt");
		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
		escreverObjeto.writeObject(listaProdutos);
		System.out.println("Adicionado no arquivo os produtos!");
		escreverObjeto.close();
		escrever.close();
	}
	
	public void recuperaDados() throws IOException, ClassNotFoundException {
		FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio6/produtos.txt");
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Produto> listaDeProduto = (List<Produto>) lerObjeto.readObject();
		if(listaDeProduto.size() != 0) {
			System.out.println("\nProdutos recuperados: \n");
			for(Produto produto: listaDeProduto) {
				listaProdutos.add(produto);
				System.out.println(produto);
				
			}
		}
		else {
			System.out.println("\nNenhum produto cadastrado!\n");
		}
		lerObjeto.close();
		ler.close();
		System.out.println("Dados recuperados!");
	}
	
	public final void criaArquivo() throws IOException {
		listaProdutos = new ArrayList<Produto>();
		try(FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio6/produtos.txt");) {
			System.out.println("O arquivo ja existe então não é preciso criar outro!");
		}catch(Exception e) {
			FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
					"Exercicios/exercicio6/produtos.txt");
			ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(listaProdutos);
			System.out.println("Arquivo criado!");
			escrever.close();
		}
	}
	
	public void adicionaProduto() {
		listaProdutos.add(dados.adicionaProduto());
	}
	
	public void deletaProduto() {
		if(listaProdutos.size() == 0) {
			System.out.println("\nNão há produtos cadastrados no sistema!\n");
		}else {
			String nome = "";
			Produto produtoDeletar = null;
			System.out.println("Digite o nome do produto a ser deletado: ");
			nome = Dados.scan.next();
			boolean achou = false;
			for(Produto produto: listaProdutos) {
				if(produto.getNome().equalsIgnoreCase(nome) && !achou) {
					produtoDeletar = produto;
					achou = true;
				}
			}
			if(!achou) {
				System.out.println("\nEste produto não existe no sistema!\n");
			}else {
				listaProdutos.remove(produtoDeletar);
				System.out.println("\nProduto deletado com suceso!\n");
			}
		}
		
	}
	
	public void editarProduto() {
		if(listaProdutos.size() == 0 ) {
			System.out.println("\nNão há produtos cadastrados no sistema!\n");
		}else {
			String nome = "";
			System.out.println("Digite o nome do produto a ser editado: ");
			nome = Dados.scan.next();
			boolean achou = false;
			for(Produto produto : listaProdutos) {
				if(produto.getNome().equalsIgnoreCase(nome) && !achou) {
					produto = dados.editarProduto(produto);
					achou = true;
				}
			}
			if(!achou) {
				System.out.println("\nEste produto não existe no sistema!\n");
			}else {
				System.out.println("\nProduto alterado com sucesso!\n");
			}
		}
		
	}
	
	public void relatório() {
		if(listaProdutos.size() == 0) {
			System.out.println("\nNão há produtos cadastrados no sistema!\n");
		}else {
			System.out.println("\nProdutos contidos no sistemas: \n");
			for(Produto produto: listaProdutos) {
				System.out.println(produto);
			}
		}
	}
	
}
