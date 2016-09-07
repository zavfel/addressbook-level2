package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
	
	public static final String CONTACT_VALIDATION_REGEX = ".+";
	
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String constraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        contact = contact.trim();
        if (!isValidContact(contact)) {
            throw new IllegalValueException(constraints);
        }
        this.value = contact;
    }

    /**
     * Checks if a given string is a valid person contact.
     */
    public boolean isValidContact(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
