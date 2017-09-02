package solitaire;

import java.awt.*;
import java.util.Stack;

//public class TempCard extends Card {
public class TempCard  { //extends LinkedList<Card> {
    int x, y;
    int recSize = 70;

    Stack<Card> stack = new Stack<>();

    Color clr = Color.blue;

//    Card cardHolder = new Card(100, 100);

    TempCard() {
        this(15, 5);
    }

    TempCard(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;

    }

    public void display (Graphics g) {
        g.setColor(clr);
        g.drawRect(x, y, 50, recSize);
    }



    public void frameOff() {
        clr = Color.blue;
        x = 15;
        y = 5;
        recSize = 70;

    }

    public void frameOn() {
        clr = Color.cyan;
    }
}
