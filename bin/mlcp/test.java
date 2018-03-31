package mlcp;  //moving ball
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
public class test extends JApplet {
public static void main(String[] args) {
JFrame frame = new JFrame();
frame.getContentPane().add(new test());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(900, 600);
frame.setVisible(true);
}
public void paint(Graphics g) {
try {
int j = 0;
while (j < 500) {
g.setColor(Color.white);
g.fillRect(0, 0, 5000, 5000);
g.setColor(Color.red);
g.fillRect(250 + j, 250, 100, 50);
g.setColor(Color.black);
g.fillOval(260 + j, 300, 20, 20);
g.fillOval(320 + j, 300, 20, 20);
j++;
Thread.sleep(1);

}
} catch (InterruptedException e) {
}

}

}
/*<applet code="test.java" width="900" height="600">
</applet>*/