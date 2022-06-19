package Questao2.BranchAndBound;

import java.util.ArrayList;
import java.util.List;

class Knapsack {

    static Item[] swap(Item[] array, int i, int j) {
        var aux = array[i];
        array[i] = array[j];
        array[j] = aux;
        return array;
    }

    public static void sort(Item[] array, int arrayLenght) {
        quicksort(array,0, arrayLenght-1);
    }

    private static void quicksort(Item[] array, int esq, int dir) {
        int i = esq, j = dir;
        Item pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i].getValue() / array[i].getWeight() < pivo.getValue() / pivo.getWeight()) i++;
            while (array[j].getValue() / array[j].getWeight() > pivo.getValue() / pivo.getWeight()) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(array, esq, j);
        if (i < dir)  quicksort(array, i, dir);
    }

    static int bound(Vertex u, int arrayLenght, int capacity, Item[] array) {

        if (u.getWeight() >= capacity)
            return 0;

        int profit_bound = u.getProfit();

        int j = u.getLevel() + 1;
        int totWeight = (int) u.getWeight();

        while ((j < arrayLenght) && (totWeight + array[j].getWeight() <= capacity)) {
            totWeight += array[j].getWeight();
            profit_bound += array[j].getValue();
            j++;
        }

        if (j < arrayLenght)
            profit_bound += (capacity - totWeight) * array[j].getValue() / array[j].getWeight();

        return profit_bound;
    }

    static int knapsack(int capacity, Item[] array, int arrayLenght) {
        sort(array, array.length);
        List<Vertex> vertexList = new ArrayList<>();
        Vertex u = new Vertex(-1, 0, 0);
        Vertex v = new Vertex(0, 0, 0, 0);
        vertexList.add(u);

        int maxProfit = 0;
        while (!vertexList.isEmpty()) {
            u = vertexList.get(0);
            vertexList.remove(0);

            if (u.getLevel() == -1)
                v.setLevel(0);

            if (u.getLevel() == arrayLenght - 1)
                continue;

            v.setLevel(u.getLevel() + 1);

            v.setWeight(u.getWeight() + array[v.getLevel()].getWeight());
            v.setProfit(u.getProfit() + array[v.getLevel()].getValue());

            if (v.getWeight() <= capacity && v.getProfit() > maxProfit)
                maxProfit = v.getProfit();

            v.setBound(bound(v, arrayLenght, capacity, array));

            if (v.getBound() > maxProfit) {
                Vertex c = new Vertex(v.getLevel(), v.getProfit(), v.getBound(), v.getWeight());
                vertexList.add(c);
            }

            v.setWeight(u.getWeight());
            v.setProfit(u.getProfit());

            v.setBound(bound(v, arrayLenght, capacity, array));

            if (v.getBound() > maxProfit) {
                Vertex c = new Vertex(v.getLevel(), v.getProfit(), v.getBound(), v.getWeight());
                vertexList.add(c);
            }

        }
        return maxProfit;
    }

}