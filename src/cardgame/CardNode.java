/* CardNode.java

   This class is Link.
   
   Basically store the information of Card object,
   next Link and previous Link.   
 */
package cardgame;

public class CardNode
{
    private Card theCard;
    private CardNode nextNode;
    private CardNode previousNode;
    
    //  Null Constructor
    public CardNode()
    {
        // EMPTY
    }
    
    // Constructor 
    public CardNode(Card inCard)
    {
        theCard = inCard;
        nextNode = null;
        previousNode = null;
    }
    
    // Mutators
    public void setNextNode(CardNode inCardNode)
    {
        nextNode = inCardNode;
    }
    
    public void setPreviousNode(CardNode inCardNode)
    {
        previousNode = inCardNode;
    }
    
    // Accessors
    public Card getCard()
    {
        return theCard;
    }
    
    public CardNode getNextNode()
    {
        return nextNode;
    }
    
    public CardNode getPreviousNode()
    {
        return previousNode;
    } 
   
}
