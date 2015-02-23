public class Enemy extends AshObject {
	private int[] moves;
	private Tile[] sprites = new Tile[2];
	Enemy(final int[] stats, final int t, final String n, final int[] m) {
		setStats(stats);
		setType(t);
		setName(n);
		moves = m;
	}
	Enemy() {
		setStats(new int[8]);
		setName("");
		moves = new int[4];
		sprites[0] = new Tile(new boolean[24*24*2],24,24,0);
		sprites[1] = new Tile(new boolean[24*24*2],24,24,1);
	}
	public void setSprites(Tile[] t) {
		sprites = t;
	}
	public Tile[] getSprites() {
		return sprites;
	}
	public void setMoves(final int[] m) {
		moves = m;
	}
	public int[] getMoves() {
		return moves;
	}
	public void setMove(final int i, final int m) {
		moves[i]=m;
	}
	public int getMove(final int i) {
		return moves[i];
	}
	
	
}
