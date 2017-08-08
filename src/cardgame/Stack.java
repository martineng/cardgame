/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.Random;
/**

 @author martineca
 */
public class Stack
{
    private int maxSize, top;
    private Card[] cardArray;
    
    public Stack()
    {
        setMaxSize();
        setCardArray();
        setTop(-1); // New stack without item
    }
    
    public void setMaxSize()
    {
        maxSize = 52;
    }
    
    public void setTop(int inTop)
    {
        top = inTop;
    }
    
    public void setCardArray()
    {
        cardArray = new Card[getMaxSize()];
    }
    
    public int getMaxSize()
    {
        return maxSize;
    }
    
    public int getTop()
    {
        return top;
    }
    
    public void populateCard()
    {
        Random rand = new Random(); // Seeding the random
        int randomNum, randomSuit; // Random int
        
        // Boolean Array use to hold pooulated card
        boolean redundantCheck[][] = new boolean[4][12];
        
        Card tempCard = new Card();
        
        // Intialize the array to all false
        for (int col = 0; col < 4; col++)
        {
            for (int row =0; row<12; row++)
            {
                redundantCheck[col][row] = false;
                //System.out.println(redundantCheck[col][row]);
            } // END FOR(row)
        } // END FOR(col)
        
        // Populate card on stack!
        for (int counter = 0; counter != cardArray.length; counter++)
        {
            randomSuit = rand.nextInt(3);
            randomNum = rand.nextInt(12);
            
            //System.out.println(redundantCheck[randomSuit][randomNum]);
            // IF card was drawn before
            if (redundantCheck[randomSuit][randomNum])
            {
                System.out.println(counter + "--");
                counter--; // Do it again
            }
            else
            {
                redundantCheck[randomSuit][randomNum] = true;
          
                tempCard = new Card(randomSuit+1, randomNum+1); // Generate Card
                push(tempCard);
                System.out.println(counter + "++");
            } // END IF
         
        } // END FOR
    } // END populateCard()
    
    // Placing card on top of the stack
    public void push(Card inCard)
    {
        if (!(isFull()))
        {
            System.out.println(top);
            System.out.println("Pushed " + inCard.getSuit() + ", " + inCard.getName());
            cardArray[++top] = inCard;
            System.out.println(top + "\n");
        }
        else
        {
            System.out.print("STACK FULL!");
        }
        
    } // END push()
    
    // Remove the top card
    public Card pop()
    {
        return cardArray[top--];
    }
    
    // Peek on the top card without removing
    public Card peek()
    {
        return cardArray[top];
    }
    
    // True if empty
    public boolean isEmpty()
    {
        return (top == -1);
    }
    
    // True if full
    public boolean isFull()
    {
        return (top == maxSize -1);
    }
    
}
