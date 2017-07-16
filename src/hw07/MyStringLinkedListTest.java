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
//        System.out.println(Asserts.assertEquals(MyStringLinkedList.get(1000), ""));
//        System.out.println(Asserts.assertEquals(MyStringLinkedList.size(), 2));
//        System.out.println(Asserts.assertEquals(MyStringLinkedList.set(1, "elem_1.1"), "elem_1"));
//        System.out.println(Asserts.assertEquals(MyStringLinkedList.isEmpty(), false));
//        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove(4), "elem_4"));
//        System.out.println(Asserts.assertEquals(MyStringLinkedList.remove("elem_3"), true));


//        System.out.println(MyStringLinkedList.myStaticToString());
        MyStringLinkedList.printList();
    }

    private static void listFiller() {
        MyStringLinkedList.add("elem_0");
        MyStringLinkedList.add("elem_1");
        MyStringLinkedList.add("elem_2");
        MyStringLinkedList.add("elem_3");
        MyStringLinkedList.add("elem_4");
        MyStringLinkedList.add("elem_5");
    }
}
