package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

class TablePile extends CardPile {

    TablePile (int x, int y, int c) {
        // initialize the parent class
        super(x, y);
        // then initialize our pile of cards
        for (int i = 0; i < c; i++) {
            addCard(Solitare.deckPile.pop());
        }
        // flip topmost card face up
        top().flip();
    }

    public boolean canTake (Card aCard) {
        if (empty())
            return aCard.getRank() == 12;
        Card topCard = top();
        return (aCard.getColor() != topCard.getColor()) &&
                (aCard.getRank() == topCard.getRank() - 1);
    }

    public boolean includes (int tx, int clickY) {
        // don't test bottom of card
        return x <= tx && tx <= x + Card.width &&
                y <= clickY;
    }

    public void select (int tx, int ty) {
        if (empty())
            return;

//        Card topCard = top();
//
//        // if face down, then flip
//        if (!topCard.isFaceUp()) {
//            topCard.flip();
//            return;
//        }

//        Solitare.temp = topCard;

        // else see if any getSuit pile can take card
//        topCard = pop();

        if (!Solitare.clicked) {
            System.out.println("FIRST. Clicked status: " + Solitare.clicked);

//            for (int i = 0; i < 4; i++) {
//
//                if (Solitare.suitPile[i].canTake(topCard)) {
////                    Solitare.suitPile[i].addCard(topCard);
//                    Solitare.suitPile[i].select(tx, ty);
////                    if (!this.top().isFaceUp()) {
////                        this.top().flip();
////                    }
//
//                    return;
//                }
//            }

            Card topCard = top();

            // if face down, then flip
            if (!topCard.isFaceUp()) {
                topCard.flip();
                return;
            }

            Solitare.temp = topCard;

            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].canTake(topCard)) {
                    System.out.println("CAN TAKE: " + i);
                    Solitare.temp = topCard;
                    Solitare.clicked = true;
                    pop();
                    System.out.println("clicked status: " + Solitare.clicked);

//                    Solitare.tableau[i].addCard(topCard);
//                    Solitare.tableau[i].select(tx, ty);
//                    if (!this.top().isFaceUp()) {
//                        this.top().flip();
//                    }
                    return;
                }
            }

        } //else {Solitare.clicked = false;}

        if (Solitare.clicked) {
            System.out.println("CLICKED. Clicked status: " + Solitare.clicked);
            for (int i = 0; i < 7; i++) {
                if (Solitare.tableau[i].includes(tx, ty)) {
//                    topCard = pop();
//                    this.addCard(topCard);

                    Solitare.tableau[i].addCard(Solitare.temp);
//                    Solitare.tableau[i].addCard(topCard);


//                    Solitare.temp = null;

                    System.out.println("RIGHT");
                    Solitare.clicked = false;
                }
            }


        }

        /*
        for (int i = 0; i < 4; i++) {

            if (Solitare.suitPile[i].canTake(topCard)) {
                Solitare.suitPile[i].addCard(topCard);

                if (!this.top().isFaceUp()) {
                    this.top().flip();
                }

                return;
            }
        }
        // else see if any other table pile can take card
        for (int i = 0; i < 7; i++) {

            if (Solitare.tableau[i].canTake(topCard)) {
                Solitare.tableau[i].addCard(topCard);

                if (!this.top().isFaceUp()) {
                    this.top().flip();
                }
                return;
            }
        }
        // else put it back on our pile*/
//        addCard(topCard);



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

    public void display (Graphics g) {
        stackDisplay(g, top());
    }

}
