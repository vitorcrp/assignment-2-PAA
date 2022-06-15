package Questao1.B;

import java.util.*;

public class Graph {

    static int white = 0, gray = 1, black = 2;

    int V;
    LinkedList<Integer> adj[];
    LinkedList<Integer> cycles[];
    static int num_cycles = 0;

    Graph(int v){
        V = v;
        adj = new LinkedList[V];
        cycles = new LinkedList[V];

        for(int i=0; i<V;i++) {
            adj[i] = new LinkedList();
            cycles[i] = new LinkedList();
        }

    }

    void DFSCycleUtil(int source, int parent, int[] color, int parents[]) {



        if(color[source]== gray) {
            System.out.println("Cycle");
            int curr_parent = parent;
            cycles[num_cycles].add(source);
            System.out.println(source);

            while(curr_parent != source) {
                cycles[num_cycles].add(curr_parent);
                System.out.println(curr_parent);
                curr_parent = parents[curr_parent];

            }



//			for(int i = source;i<color.length;i++) {
//				if(color[i]==gray) {
//					cycles[num_cycles].add(i);
//					System.out.println(i);
//				}
//			}
            num_cycles ++;
            return;
        }

        else if(color[source]== black) {
            return;
        }

        parents[source] = parent;
        color[source] = gray;

        Iterator<Integer> i = adj[source].listIterator();

        while(i.hasNext()) {
            int n= i.next();
            if(n != parent) {

                DFSCycleUtil(n, source, color,parents);
            }

        }

        color[source] = black;



    }

    void DFSCycle() {

        int color[] = new int[V];
        int parents[] = new int[V];

        for(int i = 0;i<V;i++) {
            color[i] = white;
        }

        for(int i=0; i<V;i++) {

            if(color[i]== white) {

                DFSCycleUtil(i,-1,color,parents);
            }

        }

    }

    void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public static void main(String[] args) {

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

        graph.DFSCycle();

        var a = graph.cycles;
    }
}
