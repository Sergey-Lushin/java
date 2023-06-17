// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
// Пункты реализовать в методе main

import java.util.Random;

public class Lesson1 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(2000);
        System.out.println("Случайное число =  " + i);

        int n = Integer.toBinaryString(i).length()-1;
        System.out.println("Номер старшего значения бита =  "+n);
       
              
        short count = 0;
        for (int j = i; j < Short.MAX_VALUE; j++){
            if ( j % n == 0) {
                count++;
            }
        }
        System.out.println("Количество элементов кратных n =  "+ count); 
        int[] m1 = new int [count];
        count = 0;
               
        for (int j = i; j < Short.MAX_VALUE; j++){
            if (j % n == 0) {
                m1[count++] = j;
                }
        } 

        count = 0;
        
        for (int j = Short.MIN_VALUE; j < i; j++){
            if ( j % n != 0) {
                count++;
            }
        }
        System.out.println("Количество элементов не кратных n =  "+ count); 
        int[] m2 = new int [count];
        count = 0;
                
        for (int j = Short.MIN_VALUE; j < i; j++){
            if (j % n != 0) {
                m2[count++] = j;
                }
        }
        
        }
}