/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for InputValidator class.
 */
public class InputValidatorTest {

    // DOB tests
    @Test
    public void testValidDOB() {
        assertTrue(InputValidator.isValidDOB("2000-05-10"));
    }

    @Test
    public void testUnderageDOB() {
        assertFalse(InputValidator.isValidDOB("2010-01-01"));
    }

    @Test
    public void testInvalidDOBFormat() {
        assertFalse(InputValidator.isValidDOB("05-10-2000"));
    }

    @Test
    public void testEmptyDOB() {
        assertFalse(InputValidator.isValidDOB(""));
    }

    @Test
    public void testNullDOB() {
        assertFalse(InputValidator.isValidDOB(null));
    }

    // Postal code tests
    @Test
    public void testValidPostalCode() {
        assertTrue(InputValidator.isValidPostalCode("49006"));
    }

    @Test
    public void testInvalidPostalCode() {
        assertFalse(InputValidator.isValidPostalCode("12a45"));
    }

    @Test
    public void testEmptyPostalCodeAllowed() {
        assertTrue(InputValidator.isValidPostalCode(""));
    }

    // Title tests
    @Test
    public void testValidTitle() {
        assertTrue(InputValidator.isValidTitle("Sunset Painting"));
    }

    @Test
    public void testEmptyTitle() {
        assertFalse(InputValidator.isValidTitle(""));
    }

    @Test
    public void testTooLongTitle() {
        String longTitle = new String(new char[101]).replace('\0', 'a');
        assertFalse(InputValidator.isValidTitle(longTitle));
    }
}