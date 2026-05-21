package utils;

import java.util.Random;

public class Generate {

    public static final String enUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String enLower = enUpper.toLowerCase();

    public static final String ruUpper = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String ruLower = ruUpper.toLowerCase();

    public static final String digits = "0123456789";

    public static final String symbols = enUpper + enLower + ruUpper + ruLower + digits;

    public static String randomString (int length) {
        var random = new Random();
        char[] buf = new char[length];

        for (int i = 0; i < buf.length; ++i)
            buf[i] = symbols.charAt(random.nextInt(symbols.length()));

        return new String(buf);
    }

    public static String randomEmail () {
        return randomString(5) + "@test.com";
    }
}
