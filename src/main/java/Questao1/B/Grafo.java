package Questao1.B;

import java.util.LinkedList;

public class Grafo {

    public int V;
    public LinkedList<Integer> adj[];
    public LinkedList<Integer> ciclos[];
    public static int numeroCiclos = 0;

    public Grafo(int v){
        V = v;
        adj = new LinkedList[V];
        ciclos = new LinkedList[V];

        for(int i=0; i<V;i++) {
            adj[i] = new LinkedList();
            ciclos[i] = new LinkedList();
        }

    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }
}