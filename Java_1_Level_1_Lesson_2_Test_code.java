import java.util.ArrayList;
import java.util.Arrays;//Импортируем библиотеку util для использования метода toString, чтобы красиво выводить массив

/**
 * Java. Level 1. Lesson 2. Test_code
 * @author Artem Fomin
 * @version dated 22.10.2020
 */

public class Java_1_Level_1_Lesson_2_Test_code {
    public static void main (String [] args) {

        //Тестировал код урока со своими нововведениями
        int size = 10;//Переменная для указания размера массива
        int range = 500;//Переменная для диапазона генерации значений массива

        //Применяем стандартный массив
        int [] arr = new int [size];//Создание и инициализация массива
        for (int i = 0; i < arr.length; i++) {
            arr [i] = (int) (Math.random() * range);//Генерируем значения для массива и присваиваем их в ячейки
            //System.out.println(arr [i]);//Выводим каждую ячейку массива
        }
        System.out.println(Arrays.toString(arr));//Красиво выводим весь массив

        //Применяем списочный гибкий массив ArrayList
        ArrayList<Integer> list = new ArrayList<>();//Создание и инициализация массива ArrayList
        for (int i = 0; i < size; i++) {//Ограничиваем размер области присваивания данных гобкого массива с помощью переменной size, но не жестко, т.к. массив гибкий и не имеет конечного размера
            list.add((int) (Math.random() * range));//Генерируем значения для массива и присваиваем их в ячейки
        }
        System.out.println(list.size());//Выводим размер текущего гибкого массива
        System.out.println(list);//Выводим значения гибкого массива
    }
}
