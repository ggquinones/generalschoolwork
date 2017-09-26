import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Class where TA times are put into a schedule and assigned.
 * @author Gabriel
 *
 */
class TATimes extends JDialog{

	private ScheduleButton[][] times = new ScheduleButton[48][7];
	private JPanel cPanel = new JPanel();
	private String[] hours = {"8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7"};
	private String[] min = {"00", "15", "30", "45"};
	
	public TATimes(MainFrame owner){
		super(owner, "Assign TA Times", true);
		setSize(600,850);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addItems();
		setVisible(true);
	}
	
	private void addItems(){
		JPanel nPanel = new JPanel();
		JPanel sPanel = new JPanel();
		add(nPanel, BorderLayout.NORTH);
		add(cPanel, BorderLayout.CENTER);
		add(sPanel, BorderLayout.SOUTH);
		JLabel taName = new JLabel("TA Name");
		JComboBox<?> name = new JComboBox<Object>();
		JLabel roomNum = new JLabel("Room Number");
		JComboBox<?> rooms = new JComboBox<Object>();
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		nPanel.add(taName);
		nPanel.add(name);
		nPanel.add(roomNum);
		nPanel.add(rooms);
		addScheduler();
		sPanel.add(ok);
		sPanel.add(cancel);
		ok.addActionListener(new okListener());
		cancel.addActionListener(new cancelListener());
	}
	
	private void addScheduler(){
		cPanel.setLayout(new GridLayout(49,5,1,1));
		JLabel mon = new JLabel("Monday", SwingConstants.CENTER);
		JLabel tue = new JLabel("Tuesday", SwingConstants.CENTER);
		JLabel wed = new JLabel("Wednesday", SwingConstants.CENTER);
		JLabel thur = new JLabel("Thursday", SwingConstants.CENTER);
		JLabel fri = new JLabel("Friday", SwingConstants.CENTER);
		cPanel.add(mon);
		cPanel.add(tue);
		cPanel.add(wed);
		cPanel.add(thur);
		cPanel.add(fri);
		for (int i = 0; i < 48; i++) {
			for (int j = 0; j < 5; j++) {
				
				//For testing purposes only
				Color color;
				if(i % 3 == 0){
					color = Color.RED;
				}else if(i % 3 == 1){
					color = Color.YELLOW;
				}else{
					color = Color.GREEN;
				}
				
				
				times[i][j] = new ScheduleButton(hours[i / 4] + ":" + min[i % 4],color);
				times[i][j].setSize(50, 50);
				cPanel.add(times[i][j]);
			}
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