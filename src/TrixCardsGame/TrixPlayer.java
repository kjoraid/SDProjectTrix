
package TrixCardsGame;

import java.util.ArrayList;


/**
 *
 * @author Khalid Joraid
 */
public class TrixPlayer extends Player{
    private int PlayerScore=0;
    private boolean currentKingdome; 
    private int currentPlayer;
    
    
    public TrixPlayer(String name) {
        super(name);
    }
    public void setPlayerScore(int score){
        this.PlayerScore += score;
    }
    public int getPlayerScore(){
        return this.PlayerScore;
    } 
    public boolean isCurrentKingdome() {
        return currentKingdome;
    }
    public void setCurrentKingdome(boolean currentKingdome) {
        this.currentKingdome = currentKingdome;
    }
    public void setCurrentPlayer(int firstPlayer) {
        this.currentPlayer = firstPlayer;
    }
    public int getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public void play() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //System.out.print(getName()+" ");
  
            
    }

 

}
