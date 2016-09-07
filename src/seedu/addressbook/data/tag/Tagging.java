package seedu.addressbook.data.tag;

import java.util.ArrayList;

/**
 * keep tracks of tags added or deleted during the seesion
 *
 */
public class Tagging {
	private static ArrayList<String> commands;
	private static ArrayList<String> people;
	private static ArrayList<String> tags;
	private static int nextIndex = 1;
	
	private int index;
	
	public Tagging(String command, String person, String tag) {
		commands.add(command);
		people.add(person);
		tags.add(tag);
		index = nextIndex;
		nextIndex++;
	}
	
	/**
	 * prints out a list of tags added/deleted during session
	 */
	public void getSessionTagInfo() {
		for (int i=0;i<nextIndex;i++) {
			String info = commands.get(i) + " " 
					+ people.get(i) + " "
					+ "[" + tags.get(i) + "] ";
			System.out.println(info);
		}
	}
}
