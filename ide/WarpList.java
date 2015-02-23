public class WarpList {
private Warp[] warps = new Warp[256];
public void setWarp(int x, int y, Warp warp) {
	warps[y*16+x] = warp;
}
public Warp getWarp(int x, int y) {
	return warps[y*16+x];
}
}
