import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Test class for InputValidator.
 * Following TDD principles to validate Name, Last Name, and Email fields.
 * * @author Jeremy Tarn
 * @version 1.0
 */
public class InputValidatorTest {

    // --- Tests for Name ---
    
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

    @Test
    public void testIsValidName_Valid() {
        assertTrue("Should accept standard letters", InputValidator.isValidName("Anna"));
        assertTrue("Should accept diacritic marks", InputValidator.isValidName("José"));
        assertTrue("Should accept spaces", InputValidator.isValidName("Anna Phyo"));
    }

    @Test
    public void testIsValidName_Invalid() {
        assertFalse("Should reject names shorter than 2 chars", InputValidator.isValidName("A"));
        assertFalse("Should reject empty strings", InputValidator.isValidName(""));
        assertFalse("Should reject whitespace-only values", InputValidator.isValidName("   "));
        assertFalse("Should reject numbers", InputValidator.isValidName("Anna123"));
        assertFalse("Should handle null gracefully", InputValidator.isValidName(null));
    }

    // --- Tests for Last Name ---

    @Test
    public void testIsValidLastName_Valid() {
        assertTrue("Should accept standard letters", InputValidator.isValidLastName("Tarn"));
        assertTrue("Should accept dashes and diacritics", InputValidator.isValidLastName("Vargas-Pérez"));
        assertTrue("Should accept spaces", InputValidator.isValidLastName("De la Cruz"));
    }

    @Test
    public void testIsValidLastName_Invalid() {
        assertFalse("Should reject names shorter than 2 chars", InputValidator.isValidLastName("T"));
        assertFalse("Should reject empty strings", InputValidator.isValidLastName(""));
        assertFalse("Should reject whitespace-only values", InputValidator.isValidLastName("   "));
        assertFalse("Should reject special characters like !", InputValidator.isValidLastName("Tarn!"));
        assertFalse("Should handle null gracefully", InputValidator.isValidLastName(null));
    }

    // --- Tests for Email ---

    @Test
    public void testIsValidEmail_Valid() {
        assertTrue("Should accept standard email", InputValidator.isValidEmail("name@example.com"));
        assertTrue("Should accept dots in local part", InputValidator.isValidEmail("anna.phyo@kzoo.edu"));
    }

    @Test
    public void testIsValidEmail_Invalid() {
        assertFalse("Should reject missing @ and domain", InputValidator.isValidEmail("plainaddress"));
        assertFalse("Should reject missing top-level domain (.com)", InputValidator.isValidEmail("name@domain"));
        assertFalse("Should reject missing local part", InputValidator.isValidEmail("@missinglocal.com"));
        assertFalse("Should reject empty string", InputValidator.isValidEmail(""));
        assertFalse("Should reject whitespace-only values", InputValidator.isValidEmail("   "));
        assertFalse("Should handle null gracefully", InputValidator.isValidEmail(null));
    }

    /**
     * Entry point so this test file can run directly from IDE "Run".
     * * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(InputValidatorTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful() ? "All tests passed." : "Some tests failed.");
    }

    
    // CREATE MORE TESTS HERE

    // --- MEDIUM TESTS ---
    @Test
    public void testMediumValid()
    {
        // Should return true for allowed media (dropdown menu options)
        assertTrue(InputValidator.isValidMedium("Oil Paint"));
        assertTrue(InputValidator.isValidMedium("Watercolor"));
    }

    @Test
    public void testMediumEmptyOrNull()
    {
        // Medium should not be empty or null
        assertFalse(InputValidator.isValidMedium(""));
        assertFalse(InputValidator.isValidMedium(null));
    }

    @Test
    public void testMediumInvalid()
    {
        // Should return false for unallowed random strings
        assertFalse(InputValidator.isValidMedium("Random String"));
    }


    // --- CREATION DATE TESTS ---
    @Test
    public void testCreationDateValid()
    {
        // Must follow the yyyy-MMdd- format
        assertTrue(InputValidator.isValidCreationDate("2026-0501-"));
    }

    @Test
    public void testCreationDateEmptyOrNull()
    {
        // Creation date should not be empty or null
        assertFalse(InputValidator.isValidCreationDate(""));
        assertFalse(InputValidator.isValidCreationDate(null));
    }

    @Test
    public void testCreationDateInvalidFormat()
    {
        // Should return false for wrong formats or invalid dates
        assertFalse(InputValidator.isValidCreationDate("2026/05/01"));
        assertFalse(InputValidator.isValidCreationDate("05-01-2026"));
        assertFalse(InputValidator.isValidCreationDate("2026-05-01"));
    }


    // --- PRICE TESTS ---
    @Test
    public void testPriceValid()
    {
        // Must follow the 0.00 format
        assertTrue(InputValidator.isValidPrice("15.50"));
        assertTrue(InputValidator.isValidPrice("0.00"));
        assertTrue(InputValidator.isValidPrice("1234.99"));
    }

    @Test
    public void testPriceEmpty()
    {
        // Price is allowed to be empty
        assertTrue(InputValidator.isValidPrice(""));
    }

    @Test
    public void testPriceInvalidFormat()
    {
        // Should return false for incorrect decimal places or invalid characters
        assertFalse(InputValidator.isValidPrice("15"));
        assertFalse(InputValidator.isValidPrice("15.5"));
        assertFalse(InputValidator.isValidPrice("Free"));
    }
    

}