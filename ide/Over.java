import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Over{
	private Map[] overMaps;
	final int size = 24;
	public void drawOver(Graphics g) {
		int dim = 192;
		for(int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (overMaps[j*size+i]!=null) {
					overMaps[j*size+i].drawMap(i*dim, j*dim, dim/16, g);
				} else {
					g.setColor(new Color(0,0,0));
					g.fillRect(i*dim,j*dim,dim,dim);
				}
			}
		}
	
	}
	Over() {
		overMaps = new Map[size*size];
	}
	public void setMap(int x, int y, Map map) {
		overMaps[y*size+x] = map;
	}
	public void setMap(int i, Map map) {
		overMaps[i] = map;
	}
	public void deleteMap(int x, int y) {
		overMaps[y*size+x] = null;
	}
	public Map getMap(int x, int y) {
		return overMaps[y*size+x];
	}

}
