package gameTracker;

public class HQ 
{
	public static void main(String [] args)
	{
		
	}
}

 class Match
{
	final int SETS = 3;
	Team ONE;
	Team TWO;
	
	
}
 
 class Team
 {
	 int [] ROSTER = new int[12];
	 String name;
	 int [] StartLU = new int[6]; // represents starting line up . index = actual position -1
	 int [] CurrLU = new int[6]; // represents current line up
	 public Team(String name, int [] players)
	 {
		 this.name = name;
		 for(int i =0;i<players.length;i++)
		 {
			 this.ROSTER[i] = players[i];
		 }
	 }
	 
	 
 }
 
 