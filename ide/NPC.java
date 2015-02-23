public class NPC {
	private int spriteID,convoID;
	NPC(int id, int cid) {
		convoID = cid;
		spriteID = id;
	}
	public int getSpriteID() {
		return spriteID;
	}
	public int getConvo() {
		return convoID;
	}
}
