import java.util.Random;
import java.util.Scanner;

/**
 * Java. Level 1. Lesson 3. Homework 3
 * @author Artem Fomin
 * @version dated 07.06.2019
 */

public class ThirdHomework {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Поиграем в игру 'Угадай число'");
    do {
        System.out.println("Ваша задача угадать число.");
        System.out.println("У Вас три попытки!");
        //for (int i = 10; i < 50; i+=10) {
            guess(9);
        //}
        //if (guess(9) == false) {
        //    System.out.println("Вы проиграли!");
        //} else {
        //    System.out.println("Вы выиграли!");
        //}
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
    } while (scanner.nextInt() == 1);
    scanner.close ();
    }

    public static void guess(int range) {
        Random random = new Random();
        int x = random.nextInt(range);
        int k;
        for (int i = 0; i < 3; i++) {
            //System.out.println("Угадайте число от 0 до " + range);
            System.out.println("Введите число");
            k = scanner.nextInt();
            if (k==x) {
                System.out.println("Вы угадали.");
                break;
            } else if (k<x) {
                System.out.println("Загаданное число больше.");
            } else if (k>x) {
                System.out.println("Загаданное число меньше.");
            }
        }
    }
}