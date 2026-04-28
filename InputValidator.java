/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

public class InputValidator {
    
    public static void main(String[] args) { }
    
    /**
     * checks if username is not null, not empty, and under 20 chars
     */
    public static boolean isValidUsername(String username) {
        // check for null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }
        // check length limit
        return username.length() <= 20;
    }

    /**
     * checks for 8+ chars, upper, lower, digit, and special char
     */
    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        
        // gemini helped with this regex. only allows !, -, *, and . per tests
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\\-*.]).{8,}$";
        return password.matches(passwordPattern);
    }

    /**
     * checks for 10 digits, allows dashes/spaces, and can be empty
     */
    public static boolean isValidPhone(String phone) {
        // returning true if empty or null per project rules
        if (phone == null || phone.isEmpty()) {
            return true;
        }

        // strip everything except the numbers
        String digits = phone.replaceAll("[^0-9]", "");
        
        // must be exactly 10 digits to be valid
        return digits.length() == 10;
    }

}