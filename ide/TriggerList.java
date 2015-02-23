public class TriggerList {
private Trigger[] triggers = new Trigger[256];
public void setTrigger(int x, int y, Trigger trigger) {
	triggers[y*16+x] = trigger;
}
public Trigger getTrigger(int x, int y) {
	return triggers[y*16+x];
}

}
