/**
 * Java. Level 1. Lesson 6. Homework 5 New version
 * @author Artem Fomin
 * @version dated 06.11.2020
 */

public class Java_1_Level_1_Lesson_6_HW_New {
    public static void main (String [] args) {
        //Создаем массив животных
        Animal [] animals = new Animal[6];
        animals [0] = new Dog("Бобик", "серый", 6, 200, 100, 50);
        animals [1] = new Dog("Шарик", "черный", 5, 200, 150, 80);
        animals [2] = new Cat("Буся", "белая", 4, 100, 0, 200);
        animals [3] = new Cat("Кыся", "рыжая", 7, 150, 0, 150);
        animals [4] = new Dog("Барбос", "белый", 3, 200, 50, 150);
        animals [5] = new Cat("Кыся", "рыжая", 7, 200, 100);

        //Вводим переменные для дистанций действий животных
        int runDistance = 200;
        int swimDistance = 200;
        int jumpDistance = 200;

        //Вводим и инициализируем переменные для подсчета количества созданных классов определенного типа
        int count1 = 0;
        int count2 = 0;

        //Проходим по массиву живтоных
        for (int i = 0; i < animals.length; i++) {
            //Вводим переменную, куда записываем имя класса каждого объекта массива
            String className = animals[i].getClass().getName();
            //Сравниваем имя класса каждого объекта массива с определенным названием
            if (className.equals("Dog")) {
                count1 ++;//Если совпало, то увеличиваем счетчик
            } else if (className.equals("Cat")) {
                count2 ++;//Если совпало, то увеличиваем счетчик
            }

            /*
            Выводим информацию о названии класса объекта, краткую информацию об объекте
            через переопределенный в родительском классе Animal метод toString,
            а также вызываем методы действий для каждого объекта массива и
            выводим резальтат их выполнения
             */
            System.out.println("Класс: " + animals[i].getClass().getName() +
                    ". " + animals[i] +
                    "\nПробежка (" + runDistance + "м): " + animals[i].run(runDistance) +
                    "\nПлаванье (" + swimDistance + "м): " + animals[i].swim(swimDistance) +
                    "\nПражок (" + jumpDistance + "м): " + animals[i].jump(jumpDistance) +
                    "\n");
        }
        System.out.println("Собак: " + count1);//Выводим количество классов определенного типа (здесь "Dog")
        System.out.println("Кошек: " + count2);//Выводим количество классов определенного типа (здесь "Cat")
    }
}

//Создаем интерфейс движений животных IMove
interface IMove {
    boolean run (int distance);
    boolean swim (int distance);
    boolean jump (int distance);
}

//Создаем абстрактный класс Животное, котрое реализует интерфейс движений IMove
abstract class Animal implements IMove {
    //Задаем основные поля суперкласса
    protected String name;
    protected String color;
    protected int age;
    protected int runLimit;
    protected int swimLimit;
    protected int jumpLimit;

    //Создаем конструктор суперкласса
    Animal (String name, String color, int age, int runLimit, int swimLimit, int jumpLimit) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    //Реализуем методы интерфейса движений IMove
    public boolean run (int distance) {
        return distance <= runLimit;
    }

    public boolean swim (int distance) {
        return distance <= swimLimit;
    }

    public boolean jump (int distance) {
        return distance <= jumpLimit;
    }

    //Переопределяем метод toString для вывода инфрмации о суперклассе
    @Override
    public String toString () {
        return "Кличка: " +name + ", окрас: " + color + ", возраст: " + age;
    }
}

//Создаем классы-наследники от Animal
class Cat extends Animal {

    //Создаем конструктор класса Cat
    Cat (String name, String color, int age, int runLimit, int swimLimit, int jumpLimit) {
        super(name, color, age, runLimit,swimLimit, jumpLimit);
    }

    /*
    Перегружаем конструктор класса Cat, для создания варианта, где лимит плавания
    зашит автоматически и равен 0, т.к. по условию задачи кот не плавает
     */
    Cat (String name, String color, int age, int runLimit, int jumpLimit) {
        super(name, color, age, runLimit,-1, jumpLimit);
    }

    //Переопределяем метод плавания, т.к. коты не плавают (по условиям задания)
    @Override
    public boolean swim (int distance) {
        return false;
    }

    /*
    Создаем метод вывода полной информации о классе, дополнтельно к краткому переопределенному
    методу toString в суперклассе
     */
    public String catFullInfo () {
        return "Кличка: " + name + ", окрас: " + color + ", возраст: " + age + ", лимит бега: " + runLimit + ", лимит плавания: " + swimLimit + ", лимит прыжка: " + jumpLimit;
    }
}

class Dog extends Animal {

    //Создаем конструктор класса Dog
    Dog (String name, String color, int age, int runLimit, int swimLimit, int jumpLimit) {
        super(name, color, age, runLimit,swimLimit, jumpLimit);
    }

    /*
    Создаем метод вывода полной информации о классе, дополнтельно к краткому переопределенному
    методу toString в суперклассе
     */
    public String dogFullInfo () {
        return "Кличка: " + name + ", окрас: " + color + ", возраст: " + age + ", лимит бега: " + runLimit + ", лимит плавания: " + swimLimit + ", лимит прыжка: " + jumpLimit;
    }
}