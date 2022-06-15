package Questao2.DivisaoConquista;

import java.util.Date;
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
        Random rand = new Random();
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
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public long now(){
        return new Date().getTime();
    }

    public void sort(){
        System.out.println("Método a ser implementado nas subclasses.");
    }
}