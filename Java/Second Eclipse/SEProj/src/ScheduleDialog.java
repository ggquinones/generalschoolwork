import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * This is the actual Schedule page. It is an array of Schedule Buttons that can be clicked to 
 * reflect the availability of a TA or a CRN.
 * @author Gabriel
 *
 */
class ScheduleDialog extends JDialog{
	NewCRN owner1 = null;
	NewTA owner2 = null;
	TAUpdate owner3 = null;
	final int width = 48, height = 5;
	private ScheduleButton[][] times = new ScheduleButton[width][height];
	private JPanel cPanel = new JPanel();
	private String[] hours = {"8", "9", "10", "11", "12", "1", "2", "3", "4", "5", "6", "7"};
	private String[] min = {"00", "15", "30", "45"};
	
	public ScheduleDialog(NewCRN owner, String crnName, Schedule schedule){
		super(owner, "Update " + crnName + " Schedule", true);
		owner1 = owner;
		addItems(schedule);
	}
	
	public ScheduleDialog(NewTA owner, String taName, Schedule schedule){
		super(owner, "Update " + taName + " Schedule", true);
		owner2 = owner;
		addItems(schedule);
	}
	
	public ScheduleDialog(TAUpdate owner, String taName, Schedule schedule){
		super(owner, "Update " + taName + " Schedule", true);
		owner3 = owner;
		addItems(schedule);
	}	
	
	public void addItems(Schedule schedule){
		setSize(600,800);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel sPanel = new JPanel();
		add(cPanel, BorderLayout.CENTER);
		add(sPanel, BorderLayout.SOUTH);
		cPanel.setLayout(new GridLayout(49,5,1,1));
		addButtons(schedule);
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		sPanel.add(ok);
		sPanel.add(cancel);
		ok.addActionListener(new OK());
		cancel.addActionListener(new Cancel());
		setVisible(true);
	}
	
	public void addButtons(Schedule schedule){
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
		if(schedule == null){
			for (int i = 0; i < 48; i++) {
				for (int j = 0; j < 5; j++) {
					times[i][j] = new ScheduleButton(hours[i / 4] + ":" + min[i % 4]);
					times[i][j].setSize(50, 50);
					cPanel.add(times[i][j]);
				}
			}
		}else{
			System.out.println("Schedule not null");
			ArrayList<Color> sched = schedule.getTime();
			for(int i = 0; i < sched.size(); i++){
				times[i % 48][i/48].setColor(sched.get(i));
			}
		}
	}
	
	class OK implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if(Main.getLoggedIn()){
				ArrayList<Color> sched = new ArrayList<Color>();
				for(int i = 0; i < width; i++){
					for(int j = 0; j < height; j++){
						
						System.out.println("i= " + i + "\tj= " + j + "\tColor = " + times[i][j].getColor().toString());
						sched.add(times[i][j].getColor());
					}
				}
				Schedule schedule = new Schedule(sched);
				if(owner1 != null){
					//owner1.setSchedule(schedule);
				}else if(owner2 != null){
					owner2.setSchedule(schedule);
				}else if(owner3 != null){
					owner3.setSchedule(schedule);
				}
			}
			dispose();
		}
	}
	
	class Cancel implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			dispose();
		}
	}
}