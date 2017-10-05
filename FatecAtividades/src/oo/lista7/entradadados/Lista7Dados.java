package oo.lista7.entradadados;

import java.util.Scanner;

import oo.lista7.models.Lista7Item;
import oo.lista7.models.Lista7Usuario;

public class Lista7Dados {
	public static Scanner scan;
	private double valor;
	private Lista7Item item;
	
	public Lista7Dados() {
		scan = new Scanner(System.in);
	}
	
	public final Lista7Item recebeValor() {
		item = new Lista7Item();
		System.out.println("\nDigite o motivo do gasto: ");
		item.setNome(scan.next()+scan.nextLine());
		System.out.println("\nDigite o valor: ");
		item.setValor(scan.nextDouble());
		return item;
	}
	
	public final Lista7Usuario checaUsuario() {
		Lista7Usuario usuario = null;
		usuario = new Lista7Usuario();
		System.out.println("Digite o nome do usuario: ");
		usuario.setUsuario(scan.next());
		System.out.println("Digite a senha do usuario: ");
		usuario.setSenha(scan.next());
		return usuario;
	}
}
