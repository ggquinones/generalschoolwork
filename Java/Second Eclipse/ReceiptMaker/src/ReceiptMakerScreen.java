import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ReceiptMakerScreen extends JFrame
{
	ArrayList<Thing> stuff = new ArrayList<>();
	String accountName;
	public ReceiptMakerScreen(Event currentEvent)
	{
		stuff = currentEvent.getStuff();
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