package oo.lista7.engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import oo.lista7.entradadados.Lista7Dados;
import oo.lista7.models.Lista7Item;

public class Lista7SecretarioFinanceiro {
	private List<Lista7Item> entradaCaixa;
	private List<Lista7Item> saidaCaixa;
	private List<Lista7Item> entradaSaida;
	private final String endereco; 
	private Lista7Dados dados;
	
	public Lista7SecretarioFinanceiro() {
		entradaCaixa = new ArrayList<Lista7Item>();
		saidaCaixa = new ArrayList<Lista7Item>();
		dados = new Lista7Dados();
		endereco = "/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/exercicio7/empresaHistorico.txt";
	}
	
	public final int imprimirOpcoes() {
		System.out.println("\n1 - Adicionar valor de entrada\n2 - Adicionar despesa\n3 - Historico empresa\n"
				+ "4 - Salvar dados\n5 - Recuperar dados\n6 - Sair\n");
		int opcao = Lista7Dados.scan.nextInt();
		if(opcao >= 1 && opcao <= 6) {
			return opcao;
		}
		imprimirOpcoes();
		return 0;
	}
	
	public final void entradaCaixa() {
		Lista7Item item = dados.recebeValor();
		item.setTipo("lucro");
		entradaCaixa.add(item);
		System.out.println("\nAdicionado!\n");
	}
	public final void saidaCaixa() {
		Lista7Item item = dados.recebeValor();
		item.setTipo("despesa");
		saidaCaixa.add(item);
		System.out.println("\nAdicionado!\n");
	}
	
	public final void salvaDados() throws IOException {
		FileOutputStream escrever = new FileOutputStream(endereco);
		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
		entradaSaida = new ArrayList<Lista7Item>();
		entradaSaida.addAll(entradaCaixa);
		entradaSaida.addAll(saidaCaixa);
		escreverObjeto.writeObject(entradaSaida);
		System.out.println("Adicionado no arquivo os produtos!");
		escreverObjeto.close();
		escrever.close();
	}
	
	public final void recuperaDados() throws IOException, ClassNotFoundException {
		FileInputStream ler = new FileInputStream(endereco);
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Lista7Item> empresaDados = (List<Lista7Item>) lerObjeto.readObject();
		if (empresaDados.size() != 0) {
			System.out.println("\nProdutos recuperados: \n");
			for(Lista7Item item: empresaDados) {
				if(item.getTipo().equalsIgnoreCase("lucro")) {
					System.out.println("Nome: "+item.getNome());
					entradaCaixa.add(item);
				}
				else {
					System.out.println("nome: "+item.getNome());
					saidaCaixa.add(item);
				}
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
		entradaSaida = new ArrayList<Lista7Item>();
		try(FileInputStream ler = new FileInputStream(endereco);) {
			System.out.println("O arquivo ja existe então não é preciso criar outro!");
		}catch(Exception e) {
			FileOutputStream escrever = new FileOutputStream(endereco);
			ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(entradaSaida);
			escrever.close();
		}
	}
	
	public final void imprimirHistorico() {
		if(entradaCaixa.size() == 0) {
			System.out.println("\nNão a nenhum item de entrada no caixa!\n");
		}else {
			System.out.println("\nEntrada caixa: \n");
			for(Lista7Item item: entradaCaixa) {
				System.out.println("----------");
				System.out.println(item);
				System.out.println("----------");
			}
		}
		if(saidaCaixa.size() == 0) {
			System.out.println("\nNão a nenhum item de saida no caixa!\n");
		}else {
			System.out.println("\nSaida caixa: \n");
			for(Lista7Item item: saidaCaixa) {
				System.out.println("----------");
				System.out.println(item);
				System.out.println("----------");
			}
		}
		
		System.out.println("\nTotal caixa: \n");
		System.out.println("----------");
		System.out.printf("R$ %.2f\n",totalEmpresa());
		System.out.println("----------");
	}
	
	private final double totalEmpresa() {
		double total = 0, entrada = 0, saida = 0;
		
		for(Lista7Item item: entradaCaixa) {
			entrada+= item.getValor().doubleValue();
		}
		for(Lista7Item item: saidaCaixa) {
			saida += item.getValor().doubleValue();
		}
		return entrada - saida;
	}
}
