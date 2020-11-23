import java.util.Scanner;

/**
 * Java. Level 1. Lesson 7. Homework 7 New version_v.2
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

        System.out.println(plate);//Выводим информацию о тарелке
        /*Проходим по массиву котов и просим каждого поесть из тарелки*/
        for (int i = 0; i < cats.length; i++) {
            /*Проверка на отказ пользователся класть еду*/
            if (cats [i].eat(plate) == 2) {
                break;
            }
        }
        System.out.println(plate);//Выводим информацию о тарелке
    }
}

//Создаем интерфейс, в котором указываем методы действий
interface IActions {
    //Метод с помощью котрого животное ест
    int eat (Plate p);
}
//Создаем абстрактный суперкласс животного и применяем интерфейс действий
abstract class GAnimal implements IActions {
    //Задаем основные поля абстрактного суперкласса
    protected String name;
    protected int appetite;
    protected int satiety;


    //Создаем конструктор абстрактного суперкласса
    GAnimal (String name, int appetite, int satiety) {
        this.name = name;//Имя
        this.appetite = appetite;//Аппетит
        this.satiety = satiety;//Сытость
    }
}
//Наследуем класс кота от абстрактного суперкласса животного
class GCat extends GAnimal{
    protected int fullness;

    //Создаем конструктор класса кот
    GCat (String name, int appetite, int satiety) {
        super(name, appetite, satiety);//Вызываем конструктор суперкласса
        /*Счетчик насыщения животного (при полном насыщении животного
        должен быть равен заданному параметру сытости)*/
        this.fullness = 0;
    }

    //Реализуем метод интерфейса с помощью котрого кот ест
    public int eat (Plate p) {
        Scanner scanner = new Scanner(System.in);
        /*Создаем контролирующий цикл, работающий до тех пор, пока коты голодны,
        т.е. коты едят только пока они голодные*/
        while (fullness != satiety) {
            /*Условие для проверки достаточности еды в тарелке. Кот не ест, если в тарелке еды меньше,
            чем его аппетит*/
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);//Вывзов метода уменьшения колчества еды в тарелке
                fullness = fullness + appetite;//Увеличение счетчика насыщения кота
                /*Условие проверки сытости кота и действий при ее достижении*/
                if (fullness == satiety) {
                    System.out.println("Кот " + name + " наелся.\n" +
                            "Сытость кота: " + fullness + " из " + satiety);
                    break;
                }
                /*Проверка на то, что кот все еще голоден и набор дальнейших действий*/
            } else if (p.getFood() < appetite) {
                System.out.println("Недостаточно еды! Кот " + name + " голоден.\n" +
                        "Сытость кота: " + fullness + " из " + satiety +
                        "\nЕда в тарелке: " + p.getFood());
                /*Спрашиваем пользователя, хотим ли мы добавить еду в тарелку*/
                System.out.println("Еды в тарелке недостаточно! Положить котам еще еды: да - 1; нет - 2?");
                /*Если пользователь согласен добавить еду, спашиваем, сколько он хочет добавить*/
                if (scanner.nextInt() == 1) {
                    System.out.println("Сколько еды положить?");
                    /*Вызываем метод добавления еды и в качестве параметра передаем значение,
                    которое ввел пользователь*/
                    p.addFood(scanner.nextInt());
                } else {
                    /*Если пользователь не захотел ничего добавлять, выводим об этом сообщене,
                    закрываем сканнер и выходим из цикла*/
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