package forFun;

import java.util.Random;

public class Playground {
	private int var =0;
	
	
	public int doSomething(int var)
	{
		return var;
	}
	
	public Playground(Playground other)
	{
		var=other.var;
	}
	public Playground()
	{
		var=0;
	}

}
