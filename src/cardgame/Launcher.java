/* Launcher.java
 * This is the Engine of the program
 * Basically every crucial function is written and execute here.
 */
package cardgame;

import java.util.Random;
import java.util.Scanner;

public class Launcher 
{
    Scanner inputReader = new Scanner(System.in);
    
    CardList spadeList = new CardList();
    CardList heartList = new CardList();
    CardList clubList = new CardList();
    CardList diamondList = new CardList();
    
    public void run()
    {
        int menuInput = 0;
        
        welcomeMessage();
        addNode();
        
        do
        {
            menu();
            menuInput = inputReader.nextInt();
            
            switch(menuInput)
            {
                case 1:
                    System.out.println("\nRegenerating Lists...\n");
                    addNode();
                    break;
                case 2:
                    deleteNode();
                    break;
                case 3:
                    findNode();
                    break;
                case 0:
                    // Exit menu, close program.
                    break;
                default:
                    System.out.println("\n!!! INVALID INPUT !!!\n");
                    break;
            } // END SWITCH
        } while (menuInput != 0); // END WHILE
    }
    
     /* generateRandomNum() generate a random number with range 1 - 13 */
    private int generateRandomNum()
    {
        Random rand = new Random();
        int randNum = rand.nextInt(13); // Generate an int between 0 to 12
        
        return randNum + 1; // +1 so that the range would be 1 to 13
    } // END generateRandomNum()
    
    
    /* addNode() automatically generate Card into Suit List randomly without repeatation
       It will regenerates when being evoke by user (Entered [1]). */
    private void addNode()
    {
        int[] validateUniqueNum = new int[13]; // Use to make sure random number is unique
        Card theCard = new Card();
        int randRank = 0; // Random generate number
        boolean checkRandRank = false; // Validate if RandRank is Unique
        
        // Initialize all the lists.
        spadeList = new CardList();
        heartList = new CardList();
        clubList = new CardList();
        diamondList = new CardList();
        
        // counterList loop through Suit, 1 = Spade, 2 = Heart, 3 = Club, 4 = Diamond
        for (int counterList = 1; counterList <= 4; counterList++)
        {  
            // counter loop through validateUniqueNum, from 0 to 12, 13 cards
            for (int counter = 0; counter!=12; counter++)
            {               

                // DO loop to make sure randRank is unique
                do
                {
                    checkRandRank = true; // this boolean will turn false if a similar number is found in the array
                    randRank = generateRandomNum();
                   
                    // Compare and loop through validateUniqueNum array
                    for (int arrCounter = 0; arrCounter != validateUniqueNum.length; arrCounter++)
                    {
                        // If a similar number is found in the array, making it false
                        if (randRank == validateUniqueNum[arrCounter])
                        {
                            checkRandRank = false;
                        }
                    }
                } while (!checkRandRank);
                
                // Once confirmed the random number is not repeated, put it in the array
                validateUniqueNum[counter] = randRank;
                
                // Generate the Card
                theCard = new Card(counterList, randRank);
                
                // Placing the Card into the list accordingly
                switch (counterList)
                {
                    case 1:
                        spadeList.insertFirst(theCard);
                        break;
                    case 2:
                        heartList.insertFirst(theCard);
                        break;
                    case 3:
                        clubList.insertFirst(theCard);
                        break;
                    case 4:
                        diamondList.insertFirst(theCard);
                        break;
                    default:
                        break;
                } // END SWITCH
            } // END WHILE
            
            // Intialize the array for the next counterList index
            validateUniqueNum = new int[13];
        } // END FOR
        
    } // END addNode()
    
    /* deleteNode() ask user for Suit and delete options,
       then proceed to delete either the First Node (Entered [1])
       or the Last Node (Entered [2]) */
    private void deleteNode()
    {
        int deleteSuit = 0, deleteFirstLast = 0; // To store user input
        
        // Request and validate input of Suit
        do
        {
            System.out.println("\nWhich list of node would you like to delete?");
            System.out.println("(1) - Spade");
            System.out.println("(2) - Heart");
            System.out.println("(3) - Club");
            System.out.println("(4) - Diamond");
            System.out.print("Enter: > ");
            deleteSuit = inputReader.nextInt();
            
            if (deleteSuit < 1 && deleteSuit > 4)
            {
                System.out.println("\n!!! INVALID INPUT !!!\n");
            }
        } while (deleteSuit < 1 && deleteSuit > 4);
        
        // Request and validate delete options
        do
        {
            System.out.println("\nWould you like to delete: ");
            System.out.println("(1) - First");
            System.out.println("(2) - Last");
            System.out.print("Enter: > ");
            deleteFirstLast = inputReader.nextInt();
            
            if (deleteFirstLast < 1 && deleteFirstLast > 2)
            {
                System.out.println("\n!!! INVALID INPUT !!!\n");
            }  
        } while (deleteFirstLast < 1 && deleteFirstLast > 2);
        
        // Perform deletion to according suit list.
        switch (deleteSuit)
        {
            case 1:
                if (deleteFirstLast == 1)
                {
                    spadeList.deleteFirst();
                }
                else
                {
                    spadeList.deleteLast();
                }
                break;
            case 2:
                if (deleteFirstLast == 1)
                {
                    heartList.deleteFirst();
                }
                else
                {
                    heartList.deleteLast();
                }
                break;
            case 3:
                if (deleteFirstLast == 1)
                {
                    clubList.deleteFirst();
                }
                else
                {
                    clubList.deleteLast();
                }
                break;
            case 4:
                if (deleteFirstLast == 1)
                {
                    diamondList.deleteFirst();
                }
                else
                {
                    diamondList.deleteLast();
                }
                break;
            default:
                break;
        } // END SWITCH
        
    }
    
    /* findNode() ask user for suit and rank that desire to delete.
       It will then search through the list,
       and then display its previous node and next node as a proof of search. */
    private void findNode()
    {
        Card findCard = new Card(); // Card object to find, use for comparison
        CardNode foundNode = new CardNode(); // CardNode object from the result
        int findSuit = 0, findRank = 0; // store user input
        
        // Request and validate Suit input
        do
        {
            System.out.println("\nWhich suit would you like to search?");
            System.out.println("(1) - Spade");
            System.out.println("(2) - Heart");
            System.out.println("(3) - Club");
            System.out.println("(4) - Diamond");
            System.out.print("Enter: > ");
            findSuit = inputReader.nextInt();
            
            if (findSuit < 1 && findSuit > 4)
            {
                System.out.println("\n!!! INVALID INPUT !!!\n");
            }
        } while (findSuit < 1 && findSuit > 4);
        
        // Request and validate Rank input
        do
        {
            System.out.println("\nWhich rank? [Note: J = 11, Q = 12, K = 13] ");
            System.out.print("Enter: > ");
            findRank = inputReader.nextInt();
            
            if (findRank < 1 && findRank > 13)
            {
                System.out.println("\n!!! INVALID INPUT !!!\n");
            }  
        } while (findRank < 1 && findRank > 13);
        
        findCard = new Card(findSuit, findRank); // Create Card object
        
        // Perform the search!
        switch (findSuit)
        {
            case 1:
                foundNode = spadeList.searchNode(findCard);
                break;
            case 2:
                foundNode = heartList.searchNode(findCard);
                break;
            case 3:
                foundNode = clubList.searchNode(findCard);
                break;
            case 4:
                foundNode = diamondList.searchNode(findCard);
                break;
            default:
                break;
        }
        
        // Display result
        System.out.println("\nCard suit[" + findSuit + "] rank[" + findRank + "] found!!");
        
        // Display previous node!
        if (foundNode.getPreviousNode() == null)
        {
            System.out.println("It is the first Node!");
        }
        else
        {
            System.out.println("It's previous Node is " + "suit[" + foundNode.getPreviousNode().getCard().getSuit() + "] rank[" + foundNode.getPreviousNode().getCard().getRank() + "]");
        }
        
        // Display next node!
        if (foundNode.getNextNode() == null)
        {
            System.out.println("It is the last Node!\n");
        }
        else
        {
            System.out.println("It's next Node is " + "suit[" + foundNode.getNextNode().getCard().getSuit() + "] rank[" + foundNode.getNextNode().getCard().getRank() + "]\n");
        }
    }
    
    /* welcomeMessage() only run once when the program evoked. */
    private void welcomeMessage()
    {
        System.out.println("=============================================");
        System.out.println("Welcome to CardGame!");
        System.out.println("This is not technically a game,");
        System.out.println("But rather a demo showcasing ");
        System.out.println("the implementation of Double-Linked List.\n");
        System.out.println("This program has automatically generated");
        System.out.println("4 Double-Linked List: ");
    }
    
    /* menu() is the main function menu for user*/
    private void menu()
    {
        System.out.println("=============================================");
        spadeList.displayList();
        heartList.displayList();
        clubList.displayList();
        diamondList.displayList();
        System.out.println("=============================================");
        System.out.println("Please enter index for next step: ");
        System.out.println("(1) - Regenerate all the List");
        System.out.println("(2) - Delete a node");
        System.out.println("(3) - Look for a specified node");
        System.out.println("(0) - Exit");
        System.out.print("Enter: > ");
    }
    
}
