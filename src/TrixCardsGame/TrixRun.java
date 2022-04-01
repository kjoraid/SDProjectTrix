
package TrixCardsGame;

import java.util.ArrayList;

/**
 *
 * @author Khalid Joraid
 */
public class TrixRun {
    public static void main(String[] args) {
        int handSize = Suit.values().length * Value.values().length;
        GroupOfCards goc = new GroupOfCards(handSize);
        TrixGame trix = new TrixGame("Trix");
        
        //TrixPlayer trixPlayers;
        ArrayList<TrixPlayer> players = new ArrayList<TrixPlayer>();
        players.add(new TrixPlayer("Khalid"));
        players.add(new TrixPlayer("Hannah"));
        players.add(new TrixPlayer("Omar"));
        players.add(new TrixPlayer("Adnan"));

        int i=0;
        for(TrixPlayer t:players)
        {
            System.out.println("The Player no "+ ++i +" is " +t.getName()+ "\n");
        }
        for(TrixCard cc:goc.getCards())
        {

            System.out.println(cc.getValue()+" of "+cc.getSuit() );
        }
    }
}
