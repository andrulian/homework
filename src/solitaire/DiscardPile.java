package solitaire;

class DiscardPile extends CardPile {

    DiscardPile (int x, int y) { super (x, y); }

    public void addCard (Card aCard) {
        if (! aCard.isFaceUp())
            aCard.flip();
        super.addCard(aCard);
    }

    public void select (int tx, int ty) {
        if (empty())
            return;
        Card topCard = pop();
        for (int i = 0; i < 4; i++)
            if (Solitare.suitPile[i].canTake(topCard)) {
                Solitare.suitPile[i].addCard(topCard);
                return;
            }

        for (int i = 0; i < 7; i++)
            if (Solitare.tableau[i].canTake(topCard)) {
                Solitare.tableau[i].addCard(topCard);
                return;
            }
        // nobody can use it, put it back on our list
        addCard(topCard);
    }
}
