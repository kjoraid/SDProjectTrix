
package TrixCardsGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Khalid Joraid
 */
public class AllCards {
    //The group of cards, stored in an ArrayList
    private ArrayList<Card> allCards = new ArrayList<>();
    private int size;//the size of the grouping

    public AllCards(int size) {
        this.size = size;
        CreateAllCards();
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }
    
    public void CreateAllCards(){
        for(Suit s:Suit.values())
        {
            for(Value v: Value.values() )
            {                
                this.allCards.add(new TrixCard(s ,v));
            }
        }
        //Random shuffling
        shuffle();     
    }
    
    public void shuffle() {
        Collections.shuffle(allCards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}
