package oo.lista1.revisaooperadoreslogicos;

public class Lista1OperadoresLogicos {
	public void and(boolean[] coluna1, boolean[] coluna2,boolean[] resultado) {
		for(int n = 0; n < 4;n++) {
			resultado[n] = coluna1[n] && coluna2[n];
			System.out.printf("%s and %s = %s\n",coluna1[n],coluna2[n],resultado[n]);
		}
	}
	public static void main(String[] args) {
		boolean[] coluna1 = {true, true, false, false};
		boolean[] coluna2 = {true, false, true, false};
		boolean[] resultado = new boolean[4];
		
		Lista1OperadoresLogicos operadores = new Lista1OperadoresLogicos();
		operadores.and(coluna1,coluna2,resultado);
	}
}
