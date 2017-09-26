package quingg01_lab04;

import java.util.ArrayList;

public class Hand
{
	private ArrayList<Card> hand = new ArrayList<>();
	
	public Hand()
	{
		int count =0;
		while(count<5)
		{
			Card draw=new Card();
			
			if(!(isInHand(draw)))
			{
				hand.add(draw);
				count++;
			}
		}
	}
	
	public Hand(Card a,Card b,Card c,Card d,Card e)
	{
		hand.add(0,a);
		hand.add(1,b);
		hand.add(2,c);
		hand.add(3,d);
		hand.add(4,e);
	}

	public boolean isInHand(Card draw)
	{
		for(Card el:hand)
		{
			if(el.equals(draw))
			{
				return true;
			}
		}
		return false;
	}
	
	public String toString()
	{
		String cards="Hand is:\n";
		
		for(Card el: hand)
		{
			cards+=el.toString();
		}
		
		return cards;	
	}
	
	public boolean isConsecutive()
	{
		int [] nextCards = nextRanks(hand.get(0));
		for(int i=0;i<hand.size()-1;i++)
		{
			if(hand.get(i+1).getRank()!=nextCards[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public int[] nextRanks(Card card)
	{
		int first = card.getRank();
		int [] consecutiveRanks = new int[4];
		for(int i =0;i<consecutiveRanks.length;i++)
		{
			if(first==14)
			{
				first=2;
				consecutiveRanks[i]=first;
				
			}
			else
			{
				first++;
				consecutiveRanks[i]=first;
				
			}
		}
		return consecutiveRanks;
	}
}




