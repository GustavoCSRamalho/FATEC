package oo.lista5.modelos;

public class Lista5Professor extends Lista5Pessoa{
	private String numeroRegistro;
	private String quantidadeHoraAula;
	
	@Override
	public String dadosFormatados() {
		String dadosFormatados = super.dadosFormatados();
		dadosFormatados = dadosFormatados + "\nRegistro: "+this.getNumeroRegistro();
		dadosFormatados = dadosFormatados+"\nHora/Aula: "+this.getQuantidadeHoraAula();
		return dadosFormatados;
	}
	
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public String getQuantidadeHoraAula() {
		return quantidadeHoraAula;
	}
	public void setQuantidadeHoraAula(String quantidadeHoraAula) {
		this.quantidadeHoraAula = quantidadeHoraAula;
	}
	
	
}
