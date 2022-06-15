package Questao1;

import java.util.LinkedList;

public class Graph {

    public int V;
    public LinkedList<Integer> adj[];
    public LinkedList<Integer> cycles[];
    public static int num_cycles = 0;

    public Graph(int v){
        V = v;
        adj = new LinkedList[V];
        cycles = new LinkedList[V];

        for(int i=0; i<V;i++) {
            adj[i] = new LinkedList();
            cycles[i] = new LinkedList();
        }

    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }
}