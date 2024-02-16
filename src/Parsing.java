import java.util.Objects;

public class Parsing {
  private static int num1;
  private static int num2;
  private static int flag = 0; //Флаг указывает какие конкретно. 0 арабские. 1 римские.
  private static String operator;

  public static void process(String input) throws Exception {
    // делим входную строку на числа
    String[] num = input.split("[+\\-/*]");
    for (int i = 0; i < num.length; i++) {
      num[i] = num[i].trim();
    }

    //Проверяем, что у нас всего два операнда
    if (num.length != 2) {
      throw new Exception("Должно быть два операнда.");
    }

    operator = detectOperation(input);

    // Проверяем какие это числа (арабские или  римские)
    try {
      num1 = Integer.parseInt(num[0]);
      num2 = Integer.parseInt(num[1]);
      variationNumbers();
    } catch (NumberFormatException e) {
      flag = 1;
      variationExpression(num);
      num1 = RomanNumeral.romanToArabic(num[0]);
      num2 = RomanNumeral.romanToArabic(num[1]);
      variationNumbers();
    }

    CalcAndOutput.calculator(num1, num2, operator, flag);
  }

  private static String detectOperation(String input) {
    if (input.contains("+")) return "+";
    if (input.contains("-")) return "-";
    if (input.contains("*")) return "*";
    if (input.contains("/")) return "/";
    return null;
  }

  private static void variationExpression(String[] num) throws Exception {
    boolean b = num[0].matches("[0-9]") && num[1].matches("[IVXLCD]");
    boolean a = num[0].matches("[IVXLCD]") && num[1].matches("[0-9]");

    if (a || b) throw new Exception("Не допустимое выражение.");
  }

  private static void variationNumbers() throws Exception {
    if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
      throw new Exception("Числа только от 1 до 10.");
    }

    if (flag == 1 && ((num1 < num2) && Objects.equals(operator, "-"))) {
      throw new Exception("В римской системе нет отрицательных чисел.");
    }
  }
}
