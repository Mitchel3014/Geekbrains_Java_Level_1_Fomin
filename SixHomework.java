import java.util.Random;

/**
 * Java. Level 1. Lesson 6. Homework 6
 * @author Artem Fomin
 * @version dated 17.06.2019
 */

public class SixHomework {
    public static void main (String [] args) {
    Cat cat1 = new Cat ("Бегемот", "черный", 7);
    Cat cat2 = new Cat ("Абармот", "белый", 3);
    Dog dog1 = new Dog ("Барбоскин", "коричневый", 6);
    Dog dog2 = new Dog ("Пёсель", "бежевый", 5);

        System.out.println(cat1);
        System.out.println(cat1.voice());
        System.out.println("Run: " +cat1.run(10)+ ", Swimming: " +cat1.swimming(0)+ ", Jump: " +cat1.jump(0.5));

        System.out.println(cat2);
        System.out.println(cat2.voice());
        System.out.println("Run: " +cat2.run(100)+ ", Swimming: " +cat2.swimming(5)+ ", Jump: " +cat2.jump(1));

        System.out.println(dog1);
        System.out.println(dog1.voice());
        System.out.println("Run: " +dog1.run(200)+ ", Swimming: " +dog1.swimming(2)+ ", Jump: " +dog1.jump(0.5));

        System.out.println(dog2);
        System.out.println(dog2.voice());
        System.out.println("Run: " +dog2.run(50)+ ", Swimming: " +dog2.swimming(5)+ ", Jump: " +dog2.jump(0.2));
    }
}

class Cat extends Animal {
    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public String voice() {
        return "Кот говорит мяу!";
    }

    public boolean run(int distance) {
        Random random = new Random();
        int x = random.nextInt(200);
        return distance < x;
    }

    public boolean swimming(int swim) {
        return swim == 0;
    }

    public boolean jump(double high) {
        double y = Math.random()*2;
        return high < y;
    }
}

class Dog extends Animal {
    public Dog(String name, String color, int age) {
        super(name, color, age);
    }
    public String voice() {
        return "Пес говорит гав!";
    }

    public boolean run(int distance) {
        Random random = new Random();
        int z = random.nextInt(500);
        return distance < z;
    }

    public boolean swimming(int swim) {
        Random random = new Random();
        int k = random.nextInt(10);
        return swim < k;
    }

    public boolean jump(double high) {
        double w = Math.random()*0.5;
        return high < w;
    }
}

class Animal {
    protected String name;
    protected String color;
    protected int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Кличка: " +name + ", окрас: " + color + ", возраст: " + age;
    }
}
