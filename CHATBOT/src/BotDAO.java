

import java.io.IOException;
import java.util.Scanner;

public class BotDAO {
	private Runtime r;
	private String[] cmd;
	private Process p;
	private static Scanner scanner;
	private String mensagem;
	
	BotDAO(){
		r = Runtime.getRuntime();
	}
	
	void comando(String comando) throws IOException {
		String[] configuracao = { "/bin/sh", "-c", comando };
		this.cmd = configuracao;
		p = r.exec(configuracao);
		scanner = new Scanner(p.getInputStream()).useDelimiter("$$");
		executa();
	}
	
	void executa() {
		String mensagem = "";
		if (scanner.hasNext()) {
		    System.out.println("stdout");
		    mensagem = scanner.useDelimiter("$$").next();
//		    System.out.println(scanner.useDelimiter("$$").next());
		    
		    System.out.println(mensagem);
		}

		scanner = new Scanner(p.getErrorStream()).useDelimiter("$$");
		if (scanner.hasNext()) {
		    System.out.println("stdout");
		    System.out.println(scanner.useDelimiter("$$").next());
		}
		
		System.out.println("Mensagem "+mensagem);
		this.mensagem = mensagem;
	}
	
	String mensagem() {
		return this.mensagem;
	}
	
}
