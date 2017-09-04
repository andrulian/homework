package solitaire;

import java.awt.*;

class CardPile {

    // coordinates of the card pile
    protected int x;
    protected int y;
    public Card firstInDeck;

    CardPile (int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        firstInDeck = null;
    }

    public Card top() { return firstInDeck; }

    public boolean empty() { return firstInDeck == null; }

    public Card pop() {
        Card result = null;
        if (firstInDeck != null) {
            result = firstInDeck;
            firstInDeck = firstInDeck.prevInDeck;
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
//        this.pileLen++;
        aCard.prevInDeck = firstInDeck;
        firstInDeck = aCard;
    }

    public void display (Graphics g) {
        g.setColor(Color.blue);
        if (firstInDeck == null)
            g.drawRect(x, y, Card.width, Card.height);
        else
            firstInDeck.draw(g, x, y);
    }

    public boolean canTake (Card aCard) {
        return false;
    }

    public int size () {
        if (firstInDeck == null) {return 0;}
        int count = 1;
        Card card = firstInDeck;


        while (card.prevInDeck != null) {
            count++;
            card = card.prevInDeck;
        }
//        System.out.printf("count " + count);
        return count;
    }

    public int openedCards () {
        int facedUpCards = 0;
        Card topCard = top();

        if (topCard == null) { return 0; }

        while (topCard != null && topCard.isFaceUp()) {

            topCard = topCard.prevInDeck;
            facedUpCards++;
        }

        return facedUpCards;
    }


}
