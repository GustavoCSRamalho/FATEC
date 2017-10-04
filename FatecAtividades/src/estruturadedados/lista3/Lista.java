package estruturadedados.lista3;

public class Lista {
	No inicio;
	NoNovo inicioNovo;
	Lista(){
		inicio = null;
		inicioNovo = null;
	}
	void inserir(int nro) {
		No no = new No();
		no.conteudo = nro;
		no.proximo = null;
		
		if(inicio == null) {
			inicio = no;
		}else {
			No ultimo = inicio;
			while(ultimo.proximo != null) {
				ultimo = ultimo.proximo;
			}
			ultimo.proximo = no;
		}
	}
	
//	void inserirNoNovo(int nro) {
//		NoNovo no = new NoNovo();
//		no.anterior = null;
//		no.conteudo = nro;
//		no.proximo = null;
//		
//		if(inicioNovo == null) {
//			inicioNovo = no;
//		}else {
//			NoNovo ultimo = inicioNovo;
//			while(ultimo.proximo != null && ultimo.anterior == null) {
//				ultimo.anterior = 
//				ultimo = ultimo.proximo;
//			}
//			ultimo.proximo = ;
//		}
//	}
	
	
	
	void exercicio1() {
		System.out.print("Exercicio 1:");
		No no = null;
		no = inicio.proximo.proximo;
		No temp =  no.proximo;
		System.out.print(no.conteudo);
		remover(temp.conteudo);
		System.out.println("Resp: "+no.proximo.proximo.conteudo);
	}
	
	void exercicio4(No no) {
		if(no != null) {
			System.out.println(no.conteudo+";");
			exercicio4(no.proximo);
		}
		System.out.println("aqui"+";");
	}
	void exercicio12() {
		No no = inicio;
		no = no.proximo.proximo.proximo;
		System.out.println("Conteudo : "+no.conteudo);
		no.proximo = no.proximo.proximo;
	}
	
	void exercicio15() {
		No a = inicio;
		while(a != null) {}
	}
	
	void exercicio11() {
		No no = new No();
		no.conteudo = 22;
		No lista = inicio;
		lista = lista.proximo;
		System.out.println("Lista " +lista.conteudo);
		no.proximo = lista.proximo;
		lista.proximo = no;
		
	}
	void exercicio5(No no) {
		System.out.println("aqui"+";");
		if(no != null) {
			System.out.print(no.conteudo+";");
			exercicio5(no.proximo);
		}
	}
	int exercicio7(int cont,No no) {
		if(no.proximo != null) {
			return exercicio7(++cont, no.proximo);
		}
		return cont;
	}
	
	void remover(int nro) {
		No anterior = null;
		No atual = inicio;
		while(atual != null && atual.conteudo != nro) {
			anterior = atual;
			atual = atual.proximo;
		}
		if(anterior == null && atual != null) {
			inicio = atual.proximo;
		}else if(atual != null){
			anterior.proximo = atual.proximo;
		}
	}
	
	void imprimir() {
		if(inicio == null) {
			System.out.println("Lista vazia!");
		}else {
			System.out.println();
			No ultimo = inicio;
			while(ultimo != null){
				System.out.println(ultimo.conteudo+" ");
				ultimo = ultimo.proximo;
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
