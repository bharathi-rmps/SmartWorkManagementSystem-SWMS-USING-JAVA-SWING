import java.awt.*;
import java.awt.event.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class emp_options {

   private Frame mainFrame;
   private Label headerLabel;
   private Panel controlPanel;

   public emp_options(){
      prepareGUI();
   }

   public static void main(String[] args){
	   emp_options  awtControlDemo = new emp_options();
      awtControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Employee Options");
      mainFrame.setSize(460,266);
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

      controlPanel = new Panel();

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
   }

   void showButtonDemo(){
      headerLabel.setText("EMPLOYEE PORTAL"); 

      Button reg = new Button("Register as Employee");
      reg.setFont(new Font("Tahoma", Font.PLAIN, 16));
      reg.setBounds(23, 10, 182, 61);
      Button view = new Button("View Employees");
      view.setFont(new Font("Tahoma", Font.PLAIN, 16));
      view.setBounds(232, 10, 188, 61);

      reg.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	JMenuBar mb;
    		JMenu x;
    		JMenuItem m1, m2;
    		MyFrame f = new MyFrame();
    		mb = new JMenuBar();
    	    x = new JMenu("Menu");
            m1 = new JMenuItem("Manager");
            m2 = new JMenuItem("Employee View");
            m2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		new view_emp_byname();
            		f.setVisible(false);
            	}
            });
            x.add(m1);
            x.add(m2);
            mb.add(x);
            f.setJMenuBar(mb);
            f.setVisible(true);
            mainFrame.setVisible(false); 
         }
      });

      view.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 new view_emp_byname();
        	 mainFrame.setVisible(false); 
         }
      });
      controlPanel.setLayout(null);


      controlPanel.add(reg);
      controlPanel.add(view);
      mainFrame.setVisible(true);  
      mainFrame.setLocationRelativeTo(null);
   }
}