/* CardList.java
 * 
 * Card List is a Double-Linked List.
 * 
 */
package cardgame;

/**
 @author martineca
 */
public class CardList
{
    private CardNode firstNode;
    private CardNode lastNode;
    
    // Null Constructor
    public CardList()
    {
        firstNode = null;
        lastNode = null;
    }
    
    // Return true if it is empty
    public boolean isEmpty()
    {
        return firstNode == null;
    }
    
    // Insert into the firt of the link
    public void insertFirst(Card inCard)
    {
        CardNode newNode = new CardNode(inCard); // Creating new link
        
        if (isEmpty())
        {
            lastNode = newNode; // the new link is the last item
        }
        else
        {
            firstNode.setPreviousNode(newNode); // new link is the old first
        }
        
        newNode.setNextNode(firstNode); // the next of new link is the old first
        firstNode = newNode; // the first item become the new link
    } // END insertFirst()
    
    public void insertLast(Card inCard)
    {    
        CardNode newNode = new CardNode(inCard); // Creating new link
        
        if (isEmpty())
        {
            firstNode = newNode; // the first item is the new link
        }
        else
        {
            lastNode.setNextNode(newNode); // The old last become new link
            newNode.setPreviousNode(lastNode);
        }
        
        lastNode = newNode; // the last item is the new link
    } // END insertLast()
    
    public void deleteFirst()
    { 
        // IF there is only 1 item
        if (firstNode.getNextNode() == null)
        {
            lastNode = null; // The last item is not empty
        } // END if
        else
        {
            firstNode.getNextNode().setPreviousNode(null); // The old next is now null
        }
        
        firstNode = firstNode.getNextNode(); // The initial next item become the new first.
    } // END deleteFirst()
    
    public void deleteLast()
    {
        if (firstNode.getNextNode() == null)
        {
            firstNode = null;
        }
        else
        {
            lastNode.getPreviousNode().setNextNode(null);
        }
        
        lastNode = lastNode.getPreviousNode();
    }
    
    public void displayList()
    {
        CardNode currentNode = firstNode;
        
        System.out.print(currentNode.getCard().getSuit() + ": ");
        
        while (currentNode != null)
        {
            System.out.print(currentNode.getCard().getName());
            currentNode = currentNode.getNextNode();
            
            if (currentNode != null)
            {
                System.out.print(", ");
            } // END IF
        } // END WHILE
        
        System.out.print("\n");   
    }
    
    public CardNode searchNode(Card inCard)
    {
        CardNode current = firstNode;
        
        while (current.getCard().getRank() != inCard.getRank())
        {
            current = current.getNextNode();
        }
        
        return current;
    }
    
    public CardNode getFirst()
    {
        return firstNode;
    }
    
    public CardNode getLast()
    {
        return lastNode;
    }
}
