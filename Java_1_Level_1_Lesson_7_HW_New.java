import java.util.Scanner;

/**
 * Java. Level 1. Lesson 6. Homework 5 New version
 * @author Artem Fomin
 * @version dated 06.11.2020
 */

public class Java_1_Level_1_Lesson_7_HW_New {
    public static void main (String [] args) {

        //Создаем массив животных
        GCat [] cats = new GCat[4];
        cats [0] = new GCat("Буся", 5, 20);
        cats [1] = new GCat("Кыся", 5, 50);
        cats [2] = new GCat("Мурзик", 10, 60);
        cats [3] = new GCat("Рыжий", 10, 100);
        Plate plate = new Plate (0);

        System.out.println(plate);
        for (int i = 0; i < cats.length; i++) {
            if (cats [i].eat(plate) == 2) {
                break;
            }
        }
        System.out.println(plate);
    }
}

class GCat {
    //Задаем основные поля суперкласса
    protected String name;
    protected int appetite;
    protected int satiety;
    protected int fullness;

    //Создаем конструктор суперкласса
    GCat (String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
        this.fullness = 0;
    }

    //Создаем метод с помощью котрого кот ест
    public int eat (Plate p) {
        Scanner scanner = new Scanner(System.in);
        while (fullness != satiety) {
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);
                fullness = fullness + appetite;
                if (fullness == satiety) {
                    System.out.println("Кот " + name + " наелся.\n" +
                            "Сытость кота: " + fullness + " из " + satiety);
                    break;
                }
            } else if (p.getFood() < appetite) {
                System.out.println("Недостаточно еды! Кот " + name + " голоден.\n" +
                        "Сытость кота: " + fullness + " из " + satiety +
                        "\nЕда в тарелке: " + p.getFood());
                System.out.println("Еды в тарелке недостаточно! Положить котам еще еды: да - 1; нет - 2?");
                if (scanner.nextInt() == 1) {
                    System.out.println("Сколько еды положить?");
                    p.addFood(scanner.nextInt());
                } else {
                    System.out.println("Вы не захотели класть еду!");
                    scanner.close();
                    return 2;
                    //break;
                }
            }
        }
        return 0;
    }

    //Переопределяем метод toString для вывода инфрмации о классе GCat
    @Override
    public String toString () {
        return "Кличка: " + name + ", аппетит: " + appetite + ", уровень для достижения сытости: " + satiety;
    }
}

class Plate {
    protected int food;
    //Создаем конструктор для тарелки
    Plate (int food) {
        this.food = food;
    }
    //Создаем геттер для поля food тарелки
    public int getFood() {
        return food;
    }
    /*Создаем метод уменьшения еды в тарелке на вход которому передаем значение,
    на которое необходимо уменьшить количество еды*/
    public void decreaseFood (int n) {
        if (food > 0 && food >= n) {
            food = food - n;
        } else if (food == 0) {
            System.out.println("Еда в тарелке закончилась");
        } else if (food < n) {
            System.out.println("Еды в тарелке недостаточно!");
        }
    }
    /*Создаем метод добавления еды в тарелку*/
    public void addFood (int k) {
        food = food + k;
    }
    //Переопределяем медот toString для вывода информации по количеству еды в тарелке
    @Override
    public String toString () {
        return "Количество еды в тарелке: " + food;
    }
}