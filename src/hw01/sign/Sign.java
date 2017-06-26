package hw01.sign;

public class Sign {
    public static int sign(int i) {
        if (i == 0) {
            return 0;
        } else {
            return i > 0 ? 1 : -1;
        }
    }
}