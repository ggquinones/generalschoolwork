import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This is the page where a new semester can be made and the schedules of all the CRNS loaded from
 * an excel spreadsheet which the user can download from the IPFW website.
 * @author Gabriel
 *
 */
class newSem extends JDialog{
	
	public newSem(MainFrame owner){
		super(owner, "Add New Semeseter", true);
		setSize(400,250);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout());
		
		//North Panel
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1,4,10,10));
		JLabel season = new JLabel("Season:");
		JComboBox<String> seasons = new JComboBox<String>();
		seasons.addItem("Summer");
		seasons.addItem("Fall");
		seasons.addItem("Spring");
		JLabel year = new JLabel("Year:");
		JTextField years = new JTextField();
		north.add(season);
		north.add(seasons);
		north.add(year);
		north.add(years);
		panel.add(BorderLayout.NORTH,north);
		
		//Center Panel
		ArrayList<String> tempRooms = new ArrayList<String>();
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,3,10,10));
		JLabel taroom = new JLabel("TA Rooms:");
		JLabel addedroom = new JLabel("Added Rooms");
		JTextField tarooms = new JTextField("EX: ET109");
		JButton addroom = new JButton("Add Room");
		JButton deleteroom = new JButton("Delete Room");
		JComboBox<String> rooms = new JComboBox<String>();
		center.add(taroom);
		center.add(tarooms);
		center.add(addroom);
		center.add(addedroom);
		center.add(rooms);
		center.add(deleteroom);
		panel.add(BorderLayout.CENTER,center);
		
		//South Panel
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,2,10,10));
		JLabel browseInstr = new JLabel("Upload Semester File");
		JButton browse = new JButton("Browse Files");
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");		
		south.add(browseInstr);
		south.add(browse);
		south.add(ok);
		south.add(cancel);
		panel.add(BorderLayout.SOUTH,south);
		
		// Button Listeners
		addroom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rooms.addItem(tarooms.getText().trim());
				tempRooms.add(tarooms.getText().trim());
				tarooms.setText(" ");
			}
			
		});
		
		deleteroom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rooms.removeItem(rooms.getSelectedItem());
				tempRooms.remove(rooms.getSelectedItem());
			}
		});
		
		browse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(owner);
				if (result == JFileChooser.APPROVE_OPTION) 
				{
				    File selectedFile = fileChooser.getSelectedFile();
				    //Prints out selected file's
				    //pathSystem.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    JOptionPane.showMessageDialog(panel,"File: " + selectedFile.getAbsolutePath()+" successfully uploaded", "Uploaded File Success", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					Main.addNewSemester(new Semester(years.getText(),(String)seasons.getSelectedItem(),tempRooms));
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(panel,"Data not entered correctly!/nPlease try again!","ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				dispose();
			}
		});
		
		//Sets Visibility
		setVisible(true);
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			dispose();
		}
	}
	

}