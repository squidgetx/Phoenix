public class Item extends AshObject {
	public final int none = 0;
	public final int functional = 1;
	public final int consumable = 2;
	public final int booster = 3;
	public final int weapon = 4;
	public final int shield = 5;
	public final int armor = 6;
	public final int helmet = 7;
	public final int amulet = 8;
	public final int boots = 9;
	private int price;
	Item() {
		setStats(new int[4]);
		setName("New");
		}
	Item(final String sname) {
		setName(sname);
		setType(0);
		setStats(new int[4]);
	}
	Item(final String sname, final int a, final int b, final int c, final int d, final int id) {
		setName(sname);
		setStats(new int[4]);
		setStat(0,a);
		setStat(1,b);
		setStat(2,c);
		setStat(3,c);
		setType(id);
	}
	public void setPrice(int p) {
		price = p;
	}
	public int getPrice() {
		return price;
	}
	

}
