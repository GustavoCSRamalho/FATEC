package oo.lista1.revisaoclasse;

public class Lista1Aluno extends Lista1Pessoa{
	public int numeroMatricula;
	public String turma;
	public Lista1Aluno(String nome, int numeroMatricula, String turma) {
		super(nome);
		this.numeroMatricula = numeroMatricula;
		this.turma = turma;
	}
}
