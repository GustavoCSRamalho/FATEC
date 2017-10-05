package oo.lista3.exercicio6.engine;

import java.util.ArrayList;
import java.util.List;

import oo.lista3.exercicio6.entradadados.Lista3Exercicio6EntradaDados;
import oo.lista3.exercicio6.models.Lista3Exercicio6Cliente;

public class Lista3Exercicio6Aplicativo {
	private List<Lista3Exercicio6Cliente> listaClientes;
	private Lista3Exercicio6EntradaDados dados;
	
	public Lista3Exercicio6Aplicativo() {
		listaClientes = new ArrayList<Lista3Exercicio6Cliente>();
		dados = new Lista3Exercicio6EntradaDados();
	}
	
	public void listarClientes() {
		System.out.println("\n--------\n");
		System.out.println("Lista de clientes: ");
		if(listaClientes.size() == 0 || listaClientes == null) {
			System.out.println("\nSem clientes.\n");
		}else {
			for(Lista3Exercicio6Cliente cliente: listaClientes) {
				System.out.println("\n--------\n");
				System.out.println(cliente);
				System.out.println("\n--------\n");
			}
		}
		System.out.println("\n--------\n");
	}
	
	public int opcoes() {
		System.out.println("\n1 - Cadastrar cliente.\n2 - Editar cliente.\n3 - Excluir cliente.\n"
				+ "4 - Gasto de todos os clientes.\n5 - Gasto total dos cliente no ano.\n"
				+ "6 - Maior gasto de dinheiro dos meses.\n7 - Maior gasto de dinheiro do ano.\n"
				+ "8 - listar clientes.\n9 - Sair.\n");
		int opcao = Lista3Exercicio6EntradaDados.scan.nextInt();
		return opcao;
	}
	
	public void cadastrarCliente() {
		listaClientes.add(dados.adicionaCliente());
		System.out.println("\nCliente adicionado com sucesso!\n");
	}
	
	public void excluirCliente() {
		String nome = "";
		System.out.println("Digite o nome do cliente a ser excluido: ");
		nome = Lista3Exercicio6EntradaDados.scan.next();
		Lista3Exercicio6Cliente clienteExcluir = null;
		boolean encontrou = false;
		for(Lista3Exercicio6Cliente cliente: listaClientes) {
			if(cliente.getNome().equalsIgnoreCase(nome) && !encontrou) {
				clienteExcluir = cliente;
				encontrou = true;
			}
		}
		if(!encontrou) {
			System.out.println("\nNão existe cliente com esse nome.\n");
		}else {
			listaClientes.remove(clienteExcluir);
			System.out.println("\nCliente excluido com sucesso!\n");
		}
	}
	
	public void editarCliente() {
		String nome = "";
		boolean encontrou = false;
		System.out.println("Digite o nome do cliente a ser editado: ");
		nome = Lista3Exercicio6EntradaDados.scan.next();
		for(Lista3Exercicio6Cliente cliente: listaClientes) {
			if(cliente.getNome().equals(nome) && !encontrou) {
				cliente = dados.edicaoCliente(cliente);
				encontrou = true;
			}
		}
		if(!encontrou) {
			System.out.println("\nNão existe cliente com esse nome.\n");
		}else {
			System.out.println("\nCliente alterado com sucesso!\n");
		}
	}
	
	public void montanteGastoClientes() {
		if(listaClientes == null || listaClientes.size() == 0) {
			System.out.println("\nNão a nenhum cliente adicionados para fazer o calculo!\n");
		}else {
				System.out.println("Montante gasto pelos clientes nos 12 meses: ");
				for(Lista3Exercicio6Cliente cliente : listaClientes) {
					System.out.println("\n--------\n");
					System.out.println("Cliente: "+cliente.getNome());
					for(int i = 0; i < 12; i++ ) {
						System.out.printf("Mes %d = R$%.2f\n",i+1,cliente.getGastoMeses().get(i));
					}
					System.out.println("\n--------\n");
				}
			}
		
		System.out.println("\n");
	}
	
	public void montateTotalGastoClientes() {
		if(listaClientes == null || listaClientes.size() == 0) {
			System.out.println("\nNão a nenhum cliente adicionados para fazer o calculo!\n");
		}else {
			System.out.println("Montante gasto pelos clientes nos 12 meses: ");
			double total = 0;
			for(Lista3Exercicio6Cliente cliente : listaClientes) {
				total = 0;
				System.out.println("\n--------\n");
				System.out.println("Cliente: "+cliente.getNome());
				for(int i = 0; i < 12; i++ ) {
					if(cliente.getGastoMeses().get(i) != null) {
						total += cliente.getGastoMeses().get(i).doubleValue();
					}
				}
				System.out.printf("Valor gasto no 12 meses =  R$%.2f\n",total);
				System.out.println("\n--------\n");
			}
		}
		
		System.out.println("\n");
	}
	
	public void maiorGastoMes() {
		if(listaClientes == null) {
			System.out.println("\nNão a nenhum cliente adicionados para fazer o calculo!\n");
		}else {
			System.out.println("Maior gasto de mês dos cliente foi do(a) : ");
			double maiorGastoMes = 0;
			String nome = null;
			System.out.println("\n--------\n");
			System.out.println("Cliente: ");
			for(Lista3Exercicio6Cliente cliente : listaClientes) {
				for(int i = 0; i < 12; i++ ) {
					if(cliente.getGastoMeses().get(i) != null) {
						if(cliente.getGastoMeses().get(i).doubleValue() > maiorGastoMes) {
							maiorGastoMes = cliente.getGastoMeses().get(i).doubleValue();
							nome = cliente.getNome();
						}
						
					}
				}
				

			}
			System.out.printf("\n%s com  R$%.2f\n",nome,maiorGastoMes);
			System.out.println("\n--------\n");
		}
		
		System.out.println("\n");
	}

	public void maiorGastoAno() {
		if (listaClientes == null) {
			System.out.println("\nNão a nenhum cliente adicionados para fazer o calculo!\n");
		} else {
			String nome = null;
			double maiorGastoAno = 0, totalGasto = 0;
			System.out.println("Maior gasto de ano dos cliente foi do(a) : ");
			System.out.println("\n--------\n");
			System.out.println("Cliente: ");
			for (Lista3Exercicio6Cliente cliente : listaClientes) {
				totalGasto = 0;
				
				for (int i = 0; i < 12; i++) {
					if (cliente.getGastoMeses().get(i) != null) {
						totalGasto += cliente.getGastoMeses().get(i).doubleValue();
					}
				}
				if (totalGasto > maiorGastoAno) {
					maiorGastoAno += totalGasto;
					nome = cliente.getNome();
				}
			}
			System.out.printf("\n%s com  R$%.2f\n", nome, maiorGastoAno);
			System.out.println("\n--------\n");
		}
	}
}
