import java.util.Random;


public class Application {
	static Random rd=new Random();
	public static void main(String [] args)
	{
		StudentTable table = new StudentTable(30000);
		for(int i=0;i<15000;i++)
		{
			table.put(new Student(randomName(7)));
		}
		int count=0;
		for(int k=0;k<table.data.length;k++)
		{
			if(count==50)
			{
				break;
			}
			
			if(table.data[k]!=null )
			{
				System.out.println("k: "+table.get(table.data[k].getID()));
				count++;
			}
		}
	}

	
	public static String randomName(int length)
	{
		String name="";
		char temp=' ';
		
		for(int i=0;i<length;i++)
		{
			if(i==0)
			{
				temp=(char) ((char) rd.nextInt(26)+65);
				name+=temp;
			}
			else if(i%2==0)
			{
				int choice=rd.nextInt(6);
				switch(choice)
				{
				case 1: temp='a';
					break;
				case 2: temp='e';
					break;
				case 3: temp='i';
					break;
				case 4: temp='o';
					break;
				case 5: temp='u';
					break;
				}
				name+=temp;
			}
			else
			{
				int choice = rd.nextInt(26)+97;
				while(choice==97 || choice == 101 || choice== 105 || choice==111 || choice==117)
				{
					choice=rd.nextInt(26)+97;
				}
				temp=(char)choice;
				name+=temp;
			}
		}
		
		
		
		return name;
	}
}
