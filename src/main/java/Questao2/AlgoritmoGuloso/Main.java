package Questao2.AlgoritmoGuloso;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('A', Arrays.asList(new Vertex('B', 7), new Vertex('C', 8)));
        g.addVertex('B', Arrays.asList(new Vertex('A', 7), new Vertex('F', 2)));
        g.addVertex('C', Arrays.asList(new Vertex('A', 8), new Vertex('F', 6), new Vertex('G', 4)));
        g.addVertex('D', Arrays.asList(new Vertex('F', 8)));
        g.addVertex('E', Arrays.asList(new Vertex('H', 1)));
        g.addVertex('F', Arrays.asList(new Vertex('B', 2), new Vertex('C', 6), new Vertex('D', 8), new Vertex('G', 9), new Vertex('H', 3)));
        g.addVertex('G', Arrays.asList(new Vertex('C', 4), new Vertex('F', 9)));
        g.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));

        g.printGraph('A');
        g.printGraph('B');
        g.printGraph('C');
        g.printGraph('D');
        g.printGraph('E');
        g.printGraph('F');
        g.printGraph('G');
        g.printGraph('H');

        var start = 'A';
        var finish = 'H';

        var shortestPath = g.getShortestPath(start, finish);
        shortestPath.add(start);

        System.out.print("\n" + shortestPath + "\n");
    }

}