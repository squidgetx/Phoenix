import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class Tile{
	
	private boolean[] tileData,mask;
	private int tileWidth,tileHeight,tileID,trueWidth;
	private boolean isMasked;
	Tile(boolean[] bitmap, int newWidth, int newHeight, int id) {
		//constructor
		tileData=bitmap;
		tileWidth=newWidth;
		tileHeight=newHeight;
		tileID=id;
		trueWidth = tileWidth;
		if (tileWidth%8!=0) {
			tileWidth = (tileWidth/8+1)*8;
		}
		mask = new boolean[tileData.length/2];
		isMasked = false;
	}
	Tile(boolean[] bitmap, boolean[] newmask, int newWidth, int newHeight, int id) {
		//masked constructor
		tileData=bitmap;
		tileWidth=newWidth;
		tileHeight=newHeight;
		tileID=id;
		isMasked = true;
		mask = newmask;
		trueWidth = tileWidth;
		if (tileWidth%8!=0) {
			tileWidth = (tileWidth/8+1)*8;
		}
	}
	Tile(int newWidth, int newHeight, int id) {
		//blank tile
		tileWidth=newWidth;
		tileHeight=newHeight;
		tileID=id;
		trueWidth = tileWidth;
		if (tileWidth%8!=0) {
			tileWidth = (tileWidth/8+1)*8;
		}
		tileData = new boolean[tileWidth*tileHeight*2];
		mask = new boolean[tileWidth*tileHeight];
		isMasked = false;
	}		
	public void toggleMasked() {
		isMasked = !(isMasked);
	}
	public boolean[] getMask() {
		return mask;
	}
	public void setMask(boolean[] m) {
		mask = m;
		isMasked = true;
	}
	public void setMask() {
		isMasked = true;
	}
	public boolean isMasked() {
		return isMasked;
	}
	public int getWidth() {
		return tileWidth;
	}
	public int getTrueWidth() {
		return trueWidth;
	}
	public int getHeight() {
		return tileHeight;
	}
	public void setPixel(int x, int y, boolean[] color) {
		tileData[y*tileWidth+x] = color[0];
		tileData[y*tileWidth+x+tileData.length/2] = color[1];
		if (isMasked)
			mask[y*tileWidth+x] = color[2];
	}
	public int getID() {
		return tileID;
	}
	public void setID(int a) {
		tileID = a;
	}
	public boolean[] getData() {
		return tileData;
	}
	public void setData(boolean[] b) {
		tileData = b;
	}
	public void drawTile(int x, int y, int width, int height, Graphics g) {
		int offset = tileData.length/2;
		for(int i = 0 ; i<trueWidth; i++ ){
			for(int j = 0; j<tileHeight; j++) {
				Color color;
				if (tileData[j*tileWidth+i] && tileData[j*tileWidth+i+offset]) {
					color = ide.black;
				} else if (tileData[j*tileWidth+i]) {
					color = ide.darkGray;
				} else if (tileData[j*tileWidth+i+offset]) {
					color = ide.lightGray;
				} else {
					color = ide.white;
				}
				if (isMasked) {
					if (mask[j*tileWidth+i])
						color = Color.blue;
				}
				g.setColor(color);
				g.fillRect(i*width/tileHeight+x,j*height/tileHeight+y,height/tileHeight+1,height/tileHeight+1);
			}
		}
	}
	public ImageIcon getIcon() {
		BufferedImage i = new BufferedImage(trueWidth*4,tileHeight*4,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = i.createGraphics();
		this.drawTile(0,0,trueWidth*4,tileHeight*4,(Graphics) g);
		ImageIcon icon = new ImageIcon(i);
		g.dispose();
		return icon;
	}
}
