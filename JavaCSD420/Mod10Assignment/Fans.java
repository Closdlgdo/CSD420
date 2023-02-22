
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Fans {

	int id;
	String firstName, lastName, favTeam;
	public static void main(String[] args) {
		start();
	}
	private static void start() {

		JFrame f = new JFrame();
		JLabel l1 = new JLabel("Enter Id:");
		JTextField t1 = new JTextField(10);
		JButton disp = new JButton("Display");
		JButton update= new JButton("Update");
		JLabel err = new JLabel();
		err.setForeground(Color.red);
		err.setVisible(false);
		
		disp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Fans f = null;
				try {
					int id = Integer.parseInt(t1.getText().toString());
					f=getRecord(id);
					if(f!=null) {
						display(f);
					}else {
						err.setText("No matched data found! Try Again.");
						err.setVisible(true);
					}
				}catch(Exception e1) {
					err.setText("Please enter a valid numeric id to be searched");
					err.setVisible(true);
				}
				
			}
		});
		
		update.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				Fans f = null;
				try {
					int id = Integer.parseInt(t1.getText().toString());
					f=getRecord(id);
					if(f!=null) {
						update(f);
					}else {
						err.setText("No matched data found! Try Again.");
						err.setVisible(true);
					}
				}catch(Exception e1) {
					err.setText("Please enter a valid numeric id to be searched");
					err.setVisible(true);
				}
			}
			
		});
		JPanel p1 = new JPanel();
		p1.add(l1);
		p1.add(t1);
		JPanel p2 = new JPanel();
		p2.add(disp);
		p2.add(update);
		
		JPanel p3 = new JPanel();
		p3.add(err);
		
		f.setLayout(new GridLayout(3,1));
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.setVisible(true);
	    f.setBounds(200, 200, 600, 400);
		f.setSize(400, 200);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	
	}
	
	
	
	private static Fans getRecord(int id) throws SQLException {

		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/database1?","student1","pass");  
				  
				String QUERY="select * from fans where id="+"'"+id+"'";
				Statement stmt=con.prepareStatement(QUERY);  
				  
				//step4 execute query  
				ResultSet rs=stmt.executeQuery(QUERY);  
				Fans f = null;
				while(rs.next()) {
					f = new Fans();
			    f.id=rs.getInt(1);
			    f.firstName=rs.getString(2);
			    f.lastName=rs.getString(3);
			    f.favTeam=rs.getString(4);
				}
				con.close();  
		return f;
	}
	
	private static void updateRecord(int id, String fname, String lname, String favTeam) throws SQLException {
		
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/database1?","student1","pass");  
				  
				String QUERY="update fans set firstname="+"'"+fname+"'"+", lastname='"+lname+"', favoriteteam='"+favTeam+"' where id="+id;
				Statement stmt=con.prepareStatement(QUERY);  
				  
				//step4 execute query  
				stmt.executeUpdate(QUERY); 
				con.close(); 
	}
	
	private static void display(Fans f) {
		JFrame f1 =new  JFrame();
		JLabel l1 = new JLabel("ID: "+f.id);
		JLabel l2 = new JLabel("First Name: "+f.firstName);
		JLabel l3 = new JLabel("LastName: "+f.lastName);
		JLabel l4 = new JLabel("Favorite Team: "+f.favTeam);
		JButton b = new JButton("OK!");
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				f1.dispose();
			}			
		});
		JPanel p1 = new JPanel();
		p1.add(l1);
		JPanel p4 = new JPanel();
		p4.add(l4);
		JPanel p2 = new JPanel();
		p2.add(l2);
		JPanel p3 = new JPanel();
		p3.add(l3);
		JPanel p5 = new JPanel();
		p5.add(b);
		
		f1.add(p1);
		f1.add(p2);
		f1.add(p3);
		f1.add(p4);
		f1.add(p5);
		f1.setLayout(new GridLayout(5,1));
		f1.setVisible(true);
		f1.setSize(400, 300);
	}
	
	
	private static void update(Fans f) {
				
		JFrame f1 =new  JFrame();
		JLabel l1 = new JLabel("First Name: ");
		JTextField t1 = new JTextField(f.firstName,20);
		
		JLabel l2 = new JLabel("Last Name: ");
		JTextField t2 = new JTextField(f.lastName,20);

		JLabel l3 = new JLabel("Favorite Team: ");
		JTextField t3 = new JTextField(f.favTeam,20);

		JButton b = new JButton("update");
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				updateRecord(f.id,t1.getText().toString(),t2.getText().toString(),t3.getText().toString());
				JOptionPane.showMessageDialog(null, "Record updated Successfully!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Can not update record! Try Again");
				}
				f1.dispose();
			}			
		});
		
		JPanel p1 = new JPanel();
		p1.add(l1);
		p1.add(t1);
		
		JPanel p2 = new JPanel();
		p2.add(l2);
		p2.add(t2);
		
		JPanel p3 = new JPanel();
		p3.add(l3);
		p3.add(t3);

		JPanel p4 = new JPanel();
		p4.add(b);
		
		f1.add(p1);
		f1.add(p2);
		f1.add(p3);
		f1.add(p4);
		f1.setLayout(new GridLayout(4,1));
		f1.setVisible(true);
		f1.setSize(400, 300);
	}
}