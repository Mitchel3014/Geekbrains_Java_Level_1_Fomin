import java.util.*;//Импортируем библиотеку util для использования Scanner и Random

public class Java_1_Level_1_Lesson_4_TicTacToe {

    final int SIZE = 3;//Вводим и инициализируем не изменяемую переменную для определения размера игрового поля
    final char DOT_X = 'X';//Вводим и инициализируем не изменяемую переменную для отображения Х
    final char DOT_O = 'O';//Вводим и инициализируем не изменяемую переменную для отображения О
    final char DOT_EMPTY = '.';//Вводим и инициализируем не изменяемую переменную для отображения пустых полей
    char [][]map;//Вводим массив, в котором будет храниться инфорация об игровом поле
    Scanner scanner;//Вводим переменную для сканера
    Random rand;//Вводим переменую для генерации случайных чисел для подстановки в координаты хода AI

    public static void main (String [] args) {
        new Java_1_Level_1_Lesson_4_TicTacToe ().gameCycle ();

    }

    //Создаем конструктор основного класса, где производим инициализацию массива, инициализацию генерации случайных чисел и инициализацию сканера
    Java_1_Level_1_Lesson_4_TicTacToe () {
        map = new char [SIZE][SIZE];//Инициализируем массив
        scanner = new Scanner(System.in);//Инициализируем сканнер
        rand = new Random();//Инициализируем переменную для генерации случайных чисел
    }

    //Создаем метод для инициализации игрового поля
    void initMap (){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map [i][j] = DOT_EMPTY;//Пробегаем по массиву и в каждую ячейку кладем значение переменной DOT_EMPTY
            }
        }
    }

    //Создаем метод для печати игрового поля
    void printMap (){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map [j][i] + " ");//Пробегаем по массиву и печатаем его
            }
            System.out.println();
        }
    }

    //Создаем метод для описания игрового цикла
    void gameCycle (){
        do {
            initMap ();//Вызывваем метод для инициализации игрового массива
            while (true) {
                printMap ();//Вызываем метод для печати игрового массива
                turnHuman ();
                if (checkVictory (DOT_X)) {
                    System.out.println("Вы выиграли!");
                    break;
                }
                if (checkMapFull ()) {
                    System.out.println("Ничья!");
                    break;
                }
                turnAI();
                if (checkVictory (DOT_O)) {
                    System.out.println("Извини, ты проиграл. Победитель ИИ!");
                    break;
                }
                if (checkMapFull ()) {
                    System.out.println("Ничья!");
                    break;
                }
            }
            printMap ();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (scanner.nextInt() == 1);
        //scanner.close();
    }

    //Создаем метод для описания хода игрока
    void turnHuman (){
        int x;//Инициализируем прееменную для присваивания координаты X, введенной пользователем
        int y;//Инициализируем прееменную для присваивания координаты Y, введенной пользователем
        do {
            System.out.println("Введите координаты X и Y через пробел в диапазоне от 1 до 3:");
            x = scanner.nextInt() - 1;//Присваиваем координате X значение, введенное пользователем - 1, т.к. нумерация в системе начинаемтся с 0
            y = scanner.nextInt() - 1;//Присваиваем координате Y значение, введенное пользователем - 1, т.к. нумерация в системе начинаемтся с 0
        } while (!chekCellValid (x, y));//
        map [x][y] = DOT_X;//Подставляем в ячейку значение DOT_X, т.е. крестик
    }

    //Создаем метод для описания хода AI
    void turnAI (){
        int x;//Инициализируем прееменную для присваивания координаты X, сгенерированной методом Random для нашего AI
        int y;//Инициализируем прееменную для присваивания координаты Y, сгенерированной методом Random для нашего AI
        do {
            x = rand.nextInt(SIZE);//Присваиваем коорлинате X значение, сгенерированное методом Random для нашего AI
            y = rand.nextInt(SIZE);//Присваиваем коорлинате Y значение, сгенерированное методом Random для нашего AI
        } while (!chekCellValid (x, y));
        map [x][y] = DOT_O;//Подставляем в ячейку значение DOT_O, т.е. крестик
    }

    //Создаем метод для описания проверки победы
    boolean checkVictory (char dot){
        //Проверка гризонталей
        if (map [0][0] == dot && map [1][0] == dot && map [2][0] == dot) return true;
        if (map [0][1] == dot && map [1][1] == dot && map [2][1] == dot) return true;
        if (map [0][2] == dot && map [1][2] == dot && map [2][2] == dot) return true;

        //Проверка вертикалей
        if (map [0][0] == dot && map [0][1] == dot && map [0][2] == dot) return true;
        if (map [1][0] == dot && map [1][1] == dot && map [1][2] == dot) return true;
        if (map [2][0] == dot && map [2][1] == dot && map [2][2] == dot) return true;

        //Проверка диагоналей
        if (map [0][0] == dot && map [1][1] == dot && map [2][2] == dot) return true;
        if (map [2][0] == dot && map [1][1] == dot && map [0][2] == dot) return true;

        //Пытаюсь написать универсальную проверку победы
        /*
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [i][i] == dot) {
                    return true;
                }
            }
        }
         */

        //Вывод в остальных сулчаях
        return false;
    }

    //Создаем метод для описания проверки заполненности поля
    boolean checkMapFull (){
        /*
        Пробегаем по массиву и, если хотя бы в одной ячейке есть значение переменной DOT_EMPTY,
        мы говорим, что поле не заполнено до конца, в противном случае оно полностью заполнено
         */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //Проверка правильности координат ячейки для заполнения
    boolean chekCellValid (int x, int y) {
        /*
        //Мы указываем координаты в формате от 1 до 3, но система воспринимает от 0 до 2
        для матрицы 3х3. Соответственно, мы в методе хода человека уменьшаем введенные им координаты
        на 1, т.е. при проверке мы смотрим, чтобы у нас не получились координаты -1 (когда человек
        ошибочно введет координаты 0:0) и не получились больше 2 (когда человек ошибочно введет коорлинаты 4:4).
        В обоих случаях мы выйдем за границы массива
        */
        if (x < 0 || y <0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map [x][y] == DOT_EMPTY;//Заполняем массив значениями переменной DOT_EMPTY
    }
}
