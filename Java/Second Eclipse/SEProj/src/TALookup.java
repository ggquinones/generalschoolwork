import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Simple page to look up a TA and display their data.
 * @author Gabriel
 *
 */
class TALookup extends JDialog{
	public TALookup(MainFrame owner){
		super(owner, "Lookup TA", true);
		setSize(300,250);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel taName = new JLabel("TA Name");
		JComboBox<?> name = new JComboBox<Object>();
		JTextArea output = new JTextArea(8,25);
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		JPanel nPanel = new JPanel();
		JPanel cPanel = new JPanel();
		JPanel sPanel = new JPanel();
		add(nPanel, BorderLayout.NORTH);
		add(cPanel, BorderLayout.CENTER);
		add(sPanel, BorderLayout.SOUTH);
		nPanel.add(taName);
		nPanel.add(name);
		cPanel.add(output);
		sPanel.add(ok);
		sPanel.add(cancel);
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