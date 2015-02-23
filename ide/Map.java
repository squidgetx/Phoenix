import java.awt.*;
import java.awt.image.*;
import java.util.*;
public class Map{
	private Tile[] mapTiles;
	private String name;
	private BufferedImage image;
	private NPCList npcs = new NPCList();
	private TriggerList triggers = new TriggerList();
	private WarpList warps = new WarpList();
	private int enemylvl;
	private int[] earray,meta;
	private int width,height;
	Map(String newName, int elvl, int[] enearray, int[] metad) {
		name = newName;
		enemylvl = elvl;
		earray = enearray;
		meta = metad;
		width = 16;
		height = 16;
	}
	Map(Tile t) {
		name = "";
		mapTiles = new Tile[256];
		Arrays.fill(mapTiles, t);
		enemylvl = 3;
		earray = new int[3];
		meta = new int[3];
		width = 16;
		height = 16;
		updateMapImage();
		
	}
	Map(Tile[] tiles, int w, int l) {
		name="";
		mapTiles = tiles;
		enemylvl = 3;
		earray = new int[3];
		meta = new int[3];
		width = w;
		height = l;
		updateMapImage();
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int h) {
		height = h;
	}
	public void setWidth(int w) {
		width = w;
	}
	public String getName() {
		return name;
	}
	public Tile getTile(int x, int y) {
		return mapTiles[y*width+x];
	}
	public Tile getTile(int index) {
		return mapTiles[index];
	}
	public Tile[] getTiles() {
		return mapTiles;
	}
	public void setName(String s) {
		name = s;
	}
	public void setTile(int x, int y, Tile newTile) {
		mapTiles[y*width+x] = newTile;		
	}
	public void setData(Tile[] data) {
		mapTiles = data;
		updateMapImage();	
	}
	public void setEneLevel(int e) {
		enemylvl = e;
	}
	public void setEnemies(int[] e) {
		earray = e;
	}	
	public void setNPC(int x, int y, NPC npc) {
		npcs.setNPC(x,y,npc);
	}
	public void setWarp(int x, int y, Warp warp) {
		warps.setWarp(x,y,warp);
	}
	public void setTrigger(int x, int y, Trigger trig) {
		triggers.setTrigger(x,y,trig);
	}
	public NPC getNPC(int x, int y) {
		return npcs.getNPC(x,y);
	}
	public Warp getWarp(int x, int y) {
		return warps.getWarp(x,y);
	}
	public Trigger getTrigger(int x, int y) {
		return triggers.getTrigger(x,y);
	}
	public int getMeta(int i) {
		return meta[i];
	}
	public int getElvl() {
		return enemylvl;
	}
	public int[] getEnemies() {
		return earray;
	}
	public int[] refreshMeta() {
		meta = new int[3];
		for(int i = 0; i<width; i++) {
			for (int j = 0; j<height; j++) {
			if (npcs.getNPC(i,j)!=null)
				meta[0]++;
			if (triggers.getTrigger(i,j)!=null)
				meta[1]++;
			if (warps.getWarp(i,j)!=null)
				meta[2]++;
			}
		}
		return meta;		
	}
	public void drawMap(int x, int y, int size, Graphics g) {
		for(int i=0; i<width;i++){
			for(int j=0; j<height; j++) {
					mapTiles[j*width+i].drawTile(i*size+x,j*size+y,size,size,g);
					if (npcs.getNPC(i,j)!=null) {
						g.setColor(Color.red);
						g.drawRect(i*size+x, j*size+y, size-1, size-1);
					}
					if (triggers.getTrigger(i,j)!=null) {
						g.setColor(Color.blue);
						g.drawRect(i*size+x, j*size+y, size-1, size-1);
					}
					if (warps.getWarp(i,j)!=null) {
						g.setColor(Color.green);
						g.drawRect(i*size+x, j*size+y, size-1, size-1);
					}	
			}
		}
		return;
		//g.dispose();
	}
	public BufferedImage getMapImage() {
		return image;
	}
	public BufferedImage updateMapImage() {
		final int tileWidth = mapTiles[0].getTrueWidth();
		final int tileHeight = mapTiles[0].getHeight();
		BufferedImage newimage = new BufferedImage(width*tileWidth,height*tileHeight,BufferedImage.TYPE_INT_RGB);
		Graphics g = newimage.getGraphics();
		for(int i=0; i<width;i++){
			for(int j=0; j<height; j++) {
					mapTiles[j*width+i].drawTile(i*tileWidth,j*tileHeight,tileWidth,tileHeight,g);
			}
		}
		g.dispose();
		image = newimage;
		return newimage;
	}

}
