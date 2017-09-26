import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * This is the page where the administrator makes and inputs a new TA into the system.
 * @author Gabriel
 *
 */
class NewTA extends JDialog{
	NewTA owner = this;
	public NewTA(MainFrame owner){
		super(owner, "Add New TA", true);
		setSize(300,250);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel lastName = new JLabel("Last Name");
		JTextField lName = new JTextField(30);
		JLabel firstName = new JLabel("First Name");
		JTextField fName = new JTextField(30);
		JLabel midName = new JLabel("Middle Initial");
		JTextField mName = new JTextField(1);
		JLabel course = new JLabel("Course Name");
		JComboBox<?> courseNames = new JComboBox<Object>();
		JLabel crn = new JLabel("CRN");
		JComboBox<?> courseCRN = new JComboBox<Object>();
		JButton schedule = new JButton("Schedule");
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		JPanel nPanel = new JPanel();
		JPanel cPanel = new JPanel();
		JPanel sPanel = new JPanel();
		add(nPanel, BorderLayout.NORTH);
		add(cPanel, BorderLayout.CENTER);
		add(sPanel, BorderLayout.SOUTH);
		nPanel.setLayout(new GridLayout(5,2,10,5));
		nPanel.add(lastName);
		nPanel.add(lName);
		nPanel.add(firstName);
		nPanel.add(fName);
		nPanel.add(midName);
		nPanel.add(mName);
		nPanel.add(course);
		nPanel.add(courseNames);
		nPanel.add(crn);
		nPanel.add(courseCRN);
		cPanel.add(schedule);
		sPanel.add(ok);
		sPanel.add(cancel);
		schedule.addActionListener(new schedule());
		ok.addActionListener(new okListener());
		cancel.addActionListener(new cancelListener());
		setVisible(true);
	}
	
	public void setSchedule(Schedule sched){
		//schedule = sched;
	}
	
	class schedule implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			//new ScheduleDialog(owner, "Room Number",null);
		}
	}
	
	class okListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			dispose();
		}
	}
}