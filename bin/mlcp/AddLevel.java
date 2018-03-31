package mlcp;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class AddLevel extends Frame implements ActionListener
{
Frame frm;
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2;
JButton b1,b2;
String a1,a2,a3,a4,a5="AVAIL";
int n1,n2;
ImageIcon ic,ic1,ic2;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public AddLevel()
{
ic=new ImageIcon("addtrack1.png");
ic1=new ImageIcon("addb.jpg");
ic2=new ImageIcon("backb.jpg");	
	
frm=new Frame("   Add new Track/level   ");
l1=new JLabel("Level No");
l1.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l1.setForeground(Color.white);
l2=new JLabel("Track No");
l2.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
l2.setForeground(Color.white);

t1=new JTextField();
t1.setOpaque(false);
t2=new JTextField();
t2.setOpaque(false);

b1=new JButton("");
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.setBorderPainted(false);
b1.addActionListener(this);


b2=new JButton("");
b2.addActionListener(this);
b2.setOpaque(false);
b2.setBorderPainted(false);
b2.setContentAreaFilled(false);

l3=new JLabel("",ic,JLabel.CENTER);
l4=new JLabel("",ic1,JLabel.CENTER);
l5=new JLabel("",ic2,JLabel.CENTER);
}
public void setUpAddLevel()
{
frm.setLayout(null);
frm.setSize(450,300);
frm.setLocation(400,200);

l1.setBounds(100,100,125,25);
frm.add(l1);
l2.setBounds(100,140,125,25);
frm.add(l2);
t1.setBounds(245,100,150,25);
frm.add(t1);
t2.setBounds(245,140,150,25);
frm.add(t2);
b1.setBounds(150,200,80,25);
frm.add(b1);
b2.setBounds(250,200,80,25);
frm.add(b2);

l5.setBounds(250,200,80,25);
frm.add(l5);
l4.setBounds(150,200,80,25);
frm.add(l4);
l3.setBounds(0,0,450,300);
frm.add(l3);



frm.setVisible(true);

connect();
lastLevelNo();
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
System.out.println("connection error="+ex);
}
}

public void lastLevelNo()
{
try
{
stat=con.createStatement();
rst=stat.executeQuery("select *from trackInfo ORDER BY SNO");
while(rst.next())
{
a1=rst.getString(1);
a2=rst.getString(2);
}
t1.setText(""+a1);
t2.setText(""+a2);
}
catch(Exception ex)
{
System.out.println("getTrackRec Error="+ex);
}
}

public void insertNewLevel()
{
try
{
a3=t1.getText();
a4=t2.getText();
n1=Integer.parseInt(a3);
n2=Integer.parseInt(a4);
if(n2==10)
{
n1=n1+1;
n2=1;
}
else
{
n2=n2+1;
}
pst=con.prepareStatement("insert into trackInfo (LN,TN,STATUS) values ('"+n1+"','"+n2+"','"+a5+"')");
pst.executeUpdate();
t1.setText(""+n1);
t2.setText(""+n2);
}
catch(Exception ex)
{
System.out.println("getTrackRecord Error="+ex);
}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
connect();
lastLevelNo();
insertNewLevel();
}
if(ae.getSource()==b2)
{
frm.setVisible(false);
	 Parking ob=new Parking();
	 ob.setUpParking();
 
}
}
}