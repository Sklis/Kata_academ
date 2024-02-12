public class CalcAndOutput {
  public static void calculator(int num1, int num2,String operation, int flag) throws Exception {
    float result = 0;

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
      String s = RomanNumeral.arabicToRoman(Math.round(result));
      System.out.println(s);
    }
  }
}
