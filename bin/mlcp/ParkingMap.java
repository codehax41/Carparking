package mlcp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ParkingMap extends Frame implements ActionListener
{
Frame frm;
JLabel l[]=new JLabel[100];
JLabel l1,l2,l3;
ImageIcon ic,ic1,ic2,ic3,ic4;
JButton b1,b2;
String str="RESERVED";
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
int x=100;
int y=100;
int c=0;
int i,n1,n2;

Connection con;
Statement stat;
ResultSet rst;
PreparedStatement pst;

public ParkingMap()
{
ic=new ImageIcon("g1.png");
ic1=new ImageIcon("red1.png");
ic2=new ImageIcon("backb.jpg");
ic3=new ImageIcon("exitb.jpg");
ic4=new ImageIcon("parkingmap.jpg");



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

l1=new JLabel("",ic2,JLabel.CENTER);
l2=new JLabel("",ic3,JLabel.CENTER);
l3=new JLabel("",ic4,JLabel.CENTER);

frm=new Frame("Parking Map");
}
public void setUpParkingMap()
{
frm.setLayout(null);
frm.setSize(900,750);
frm.setLocation(250,0);


b1.setBounds(750,350,80,25);
frm.add(b1);

b2.setBounds(750,380,80,25);
frm.add(b2);

l2.setBounds(750,350,80,25);
frm.add(l2);

l1.setBounds(750,380,80,25);
frm.add(l1);



for(int i=0;i<100;i++)
{
c=c+1;

l[i]=new JLabel("L"+(i+1));
l[i]=new JLabel("",ic,JLabel.CENTER);
l[i].setBounds(x,y,30,30);
frm.add(l[i]);

l3.setBounds(0,0,900,750);
frm.add(l3);

x=x+60;
if(c==10)
{
y=y+60;
c=0;
x=100;

}
}
connect();
getTrackRec();

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
public void getTrackRec()            //new account
{
try
{
stat=con.createStatement();
rst=stat.executeQuery("select*from trackInfo where Status='"+str+"'");
while(rst.next())
{
n1=Integer.parseInt(rst.getString(1));
n2=Integer.parseInt(rst.getString(2));
i=10*(n1-1)+n2;
l[i-1].setIcon(new ImageIcon("red1.png"));
}
}
catch(Exception ex)
{
System.out.println("getStuRecord Error="+ex);
}
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		System.exit(0);
	}
	if(ae.getSource()==b2)
	{
		frm.setVisible(false);
			Parking ob=new Parking();
			ob.setUpParking();
	}
}
}