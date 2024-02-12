import java.util.Objects;

public class Parsing {
  public static void process(String input) throws Exception {
    // делим входную строку на числа
    String[] num = input.split("[+\\-/*]");
    for (int i = 0; i < num.length; i++) {
      num[i] = num[i].trim();
    }

    //Проверяем, что у нас всего два операнда
    if (num.length != 2) throw new Exception("Должно быть два операнда.");

    String operator;
    operator = detectOperation(input);

    // Проверяем какие это числа (арабские или  римские)
    int num1, num2, flag = 0; //Флаг указывает какие конкретно. 0 арабские. 1 римские.
    try {
      num1 = Integer.parseInt(num[0]);
      num2 = Integer.parseInt(num[1]);
    } catch (NumberFormatException e) {
      if (num[0].matches("[IVXLCD]") && num[1].matches("[0-9]")) {
        throw new Exception("Не допустимое выражение.");
      } else if (num[0].matches("[0-9]") && num[1].matches("[IVXLCD]")) {
        throw new Exception("Не допустимое выражение.");
      } else {
        num1 = RomanNumeral.romanToArabic(num[0]);
        num2 = RomanNumeral.romanToArabic(num[1]);
        flag = 1;
      }

      if (num1 <= num2 && Objects.equals(operator, "-")) {
        throw new Exception("В римской системе нет отрицательных чисел.");
      }

    }

    if ((num1 > 10 || num1 < 0) || (num2 < 0 || num2 > 11)) {
      // Отправляем полученные  данные для вычислений и вывода результата
      assert operator != null;
      CalcAndOutput.calculator(num1, num2, operator, flag);
    } else {
      throw new Exception("По условию входные данные могут быть только от 1 до 10 включительно.");
    }
  }

  static String detectOperation(String input) {
    if (input.contains("+")) return "+";
    if (input.contains("-")) return "-";
    if (input.contains("*")) return "*";
    if (input.contains("/")) return "/";
    return null;
  }

}
