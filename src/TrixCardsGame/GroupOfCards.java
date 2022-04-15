/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package TrixCardsGame;


import java.util.ArrayList;
import java.util.Collections;
import javax.xml.transform.Source;
import sun.jvm.hotspot.runtime.PerfMemory;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * Modifier Khalid Joraid March 2022
 */
public class GroupOfCards {
    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> allCards = new ArrayList<>();
    private int size;//the size of the grouping


    public GroupOfCards(int size, ArrayList allCard) {
        this.size = size;
        this.allCards = allCard;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> setCards() {
        cards.clear();
        //TrixRun.Allcards shuffle();
        for (int i=(size-13); i<size;i++){
            cards.add(allCards.get(i));
        }
        sortCards();
        return cards;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void sortCards(){
        ArrayList<Card> sortedCards = new ArrayList<Card>();

        int j=0;
        
            for (Suit s:Suit.values())
                {
                for(Value v:Value.values())
                {
                   for (int i=0; i<cards.size();i++){
                        if (cards.get(i).getSuit()==s && cards.get(i).getValue()==v)
                        {
                            sortedCards.add(cards.get(i));
                            j++;
                            cards.remove(i);
                        }
                    }
                }
            }
            for (Card sc:sortedCards)
               //System.out.println(sc.getSuit()+"--"+sc.getValue());
            cards = (ArrayList<Card>)sortedCards.clone();
    }
            
    public void deleteCards(int index) {
        cards.remove(index);
    }
    

    //public void shuffle() {
    //    Collections.shuffle(Cards);
    //}

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

}//end class
