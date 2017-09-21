package estruturadedados.avalicao3;


public class Principal {
	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.inserir("Bbb");
		lista.inserir("aaA");		
		System.out.println("Primeiro teste:");
		
		lista.imprimir();
		lista.sort();
		lista.imprimir();
		lista = new Lista();
		lista.inserir("BBb");
		lista.inserir("AaA");
		lista.inserir("DDD");
		lista.inserir("eee");
		lista.inserir("cCc");
		System.out.println("\nSegundo teste:");
		
		lista.imprimir();
		lista.sort();
		lista.imprimir();
		lista = new Lista();
		lista.inserir("eee");
		lista.inserir("Ddd");
		lista.inserir("CcC");
		lista.inserir("bbB");
		lista.inserir("fcC");
		lista.inserir("aAa");		
		System.out.println("\nTerceiro teste:");
		
		lista.imprimir();
		lista.sort();
		lista.imprimir();
	}
}
