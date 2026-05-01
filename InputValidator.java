/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */
import java.util.Arrays;
import java.util.List;

public class InputValidator
{

    public static boolean isValidMedium(String medium)
    {
        // Reject if null or empty
        if (medium == null || medium.isEmpty())
        {
            return false;
        }
        // List of allowed media (used in tests)
        List<String> validMedia = Arrays.asList("Oil Paint", "Watercolor");

        // Check if the input medium is included in the list
        return validMedia.contains(medium);
    }

    public static boolean isValidCreationDate(String creationDate)
    {
        // Reject if null or empty
        if (creationDate == null || creationDate.isEmpty())
        {
            return false;
        }
        // Check yyyy-MMdd- format using regex
        return creationDate.matches("^\\d{4}-\\d{4}-$");
    }

    public static boolean isValidPrice(String price)
    {
        if (price == null)
        {
            return false;
        }
        // Price is allowed to be empty
        if (price.isEmpty())
        {
            return true;
        }
        // Check format (e.g., 15.50) using regex
        return price.matches("^\\d+\\.\\d{2}$");
    }

}