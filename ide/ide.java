import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;

public class ide{

public static final Color black = Color.black;
public static final Color darkGray = new Color(84,84,84);
public static final Color lightGray = new Color(168,168,168);
public static final Color white = Color.white;
public static final String hexDigits="0123456789ABCDEF";
public static final int normal = 0;
public static final int warrior = 1;
public static final int archer = 2;
public static final int assassin = 3;
public static final int holy = 4;
public static final int undead = 5;
public static final int shadow = 6;
public static final String[] playerTypes = {"Normal", "Warrior", "Archer", "Assassin", "Holy", "Undead", "Shadow"};
public static final String[] stats = {"None","HP", "MP", "HPMax", "MPMax", "Strength", "Skill", "Speed", "Magic Strength", "Magic Skill", "Defense"};
public static final String s = "Start:";
public static final String db = ".db ";
public static final String dw = ".dw ";

public static ArrayList<Item> itemReference;
public static ArrayList<Tile> tileReference;
public static ArrayList<Map> mapReference;
public static Map[] overworld;
public static ArrayList<String> convoReference;
public static ArrayList<Tile> npcSprites;
public static ArrayList<Move> moveReference;
public static ArrayList<Enemy> enemyReference;


public static MapEditorPackage mapEditorMain;


//helper routines
public static void resetAll() {
	//parse moves
	moveReference.clear();
	enemyReference.clear();
	itemReference.clear();
	convoReference.clear();
	npcSprites.clear();
	tileReference.clear();
	mapReference.clear();
	try{
		FileInputStream fstream = new FileInputStream("moves.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		br.readLine();
		String strLine = br.readLine();
		int i = 0;
		int end;
		while (true)   {
			end = 5;
			for (int j = 5; j<strLine.length(); j++) {
				end = j;
				if (strLine.charAt(j) == '"')
					break;
			}
			String name = strLine.substring(5,end);
			int[] data = hexToInt(asmToHex(br.readLine()));
			int[] stats = hexToInt(asmToHex(br.readLine()));
			int funcID = hexToInt(asmToHex(br.readLine()))[0];
			moveReference.add(new Move(name, stats, data[0], data[1], data[2], funcID));
			strLine = br.readLine();
			if (strLine == null)
				break;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//parse enemies
	try{
		FileInputStream fstream = new FileInputStream("enemymeta.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		br.readLine();
		String strLine = br.readLine();
		int end;
		while (true)   {
			end = 5;
			for (int j = 5; j<strLine.length(); j++) {
				end = j;
				if (strLine.charAt(j) == '"')
					break;
			}
			String name = strLine.substring(5,end);
			int type = hexToInt(asmToHex(br.readLine()))[0];
			int[] stats = hexToInt(asmToHex(br.readLine()));
			int[] moveIDs = hexToInt(asmToHex(br.readLine()));
			enemyReference.add(new Enemy(stats, type, name, moveIDs));
			strLine = br.readLine();
			if (strLine == null)
				break;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	//parse enemy sprites
	try{
		FileInputStream fstream = new FileInputStream("enesprites.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		br.readLine();
		String strLine = br.readLine();
		int i=0;
		Tile[] tiles;
		while (true) {
			tiles = new Tile[2];
			tiles[0] = new Tile(hexToBoolean(asmToHex(strLine)),24,24,0);
			//System.out.println(strLine);
			tiles[1] = new Tile(hexToBoolean(asmToHex(br.readLine())),24,24,1);
			enemyReference.get(i).setSprites(tiles);
			strLine = br.readLine();
			if (strLine == null)
				break;
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
	
	//parse items yo
	try{
		FileInputStream fstream = new FileInputStream("items.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String strLine;

		while (!(strLine = br.readLine()).equals("Start:"))   {}
		strLine = br.readLine();
		int i = Integer.parseInt(strLine.substring(1,strLine.length()));
		br.readLine();
		int end;
		for(int index=0; index<i; index++)   {
			strLine = br.readLine();
			end = 5;
			for (int j = 5; j<strLine.length(); j++) {
				end = j;
				if (strLine.charAt(j) == '"')
					break;
			}
			String name = strLine.substring(5,end);
			int[] ints = hexToInt(asmToHex(br.readLine()));
			int id = ints[0];
			ints = hexToInt(asmToHex(br.readLine()));
			int s1 = ints[0];
			int s1q = ints[1]*256+ints[2];
			ints = hexToInt(asmToHex(br.readLine()));
			int s2 = ints[0];
			int s2q = ints[1]*256+ints[2];
			Item it = new Item(name,s1,s1q,s2,s2q,id);
			int[] intst = hexToInt(asmToHex(br.readLine()));
			it.setPrice(intst[0]*256+intst[1]);
			itemReference.add(it);
			//br.readLine();
		}		
		//Close the input stream
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//parse npcs yo
	try{
		FileInputStream fstream = new FileInputStream("npcconvos.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String strLine,convo;
		
		while (!(strLine = br.readLine()).equals("Start:"))   {}
		strLine = br.readLine();
		int count = 0;
		for(int i = 0; i<strLine.length(); i++) {
			if (strLine.charAt(i) == ',') {
				count++;
			}
		}
		count++;
		while (!(strLine = br.readLine()).equals("convo0:"))   {}
		for(int i = 0; i<count; i++) {
			convo = br.readLine();
			while (!(strLine = br.readLine()).equals("convo"+Integer.toString(i+1)+":"))
				convo = convo + "\n" + strLine;
			convoReference.add(convo);
		}		
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//tiles
	try{
		FileInputStream fstream = new FileInputStream("tileout.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String strLine,hex;
		
		//Read File Line By Line
		//12x12 tiles stored 3 lines at a time, for now anyway
		int id=0;
		while (!((strLine = br.readLine()).equals("tileData:"))) {}
		br.readLine(); //skip first commented label
		while ((strLine = br.readLine())!=null)   {
			hex = "";
			while (strLine.indexOf(';')==-1) {
				hex+=asmToHex(strLine); //concatenate the data to one readable string
				strLine = br.readLine();
				if (strLine == null)
					break;
			}
			tileReference.add(new Tile(hexToBoolean(hex),12,12,id));
			id++;
		}
		//Close the input stream
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
		tileReference.add(new Tile(new boolean[384],12,12,0));
	}
	//parse npc sprites
	try{
		FileInputStream fstream = new FileInputStream("npcsprites.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		br.readLine(); //skip 1 line header
		int i = 0;
		String strLine = br.readLine();
		while (true)   {
			boolean[] mask = hexToBoolean(asmToHex(strLine));
			boolean[] data = hexToBoolean(asmToHex(br.readLine()));
			npcSprites.add(new Tile(data, mask, 16, 16, i));
			i++;
			strLine = br.readLine();
			if (strLine == null)
				break;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		npcSprites.add(new Tile(16,16,0));
		npcSprites.add(new Tile(16,16,1));
		npcSprites.add(new Tile(16,16,2));
		npcSprites.add(new Tile(16,16,3));
	}
	
	//overworld
	int[] overInts = new int[576];
	String mapText = "";
	try{
		FileInputStream fstream = new FileInputStream("overworl.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String strLine;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			mapText = mapText + asmToHex(strLine);
		}
		overInts = hexToInt(mapText);
		
		//Close the input stream
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
		overInts[0] = 1;
	}
	//set up map editor
	
	mapReference.add(null);
	//parse maps, yo
	
	try{
		FileInputStream fstream = new FileInputStream("map.asm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String strLine;
		
		//Read File Line By Line
		while (!(strLine = br.readLine()).equals("Start:"))   {}
		String name=br.readLine();
		while (!name.equals("map1:")) {
			name = name.substring(5,name.length()-1);
			br.readLine();
			br.readLine();
			int[] meta = hexToInt(asmToHex(br.readLine())); //number of npcs, triggers, warps
			//enemy lvl
			int elvl = hexToInt(asmToHex(br.readLine()))[0];
			int[] earray = hexToInt(asmToHex(br.readLine()));
			Map newMap = new Map(name, elvl, earray, meta);
			mapReference.add(newMap);
			br.readLine(); //another pointer
			br.readLine(); //blank line
			name = br.readLine();
		}
		
		//create Map[] array from overInts
		overworld = new Map[576];
		for(int i=0; i<overInts.length; i++) {
			if (overInts[i]!=0) {
				overworld[i] = mapReference.get(overInts[i]);
			}
		}
		
		String strLine2,strLine0;
		for(int i = 1; i<mapReference.size(); i++) {
			//parse actual map content
			strLine0 = "";
			while ((strLine2=br.readLine()).charAt(0)!='m') {
				//while map data
				strLine0 = strLine0 + asmToHex(strLine2);
			}
			Tile[] Tiles = intToTiles(decompInts(hexToInt(strLine0),256));
			mapReference.get(i).setData(Tiles);
			for(int j = 0; j<mapReference.get(i).getMeta(0); j++) {
				String s = asmToHex(br.readLine());
				int[] data = hexToInt(s);
				mapReference.get(i).setNPC(data[0], data[1], new NPC(data[2],data[3]*256+data[4]));
			}
			for(int j = 0; j<mapReference.get(i).getMeta(1); j++) {
				int[] data = hexToInt(asmToHex(br.readLine()));
				mapReference.get(i).setTrigger(data[0], data[1], new Trigger(data[2]*256+data[3]));
				
			}
			for(int j = 0; j<mapReference.get(i).getMeta(2); j++) {
				int[] data = hexToInt(asmToHex(br.readLine()));
				mapReference.get(i).setWarp(data[0], data[1], new Warp(overworld[data[3]*24+data[2]], data[4], data[5]));
			}
			br.readLine();
			br.readLine();
		}
		
		
		//Close the input stream
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
		mapReference.add(new Map(tileReference.get(0)));
		overworld = new Map[576];
		overworld[0] = mapReference.get(1);
	}
	
	//parse overowlrd
	
}
public static void exportAll() throws IOException {
	
	//first maps n stuff
	File file;
	file = new File("map.asm");	
	file.delete();
	FileWriter writer = new FileWriter(file);
	writer.append(s);
	writer.append('\n');
	Map map;
	//map meta information
	int size = mapReference.size();
	for(int i = 1; i<size; i++) {
		map = mapReference.get(i);
		if (map==null)
			continue;
		//map name
		writer.append(db);
		writer.append('"');
		writer.append(map.getName());
		writer.append("\"\n.block "+Integer.toString(21-map.getName().length())+"\n");
		//map pointer
		writer.append(dw);
		writer.append("map"+i+"\n");
		//meta stuff
		int[] meta = map.refreshMeta();
		writer.append(db);
		for(int j=0; j<3; j++) {
			writer.append("$"+intToHex(meta[j]));
			if (j!=2)
				writer.append(",");
		}
		writer.append("\n");
		//enemy level
		writer.append(db+"$"+intToHex(map.getElvl())+"\n");
		writer.append(db);
		//enemies
		for(int j=0; j<3; j++) {
			writer.append("$"+intToHex(map.getEnemies()[j]));
			if (j!=2)
				writer.append(",");
		}
		writer.append("\n"+dw+"map"+i+"inf"+"\n\n");
	}
	//map content
	for(int i = 1; i<size; i++) {
		map = mapReference.get(i);
		if (map==null)
			continue;
		writer.append("map"+i+":\n"+db);
		//compress map
		int[] data = compTiles(map.getTiles());
		for(int j=0; j<data.length; j++) {
			System.out.println(data[j]+"");
			writer.append("$"+intToHex(data[j]));
			if (j!=data.length-1) {
				if (j%16 == 15)
					writer.append("\n"+db);
				else
					writer.append(",");
			}
		}
		writer.append("\nmap"+i+"inf:\n");
		//map npcs
		for(int x=0; x<16; x++) {
			for(int y=0; y<16; y++) {
				NPC n = map.getNPC(x,y);
				if (n!=null) {
					writer.append(db+"$"+intToHex(x)+",$"+intToHex(y)+",$"+intToHex(n.getSpriteID())
									+" \\ "+dw+"$"+wordToHex(n.getConvo())+"\n");
				}
			}
		}
		//triggers
		for(int x=0; x<16; x++) {
			for(int y=0; y<16; y++) {
				Trigger t = map.getTrigger(x,y);
				if (t!=null) {
					writer.append(db+"$"+intToHex(x)+",$"+intToHex(y)
									+" \\ "+dw+"$"+wordToHex(t.getConvo())+"\n");
				}
			}
		}
		//warps
		for(int x=0; x<16; x++) {
			for(int y=0; y<16; y++) {
				Warp w = map.getWarp(x,y);
				if (w!=null) {
					int overX=0;
					int overY=0;
					for(int j=0; j<overworld.length; j++) {
						if (overworld[j] == w.getMap()) {
							overX = j%24;
							overY = j/24;
							break;
						}
					}
					writer.append(db+"$"+intToHex(x)+",$"+intToHex(y)+",$"
									+intToHex(overX)+",$"+intToHex(overY)+",$"
									+intToHex(w.getXdest())+",$"+intToHex(w.getYdest())+"\n");
				}
			}
		}
		writer.append("\n");
	}	
	writer.close();
	file.createNewFile();
	//npcconvos.asm
	file = new File("npcconvos.asm");	
	file.delete();
	writer = new FileWriter(file);
	writer.append("#include \"itemnames.asm\"\n");
	writer.append("name .equ 1\ncheckFlag .equ 2\ncheckItem .equ 3\nsetFlag .equ 4\nresFlag .equ 5\nnewLine .equ 6\npause .equ 7\ngetItem .equ 8\nbattle .equ 9\nchangeTile .equ 10\nstore .equ 11\ninput .equ 12\njump .equ 13\nwarp .equ 14\ngetMoney .equ 15\nheal .equ 16\nspecialBattle .equ 17\n");
	writer.append(s+"\n");
	//listing of npc convos
	writer.append(dw);
	size = convoReference.size();
	for(int i=0; i<size; i++) {
		writer.append("convo"+i);
		if (i==convoReference.size()-1)
			writer.append("\n");
		else
			writer.append(",");
	}
	for(int i=0; i<size; i++) {
		//actual convo content
		writer.append("convo"+i+":\n");
		writer.append(convoReference.get(i));
		writer.append("\n");	
	}
	writer.append("convo"+convoReference.size()+":");
	writer.close();
	file.createNewFile();
	//items.asm
	file = new File("items.asm");
	file.delete();
	writer = new FileWriter(file);
	size = itemReference.size();
	writer.append(s+"\n;"+size+"\n\n");
	for(int i=0; i<size; i++) {
		//item data
		Item item = itemReference.get(i);
		writer.append(db+"\""+item.getName()+"\" \\ .block "+(16-item.getName().length())+"\n");
		writer.append(db+"$"+intToHex(item.getType())+"\n");
		writer.append(db+"$"+intToHex(item.getStat(0))+" \\ "+dw+"$"+wordToHex(item.getStat(1))+"\n");
		writer.append(db+"$"+intToHex(item.getStat(2))+" \\ "+dw+"$"+wordToHex(item.getStat(3))+"\n");
		writer.append(dw+"$"+wordToHex(item.getPrice()));
		writer.append("\n");
	}
	writer.close();
	file.createNewFile();
	
	file = new File("itemnames.asm");
	file.delete();
	writer = new FileWriter(file);
	for(int i = 0; i<itemReference.size(); i++){
		writer.append(itemReference.get(i).getName().replace(" ","_")+" .equ "+(i+1)+"\n");
	}
	writer.close();
	file.createNewFile();
	
	//tileoutp.asm
	file = new File("tileout.asm");
	file.delete();
	writer = new FileWriter(file);
	writer.append("tileData:\n");
	size = tileReference.size();
	for(int i=0; i<size; i++) {
		writer.append(";"+i);
		Tile tile = tileReference.get(i);
		boolean[] data = tile.getData();
		for(int j=0; j<data.length; j=j+8) {
			if (j/8%16==0)
				writer.append("\n"+db);
			int num = 0;
			for(int k=0; k<8; k++) {
				if (data[j+k])
					num += Math.pow(2,7-k);
			}
			writer.append("$"+intToHex(num));
			if (j/8%16!=15)
				writer.append(",");
		}
		writer.append("\n");
	}
	writer.close();
	file.createNewFile();
	//overwolrd.asm
	file = new File("overworl.asm");
	file.delete();
	writer = new FileWriter(file);
	writer.append(db);
	size = overworld.length;
	for(int i=0; i<size; i++) {
		writer.append("$"+intToHex(mapReference.indexOf(overworld[i])));
		if (i!=overworld.length-1)
			writer.append(",");
	}
	writer.close();
	file.createNewFile();
	//npcsprites.asm
	file = new File("npcsprites.asm");
	file.delete();
	writer = new FileWriter(file);
	writer.append(";NPC Sprites\n");
	size = npcSprites.size();
	for(int i = 0; i<size; i++) {
		boolean[] mask = npcSprites.get(i).getMask();
		boolean[] data = npcSprites.get(i).getData();
		appendBooleans(writer, mask);
		appendBooleans(writer, data);
	}
	writer.close();
	file.createNewFile();
	//enemymeta.asm
	file = new File("enemymeta.asm");
	file.delete();
	writer = new FileWriter(file);
	writer.append(";Enemy Metadata\n");
	size = enemyReference.size();
	for(int i=0; i<size; i++) {
		Enemy enemy = enemyReference.get(i);
		String name = enemy.getName();
		if (name.length() > 9) {
			name = name.substring(0, 9);
		}
		writer.append(db+"\""+name+"\" \\ .block "+(10-name.length())+"\n");
		writer.append(db+"$"+intToHex(enemy.getType())+"\n");
		appendInts(writer, enemy.getStats());
		appendInts(writer, enemy.getMoves());
	}
	writer.close();
	file.createNewFile();
	
	file = new File("moves.asm");
	file.delete();
	writer = new FileWriter(file);
	writer.append(";Moves\n");
	size = moveReference.size();
	for(int i=0; i<size; i++) {
		Move move = moveReference.get(i);
		String name = move.getName();
		if (name.length() > 15) {
			name = name.substring(0, 15);
		}
		writer.append(db+"\""+name+"\" \\ .block "+(16-name.length())+"\n");
		writer.append(db+"$"+intToHex(move.getType())+", $"+intToHex(move.getAnim())+", $"+intToHex(move.getDmg())+"\n");
		appendInts(writer, move.getStats());
		writer.append(db+"$"+intToHex(move.getFuncID())+"\n");
	}
	writer.close();
	file.createNewFile();
	
	file = new File("enesprites.asm");
	file.delete();
	writer = new FileWriter(file);
	writer.append(";Enemy Sprites\n");
	size = enemyReference.size();
	for(int i=0; i<size; i++) {
		Enemy e = enemyReference.get(i);
		Tile[] sprites = e.getSprites();
		appendBooleans(writer,sprites[0].getData());
		appendBooleans(writer,sprites[1].getData());
	}
	writer.close();
	file.createNewFile();
	System.out.println("Saved successfully");
}

private static String[] getStrings(ArrayList<? extends AshObject> v) {
		final String[] strings = new String[v.size()];
		for(int i=0; i<strings.length; i++) {
			strings[i] = v.get(i).getName();
		}
		return strings;
}

public static String trimConvo(String s) {
	s = s.substring(4,s.length()-2);
	if (s.length()>32)
		s = s.substring(0,32)+"...";
	return s;	
}
public static void syncIDs() {
	for(int i = 0; i<tileReference.size(); i++) {
		tileReference.get(i).setID(i);
	}
	
}

public static boolean[] hexToBoolean(String hex) {	
	final boolean[] returnArray = new boolean[hex.length()*4];
	int placer = 0;
	for(int i =0; i<hex.length(); i++) {
		int dec = hexDigits.indexOf(hex.charAt(i));
		int power = 8;
		for(int j = 0; j<4; j++) {
			int test = dec-power;
			returnArray[placer] = (test>=0);
			if (test>=0)
				dec = test;
			placer++;
			power=power/2;
		}
	}
	return returnArray;
}

public static int[] hexToInt (String hex) {
	final int[] returnArray = new int[hex.length()/2];
	for(int i =0; i<hex.length(); i=i+2) {
		returnArray[i/2] = hexDigits.indexOf(hex.charAt(i))*16+hexDigits.indexOf(hex.charAt(i+1));
	}
	return returnArray;
}

public static String intToHex (int i) {
	if (i!=0)
		return Character.toString(hexDigits.charAt(i/16))+Character.toString(hexDigits.charAt(i%16));
	return "00";
}

public static void appendInts(FileWriter writer, int[] ints) {
	try {
		writer.append(db);
		int i=0;
		while (true) {
			writer.append("$"+intToHex(ints[i]));
			if (i==ints.length-1) {
				writer.append("\n");
				return;
			} else {
				writer.append(",");
			}
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void appendBooleans(FileWriter writer, boolean[] data) {
	try {
		writer.append(db);
		int j = 0;
		while (true) {
			int num = 0;
			for(int k=0; k<8; k++) {
				if (data[j+k])
					num += Math.pow(2,7-k);
			}
			writer.append("$"+intToHex(num));
			j = j+8;
			if (j<=data.length-1) {
				writer.append(",");
			} else {
				writer.append("\n");
				return;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static String wordToHex(int i) {
	if(i!=0)
		return intToHex(i/256)+intToHex(i%256);
	return "0000";
}

public static Tile[] intToTiles(int[] ints) {
	final Tile[] returnArray = new Tile[256];
	for(int i =0; i<ints.length; i++) {
		returnArray[i] = tileReference.get(ints[i]);
	}
	return returnArray;
}
public static int[] compTiles(Tile[] data) {
	int[] temp = new int[data.length];
	Tile tile;
	Tile prevTile = data[1];
	int runLength = 0;
	int index = 0;
	for(int i = 1; i<data.length+1; i++) {
		if (i== data.length)
			tile = null;
		else
			tile = data[i];
		if ((tile == prevTile) && (runLength < 254)) //it's a run
			runLength++;
		else {
			if (runLength<3) {
				if (runLength==0) {
					//singlebyte
					temp[index] = prevTile.getID();
					index++;
				} else {
				//a run not worth using
					for(int j = 0; j<runLength+1; j++) {
						temp[index] = prevTile.getID();
						index++;
					}
					runLength = 0;
				}
			} else {
				//a run worth using
				temp[index] = 255; //write escape character
				index++;
				temp[index] = runLength+1;
				runLength = 0;
				index++;
				temp[index] = prevTile.getID();
				index++;
			}
		}
		prevTile = tile;
	}
	int[] returnarray = new int[index];
	for(int i = 0; i<index; i++)
			returnarray[i] = temp[i];
	return returnarray;	
}
public static int[] decompInts(int[] data, int size) {
	int[] returnArray = new int[size];
	int counter = 0;
	for(int i=0; i<data.length;i++) {
		if (data[i]==255) {
			//run
			for(int j=0; j<data[i+1]; j++) {
				returnArray[counter] = data[i+2];
				counter++;
			}
			i+=2;
		} else {
			//norun
			returnArray[counter] = data[i];
			counter++;
		}
	}
	return returnArray;
}

public static String asmToHex(String asm) {
	String returnString="";
	for(int i=0;i<asm.length();i++) {
		if (hexDigits.indexOf(asm.charAt(i))!=-1)
			returnString = returnString + asm.charAt(i);
		if (asm.charAt(i)==';')
			break;
	}
	return returnString;
}

//helper classes


private static class TileDisplay extends JPanel {
	private final static int size = 36;
	private boolean isActive = false;
	private Tile tile;
	public TileDisplay(Tile newtile) {
		tile = newtile;
		setPreferredSize(new Dimension(size,size*2));
	}
	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile t) {
		tile = t;
		repaint();
	}
	public void setActive(boolean b) {
		isActive = b;
		repaint();
	}
	public boolean isActive() {
		return isActive;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		tile.drawTile(0,0,size,size,g);
		if (isActive) {
			g.setColor(new Color(100,50,50));
			g.drawRect(0,0,getWidth()-1, getHeight()-1);
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(50,50,50));
		g2d.setFont(new Font("sansserif",Font.BOLD,12));
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.drawString(Integer.toString(tile.getID()),5, size+10);
	}
	
}

private static class TileSelector extends JPanel{
	private final int totalSize = 40;
	private final int size = 36;
	private ArrayList<Tile> tileReference;
	private TileDisplay activeTileDisplay;
	private ArrayList<TileDisplay> displays;
	MouseListener m = new MouseListener() {
		public void mousePressed(MouseEvent e) {
			activeTileDisplay.setActive(false);
			activeTileDisplay.repaint();
			activeTileDisplay = (TileDisplay) e.getSource();
			activeTileDisplay.setActive(true);
			repaint();
		}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	};
	public void repaintActive() {
		activeTileDisplay.repaint();
	}
	public Tile getActiveTile() {
		return activeTileDisplay.getTile();
	}
	public void insertTileAt(final Tile t, final int index) {
		tileReference.add(index,t);
	}
	public void setTileAt(final Tile t, final int index) {
		tileReference.set(index,t);
	}
	public void removeTileAt(final int index) {
		displays.remove(index);
		tileReference.remove(index);
	}
	public void refresh(MouseListener d) {
		this.removeAll();
		displays.clear();
		for(int i=0; i<tileReference.size(); i++) {
			displays.add(new TileDisplay(tileReference.get(i)));
			this.add(displays.get(i));
			displays.get(i).addMouseListener(m);
			displays.get(i).addMouseListener(d);
		}
		revalidate();
		repaint();
	}
	public TileSelector(ArrayList<Tile> tileR) {
		tileReference = tileR;
		displays = new ArrayList();
		for(int i = 0; i<tileReference.size(); i++) {
			TileDisplay temp = new TileDisplay(tileReference.get(i));
			temp.addMouseListener(m);
			displays.add(temp);
			add(temp);
		}
		activeTileDisplay = displays.get(0);
		activeTileDisplay.setActive(true);
		
	}
	public TileSelector(ArrayList<Tile> tileR, MouseListener extraListener) {
		tileReference = tileR;
		displays = new ArrayList();
		for(int i = 0; i<tileReference.size(); i++) {
			TileDisplay temp = new TileDisplay(tileReference.get(i));
			temp.addMouseListener(m);
			temp.addMouseListener(extraListener);
			displays.add(temp);
			add(temp);
		}
		activeTileDisplay = displays.get(0);
		activeTileDisplay.setActive(true);
	}
}



private static class MapEditorPackage {
	public MapEditor editor;
	public OverDisplay overDisplay;
	public MapInfoPanel mapinfo;
	public TileSelector tselector;
	private int mouseX, mouseY, prevX, prevY;
	private boolean isWarpLinking;
	private Map prevMap;
	public MapEditorPackage(Map active, Map[] newOver, ArrayList<Tile> tileR) {
		overDisplay = new OverDisplay(newOver);
		editor = new MapEditor(active);
		mapinfo = new MapInfoPanel();
		tselector = new TileSelector(tileR);
	}
	public Map getMap() {
		return editor.getMap();
	}
	public class MapInfoPanel extends JPanel {
		MapInfoPanel() {
			setPreferredSize(new Dimension(400,100));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Map wMap = editor.getMap();
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(50,50,50));
			g2d.setFont(new Font("sansserif",Font.BOLD,12));
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
			g2d.drawString(Integer.toString(mouseX),10,12);
			g2d.drawString(Integer.toString(mouseY),30,12);
			g2d.drawString(Integer.toString(wMap.getTile(mouseX,mouseY).getID()),50,12);
			final NPC n = wMap.getNPC(mouseX,mouseY);
			final Warp w = wMap.getWarp(mouseX,mouseY);
			final Trigger t = wMap.getTrigger(mouseX,mouseY);
			if (n!=null) {
				g2d.drawString("NPC: "+trimConvo(convoReference.get(n.getConvo())),10,30);
				npcSprites.get(n.getSpriteID()*4).drawTile(10,40,32,32,g);
			}
			if (w !=null) {
				g2d.drawString("Warp: Warp to "+w.getMap().getName()+" ("+w.getXdest()+", " +w.getYdest()+")",10,30);
			}
			if (t !=null) {
				g2d.drawString("Trigger: "+trimConvo(convoReference.get(t.getConvo())),10,30);
			}
		}
	}
	
	public class MapEditor extends MapDisplay implements MouseListener, MouseMotionListener {
		
		public MapEditor(Map active) {
			super(active);
			isWarpLinking = false;
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		public void mousePressed(MouseEvent evt) {
			final int x = evt.getX()/24;
			final int y = evt.getY()/24;
			if ((x>=getMap().getWidth()) || (y>=getMap().getHeight()))
				return;
			if (isWarpLinking) {
				final int response = JOptionPane.showConfirmDialog(null, "Link warp tile here?");
				if (response == 0) {
					//final Map temp = editor.getMap();
					prevMap.setWarp(prevX,prevY,new Warp(editor.getMap(), mouseX,mouseY));
					isWarpLinking = false;
					editor.setMap(prevMap);
					editor.repaint();
				} else if (response == 2) {
					isWarpLinking = false;
				}
			} else {
				if (evt.isPopupTrigger()) {
					final MapEditPopup popup = new MapEditPopup();
					popup.show(evt.getComponent(),evt.getX(), evt.getY());
				} else {
					final Tile activeTile = tselector.getActiveTile();
					if (getMap().getTile(x,y) != activeTile) {
						getMap().setTile(x,y,activeTile);
						repaint();
					}
				}
			}
		}
		public void mouseClicked(MouseEvent evt) { }
		public void mouseDragged(MouseEvent evt) {
			final int x = evt.getX()/24;
			final int y = evt.getY()/24;
			if ((x>=getMap().getWidth()) || (y>=getMap().getHeight()))
				return;
			if (!isWarpLinking) {
				if (!evt.isPopupTrigger()) {
					
					final Tile activeTile = tselector.getActiveTile();
					if (getMap().getTile(x,y) != activeTile) {
						getMap().setTile(x,y,activeTile);
						repaint();
					}
				}
		    }
		}
		public void mouseReleased(MouseEvent evt) { 
				  getMap().updateMapImage();
				  overDisplay.repaint();
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseMoved(MouseEvent evt) { 
			mouseX = Math.min(15,evt.getX()/24);
			mouseY = Math.min(15,evt.getY()/24);
			mapinfo.repaint();
		}	
		private class MapEditPopup extends JPopupMenu implements ActionListener{
			final JMenuItem addNPC = new JMenuItem("Add NPC");
			final JMenuItem addWarp = new JMenuItem("Add Warp");
			final JMenuItem addTrigger = new JMenuItem("Add Trigger");
			final JMenuItem clear = new JMenuItem("Clear Tile");
			MapEditPopup() {
				super();
				addNPC.addActionListener(this);
				addWarp.addActionListener(this);
				addTrigger.addActionListener(this);
				clear.addActionListener(this);
				add(addNPC);
				add(addWarp);
				add(addTrigger);
				add(clear);
			}
			public void actionPerformed(ActionEvent a) {
				final Object src = a.getSource();
				final Map wMap = editor.getMap();
				if (src == addNPC) {
					final NPCSelector popup = new NPCSelector();
					final int convoIndex = popup.getIndex();
					if (convoIndex==convoReference.size()) {
						final NPCEditorPrompt editor = new NPCEditorPrompt(convoReference.size());
					}
					final NPCSpriteSelector popup2 = new NPCSpriteSelector();
					final int spriteIndex = popup2.getIndex();
					wMap.setNPC(mouseX,mouseY, new NPC(spriteIndex,convoIndex));
				} else if (src == addWarp) {
					isWarpLinking = true;
					prevX = mouseX;
					prevY = mouseY;
					prevMap = editor.getMap();
				} else if (src == addTrigger) {
					final NPCSelector popup = new NPCSelector();
					final int index = popup.getIndex();
					if (index==convoReference.size()) {
						final NPCEditorPrompt editor = new NPCEditorPrompt(convoReference.size());
					}
					wMap.setTrigger(mouseX,mouseY, new Trigger(index));
				} else if (src == clear) {
					wMap.setNPC(mouseX,mouseY,null);
					wMap.setWarp(mouseX,mouseY,null);
					wMap.setTrigger(mouseX,mouseY,null);
				}
				editor.repaint();
			}
		}
	}

	public class OverDisplay extends JPanel implements MouseListener {
		private Map[] over;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			final int dim = 192;
			for(int i=0; i<24; i++) {
				for (int j=0; j<24; j++) {
					if (over[j*24+i]!=null) {
						g.drawImage(over[j*24+i].getMapImage(),i*dim, j*dim, this);
						if (over[j*24+i]==editor.getMap()) {
							g.setColor(Color.red);
							g.drawRect(i*dim, j*dim, dim-1, dim-1);
						}
					}
				}
			}
			
			g.dispose();
		}
		
		OverDisplay(Map[] newOver) {
			over = newOver;
			setPreferredSize(new Dimension(192*24,192*24));
			addMouseListener(this);
		}
		
		public void mousePressed(MouseEvent evt) {
			final int x=evt.getX()/192;
			final int y=evt.getY()/192;
			final Map temp = over[y*24+x];
			if (evt.isMetaDown()) {
					final MapMetaEditor editor = new MapMetaEditor(temp);
				} else {
					if (temp == null){
						if (JOptionPane.showConfirmDialog(null,"Create new map here?")==0) {
							final Map newMap = new Map(tileReference.get(0));
							final MapMetaEditor e = new MapMetaEditor(newMap);
							mapReference.add(newMap);
							over[y*24+x] = newMap;
							editor.setMap(newMap);
						}
					} else {
						editor.setMap(temp);
					}
					mapinfo.repaint();
			}
			repaint();
		}
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
	}
}

private static class EnemyEditorPrompt extends JDialog implements ActionListener {
	final JTextField name = new JTextField(10);
	final JTextField[] stats = new JTextField[8];
	final JComboBox typeChooser = new JComboBox(playerTypes);
	final JComboBox[] moveChoosers = new JComboBox[4];
	final JButton save = new JButton("Save");
	final JButton cancel = new JButton("Cancel");
	final JButton sprites = new JButton("Edit Sprites");
	final EnemyDisplay disp = new EnemyDisplay();
	
	static Enemy enemy;
	static int index;
	EnemyEditorPrompt(final int i) {
		super((Frame) null, "Enemy Editor", true);
		setSize(new Dimension(300,350));
		index = i;
		if (index == enemyReference.size()) {
			enemy = new Enemy();
		} else {
			enemy = enemyReference.get(index);
		}
		final JPanel content = new JPanel();
		name.setText(enemy.getName());
		JPanel nameContainer = new JPanel(new BorderLayout());
		nameContainer.add(name, BorderLayout.CENTER);
		nameContainer.add(new JLabel("Enemy Name: "), BorderLayout.WEST);
		content.add(nameContainer);
		content.add(disp);
		typeChooser.setSelectedIndex(enemy.getType());
		JPanel tcontainer = new JPanel(new BorderLayout());
		tcontainer.add(typeChooser,BorderLayout.CENTER);
		tcontainer.add(new JLabel("Enemy Type: "), BorderLayout.WEST);
		content.add(tcontainer);
		final JPanel sFields = new JPanel(new GridLayout(4,4));
		final String[] names = {"HP","MP","Str","Skl","Spe","MStr","MSkl","Def"};
		for(int j=0; j<8; j++) {
			sFields.add(new JLabel(names[j]));
			stats[j] = new JTextField(Integer.toString(enemy.getStat(j)),3);
			sFields.add(stats[j]);
		}
		content.add(sFields);
		final JPanel moveContainer = new JPanel(new GridLayout(4,2));
		final String[] moveNames = getStrings(moveReference);
		for(int j=0; j<4; j++) {
			moveContainer.add(new JLabel("Move "+(j+1)));
			moveChoosers[j] = new JComboBox(moveNames);
			moveContainer.add(moveChoosers[j]);
		}
		content.add(moveContainer);
		final JPanel buttons = new JPanel();
		save.addActionListener(this);
		cancel.addActionListener(this);
		sprites.addActionListener(this);
		buttons.add(sprites);
		buttons.add(save);
		buttons.add(cancel);
		content.add(buttons);
		add(content);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == sprites) {
			ArrayList<Tile> vector = new ArrayList();
			Tile[] tiles = enemy.getSprites();
			vector.add(tiles[0]);
			vector.add(tiles[1]);
			final TileEditorPane editor = new TileEditorPane(vector, 2);
			tiles[0] = vector.get(0);
			tiles[1] = vector.get(1);
			enemy.setSprites(tiles);
			disp.repaint();
			return;
		}
		if (src == save) {
			if (index == enemyReference.size()) {
				enemyReference.add(enemy);
			}
			final String n = name.getText();
			final int type = typeChooser.getSelectedIndex();
			final int[] statints = new int[8];
			for(int i=0; i<8; i++) {
				statints[i] = Integer.parseInt(stats[i].getText());
			}
			final int[] moves = new int[4];
			for(int i=0; i<4; i++) {
				moves[i] = moveChoosers[i].getSelectedIndex();
			}
			enemy.setStats(statints);
			enemy.setName(n);
			enemy.setType(type);
			enemy.setMoves(moves);
		}
		dispose();
	}
	
	private static class EnemyDisplay extends JPanel {
		EnemyDisplay() {
			setPreferredSize(new Dimension(100,50));
		}
		public void paintComponent(Graphics g) {
			final Tile[] sprites = enemy.getSprites();
			sprites[0].drawTile(0,0,48,48,g);
			sprites[1].drawTile(50,0,48,48,g);
			}
	}

}
private static class MoveEditorPrompt extends JDialog implements ActionListener {
	final JTextField name = new JTextField(10);
	final JComboBox typeChooser = new JComboBox(playerTypes);
	final JButton save = new JButton("Save");
	final JButton cancel = new JButton("Cancel");
	private static JTextField s1q,s2q,funcID,animField,damage;
	private static JComboBox s1Chooser, s2Chooser;
	private static int index;
	MoveEditorPrompt(final int i) {
		super((Frame) null, "Move Editor", true);
		setSize(new Dimension(300,300));
		index = i;
		Move move;
		if (index == moveReference.size()) {
			move = new Move();
		} else {
			move = moveReference.get(index);
		}
		final JPanel content = new JPanel();
		name.setText(move.getName());
		final JPanel nameContainer = new JPanel(new BorderLayout());
		nameContainer.add(name, BorderLayout.CENTER);
		nameContainer.add(new JLabel("Move Name: "), BorderLayout.WEST);
		content.add(nameContainer);
		
		typeChooser.setSelectedIndex(move.getType());
		final JPanel tcontainer = new JPanel(new BorderLayout());
		tcontainer.add(typeChooser,BorderLayout.CENTER);
		tcontainer.add(new JLabel("Move Type: "), BorderLayout.WEST);
		content.add(tcontainer);
		
		final JPanel sFields = new JPanel(new GridLayout(3,2));
		s1Chooser = new JComboBox(stats);
		s1Chooser.setSelectedIndex(move.getStat(0));
		s2Chooser = new JComboBox(stats);
		s2Chooser.setSelectedIndex(move.getStat(2));
		s1q = new JTextField(Integer.toString(move.getStat(1)),3);
		s2q = new JTextField(Integer.toString(move.getStat(3)),3);
		sFields.add(new JLabel("Stat 1"));
		sFields.add(new JLabel("Stat 2"));
		sFields.add(s1Chooser);
		sFields.add(s2Chooser);
		sFields.add(s1q);
		sFields.add(s2q);
		content.add(sFields);
		
		final JPanel func = new JPanel(new GridLayout(3,2));
		func.add(new JLabel("Function ID: "));
		funcID = new JTextField(Integer.toString(move.getFuncID()),3);
		func.add(funcID);
		func.add(new JLabel("Animation ID: "));
		animField = new JTextField(Integer.toString(move.getAnim()),3);
		func.add(animField);
		func.add(new JLabel("Damage: "));
		damage = new JTextField(Integer.toString(move.getDmg()),3);
		func.add(damage);
		content.add(func);
		
		final JPanel buttons = new JPanel();
		save.addActionListener(this);
		cancel.addActionListener(this);
		buttons.add(save);
		buttons.add(cancel);
		content.add(buttons);
		
		add(content);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == save) {
			final int[] data = new int[4];
			data[0] = s1Chooser.getSelectedIndex();
			data[1] = Integer.parseInt(s1q.getText());
			data[2] = s2Chooser.getSelectedIndex();
			data[3] = Integer.parseInt(s2q.getText());
			final Move move = new Move(name.getText(),data,typeChooser.getSelectedIndex(),
								Integer.parseInt(animField.getText()), Integer.parseInt(damage.getText()),
								Integer.parseInt(funcID.getText()));
			if (index == moveReference.size()) {
				moveReference.add(move);
			} else {
				moveReference.set(index, move);
			}
		}		
		dispose();
	}
}

private static class ItemEditorPrompt extends JDialog implements ActionListener {
	private static final String[] itemTypes = {"No type","Functional","Consumable","Booster","Weapon","Shield","Armor","Helmet","Amulet","Boots"};
	final JTextField name = new JTextField(10);
	final JComboBox itemTypeChooser = new JComboBox(itemTypes);
	final JButton save = new JButton("Save");
	final JButton cancel = new JButton("Cancel");
	private static JTextField s1q,s2q,funcID,wPow,price;
	private static JComboBox s1Chooser, s2Chooser,weapType;
	private static int index;
	ItemEditorPrompt(final int i) {
		super((Frame) null, "Item Editor", true);
		setSize(new Dimension(300,300));
		index = i;
		if (index == itemReference.size()) {
			itemReference.add(new Item());
		}
		final Item item = itemReference.get(index);
		final JPanel content = new JPanel();
		name.setText(item.getName());
		final JPanel nameContainer = new JPanel(new BorderLayout());
		nameContainer.add(name, BorderLayout.CENTER);
		nameContainer.add(new JLabel("Item Name: "), BorderLayout.WEST);
		content.add(nameContainer);
		
		itemTypeChooser.setSelectedIndex(item.getType());
		final JPanel itcontainer = new JPanel(new BorderLayout());
		itcontainer.add(itemTypeChooser,BorderLayout.CENTER);
		itcontainer.add(new JLabel("Item Type: "), BorderLayout.WEST);
		content.add(itcontainer);
		
		final JPanel sFields = new JPanel(new GridLayout(3,2));
		s1Chooser = new JComboBox(stats);
		s1Chooser.setSelectedIndex(item.getStat(0));
		s2Chooser = new JComboBox(stats);
		s2Chooser.setSelectedIndex(item.getStat(2));
		s1q = new JTextField(Integer.toString(item.getStat(1)),3);
		s2q = new JTextField(Integer.toString(item.getStat(3)),3);
		sFields.add(new JLabel("Stat 1"));
		sFields.add(new JLabel("Stat 2"));
		sFields.add(s1Chooser);
		sFields.add(s2Chooser);
		sFields.add(s1q);
		sFields.add(s2q);
		content.add(sFields);
		
		final JPanel weapon = new JPanel(new GridLayout(2,2));
		weapType = new JComboBox(playerTypes);
		weapType.setSelectedIndex(item.getStat(2));
		wPow = new JTextField(Integer.toString(item.getStat(3)),3);
		weapon.add(new JLabel("Weapon Type: "));
		weapon.add(weapType);
		weapon.add(new JLabel("Weapon Power: "));
		weapon.add(wPow);
		content.add(weapon);
		
		final JPanel func = new JPanel(new GridLayout(2,2));
		func.add(new JLabel("Function ID: "));
		funcID = new JTextField(Integer.toString(item.getStat(0)),3);
		func.add(funcID);
		func.add(new JLabel("Price: "));
		price = new JTextField(Integer.toString(item.getPrice()),3);
		func.add(price);
		content.add(func);
		
		final JPanel buttons = new JPanel();
		save.addActionListener(this);
		cancel.addActionListener(this);
		buttons.add(save);
		buttons.add(cancel);
		content.add(buttons);
		
		add(content);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == save) {
			Item item = new Item(name.getText());
			final int type = itemTypeChooser.getSelectedIndex();
			if (type == 1)
				item.setStat(0,Integer.parseInt(funcID.getText()));
			else{
				item.setStat(0,s1Chooser.getSelectedIndex());
				item.setStat(1,Integer.parseInt(s1q.getText()));
				item.setType(type);
				if (type==4) {
					item.setStat(2,weapType.getSelectedIndex());
					item.setStat(3,Integer.parseInt(wPow.getText()));
				} else {
					item.setStat(2,s2Chooser.getSelectedIndex());
					item.setStat(3,Integer.parseInt(s2q.getText()));
				}
			}
			item.setPrice(Integer.parseInt(price.getText()));
			itemReference.set(index,item);
		}
		dispose();
	}
	
}

private static class NPCSpriteSelector extends JDialog implements ActionListener{
	final JButton[] buttons = new JButton[npcSprites.size()/4];
	int index = -1;
	NPCSpriteSelector() {
		super((JFrame) null, "NPC Sprite Selector",true);
		final JPanel content = new JPanel(new GridLayout(buttons.length,1));
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton(npcSprites.get(i*4).getIcon());
			content.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		final JScrollPane pane = new JScrollPane(content);
		add(pane);
		setSize(new Dimension(400,500));
		setVisible(true);
	}
	public int getIndex() {
		return index;
	}
	public void actionPerformed(ActionEvent e) {
		final Object src = e.getSource();
		for(int i=0; i<buttons.length; i++) {
			if (src == buttons[i]) {
				index = i;
				break;
			}
		}
		dispose();
	}
	
}

private static class MapMetaEditor extends JDialog implements ActionListener {
	private static Map map;
	private static final JTextField name = new JTextField(20);
	private static SpinnerNumberModel levelSpinModel;
	private static JSpinner levelSpinner;
	private static final JButton remove = new JButton("Delete Map");
	private static final JButton save = new JButton("Save");
	private static final JButton cancel = new JButton("Cancel");
	private static final JComboBox[] enemies = new JComboBox[3];
	MapMetaEditor(Map m) {
		super((Frame) null, "Edit Map Data", true);
		setSize(new Dimension(300,300));
		map = m;
		final JPanel content = new JPanel();
		content.add(new JLabel("Name:"));
		name.setText(map.getName());
		content.add(name);
		levelSpinModel = new SpinnerNumberModel(map.getElvl(),0,100,1);
		levelSpinner = new JSpinner(levelSpinModel);
		
		final JPanel enemyContainer = new JPanel(new GridLayout(3,1));
		enemyContainer.add(new JLabel("Enemy Level: "));
		enemyContainer.add(levelSpinner);
		
		//build combo box string
		final int s = enemyReference.size();
		String[] names = new String[s];
		for(int i=0; i<s; i++) {
			names[i] = enemyReference.get(i).getName();
		}
		for(int i=0; i<3; i++) {
			enemies[i] = new JComboBox(names);
			enemies[i].setSelectedIndex(map.getEnemies()[i]);
			enemyContainer.add(enemies[i]);
		}
		content.add(enemyContainer);
		remove.addActionListener(this);
		save.addActionListener(this);
		cancel.addActionListener(this);
		JPanel buttonContainer = new JPanel(new GridLayout(1,2));
		buttonContainer.add(save);
		buttonContainer.add(cancel);
		content.add(remove);
		content.add(buttonContainer);
		add(content);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		final Object src = e.getSource();
		if (src == save) {
			final Integer level = (Integer) (levelSpinner.getValue());
			map.setEneLevel(level);
			int[] en = new int[3];
			for(int i=0; i<3; i++)
				en[i] = enemies[i].getSelectedIndex();
			map.setEnemies(en);
			String n = name.getText();
			if (n.length() > 20) {
				n = n.substring(0,19);
			}
			map.setName(n);
		} else if (src == remove) {
			mapReference.remove(map);
			for(int i=0; i<overworld.length; i++) {
				if (overworld[i] == map) {
					overworld[i] = null;
					break;
				}
			}
		}
		dispose();
	}
}
private static class NPCSelector extends Selector {
	private static String[] getStrings() {
		final int s = convoReference.size();
		String[] strings = new String[s]; 
		for(int i=0; i<s; i++) {
			strings[i] = trimConvo(convoReference.get(i));
		}
		return strings;
	}
	NPCSelector() {
		super("NPC Conversation Selector",getStrings());
	}
}

private static class NPCEditorPrompt extends JDialog implements ActionListener {
	private static JPanel content;
	private static JTextArea textArea;
	private static int index;
	private static final JButton save = new JButton("Save");
	private static final JButton cancel = new JButton("Cancel");
	
	public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
				if (src == save) {
					String s = textArea.getText();
					if (s.length()<8) {
						JOptionPane.showMessageDialog(null,"Use form '.db xxxx,0'");
						return;
					}					
					convoReference.set(index, textArea.getText());
				}
			dispose();
		}
	NPCEditorPrompt(int i) {
		super((Frame) null, "Conversation Editor");
		index = i;
		if (index == convoReference.size())
			convoReference.add(".db \"");
		setSize(new Dimension(600,400));
		textArea = new JTextArea(convoReference.get(index),5, 20);
		JTextArea info = new JTextArea("Available Commands:\nname\ncheckFlag (word flagID, label)\ncheckItem (byte itemID, label)\nsetFlag (word Flag #)\nresFlag (word flagID)\nnewLine\npause\ngetItem (byte itemID)\nbattle (byte enemyID, byte level)\nchangeTile (byte tileID, byte x, byte y)\nstore\ninput (label)\njump (label)\nwarp (byte overworldX, byte overworldY, byte destinationX, byte destinationY)\ngetMoney (word quantity)\nheal\nspecialBattle", 5,25);
		info.setEditable(false);
		JPanel editor = new JPanel(new BorderLayout());
		editor.add(new JScrollPane(textArea),BorderLayout.CENTER);
		JPanel buttons = new JPanel();
			
			buttons.add(save);
			buttons.add(cancel);
			save.addActionListener(this);
			cancel.addActionListener(this);
		editor.add(buttons,BorderLayout.SOUTH);
		JSplitPane content = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JScrollPane(info),editor);
		content.setDividerLocation(100);
		add(content);
		setVisible(true);
	}
}


private static class TileEditorPane extends JDialog {
	private ArrayList<Tile> tileReference;
	private boolean[] mainColor;
	private boolean[] altColor;
	private TileEditor editArea;
	private TileEditorControls controls;
	private MapDisplay mapDisplay;
	private Tile copyBuffer;
	private boolean mapDisplayed;
	
	private MouseListener editorListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {
			editArea.repaint();
			if (e.isPopupTrigger()) {
				EditMenu popup = new EditMenu(((TileDisplay) e.getSource()).getTile());
				popup.show(e.getComponent(),e.getX(), e.getY());
			} else {
				
			}					
		}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		
		};
	private TileSelector tselector;
	
	TileEditorPane(final Map active, final ArrayList<Tile> tileR) {
		super((Frame) null, "Tile Editor", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		tileReference = tileR;
		tselector  = new TileSelector(tileReference, editorListener);
		mainColor = new boolean[3];
		mainColor[0] = true;
		mainColor[1] = true;
		altColor = new boolean[3];
		editArea = new TileEditor();
		controls = new TileEditorControls();
		mapDisplay = new MapDisplay(active);
		
		JScrollPane editAreaContainer = new JScrollPane(editArea);
		
		JSplitPane editor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editAreaContainer, controls);
		editor.setDividerLocation(500);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(tselector), editor);
		splitPane.setDividerLocation(100);
		JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, mapDisplay);
		content.setDividerLocation(500);
		add(content);
		setSize(new Dimension(1000,700));
		mapDisplayed = true;
		setVisible(true);
	}
	TileEditorPane(final ArrayList<Tile> tileR, final int width) {
		this(makeAMap(tileR,width), tileR);
	}
	private static Map makeAMap(final ArrayList<Tile> tileR, final int width) {
		final int s = tileR.size()/width+1;
		final Tile[] tiles = new Tile[s*width];
		for(int i=0; i<tileR.size(); i++) {
			tiles[i] = tileR.get(i);
		}
		for(int i=tileR.size(); i<tiles.length; i++) {
			tiles[i] = new Tile(new boolean[tiles[0].getData().length], tiles[0].getTrueWidth(),
								tiles[0].getHeight(), 0);
		}
		return new Map(tiles,width,s);
	}
	private class EditMenu extends JPopupMenu implements ActionListener{
		final JMenuItem copy = new JMenuItem("Copy");
		final JMenuItem paste = new JMenuItem("Paste");
		final JMenuItem insert = new JMenuItem("Insert New");
		final JMenuItem delete = new JMenuItem("Delete");
		final JMenuItem clear = new JMenuItem("Clear");
		Tile workingTile;
		public EditMenu(Tile tile) {
			workingTile = tile;
			copy.addActionListener(this);
			paste.addActionListener(this);
			insert.addActionListener(this);
			delete.addActionListener(this);
			clear.addActionListener(this);
			add(copy);
			add(paste);
			add(insert);
			add(delete);
			add(clear);
		}
		public void actionPerformed(ActionEvent evt) {
			final Object src = evt.getSource();
			final int id = workingTile.getID();
			if (src == copy) {
				copyBuffer = workingTile;
			} else if (src == paste) {
				if (copyBuffer!=null) {
					final Tile temp = new Tile(Arrays.copyOf(copyBuffer.getData(),copyBuffer.getData().length),
											workingTile.getTrueWidth(),
											workingTile.getHeight(),
											workingTile.getID());
					if (workingTile.isMasked()) 
						temp.setMask(workingTile.getMask());
					tselector.setTileAt(temp, id);
				}
			} else if (src == insert) {
				final Tile temp = new Tile(workingTile.getTrueWidth(),workingTile.getHeight(),id);
				tselector.insertTileAt(temp, id);
			} else if (src == delete) {
				tselector.removeTileAt(id);
			} else if (src == clear) {
				workingTile.setData(new boolean[384]);
			}
			syncIDs();
			tselector.refresh(editorListener);
		}
	}
	
	private class TileEditor extends JPanel implements MouseListener,MouseMotionListener {
		private int pixelSize,width,height;
		TileEditor() {
			height = tselector.getActiveTile().getHeight()*16;
			width = tselector.getActiveTile().getTrueWidth()*16;
			addMouseListener(this);
			addMouseMotionListener(this);
			setSize(new Dimension(width,height));
			pixelSize = 16;
		}
		
		public void resize(final int s) {
			pixelSize = (int) Math.pow(2,s);
			height = tselector.getActiveTile().getHeight()*pixelSize;
			width = tselector.getActiveTile().getTrueWidth()*pixelSize;
			repaint();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			tselector.getActiveTile().drawTile(0,0,width,height,g);
			g.dispose();
		}
	  public void mousePressed(MouseEvent evt) {
		 mouseDragged(evt);
	  }
      public void mouseClicked(MouseEvent evt) { }
      public void mouseDragged(MouseEvent evt) {
		  boolean[] color;
		  if (evt.isMetaDown()) {
			  color = altColor;
		  } else {
			  color = mainColor;
		  }
		  Tile tile = tselector.getActiveTile();
		  int x = Math.max(0,Math.min(evt.getX()/pixelSize,tile.getTrueWidth()-1));
		  int y = Math.max(0,Math.min(evt.getY()/pixelSize,tile.getHeight()-1));
		  tile.setPixel(x,y,color);
		  repaint();
		  }
      public void mouseMoved(MouseEvent evt) {}      
      public void mouseReleased(MouseEvent evt) { 
			mapDisplay.repaint();
			tselector.repaintActive();
		}
      public void mouseEntered(MouseEvent evt) { }
      public void mouseExited(MouseEvent evt) { }
}
	private class TileEditorControls extends JPanel implements ActionListener {
		final JToggleButton enableMask = new JToggleButton("Masked");
		final String[] s = {"1x","2x","4x","8x","16x","32x","64x"};
		final JComboBox sizeSelector = new JComboBox(s);
		final SpinnerNumberModel spinModel = new SpinnerNumberModel(tileReference.size(),1,256,1);
		final JSpinner tileCount = new JSpinner(spinModel);
		ChangeListener c = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				final Integer newCount = (Integer) tileCount.getValue();
				final int size = tileReference.size();
				if (newCount > size) {
					final int w = tileReference.get(0).getTrueWidth();
					final int h = tileReference.get(0).getHeight();
					for(int i=size; i<newCount; i++) {
						Tile t = new Tile(w,h,i);
						if (tileReference.get(0).isMasked())
							t.setMask();
						tileReference.add(t);
					}
				} else if (newCount < size) {
					for(int i=size-1; i>=newCount; i--) {
						tileReference.remove(i);
					}
				}
				tselector.refresh(editorListener);
			}
		};
		TileEditorControls() {
			add(new colorChooser());
			add(enableMask);
			enableMask.addActionListener(this);
			if (tselector.getActiveTile().isMasked())
				enableMask.setSelected(true);
			add(sizeSelector);
			sizeSelector.addActionListener(this);
			sizeSelector.setSelectedIndex(4);
			final JPanel tileCountContainer = new JPanel();
			tileCount.addChangeListener(c);
			tileCountContainer.add(new JLabel("Tiles: "));
			tileCountContainer.add(tileCount);
			add(tileCountContainer);
		}
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == enableMask) {
				if (enableMask.isSelected() == tselector.getActiveTile().isMasked())
					return;
				tselector.getActiveTile().toggleMasked();
				repaint();
				editArea.repaint();
			} else if (src == sizeSelector) {
				JComboBox c = (JComboBox) src;
				int i = c.getSelectedIndex();
				editArea.resize(i);
			} 
		}
		
		private Color boolToColor(boolean[] b) {
			if (b[2])
				return Color.blue;
			if (b[0] && b[1])
				return ide.black;
			if (b[0])
				return ide.darkGray;
			if (b[1])
				return ide.lightGray;
			return ide.white;
		}
		
		private class colorChooser extends JPanel implements MouseListener{
			private int size;
			colorChooser() {
				addMouseListener(this);
				setPreferredSize(new Dimension(200,25));
				size = 7;
			}
			public void paintComponent(Graphics g) {
				if (tselector.getActiveTile().isMasked())
					size = 8;
				else
					size = 7;
				int height = getHeight();
				int width = getWidth()/size;
				int gray = 0;
				g.setColor(boolToColor(mainColor));
				g.fillRect(0,0,width,height);
				g.setColor(boolToColor(altColor));
				g.fillRect(width,0,width,height);
				g.setColor(new Color(50,50,100));
				g.drawRect(0,0,width*2,height-1);
				g.setColor(ide.black);
				g.fillRect(width*3,0,width,height);
				g.setColor(ide.darkGray);
				g.fillRect(width*4,0,width, height);
				g.setColor(ide.lightGray);
				g.fillRect(width*5,0,width,height);
				g.setColor(ide.white);
				g.fillRect(width*6,0,width,height);
				if (tselector.getActiveTile().isMasked()) {
					g.setColor(Color.blue);
					g.fillRect(width*7,0,width,height);
					g.setColor(new Color(100,50,50));
					g.drawRect(width*3,0,width*5-1,height-1);
				} else {
					g.setColor(new Color(100,50,50));
					g.drawRect(width*3,0,width*4-1,height-1);
				}
			}
			public void mousePressed(MouseEvent evt) {
				int index = evt.getX()*size/getWidth()-3;
				if (index < 0)
					return;
				final boolean[] colorIndex = {true, true, false,
												true, false, false,
												false, true, false,
												 false, false, false,
												 false, false, true};
				
				if (evt.isMetaDown()) {
					altColor[0] = colorIndex[index*3];
					altColor[1] = colorIndex[index*3+1];
					altColor[2] = colorIndex[index*3+2];
				} else {
					mainColor[0] = colorIndex[index*3];
					mainColor[1] = colorIndex[index*3+1];
					mainColor[2] = colorIndex[index*3+2];
				}
				//probably could clean this up to be less wonky
				repaint();
				}
			public void mouseClicked(MouseEvent evt) { }
			public void mouseReleased(MouseEvent evt) { }
			public void mouseEntered(MouseEvent evt) { }
			public void mouseExited(MouseEvent evt) { }
		}			
	}
	

}


private static class CustomMenu extends JPanel implements ActionListener {
	
	private final JButton button1 = new JButton("Tile Editor");
	private final JButton button2 = new JButton("NPC Editor");
	private final JButton button3 = new JButton("Item Editor");
	private final JButton button4 = new JButton("Move Editor");
	private final JButton button5 = new JButton("Enemy Editor");
	private final JButton button6 = new JButton("NPC Sprite Editor");
	private final JButton save = new JButton("Save Changes");
	private final JButton discard = new JButton("Discard Changes");
	public CustomMenu() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		save.addActionListener(this);
		discard.addActionListener(this);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(save);
		add(discard);
	}

	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == button1) {
			TileEditorPane tileEditor = new TileEditorPane(mapEditorMain.getMap(), tileReference);
		} else if (src == button2) {
			NPCSelector n = new NPCSelector();
			final int index = n.getIndex();
			if (index!=-1) {
				NPCEditorPrompt editor = new NPCEditorPrompt(index);
				//n.setVisible(true);
			}
		} else if (src == button3) {
			//item editor
			Selector i = new Selector("Item Selector",getStrings(itemReference));
			final int index = i.getIndex();
			if (index!=-1) {
				ItemEditorPrompt editor = new ItemEditorPrompt(index);
				//i.setVisible(true);
			}
		} else if (src == button4) {
			Selector m = new Selector("Move Selector", getStrings(moveReference));
			final int index = m.getIndex();
			if (index!=-1) {
				MoveEditorPrompt editor = new MoveEditorPrompt(index);
				//m.setVisible(true);
			}
		} else if (src == button5) {
			Selector e = new Selector("Enemy Selector", getStrings(enemyReference));
			final int index = e.getIndex();
			if (index!=-1) {
				EnemyEditorPrompt editor = new EnemyEditorPrompt(index);
				//e.setVisible(true);
			}
		} else if (src== button6) {
			TileEditorPane npcSpriteEditor = new TileEditorPane(npcSprites,4);
		} else if (src == save) {
			try{
				exportAll();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			resetAll();
		}
	}
}



public static void main(String[] args) {
	moveReference = new ArrayList();
	itemReference = new ArrayList();
	enemyReference = new ArrayList();
	convoReference = new ArrayList();
	npcSprites = new ArrayList();
	tileReference = new ArrayList();
	mapReference = new ArrayList();
	
		resetAll();
   
	mapEditorMain = new MapEditorPackage(mapReference.get(1),overworld, tileReference);
	final MapEditorPackage.OverDisplay overWorldContainer = mapEditorMain.overDisplay;
	final MapEditorPackage.MapEditor mapDisplayPanel = mapEditorMain.editor;
	final TileSelector tileContainer = mapEditorMain.tselector;
	final JScrollPane overScrollPane = new JScrollPane(overWorldContainer);
	
	final JScrollPane tileScrollPane = new JScrollPane(tileContainer);
	
	final JPanel mapContainer = new JPanel();
	mapContainer.setLayout(new BorderLayout());
	
	final JScrollPane mapScrollPane = new JScrollPane(mapDisplayPanel);
	mapContainer.add(mapScrollPane,BorderLayout.CENTER);
	mapContainer.add(mapEditorMain.mapinfo,BorderLayout.SOUTH);
	final JSplitPane mapTileContainer = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tileScrollPane, mapContainer);
	mapTileContainer.setDividerLocation(100);
	final JSplitPane mainContent = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mapTileContainer, overScrollPane);
	mainContent.setDividerLocation(600);
	
	
	final CustomMenu menuBar = new CustomMenu();
	final JPanel content = new JPanel(new BorderLayout());
	content.add(menuBar,BorderLayout.NORTH);
	content.add(mainContent, BorderLayout.CENTER);
	
	final JFrame mainWindow = new JFrame("Ash:Phoenix IDE");
	WindowFocusListener w = new WindowFocusListener() {
		public void windowGainedFocus(WindowEvent e) {
			tileContainer.refresh(null);
			int s = mapReference.size();
			for(int i=1; i<s; i++) {
				mapReference.get(i).updateMapImage();
			}
			overWorldContainer.repaint();
			mapDisplayPanel.repaint();
		}
		public void windowLostFocus(WindowEvent e) {}
	};
	mainWindow.addWindowFocusListener(w);
	mainWindow.setContentPane(content);
	mainWindow.setSize(1080,768);
	mainWindow.setLocation(100,10);
	mainWindow.setVisible(true);
	
	}

}
