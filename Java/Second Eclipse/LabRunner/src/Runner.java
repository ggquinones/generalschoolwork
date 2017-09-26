import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
// look for places to make hard copies of everything
public class Runner 
{
	 public static void main(String[] args) throws FileNotFoundException 
	 {
	    Random rd = new Random();
	    int number = rd.nextInt(6)+1;
	    for(int i =0;i<25;i++)
	    {
	    	System.out.println(number);
	    	number = rd.nextInt(6)+1;
	    }
	 } 
}



class EventFrame extends JFrame
{
	public EventFrame()
	{
		setTitle("Event/Customer Info");
		JPanel panel = new JPanel();
		
		JLabel name = new JLabel();
		JTextField nameF = new JTextField(20);
		
		JLabel num = new JLabel();
		JTextField numF = new JTextField(20);
		
		JLabel email = new JLabel();
		JTextField emailF = new JTextField(20);
		
		JLabel address = new JLabel();
		JTextField addressF = new JTextField(20);
		
		JLabel deadline = new JLabel();
		JTextField deadlineF = new JTextField(20);
		
		
		
	}

}

class Event 
{
	ArrayList<Thing> stuff=new ArrayList<>();
	private double accTotal=0.0;
	String name,email,num,deadline,address;
	
	public Event (String name, String email, String num, String deadline,String address)
	{
		this.name=name;
		this.email=email;
		this.num=num;
		this.deadline=deadline;
		this.address=address;
	}
	public void addThing(Thing thingy)
	{
		stuff.add(thingy);
	}
	
	public ArrayList<Thing> getStuff()
	{
		return stuff;
	}

}

class ReceiptMakerScreen extends JFrame
{
	static ArrayList<Thing>stuff = new ArrayList<>();
	String accountName;
	public ReceiptMakerScreen()
	{
		setTitle("Events and Proposals");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p1 = new JPanel(new GridLayout(15,1,5,5));
		JPanel p2 = new JPanel();
		
		//JLabel l1a = new JLabel("Account Name");
		//JTextField name = new JTextField(10);
		
		JLabel l1 = new JLabel("Name");
		JTextField words = new JTextField(10);
		
		JLabel l1b = new JLabel("Description");
		JTextField description = new JTextField(10);
		
		JLabel l2 = new JLabel("Amt");
		JTextField amount = new JTextField(10);
		
		JLabel l3 = new JLabel("Price");
		JTextField price = new JTextField(10);
		
		JButton OK = new JButton("OK");
		JComboBox box = new JComboBox();
		JButton REMOVE = new JButton("Remove");
		
		JButton SAVE = new JButton("Save");
		
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu menu = new JMenu("Options");
		bar.add(menu);
				
		JMenuItem LOAD = new JMenuItem("Load");
		menu.add(LOAD);
		
		p1.add(l1);
		p1.add(words);
		p1.add(l1b);
		p1.add(description);
		p1.add(l2);
		p1.add(amount);
		p1.add(l3);
		p1.add(price);
		p1.add(new JLabel(""));
		p1.add(OK);
		p1.add(box);
		p1.add(REMOVE);
		p1.add(new JLabel(""));
		p1.add(SAVE);
		
		
		JTextArea show = new JTextArea(30,30);
		p2.add(show);
		p2.add(new JScrollPane(show),BorderLayout.EAST);
		
		OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Thing madeNow = new Thing(words.getText().trim(),description.getText().trim(),Integer.parseInt(amount.getText().trim()), Double.parseDouble(price.getText().trim()));
				stuff.add(madeNow);
				box.addItem(madeNow.getName());
				price.setText("");
				description.setText("");
				words.setText("");
				amount.setText("");
				
				show.setFont(new Font("Times New Roman", Font.BOLD,16));
				show.setText("Event Name\tEvent DeadLine\nAccount Total: $"+getTotal()+"\tcontact info\n\n");
				show.setFont(new Font("Sans Serif",Font.PLAIN,14));
				for(Thing el:stuff)
				{
					show.append(el.toString());
					
				}
				repaint();
			}
		});
		
		REMOVE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Thing choice=getThing((String) box.getSelectedItem());
				stuff.remove(choice);
				box.removeItem((String) box.getSelectedItem());
				show.setText("Event Name\tEvent DeadLine\n"+getTotal()+"\tcontact info\n\n");
				for(Thing el:stuff)
				{
					show.append(el.toString());
				}
				repaint();
			}
		});
		
		SAVE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					JFileChooser choose = new JFileChooser(); 
					if (choose.showDialog(ReceiptMakerScreen.this, "Save") == JFileChooser.APPROVE_OPTION) 
					{
						  File newFile = choose.getSelectedFile();
						  FileOutputStream fos = new FileOutputStream(newFile);
						  ObjectOutputStream oos = new ObjectOutputStream(fos);
						  oos.writeObject(ReceiptMakerScreen.this);
						  oos.close();
						  fos.close();
						  
					}
				}catch(Exception ex){
					
					JOptionPane.showMessageDialog(null,"ERROR!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		LOAD.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					 stuff.clear();
					JFileChooser choose = new JFileChooser(); 
					if (choose.showDialog(ReceiptMakerScreen.this, "Open") == JFileChooser.APPROVE_OPTION) 
					{
						  File newFile = choose.getSelectedFile();
						  FileInputStream fis = new FileInputStream(newFile);
						  ObjectInputStream ois = new ObjectInputStream(fis);
						 
						 
						  stuff=((ReceiptMakerScreen)(ois.readObject())).getStuff();
						  ois.close();
						  fis.close();
						  show.setText("Event Name\tEvent DeadLine\n"+getTotal()+"\tcontact info\n\n");
							for(Thing el:stuff)
							{
								box.addItem(el.getName());
								show.append(el.toString());
							}
							repaint();
					}
				}catch(Exception ex){
					System.out.println(ex.toString());
					JOptionPane.showMessageDialog(null,"ERROR!",ex.toString(),JOptionPane.WARNING_MESSAGE);
				} 
				
			}			
		});
		
		add(p1,BorderLayout.WEST);
		add(p2);
		setSize(500,600);
		setVisible(true);
		
	}
	
	public Thing getThing(String name)
	{
		for(Thing el:stuff)
		{
			if(el.getName().equals(name))
			{
				return el;
			}
		}
		return null;
	}
	
	public ArrayList<Thing> getStuff()
	{
		return stuff;
	}
	public double getTotal()
	{
		double total=0;
		for(Thing el:stuff)
		{
			total+=el.getTotal();
		}
		return total;
	}
}

class Thing implements Serializable
{
	private String name;
	private String desc;
	private int amt;
	private double price;
	private double total;
	
	public Thing(String name,String desc,int amount, double price)
	{
		this.name=name;
		this.desc=desc;
		this.amt=amount;
		this.price=price;
		this.total=amount*price;
		
	}
	
	public String toString()
	{
		return "Name: "+getName()+"\t$"+getTotal()+"\nAmt:"+this.getAmt()+"\tPrice/Unit: $"+this.getPrice()+"\n"+this.desc+"\n";
	}
	
	public String getName()
	{
		return this.name;
	}
	public double getTotal()
	{
		return this.total;
	}
	public int getAmt()
	{
		return this.amt;
	}
	public double getPrice()
	{
		return this.price;
	}
}


class List implements Serializable
{
	private ArrayList<Thing> stuff;
	public List(ArrayList<Thing> stuff)
	{
		this.stuff=stuff;
	}
	
	public ArrayList<Thing> getList()
	{
		return this.stuff;
	}
}





