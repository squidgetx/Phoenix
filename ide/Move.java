public class Move extends AshObject{
	private int animation, damage, funcID;
	Move(final String n, final int[] stats, final int type, final int anim, 
												final int dmg, final int func) {
		setName(n);
		setStats(stats);
		setType(type);
		animation = anim;
		damage = dmg;
		funcID = func;
	}
	Move() {
		setStats(new int[4]);
		setName("");
	}
	public int getAnim() {
		return animation;
	}
	public int getDmg() {
		return damage;
	}
	public int getFuncID() {
		return funcID;
	}
	public void setAnim(int a) {
		animation = a;
	}
	public void setDmg(int d) {
		damage = d;
	}
	public void setFuncID(int f) {
		funcID = f;
	}
}
