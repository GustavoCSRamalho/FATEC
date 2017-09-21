package oo.lista2.exercicio5;

final class Cliente {
	long numeroConta;
	double saldoInicialMes;
	double totalMes;
	double totalCreditoCliente;
	double limiteAutorizado;
	double novoSaldo;
	
	void novoSaldo() {
		this.novoSaldo = saldoInicialMes + totalMes - totalCreditoCliente;
		System.out.println("Novo saldo  = "+novoSaldo);
		if(novoSaldo > limiteAutorizado) {
			System.out.println("Excede o limite autorizado!\n");
		}else {
			System.out.println("Não excede o limite.\n");
		}
		
	}
	
	public long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldoInicialMes() {
		return saldoInicialMes;
	}

	public void setSaldoInicialMes(double saldoInicialMes) {
		this.saldoInicialMes = saldoInicialMes;
	}

	public double getTotalMes() {
		return totalMes;
	}

	public void setTotalMes(double totalMes) {
		this.totalMes = totalMes;
	}

	public double getTotalCreditoCliente() {
		return totalCreditoCliente;
	}

	public void setTotalCreditoCliente(double totalCreditoCliente) {
		this.totalCreditoCliente = totalCreditoCliente;
	}

	public double getLimiteAutorizado() {
		return limiteAutorizado;
	}

	public void setLimiteAutorizado(double limiteAutorizado) {
		this.limiteAutorizado = limiteAutorizado;
	}

	public double getNovoSaldo() {
		return novoSaldo;
	}

	public void setNovoSaldo(double novoSaldo) {
		this.novoSaldo = novoSaldo;
	}

	
}
