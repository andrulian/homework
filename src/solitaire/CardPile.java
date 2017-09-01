package solitaire;

import java.awt.*;

class CardPile {

    // coordinates of the card pile
    protected int x;
    protected int y;
    public Card firstCard;

//    public int pileLen;

    CardPile (int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        firstCard = null;
    }

    // access to cards are not overridden

//    returns the first card's cardHolder in the pile (ON TOP)
    public Card top() { return firstCard; }

    public boolean empty() { return firstCard == null; }

    public Card pop() {
        Card result = null;
        if (firstCard != null) {
//            this.pileLen--;
            result = firstCard;
            firstCard = firstCard.nextLink;
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
        aCard.nextLink = firstCard;
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

    public int size () {
        if (firstCard == null) {return 0;}
        int count = 1;
        Card card = firstCard;


        while (card.nextLink != null) {
            count++;
            card = card.nextLink;
        }
//        System.out.printf("count " + count);
        return count;
    }


}
