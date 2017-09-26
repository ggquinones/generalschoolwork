import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
/**
 * This page confirms the user's decision to logout and prevents accidental logouts.
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
public class logout extends JDialog{
	public logout(MainFrame owner){
		super(owner, "Logout", true);
		setSize(300,100);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JButton logout = new JButton("Logout");
		JButton cancel = new JButton("Cancel");
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		panel.add(logout);
		panel.add(cancel);
		logout.addActionListener(new logoutListener());
		cancel.addActionListener(new cancelListener());
		setVisible(true);
	}
	
	class logoutListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			Main.setLoggedIn(false);
			dispose();
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			dispose();
		}
	}
}