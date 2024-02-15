public class CalcAndOutput {
    public static void calculator(int num1, int num2, String operation, int flag) {
    int result;
    result = switch (operation) {
      case "+" -> num1 + num2;
      case "-" -> num1 - num2;
      case "*" -> num1 * num2;
      case "/" -> num1 / num2;
      default -> 0;
    };

    if (flag != 0) {
      if (result < 1) {
        System.out.println("В римской системе, чисела только положительные. И результат не может быть равен 0.");
        System.exit(0);
      } else {
        String s = RomanNumeral.arabicToRoman(result);
        System.out.println(s);
      }
    } else {
      System.out.println(result);
    }

  }
}
