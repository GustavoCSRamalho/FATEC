package oo.lista2.exercicio7;

public class Lista2Exercicio7Empregado {
	private int horasTrabalhadas;
	private double valorHora;
	private double salario;
	
	private void calculaSalario() {
		if(horasTrabalhadas > 40) {
			salario = valorHora*horasTrabalhadas;
			int horasTB = horasTrabalhadas-40;
			salario += (valorHora * 1.5) * horasTB ;
		}else {
			salario = valorHora*horasTrabalhadas;

		}
	}
	
	void imprimeSalario() {
		calculaSalario();
		System.out.println("Salario bruto de = "+salario);
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	
}
