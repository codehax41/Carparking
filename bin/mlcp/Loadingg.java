package mlcp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Loadingg extends Frame implements ActionListener,Runnable
{
Frame frm;
JProgressBar pb1;
Thread th;
int s=0;
ImageIcon ic,ic1;
JLabel l1,l2;
int x=0,y=100;

public Loadingg()
{
ic=new ImageIcon("bug2.jpg");
ic1=new ImageIcon("mera.jpg");

pb1=new JProgressBar(JProgressBar.HORIZONTAL);
th=new Thread(this);

frm=new Frame("Welcome");
l1=new JLabel("",ic1,JLabel.CENTER);
l2=new JLabel("",ic,JLabel.CENTER);
}
public void setUpLoadingg()
{
frm.setLayout(null);
frm.setSize(650,500);
frm.setLocation(300,50);

l2.setBounds(50,25,500,500);
frm.add(l2);

l1.setBounds(0,50,700,500);
frm.add(l1);

pb1.setBounds(200,400,200,25);
frm.add(pb1);

pb1.setMinimum(0);
pb1.setMaximum(20);
pb1.setValue(1);
pb1.setForeground(Color.green);
/*void moveImage()
{
for(int i=0;i<=700;i++)
{
	for(int j=1;j<6000000;j++)
		x +=1;
	y +=1;
}
*/
pb1.setStringPainted(true);
frm.setVisible(true);
th.start();
}
public void run()
{
try
{
for(int i=1;i<=200;i++)
{
	s=s+1;
int m=pb1.getMaximum();
	int val=pb1.getValue();
	if(val<m)
	{
		pb1.setValue(pb1.getValue()+1);
	}
	else
	{ i=201;
        frm.setVisible(false);
		LogIn ob=new LogIn();
		ob.setUpLogIn();
	}
	
	Thread.sleep(300);
}}
catch(Exception ex)	
{
	System.out.println(ex);
}
}
public void actionPerformed(ActionEvent ae)

{
	frm.setVisible(false);
}
}