import java.util.Arrays;

/**
 * Java. Level 1. Lesson 5. Homework 5
 * @author Artem Fomin
 * @version dated 14.06.2019
 */

public class FifthHomework {
    public static void main(String[] args) {

        Worker [] workerArray = new Worker [6];
        workerArray [0] = new Worker("Андрей", "программист", "andrey@mail.ru", 89163456728L, 110000, 47);
        workerArray [1] = new Worker("Виктор", "менеджер", "viktor@mail.ru", 89256773428L, 50000, 50);
        workerArray [2] = new Worker("Сергей", "аналитик", "sergey@mail.ru", 89036478893L, 60000, 35);
        workerArray [3] = new Worker("Николай", "директор", "nikolay@mail.ru", 89051225990L, 150000, 46);
        workerArray [4] = new Worker("Геннадий", "повар", "gennady@mail.ru", 89567778999L, 30000, 25);
        workerArray [5] = new Worker("Дмитрий", "программист", "dmitriy@mail.ru", 89154432681L, 120000, 48);
// worker1.setAge(0);
// Worker worker2 = new Worker("Виктор", "менеджер", "viktor@mail.ru", 89256773428L, 50000, 50);
// Worker worker3 = new Worker("Сергей", "аналитик", "sergey@mail.ru", 89036478893L, 60000, 35);
// Worker worker4 = new Worker("Николай", "директор", "nikolay@mail.ru", 89051225990L, 150000, 46);
// Worker worker5 = new Worker("Геннадий", "повар", "gennady@mail.ru", 89567778999L, 30000, 25);
// worker1.info();
// worker2.info();
// worker3.info();
// worker4.info();
// worker5.info();
// System.out.println ("Имя: " +worker1.getName(), "должность: " +worker1.getPosition(), "e-mail: " +worker1.getEmail(), "телефон: " +worker1.getPhone(), "зарплата: " +worker1.getSalary(), "возраст: " +worker1.getAge());

/**
 * Сначала написал через стандартный вывод с помощью геттеров:
 */
//for (int i = 0; i<workerArray.length; i++){
//if (workerArray[i].getAge() >= 40){
//System.out.println("Имя: " +workerArray[i].getName()+ ", должность: " +workerArray[i].getPosition()+ ", возраст: " +workerArray[i].getAge());
// }
// }
// System.out.println (workerArray[1].getName());


/**
 * Здесь написал вывод с использованием переопределения toString:
 */
        for (int i = 0; i<workerArray.length; i++){
            if (workerArray[i].getAge() >= 40){
                System.out.println (workerArray[i]);
                   }
        }
    }
}

class Worker {
    private String name;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    Worker (String name, String position, String email, long phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    String getName (){
        return name;
    }

    String getPosition (){
        return position;
    }

    String getEmail (){
        return email;
    }

    long getPhone (){
        return phone;
    }

    int getSalary (){
        return salary;
    }

    int getAge (){
        return age;
    }

    void setName (String name){
        if (name != null) {
            this.name = name;
        }
    }

    void setPosition (String position){
        if (position != null) {
            this.position = position;
        }
    }

    void setEmail (String email){
        if (email != null) {
            this.email = email;
        }
    }

    void setPhone (long phone){
        if (phone > 0) {
            this.phone = phone;
        }
    }

    void setSalary (int salary){
        if (salary > 0) {
            this.salary = salary;
        }
    }

    void setAge (int age){
        if (age > 0) {
            this.age = age;
        }
    }

    public void info () {
        System.out.println ("Имя: "+name+ "; должность: "+position+ "; e-mail: "+email+ "; телефон: "+phone+ "; зарплата: "+salary+ "; возраст: "+age);
    }

    @Override
    public String toString(){
        return "Имя: " + name + ", должность: " + position + ", e-mail: " + email + ", телефон: " + phone + ", зарплата: " + salary + ", возраст: " + age;
    }

}