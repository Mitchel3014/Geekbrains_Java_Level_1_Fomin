import java.util.Arrays;//Импортируем библиотеку util для использования метода toString, чтобы красиво выводить массив

/**
 * Java. Level 1. Lesson 2. Homework 2 New version
 * @author Artem Fomin
 * @version dated 22.10.2020
 */

public class Java_1_Level_1_Lesson_2_HW_New {
    public static void main (String [] args) {

        int [] array_1;
        int [] array_2;
        int [] array_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int [] array_4 = {0, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 50};

        System.out.println("Пункт задания №1 часть 1. Создание массива");
        array_1 = firstArray (10, 2);
        System.out.println(Arrays.toString(array_1)+ "\n");

        System.out.println("Пункт задания №1 часть 2. Замена элементов массива с 0 на 1 и с 1 на 0");
        changeArray (array_1);
        System.out.println(Arrays.toString(array_1)+ "\n");

        System.out.println("Пункт задания №2. Создаем массив размера 8 и заполняем его значениями 0 3 6 9 12 15 18 21");
        array_2 = fillArray (8);
        System.out.println(Arrays.toString(array_2)+ "\n");

        System.out.println("Пункт задания №3. Проход по массиву и увеличение чисел менее 6 на 2");
        System.out.println("Массив до приращения:" + "\n" + Arrays.toString(array_3));//Массив до приращения
        increasingArray (array_3);//Приращение
        System.out.println("Массив после приращения:" + "\n" + Arrays.toString(array_3)+ "\n");//Массив после приращения

        System.out.println("Пункт задания №4. Заполнение диагоналей");
        fillDiagonal(8);

        System.out.println("\n" + "Пункт задания №5. Находим в массиве минимальный и максимальный элементы");
        find_min_max (array_4);

    }

    //Пункт задания №1 часть 1 - создание массива
    public static int[] firstArray (int size, int range) {
        int [] arr_1 = new int [size];//Создание и инициализация массива размерности size
        for (int i = 0; i < arr_1.length; i++) {
            arr_1[i] = (int) (Math.random() * range);//Генерируем значения для массива и присваиваем их в ячейки
        }
        return arr_1;
    }

    //Пункт задания №1 часть 2 - замена элементов массива с 0 на 1 и с 1 на 0
    public static void changeArray(int [] arr_2) {
        for (int i = 0; i < arr_2.length; i++) {
            if (arr_2[i] == 1) {
                arr_2[i] = 0;
            } else {
                arr_2[i] = 1;
            }
        }
    }

    //Пункт задания №2 - создаем массив размера 8 и заполняем его значениями 0 3 6 9 12 15 18 21
    public static int[] fillArray (int size) {
        int [] arr_3 = new int [size];
        for (int i = 0; i < arr_3.length; i++) {
            arr_3[i] = i*3;
        }
        return arr_3;
    }

    //Пункт задания №3 - проход по массиву и увеличение чисел менее 6 на 2
    public static void increasingArray (int [] arr_3) {
        for (int i = 0; i < arr_3.length; i++) {
            if (arr_3[i] < 6) {
                arr_3[i] = arr_3[i]*2;
            }
        }
    }

    //Пункт задания №4 - заполняем диагональные элементы двумерного массива
    public static void fillDiagonal (int size) {
        int [][] arr_4 = new int [size][size];//Создание и инициализация двумерного массива размерности size
        for (int i = 0; i<arr_4.length; i++) {
            arr_4[i][i] = 2;//Присваиваем каждому i-му и j-му элементу, позиция которого равна возиции i-го элемента, значение 2
            arr_4[i][arr_4.length-i-1] = 1;//Присваивание каждому i-му и j-му элементу, позиция которого рассчитывается как длинна массива минус текущая позиция элемента по координатам i минус 1, т.к. нумерация начинается с 0, значения 1
            for (int j = 0; j<arr_4.length; j++) {
                //arr_4[j][j] = 2;//Присваиваем каждому i-му и j-му элементу, позиция которого равна возиции j-го элемента, значение 2
                //arr_4[arr_4.length-j-1][j] = 1;
                System.out.print(arr_4[i] [j] + " ");
            }
            System.out.println();
        }
    }

    //Пункт задания №5 - Находим в массиве минимальный и максимальный элементы
    public static void find_min_max (int [] arr_3) {
        int max = arr_3[0];//Задаем начальный максимум в виде первого элемента массива
        int min = arr_3[0];//Задаем начальный минимум в виде первого элемента массива
        int k;//Задаем переменную для присваивания значений элементов массива
        System.out.println("Выводим массив:" + "\n" + Arrays.toString(arr_3));//Выводим массив

        for (int i = 0; i < arr_3.length; i++) {
            k = arr_3[i];//Присваиваем переменной k значение i-го элемента массива
            if (k > max) {//Сравниваем значение переменной k с текущим максимальным max
                max = k;//Если значение прееменной k больше текущего максимума, присваиваем переменной max новое значение
            }
        }
        System.out.println("Максимум: " +max);//Выводим максимум

        for (int i = 0; i < arr_3.length; i++) {
            k = arr_3[i];
            if (k < min) {
                min = k;
            }
        }
        System.out.println("Минимум: " +min);
    }
}
