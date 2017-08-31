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
        localy = stackDisplay(g, aCard.nextLink);
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
                Solitare.suitPile[i].addCard(pop());

                if (!this.top().isFaceUp()) {
                    this.top().flip();
                }

                return;
            }
        }

        System.out.println("PRE Stack size:" + Solitare.tempCard.stack.size());
        if (!Solitare.tempCard.stack.isEmpty()) {
            System.err.println("NOT EMPTY");

            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].isOnTopCard(tx, ty) && Solitare.tableau[i].canTake(Solitare.tempCard.stack.peek())) {

                    Solitare.tempCard.frameOff();

                    Solitare.thisCP.firstCard = Solitare.tempCard.stack.peek().nextLink;
                    Solitare.thisCP.firstCard.flip();

                    while (!Solitare.tempCard.stack.isEmpty()) {
                        Solitare.tableau[i].addCard(Solitare.tempCard.stack.pop());
                    }
                }
            }
        
        } else {
            Solitare.tempCard.frameOn();
            Solitare.thisCP = this;
            Solitare.tempCard.x = x;
            int len = size();
            System.out.println("Stack size:" + len);

            if (isOnTopCard(tx, ty)) {
                System.out.println("call ONE");

                //TODO
                Solitare.tempCard.y = (len - 1) * 35 + y;
                Solitare.tempCard.stack.push(this.firstCard);

//                return;
            }

            
            if (isOnGroupOfCards(tx, ty)) {
                System.out.println("call MANY");
                Solitare.tempCard.y = y + (len - openedCards()) * 35;
                Solitare.tempCard.recSize += (openedCards() - 1) + openedCards() * 35 - 35;

                while (topCard.isFaceUp()) {
                    Solitare.tempCard.stack.push(topCard);
                    topCard = topCard.nextLink;
                }

//                return;
            }
            System.out.println("Stack size:" + len);
            }
    }

    @Override
    public boolean includes (int tx, int ty) {
        // don't test bottom of card
        return x <= tx && tx <= x + Card.width &&
                y <= ty;
    }

    public boolean isOnTopCard (int tx, int ty) {
        System.out.println("One");

        if (size() == 0) {return false;}

        int topEdge = y + 35 * (size() - 1);
        return x <= tx && tx <= x + Card.width &&
                topEdge <= ty && ty <= topEdge + Card.height;
    }

    public boolean isOnGroupOfCards (int tx, int ty) {
        System.out.println("Group");

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

            topCard = topCard.nextLink;
            facedUpCards++;
        }

        return facedUpCards;
    }



}

