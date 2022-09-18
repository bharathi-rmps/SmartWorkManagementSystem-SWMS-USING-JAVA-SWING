// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.*;

class MyFrame extends JFrame implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel add;
	private JTextArea tadd;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;
	private JTextField tgm;
	private JLabel gm;
	DefaultTableModel model;

	
	private String dates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31" };
	private String months[]
		= { "1", "2", "3", "4",
			"5", "6", "7", "8",
			"9", "10", "11", "12" };
	private String years[]
		= { "1995", "1996", "1997", "1998",
			"1999", "2000", "2001", "2002",
			"2003", "2004", "2005", "2006",
			"2007", "2008", "2009", "2010",
			"2011", "2012", "2013", "2014",
			"2015", "2016", "2017", "2018" };

	// constructor, to initialize the components
	// with default values.
	public MyFrame()
	{
		
		setTitle("Registration Form");
		setBounds(300, 90, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("EMPLOYEE REGISTRATION FORM");
		title.setFont(new Font("Tahuma", Font.PLAIN, 30));
		title.setSize(500, 30);
		title.setLocation(200, 30);
		title.setForeground(new Color(128, 0, 64));
		c.add(title);
		
		name = new JLabel("Name");
		name.setFont(new Font("Tahuma", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Tahuma", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		c.add(tname);

		mno = new JLabel("Mobile");
		mno.setFont(new Font("Tahuma", Font.PLAIN, 20));
		mno.setSize(190, 20);
		mno.setLocation(100, 150);
		c.add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Tahuma", Font.PLAIN, 15));
		tmno.setSize(190, 20);
		tmno.setLocation(200, 150);
		c.add(tmno);
		
		gm = new JLabel("Mail-id");
		gm.setFont(new Font("Tahuma", Font.PLAIN, 20));
		gm.setSize(190, 20);
		gm.setLocation(100, 200);
		c.add(gm);

		tgm = new JTextField();
		tgm.setFont(new Font("Tahuma", Font.PLAIN, 15));
		tgm.setSize(190, 20);
		tgm.setLocation(200, 200);
		c.add(tgm);

		gender = new JLabel("Gender");
		gender.setFont(new Font("Tahuma", Font.PLAIN, 20));
		gender.setSize(100, 20);
		gender.setLocation(100, 250);
		c.add(gender);

		male = new JRadioButton("Male");
		male.setFont(new Font("Tahuma", Font.PLAIN, 15));
		male.setSelected(true);
		male.setSize(75, 20);
		male.setLocation(200, 250);
		c.add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Tahuma", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(80, 20);
		female.setLocation(275, 250);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		dob = new JLabel("DOB");
		dob.setFont(new Font("Tahuma", Font.PLAIN, 20));
		dob.setSize(100, 20);
		dob.setLocation(100, 300);
		c.add(dob);

		date = new JComboBox(dates);
		date.setFont(new Font("Tahuma", Font.PLAIN, 15));
		date.setSize(50, 20);
		date.setLocation(200, 300);
		c.add(date);

		month = new JComboBox(months);
		month.setFont(new Font("Tahuma", Font.PLAIN, 15));
		month.setSize(60, 20);
		month.setLocation(250, 300);
		c.add(month);

		year = new JComboBox(years);
		year.setFont(new Font("Tahuma", Font.PLAIN, 15));
		year.setSize(60, 20);
		year.setLocation(320, 300);
		c.add(year);

		add = new JLabel("Address");
		add.setFont(new Font("Tahuma", Font.PLAIN, 20));
		add.setSize(100, 20);
		add.setLocation(100, 350);
		c.add(add);

		tadd = new JTextArea();
		tadd.setFont(new Font("Tahuma", Font.PLAIN, 15));
		tadd.setSize(200, 75);
		tadd.setLocation(200, 350);
		tadd.setLineWrap(true);
		c.add(tadd);

		term = new JCheckBox("Accept Terms And Conditions.");
		term.setFont(new Font("Tahuma", Font.PLAIN, 15));
		term.setSize(250, 20);
		term.setLocation(150, 450);
		c.add(term);

		sub = new JButton("Submit");
		sub.setFont(new Font("Tahuma", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 500);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Tahuma", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(270, 500);
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setFont(new Font("Tahuma", Font.PLAIN, 20));
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Tahuma", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(150, 550);
		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Tahuma", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		c.add(resadd);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {
			Object[] column = {"name", "mobile","mail_id","gender","dob","address"};
			Object[] row = new Object[6];
			model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
				       
			if (term.isSelected()) {
				
				String data1;
				String data
					= " Name : "
					+ tname.getText() + "\n\n"
					+ " Mobile : "
					+ tmno.getText() + "\n\n";
				
				if (male.isSelected())
					data1 = " Gender : Male"
							+ "\n\n";
				else
					data1 = " Gender : Female"
							+ "\n\n";
				String data2
					= " DOB : " 
					 + (String)year.getSelectedItem()
					+ "." + (String)month.getSelectedItem()
					+ "." + (String)date.getSelectedItem() + "\n\n";

				String data3 = "\n\n Address : " + tadd.getText() + "\n";
				
				String data4 = " Mail id :" + tgm.getText();
				tout.setText(data + data1 + data2 + data4 + data3);
				tout.setEditable(false);
				res.setText("Registered Successfully!!!...");
				String data11;
				if (male.isSelected())
					data11 = "Male";
				else
					data11 = "Female";
				row[0] = tname.getText();
				row[1] = tmno.getText();
				row[2] = tgm.getText();
				row[3] = data11;
				row[4] = (String)year.getSelectedItem()
						+ "." + (String)month.getSelectedItem()
						+ "." + (String)date.getSelectedItem();
				row[5] = tadd.getText();
				
				model.addRow(row);
				try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/abccompany", "root", "root123");

                String query = "INSERT INTO emp_details values('" + row[0] + "','" + row[1] + "','" + row[2] + "','" +
                		row[3] + "','" + row[4] + "','" + row[5] + "')";

                Statement sta = connection.createStatement();
                sta.executeUpdate(query);
				}catch(Exception xx) {
					System.out.println(xx);
				}
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions..");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			tadd.setText(def);
			tmno.setText(def);
			res.setText(def);
			tout.setText(def);
			term.setSelected(false);
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			tgm.setText(def);
			resadd.setText(def);
		}
	}
		
}


// Driver Code
class emp_reg {
	
	public static void main(String[] args) throws Exception
	{
		JMenuBar mb;
		JMenu x;
		JMenuItem m1, m2;
		MyFrame f = new MyFrame();
		f.getContentPane().setForeground(new Color(255, 255, 128));
		f.setLocationRelativeTo(null);
		mb = new JMenuBar();
	    x = new JMenu("Menu");
        m1 = new JMenuItem("Manager");
        m2 = new JMenuItem("Employee View");
        
        m1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		manager_details window = new manager_details();
				window.frame.setVisible(true);
				f.setVisible(false);
        	}
        });
        
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
	}
}

