public class Java_1_Level_1_Lesson_5_HW_New {
    public static void main (String [] args) {
        Worker [] workers = new Worker [6];
        workers [0] = new Worker("Кукушкин", "Виссарион", "Германович", "водитель","vissa@mail.ru", 89165548798L, 50000, 30);
        workers [1] = new Worker("Евдокимов", "Александр", "Олегович", "программист","alex@mail.ru", 89165678321L, 45000, 50);
        workers [2] = new Worker("Багратионов", "Кирилл", "Дмитриевич", "инженер","kira@mail.ru", 89163468893L, 63000, 43);
        workers [3] = new Worker("Елабугин", "Дмитрий", "Петрович", "программист","dim@mail.ru", 89169786457L, 31000, 30);
        workers [4] = new Worker("Ольшанский", "Сергей", "Викторович", "разработчик","serg@mail.ru", 89164532281L, 25000, 41);
        workers [5] = new Worker("Бредин", "Виктор", "Петрович", "директор","vikt@mail.ru", 89167893289L, 100000, 44);

        //Выводим информацию только по тем сотрудникам, возраст которых больше или равен 40
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getAge() >= 40) {
                System.out.println(workers[i]);
            }
        }
    }
}

class Worker {
    //Задаем основные поля класса
    private String lastName;
    private String name;
    private String surname;
    private String position;
    private String email;
    private long phoneNumber;
    private long salary;
    private int age;

    //Создаем конструктор класса
    Worker (String surname, String name, String lastName, String position, String email, long phoneNumber, long salary, int age) {
        this.lastName = lastName;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /*
    //Создаем метод, выводящий информацию о сотруднике
    public void workerInfo () {
        System.out.println( "Фамилия: " + surname + " Имя: " + name + " Отчество: " + lastName + ", возраст: " + age + ", должность: " + position + ", e-mail: " + email + ", номер телефона: " + phoneNumber + ", зарплата: " + salary);
    }
     */

    //Переопределяем метод toString для вывода инфрмации о сотруднике
    @Override
    public String toString () {
        return "Фамилия: " + surname + " Имя: " + name + " Отчество: " + lastName + ", возраст: " + age + ", должность: " + position + ", e-mail: " + email + ", номер телефона: " + phoneNumber + ", зарплата: " + salary;
    }

    //Геттеры для доступа к полям класса Worker
    String getLastName () {
        return lastName;
    }

    String getName () {
        return name;
    }

    String getSurname () {
        return surname;
    }

    String getPosition () {
        return position;
    }

    String getEmail () {
        return email;
    }

    long getPhoneNumber () {
        return phoneNumber;
    }
    long getSalary () {
        return salary;
    }

    int getAge () {
        return age;
    }

    //Сеттеры для изменения полей класса Worker
    void setLastName (String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    void setName (String name) {
        if (name != null) {
            this.name = name;
        }
    }

    void setSurname (String surname) {
        if (surname != null) {
            this.surname = surname;
        }
    }

    void setPosition (String position) {
        if (position != null) {
            this.position = position;
        }
    }

    void setEmail (String email) {
        if (email != null) {
            this.email = email;
        }
    }

    void setPhoneNumber (long phoneNumber) {
        if (phoneNumber > 0) {
            this.phoneNumber = phoneNumber;
        }
    }
    void setSalary (long salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    void setAge (int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        }
    }
}
