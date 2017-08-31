package solitaire;

public class TempPile extends CardPile{

    TempPile(int xCoord, int yCoord) {
        super(xCoord, yCoord);
    }

    public int getLen() {
        Card topCard = top();
        int len = 0;

        while (topCard.link != null) {
            topCard = topCard.link;
            len++;
        }

        return len;
    }

    @Override
    public boolean includes (int clickX, int clickY) {

        return x <= clickX && clickX <= x + Card.width &&
                y <= clickY && clickY <= y + Card.height;
    }


}
