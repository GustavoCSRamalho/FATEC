package sistemasoperacionais.exercicio3;

import java.nio.channels.Channel;
import java.util.Date;

public class Producer implements Runnable{
	//Cria uma variavel do tipo MessageQueue
	private MessageQueue mbox;
	
	public Producer(MessageQueue mbox) {
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
			//Instancia a message com o Date.
			message = new Date();
			//Printa a mensagem com o conteudo do Date.
			System.out.println("Producer produced "+message);
			//Adiciona a mensagem no vetor.
			mbox.send(message);
		}
	}

}
