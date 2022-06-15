package Questao2.BranchAndBound;

import static Questao2.BranchAndBound.Knapsack.knapsack;

public class Main {

    public static void main(String[] args) {
        double initialTime = System.currentTimeMillis();

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

        Item array[] = { item1, item2, item3, item4};
        System.out.println("Utilizando a estratégia Branch and Bound a melhor solução encontrada é: " + knapsack(capacity, array, array.length));

        double endTime = System.currentTimeMillis();
        double totalTime = (endTime - initialTime) / 10000;
        System.out.println("Tempo = " + totalTime);
    }
}
