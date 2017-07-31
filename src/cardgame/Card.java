/*
 * Card is just a class that store name and rank,
 * for example: Card name: King, rank: 13
 */
package cardgame;

/**
 @author martineca
 */
public class Card
{
    private String name;
    private int rank;
    
    public Card()
    {
        // Null Constructor
    }
    
    public Card(String inName, int inRank)
    {
        setName(inName);
        setRank(inRank);
    }
    
    public void setName(String inName)
    {
        name = inName;
    }
    
    public void setRank(int inRank)
    {
        rank = inRank;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getRank()
    {
        return rank;
    }
    
}
