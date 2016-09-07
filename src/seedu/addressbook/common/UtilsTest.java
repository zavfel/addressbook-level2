package seedu.addressbook.common;

import static org.junit.Assert.*;
import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.commands.HelpCommand;
import seedu.addressbook.parser.Parser;

public class UtilsTest {
	
    @Test
    public void emptyInput_returnsCorrect() {
        final Object obj = null;
        assertTrue(Utils.isAnyNull(obj));
    }
    
    @Test
    public void NonEmptyInput_returnsIncorrect() {
        final Object obj = new Object();
        assertFalse(Utils.isAnyNull(obj));
    }
    
    @Test
    public void NonIdenticalInput_returnsCorrect() {
        final ArrayList<Integer> lst = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        assertTrue(Utils.elementsAreUnique(lst));
    }
    
    @Test
    public void IdenticalInput_returnsIncorrect() {
        final ArrayList<Integer> lst = new ArrayList<Integer>(Arrays.asList(1,1,3,4,5));
        assertTrue(Utils.elementsAreUnique(lst));
    }
}
