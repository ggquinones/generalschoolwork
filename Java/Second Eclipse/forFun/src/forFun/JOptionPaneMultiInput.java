package forFun;

import javax.swing.*;

public class JOptionPaneMultiInput {
   public static void main(String[] args) {
	   
      JTextField numberOfFlowers = new JTextField(5);
      JTextField numberOfCenterPieces = new JTextField(5);
      JTextField numberOfAccessories = new JTextField(5);
      
      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Flowers:"));
      myPanel.add(numberOfFlowers);				  // adds input boxes
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Center Pieces:"));
      myPanel.add(numberOfCenterPieces);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Accessories:"));
      myPanel.add(numberOfAccessories);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         System.out.println("x value: " + numberOfFlowers.getText());
         System.out.println("y value: " + numberOfCenterPieces.getText());
         System.out.println("z value: " + numberOfAccessories.getText());
         
      }

   }
}