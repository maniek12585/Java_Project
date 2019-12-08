package pl.polsl.PawelZachara.NumberConversion.Server;

/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

/**
 * class that perform conversion
 */
public class Converter {

    private static final int arabic[] = {1000, 500, 100, 50, 10, 5, 1};
    private static final int ROMAN_N = arabic.length;
    private static final char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    /**
     *
     * @param number
     * @param inputArabic
     * @return romanNumber
     *
     * Roman numeral passed as string is converted to Arabic numeral (int type)
     */
    public static int romanToDecimal(String number) {
        int indexInArabicRomanArrays = 0;
        int indexInRomanNumber = 0;
        int length = 0;
        int result = 0;
        
        length = number.length();

        while ((indexInRomanNumber < length) && (indexInArabicRomanArrays < ROMAN_N)) {
            if (number.charAt(indexInRomanNumber) == roman[indexInArabicRomanArrays]) {
                result += arabic[indexInArabicRomanArrays];
                indexInRomanNumber++;
            } else if ((indexInArabicRomanArrays % 2 == 0)
                    && (indexInArabicRomanArrays < ROMAN_N - 2)
                    && (indexInRomanNumber < length - 1)
                    && (number.charAt(indexInRomanNumber) == roman[indexInArabicRomanArrays + 2])
                    && (number.charAt(indexInRomanNumber + 1) == roman[indexInArabicRomanArrays])) {
                result += arabic[indexInArabicRomanArrays] - arabic[indexInArabicRomanArrays + 2];
                indexInRomanNumber += 2;
                indexInArabicRomanArrays++;
            } else if ((indexInArabicRomanArrays % 2 == 1)
                    && (indexInArabicRomanArrays < ROMAN_N - 1)
                    && (indexInRomanNumber < length - 1)
                    && (number.charAt(indexInRomanNumber) == roman[indexInArabicRomanArrays + 1])
                    && (number.charAt(indexInRomanNumber + 1) == roman[indexInArabicRomanArrays])) {
                result += arabic[indexInArabicRomanArrays] - arabic[indexInArabicRomanArrays + 1];
                indexInRomanNumber += 2;
                indexInArabicRomanArrays++;
            } else {
                indexInArabicRomanArrays++;
            }
        }
//        System.out.println(result);
//        if (indexInArabicRomanArrays == ROMAN_N) {
//            result = -1;
//        }

        return result;
    }

}
