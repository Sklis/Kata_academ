import java.util.Scanner;

public class Input {
  public static void entrance() throws Exception {
    Scanner input = new Scanner((System.in));
    System.out.print("Введите выражение из целых чисел от 1 до 10: ");
    String expr = input.nextLine();

    if (!expr.matches("[0-9+\\-*/IiVvXxLlCcDd]+")) {
      throw new Exception("Используйте только арабские цифры, римские цифры и знаки операций (+, -, *, /).");
    }

    expr = expr.toUpperCase();
    Parsing.process(expr);
  }
}
