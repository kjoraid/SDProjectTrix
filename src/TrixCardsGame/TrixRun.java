
package TrixCardsGame;

import java.util.ArrayList;

/**
 *
 * @author Khalid Joraid
 */
public class TrixRun {
    private static GroupOfCards Player01Cards;
    private static GroupOfCards Player02Cards;
    private static GroupOfCards Player03Cards;
    private static GroupOfCards Player04Cards;
    private static AllCards allCards;
    private static int handSize;
    public static void main(String[] args) {
        
        setAllCards(handSize);
        //allCards = new AllCards(handSize);
        // Create the Game Name
        // Create the 52 cards and suffling them randomly
        TrixRun trixrun = new TrixRun();
        trixrun.startPlayTrix();
 
    }

    public static int getHandSize(){
        return (Suit.values().length * Value.values().length);
    }
    public static void setAllCards(int handSize) {
        allCards = new AllCards(handSize);
    }
    
    public static void setPlayer01Cards(){
        //AllCards allCards = new AllCards(handSize);
        Player01Cards = new GroupOfCards(13, allCards.getAllCards());
    
    }
    public static GroupOfCards getPlayer01Cards(){
        return Player01Cards;    
    }
     public static void setPlayer02Cards(){
        //AllCards allCards = new AllCards(handSize);
        Player02Cards = new GroupOfCards(26, allCards.getAllCards());
    
    }
    public static GroupOfCards getPlayer02Cards(){
        return Player02Cards;    
    }
    public static void setPlayer03Cards(){
        //AllCards allCards = new AllCards(handSize);
        Player03Cards = new GroupOfCards(39, allCards.getAllCards());
    
    }
    public static GroupOfCards getPlayer03Cards(){
        return Player03Cards;    
    }
    public static void setPlayer04Cards(){
        //AllCards allCards = new AllCards(handSize);
        Player04Cards = new GroupOfCards(52, allCards.getAllCards());
    }
    public static GroupOfCards getPlayer04Cards(){
        return Player04Cards;    
    }
    private static void startPlayTrix() {
        //throw new UnsupportedOperationException("Not supported yet.");
        TrixGame trixGame = new TrixGame("Trix");
          
        setPlayer01Cards();
        setPlayer02Cards();
        setPlayer03Cards();
        setPlayer04Cards();

        int i=0;
        for(Player p:trixGame.getPlayers())
        {
            System.out.println("The Player no "+ ++i +" is " +p.getName()+ "\n");
        }
        // Print first Player's cards
        trixGame.getPlayers().get(0).setCurrentKingdome(false);
        trixGame.getPlayers().get(1).setCurrentKingdome(false);
        trixGame.getPlayers().get(2).setCurrentKingdome(false);
        trixGame.getPlayers().get(3).setCurrentKingdome(false);
        
        for(Card cc:Player01Cards.setCards())
        {
            if (cc.getSuit()==Suit.Hearts && 
               cc.getValue()==Value.SEVEN)
               trixGame.getPlayers().get(0).setCurrentKingdome(true);
               trixGame.getPlayers().get(0).setCurrentPlayer(0);
            //System.out.println(cc.getValue()+" of "+cc.getSuit() );
        }
        // Print Second Player's cards
        System.out.println("======================" );
        for(Card cc:Player02Cards.setCards())
        {
           if (cc.getSuit()==Suit.Hearts && 
               cc.getValue()==Value.SEVEN)
                trixGame.getPlayers().get(1).setCurrentKingdome(true);
                trixGame.getPlayers().get(0).setCurrentPlayer(1);
            //System.out.println(cc.getValue()+" of "+cc.getSuit() );
        }
        // Print third Player's cards
        System.out.println("======================" );
        for(Card cc:Player03Cards.setCards())
        {
        if (cc.getSuit()==Suit.Hearts && 
            cc.getValue()==Value.SEVEN)
            trixGame.getPlayers().get(2).setCurrentKingdome(true);
            trixGame.getPlayers().get(0).setCurrentPlayer(2);
            //System.out.println(cc.getValue()+" of "+cc.getSuit() );
        }       
        // Print fourth Player's cards
        System.out.println("======================" );
        for(Card cc:Player04Cards.setCards())
        {
        if (cc.getSuit()==Suit.Hearts && 
            cc.getValue()==Value.SEVEN)
            trixGame.getPlayers().get(3).setCurrentKingdome(true);
            trixGame.getPlayers().get(0).setCurrentPlayer(3);
            //System.out.println(cc.getValue()+" of "+cc.getSuit() );
        }
    trixGame.play();
    }
}
