import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
/**
 * This is the project Main Menu. The page has a menu bar with all the options available to the user, Login/Logout
 * , Input information, Lookup information, change semester or add one, and Exit the whole 
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
class MainFrame extends JFrame {
	 
	public MainFrame() {
		setSize(300, 250);
		
		//menu bar and menu bar options
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu inout = new JMenu("Login/Logout");
		JMenu semester = new JMenu("Semseter Options");
		JMenu tas = new JMenu("TA");
		JMenu input = new JMenu("Input");
		JMenu exit = new JMenu("Exit");
		bar.add(inout);
		bar.add(semester);
		bar.add(tas);
		bar.add(input);
		bar.add(exit);
		
		//menu options
		JMenuItem login = new JMenuItem("Login");
		JMenuItem logout = new JMenuItem("Logout");
		JMenuItem newSem = new JMenuItem("Enter New Semester");
		JMenuItem changeSem = new JMenuItem("Change Semester");
		JMenuItem taLookup = new JMenuItem("TA Lookup");
		JMenuItem taUpdate = new JMenuItem("Update TA");
		JMenuItem newTA = new JMenuItem("Input New TA");
		JMenuItem taTimes = new JMenuItem("Enter Tutoring Times");
		JMenuItem newCourse = new JMenuItem("Input New Course");
		JMenuItem newCRN = new JMenuItem("Input New CRN");
		JMenuItem exits = new JMenuItem("Exit");
		JPanel nPanel = new JPanel();
		
		JTextArea semInfo = new JTextArea();
		if(Main.getCurrent() != null)
		{
		semInfo.append(Main.getCurrent().toString());
		}
		add(semInfo);
		
		inout.add(login);
		inout.add(logout);
		semester.add(newSem);
		semester.add(changeSem);
		tas.add(taLookup);
		tas.add(taUpdate);
		tas.add(newTA);
		tas.add(taTimes);
		input.add(newCourse);
		input.add(newCRN);
		exit.add(exits);
		
		//ActionListeners
		login.addActionListener(new loginListener());
		logout.addActionListener(new logoutListener());
		newSem.addActionListener(new newSemListener());
		changeSem.addActionListener(new changeSemListener());
		taLookup.addActionListener(new taLookupListener());
		taUpdate.addActionListener(new taUpdateListener());
		newTA.addActionListener(new newTAListener());
		taTimes.addActionListener(new taTimesListener());
		newCourse.addActionListener(new newCourseListener());
		newCRN.addActionListener(new newCRNListener());
		exits.addActionListener(new exitListener());
		
		new Login(Main.getFrame());
		new changeSem(Main.getFrame());
	}
	
	class loginListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new Login(Main.getFrame());
		}
	}
	
	class logoutListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new logout(Main.getFrame());
		}
	}

	class newSemListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new newSem(Main.getFrame());
		}
	}

	class taLookupListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new TALookup(Main.getFrame());
		}
	}

	class changeSemListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new changeSem(Main.getFrame());
		}
	}
	
	class taUpdateListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new TAUpdate(Main.getFrame());
		}
	}

	class newTAListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new NewTA(Main.getFrame());
		}
	}

	class taTimesListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new TATimes(Main.getFrame());
		}
	}

	class newCourseListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new NewCourse(Main.getFrame());
		}
	}

	class newCRNListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			new NewCRN(Main.getFrame());
		}
	}
	
	class exitListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
}