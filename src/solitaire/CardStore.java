package solitaire;

import java.awt.*;
import java.util.Stack;

public class CardStore {
    int x, y;
    int recSize = 70;

    Stack<Card> stack = new Stack<>();

    Color clr = Color.blue;

    CardStore() {
        this(15, 5);
    }

    CardStore(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public void display (Graphics g) {
        g.setColor(clr);
        g.drawRect(x, y, 50, recSize);
    }

    public void frameOff() {
        x = 15;
        y = 5;
        recSize = 70;
        clr = Color.blue;
        stack.clear();
        System.out.println("From stack: " + stack.size());

    }

    public void frameOn() {
        clr = Color.cyan;
    }
}
