package sistemasoperacionais.exercicio3;

public class Factory {
	public Factory() {
		//Instancia a classe onde será armazenado os itens recebidos e enviado.
		MessageQueue mailBox = new MessageQueue();
		
		//Aloca um espaço de memoria a ser utilizada pela thread;
		Thread producerThread = new Thread(new Producer(mailBox));
		Thread consumerThread = new Thread(new Consumer(mailBox));
		
		//Inicia a thread nesse espaço de memoria reservado para ela.
		producerThread.start();
		consumerThread.start();
	}
	
	public static void main(String[] args) {
		//Instancia a classe factory para que o programa rode.
		Factory server = new Factory();
	}
}
