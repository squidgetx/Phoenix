import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MapDisplay extends JPanel {
	private int size;
	private Map activeMap;
	public void setMap(Map map) {
		activeMap = map;
		repaint();
	}
	public Map getMap() {
		return activeMap;
	}
	public void setSize(int newsize) {
		size = newsize;
	}
	//Main Map editor display pane
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		activeMap.drawMap(0,0,size*12,g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(50,50,50));
		g2d.setFont(new Font("sansserif",Font.BOLD,12));
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g2d.drawString(activeMap.getName(),10,400);
		g2d.dispose();
		g.dispose();
	}
   
	 public MapDisplay(Map active) {
		setPreferredSize(new Dimension(384,400));
		size = 2;
		activeMap = active;
	 }
	  
}
