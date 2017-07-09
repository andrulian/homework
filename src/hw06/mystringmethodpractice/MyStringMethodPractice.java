package hw06.mystringmethodpractice;

import java.util.Arrays;

public class MyStringMethodPractice {

    public static String trim(String s) {
        int beginIndex = 0;
        int endIndex = 0;

        if (s == null || s.length() == 0) {
            return s;
        }

        if (hasNoTrailingOrLeadingSpaces(s)) {
            return s;
        }

        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) != ' ') {
                beginIndex = i;
                break;
            }
        }

        for (int i = s.length()-1; i > 0; i--) {
            if(s.charAt(i) != ' ') {
                endIndex = i;
                break;
            }
        }

        String sSub = s.substring(beginIndex, endIndex+1);
        return sSub;
    }

    public static String replace(String str, char oldChar, char newChar) {
        if (str == null || str.length() == 0) {
            return str;
        }

        int index = 0;
        char[] sarr = str.toCharArray();
        int len = sarr.length;

        if (oldChar != newChar) {
            for (int i = 0; i < len; i++) {
                if(str.charAt(i) == oldChar) {
                    index = i;
                    break;
                }
            }

            char[] buf = new char[len];
            System.arraycopy(sarr, 0, buf, 0, index);
            buf[index] = newChar;
            System.arraycopy(sarr, index + 1, buf, index + 1, len - (index + 1));
            return new String(buf);
        }

        return str;
    }

    private static boolean hasNoTrailingOrLeadingSpaces(String s) {
        return s.indexOf(' ') != 0 && s.lastIndexOf(' ') != s.length() - 1;
    }
}
