package solitaire;

import java.awt.*;

class Card {

    // data fields for colors and suits
    final static int width = 50;
    final static int height = 70;

    final static int red = 0;
    final static int black = 1;

    final static int heart = 0;
    final static int spade = 1;
    final static int diamond = 2;
    final static int club = 3;

    private static String names[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    // data fields
    private int rank;
    private int suit;
    private boolean faceup;

    Card link;
    Card prevLink;

    // constructor
    Card (int sv, int rv) {
        suit = sv;
        rank = rv;
        faceup = false;
    }

    // access attributes of card
    public int getRank() { return rank; }

    public int getSuit() { return suit; }

    public boolean isFaceUp() { return faceup; }

    public void flip() { faceup = ! faceup; }

    public int getColor() {
        if (getSuit() == heart || getSuit() == diamond)
            return red;
        return black;
    }

    public void draw (Graphics g, int x, int y) { // x , y - left high corner
        // clear rectangle, draw border
        g.clearRect(x, y, width, height);
        g.setColor(Color.blue);
//        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        // draw body of card
        if (isFaceUp()) {
            if (getColor() == red)
                g.setColor(Color.red);
            else
                g.setColor(Color.black);
            g.drawString(names[getRank()], x+3, y+15);


            switch (getSuit()) {
                case heart:
                    g.drawLine(x + 25, y + 30, x + 35, y + 20);
                    g.drawLine(x + 35, y + 20, x + 45, y + 30);
                    g.drawLine(x + 45, y + 30, x + 25, y + 60);
                    g.drawLine(x + 25, y + 60, x + 5, y + 30);
                    g.drawLine(x + 5, y + 30, x + 15, y + 20);
                    g.drawLine(x + 15, y + 20, x + 25, y + 30);
                    break;
                case spade:
                    g.drawLine(x + 25, y + 20, x + 40, y + 50);
                    g.drawLine(x + 40, y + 50, x + 10, y + 50);
                    g.drawLine(x + 10, y + 50, x + 25, y + 20);
                    g.drawLine(x + 23, y + 45, x + 20, y + 60);
                    g.drawLine(x + 20, y + 60, x + 30, y + 60);
                    g.drawLine(x + 30, y + 60, x + 27, y + 45);
                    break;
                case diamond:
                    g.drawLine(x + 25, y + 20, x + 40, y + 40);
                    g.drawLine(x + 40, y + 40, x + 25, y + 60);
                    g.drawLine(x + 25, y + 60, x + 10, y + 40);
                    g.drawLine(x + 10, y + 40, x + 25, y + 20);
                    break;
                case club:
                    g.drawOval(x + 20, y + 25, 10, 10);
                    g.drawOval(x + 25, y + 35, 10, 10);
                    g.drawOval(x + 15, y + 35, 10, 10);
                    g.drawLine(x + 23, y + 45, x + 20, y + 55);
                    g.drawLine(x + 20, y + 55, x + 30, y + 55);
                    g.drawLine(x + 30, y + 55, x + 27, y + 45);
                    break;
            }
        }
        else { // face down

            g.setColor(Color.magenta);
            g.drawOval(x + 10, y + 20, 30, 30);

//            g.drawLine(x+15, y+5, x+15, y+65);
//            g.drawLine(x+35, y+5, x+35, y+65);
//            g.drawLine(x+5, y+20, x+45, y+20);
//            g.drawLine(x+5, y+35, x+45, y+35);
//            g.drawLine(x+5, y+50, x+45, y+50);
        }
    }
}
