package Questao1.B;

import Questao1.A.Permutation;
import Questao1.Graph;

import static Questao1.B.CiclosCaminhamento.DFSCycle;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(15);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        DFSCycle(graph);

        var a = graph.cycles;
    }

}
