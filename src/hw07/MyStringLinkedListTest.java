package hw07;

import mytestframework.Asserts;


public class MyStringLinkedListTest {
    public static void main(String[] args) {

        listFiller();

        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove(0), "elem_0"));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove(4), "elem_5"));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove(1), "elem_2"));

        MyStringLinkedList.listEraser();
        listFiller();

        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_0"), true));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_5"), true));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_2"), true));

        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_0"), false));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_5"), false));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_2"), false));



        System.out.println(Asserts.assertEquals(MyStringLinkedList.get(0), "elem_1"));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.get(3), ""));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.get(1000), ""));

        System.out.println(Asserts.assertEquals(MyStringLinkedList.set(0, "elem_1.1"), true));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.set(1, "elem_3.1"), true));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.set(2, "elem_4.1"), true));
        System.out.println(Asserts.assertEquals(MyStringLinkedList.set(3, "elem_out.1"), false));

        System.out.println(Asserts.assertEquals(MyStringLinkedList.isEmpty(), false));

        System.out.println(MyStringLinkedList.myStaticToString());
        MyStringLinkedList.printList();
    }

    private static void listFiller() {
        for (int i = 0; i < 6; i++) {
            MyStringLinkedList.add("elem_" + i);
        }
    }
}