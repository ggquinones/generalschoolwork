package quingg01_lab04;

public class Card
{
	Suit suit;
	Rank rank;
	
	public Card()
	{
		int i = (int)(Math.random()*4);
	    this.suit=Suit.values()[i];
	    
	    i = (int)(Math.random()*13);
	    this.rank=Rank.values()[i];
	}
	
	public Card(Suit suit,Rank rank)
	{
		this.suit=suit;
		this.rank=rank;
	}

	public int getRank()
	{
		return(this.rank.getRank());
	}
	
	public String getSuit()
	{
		return this.suit.getSuit();
	}
	
	public String toString()
	{
		return("Suit: "+this.suit.toString()+" Rank: "+this.rank.toString()+"\n");
	}
	
	public boolean equals(Card other)
	{
		if((this.getSuit().equals(other.getSuit())) && (this.getRank()==other.getRank()))
		{
			return true;
		}
		return false;
	}
	
}

enum Suit
{
	HEARTS("hearts") ,CLUBS("clubs"),DIAMONDS("diamonds"),SPADES("spades");
	private String suit;
	
	private Suit(String suit)
	{
		this.suit=suit;
	}
	
	public String getSuit()
	{
		return this.suit;
	}
}

enum Rank
{
	TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
	private int rank;
	
	private Rank(int rank)
	{
		this.rank=rank;
	}

	public int getRank()
	{
		return this.rank;
	}
}