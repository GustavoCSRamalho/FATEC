package oo.lista7.entradadados;

import java.util.Scanner;

import oo.lista7.models.Item;
import oo.lista7.models.Usuario;

public class Dados {
	public static Scanner scan;
	private double valor;
	private Item item;
	
	public Dados() {
		scan = new Scanner(System.in);
	}
	
	public final Item recebeValor() {
		item = new Item();
		System.out.println("\nDigite o motivo do gasto: ");
		item.setNome(scan.next()+scan.nextLine());
		System.out.println("\nDigite o valor: ");
		item.setValor(scan.nextDouble());
		return item;
	}
	
	public final Usuario checaUsuario() {
		Usuario usuario = null;
		usuario = new Usuario();
		System.out.println("Digite o nome do usuario: ");
		usuario.setUsuario(scan.next());
		System.out.println("Digite a senha do usuario: ");
		usuario.setSenha(scan.next());
		return usuario;
	}
}
