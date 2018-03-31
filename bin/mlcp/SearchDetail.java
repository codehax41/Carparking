package mlcp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SearchDetail extends  Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
JButton b1,b2,b3;
ImageIcon ic,ic1,ic2,ic3;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;


Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public SearchDetail()
{
ic=new ImageIcon("searchcarr.jpg");
ic2=new ImageIcon("backb.jpg");
ic3=new ImageIcon("exitb.jpg");	
ic1=new ImageIcon("searchb.jpg");	
	
l1=new JLabel("P ID Or RC No.");
l1.setFont(new Font("Serif",Font.PLAIN,20));
l2=new JLabel("Owner Name");
l2.setFont(new Font("Serif",Font.PLAIN,20));	
l3=new JLabel("Address");
l3.setFont(new Font("Serif",Font.PLAIN,20));
l4=new JLabel("Contact No.");
l4.setFont(new Font("Serif",Font.PLAIN,20));
l5=new JLabel("Parking Time");
l5.setFont(new Font("Serif",Font.PLAIN,20));
l6=new JLabel("Parking Date");
l6.setFont(new Font("Serif",Font.PLAIN,20));
l7=new JLabel("Model of car");
l7.setFont(new Font("Serif",Font.PLAIN,20));
l8=new JLabel("Label No.");
l8.setFont(new Font("Serif",Font.PLAIN,20));
l9=new JLabel("Track No.");
l9.setFont(new Font("Serif",Font.PLAIN,20));
l10=new JLabel("Rs.2/- Per Hour");
l10.setForeground(Color.white);
l10.setFont(new Font("Serif",Font.PLAIN,20));
l11=new JLabel("Date");
l11.setFont(new Font("Serif",Font.PLAIN,20));
l12=new JLabel("Time");
l12.setFont(new Font("Serif",Font.PLAIN,20));	
l13=new JLabel("Total HRS");
l13.setFont(new Font("Serif",Font.PLAIN,20));
l14=new JLabel("Amount");
l14.setFont(new Font("Serif",Font.PLAIN,20));




b1=new JButton("");
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.setBorderPainted(false);
b1.addActionListener(this);
b1.setToolTipText("Click to update release car");

b2=new JButton("");
b2.setOpaque(false);
b2.setContentAreaFilled(false);
b2.setBorderPainted(false);
b2.addActionListener(this);
b2.setToolTipText("Click to close and do exit");

b3=new JButton("");
b3.setOpaque(false);
b3.setContentAreaFilled(false);
b3.setBorderPainted(false);
b3.addActionListener(this);
b3.setToolTipText("Click to close and do exit");

t1=new JTextField();
t1.setOpaque(false);
t2=new JTextField();
t2.setOpaque(false);
t3=new JTextField();
t3.setOpaque(false);
t4=new JTextField();
t4.setOpaque(false);
t5=new JTextField();
t5.setOpaque(false);
t6=new JTextField();
t6.setOpaque(false);
t7=new JTextField();
t7.setOpaque(false);
t8=new JTextField();
t8.setOpaque(false);
t9=new JTextField();
t9.setOpaque(false);
t11=new JTextField();
t11.setOpaque(false);
t12=new JTextField();
t12.setOpaque(false);
t13=new JTextField();
t13.setOpaque(false);
t14=new JTextField();
t14.setOpaque(false);

l17=new JLabel("",ic,JLabel.CENTER);
l18=new JLabel("",ic1,JLabel.CENTER);
l19=new JLabel("",ic2,JLabel.CENTER);
l20=new JLabel("",ic3,JLabel.CENTER);
}
public void setUpSearchDetail()
{
frm=new Frame("Search Detail");
frm.setLayout(null);
frm.setSize(1000,600);
frm.setLocation(150,50);

l1.setBounds(20,140,150,25);
frm.add(l1);
t1.setBounds(170,140,150,25);
frm.add(t1);

l2.setBounds(20,170,150,25);
frm.add(l2);
t2.setBounds(170,170,150,25);
frm.add(t2);

l3.setBounds(20,200,150,25);
frm.add(l3);
t3.setBounds(170,200,150,25);
frm.add(t3);

l4.setBounds(20,230,150,25);
frm.add(l4);
t4.setBounds(170,230,150,25);
frm.add(t4);

l5.setBounds(20,260,150,25);
frm.add(l5);
t5.setBounds(170,260,150,25);
frm.add(t5);

l6.setBounds(20,290,150,25);
frm.add(l6);
t6.setBounds(170,290,150,25);
frm.add(t6);

l7.setBounds(20,320,150,25);
frm.add(l7);
t7.setBounds(170,320,150,25);
frm.add(t7);

l8.setBounds(20,350,150,25);
frm.add(l8);
t8.setBounds(170,350,150,25);
frm.add(t8);

l9.setBounds(20,380,150,25);
frm.add(l9);
t9.setBounds(170,380,150,25);
frm.add(t9);


l10.setBounds(800,230,150,25);
frm.add(l10);

l11.setBounds(500,140,150,25);
frm.add(l11);
t11.setBounds(600,140,150,25);
frm.add(t11);

l12.setBounds(500,170,150,25);
frm.add(l12);
t12.setBounds(600,170,150,25);
frm.add(t12);

l13.setBounds(500,200,150,25);
frm.add(l13);
t13.setBounds(600,200,150,25);
frm.add(t13);

l14.setBounds(500,230,150,25);
frm.add(l14);
t14.setBounds(600,230,150,25);
frm.add(t14);

b1.setBounds(300,500,100,25);
frm.add(b1);
b2.setBounds(450,500,100,25);
frm.add(b2);
b3.setBounds(350,140,100,25);
frm.add(b3);

l20.setBounds(300,500,100,25);
frm.add(l20);
l19.setBounds(450,500,100,25);
frm.add(l19);
l18.setBounds(350,140,100,25);
frm.add(l18);

l17.setBounds(0,0,1000,600);
frm.add(l17);


connect();
frm.setVisible(true);
}
public void getData()
{
	try
	{
	a1=t1.getText();
	a2=t2.getText();
	a3=t3.getText();
	a4=t4.getText();
	a5=t5.getText();
	a6=t6.getText();
	a7=t7.getText();
	a8=t8.getText();
	a9=t9.getText();
	
	a10=t11.getText();
	a11=t12.getText();
	a12=t13.getText();
	a13=t14.getText();
	}
	catch(Exception ex)
	{
		System.out.println("getData equals="+ex);
	}
}
public void connect()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:MLCP");
}
catch(Exception ex)
{
System.out.println("connection Error="+ex);
}
}
public void searchData()
{ 
  a1=t1.getText();
	try
	{
		
		a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from parkingRelease where parkingID='"+a1+"'");//
		if(rst.next())
		{   
	      t2.setText(rst.getString(2));
		  t3.setText(rst.getString(4));
		  t4.setText(rst.getString(5));
		  t5.setText(rst.getString(6));
		  t6.setText(rst.getString(7));
		  t7.setText(rst.getString(8));
		  t8.setText(rst.getString(9));
		  t9.setText(rst.getString(10));
		  t11.setText(rst.getString(11));
		  t12.setText(rst.getString(12));
		  t13.setText(rst.getString(13));
		  t14.setText(rst.getString(14));
		}
		else
		{   String dialogtittle="Incorrect Parking ID";
		String dialogmessage="Warning!";
		int dialogtype=JOptionPane.PLAIN_MESSAGE;
			 dialogtype=JOptionPane.WARNING_MESSAGE;
            JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
		}
		} 
	catch(Exception ex)
	{
		System.out.println("getParkingRecord Error=+ex");
	}
}
public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b1)//searh parking id
	{   
	    	System.exit(0);
	}
	if(ae.getSource()==b3)//release
	{  
	   connect();
       searchData();
	    	
	}
	if(ae.getSource()==b2)
	{  
	    frm.setVisible(false);
        Parking ob=new Parking();
	    ob.setUpParking();
	}
}
}




	
    
