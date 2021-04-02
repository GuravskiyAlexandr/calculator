import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanLetter {
    private final int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] letters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final String regexRoman = "^(?:X{0,3})(?:V?I{0,3}|I[XV])$";
    private final Pattern patternRoman = Pattern.compile(regexRoman);

    public RomanLetter() {
    }

    public int romanNumeral(String roman) {
        final Matcher matcherRoman = patternRoman.matcher(roman);
        final boolean resultFindRoman = matcherRoman.find();
        if (!resultFindRoman)
            throw new NumberFormatException("Недопустимый символ "+roman);

        int i = 0;
        int arabic = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int number = letterToNumber(letter);

            if (number < 0)
                throw new NumberFormatException("Недопустимый символ \"" + letter + "\" римской цифры.");
            i++;

            if (i == roman.length()) {
                arabic += number;
            } else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                } else {
                    arabic += number;
                }
            }
        }
        return arabic;
    }

    public String convertArabicToRoman(int number) {
        String roman = "";
        for (int i = 0; i < numbers.length; i++) {
            while (number >= numbers[i]) {
                roman += letters[i];
                number -= numbers[i];
            }
        }
        return roman;
    }

    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                return -1;
        }
    }
}
