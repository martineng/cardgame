/*

 */
package cardgame;

/**
 @author martineca
 */

public class CardLink
{
    private Card theCard;
    private CardLink nextLink;
    
    public CardLink(Card inCard)
    {
        theCard = inCard;
    }
    
    public void setNextLink(CardLink inCardLink)
    {
        nextLink = inCardLink;
    }
    
    public CardLink getNextLink()
    {
        return nextLink;
    }
    
    public Card getCard()
    {
        return theCard;
    }
    
}
