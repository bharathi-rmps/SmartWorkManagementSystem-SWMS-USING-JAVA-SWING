import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class appraisal extends JFrame implements ActionListener {
    JFrame frame1;
    JLabel l0, l1, l2;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table;
    String[] columnNames = {"Employee ", "Manager Name", "Manager ID", "Performance", "Contribution"};
    String from;
    private JTextField c1;
    appraisal() {
        l0 = new JLabel("FETCH APPRAISAL DETAILS");
        l0.setForeground(new Color(128, 0, 64));
        l0.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1 = new JLabel("Enter Name :");
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1 = new JButton("Submit");
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l0.setBounds(81, 43, 285, 40);
        l1.setBounds(53, 110, 89, 31);
        b1.setBounds(256, 182, 150, 20);
        b1.addActionListener(this);
        setTitle("Fetching Appraisal Details....");
        getContentPane().setLayout(null);
        setVisible(true);
        setSize(444, 266);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(l0);
        getContentPane().add(l1);;
        getContentPane().add(b1);
        setLocationRelativeTo(null);

        
        c1 = new JTextField();
        c1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c1.setBounds(144, 112, 262, 29);
        getContentPane().add(c1);
        c1.setColumns(10);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/abccompany","root","root123");
            st = con.createStatement();
            rs = st.executeQuery("select name from appraisal");
            Vector v = new Vector();
            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            showTableData();
        }
    }
    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setLayout(new BorderLayout());
        frame1.setLocationRelativeTo(null);
        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        from = (String) c1.getText();
        //String textvalue = textbox.getText();
        String ename = "";
        String mname = "";
        String performance = "";
        String contribution = "";
        String m_id = "";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3305/abccompany","root","root123");
            pst = con.prepareStatement("select * from appraisal where ename='" + from + "'");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            if (rs.next()) {
            	ename = rs.getString("ename");
            	mname = rs.getString("mname");
            	performance = rs.getString("performance");
            	contribution = rs.getString("contribution");
            	m_id = rs.getString("m_id");
                model.addRow(new Object[]{ename, mname, m_id, performance, contribution});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.getContentPane().add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }
    public static void main(String args[]) {
    	new appraisal();
        
    }
}