package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name n1;

    @Before
    public void setup() throws IllegalValueException {
        n1 = new Name("John K Smith");
    }
    
    @Test
    public void test() throws IllegalValueException {
        final Name n2 = new Name("John");
        assertTrue(n1.isSimilar(n2));
    }

}
