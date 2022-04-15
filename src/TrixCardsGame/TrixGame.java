
package TrixCardsGame;


import com.sun.tools.example.debug.expr.ExpressionParserConstants;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Khalid Joraid
 */
public class TrixGame extends Game{
    String tableDeck[][] = new String[4][14];  
    Scanner input = new Scanner(System.in);
    int KingdomeWinnerPoints;
    String gameTitleLine="";
    

    public TrixGame(String name) {
        super(name);
        initiatPlayers();
        tableDeck[0][0] = "Clubs";
        tableDeck[1][0] = "Dimonds";
        tableDeck[2][0] = "Hearts";
        tableDeck[3][0] = "Spades";
        resetTableDeck();
       
    }
    public void initiatPlayers(){
        ArrayList<TrixPlayer> players = new ArrayList<TrixPlayer>();
        players.add(new TrixPlayer("Khalid"));
        players.add(new TrixPlayer("Player-2"));
        players.add(new TrixPlayer("Player-3"));
        players.add(new TrixPlayer("Player-4"));
        super.setPlayers(players);
    }

    @Override
    public void play() {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        

        //Check the first kingdome
        int index, kingdomeIndex, kingdomeSerial;
        if (getPlayers().get(0).isCurrentKingdome())
            kingdomeIndex=1;
        else if (getPlayers().get(1).isCurrentKingdome())
            kingdomeIndex=2;
        else if (getPlayers().get(2).isCurrentKingdome())
            kingdomeIndex=3;
        else
            kingdomeIndex=4;
        // Do while ==> rotate four times starting with the current Kingdome
        // for i ==> 13 cards need to be played
        // for j ==> each player should play a card (if exist)in each (for i) round

        kingdomeSerial=1;
        do {            
            //for (int i=0;i<=12;i++){
            KingdomeWinnerPoints=200;
            do 
            {
                index=kingdomeIndex;
                
                gameTitleLine="Game Name: "+getName()+"\t\t\t\t\t\tKingdome #: "+kingdomeSerial+"\t\t\t\t\tKingdome Owner Name: "+getPlayers().get(index-1).getName();
                displayTrixTable();        
                playACard(kingdomeIndex);
            } while (TrixRun.getPlayer01Cards().getCards().size()>0 || TrixRun.getPlayer02Cards().getCards().size()>0 || TrixRun.getPlayer03Cards().getCards().size()>0 || TrixRun.getPlayer04Cards().getCards().size()>0);
                
            
            if (kingdomeIndex==4)
                kingdomeIndex=1;
            else
                kingdomeIndex++;
            
            kingdomeSerial++;
            
            if (kingdomeSerial<5)
                newShuffleForNewKingdome(kingdomeIndex-1);
            
            if(kingdomeSerial==5)
            {
                // When The Game Over
                displayTrixTable();
                declareWinner();
            }
        } while (kingdomeSerial<5);
    }
    
    public void newShuffleForNewKingdome(int kingdomeIndex){
        
        //if (kingdomeIndex==0)
        getPlayers().get(kingdomeIndex).setCurrentKingdome(true);
        TrixRun.setAllCards(TrixRun.getHandSize());
        
        TrixRun.setPlayer01Cards();
        TrixRun.setPlayer02Cards();
        TrixRun.setPlayer03Cards();
        TrixRun.setPlayer04Cards();
        
        TrixRun.getPlayer01Cards().setCards();
        TrixRun.getPlayer02Cards().setCards();
        TrixRun.getPlayer03Cards().setCards();
        TrixRun.getPlayer04Cards().setCards();

        resetTableDeck();    
    }
    
    public void resetTableDeck(){
        for (int i=0;i<4;i++)
            for (int j=1;j<14;j++)
            tableDeck[i][j]= "-----";

    }
    
    public void playACard(int kingdomeIndex){
        if (kingdomeIndex==1){
            if (TrixRun.getPlayer01Cards().getCards().size()>0){firstPlayerAction();displayTrixTable();}    
            if (TrixRun.getPlayer02Cards().getCards().size()>0) {secondPlayerAction();displayTrixTable();}
            if (TrixRun.getPlayer03Cards().getCards().size()>0){thirdPlayerAction();displayTrixTable(); }
            if (TrixRun.getPlayer04Cards().getCards().size()>0){fourthPlayerAction();displayTrixTable();} 
        }
        else if (kingdomeIndex==2){
            if (TrixRun.getPlayer02Cards().getCards().size()>0) {secondPlayerAction();displayTrixTable();}
            if (TrixRun.getPlayer03Cards().getCards().size()>0){thirdPlayerAction();displayTrixTable(); }
            if (TrixRun.getPlayer04Cards().getCards().size()>0){fourthPlayerAction();displayTrixTable();} 
            if (TrixRun.getPlayer01Cards().getCards().size()>0){firstPlayerAction();displayTrixTable();}
        }
        else if(kingdomeIndex==3){
            if (TrixRun.getPlayer03Cards().getCards().size()>0){thirdPlayerAction();displayTrixTable(); }
            if (TrixRun.getPlayer04Cards().getCards().size()>0){fourthPlayerAction();displayTrixTable();} 
            if (TrixRun.getPlayer01Cards().getCards().size()>0){firstPlayerAction();displayTrixTable();}
            if (TrixRun.getPlayer02Cards().getCards().size()>0) {secondPlayerAction();displayTrixTable();}
        }
        else{
            if (TrixRun.getPlayer04Cards().getCards().size()>0){fourthPlayerAction();displayTrixTable();} 
            if (TrixRun.getPlayer01Cards().getCards().size()>0){firstPlayerAction();displayTrixTable();}
            if (TrixRun.getPlayer02Cards().getCards().size()>0) {secondPlayerAction();displayTrixTable();}
            if (TrixRun.getPlayer03Cards().getCards().size()>0){thirdPlayerAction();displayTrixTable(); }
        }
    }
    public void firstPlayerAction(){
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // This is the user player, the player index = 0
        int i=0,j=0,selection=0;
        boolean repeateSelection=false;
        do {   
        
            System.out.println("Choose one of the Cards, the number appears infront of each card, or enter 123 to Pass if you have no card to pay ");
                    //+TrixRun.getPlayer01Cards().getCards().size());
            try {
                selection = input.nextInt();
            } catch (Exception e) {
                repeateSelection=true;
                System.out.println("Please enter a valid integer");
                input.nextLine();
            }
 
            if (selection>=0 && selection < TrixRun.getPlayer01Cards().getCards().size())
            {
                //System.out.println(TrixRun.getPlayer01Cards().getCards().size());
                //System.out.println(TrixRun.getPlayer01Cards().getCards().get(selection).getSuit());
                //System.out.println(TrixRun.getPlayer01Cards().getCards().get(selection).getValue());
                // check if the card is appropreate

                // Find i
                i=whichSuitWasSelected(TrixRun.getPlayer01Cards(),selection);
                // Find j
                j=whichValueWasSelected(TrixRun.getPlayer01Cards(),selection);
                
                // Game Rule should be checked here before play a card
                if (playedCardAccepted(i,j)) {
                    //
                    repeateSelection=false;
                    tableDeck[i][j]=""+TrixRun.getPlayer01Cards().getCards().get(selection).getValue();
                    // delete the card from the player Cards after playing it
                    TrixRun.getPlayer01Cards().deleteCards(selection);
                    if (TrixRun.getPlayer01Cards().getCards().size()==0)
                    {
                       System.out.println("The points for player 01---> "+KingdomeWinnerPoints);
                       getPlayers().get(0).setPlayerScore(KingdomeWinnerPoints);
                       KingdomeWinnerPoints-=50;
                    }
                }
                else {
                    repeateSelection=true;
                    System.out.println("Card is not correct, please play another card, or enter 123 to Pass if you have no card to pay");
                }
            } 
            else if (selection==123) // Check if the Pass is correct, means there is no card to play
                {
                    //System.out.println(is123PassCorrect());
                    if (is123PassCorrect())
                    {
                        repeateSelection=false;
                    }
                    else
                    {
                        System.out.println("You chose 123 to pass your turn, "
                            + "but you still have card to play, please check and play a card");
                        repeateSelection=true;   
                    }
                }
            else 
            {
                repeateSelection=true;
                System.out.println("Please choose card within the range"+ selection);
            }
        }
        while (repeateSelection);
        
    }
    public boolean playedCardAccepted(int i, int j){
        if (j!=4) // Means Jack
        {
            if (j<4) 
            {
                if(tableDeck[i][j+1]=="-----")// check if the next slot is empty
                {
                    return false;
                }
            }
            else
            {
                if(tableDeck[i][j-1]=="-----") // check if the previouse slot is empty
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int whichSuitWasSelected(GroupOfCards trixRunPlayer, int selection){
        int i=0;
        if (trixRunPlayer.getCards().get(selection).getSuit()==Suit.Clubs)
            i=0;
        if (trixRunPlayer.getCards().get(selection).getSuit()==Suit.Diamonds)
            i=1;
        if (trixRunPlayer.getCards().get(selection).getSuit()==Suit.Hearts)
            i=2;
        if (trixRunPlayer.getCards().get(selection).getSuit()==Suit.Spades)
            i=3;  
    return i;
    }
    public int whichValueWasSelected(GroupOfCards trixRunPlayer, int selection){
        int j=0;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.ACE)
            j=1;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.KING)
            j=2;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.QUEEN)
            j=3;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.JACK)
            j=4;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.TEN)
            j=5;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.NINE)
            j=6;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.EIGHT)
            j=7;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.SEVEN)
            j=8;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.SIX)
            j=9;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.FIVE)
            j=10; 
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.FOUR)
            j=11; 
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.THREE)
            j=12;
        if (trixRunPlayer.getCards().get(selection).getValue()==Value.TWO)
            j=13;
    return j;
    }
            
    public boolean is123PassCorrect(){
        boolean passIsCorrect=true;
        for (int i=0; i<TrixRun.getPlayer01Cards().getCards().size();i++)
        {
            if (whichValueWasSelected(TrixRun.getPlayer01Cards(),i)==4)
            {
                passIsCorrect=false;
            }
            else if((whichValueWasSelected(TrixRun.getPlayer01Cards(),i)<4))
            {
                if (tableDeck[whichSuitWasSelected(TrixRun.getPlayer01Cards(),i)][whichValueWasSelected(TrixRun.getPlayer01Cards(),i)+1]!="-----")
                    passIsCorrect=false;
            }
            else if((whichValueWasSelected(TrixRun.getPlayer01Cards(),i)>4))
            {    
                if (tableDeck[whichSuitWasSelected(TrixRun.getPlayer01Cards(),i)][whichValueWasSelected(TrixRun.getPlayer01Cards(),i)-1]!="-----")
                        passIsCorrect=false;
            }
        }
        return passIsCorrect;
    }
    public void secondPlayerAction() {
        System.out.println("Player2");
        int s=0,val=0,v=0;
        boolean CardAlreadyPlayed = false;
        // if there is a smaller card = 2 from any suite
        while (!CardAlreadyPlayed){
            System.out.println("Player2 - Thinking .");
            for (int i=0; i<TrixRun.getPlayer02Cards().getCards().size();i++)
            {
                s= whichSuitWasSelected(TrixRun.getPlayer02Cards(), i);
                val=whichValueWasSelected(TrixRun.getPlayer02Cards(),i);
                if (val==13) // There is 2
                    //play card from these suit
                    if (playCardFromThisSuite(TrixRun.getPlayer02Cards(), s))
                    {
                       CardAlreadyPlayed=true;
                       break;
                    }
                       
            }
            break;
        }
        //if there are more than 5 cards from the same suit
        while (!CardAlreadyPlayed)
        {
            System.out.println("Player2 - Thinking ..");
            int clubs=0, dimonds=0,hearts=0,spades=0;
            for (int i=0; i<TrixRun.getPlayer02Cards().getCards().size();i++)
            {
                s= whichSuitWasSelected(TrixRun.getPlayer02Cards(), i);
                val=whichValueWasSelected(TrixRun.getPlayer02Cards(),i);
                if (s==0) // Clubs
                    clubs++;
                else if(s==1)
                    dimonds++;
                else if(s==2)
                    hearts++;
                else
                    spades++;
            }
                //-----------
                if (clubs>=5)
                    if (playCardFromThisSuite(TrixRun.getPlayer02Cards(), 0))
                        CardAlreadyPlayed=true;
                if (dimonds>=5)
                    if (playCardFromThisSuite(TrixRun.getPlayer02Cards(), 1))
                        CardAlreadyPlayed=true;
                if (hearts>=5)
                    if (playCardFromThisSuite(TrixRun.getPlayer02Cards(), 2))
                        CardAlreadyPlayed=true;
                if (spades>=5)
                    if (playCardFromThisSuite(TrixRun.getPlayer02Cards(), 3))
                        CardAlreadyPlayed=true;
                break;
        }
        while (!CardAlreadyPlayed){
            System.out.println("Player2 - Thinking ...");
            // Play any card that find a slot, there is no periority
            if (playCardFromThisSuite(TrixRun.getPlayer02Cards(), 4))
                CardAlreadyPlayed=true;
            break;
        }
        while (!CardAlreadyPlayed){
            System.out.println("Player2 - Thinking ....");
            // Pass, There is no card to  play
            System.out.println("Player2 - Pass .....");
            CardAlreadyPlayed=true;
            break;
        }
        if (CardAlreadyPlayed && TrixRun.getPlayer02Cards().getCards().size()==0){
            System.out.println("The points for player 02---> "+KingdomeWinnerPoints);
            getPlayers().get(1).setPlayerScore(KingdomeWinnerPoints);
            KingdomeWinnerPoints-=50;
        }
    }
    public void thirdPlayerAction() {
        System.out.println("Player3");
        int s=0,val=0,v=0;
        boolean CardAlreadyPlayed = false;
        // if there is a smaller card = 2 from any suite
        while (!CardAlreadyPlayed){
            System.out.println("Player3 - Thinking .");
            for (int i=0; i<TrixRun.getPlayer03Cards().getCards().size();i++)
            {
                s= whichSuitWasSelected(TrixRun.getPlayer03Cards(), i);
                val=whichValueWasSelected(TrixRun.getPlayer03Cards(),i);
                if (val==13) // There is 2
                    //play card from these suit
                    if (playCardFromThisSuite(TrixRun.getPlayer03Cards(), s))
                    {
                       CardAlreadyPlayed=true;
                       break;
                    }
                       
            }
            break;
        }
        //if there are more than 5 cards from the same suit
        while (!CardAlreadyPlayed)
        {
            System.out.println("Player3 - Thinking ..");
            int clubs=0, dimonds=0,hearts=0,spades=0;
            for (int i=0; i<TrixRun.getPlayer03Cards().getCards().size();i++)
            {
                s= whichSuitWasSelected(TrixRun.getPlayer03Cards(), i);
                val=whichValueWasSelected(TrixRun.getPlayer03Cards(),i);
                if (s==0) // Clubs
                    clubs++;
                else if(s==1)
                    dimonds++;
                else if(s==2)
                    hearts++;
                else
                    spades++;
            }
                //-----------
                if (clubs>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer03Cards(), 0))
                        CardAlreadyPlayed=true;
                if (dimonds>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer03Cards(), 1))
                        CardAlreadyPlayed=true;
                if (hearts>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer03Cards(), 2))
                        CardAlreadyPlayed=true;
                if (spades>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer03Cards(), 3))
                        CardAlreadyPlayed=true;
                break;
        }
        while (!CardAlreadyPlayed){
            System.out.println("Player3 - Thinking ...");
            // Play any card that find a slot, there is no periority
            if (playCardFromThisSuite(TrixRun.getPlayer03Cards(), 4))
                CardAlreadyPlayed=true;
            break;
        }
        while (!CardAlreadyPlayed){
            System.out.println("Player3 - Thinking ....");
            // Pass, There is no card to  play
            System.out.println("Player3 - Pass .....");
            CardAlreadyPlayed=true;
            break;
        }
        if (CardAlreadyPlayed && TrixRun.getPlayer03Cards().getCards().size()==0){
            System.out.println("The points for player 03---> "+KingdomeWinnerPoints);
            getPlayers().get(2).setPlayerScore(KingdomeWinnerPoints);
            KingdomeWinnerPoints-=50;
        }

    }
    
    public void fourthPlayerAction() {
        System.out.println("Player4");
        int s=0,val=0,v=0;
        boolean CardAlreadyPlayed = false;
        // if there is a smaller card = 2 from any suite
        while (!CardAlreadyPlayed){
            System.out.println("Player4 - Thinking .");
            for (int i=0; i<TrixRun.getPlayer04Cards().getCards().size();i++)
            {
                s= whichSuitWasSelected(TrixRun.getPlayer04Cards(), i);
                val=whichValueWasSelected(TrixRun.getPlayer04Cards(),i);
                if (val==13) // There is 2
                    //play card from these suit
                    if (playCardFromThisSuite(TrixRun.getPlayer04Cards(), s))
                    {
                       CardAlreadyPlayed=true;
                       break;
                    }
                       
            }
            break;
        }
        //if there are more than 5 cards from the same suit
        while (!CardAlreadyPlayed)
        {
            System.out.println("Player4 - Thinking ..");
            int clubs=0, dimonds=0,hearts=0,spades=0;
            for (int i=0; i<TrixRun.getPlayer04Cards().getCards().size();i++)
            {
                s= whichSuitWasSelected(TrixRun.getPlayer04Cards(), i);
                val=whichValueWasSelected(TrixRun.getPlayer04Cards(),i);
                if (s==0) // Clubs
                    clubs++;
                else if(s==1)
                    dimonds++;
                else if(s==2)
                    hearts++;
                else
                    spades++;
            }
                //-----------
                if (clubs>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer04Cards(), 0))
                        CardAlreadyPlayed=true;
                if (dimonds>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer04Cards(), 1))
                        CardAlreadyPlayed=true;
                if (hearts>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer04Cards(), 2))
                        CardAlreadyPlayed=true;
                if (spades>=4)
                    if (playCardFromThisSuite(TrixRun.getPlayer04Cards(), 3))
                        CardAlreadyPlayed=true;
                break;
        }
        while (!CardAlreadyPlayed){
            System.out.println("Player4 - Thinking ...");
            // Play any card that find a slot, there is no periority
            if (playCardFromThisSuite(TrixRun.getPlayer04Cards(), 4))
                CardAlreadyPlayed=true;
            break;
        }
        while (!CardAlreadyPlayed){
            System.out.println("Player4 - Thinking ....");
            // Pass, There is no card to  play
            System.out.println("Player4 - Pass .....");
            CardAlreadyPlayed=true;
            break;
        }
        if (CardAlreadyPlayed && TrixRun.getPlayer04Cards().getCards().size()==0){
            System.out.println("The points for player 04---> "+KingdomeWinnerPoints);
            getPlayers().get(3).setPlayerScore(KingdomeWinnerPoints);
            KingdomeWinnerPoints-=50;
        }
    }

    
    public boolean playCardFromThisSuite(GroupOfCards trixRunPlayer, int suit){
    int v;
    boolean playAnyFitCard=false;
    if (suit==4)
        playAnyFitCard=true;
    
    for (int j=0; j<trixRunPlayer.getCards().size();j++)
    {
        
        v= whichValueWasSelected(trixRunPlayer,j);
        //Suite = 4 means any suit
            if (playAnyFitCard)
                suit=whichSuitWasSelected(trixRunPlayer,j);
            //System.out.println(whichSuitWasSelected(trixRunPlayer, j)+"====="+suit);
            if (whichSuitWasSelected(trixRunPlayer, j)==suit)
            {
                //System.out.println(trixRunPlayer);
                //System.out.println(trixRunPlayer.getCards().get(j).getValue());
                //System.out.println(trixRunPlayer.getCards().get(j).getSuit());
                if (v==4) //Jack
                {
                    tableDeck[suit][4]=""+trixRunPlayer.getCards().get(j).getValue();
                    trixRunPlayer.deleteCards(j);
                    return true;
                }
                else if (v>4) // Value of 10 or less
                {
                    if(tableDeck[suit][v-1]!="-----") // check if the previouse slot is empty
                    {
                         tableDeck[suit][v]=""+trixRunPlayer.getCards().get(j).getValue();
                         trixRunPlayer.deleteCards(j);
                         return true;
                    }
                }
                else if (v<4) // Value above Jack
                {
                    if(tableDeck[suit][v+1]!="-----") // check if the Next slot is empty
                    {
                         tableDeck[suit][v]=""+trixRunPlayer.getCards().get(j).getValue();
                         trixRunPlayer.deleteCards(j);
                         return true;
                    }
                }
            }
    }
    return false;
}
    @Override
    public void declareWinner() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String winnerPlayer="";
        int winnerIndex=0;
        int winnerScore=getPlayers().get(0).getPlayerScore();
        for(int i=0;i<4;i++)
        {
            if (getPlayers().get(i).getPlayerScore()> winnerScore)
            {
                winnerScore=getPlayers().get(i).getPlayerScore();
                winnerIndex = i;
            }
        }
        
        winnerPlayer=getPlayers().get(winnerIndex).getName();

        System.out.println("Game Over");
        System.out.println("The winner is "+winnerPlayer);
        System.out.println("Congratulations..."+winnerPlayer);
    }

    private void displayTrixTable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
        String line1,line2,line3;
        int i = 0;
        boolean initiateComplete = false;
        do {
            line1=gameTitleLine;
            line1+="\n\n";
            line1+="\t\t\t\t\t\t\t";
            line1+=getPlayers().get(2).getName()+"["+getPlayers().get(2).getPlayerScore()+"]"+"Cards("+TrixRun.getPlayer03Cards().getCards().size()+")" ;
            line1+="\t\t\t\t\t\t\t\t";
            line1+="\n\n";
            for (i=0;i<=6;i++){
                //for (int j=0;j<=13;j++)
                line1+= "\t\t\t\t"+tableDeck[0][i]+"\t\t"+tableDeck[1][i]+"\t\t"+tableDeck[2][i]+"\t\t"+tableDeck[3][i];
                line1+="\n";
            }
   
            line1+= getPlayers().get(3).getName()+"["+getPlayers().get(3).getPlayerScore()+"]"+"Cards("+TrixRun.getPlayer04Cards().getCards().size()+")";
            
            i=7;
            line1+= "\t\t"+tableDeck[0][i]+"\t\t"+tableDeck[1][i]+"\t\t"+tableDeck[2][i]+"\t\t"+tableDeck[3][i];
            line1+="\t\t\t";
            line1+= getPlayers().get(1).getName()+"["+getPlayers().get(1).getPlayerScore()+"]"+"Cards("+TrixRun.getPlayer02Cards().getCards().size()+")";
            line1+="\n";
            //line1+="\n\n\n\n\n\n\n";
            for (i=8;i<=13;i++){
                line1+= "\t\t\t\t"+tableDeck[0][i]+"\t\t"+tableDeck[1][i]+"\t\t"+tableDeck[2][i]+"\t\t"+tableDeck[3][i];
                line1+="\n";
            }
            line1+="\n";
            line1+="\t\t\t\t\t\t\t"+ getPlayers().get(0).getName()+"["+getPlayers().get(0).getPlayerScore()+"]"+"Cards("+TrixRun.getPlayer01Cards().getCards().size()+")";
            line1+="\n\n\t";
            i=0;
            for(Card cc:TrixRun.getPlayer01Cards().getCards())
             {
                //line1+= i+")"+(cc.getValue()+" of "+cc.getSuit());
                line1+= i+")"+(cc.getValue()+"["+cc.getSuit()+"]");

                i++;
                if (i==7)
                   line1+="\n\t\t\t";
                else if(i!=13)
                    line1+="  ";
             }
            System.out.println(line1);
            initiateComplete=true;
        } while (!initiateComplete);   
    }
}
