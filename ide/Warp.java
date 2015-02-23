public class Warp {
	private int destX,destY;
	private Map map;
	Warp(Map map1, int dX, int dY) {
	map = map1;
	destX = dX;
	destY = dY;
	}
	public Map getMap() {
		return map;
	}
	public int getXdest() {
		return destX;
	}
	public int getYdest() {
		return destY;
	}
}
