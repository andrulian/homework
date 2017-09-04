package solitaire;

import java.awt.*;

class TablePile extends CardPile {
    CardStorage cs = Solitare.cardStorage;

    TablePile(int x, int y, int c) {
        // initialize the parent class
        super(x, y);
        // then initialize our pile of cards
        for (int i = 0; i < c; i++) {
            addCard(Solitare.deckPile.pop());
        }
        // flip topmost card face up
        top().flip();
    }

    public boolean canTake(Card aCard) {
        if (empty())
            return aCard.getRank() == 12;
        Card topCard = top();
        return (aCard.getColor() != topCard.getColor()) &&
                (aCard.getRank() == topCard.getRank() - 1);
    }

    //    рекурсивно рисуем со сдвигом 35
    private int stackDisplay(Graphics g, Card aCard) {
        int localy;
        if (aCard == null)
            return y;
        localy = stackDisplay(g, aCard.prevInDeck);
        aCard.draw(g, x, localy);
        return localy + 35;
    }

    public void display(Graphics g) {
        stackDisplay(g, top());
    }

//------------

    public void select(int tx, int ty) {
        if (empty())
            return;

        Card topCard = top();


        if (!topCard.isFaceUp()) {
            topCard.flip();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (Solitare.suitPile[i].canTake(topCard)) {
                if (topCard.prevInDeck != null && !topCard.prevInDeck.isFaceUp()) {
                    topCard.prevInDeck.flip();
                }
                Solitare.suitPile[i].addCard(pop());

                return;
            }
        }

        if ( !cs.isHandFree()) { // stack is not empty
            System.out.println("Stack has: " + cs.cardsInHand());

            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].isClickOnTopCard(tx, ty) && Solitare.tableau[i].canTake(cs.peekCard())) {


                    System.out.println("pickedCardPile.size() IS " + cs.pickedCardPile.size());
                    System.out.println("CardStorage STACK.size() IS " + cs.cardsInHand());
                    // if peeked pile has only one or many open cards.
                    if (cs.pickedCardPile.size() == 1  || cs.pickedCardPile.openedCards() == cs.pickedCardPile.size()) {
                        cs.pickedCardPile.firstInDeck = null;
                        System.out.println("YEP");
                    } else {
                        System.out.println("TRY FOR ELSE");
                        cs.pickedCardPile.firstInDeck = cs.peekCard().prevInDeck;
                        cs.pickedCardPile.firstInDeck.flip();
                    }

                    while (!cs.isHandFree()) {
                        Solitare.tableau[i].addCard(cs.putCard());
                    }
                }
            }

            cs.frameOff();

        } else { // stack is empty
            cs.pickedCardPile = this;
            int len = size();

            if (isClickOnTopCard(tx, ty)) {
                cs.setCoord(x, (len - 1) * 35 + y);
                cs.takeCard(topCard);
                System.out.println("" + cs.cardsInHand() + " card has pushed to stack");

            }
            
            if (isClickOnGroupOfCards(tx, ty)) {
                System.out.println("call MANY");
                cs.setCoord(x, y + (len - openedCards()) * 35);
                cs.recSize += (openedCards() - 1) + openedCards() * 35 - 36;

                while (topCard.isFaceUp()) {
                    cs.takeCard(topCard);
                    if (topCard.prevInDeck == null) {break;}
                    topCard = topCard.prevInDeck;
                }

                System.out.println("Many cards has pushed to stack");
            }
        }
    }

    @Override
    public boolean includes (int tx, int ty) {
        return x <= tx && tx <= x + Card.width &&
                y <= ty;
    }

    public boolean isClickOnTopCard(int tx, int ty) {
        if (size() == 0) {return false;}

        int topEdge = y + 35 * (size() - 1);
        return x <= tx && tx <= x + Card.width &&
                topEdge <= ty && ty <= topEdge + Card.height;
    }

    public boolean isClickOnGroupOfCards(int tx, int ty) {
        if (size() == 0) {return false;}

        int facedUpCards = openedCards();

        if (facedUpCards > 1) {
            int topEdge = y + 35 * (size() - facedUpCards);
            return x <= tx && tx <= x + Card.width &&
                    topEdge <= ty && ty <= topEdge + 35;
        }

        return false;
    }

//    public int openedCards () {
//        int facedUpCards = 0;
//        Card topCard = top();
//
//        if (topCard == null) { return 0; }
//
//        while (topCard != null && topCard.isFaceUp()) {
//
//            topCard = topCard.prevInDeck;
//            facedUpCards++;
//        }
//
//        return facedUpCards;
//    }
}

