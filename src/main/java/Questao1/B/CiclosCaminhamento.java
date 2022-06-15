package Questao1.B;

import Questao1.Graph;

import java.util.*;

public class CiclosCaminhamento {

    static int white = 0, gray = 1, black = 2;


    static void DFSCycleUtil(Graph graph, int source, int parent, int[] color, int parents[]) {



        if(color[source]== gray) {
            System.out.println("Cycle");
            int curr_parent = parent;
            graph.cycles[Graph.num_cycles].add(source);
            System.out.println(source);

            while(curr_parent != source) {
                graph.cycles[Graph.num_cycles].add(curr_parent);
                System.out.println(curr_parent);
                curr_parent = parents[curr_parent];

            }



//			for(int i = source;i<color.length;i++) {
//				if(color[i]==gray) {
//					cycles[num_cycles].add(i);
//					System.out.println(i);
//				}
//			}
            Graph.num_cycles ++;
            return;
        }

        else if(color[source]== black) {
            return;
        }

        parents[source] = parent;
        color[source] = gray;

        Iterator<Integer> i = graph.adj[source].listIterator();

        while(i.hasNext()) {
            int n= i.next();
            if(n != parent) {

                DFSCycleUtil(graph, n, source, color,parents);
            }

        }

        color[source] = black;

    }

    static void DFSCycle(Graph graph) {

        int color[] = new int[graph.V];
        int parents[] = new int[graph.V];

        for(int i = 0;i < graph.V; i++) {
            color[i] = white;
        }

        for(int i=0; i<graph.V ;i++) {

            if(color[i]== white) {

                DFSCycleUtil(graph, i,-1,color,parents);
            }

        }

    }
}
