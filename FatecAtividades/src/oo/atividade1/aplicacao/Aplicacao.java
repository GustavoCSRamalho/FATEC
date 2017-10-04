package oo.atividade1.aplicacao;

import java.io.IOException;

import oo.atividade1.dao.InformacaoDAO;
import oo.atividade1.dao.PlataformaDAO;

final class Aplicacao {
	private static PlataformaDAO dao;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		dao = new PlataformaDAO();
		dao.criaArquivo();
		boolean funciona = true;
		do{
			int opcao = dao.imprimeOpcao();
			switch(opcao) {
			case 1:
				dao.cadastrar();
				break;
			case 2:
				dao.venderProduto();
				break;
			case 3:
				dao.imprimeLista();
				break;
			case 4:
				dao.imprimeRanking();
				break;
			case 5:
				dao.comentario();
				break;
			case 6:
				dao.imprimeComentarios();
				break;
			case 7:
				funciona = false;
				break;
			}
		}while(funciona);
		System.out.println("Sistema desligado!");
	}
}
