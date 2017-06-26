package hw01.isFibonacci;

public class IsFibonacci {

//    public static boolean isFibonacci(int fibIndex) {
//        int a = 0;
//        int b = 1;
//
//        for(int i=0; i<fibIndex; i++) {
//            int c = (a + b);
//            a = b;
//            b = c;
//        }
//        return true;
//    }
    public static boolean isFibonacci(int fibIndex) {
        double body = 5 * Math.pow(fibIndex, 2);
        if((Math.sqrt(body + 4) % 1 == 0) || (Math.sqrt(body - 4) % 1 ==0)) {
            return true;
        }
        return false;
    }
}
