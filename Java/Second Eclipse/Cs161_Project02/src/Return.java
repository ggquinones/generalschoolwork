/**
 * Return class which allows customers to return a bought item.
 * @author Gabriel
 *
 */
public class Return extends Transaction 
{
	private Sale ret;
	public Return( Customer cus, Employee emp,Sale ret)
	{
		super(cus,emp);
		this.ret=ret;
		
	}
	
	
	
	public Sale getSale()
	{
		return ret;
	}
}
