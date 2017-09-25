package sistemasoperacionais.exercicio3;

import java.util.Date;

public class Consumer implements Runnable{
	//Cria uma variavel do tipo MessageQueue
	private MessageQueue mbox;
	
	public Consumer(MessageQueue mbox) {
		//Instancia a classe que vai Armazenar os dados.

		this.mbox = mbox;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Cria um atributo do tipo Date.
		Date message;
		
		//Loop infinito
		while(true) {
			//Coloca a thread para dormir durante um tempo.

			SleepUtilities.nap();
			//Adiciona ao atributo message o objeto removido da lista e retornado pelo método receive,
			//então da-se o cast para que ele possa ler lido na sua verdadeira forma.
			message = (Date) mbox.receive();
			
			//Se a mensagem não for null ele entra no metodo.
			if(message != null) {
				//Printa a mensagem com o conteudo do Date.

				System.out.println("Consumer consumed "+message);
			}
		}
	}
	
	
}
