package oo.paint.paint;



import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Janela extends JFrame{
	public Janela(){
		//Para ativiar o rabisco, clica com o botão direito
		//Então o botão esquerdo ao invez de pintar ele apaga
		//Aperte novamente para o botão esquerdo voltar a pintar
		Rabisco rab1 = new Rabisco(Color.RED);//(Color.RED);
		Rabisco rab2 = new Rabisco(Color.BLUE);
		rab1.setBorder(BorderFactory.createLineBorder(Color.RED));
		rab2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		getContentPane().setLayout(new GridLayout(1,2));
		getContentPane().add(rab1);
		getContentPane().add(rab2);
		pack();
		setVisible(true);
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new Janela();
	}
}

