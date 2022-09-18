import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class view_manager extends JFrame implements ActionListener {
    JFrame frame1;
    JLabel l0, l1, l2;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table;
    String[] columnNames = {"Id", "Name", "Management", "Mobile Number", "Email"};
    String from;
    private JTextField c1;
    view_manager() {
        l0 = new JLabel("SEARCH MANAGER");
        l0.setForeground(new Color(128, 0, 64));
        l0.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1 = new JLabel("Enter Name :");
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1 = new JButton("Submit");
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        l0.setBounds(118, 31, 214, 40);
        l1.setBounds(65, 109, 95, 26);
        b1.setBounds(256, 180, 150, 20);
        b1.addActionListener(this);
        setTitle("Fetching Manager Details....");
        getContentPane().setLayout(null);
        setVisible(true);
        setSize(444, 268);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(l0);
        getContentPane().add(l1);;
        getContentPane().add(b1);
        setLocationRelativeTo(null);

        
        c1 = new JTextField();
        c1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c1.setBounds(160, 110, 246, 25);
        getContentPane().add(c1);
        c1.setColumns(10);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/abccompany","root","root123");
            st = con.createStatement();
            rs = st.executeQuery("select name from manager");
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
        String id = "";
        String name = "";
        String management = "";
        String mobnumber = "";
        String email = "";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3305/abccompany","root","root123");
            pst = con.prepareStatement("select * from manager where name='" + from + "'");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            if (rs.next()) {
            	id = rs.getString("id");
                name = rs.getString("name");
                management = rs.getString("management");
                mobnumber = rs.getString("mobnumber");
                email = rs.getString("email");
                model.addRow(new Object[]{id, name, management, mobnumber, email});
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
        frame1.setLocationRelativeTo(null);
    }
    public static void main(String args[]) {
    	new view_manager();
        
    }
}