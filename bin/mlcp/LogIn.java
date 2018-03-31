package mlcp;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class LogIn extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JTextField t1;
JPasswordField t2;
JButton b1,b2,b3,b4;
String a1,a2;
Frame frm;
ImageIcon ic,ic1,ic2,ic3,ic4,ic5,ic6;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;
public LogIn()
{
ic=new ImageIcon("loginp.jpg");
ic1=new ImageIcon("login.jpg");
ic2=new ImageIcon("exitb.jpg");
ic3=new ImageIcon("registerb.jpg");
ic4=new ImageIcon("forgotb.jpg");
ic5=new ImageIcon("lockerb.jpg");
ic6=new ImageIcon("keyb.jpg");

b1=new JButton("");
b1.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b1.addActionListener(this);
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.setBorderPainted(false);

b2=new JButton("");
b2.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b2.addActionListener(this);
b2.setOpaque(false);
b2.setContentAreaFilled(false);
b2.setBorderPainted(false);
b2.setToolTipText("Click to exit");

b3=new JButton("");
b3.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b3.addActionListener(this);
b3.setOpaque(false);
b3.setContentAreaFilled(false);
b3.setBorderPainted(false);
b3.setToolTipText("Click if you forgotten your password");

b4=new JButton("");
b4.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b4.addActionListener(this);
b4.setOpaque(false);
b4.setContentAreaFilled(false);
b4.setBorderPainted(false);
b4.setToolTipText("Click if you forgotten your password");



//b1.setBorderPainted(false); only ok not visible
b1.setToolTipText("Click to go to your account section");



l2=new JLabel("User ID");
l2.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
l3=new JLabel("Password");
l3.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
l4=new JLabel("");
l6=new JLabel("",ic,JLabel.CENTER);
l7=new JLabel("",ic1,JLabel.CENTER);
l8=new JLabel("",ic2,JLabel.CENTER);
l9=new JLabel("",ic3,JLabel.CENTER);
l10=new JLabel("",ic4,JLabel.CENTER);
l11=new JLabel("",ic5,JLabel.CENTER);
l12=new JLabel("",ic6,JLabel.CENTER);

t1=new JTextField();
t1.setOpaque(false);
t2=new JPasswordField();
t2.setOpaque(false);

frm=new Frame("Log In");
}
public void setUpLogIn()
{
frm.setLayout(null);
frm.setSize(500,300);
frm.setLocation(400,200);

//l1.setBounds(230,100,600,50);
//frm.add(l1);

l2.setBounds(110,100,300,25);
frm.add(l2);

l3.setBounds(110,130,300,25);
frm.add(l3);

l4.setBounds(150,190,300,25);
frm.add(l4);

t1.setBounds(220,100,150,25);
frm.add(t1);

t2.setBounds(220,130,150,25);
frm.add(t2);

b1.setBounds(140,200,75,25);
frm.add(b1);

b2.setBounds(260,200,75,25);
frm.add(b2);

b3.setBounds(130,230,90,25);
frm.add(b3);

b4.setBounds(260,230,90,25);
frm.add(b4);

l12.setBounds(310,130,150,25); //keyb
frm.add(l12);
l11.setBounds(310,100,150,25); //locker
frm.add(l11);
l10.setBounds(130,230,90,25); //forgotb
frm.add(l10);
l9.setBounds(260,230,90,25);  //registerb
frm.add(l9);
l8.setBounds(260,200,75,25);  //exit
frm.add(l8);
l7.setBounds(100,200,150,25);  //loginb
frm.add(l7);
l6.setBounds(0,0,500,300);  //pic
frm.add(l6);


frm.setVisible(true);
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
	try
	{
		a1=t1.getText();
	    a2=t2.getText();
		stat=con.createStatement();
		rst=stat.executeQuery("select * from createAccount where userid='"+a1+"' and password='"+a2+"'");
		if(rst.next())
		{   frm.setVisible(false);
			Parking ob=new Parking();
			ob.setUpParking();
		}
		
		
		
	else if(a1.equals("")||(a2.equals("")))
	 {
		 String dialogtittle="Fill all field";
    String dialogmessage="Error!";
	
	int dialogtype=JOptionPane.PLAIN_MESSAGE;
        dialogtype=JOptionPane.WARNING_MESSAGE;
        JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
     }
		
		
       else
      { 
		String dialogtittle="Invalid User ID or Password";
        String dialogmessage="Error!";
		int dialogtype=JOptionPane.PLAIN_MESSAGE;
		dialogtype=JOptionPane.ERROR_MESSAGE;
		JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
	  }
	} 
	catch(Exception ex)
	{
		System.out.println("getBookRecord Error=+ex");
	}
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		connect();
		searchData();
		
	}
	else if(ae.getSource()==b2)
	{
		System.exit(0);
	}
	else if(ae.getSource()==b3)
	{
		frm.setVisible(false);
		ForgotPassword ob=new ForgotPassword();
		ob.setUpForgotPassword();
	}
	else if(ae.getSource()==b4)
	{
		frm.setVisible(false);
		CreateAccount ob=new CreateAccount();
		ob.setUpCreateAccount();
	}
}
}

