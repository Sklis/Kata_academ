import java.util.Scanner;

public class Input {
  public static void entrance() throws Exception {
    Scanner input = new Scanner((System.in));
    System.out.print("Введите выражение из целых чисел: ");
    String expr = input.nextLine();

    if (!expr.matches("[0-9+\\-*/IiVvXxLlCcDd]+")) {
      System.out.println("Введено недопустимое выражение. Пожалуйста, используйте только арабские цифры, римские цифры и знаки операций (+, -, *, /).");
      question();
    }
    expr = expr.toUpperCase();
    Parsing.process(expr);
  }

  static void question() throws Exception {
    Scanner input = new Scanner((System.in));
    System.out.println("Хотите попробовать еще раз?:");
    System.out.print("Ответтье Y/N: ");
    String expr = input.nextLine();
    expr = expr.toUpperCase();

    if (expr.equals("Y")) {
      entrance();
    } else {
      System.exit(0);
    }
  }
}
