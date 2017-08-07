/*
 * THis program is developed in associated to Advance data structure
 * and Algorithm assessment.
 */
package cardgame;

import java.util.Random;

/**
 @author martineca
 */
public class CardGame
{

    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        testDeck();
    }
    
    public static void testDeck()
    {
        Deck d1 = new Deck();
        
        d1.insertFirst(generateRandomNum());
        d1.insertFirst(generateRandomNum());
        d1.insertFirst(generateRandomNum());
        d1.insertFirst(generateRandomNum());
        
        d1.insertLast(generateRandomNum());
        d1.insertLast(generateRandomNum());
        
        CardLink current = d1.getFirst();
        
        while (current != null)
        {
            System.out.println("Name: " + current.getCard().getName());
            System.out.println("Rank: " + current.getCard().getRank() + "\n");
            current = current.getNextLink();
        }
        
    }
    
    // Generate Random Number
    public static int generateRandomNum()
    {
        Random rand = new Random();
        int randNum = rand.nextInt(12);
        
        // Obtain Visual. To be removed.
        System.out.println("Generated " + (randNum+1));
        
        return randNum + 1;
    } // END generateRandomNum()
    
}
