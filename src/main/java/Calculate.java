public class Calculate {
    private RomanLetter romanLetter = new RomanLetter();

    public Calculate() {
    }

    private void maxValueCheck(int number) {
        if (number > 10)
            throw new NumberFormatException("Вы ввели значение больше 10! Внимательней  читайте условие ввода.");
    }

    public void nextStepCheck(String scannerLetter, TypeNumber typeNumber){
        int firsNumber, lastNumber, resultCalculate;
        String arithmeticSigns, regexSplitEquation;

        regexSplitEquation = "((?<=[+*-/])|(?=[+*-/]))";

        scannerLetter = scannerLetter.replaceAll(" ", "");
        String[] splitLine = scannerLetter.split(regexSplitEquation);
        if (splitLine.length != 3) {
            throw new NumberFormatException("Не верный формат ввода! Пример: 1 + 2 или VI / III");
        }

        if (typeNumber.equals(TypeNumber.ROMAN)) {
            firsNumber = romanLetter.romanNumeral(splitLine[0]);
            maxValueCheck(firsNumber);
            lastNumber = romanLetter.romanNumeral(splitLine[2]);
        } else {
            firsNumber = Integer.parseInt(splitLine[0]);
            maxValueCheck(firsNumber);
            lastNumber = Integer.parseInt(splitLine[2]);
        }

        maxValueCheck(lastNumber);
        arithmeticSigns = splitLine[1];

        try {
            resultCalculate = calculateNumber(firsNumber, lastNumber, arithmeticSigns);
        } catch (NullPointerException e) {
            throw new NumberFormatException("что то пошло не так, попробуйте еще раз");
        }

        if (typeNumber.equals(TypeNumber.ROMAN)) {
            if (resultCalculate <= 0)
                throw new NumberFormatException("Не верный формат ввода! Римские цифры не могут быть 0 или отрицательные");
            System.out.println(romanLetter.convertArabicToRoman(resultCalculate));
        } else {
            System.out.println(resultCalculate);
        }
    }

    private Integer calculateNumber(int firstValue, int lastValue, String operation) {
        if (operation.equals("+")) {
            return firstValue + lastValue;
        }

        if (operation.equals("-")) {
            return firstValue - lastValue;
        }

        if (operation.equals("*")) {
            return firstValue * lastValue;
        }

        if (operation.equals("/")) {
            return firstValue / lastValue;
        }
        return null;
    }
}
