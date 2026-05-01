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
}