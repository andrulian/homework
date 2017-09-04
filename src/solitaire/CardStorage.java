package solitaire;

import java.awt.*;
import java.util.Stack;

public class CardStorage {
    private int x = 15, y = 5;
    private Color clr = Color.blue;
    private Stack<Card> stack = new Stack<>();

    int recSize = 70;

    CardPile pickedCardPile;


    public void frameOff() {
        x = 15;
        y = 5;
        recSize = 70;
        clr = Color.blue;
        System.out.println("Clearing stack....");
        stack.clear();
        System.out.println("From stack: " + stack.size());
    }

    public void frameOn() {
        clr = Color.cyan;
    }

    public void display (Graphics g) {
        g.setColor(clr);
        g.drawRect(x, y, 50, recSize);
    }

    public void takeCard (Card aCard) {
        if (stack.isEmpty()) { frameOn(); }
        stack.push(aCard);
    }

    public Card putCard () {
//        if (!stack.isEmpty()) { frameOff(); }
        return stack.pop();
    }

    public Card peekCard () {
        return stack.peek();
    }

    public int cardsInHand () {
        return stack.size();
    }

    public boolean isHandFree () {
        return stack.size() < 1;
    }

    public void setCoord(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }
}
