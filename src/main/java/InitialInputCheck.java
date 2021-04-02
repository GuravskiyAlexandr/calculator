import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitialInputCheck {
    private Calculate calculate = new Calculate();

    public InitialInputCheck() {
    }

    private final String regexRoman = "[IVX]";
    private final String regexArabic = "[0-9{1}]";
    private final String regexSymbol = "[^+\\-*/0-9IXV\\s]";

    private final Pattern patternRoman = Pattern.compile(regexRoman);
    private final Pattern patternArabic = Pattern.compile(regexArabic);
    private final Pattern patternSymbol = Pattern.compile(regexSymbol);

    public void InputCheck(String scannerLetter) throws Exception {

        final Matcher matcherRoman = patternRoman.matcher(scannerLetter);
        final Matcher matcherArabic = patternArabic.matcher(scannerLetter);
        final Matcher matcherSymbol = patternSymbol.matcher(scannerLetter);

        final boolean resultFindRom = matcherRoman.find();
        final boolean resultFindArabic = matcherArabic.find();
        final boolean resultFindSymbol = matcherSymbol.find();


        if (resultFindSymbol) {
            throw new NumberFormatException("Вводить только целые числа из разрешенного диапазона 1-9 или IXL ,\n " +
                    "операторы +-*/, остальные сивмолы  также нельзя");
        } else {
            if (resultFindRom) {
                if (!resultFindArabic) {
                    calculate.nextStepCheck(scannerLetter, TypeNumber.ROMAN);
                } else {
                    throw new NumberFormatException("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно");
                }
            } else if (resultFindArabic) {
                calculate.nextStepCheck(scannerLetter, TypeNumber.ARABIC);
            }
        }
    }
}
