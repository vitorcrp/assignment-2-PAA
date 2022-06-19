package Questao2.DivisaoConquista;

import java.util.Date;

class Main {
    public static void main(String[] args) {

        Geracao algoritmo;
        var n = (args.length < 1) ? 1000 : Integer.parseInt(args[0]);

        algoritmo = new Quicksort(n);

        algoritmo.aleatorio();

        System.out.println("\n Algoritmo desordenado:");
        algoritmo.mostrar();

        var inicio = new Date().getTime();
        algoritmo.sort();
        var fim = new Date().getTime();

        System.out.println("\nTempo para ordenar: " + (fim-inicio)/1000.0 + " s.");

        System.out.println("\nAlgoritmo ordenado:");
        algoritmo.mostrar();
    }
}