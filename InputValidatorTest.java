/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
    
    /*
     * Example test method for a possible Name field validator method in your 
     * InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */
    @Test
    public void testNameFieldIsNotEmpty() {
        // assertTrue(InputValidator.validateNameField("..."));
        // assertFalse (InputValidator.validateNameField("..."));
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