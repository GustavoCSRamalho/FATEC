package oo.atividade1.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import oo.atividade1.models.Comentarios;
import oo.atividade1.models.Produto;
public class PlataformaDAO {
	private List<Produto> listaProdutos;
	private List<Produto> ranking;
	private List<Comentarios> comentarios;
	private InformacaoDAO dados;
	private String enderecoListaProdutos;
	private String enderecoListaComentarios;
	
	public PlataformaDAO() {
		this.listaProdutos = new ArrayList<Produto>();
		this.dados = new InformacaoDAO();
		this.comentarios = new ArrayList<Comentarios>();
		this.ranking = new ArrayList<Produto>();
		this.enderecoListaProdutos = "/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/atividade1/listaProdutos.txt";
		this.enderecoListaComentarios= "/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
				"Exercicios/atividade1/listaComentarios.txt";
	}
	public final void cadastrar() throws IOException {
		Produto produto = dados.criaProduto();
		System.out.println("1");
		listaProdutos.add(produto);
		System.out.println("2");
		ranking.add(produto);
		System.out.println("3");
		atualizaListaProdutos();
		System.out.println("4");
		System.out.print("\nProduto cadastrado com sucesso!\n");
	}
	public final void criaArquivo() throws IOException, ClassNotFoundException {
		try(FileInputStream ler = new FileInputStream(enderecoListaProdutos);) {
			System.out.print("O arquivo ja existe então não é preciso criar outro!");
		}catch(Exception e) {
			FileOutputStream escrever = new FileOutputStream(enderecoListaProdutos);
			ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(listaProdutos);
			escreverObjeto.close();
			escrever.close();
			escrever = new FileOutputStream(enderecoListaComentarios);
			escreverObjeto = new ObjectOutputStream(escrever);
			escreverObjeto.writeObject(comentarios);
			escreverObjeto.close();
			escrever.close();
			
		}
		recuperaDados();
	}
	
	private final void atualizaListaProdutos() throws IOException {
		FileOutputStream escrever = new FileOutputStream(enderecoListaProdutos);
		ObjectOutputStream escreverObj = new ObjectOutputStream(escrever);
		escreverObj.writeObject(listaProdutos);
		escreverObj.close();
		escrever.close();
		escrever = new FileOutputStream(enderecoListaComentarios);
		escreverObj = new ObjectOutputStream(escrever);
		escreverObj.writeObject(comentarios);
		escreverObj.close();
		escrever.close();
	}
	
	private final void recuperaDados() throws ClassNotFoundException, IOException {
		FileInputStream ler = new FileInputStream(enderecoListaProdutos);
		ObjectInputStream lerObjeto = new ObjectInputStream(ler);
		List<Produto> produtosRecuperados = (List<Produto>) lerObjeto.readObject();
		listaProdutos.addAll(produtosRecuperados);
		ranking.addAll(produtosRecuperados);
		lerObjeto.close();
		ler.close();
		ler = new FileInputStream(enderecoListaComentarios);
		lerObjeto = new ObjectInputStream(ler);
		List<Comentarios> listaComentarios = (List<Comentarios>) lerObjeto.readObject();
		comentarios.addAll(listaComentarios);
		lerObjeto.close();
		ler.close();
	}
	
	public final void venderProduto() throws IOException{
		String nomeProduto = dados.nomeProduto();
		boolean vender = false;
		for(Produto produto: listaProdutos) {
			if(produto.getNome().equalsIgnoreCase(nomeProduto)) {
				if(produto.getQuantidade() != 0) {
					if(dados.confirmaCompra().equalsIgnoreCase("y")) {
						int qntd = produto.getQuantidade();
						int qntdVendido = produto.getQuantidadeVendido();
						produto.setQuantidade(--qntd);
						produto.setQuantidadeVendido(++qntdVendido);
						vender = true;
						System.out.print("\nComprado com sucesso!\n");
					}else {
						System.out.print("\nProduto cancelado!\n");
					}
					
				}else {
					System.out.print("\nEstoque esgotado!\n");
				}
			}
		}
		if(!vender) {
			System.out.print("\nO produto não existe no estoque!\n");
		}
		atualizaListaProdutos();
	}
	
	public final void comentario() throws IOException {
		Comentarios comentario = null;
		String nome = dados.nomeProdutoComentario();
		boolean achou = false;
		for(Produto produto : listaProdutos) {
			if(produto.getNome().equalsIgnoreCase(nome)) {
				comentario = dados.adicionarComentario();
				comentario.setNomeProduto(nome);
				comentarios.add(comentario);
				achou = true;
				System.out.print("\nComentario adicionado!\n");
			}
		}
		if(!achou) {
			System.out.print("Esse produto não existe no banco de dados para ser comentado!\n");
		}else {
			atualizaListaProdutos();
		}
	}
	
	public final void imprimeLista() {
		for(Produto produto: listaProdutos) {
			System.out.print(produto);
		}
	}
		
	public final int imprimeOpcao() {
		return dados.opcoes();
		
	}
	
	public final void imprimeRanking() {
		ordenaPorNome(ranking);
		System.out.print("\nRanking : \n");
		for(Produto produto: ranking) {
			System.out.println(produto);
		}
	}
	
	public final void imprimeComentarios() {
		for(Comentarios comentario : comentarios) {
			System.out.println(comentario);
		}
	}
	
	private static final void ordenaPorNome(List<Produto> ranking) {  
        Collections.sort(ranking, new Comparator<Produto>() {  
            @Override  
            public int compare(Produto p1, Produto p2) {  
                return p2.getQuantidadeVendido() - (p1.getQuantidadeVendido());  
            }  

     });  
    }
}
