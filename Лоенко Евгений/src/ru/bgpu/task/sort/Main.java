package ru.bgpu.task.sort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int ARRAY_SIZE = 50000;

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[ARRAY_SIZE];
        int[] checkArray = new int[ARRAY_SIZE];

        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_SIZE - 1) + 1; // рандомизация значений м/ду 1 и 50000
        }                                                        // иначе не хватает памяти ВМ

        System.arraycopy(array, 0, checkArray, 0, ARRAY_SIZE);
        System.out.println("Start user sort");
        long time = System.currentTimeMillis();
        sort(array);
        System.out.format("sorted: %.3f seconds\r\n", (System.currentTimeMillis()-time) / 1000d);
        System.out.println("Start java lib sort");
        time = System.currentTimeMillis();
        Arrays.sort(checkArray);
        System.out.format("sorted: %.3f seconds\r\n", (System.currentTimeMillis()-time) / 1000d);
        System.out.println("Check result");
        for(int i = 0; i < array.length; i++) {
            if(array[i] != checkArray[i]) {
                throw new RuntimeException("Error in index: "+i);
            }
        }
        System.out.println("OK");
    }

    public static void sort(int[] array) {

        // Место для вашего алгоритма сортировки

        int[] bucket = new int[ARRAY_SIZE + 1];
        Arrays.fill(bucket, 0);

        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }

        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                array[k++] = i;
            }
        }

        // Место для вашего алгоритма сортировки

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
    }
}