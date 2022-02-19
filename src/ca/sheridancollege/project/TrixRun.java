
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Khalid Joraid
 */
public class TrixRun {
    public static void main(String[] args) {
        int handSize = Suit.values().length * Value.values().length;
        CardHand ch = new CardHand(handSize);
        TrixGame trix = new TrixGame("Trix");
        //TrixPlayer trixPlayers;
        ArrayList<TrixPlayer> players = new ArrayList<TrixPlayer>();
        players.add(new TrixPlayer("Khalid"));
        players.add(new TrixPlayer("Hannah"));
        players.add(new TrixPlayer("Omar"));
        players.add(new TrixPlayer("Adnan"));
        
        
        ch.generateHand();
        int i=0;
        for(TrixPlayer t:players)
        {
            System.out.println("The Player no "+ ++i +" is " +t.getName()+ "\n");
        }
        for(TrixCard c:ch.cards)
        {
            System.out.println(c.getValue()+" of "+c.getSuit());
        }
    }
}
