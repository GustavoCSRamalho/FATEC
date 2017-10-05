package oo.lista1.revisaoclasse;

public class Lista1Professor extends Lista1Pessoa{
	public int numeroMatricula;
	public String[] turmas;
	
	public Lista1Professor(String nome, int numeroMatricula) {
		super(nome);
		this.numeroMatricula = numeroMatricula;
	}
	
	public void	setDisciplinas(String[] turmas) {
		this.turmas = turmas;
	}
}
