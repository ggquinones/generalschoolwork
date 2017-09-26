import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Runner 
{

	public static void main(String[] args) 
	{
		setLookandFeel();
		File srcDirectory = getSourceDirectory();
		if(srcDirectory == null)
		{
			System.out.println("No Directory Selected");
			System.exit(0);
		}
		
		File destDirectory  = getDestinationDirectory();
		if(destDirectory == null)
		{
			System.out.println("No Directory Selected");
			System.exit(0);
		}
			    
		
		
		for(File currFile:srcDirectory.listFiles())
		{
			
			System.out.println("-----------*UNZIPPING NOISE*-----------");
			try {
				// Initiate ZipFile object with the path/name of the zip file.
				ZipFile zipFile = new ZipFile(currFile);
				
				// Extracts all files to the path specified
				zipFile.extractAll(destDirectory.getPath());
				
			} catch (ZipException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---------EXTRACTION COMPLETE-----------");
		JOptionPane.showMessageDialog(null,"TA Extractor Tool 1.0","---------EXTRACTION COMPLETE-----------",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
 
	/**
	 * Method that uses a JFileChooser to let the user navigate their system and select the directory containing all
	 * the zipped files they wish to extract.
	 * 
	 * Input: Takes no parameters.
	 * Output: return the directory the user chooses as a File object, returns null if no file is chosen!
	 * @return  
	 */
	public static File getSourceDirectory()
	{		
		
		JFileChooser chooser = new JFileChooser(new File("c:/users/gabriel/desktop"));
	    chooser.setDialogTitle("Choose Source Directory");
	    chooser.setPreferredSize(new Dimension(800, 600));
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {	       
	           return chooser.getSelectedFile();
	    }
	    return null;
	}
	
	/**
	 * Method that uses a JFileChooser to let the user navigate their system and select the directory where they would like
	 * their unzipped folders to go.
	 * 
	 * Input: Takes no parameters.
	 * Output: return the directory the user chooses as a File object, returns null if no file is chosen!
	 * @return  
	 */
	public static File getDestinationDirectory()
	{
		JFileChooser chooser = new JFileChooser(new File("c:/users/gabriel/desktop"));
	    chooser.setDialogTitle("Choose Destination Directory");
	    chooser.setPreferredSize(new Dimension(800, 600));
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {	       
	           return chooser.getSelectedFile();
	    }
	    return null;
	}
	
	/**
	 * Makes look and feel of User Interfaces that of the user's system.
	 */
	private static void setLookandFeel()
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

}
