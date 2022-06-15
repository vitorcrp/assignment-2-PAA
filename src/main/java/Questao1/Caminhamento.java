package Questao1;

import java.util.*;

class Caminhamento {

    static final int N = 200;

    @SuppressWarnings("unchecked")
    static Vector<Integer>[] graph = new Vector[N];
    @SuppressWarnings("unchecked")
    static Vector<Integer>[] cycles = new Vector[N];
    static int cyclenumber;

    // Function to mark the vertex with
    // different colors for different cycles
    static void dfs_cycle(int u, int p, int[] color, Map<Integer, List<Integer>> mark, int[] par) {

        // already (completely) visited vertex.
        if (color[u] == 2) {
            return;
        }

        // seen vertex, but was not completely visited -> cycle detected.
        // backtrack based on parents to find the complete cycle.
        if (color[u] == 1) {

            cyclenumber++;
            int cur = p;
            if(!mark.containsKey(cur)){
                mark.put(cur, new ArrayList<>());
            }
            mark.get(cur).add(cyclenumber);

            // backtrack the vertex which are
            // in the current cycle thats found
            while (cur != u) {
                cur = par[cur];
                if(!mark.containsKey(cur)){
                    mark.put(cur, new ArrayList<>());
                }
                mark.get(cur).add(cyclenumber);
            }
            return;
        }
        par[u] = p;

        // partially visited.
        color[u] = 1;

        // simple dfs on graph
        for (int v : graph[u]) {

            // if it has not been visited previously
            if (v == par[u]) {
                continue;
            }
            dfs_cycle(v, u, color, mark, par);
        }

        // completely visited.
        color[u] = 2;
    }

    // add the edges to the graph
    static void addEdge(int u, int v)
    {
        graph[u].add(v);
        graph[v].add(u);
    }

    // Function to print the cycles
    static void printCycles(int edges, int mark[]) {

        // push the edges that into the
        // cycle adjacency list
        for (int i = 1; i <= edges; i++)
        {
            if (mark[i] != 0)
                cycles[mark[i]].add(i);
        }

        // print all the vertex with same cycle
        for (int i = 1; i <= cyclenumber; i++)
        {
            // Print the i-th cycle
            System.out.printf("Cycle Number %d: ", i);
            for (int x : cycles[i])
                System.out.printf("%d ", x);
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            graph[i] = new Vector<>();
            cycles[i] = new Vector<>();
        }

        // add edges
        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(1, 5);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(3, 5);
        addEdge(3, 4);
        addEdge(3, 6);
        addEdge(4, 6);
        addEdge(5, 6);
//        addEdge(5, 9);
//        addEdge(10, 11);
//        addEdge(11, 12);
//        addEdge(11, 13);
//        addEdge(12, 13);

        // arrays required to color the
        // graph, store the parent of node
        int[] color = new int[N];
        int[] par = new int[N];

        var mark = new HashMap<Integer, List<Integer>>();
        // mark with unique numbers
        //int[] mark = new int[N];

        // store the numbers of cycle
        cyclenumber = 0;
        int edges = 13;

        // call DFS to mark the cycles
        dfs_cycle(1, 0, color, mark, par);

        mark.get(4);

        // function to print the cycles
        //printCycles(edges, mark);
    }
}
