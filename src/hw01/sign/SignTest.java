package hw01.sign;

public class SignTest {
    public static void main(String[] args) {
        System.out.println(SimpleUnit.assertsEqual(Sign.sign(10),1));
        System.out.println(SimpleUnit.assertsEqual(Sign.sign(15),1));
        System.out.println(SimpleUnit.assertsNotEqual(Sign.sign(111),-1));

        System.out.println(SimpleUnit.assertsEqual(Sign.sign(-10),-1));
        System.out.println(SimpleUnit.assertsEqual(Sign.sign(-15),-1));
        System.out.println(SimpleUnit.assertsNotEqual(Sign.sign(-111),1));

        System.out.println(SimpleUnit.assertsEqual(Sign.sign(0),0));
        System.out.println(SimpleUnit.assertsNotEqual(Sign.sign(0),-1));
    }
}
