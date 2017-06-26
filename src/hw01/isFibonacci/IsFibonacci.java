package hw01.isFibonacci;

public class IsFibonacci {

    public static int isFibonacci(int fibIndex) {
        int a = 0;
        int b = 1;

        for(int i=0; i<fibIndex; i++) {
            int c = (a + b);
            a = b;
            b = c;
        }
        return a;
    }
}
