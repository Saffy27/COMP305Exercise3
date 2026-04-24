/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest
{
    public static void main(String[] args)
    {
        InputValidatorTest test = new InputValidatorTest();
        test.testDescriptionFieldIsNotEmpty();
    }
    
    /*
     * Example test method for a possible Description field validator method in your
     * InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */
    @Test
    public void testDescriptionFieldIsNotEmpty()
    {
        //TODO: Change this description to get the user input from InputValidator
        String description = "";
        Assert.assertFalse(description.isEmpty());

    }
    
    // CREATE MORE TESTS HERE
    
}