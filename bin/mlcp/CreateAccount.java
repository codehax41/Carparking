package mlcp;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CreateAccount extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JTextField t1,t2,t3,t4;
Choice ch1;
ImageIcon ic,ic1,ic2,ic3;
JButton b1,b2,b3;
String a1,a2,a3,a4,a5;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public CreateAccount()
{	
ic=new ImageIcon("account1.jpg");
ic1=new ImageIcon("createb.jpg");
ic2=new ImageIcon("backb.jpg");
ic3=new ImageIcon("exitb.jpg");

l1=new JLabel("Enter User ID");
l1.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l2=new JLabel("Enter Paswrd");
l2.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l3=new JLabel("Re-Enter Paswrd");
l3.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l4=new JLabel("Select Sec-Q.");
l4.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l5=new JLabel("Answer");
l5.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));

b1=new JButton("");
b1.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.setBorderPainted(false);
b1.addActionListener(this);
b1.setToolTipText("Click to submit your Entry");


b2=new JButton("");
b2.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b2.setOpaque(false);
b2.setContentAreaFilled(false);
b2.setBorderPainted(false);
b2.addActionListener(this);
b2.setToolTipText("Click to back to menu");

b3=new JButton("");
b3.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
b3.setOpaque(false);
b3.setContentAreaFilled(false);
b3.setBorderPainted(false);
b3.addActionListener(this);
b3.setToolTipText("Click to exit");

l7=new JLabel("",ic,JLabel.CENTER);
l8=new JLabel("",ic1,JLabel.CENTER);
l9=new JLabel("",ic2,JLabel.CENTER);
l10=new JLabel("",ic3,JLabel.CENTER);

t1=new JTextField();
t1.setOpaque(false);
t2=new JTextField();
t2.setOpaque(false);
t3=new JTextField();
t3.setOpaque(false);
t4=new JTextField();
t4.setOpaque(false);
}
public void setUpCreateAccount()
{

frm=new Frame("New Account");
frm.setLayout(null);
frm.setSize(600,600);
frm.setLocation(350,100);

l1.setBounds(90,100,100,25);
frm.add(l1);
t1.setBounds(290,100,150,25);
frm.add(t1);

b1.setBounds(150,350,100,25);
frm.add(b1);
	
b2.setBounds(300,350,100,25);
frm.add(b2);

b3.setBounds(230,400,100,25);
frm.add(b3);

l2.setBounds(90,140,100,25);
frm.add(l2);
t2.setBounds(290,140,150,25);
frm.add(t2);

l3.setBounds(90,180,100,25);
frm.add(l3);
t3.setBounds(290,180,150,25);
frm.add(t3);

l4.setBounds(90,220,100,30);
frm.add(l4);

ch1=new Choice();
ch1.setBounds(290,220,150,25);
    ch1.add("Select");
	ch1.add("What is your Birth Place");
	ch1.add("What is your Mother Tounge");
	ch1.add("What is your Chlid Name");
	ch1.add("What You Live");
	frm.add(ch1);

l5.setBounds(90,260,100,25);
frm.add(l5);
t4.setBounds(290,260,150,25);
frm.add(t4);

l10.setBounds(230,400,100,25);
frm.add(l10);
l9.setBounds(300,350,100,25);
frm.add(l9);
l8.setBounds(150,350,100,25);
frm.add(l8);
l7.setBounds(0,0,600,600);
frm.add(l7);

frm.setVisible(true);
}
public void getData()
{
	try
	{
	a1=t1.getText();
	a2=t2.getText();
	a3=t3.getText();
	a4=ch1.getSelectedItem();
	a5=t4.getText();
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
pst=con.prepareStatement("insert into createAccount values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"')");
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
	
	String dialogtittle="Fill all field";
    String dialogmessage="Error!";
	
	String dialogtittle1="Account Created";
    String dialogmessage1="Great!";
	
	int dialogtype=JOptionPane.PLAIN_MESSAGE;
		
	if(a1.equals("")||(a2.equals("")||(a3.equals("")||(a4.equals("")||(a5.equals(""))))))
	 {
        dialogtype=JOptionPane.WARNING_MESSAGE;
        JOptionPane.showMessageDialog((Component)null,dialogtittle,dialogmessage,dialogtype);
     }
	 else
	 {
		dialogtype=JOptionPane.INFORMATION_MESSAGE;
		JOptionPane.showMessageDialog((Component)null,dialogtittle1,dialogmessage1,dialogtype); 
	 }
		
		
 }
 else if(ae.getSource()==b2)  //menus
 {
	 frm.setVisible(false);
	 LogIn ob=new LogIn();
	 ob.setUpLogIn();
 
 }
 else if(ae.getSource()==b3)
 {
	 System.exit(0);
 }
	 
}
}

