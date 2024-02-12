public class CalcAndOutput {
  public static void calculator(int num1, int num2,String operation, int flag) throws Exception {
    int result = 0;

    switch (operation) {
      case "+":
        result = num1 + num2;
        break;
      case "-":
        result = num1 - num2;
        break;
      case "*":
        result = num1 * num2;
        break;
      case "/":
        result = num1 / num2;
    }

    if (flag == 0) {
      System.out.println(result);
    } else {
      if (result < 1) {
        throw new Exception("В римской системе чисела только положительные.");
      } else {
      String s = RomanNumeral.arabicToRoman(result);
      System.out.println(s);
      }
    }

  }
}
