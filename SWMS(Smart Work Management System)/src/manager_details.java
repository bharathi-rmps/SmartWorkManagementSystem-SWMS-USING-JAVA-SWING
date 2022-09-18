import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class manager_details {

	JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manager_details window = new manager_details();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public manager_details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 522, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGER PORTAL");
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(155, 43, 198, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Managers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view_manager();
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(57, 144, 182, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCheckAppraisals = new JButton("Check Appraisals");
		btnCheckAppraisals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new appraisal();
				frame.setVisible(false);
			}
		});
		btnCheckAppraisals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCheckAppraisals.setBounds(272, 144, 182, 43);
		frame.getContentPane().add(btnCheckAppraisals);
	}

}
