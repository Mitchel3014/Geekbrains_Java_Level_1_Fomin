/**
* Артем Фомин, домашнее задание №1, дата: 30.05.2019
 */

public class FirstHomework {

    public static void main (String[] args) {
        //Пункт 2
        int a = 10;
        int b = 5;
        int c = 40;
        int d = 10;
        byte f = 127;
        short g = -32765;
        int h = 500;
        long i = 200000L;
        float j = 25.15f;
        double k = 225.125;
        char l = '*';
        boolean m = true;
        System.out.println ("Создал и проинициализировал переменные всех типов данных: " +f+ "; " +g+ "; " +h+ "; " +i+ "; " +j+ "; " +k+ "; " +l+ "; " +m);
        System.out.println ("Результат выражения из пункта 3: " + count(a,b,c,d));
        System.out.println ("Результат выражения из пункта 4: " + check(a, b));
        plusOrMinus (a);
        System.out.println ("Результат выражения из пункта 6: " + negative(a));
        text ("Сергей");
    }

    //Пункт 3
    static int count (int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //Пункт 4
    static boolean check (int a, int b) {
          if (a+b<=20 && a+b>10){
            return true;
        } else {
            return false;
        }
    }
    //Пункт 5
    static void plusOrMinus (int a) {
        if (a>=0){
            System.out.println ("Результат выражения из пункта 5: Положительное");
        } else {
            System.out.println ("Результат выражения из пункта 5: Отрицательное");
        }
    }
    //Пункт 6
    static boolean negative (int a) {
        if (a<0) {
            return true;
        } else {
            return false;
        }
    }
    //Пункт 7
    static void text (String name) {
        System.out.println ("Привет, " +name+ "!");
    }
}
