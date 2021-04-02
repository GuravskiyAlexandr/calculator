import java.util.Scanner;

public class Main extends RomanLetter {

    public static void main(String[] args) throws Exception {
        boolean run = true;
        InitialInputCheck inputCheck = new InitialInputCheck();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. \n" +
                "Данные передаются в одну строку (смотрите пример)!\n " +
                "Input:\n" +
                "1 + 2\n" +
                "Output:\n" +
                "3\n" +
                "Input:\n" +
                "VI / III\n" +
                "Output:\n" +
                "II \n" +
                "Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.\n" +
                "Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.\n" +
                "Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.\n" +
                "Калькулятор умеет работать только с целыми числами.\n" +
                "Калькулятор умеет работать только с арабскими или римскими цифрами одновременно");
        System.out.println("Если хотите Выйти из программы введите  восклицательный знак \"!\" и нажмите Enter");

        while (run) {
            String scannerLetter = scanner.nextLine();
            if (scannerLetter.equals("!")) {
                run = false;
                System.out.println("THE END BYE-BYE");
            } else {
                inputCheck.InputCheck(scannerLetter);
            }
        }
        scanner.close();
    }


}
