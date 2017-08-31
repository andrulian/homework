package solitaire;

import java.awt.*;

public class TempPile extends CardPile {

    TempPile(int xCoord, int yCoord) {
        super(xCoord, yCoord);
        firstCard = new Card(100, 100);

    }

//    public int getLen() {
//        Card topCard = top();
//        int len = 0;
//
//        while (topCard != null) {
//            topCard = topCard.cardHolder;
//            len++;
//        }
//
//        return len;
//    }

    @Override
    public void addCard (Card aCard) {
//        aCard.cardHolder = firstCard;
        firstCard = aCard;
//        if (firstCard == null) { firstCard = aCard; }
//        else {
//            aCard.cardHolder = firstCard;
//            firstCard = aCard;
////            aCard.prevLink = null;
    }


//    @Override
//    public Card pop() {
//        Card result = null;
//        if (firstCard != null) {
//            result = firstCard;
//            firstCard = firstCard.cardHolder;
//        }
//        return result;
//    }

    @Override
    public void display (Graphics g) {
        if (!firstCard.isFaceUp()) {
            g.setColor(Color.white);
            g.drawRect(x, y, Card.width + 4, Card.height + 4);
        }
        else {
            g.setColor(Color.cyan);
            g.drawRect(x, y, Card.width + 4, Card.height + 4);
        }
//            firstCard.draw(g, x, y);
    }

//    @Override
//    public boolean includes (int clickX, int clickY) {
//        int topEdge = y + 35 * (this.getLen() - 1);
//        boolean res = x <= clickX && clickX <= x + Card.width &&
//                topEdge <= clickY && clickY <= topEdge + Card.height;
//        return res;// ? res : groupIncludes(clickX, clickY);
//    }


}
