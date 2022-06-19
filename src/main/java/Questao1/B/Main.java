package Questao1.B;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(15);

        grafo.addEdge(1, 2);
        grafo.addEdge(1, 4);
        grafo.addEdge(1, 5);
        grafo.addEdge(2, 3);
        grafo.addEdge(2, 4);
        grafo.addEdge(2, 5);
        grafo.addEdge(3, 5);
        grafo.addEdge(3, 4);
        grafo.addEdge(3, 6);
        grafo.addEdge(4, 6);
        grafo.addEdge(5, 6);

        CiclosCaminhamento.encontraCiclo(grafo);

        var a = graph.ciclos;
    }

}
