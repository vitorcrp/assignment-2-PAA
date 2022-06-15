package Questao1.B;

import Questao1.Graph;

import java.util.*;

public class CiclosCaminhamento {

    static int branco = 0, cinza = 1, preto = 2;


    static void DFSCycleUtil(Graph grafo, int origem, int pai, int[] cores, int[] pais) {



        if(cores[origem]== cinza) {
            System.out.println("Ciclo");
            int paiAtual = pai;
            grafo.ciclos[Graph.numeroCiclos].add(origem);
            System.out.println(origem);

            while(paiAtual != origem) {
                grafo.ciclos[Graph.numeroCiclos].add(paiAtual);
                System.out.println(paiAtual);
                paiAtual = pais[paiAtual];

            }



//			for(int i = origem;i<cores.length;i++) {
//				if(cores[i]==gray) {
//					cycles[num_cycles].add(i);
//					System.out.println(i);
//				}
//			}
            Graph.numeroCiclos++;
            return;
        }

        else if(cores[origem]== preto) {
            return;
        }

        pais[origem] = pai;
        cores[origem] = cinza;

        for (int n : grafo.adj[origem]) {
            if (n != pai) {
                DFSCycleUtil(grafo, n, origem, cores, pais);
            }

        }

        cores[origem] = preto;

    }

    static void DFSCycle(Graph grafo) {

        int[] cores = new int[grafo.V];
        int[] pais = new int[grafo.V];

        for(int i = 0;i < grafo.V; i++) {
            cores[i] = branco;
        }

        for(int i=0; i<grafo.V ;i++) {

            if(cores[i]== branco) {

                DFSCycleUtil(grafo, i,-1,cores,pais);
            }

        }

    }
}
