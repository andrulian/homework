package solitaire;

import java.awt.*;
import java.util.Stack;

//public class TempCard extends Card {
public class TempCard  { //extends LinkedList<Card> {
    int x;
    int y;
    int recSize = 74;

    Stack<Card> stack = new Stack<>();

    Color clr = Color.lightGray;

    Card cardHolder = new Card(100, 100);

    TempCard() {
        this(0, 100);
    }

    TempCard(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;

    }

    public void display (Graphics g) {
        g.setColor(clr);
        g.drawRect(x - 2, y - 2, 54, recSize);
    }


    public void frameOff() {
        clr = Color.lightGray;
    }

    public void frameOn() {
        clr = Color.cyan;
    }
}
