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
//    if(oldChar != newChar) {
//        int len = this.value.length;
//        int i = -1;
//        char[] val = this.value;
//
//        do {
//            ++i;
//        } while(i < len && val[i] != oldChar);
//
//        if(i < len) {
//            char[] buf = new char[len];
//
//            for(int j = 0; j < i; ++j) {
//                buf[j] = val[j];
//            }
//
//            while(i < len) {
//                char c = val[i];
//                buf[i] = c == oldChar?newChar:c;
//                ++i;
//            }
//
//            return new String(buf, true);
//        }
//    }

    private static boolean hasNoTrailingOrLeadingSpaces(String s) {
        return s.indexOf(' ') != 0 && s.lastIndexOf(' ') != s.length() - 1;
    }
}
