package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * keep tracks of tags added or deleted during the seesion
 *
 */
public class Tagging {
	public enum Command {
		ADD, REMOVE
	}
	
	private Command command;
	private Person person;
	private Tag tag;
	
	public Tagging(Command command, Person person, Tag tag) {
		this.command = command;
		this.person = person;
		this.tag = tag;
	}
	
	/**
	 * prints out the command for particular tag
	 */
	public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (command == Command.ADD) {
        	builder.append("+ ");
        } else {
        	builder.append("- ");
        }
        builder.append(person.toString())
        		.append(" ")
        		.append(tag.toString());
        return builder.toString();
	}
}
