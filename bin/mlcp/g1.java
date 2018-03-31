//package mlcp;
import java.applet.*;
import java.awt.*;
import java.lang.*;

/*<applet code="g1" height=800 width=700>
</applet> */
public class g1 extends Applet
 { int x; int y; int w;
 void slep()                  //for delay
 {
      try {
    Thread.sleep(200);
  }  catch(Exception ex) {
      }
}
public void init()
 {
 y=30;

x=20;
}

public void paint(Graphics g)
 {
            setBackground(Color.cyan);
            w=getWidth();
        Color c1=new Color(20,160,200);
        Color c2=new Color(200,60,200);
        g.setColor(c1);
       
        g.drawLine(0,y+75,w,y+75);
        g.setColor(c2);
        g.fillRoundRect(x,y+20,100,40,5,5);
        g.fillArc(x+90,y+20,20,40,270,180);

        g.setColor(c1);
       

        g.fillRoundRect(x+10,y,70,25,10,10);
        g.setColor(Color.white);
                g.fillRect(x+20,y+5,20,25);
        g.fillRect(x+50,y+5,20,25);
        g.setColor(Color.black);
        g.fillRoundRect(x+55,y+10,10,20,10,10);
                  g.fillOval(x+10,y+50,25,25);
        g.fillOval(x+60,y+50,25,25);
        g.setColor(Color.white);
                  g.fillOval(x+15,y+55,10,10);
        g.fillOval(x+65,y+55,10,10);
         x=x+10; slep();
            
if(x+100<w) {    repaint(); }
else
{ repaint(); x=20; y+=30;
  }
}
}