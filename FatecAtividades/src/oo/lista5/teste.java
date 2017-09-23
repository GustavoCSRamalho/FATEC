package oo.lista5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import oo.lista5.modelos.Aluno;



public class teste {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
//		Agenda agenda = new Agenda();
//		agenda.salvarAgenda();
		List<Aluno> lista = new ArrayList<Aluno>();
		Aluno aluno = new Aluno();
		aluno.setEmail("@@@");
		aluno.setNome("roberto");
		aluno.setNumeroMatricula("666");
		aluno.setTelefone("787879");
//		lista.add(aluno);
//		FileOutputStream escrever = new FileOutputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
//				"Exercicios/exercicio5/agenda.txt");
//		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
		try {
			FileInputStream ler = new FileInputStream("/home/gustavo/Documents/fatec/OrientacaoObjeto/"+
					"Exercicios/exercicio5/agenda.txt");
			
			ObjectInputStream lerObjeto = new ObjectInputStream(ler);
			System.out.println("Lendo!");
		}catch(Exception e) {
			System.out.println("Arquivo criado!");
		}
		
		
//		escreverObjeto.writeObject(lista);
////		
//		List<Aluno> lista1 = (List<Aluno>) lerObjeto.readObject();
//		
//		System.out.println("Tamanho : "+lista1.size());
//		for(Aluno aluno1: lista1) {
//			System.out.println("Nome: "+aluno1.getNome());
//		}
		
		
		
//		ObjectOutputStream escreverObjeto = new ObjectOutputStream(escrever);
//		System.out.println("Arquivo criado!");
	}

}
