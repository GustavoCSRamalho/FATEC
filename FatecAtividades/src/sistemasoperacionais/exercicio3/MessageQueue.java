package sistemasoperacionais.exercicio3;

import java.io.IOException;
import java.nio.channels.Channel;
import java.util.Vector;

//Implementa a classe chanel para que possa compartilhar os atributos que forem
//atribuidos a  esta classe instanciada em qualquer classe.
public class MessageQueue implements Channel{
	private Vector queue;
	
	public MessageQueue() {
		//Instancia o vector para poder utilizar de suas funcionalidades;
		queue = new Vector();
	}
	
	public void send(Object item) {
		//Adiciona um elemento no vetor;
		queue.addElement(item);
	}
	
	public Object receive() {
		//Se o tamanho da lista for zero ele returna null;
		if(queue.size() == 0) {
			return null;
		}else {
			//Se não for zero, ele remove o elemento da lista e retorna o elemento tirado do vetor.
			return queue.remove(0);
		}
	}
	
	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
