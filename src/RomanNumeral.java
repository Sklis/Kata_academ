public enum RomanNumeral {
  M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

  private final int value;

  RomanNumeral(int arabic) {
    this.value = arabic;
  }

  public int getValue() {
    return value;
  }

  public static String arabicToRoman(int arabic) throws IllegalArgumentException {
    if (arabic <= 0 || arabic > 3999) {
      throw new IllegalArgumentException("Значение должно быть в диапазоне от 1 до 3999");
    }

    StringBuilder result = new StringBuilder();

    for (RomanNumeral numeral : values()) {
      while (arabic >= numeral.getValue()) {
        result.append(numeral.name());
        arabic -= numeral.getValue();
      }
    }

    return result.toString();
  }

  public static int romanToArabic(String roman) {
    int result = 0;
    int prev = 0;

    for (int i = roman.length() - 1; i >= 0; i--) {
      char currentSymbol = roman.charAt(i);
      RomanNumeral currentNumeral = valueOf(String.valueOf(currentSymbol));

      if (currentNumeral.getValue() < prev) result -= currentNumeral.getValue();
      else  result += currentNumeral.getValue();

      prev = currentNumeral.getValue();
    }

    return result;
  }
}
