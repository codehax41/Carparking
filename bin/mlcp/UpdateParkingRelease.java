package mlcp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateParkingRelease extends  Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
JButton b1,b2,b3;
ImageIcon ic;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;


Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public UpdateParkingRelease()
{	
l1=new JLabel("Parkind ID");
l1.setFont(new Font("Serif",Font.PLAIN,20));//date,time,amt,hrs
l2=new JLabel("Owner Name");
l2.setFont(new Font("Serif",Font.PLAIN,20));	
l3=new JLabel("RC No.");
l3.setFont(new Font("Serif",Font.PLAIN,20));
l4=new JLabel("Address");
l4.setFont(new Font("Serif",Font.PLAIN,20));
l5=new JLabel("Contact No.");
l5.setFont(new Font("Serif",Font.PLAIN,20));
l6=new JLabel("Parking Time");
l6.setFont(new Font("Serif",Font.PLAIN,20));
l7=new JLabel("Parking Date");
l7.setFont(new Font("Serif",Font.PLAIN,20));
l8=new JLabel("Model of car");
l8.setFont(new Font("Serif",Font.PLAIN,20));
l9=new JLabel("Label No.");
l9.setFont(new Font("Serif",Font.PLAIN,20));
l10=new JLabel("Track No.");
l10.setFont(new Font("Serif",Font.PLAIN,20));
l11=new JLabel("");
l11.setFont(new Font("Serif",Font.PLAIN,20));
l12=new JLabel("",ic,JLabel.CENTER);
l13=new JLabel("Date");
l13.setFont(new Font("Serif",Font.PLAIN,20));//date,time,amt,hrs
l14=new JLabel("Time");
l14.setFont(new Font("Serif",Font.PLAIN,20));	
l15=new JLabel("Total HRS");
l15.setFont(new Font("Serif",Font.PLAIN,20));
l16=new JLabel("Amount");
l16.setFont(new Font("Serif",Font.PLAIN,20));


b1=new JButton("Update");
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.addActionListener(this);
b1.setToolTipText("Click to update release car");
b2=new JButton("Close");
b2.setOpaque(false);
b2.setContentAreaFilled(false);
b2.addActionListener(this);
b2.setToolTipText("Click to close and do exit");

b3=new JButton("Search");
b3.setOpaque(false);
b3.setContentAreaFilled(false);
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
t10=new JTextField();
t10.setOpaque(false);
t11=new JTextField();
t11.setOpaque(false);
t12=new JTextField();
t12.setOpaque(false);
t13=new JTextField();
t13.setOpaque(false);
t14=new JTextField();
t14.setOpaque(false);
}
public void setUpUpdateParkingRelease()
{
frm=new Frame("Updating Parking Release");
frm.setLayout(null);
frm.setSize(900,600);
frm.setLocation(200,75);
l11.setBounds(20,40,300,25);
frm.add(l11);

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


l10.setBounds(20,410,150,25);
frm.add(l10);
t10.setBounds(170,410,150,25);
frm.add(t10);

l13.setBounds(400,320,150,25);
frm.add(l13);
t11.setBounds(500,320,150,25);
frm.add(t11);

l14.setBounds(400,350,150,25);
frm.add(l14);
t12.setBounds(500,350,150,25);
frm.add(t12);

l15.setBounds(400,380,150,25);
frm.add(l15);
t13.setBounds(500,380,150,25);
frm.add(t13);

l16.setBounds(400,410,150,25);
frm.add(l16);
t14.setBounds(500,410,150,25);
frm.add(t14);

b1.setBounds(300,500,100,25);
frm.add(b1);
b2.setBounds(450,500,100,25);
frm.add(b2);
b3.setBounds(350,140,100,25);
frm.add(b3);

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
	a10=t10.getText();
	a11=t11.getText();
	a12=t12.getText();
	a13=t13.getText();
	a14=t14.getText();
	}
	catch(Exception ex)
	{
		System.out.println("getData equals="+ex);
	}
}
public void searchData()
{ 
  a1=t1.getText();
	try
	{
		
		a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from parkingRelease where parkingID='"+a1+"'");
		if(rst.next())
		{   
	      t2.setText(rst.getString(2));
		  t3.setText(rst.getString(3));
		  t4.setText(rst.getString(4));
		  t5.setText(rst.getString(5));
		  t6.setText(rst.getString(6));
		  t7.setText(rst.getString(7));
		  t8.setText(rst.getString(8));
		  t9.setText(rst.getString(9));
		  t10.setText(rst.getString(10));
		  t11.setText(rst.getString(11));
		  t12.setText(rst.getString(12));
		  t13.setText(rst.getString(13));
		  t14.setText(rst.getString(14));
		  
		}
       
	} 
	catch(Exception ex)
	{
		System.out.println("getParkingRecord Error=+ex");
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
public void updateData()   //protocol= jdbc odbc=sub protocol//
{
try
{
pst=con.prepareStatement("update parkingRelease set ownerName='"+a2+"',rcno='"+a3+"',address='"+a4+"',contact='"+a5+"',parkingTime='"+a6+"',parkingDate='"+a7+"',model='"+a8+"',date='"+a11+"',time='"+a12+"',totalHRS='"+a13+"',amount='"+a14+"' where parkingID='"+a1+"'");
pst.executeUpdate();
}
catch(Exception ex)
{
System.out.println("Error in insert"+ex);
}
}
public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b3)//searh parking id
	{   
	    connect();
		searchData();	
	}
	if(ae.getSource()==b1)//release
	{  
       getData();
	   connect();
       updateData();
	   
	String dialogtittle="Parking Released Updated";
    String dialogmessage="Great!";
	int dialogtype=JOptionPane.PLAIN_MESSAGE;
	 {
        dialogtype=JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
     }
	    	
	}
	if(ae.getSource()==b2)
	{  
	    System.exit(0);	
	}
}
}








