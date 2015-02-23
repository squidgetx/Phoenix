public class NPCList {
//custom tilemap array structure for npcs;
private NPC[] npcs = new NPC[256];

public void setNPC(int x, int y, NPC npc) {
	npcs[y*16+x] = npc;
}
public NPC getNPC(int x, int y) {
	return npcs[y*16+x];
}

}
