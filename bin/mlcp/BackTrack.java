package mlcp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BackTrack extends Frame implements ActionListener,Runnable
{
int s=0;
Frame frm;
JLabel l1,l2,l3,l4;
ImageIcon ic,ic1;
JTextField t1,t2,t3,t4;
JButton b1;
String a1,a2,a3,a4,k,k1,a9,a10;
Thread th;


public BackTrack(String p1,String p2,String p3)
{
ic=new ImageIcon("c1.png");
ic1=new ImageIcon("t1.png");
l3=new JLabel("",ic,JLabel.CENTER);
l4=new JLabel("",ic1,JLabel.CENTER);

b1=new JButton("Done");
b1.setOpaque(false);
b1.setContentAreaFilled(false);
b1.addActionListener(this);
b1.setToolTipText("Click to release car");

th=new Thread(this);

l1=new JLabel("Label No.");
l1.setFont(new Font("Serif",Font.PLAIN,20));
l2=new JLabel("Track No.");
l2.setFont(new Font("Serif",Font.PLAIN,20));

t1=new JTextField(""+p1);
t2=new JTextField(""+p2);
t3=new JTextField();
t4=new JTextField(""+p3);

a1=t1.getText();
a2=t2.getText();
/*a1=p3;
a21=p1;
a22=p2;*/
}
public void setUpBackTrack()
{
frm=new Frame("Track Processing");
frm.setLayout(null);
frm.setSize(1000,600);
frm.setLocation(200,100);

//l2.setBounds(20,170,150,25);
frm.add(l2);
//t2.setBounds(170,170,150,25);
frm.add(t2);

//t1.setBounds(170,300,150,25);
frm.add(t1);

//t3.setBounds(170,200,150,25);
frm.add(t3);

//t4.setBounds(170,200,150,25);
frm.add(t4);

l3.setBounds(0,0,500,600);
frm.add(l3);
l4.setBounds(400,0,600,600);
frm.add(l4);

a1=t1.getText();
a2=t2.getText();
a4=t4.getText();

b1.setBounds(650,550,100,25);
frm.add(b1);

frm.setVisible(true);
th.start();  
}
public void run()
{
try
{
	int n;
	k=t1.getText();
	n=Integer.parseInt(k);
	for(int i=10;i>=n;i--)
{
	t3.setText(""+i);
	
	if(i==10)
	{
		ic=new ImageIcon("c10.png");
	}
	if(i==9)
	{
		ic=new ImageIcon("c9.png");
	}
	if(i==8)
	{
		ic=new ImageIcon("c8.png");
	}
	if(i==7)
	{
		ic=new ImageIcon("c7.png");
	}
	if(i==6)
	{
		ic=new ImageIcon("c6.png");
	}
	if(i==5)
	{
		ic=new ImageIcon("c5.png");
	}
	if(i==4)
	{
		ic=new ImageIcon("c4.png");
	}
	if(i==3)
	{
		ic=new ImageIcon("c3.png");
	}
	if(i==2)
	{
		ic=new ImageIcon("c2.png");
	}
	if(i==1)
	{
		ic=new ImageIcon("c1.png");
	}
	l3.setIcon(ic);
	Thread.sleep(300);
}
{
	int j;
	k1=t2.getText();
	j=Integer.parseInt(k1);
	for(int b=10;b>=j;b--)
{
	t3.setText(""+b);
	
	if(b==10)
	{
		ic1=new ImageIcon("t10.png");
	}
	if(b==9)
	{
		ic1=new ImageIcon("t9.png");
	}
	if(b==8)
	{
		ic1=new ImageIcon("t8.png");
	}
	if(b==7)
	{
		ic1=new ImageIcon("t7.png");
	}
	if(b==6)
	{
		ic1=new ImageIcon("t6.png");
	}
	if(b==5)
	{
		ic1=new ImageIcon("t5.png");
	}
	if(b==4)
	{
		ic1=new ImageIcon("t4.png");
	}
	if(b==3)
	{
		ic1=new ImageIcon("t3.png");
	}
	if(b==2)
	{
		ic1=new ImageIcon("t2.png");
	}
	if(b==1)
	{
		ic1=new ImageIcon("t1.png");
	}
	l4.setIcon(ic1);
	Thread.sleep(300);
}
}
}
catch(Exception ex)	
{
	System.out.println(ex);
}
}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		frm.setVisible(false);
        ParkingRecipt ob=new ParkingRecipt(a4);
        ob.setUpParkingRecipt();
	}
	
}
}
 
