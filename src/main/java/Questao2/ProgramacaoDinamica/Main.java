package Questao2.ProgramacaoDinamica;

import java.util.Date;

import static Questao2.ProgramacaoDinamica.LCS.solveLcs;

public class Main {

    public static void main(String[] args) {
        var inicio = new Date().getTime();
        System.out.print("Tamanho do LCS é: " + (solveLcs("ABCDE", "CDBDE")));
        var fim = new Date().getTime();

        System.out.println("\nTempo para execução: " + (fim-inicio)/1000.0 + " s.");
    }

}
