package hw06;

public class MyStringMethodPractice {



    public static String trim(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        if (hasNoTrailingOrLeadingSpaces(s)) {
            return s;
        }

        // TODO

        return s;
    }

//    public static String replace(String s) {
//
//    }

    private static boolean hasNoTrailingOrLeadingSpaces(String s) {
        return s.indexOf(' ') != 0 && s.lastIndexOf(' ') != s.length() - 1;
    }

}
