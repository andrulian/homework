package solitaire;

import java.awt.Color;
import java.awt.Graphics;

class CardPile {

    // coordinates of the card pile
    protected int x;
    protected int y;
    private Card firstCard;

    CardPile (int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        firstCard = null;
    }

    // access to cards are not overridden

//    returns the first card's link in the pile (ON TOP)
    public Card top() { return firstCard; }

    public boolean empty() { return firstCard == null; }

    public Card pop() {
        Card result = null;
        if (firstCard != null) {
            result = firstCard;
            firstCard = firstCard.link;
        }
        return result;
    }

    // the following are sometimes overridden

    // if click was made in this. pile area
    public boolean includes (int clickX, int clickY) {
        return x <= clickX && clickX <= x + Card.width &&
                y <= clickY && clickY <= y + Card.height;
    }

//    clicked pile action:
    public void select (int tx, int ty) {
        // do nothing
    }

    public void addCard (Card aCard) {
        aCard.link = firstCard;
        firstCard = aCard;
    }

    public void display (Graphics g) {
        g.setColor(Color.blue);
        if (firstCard == null)
            g.drawRect(x, y, Card.width, Card.height);
        else
            firstCard.draw(g, x, y);
    }

    public boolean canTake (Card aCard) {
        return false;
    }
}
