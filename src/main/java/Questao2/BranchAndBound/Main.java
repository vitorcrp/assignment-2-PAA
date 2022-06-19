package Questao2.BranchAndBound;

import java.util.Date;

import static Questao2.BranchAndBound.Knapsack.knapsack;

public class Main {

    public static void main(String[] args) {
        int capacity = 9;

        var item1 = Item.builder()
                    .value(10)
                    .weight(4)
                    .build();

        var item2 = Item.builder()
                .value(15)
                .weight(2)
                .build();

        var item3 = Item.builder()
                .value(20)
                .weight(7)
                .build();

        var item4 = Item.builder()
                .value(13)
                .weight(4)
                .build();

        Item[] array = { item1, item2, item3, item4};

        var inicio = new Date().getTime();
        System.out.println("Utilizando a estratégia Branch and Bound a melhor solução encontrada é: " + knapsack(capacity, array, array.length));
        var fim = new Date().getTime();

        System.out.println("\nTempo para execução: " + (fim-inicio)/1000.0 + " s.");
    }
}
