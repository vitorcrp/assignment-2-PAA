package Questao2.DivisaoConquista;

import java.util.Random;

class Geracao {
    protected int[] array;
    protected int n;

    public Geracao(int tamanho){
        array = new int[tamanho];
        n = array.length;
    }

    public void crescente() {
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void aleatorio() {
        var rand = new Random();
        crescente();
        for (int i = 0; i < n; i++) {
            swap(i, Math.abs(rand.nextInt()) % n);
        }
    }

    public void mostrar() {
        System.out.print("[");

        for (int i = 0; i < n; i++) {
            System.out.print(" ("+i+")" + array[i]);
        }

        System.out.println("]");
    }

    public void swap(int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(){
        System.out.println("Método a ser implementado nas subclasses.");
    }
}