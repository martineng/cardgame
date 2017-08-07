/*
 *
 */
package cardgame;

/**
 @author martineca
 */
public class Deck
{
    private CardLink first;
    private CardLink last;
    
    // Null Constructor
    public Deck()
    {
        first = null;
        last = null;
    }
    
    // Return true if it is empty
    public boolean isEmpty()
    {
        return first == null;
    }
    /*
    
    // Insert into the firt of the link
    public void insertFirst(int inInput)
    {
        Card newCard = new Card(inInput); // Creating new card
        CardLink newLink = new CardLink(newCard); // Creating new link
        
        if (isEmpty())
        {
            last = newLink; // the new link is the last item
        }
        
        newLink.setNextLink(first); // the next of new link is the old first
        first = newLink; // the first item become the new link
    } // END insertFirst()
    
    public void insertLast(int inInput)
    {
        Card newCard = new Card(inInput); // Creating new card
        CardLink newLink = new CardLink(newCard); // Creating new link
        
        if (isEmpty())
        {
            first = newLink; // the first item is the new link
        }
        else
        {
            last.setNextLink(newLink); // The old last become new link
        }
        
        last = newLink; // the last item is the new link
    } // END insertLast()
    */
    public void deleteFirst()
    {
        // IF there is only 1 item
        if (first.getNextLink() == null)
        {
            last = null; // The last item is not empty
        } // END if
        
        first = first.getNextLink(); // The initial next item become the new first.
    } // END deleteFirst()
    
    public CardLink getFirst()
    {
        return first;
    }
    
    public CardLink getLast()
    {
        return last;
    }
}
