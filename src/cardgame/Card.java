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
    
    public Card(int inInput)
    {
        switch (inInput)
        {
            case 1:
                setName("1");
                setRank(1);
                break;
            case 2:
                setName("2");
                setRank(2);
                break;
            case 3:
                setName("3");
                setRank(3);
                break;
            case 4:
                setName("4");
                setRank(4);
                break;
            case 5:
                setName("5");
                setRank(5);
                break;
            case 6:
                setName("6");
                setRank(6);
                break;
            case 7:
                setName("7");
                setRank(7);
                break;
            case 8:
                setName("8");
                setRank(8);
                break;
            case 9:
                setName("9");
                setRank(9);
                break;
            case 10:
                setName("10");
                setRank(10);
                break;
            case 11:
                setName("J");
                setRank(11);
                break;
            case 12:
                setName("Q");
                setRank(12);
                break;
            case 13:
                setName("K");
                setRank(13);
                break;      
            default:
                break;
        } // END switch
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
