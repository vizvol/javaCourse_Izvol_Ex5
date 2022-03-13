package ru.iteco;

import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        String[] strings; // введенная строка
        boolean isName = false;
        boolean isNumber = false;
        String name = "";    // введенное имя
        String numText = ""; // введенное число
        int number  = 0;     // преобразованное число

        while (!isName || !isNumber) {
            System.out.println("Введите имя и число через пробел (Например: \"Максим 1234\"): ");
            Scanner src = new Scanner(System.in);

            // считываем строку с экрана
            String str = src.nextLine();

            if ( str.isEmpty() ) {
                System.out.println("Ошибка! Вы ничего не ввели.");
                continue;
            }
            else {
                // Разбиваем считанную строку на слова разделенные пробелами
                strings = str.split(" ");

                if ( strings.length < 2 ) {
                    System.out.println("Ошибка! Вы не ввели число.");
                    continue;
                }
                if ( strings.length > 2 ) {
                    System.out.println("Ошибка! введена лишняя информация.");
                    continue;
                }
                name = strings[0];
                numText = strings[1];
                isName = true;
                isNumber = true;
            }

            // распознование числа
            if (!isNumber(numText)) {
                System.out.println("Ошибка! Не удалось распознать число.");
                isNumber = false;
                continue;
            }
            number = Integer.parseInt(numText);

            int countDigit = getCountDigit(number);
            if ( countDigit < 2 || countDigit > 5 ) {
                isNumber = false;
                System.out.println("Ошибка! Число должно содержать от 2 до 5 цифр.");
                continue;
            }
        }

        // считаем сумму цифр числа с помощью рекурсии
        int sumDigitNum = calcSumDigitOfNum(number);
        // конвертируем число в название
        String numInText = ( convertNumInText(sumDigitNum).equals("error") ) ? sumDigitNum + " (больше десяти)" : convertNumInText(sumDigitNum) ;
        //приветствие
        greetings(name, numInText);
    }
    // метод приветствия
    private static void greetings(String name, String numInText) {
        System.out.println("Здравствуй, " + name + "! Сумма цифр в числе = " + numInText);

    }

    // метод определения разряда числа
    public static int getCountDigit (int number){
        int count = 0;
        while (number > 0)
        {
            number /= 10;
            count++; // count = count + 1;
        }
        return count;
    }

    // метод распознавания числа из строки
    public static boolean isNumber (String number){
        for (char num : number.toCharArray() ) {
            if (!Character.isDigit(num)) {
                return false;
            }
        }
        return true;
    }

    // метод подсчета цифр числа
    private static int calcSumDigitOfNum (int number){
        return number == 0 ? 0 : number % 10 + calcSumDigitOfNum(number/10);
    }

    // метод конвертации числа в его тектовое название
    private static String convertNumInText (int number){
        String numInText;
        switch (number) {
            case 1:
                numInText = "один";
                break;
            case 2:
                numInText = "два";
                break;
            case 3:
                numInText = "три";
                break;
            case 4:
                numInText = "четыре";
                break;
            case 5:
                numInText = "пять";
                break;
            case 6:
                numInText = "шесть";
                break;
            case 7:
                numInText = "семь";
                break;
            case 8:
                numInText = "восемь";
                break;
            case 9:
                numInText = "девять";
                break;
            case 10:
                numInText = "десять";
                break;
            default: numInText = "error";
        }
        return numInText;
    }

}
