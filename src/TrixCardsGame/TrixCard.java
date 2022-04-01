
package TrixCardsGame;

/**
 *
 * @author Khalid Joraid
 */
public class TrixCard  extends Card {
    private final Suit suit;
    private final Value value;
    
    public TrixCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
 
    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }
    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "";
    }
    
}

