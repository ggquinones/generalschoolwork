import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * This class produces a Dialog Box which allows the user to switch which Semester they 
 * are looking at as well as add a new semester, done on another dialog box.
 * 
 */
import javax.swing.*;
/**
 * Page to change which semester you are currently looking at, and therefore
 * which associated information you are handling.
 * @author Gabriel
 *
 */
class changeSem extends JDialog{
	
	private JComboBox<?> semesterSelection = new JComboBox<Object>(Main.semTags());
	
	public changeSem(MainFrame owner){
		super(owner, "Pick Semeseter", true);
		setSize(300,150);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel nPanel = new JPanel();
		add(nPanel);
		nPanel.setLayout(new BorderLayout());
		
		// North Panel With Semester drop down
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel semSelect = new JLabel("Pick Semester:");			
		north.add(semSelect);
		north.add(semesterSelection);		
		nPanel.add(BorderLayout.NORTH,north);
		
		//Center Panel With Upload Option button
		JPanel center = new JPanel();
		JButton newSem = new JButton("Make New Semester");	
		center.add(newSem);
		nPanel.add(BorderLayout.CENTER,center);
		
		// South panel with ok/cancel option
		JPanel south = new JPanel();
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		south.add(ok);
		south.add(cancel);
		nPanel.add(BorderLayout.SOUTH,south);
		
		ok.addActionListener(new okListener());
		cancel.addActionListener(new cancelListener());
		newSem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new newSem(owner);
			}
		});
		setVisible(true);
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			System.out.println("closed Pick Semester");
			dispose();
		}
	}
	
	class okListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			
		}
	}
}