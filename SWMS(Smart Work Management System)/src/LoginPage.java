import java.awt.*;
import java.awt.event.*;

public class LoginPage {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public LoginPage(){
      prepareGUI();
   }

   public static void main(String[] args){
	   LoginPage  awtControlDemo = new LoginPage();
      awtControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Smart Work Managemetn System (SWMS)");
      mainFrame.setSize(407,225);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setForeground(new Color(128, 0, 64));
      headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showButtonDemo(){
      headerLabel.setText("LOGIN AS?"); 

      Button okButton = new Button("Manager");
      okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
      okButton.setBounds(35, 10, 149, 45);
      Button submitButton = new Button("Employee");
      submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
      submitButton.setBounds(213, 10, 149, 45);

      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 manager_details window = new manager_details();
				window.frame.setVisible(true);
			
            mainFrame.setVisible(false); 
         }
      });

      submitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 emp_options  awtControlDemo = new emp_options();
             awtControlDemo.showButtonDemo();
             mainFrame.setVisible(false);  
         }
      });
      controlPanel.setLayout(null);


      controlPanel.add(okButton);
      controlPanel.add(submitButton);
      mainFrame.setVisible(true);
      mainFrame.setLocationRelativeTo(null);
   }
}