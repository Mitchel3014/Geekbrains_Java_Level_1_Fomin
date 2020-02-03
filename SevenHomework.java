import java.util.Scanner;

public class SevenHomework {

    public static void main (String [] args) {
        Cat cat = new Cat("Barsik", 10);
        Cat cat2 = new Cat("Murzik", 20);
        Cat cat3 = new Cat("Murzik", 30);
        Cat cat4 = new Cat("Duzik", 30);
        Plate plate = new Plate(30);
        System.out.println(cat);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(plate);

            cat.eat(plate);
            System.out.println(cat.satisfying);
            cat2.eat(plate);
            System.out.println(cat2.satisfying);
            cat3.eat(plate);
            System.out.println(cat3.satisfying);
            cat4.eat(plate);
            System.out.println(cat4.satisfying);

        System.out.println(cat);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(plate);
    }
}

class Cat {
    private static Scanner scanner = new Scanner(System.in);
    public String name;
    public int appetite;
    public boolean satisfying;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= appetite && !satisfying) {
                plate.dicreaseFood(appetite);
                satisfying = true;
        }
        else {
            do {
                System.out.println("Недостаточно еды! Положить котам еще еды: да - 1; нет - 2?");
                if (scanner.nextInt() == 1) {
                    System.out.println("Сколько еды положить?");
                    plate.addFood(scanner.nextInt());
                }
            } while (plate.getFood() < appetite);
            plate.dicreaseFood(appetite);
            satisfying = true;

            //System.out.println("Недостаточно еды! Положить котам еще еды: да - 1; нет - 2?");
            //if (scanner.nextInt() == 1) {
            //    System.out.println("Сколько еды положить?");
            //   do {
            //       plate.addFood(scanner.nextInt());
            //   } while (plate.getFood() < appetite);
            //    plate.dicreaseFood(appetite);
            //    satisfying = true;
           // }
        }
    }
    @Override
    public String toString() {
        return "Name: " + name + "; Appetite: " + appetite + "; Satisfying: " + satisfying;
    }
}

class Plate {
    public int food;

    Plate(int food) {

        this.food = food;
    }

    int getFood() {

        return food;
    }
    void dicreaseFood(int food) {

        this.food -= food;
    }

    void addFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}