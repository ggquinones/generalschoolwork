import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * This is the page where the administrator can update, remove, or add TAs.
 * @author Gabriel
 *
 */
class TAUpdate extends JDialog{
	
	private TAUpdate thisOwner = this;
	JComboBox<TeachingAssistant> taNames = new JComboBox<TeachingAssistant>();
	
	JComboBox<CRN> courseCRN = new JComboBox<CRN>();
	private Schedule schedule = null;
	
	public TAUpdate(MainFrame owner){
		
		super(owner, "Update/Add TA Info", true);
		ArrayList<CRN> tempCRNs = new ArrayList<CRN>();
		System.out.println("here");
		addItems(Main.getCurrent());
		setSize(450,275);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		
		//North Panel
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(5,3,10,10));
		
		JLabel talookup = new JLabel("TA Lookup");
		JComboBox<TeachingAssistant>tas = new JComboBox<TeachingAssistant>();
		if(Main.getCurrent()!=null)
		{
			 //Getting current semesters TA List and putting it into JCOmboBox options
				ArrayList<TeachingAssistant> temp =Main.getCurrent().getTeachingAssistants();
				for(TeachingAssistant elem : temp)
				{
					tas.addItem(elem);
				}
		}
		
		JButton upload = new JButton("Upload Information");
		JLabel fName = new JLabel("First Name");
		JTextField fNames = new JTextField();
		JLabel blank1 = new JLabel("\t");
		JLabel blank2 = new JLabel("\t ");
		JLabel lName = new JLabel("Last Name");
		JTextField lNames = new JTextField();
		JLabel addtacrs = new JLabel("Add TA CRN");
		JComboBox<CRN> crns = new JComboBox<CRN>();
		if(Main.getCurrent()!=null)
		{
			//Getting current semesters CRN List and putting it into JCOmboBox options
			ArrayList<CRN> temp =Main.getCurrent().getCRNs();
			for(CRN elem : temp)
			{
				crns.addItem(elem);
			}
		}
		JButton add = new JButton("Add");
		JLabel crstaing = new JLabel("Courses TAing");
		JComboBox<CRN> taing = new JComboBox<CRN>();
		
		
		JButton rmv = new JButton("Remove");
		north.add(talookup);
		north.add(tas);
		north.add(upload);
		north.add(fName);
		north.add(fNames);
		north.add(blank1);
		north.add(lName);
		north.add(lNames);
		north.add(blank2);
		north.add(addtacrs);
		north.add(crns);
		north.add(add);
		north.add(crstaing);
		north.add(taing);
		north.add(rmv);
		panel.add(BorderLayout.NORTH,north);
				
		//South Panel
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton scheduleB = new JButton("Schedule");
		JButton Update = new JButton("Update");
		JButton addTA = new JButton("Add New TA");
		JButton rmvTA = new JButton("Remove TA");
		JButton exit = new JButton("Exit");
		south.add(scheduleB);
		south.add(Update);
		south.add(addTA);
		south.add(rmvTA);
		south.add(exit);
		panel.add(BorderLayout.SOUTH,south);
		
		
		
		
		

		// Action Listeners
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				dispose();
			}
		});
		
		upload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TeachingAssistant ta = (TeachingAssistant) taNames.getSelectedItem();

				if(ta != null){
					fNames.setText(ta.getFName());
					lNames.setText(ta.getLName());
					for(CRN addCRN: ta.getTAsCRN()){
						courseCRN.addItem(addCRN);
					}
					schedule = ta.getSchedule();
				}
			}
		});
		
		rmv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				tempCRNs.remove(taing.getSelectedItem());
				taing.removeItem(taing.getSelectedItem());
			}
		});
		
		/*ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(Main.getLoggedIn()){
					TeachingAssistant ta = (TeachingAssistant) taNames.getSelectedItem();
					ta.setFName(fNames.getText());
					ta.setLName(lNames.getText());
					ta.setSchedule(schedule);
				}
				dispose();

			}
		});
		*/
		scheduleB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				new ScheduleDialog(thisOwner, "Room Number", schedule);
			}
		});	
		
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				taing.addItem((CRN)crns.getSelectedItem());
				tempCRNs.add((CRN) crns.getSelectedItem());
			}
		});
		
		//might have to look up TA because of what getSelectedItem potentially returns
		rmvTA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Main.getCurrent().remove((TeachingAssistant) tas.getSelectedItem());
				
			}
		});
		
		addTA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(Main.getLoggedIn()){
					Main.getCurrent().addTeachingAssistant(new TeachingAssistant(fNames.getText(),lNames.getText(),schedule));
				}
				dispose();
			}
		});
		setVisible(true);
	}
	
	
	
	
	public void addItems(Semester semester){
		if(semester == null){
			return;
		}
		for(TeachingAssistant addTA : semester.getTeachingAssistants()){
			taNames.addItem(addTA);
		}
	}
	
	public void setSchedule(Schedule sched){
		schedule = sched;
	}
	

	
	
	
}