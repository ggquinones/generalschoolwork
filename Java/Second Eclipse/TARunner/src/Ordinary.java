
public class Ordinary {
   	private double real;
		private String message;
		public <T extends Number> Ordinary( T inp){
			real = inp.doubleValue();
			System.out.println( "The double value for "+inp.getClass()+ "  "+inp+"	is: "+real);
		}
	}
