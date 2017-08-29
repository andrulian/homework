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
        localy = stackDisplay(g, aCard.link);
        aCard.draw(g, x, localy);
        return localy + 35;
    }

    public void display(Graphics g) {
        stackDisplay(g, top());
    }

//------------

    public void select(int tx, int ty) {
//        System.out.println("PILE LENGTH: " + this.getLen());
//        System.out.println("CLOSED PILE LENGTH: " + this.getLen(false));



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

        if (!Solitare.clicked && this.includes(tx, ty)) { //false
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

        if (Solitare.clicked && this.includes(tx, ty)) { //true
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

//        group of cards
        if (!Solitare.clicked && this.groupIncludes(tx, ty)) { //false
            System.out.println("GROUP. Clicked status: " + Solitare.clicked);

//            System.out.println("--> "  + getGroup());

//            for (int i = 0; i < 7; i++) {
//                if (Solitare.tableau[i].canTake(topCard)) {
//                    System.out.println("CAN TAKE: " + i);
//
//                    Solitare.temp = pop();
//                    Solitare.thisCP = this;
//
//                    Solitare.clicked = true;
//                    System.out.println("clicked status: " + Solitare.clicked);
//                    return;
//                }
//            }
        }

        if (Solitare.clicked && this.groupIncludes(tx, ty)) { //true
            System.out.println("GROUP CLICKED. Clicked status: " + Solitare.clicked);
//
//            for (int i = 0; i < 7; i++) {
//                if (Solitare.tableau[i].groupIncludes(tx, ty) && !Solitare.tableau[i].canTake(Solitare.temp)) {
//                    Solitare.thisCP.addCard(Solitare.temp);
//                }
//
//                if (Solitare.tableau[i].canTake(Solitare.temp) && Solitare.tableau[i].groupIncludes(tx, ty)) {
//                    Solitare.tableau[i].addCard(Solitare.temp);
//
//                    if (!Solitare.thisCP.empty()) { Solitare.thisCP.top().flip(); }
//                }
//                Solitare.clicked = false;
//            }
        }


    }

//    @Override
    public boolean includes (int clickX, int clickY) {
        int topEdge = y + 35 * (this.getLen() - 1);
        boolean res = x <= clickX && clickX <= x + Card.width &&
                topEdge <= clickY && clickY <=  topEdge + Card.height;
        return res ? res : groupIncludes(clickX, clickY);

    }

    public boolean groupIncludes (int clickX, int clickY) {

        int topEdge = y + 35 * this.getLen(false);
        return x <= clickX && clickX <= x + Card.width &&
                topEdge <= clickY && clickY <= topEdge + 35;

    }

    public int getLen(boolean all) {
        int cnt = 0;
        Card iter = this.top();

        if (all) {
            while (iter != null) {
                iter = iter.link;
                cnt++;
            }

            return cnt;
        } else {
            while (iter != null) {
                if (!iter.isFaceUp()) { cnt++; }
                iter = iter.link;
            }

            return cnt;
        }

    }

    public int getLen() {
        return this.getLen(true);
    }

    public void getGroup() {
        Card iter = this.top();

        while (iter.isFaceUp()) {
            System.out.println("ITER");
            iter = iter.link;

            Solitare.tempPile.addCard(pop());
        }
    }


}

