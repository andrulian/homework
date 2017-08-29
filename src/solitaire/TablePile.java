package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

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

    public boolean includes(int tx, int clickY) {
        // don't test bottom of card
        return x <= tx && tx <= x + Card.width &&
                y <= clickY;
    }

    //    рекурсивно рисуем со сдвигом
    private int stackDisplay(Graphics g, Card aCard) {
        int localy;
        if (aCard == null)
            return y;
        localy = stackDisplay(g, aCard.link);
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
//        CardPile thisCP = this;

        // if face down, then flip
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

        if (!Solitare.clicked) { //false
            System.out.println("FIRST. Clicked status: " + Solitare.clicked);

            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].canTake(topCard)) {
                    System.out.println("CAN TAKE: " + i);

                    Solitare.temp = pop();
                    Solitare.thisCP = this;

                    Solitare.clicked = true;
                    System.out.println("clicked status: " + Solitare.clicked);
                    return;
                }
            }
        }

        if (Solitare.clicked) { //true
            System.out.println("CLICKED. Clicked status: " + Solitare.clicked);

            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].includes(tx, ty) && !Solitare.tableau[i].canTake(Solitare.temp)) {
                    Solitare.thisCP.addCard(Solitare.temp);
                }

                if (Solitare.tableau[i].canTake(Solitare.temp) && Solitare.tableau[i].includes(tx, ty)) {
                    Solitare.tableau[i].addCard(Solitare.temp);

                    if (!Solitare.thisCP.empty()) { Solitare.thisCP.top().flip(); }
                }
                Solitare.clicked = false;
            }
        }
    }
}

