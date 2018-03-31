package mlcp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.DriverManager;
public class Parking extends Frame implements ActionListener,ItemListener
{
Date dt;
int s=0;
Random rd;
Frame frm;
String str="AVAIL",str2="RESERVED";
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
Choice ch1;
ImageIcon ic,ic1,ic2,ic3,ic4,ic5,ic6,ic7,ic8;
JButton b1,b2,b3,b4,b5,b6,b7,b8;
String a22,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public Parking()
{
ic=new ImageIcon("main1.jpg");
ic1=new ImageIcon("exitb.jpg");
ic2=new ImageIcon("level.jpg");
ic3=new ImageIcon("releasebb.jpg");
ic4=new ImageIcon("parkb.jpg");
ic5=new ImageIcon("logout.jpg");
ic6=new ImageIcon("map.jpg");
ic7=new ImageIcon("updatepark.jpg");
ic8=new ImageIcon("searchbu.jpg");

rd=new Random();
dt=new Date();

l1=new JLabel("Parkind ID");
l1.setFont(new Font("Serif",Font.PLAIN,20));
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
l13=new JLabel("",ic1,JLabel.CENTER);
l14=new JLabel("",ic2,JLabel.CENTER);
l15=new JLabel("",ic3,JLabel.CENTER);
l16=new JLabel("",ic4,JLabel.CENTER);
l17=new JLabel("",ic5,JLabel.CENTER);
l18=new JLabel("",ic6,JLabel.CENTER);
l19=new JLabel("",ic7,JLabel.CENTER);
l20=new JLabel("",ic8,JLabel.CENTER);

b1=new JButton("");
b1.addActionListener(this);
b1.setToolTipText("Click to submit detail");
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.setBorderPainted(false);

b2=new JButton("");
b2.addActionListener(this);
b2.setToolTipText("Click to close and do exit");
b2.setOpaque(false);
b2.setContentAreaFilled(false);
b2.setBorderPainted(false);

b3=new JButton("");
b3.addActionListener(this);
b3.setOpaque(false);
b3.setContentAreaFilled(false);
b3.setBorderPainted(false);

b4=new JButton("");
b4.addActionListener(this);
b4.setOpaque(false);
b4.setContentAreaFilled(false);
b4.setBorderPainted(false);

b5=new JButton("");
b5.addActionListener(this);
b5.setOpaque(false);
b5.setContentAreaFilled(false);
b5.setBorderPainted(false);

b6=new JButton("");
b6.addActionListener(this);
b6.setOpaque(false);
b6.setContentAreaFilled(false);
b6.setBorderPainted(false);

b7=new JButton("");
b7.addActionListener(this);
b7.setOpaque(false);
b7.setContentAreaFilled(false);
b7.setBorderPainted(false);

b8=new JButton("");
b8.addActionListener(this);
b8.setOpaque(false);
b8.setContentAreaFilled(false);
b8.setBorderPainted(false);

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
}
public void setUpParking()
{
frm=new Frame("Parking Detail");
frm.setLayout(null);
frm.setSize(900,600);
frm.setLocation(200,75);
l11.setBounds(20,40,300,25);
frm.add(l11);

l1.setBounds(20,170,150,25);
frm.add(l1);
t1.setBounds(170,170,150,25);
frm.add(t1);

l2.setBounds(20,200,150,25);
frm.add(l2);
t2.setBounds(170,200,150,25);
frm.add(t2);

l3.setBounds(20,230,150,25);
frm.add(l3);
t3.setBounds(170,230,150,25);
frm.add(t3);

l4.setBounds(20,260,150,25);
frm.add(l4);
t4.setBounds(170,260,150,25);
frm.add(t4);

l5.setBounds(20,290,150,25);
frm.add(l5);
t5.setBounds(170,290,150,25);
frm.add(t5);

l6.setBounds(20,320,150,25);
frm.add(l6);
t6.setBounds(170,320,150,25);
frm.add(t6);

l7.setBounds(20,350,150,25);
frm.add(l7);
t7.setBounds(170,350,150,25);
frm.add(t7);

l8.setBounds(20,380,150,25);
frm.add(l8);
ch1=new Choice();
ch1.setBounds(170,380,150,50);
ch1.add("Honda");
ch1.add("Audi");
ch1.add("Farari");
ch1.add("Jaguar");
ch1.add("Hyundai");
ch1.add("Maruti");
ch1.add("Mahindra");
ch1.add("BMW");
ch1.add("Chevrolet");
ch1.add("Fiat");
ch1.add("Lamborgini");
ch1.add("Nissan");
frm.add(ch1);


l9.setBounds(20,410,150,25);
frm.add(l9);
t8.setBounds(170,410,150,25);
frm.add(t8);


l10.setBounds(20,440,150,25);
frm.add(l10);
t9.setBounds(170,440,150,25);
frm.add(t9);

b1.setBounds(30,530,100,25);
frm.add(b1);
b2.setBounds(170,530,100,25);
frm.add(b2);
b3.setBounds(700,150,150,25);
frm.add(b3);
b4.setBounds(700,200,150,25);
frm.add(b4);
b5.setBounds(700,250,150,25);
frm.add(b5);
b6.setBounds(700,300,150,25);
frm.add(b6);

b8.setBounds(700,350,150,25);
frm.add(b8);

b7.setBounds(700,400,150,25);
frm.add(b7);

l18.setBounds(700,350,150,25);
frm.add(l18);

l20.setBounds(700,250,150,25);
frm.add(l20);

l19.setBounds(700,300,150,25);
frm.add(l19);

l17.setBounds(700,400,150,25);
frm.add(l17);

l16.setBounds(30,530,100,25);
frm.add(l16);

l15.setBounds(700,150,150,25);
frm.add(l15);

l14.setBounds(700,200,150,25);
frm.add(l14);

l13.setBounds(170,530,100,25);
frm.add(l13);

l12.setBounds(0,35,900,600);
frm.add(l12);

t1.setText(""+rd.nextInt(1000));
t7.setText(""+dt);



String s1=t7.getText();  //time from date
String s2=s1.substring(11,20);
t6.setText(""+s2);

String s3=t7.getText();
String s4=s3.substring(0,10);
t7.setText(""+s4);
a22=t1.getText();
connect();
getTrackNo();
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
	a8=ch1.getSelectedItem();
	a9=t8.getText();
	a10=t9.getText();
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
public void PutData()
{
try
{
pst=con.prepareStatement("insert into parkingDetail values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"')");
pst.executeUpdate();
}
catch(Exception ex)
{
System.out.println("Error in insert"+ex);
}
}
public void updateData()   //protocol= jdbc odbc=sub protocol//
{
try
{
pst=con.prepareStatement("update trackInfo set Status='"+str2+"' where LN='"+a9+"' and TN='"+a10+"'");
pst.executeUpdate();
}
catch(Exception ex)
{
System.out.println("Error in insert"+ex);
}
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		getData();
		connect();
		PutData();
		updateData();
		
		
		  //frm.setVisible(false);
	       //TrackProcess ob=new TrackProcess(a9,a10);
	       //ob.setUpTrackProcess();
		
		
		
		String dialogtittle="Fill all field";
		String dialogmessage="Warning!";
		
		String dialogtittle1="Successfully Recorder";
		String dialogmessage1="Great!";
		
		int dialogtype=JOptionPane.PLAIN_MESSAGE;
		
		
		if(a2.equals("")||(a3.equals("")||(a4.equals("")||(a5.equals("")||(a8.equals(""))))))
		{
            dialogtype=JOptionPane.WARNING_MESSAGE;
            JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
		}
		else		   
		
	    {
			dialogtype=JOptionPane.INFORMATION_MESSAGE;
		    JOptionPane.showMessageDialog((Component)null,dialogtittle1,dialogmessage1,dialogtype);
	     

		   frm.setVisible(false);
	       TrackProcess ob=new TrackProcess(a9,a10,a22);
	       ob.setUpTrackProcess(); 
		}
		
	}
    else if(ae.getSource()==b2)
	{
		System.exit(0);
	}
	else if(ae.getSource()==b3)
	{
		frm.setVisible(false);
	    ParkingRelease ob=new ParkingRelease();
	    ob.setUpParkingRelease();
	}
	else if(ae.getSource()==b4)
	{
		frm.setVisible(false);
        AddLevel ob=new AddLevel();
	    ob.setUpAddLevel();
	}
	else if(ae.getSource()==b5)
	{
		frm.setVisible(false);
	    SearchDetail ob=new SearchDetail();
	    ob.setUpSearchDetail();
	}
	else if(ae.getSource()==b6)
	{
		frm.setVisible(false);
        UpdateParking ob=new UpdateParking();
	    ob.setUpUpdateParking();
	}
	else if(ae.getSource()==b7)
	{
		frm.setVisible(false);
        LogIn ob=new LogIn();
	    ob.setUpLogIn();
	}
	else if(ae.getSource()==b8)
	{
		frm.setVisible(false);
        ParkingMap ob=new ParkingMap();
	    ob.setUpParkingMap();
	}
}  
public void getTrackNo()
{
	try
	{
		stat=con.createStatement();
		rst=stat.executeQuery("select * from trackInfo where Status='"+str+"'");
		if(rst.next())
		{
			t8.setText(rst.getString(1));
			t9.setText(rst.getString(2));
		}
	}
	catch(Exception ex)
	{
		System.out.println("getTrackNo. Error=+ex");
	}
}
public void itemStateChanged(ItemEvent ie)
{
	if(ie.getSource()==ch1)
{	
getTrackNo();
}
}
}