package solitaire;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Solitare extends Applet{// implements MouseListener, MouseMotionListener {
    static DeckPile deckPile;
    static DiscardPile discardPile;
    static TablePile tableau[];
    static SuitPile suitPile[];
    static CardPile allPiles[];

    static CardStorage cardStorage;

    public void init() {
//        setBackground(Color.lightGray);
        this.setSize(391, 550);

        cardStorage = new CardStorage();
        // first allocate the arrays
        allPiles = new CardPile[13];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 5);
        allPiles[1] = discardPile = new DiscardPile(268, 5);

//        make piles for suits
        for (int i = 0; i < 4; i++)
            allPiles[2+i] = suitPile[i] =
                    new SuitPile(15 + 60 * i, 5);

        for (int i = 0; i < 7; i++)
            allPiles[6+i] = tableau[i] =
                    new TablePile(5 + 55 * i, 80, i+1);


        addMouseListener(new mouseClicks());
//        addMouseMotionListener(new mouseMotions());

//        addMouseListener(this); interfaces !!!!
//        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 13; i++)
            allPiles[i].display(g);
            cardStorage.display(g); // TODO condition if null
    }

    public void clickHandle (MouseEvent e) {
        int mX = e.getX();
        int mY = e.getY();

        for (int i = 0; i < 13; i++) {
            if (allPiles[i].includes(mX, mY)) {
                allPiles[i].select(mX, mY);
                repaint();
            }
        }
    }

//    Перебираются все стопки и у каждой спрашивается попадает ли клик в нее
//    public boolean mouseDown(Event evt, int x, int y) {
//        for (int i = 0; i < 13; i++)
//            if (allPiles[i].includes(x, y)) {
//                allPiles[i].select(x, y);
//                repaint(); // вызывает paint() и все стопки перерисовываются
//                return true;
//            }
//        return true;
//    }

    private class mouseClicks extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
//            System.out.println("Released");

        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            System.out.println("Clicked");
            clickHandle(e);
            repaint();
        }

    }

    private class mouseMotions extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("Dragged");
        }
    }
}
