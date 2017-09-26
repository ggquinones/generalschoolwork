import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
/**
 * This page is where the Administrator can make a new course object and input it into the system.
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
class NewCourse extends JDialog{
	
	public NewCourse(MainFrame owner){
		super(owner, "Add New Course", true);
		setSize(300,250);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel newCourse = new JLabel("Course Name");
		JTextField courseName = new JTextField(30);
		
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2,2,10,10));
		panel.add(newCourse);
		panel.add(courseName);
		panel.add(ok);
		panel.add(cancel);
		ok.addActionListener(new okListener());
		cancel.addActionListener(new cancelListener());
		setVisible(true);
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