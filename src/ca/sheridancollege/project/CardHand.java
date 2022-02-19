
package ca.sheridancollege.project;

/**
 *
 * @author Khalid Joraid
 */
public class CardHand {
    private int handSize;
    public TrixCard[] cards;
    
    //A method which generate a deck of cards
    
    public void generateHand()
    {
        int countCards=0;
        for(Suit s:Suit.values())
        {
            for(Value v: Value.values() )
            {
                cards[countCards]=new TrixCard(s,v);
                countCards++;            
            }
        }
    }

    public CardHand(int handSize) {
        this.handSize = handSize;
        cards = new TrixCard[handSize];
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }
}
