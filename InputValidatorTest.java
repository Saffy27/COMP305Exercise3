/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class InputValidatorTest {
    
    // --- USERNAME TESTS ---
    @Test
    public void testUsernameIsValid() {
        // Valid username (under 20 chars, not empty)
        assertTrue(InputValidator.isValidUsername("Artist_Alex"));
    }

    @Test
    public void testUsernameTooLong() {
        // Should be false because it's over 20 characters
        assertFalse(InputValidator.isValidUsername("ThisUsernameIsWayTooLongForTheSystem"));
    }

    @Test
    public void testUsernameEmpty() {
        assertFalse(InputValidator.isValidUsername(""));
    }

    // --- PASSWORD TESTS ---
    @Test
    public void testPasswordValid() {
        // 8+ chars, Upper, Lower, Digit, Special (! - * .)
        assertTrue(InputValidator.isValidPassword("ArtPass1!"));
    }

    @Test
    public void testPasswordMissingDigit() {
        assertFalse(InputValidator.isValidPassword("ArtPass!"));
    }

    @Test
    public void testPasswordInvalidChar() {
        // '#' is not in the allowed list: !, -, *, .
        assertFalse(InputValidator.isValidPassword("ArtPass1#"));
    }

    // --- PHONE NUMBER TESTS ---
    @Test
    public void testPhoneValidWithDashes() {
        assertTrue(InputValidator.isValidPhone("123-456-7890"));
    }

    @Test
    public void testPhoneValidEmpty() {
        // The requirements say phone can be empty
        assertTrue(InputValidator.isValidPhone(""));
    }

    @Test
    public void testPhoneInvalidLength() {
        assertFalse(InputValidator.isValidPhone("12345"));
    }
    
}