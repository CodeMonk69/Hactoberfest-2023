import java.applet.Applet; 
import java.awt.*; 
public class Graph5_Cube extends Applet
{ 
    int x1[]={100,150,350,300};
    int y1[]={100,50,50,100};
    int n1=4;
    int x2[]={100,150,350,300};
    int y2[]={300,250,250,300};
    int n2=4;
    public void paint(Graphics g)
    { 
        Font font = new Font("Serif", Font.PLAIN, 26);
        g.setFont(font);
        setBackground(Color.gray);
        setForeground(Color.yellow);
        g.drawRect(100,100,200,200);
        g.drawPolygon(x1,y1,n1);
        g.drawPolygon(x2,y2,n2);
        g.drawLine(150,50,150,250);
        g.drawLine(350,50,350,250);
        g.drawString("CUBE",175,360);
        g.drawString("Length(L)",175,325);
        g.drawString("Breadth(B)",340,280);
        g.drawString("Height(H)",360,160);
    } 
}  