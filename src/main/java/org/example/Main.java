package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {

        input = input.trim();
        String[] arrSymbols;
        char operator;

        if (input.contains(" + ")) {
            arrSymbols = input.split(" \\+ ");
            operator = '+';
        } else if (input.contains(" - ")) {
            arrSymbols = input.split(" - ");
            operator = '-';
        } else if (input.contains(" * ")) {
            arrSymbols = input.split(" \\* ");
            operator = '*';
        } else if (input.contains(" / ")) {
            arrSymbols = input.split(" / ");
            operator = '/';
        } else {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
       if (arrSymbols.length != 2) {
            throw new Exception("Некорректный формат ввода. Должны быть два числа и одна операция.");
        }
        int a, b;
        try {
            a = Integer.parseInt(arrSymbols[0].trim());
            b = Integer.parseInt(arrSymbols[1].trim());
        } catch (NumberFormatException e) {
            throw new Exception("Некорректный ввод чисел. Должны быть целые числа.");
        }
       if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Вне диапазона");
        }
        int result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new Exception("Деление на ноль.");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Операция невозможна.");
        }
       return String.valueOf(result);
    }
}
