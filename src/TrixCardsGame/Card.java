/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package TrixCardsGame;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * Modifier: Khalid Joraid, Feb 18, 2022
 */

public abstract class Card {
    //default modifier for child classes
    private final Suit suit;
    private final Value value;
    

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    public Card(Suit suit, Value value) {
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
    public abstract String toString();

}
