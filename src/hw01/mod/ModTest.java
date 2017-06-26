package hw01.mod;

public class ModTest {
    public static void main(String[] args) {
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(30,3), 0));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(400,5), 0));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(103,5), 3));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(43,5), -3));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(10,5), 2));

        System.out.println(SimpleUnit.assertsEqual(Mod.mod(-30,3), 0));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(-401,5), -1));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(-103,5), -3));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(-43,5), 1));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(-11,5), -10));

        System.out.println(SimpleUnit.assertsEqual(Mod.mod(30,-3), 0));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(401,-5), 1));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(103,-5), 3));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(43,-5), 0));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(11,-5), -1));

        System.out.println(SimpleUnit.assertsEqual(Mod.mod(-30,-3), 0));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(-401,-5), -1));
        System.out.println(SimpleUnit.assertsEqual(Mod.mod(-103,-5), -3));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(-43,-5), 3));
        System.out.println(SimpleUnit.assertsNotEqual(Mod.mod(-11,-5), 1));
    }
}