package hw06;

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
//        int newLen = endIndex+1-beginIndex;
//        char[] slice = new char[newLen];
//        char[] sarr = s.toCharArray();
//        System.arraycopy(sarr, beginIndex, slice, 0, newLen);

        String sSub = s.substring(beginIndex, endIndex+1);

        return sSub;
    }

//    public static String replace(String s) {
//
//    }

    private static boolean hasNoTrailingOrLeadingSpaces(String s) {
        return s.indexOf(' ') != 0 && s.lastIndexOf(' ') != s.length() - 1;
    }
}
