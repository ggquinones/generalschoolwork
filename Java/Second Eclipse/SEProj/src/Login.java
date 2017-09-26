import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
/**
 * This is the Login page where the Administrator can input their password and user name.
 * 
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
class Login extends JDialog {
	private JPanel cPanel = new JPanel();
	private final JTextField username = new JTextField(20);
	private final JTextField password = new JTextField(20);
	
	public Login(MainFrame owner){
		super(owner, "Login", true);
		setSize(200,150);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel name = new JLabel("Username:");
		JLabel pass = new JLabel("Password");
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		

		cPanel.setLayout(new GridLayout(3, 2, 10, 10));
		add(cPanel);
		cPanel.add(name);
		cPanel.add(username);
		cPanel.add(pass);
		cPanel.add(password);
		cPanel.add(ok);
		cPanel.add(cancel);
		ok.addActionListener(new okListener());
		cancel.addActionListener(new cancelListener());
		setVisible(true);
	}
	
	class okListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			Administrator admin = Main.getAdmin();
			//System.out.print("Logged in?\t");
			//System.out.println(admin.login(username.getText(), password.getText()));
			if(admin.login(username.getText(), password.getText())){
				//System.out.println("made it");
				Main.setLoggedIn(true);
				dispose();
			}else{
				//System.out.println("failed");
				username.setText("");
				password.setText("");
			}
		}
	}
	
	class cancelListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			username.setText("");
			password.setText("");
			
			//comment out after testing is complete
			Main.setLoggedIn(true);
			dispose();
		}
	}
}