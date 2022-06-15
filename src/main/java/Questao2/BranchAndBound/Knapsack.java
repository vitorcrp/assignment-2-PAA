package Questao2.BranchAndBound;

import java.util.ArrayList;
import java.util.List;

class Knapsack {

    static Item[] swap(Item[] arr, int i, int j) {
        var aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
        return arr;
    }

    public static void sort(Item array[], int arrayLenght) {
        quicksort(array,0, arrayLenght-1);
    }

    private static void quicksort(Item array[], int esq, int dir) {
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

    static int bound(Node u, int arrayLenght, int capacity, Item array[]) {

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

    static int knapsack(int capacity, Item arr[], int arrayLenght) {
        sort(arr, arr.length);
        List<Node> Q = new ArrayList<>();
        Node u = new Node(-1, 0, 0);
        Node v = new Node(0, 0, 0, 0);
        Q.add(u);

        int maxProfit = 0;
        while (!Q.isEmpty()) {
            u = Q.get(0);
            Q.remove(0);

            if (u.getLevel() == -1)
                v.setLevel(0);

            if (u.getLevel() == arrayLenght - 1)
                continue;

            v.setLevel(u.getLevel() + 1);

            v.setWeight(u.getWeight() + arr[v.getLevel()].getWeight());
            v.setProfit(u.getProfit() + arr[v.getLevel()].getValue());

            if (v.getWeight() <= capacity && v.getProfit() > maxProfit)
                maxProfit = v.getProfit();

            v.setBound(bound(v, arrayLenght, capacity, arr));

            if (v.getBound() > maxProfit) {
                Node c = new Node(v.getLevel(), v.getProfit(), v.getBound(), v.getWeight());
                Q.add(c);
            }

            v.setWeight(u.getWeight());
            v.setProfit(u.getProfit());

            v.setBound(bound(v, arrayLenght, capacity, arr));

            if (v.getBound() > maxProfit) {
                Node c = new Node(v.getLevel(), v.getProfit(), v.getBound(), v.getWeight());
                Q.add(c);
            }

        }
        return maxProfit;
    }

}