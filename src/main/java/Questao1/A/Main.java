package Questao1.A;

import Questao1.Graph;

public class Main {
    public static void main(String[] args)

    {

        var graph = new Graph(15);

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





        String str = "ABC";

        int n = str.length();

        Permutation permutation = new Permutation();

        permutation.permute(str, 0, n-1);

    }

}
