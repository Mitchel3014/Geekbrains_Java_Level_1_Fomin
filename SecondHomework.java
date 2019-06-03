import java.util.Arrays;

/**
 * Java. Level 1. Lesson 2. Homework 2
 * @author Artem Fomin
 * @version dated 04.06.2019
 */

public class SecondHomework {
    public static void main(String[] args) {
        firstArray ();
        fillArray ();
        changeArray ();
        fillDiagonal();
        //Думал через рандом сделать пункт 1, получилось, но для ДЗ рещил оставить вариант попроще.
        //int array[] = new int[10];
        //for (int i = 0; i < 10; i++) {
            //array[i] = 0 + (int) (Math.random() * 2);
               // System.out.println("arr[" + i + "] = " + array [i]);
        }

    //Пункт 1
    public static void firstArray() {
        int [] array = {1,1,1,0,0,1,0,0,1,0};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //Пункт 2
    public static void fillArray() {
        int [] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i*3;
        }
        System.out.println(Arrays.toString(array2));
    }

    //Пункт 3
    private static void changeArray() {
        int [] array3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        //for(int i = 0; i < array3.length; i++) {
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i]*2;
            }
        }
        System.out.println(Arrays.toString(array3));
    }

    //Пункт 4
        public static void fillDiagonal() {
        int [] [] doubleArray = new int [4] [4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                doubleArray [i] [j] = 1;
            System.out.print(doubleArray[i] [j] + " ");
            }
            System.out.println();
        }
    }
}


