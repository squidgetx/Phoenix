import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Selector extends JDialog implements ActionListener {
	private static JButton[] buttons;
	private static int index=-1;
	Selector(String s, String[] names) {
		super((Frame) null, s, true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int size = names.length;
		setSize(new Dimension(400,400));
		
		JPanel content = new JPanel(new GridLayout(size+1,1));
		buttons = new JButton[size+1];
		JPanel wrapper;
		for(int i = 0; i<size; i++){
			buttons[i] = new JButton(names[i]);
			wrapper = new JPanel();
			wrapper.add(new JLabel(i+": "));
			wrapper.add(buttons[i]);
			content.add(wrapper);
			buttons[i].addActionListener(this);
		}
		buttons[size] = new JButton("Add new");
		buttons[size].addActionListener(this);
		content.add(buttons[size]);
		add(new JScrollPane(content));
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		index = -1;
		for(int i = 0; i < buttons.length; i++) {
			if (src == buttons[i])
				index = i;
		}
		dispose();
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int i) {
		index = i;
	}
	public JButton[] getButtons() {
		return buttons;
	}
}
