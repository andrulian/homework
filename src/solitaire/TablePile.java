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


        if (!topCard.isFaceUp() && !Solitare.clicked) {
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

        for (int i = 0; i < 7; i++) {
            if (Solitare.tableau[i].isOnTopCard(tx, ty) && Solitare.tableau[i].canTake(Solitare.tempCard.cardHolder)) {

                Solitare.tempCard.frameOff();

                Solitare.thisCP.firstCard = Solitare.tempCard.cardHolder.nextLink;
                Solitare.thisCP.firstCard.flip();

                Solitare.tableau[i].addCard(Solitare.tempCard.cardHolder);
            }

            if (!Solitare.tempCard.stack.isEmpty()) {

                if (Solitare.tableau[i].isOnTopCard(tx, ty) && Solitare.tableau[i].canTake(Solitare.tempCard.stack.peek())) {

                    Solitare.thisCP.firstCard = Solitare.tempCard.stack.peek().nextLink;
                    Solitare.thisCP.firstCard.flip();

                    while (!Solitare.tempCard.stack.isEmpty()) {
                        System.out.println("-1");
                        Solitare.tableau[i].addCard(Solitare.tempCard.stack.pop());


                    }


                }

            }
        }

        if (isOnTopCard(tx, ty)) {
            Solitare.tempCard.frameOn();
            Solitare.thisCP = this;
            Solitare.tempCard.x = x;
            Solitare.tempCard.y = (getLen() - 1) * 35 + y;
            Solitare.tempCard.cardHolder = this.firstCard;
        }

        if (isOnGroupOfCards(tx, ty)) {
            System.err.println("GROUP");
            Solitare.tempCard.frameOn();
            Solitare.thisCP = this;
            Solitare.tempCard.x = x;
            Solitare.tempCard.y = y + (getLen() - openedCards()) * 35;
            Solitare.tempCard.recSize += (openedCards() - 1) + openedCards() * 35  - 35;

            while (topCard.isFaceUp()) {
                Solitare.tempCard.stack.push(topCard);
                System.out.println("+1");
                topCard = topCard.nextLink;
            }
        }
    }

    @Override
    public boolean includes (int tx, int ty) {
        // don't test bottom of card
        return x <= tx && tx <= x + Card.width &&
                y <= ty;
    }

    public boolean isOnTopCard (int tx, int ty) {

        int topEdge = y + 35 * (this.getLen() - 1);
        return x <= tx && tx <= x + Card.width &&
                topEdge <= ty && ty <= topEdge + Card.height;
    }

    public boolean isOnGroupOfCards (int tx, int ty) {
        int facedUpCards = 0;
        Card topCard = top();

        facedUpCards = openedCards();

        if (facedUpCards > 1) {
            System.out.println(facedUpCards);
            int topEdge = y + 35 * (this.getLen() - facedUpCards);
            return x <= tx && tx <= x + Card.width &&
                    topEdge <= ty && ty <= topEdge + 35;
        }

        return false;
    }

    public int getLen() {
        int cnt = 0;
        Card iter = this.top();

        while (iter != null) {
            iter = iter.nextLink;
            cnt++;
        }

        return cnt;
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

