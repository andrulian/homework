package hw08lesson170712;

import mytestframework.Asserts;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(7);
        myStack = stackFiller(myStack);

        System.out.println(Asserts.assertEquals(myStack.size(), 6));
        System.out.println(Asserts.assertEquals(myStack.pop(), "elem_5"));
        System.out.println(Asserts.assertEquals(myStack.pop(), "elem_4"));
        System.out.println(Asserts.assertEquals(myStack.pop(), "elem_3"));
        System.out.println(Asserts.assertEquals(myStack.pop(), "elem_2"));
        System.out.println(Asserts.assertEquals(myStack.pop(), "elem_1"));
        System.out.println(Asserts.assertEquals(myStack.pop(), "elem_0"));
        System.out.println(myStack.pop()==null);

        myStack = new MyStack(3);
        myStack = stackFiller(myStack);

        System.out.println(Asserts.assertEquals(myStack.tos(), "elem_2"));
        System.out.println(Asserts.assertEquals(myStack.size(), 3));

        System.out.println(myStack.toString());
    }

    private static MyStack stackFiller(MyStack myStack) {
        for (int i = 0; i < 6; i++) {
            myStack.push("elem_" + i);
        }

        return myStack;
    }
}