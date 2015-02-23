public class AshObject {
	private String name;
	private int type;
	private int[] data;
	public String getName() {
		return name;
	}
	public void setName(String s) {
		name = s;
	}
	public int getType() {
		return type;
	}
	public void setType(int t) {
		type = t;
	}
	public int[] getStats() {
		return data;
	}
	public void setStats(int[] a) {
		data = a;
	}
	public int getStat(int i) {
		return data[i];
	}
	public void setStat(int i, int value) {
		data[i] = value;
	}
}
