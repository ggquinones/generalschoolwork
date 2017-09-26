import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * This is where the administrator can make a new CRN and input it into the system.
 * @author Gabriel
 *
 */
class NewCRN extends JDialog{
	private NewCRN owner = this;
	public NewCRN(MainFrame owner){
		super(owner, "Add New CRN", true);
		setSize(300,250);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel nPanel = new JPanel();
		JPanel panel = new JPanel();
		JPanel sPanel = new JPanel();
		add(nPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(sPanel, BorderLayout.SOUTH);
		nPanel.setLayout(new GridLayout(2, 2, 10 , 10));
		JLabel newCRN = new JLabel("New CRN");
		JTextField crn = new JTextField(5);
		JLabel course = new JLabel("Course Name");
		JComboBox<?> courses = new JComboBox<Object>();
		JButton schedule = new JButton("Schedule");
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		nPanel.add(newCRN);
		nPanel.add(crn);
		nPanel.add(course);
		nPanel.add(courses);
		panel.add(schedule);
		sPanel.add(ok);
		sPanel.add(cancel);
		schedule.addActionListener(new schedule());
		ok.addActionListener(new okListener());
		cancel.addActionListener(new cancelListener());
		setVisible(true);
		pack();
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