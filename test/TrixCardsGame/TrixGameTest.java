/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TrixCardsGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kjora
 */
public class TrixGameTest {
    
    public TrixGameTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of initiatPlayers method, of class TrixGame.
     */
    @Test
    public void testInitiatPlayers() {
        System.out.println("initiatPlayers");
        TrixGame instance = null;
        instance.initiatPlayers();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    /**
     * Test of play method, of class TrixGame.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        TrixGame instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of newShuffleForNewKingdome method, of class TrixGame.
     */
    @Test
    public void testNewShuffleForNewKingdome() {
        System.out.println("newShuffleForNewKingdome");
        int kingdomeIndex = 0;
        TrixGame instance = null;
        instance.newShuffleForNewKingdome(kingdomeIndex);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resetTableDeck method, of class TrixGame.
     */
    @Test
    public void testResetTableDeck() {
        System.out.println("resetTableDeck");
        TrixGame instance = null;
        instance.resetTableDeck();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of playACard method, of class TrixGame.
     */
    @Test
    public void testPlayACard() {
        System.out.println("playACard");
        int kingdomeIndex = 0;
        TrixGame instance = null;
        instance.playACard(kingdomeIndex);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of firstPlayerAction method, of class TrixGame.
     */
    @Test
    public void testFirstPlayerAction() {
        System.out.println("firstPlayerAction");
        TrixGame instance = null;
        instance.firstPlayerAction();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of playedCardAccepted method, of class TrixGame.
     */
    @Test
    public void testPlayedCardAccepted() {
        System.out.println("playedCardAccepted");
        int i = 0;
        int j = 0;
        TrixGame instance = null;
        boolean expResult = false;
        boolean result = instance.playedCardAccepted(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of whichSuitWasSelected method, of class TrixGame.
     */
    @Test
    public void testWhichSuitWasSelected() {
        System.out.println("whichSuitWasSelected");
        GroupOfCards trixRunPlayer = null;
        int selection = 0;
        TrixGame instance = null;
        int expResult = 0;
        int result = instance.whichSuitWasSelected(trixRunPlayer, selection);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of whichValueWasSelected method, of class TrixGame.
     */
    @Test
    public void testWhichValueWasSelected() {
        System.out.println("whichValueWasSelected");
        GroupOfCards trixRunPlayer = null;
        int selection = 0;
        TrixGame instance = null;
        int expResult = 0;
        int result = instance.whichValueWasSelected(trixRunPlayer, selection);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of is123PassCorrect method, of class TrixGame.
     */
    @Test
    public void testIs123PassCorrect() {
        System.out.println("is123PassCorrect");
        TrixGame instance = null;
        boolean expResult = false;
        boolean result = instance.is123PassCorrect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of secondPlayerAction method, of class TrixGame.
     */
    @Test
    public void testSecondPlayerAction() {
        System.out.println("secondPlayerAction");
        TrixGame instance = null;
        instance.secondPlayerAction();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of thirdPlayerAction method, of class TrixGame.
     */
    @Test
    public void testThirdPlayerAction() {
        System.out.println("thirdPlayerAction");
        TrixGame instance = null;
        instance.thirdPlayerAction();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fourthPlayerAction method, of class TrixGame.
     */
    @Test
    public void testFourthPlayerAction() {
        System.out.println("fourthPlayerAction");
        TrixGame instance = null;
        instance.fourthPlayerAction();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of playCardFromThisSuite method, of class TrixGame.
     */
    @Test
    public void testPlayCardFromThisSuite() {
        System.out.println("playCardFromThisSuite");
        GroupOfCards trixRunPlayer = null;
        int suit = 0;
        TrixGame instance = null;
        boolean expResult = false;
        boolean result = instance.playCardFromThisSuite(trixRunPlayer, suit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of declareWinner method, of class TrixGame.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        TrixGame instance = null;
        instance.declareWinner();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
