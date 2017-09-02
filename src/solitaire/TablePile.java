package solitaire;

import java.awt.*;

class TablePile extends CardPile {

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

        if ( !Solitare.cardStore.stack.isEmpty()) {//not empty
            System.out.println("Stack has: " + Solitare.cardStore.stack.size());

            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].isOnTopCard(tx, ty) && Solitare.tableau[i].canTake(Solitare.cardStore.stack.peek())) {


                    System.out.println("pickedCardPile.size() IS " + Solitare.pickedCardPile.size());
                    System.out.println("CardStore STACK.size() IS " + Solitare.cardStore.stack.size());
                    if (Solitare.pickedCardPile.size() == 1) {
                        Solitare.pickedCardPile.firstInDeck = null;
                        System.out.println("YEP");
                    } else {
                        Solitare.pickedCardPile.firstInDeck = Solitare.cardStore.stack.peek().prevInDeck;
                        Solitare.pickedCardPile.firstInDeck.flip();
                    }

                    while (!Solitare.cardStore.stack.isEmpty()) {
                        Solitare.tableau[i].addCard(Solitare.cardStore.stack.pop());
                    }
                }
            }

            Solitare.cardStore.frameOff();

        } else { //empty
            Solitare.cardStore.frameOn();
            Solitare.pickedCardPile = this;
            Solitare.cardStore.x = x;
            int len = size();

            if (isOnTopCard(tx, ty)) {
                Solitare.cardStore.y = (len - 1) * 35 + y;
                Solitare.cardStore.stack.push(topCard);
                System.out.println("" + Solitare.cardStore.stack.size() + " card(s) has pushed to stack");

            }
            
            if (isOnGroupOfCards(tx, ty)) {
                System.out.println("call MANY");
                Solitare.cardStore.y = y + (len - openedCards()) * 35;
                Solitare.cardStore.recSize += (openedCards() - 1) + openedCards() * 35 - 36;

                while (topCard.isFaceUp()) {
                    Solitare.cardStore.stack.push(topCard);
                    if (topCard.prevInDeck == null) {break;}
                    topCard = topCard.prevInDeck;
                }

                System.out.println("Many card has pushed to stack");
            }
        }
    }

    @Override
    public boolean includes (int tx, int ty) {
        return x <= tx && tx <= x + Card.width &&
                y <= ty;
    }

    public boolean isOnTopCard (int tx, int ty) {
        if (size() == 0) {return false;}

        int topEdge = y + 35 * (size() - 1);
        return x <= tx && tx <= x + Card.width &&
                topEdge <= ty && ty <= topEdge + Card.height;
    }

    public boolean isOnGroupOfCards (int tx, int ty) {
        if (size() == 0) {return false;}

        int facedUpCards = openedCards();

        if (facedUpCards > 1) {
            int topEdge = y + 35 * (size() - facedUpCards);
            return x <= tx && tx <= x + Card.width &&
                    topEdge <= ty && ty <= topEdge + 35;
        }

        return false;
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

