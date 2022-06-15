package Questao2.DivisaoConquista;

class Main {
    public static void main(String[] args) {

        Geracao algoritmo;
        int n = (args.length < 1) ? 1000 : Integer.parseInt(args[0]);
        double inicio, fim;

        algoritmo = new Quicksort(n);

        algoritmo.aleatorio();

        System.out.println("\n Algoritmo desordenado:");
        algoritmo.mostrar();

        inicio = algoritmo.now();
        algoritmo.sort();
        fim = algoritmo.now();

        System.out.println("\nTempo para ordenar: " + (fim-inicio)/1000.0 + " s.");

        System.out.println("\nAlgoritmo ordenado:");
        algoritmo.mostrar();
    }
}