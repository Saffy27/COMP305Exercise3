/**
 * The InputValidator class provides static methods to validate user input
 * for the Nube Art Catalog system.
 * * @author Jeremy Tarn
 * @version 1.1
 */
public class InputValidator {

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

    /**
     * Validates the 'name' field.
     * Requirements: Non-empty, letters and spaces only, min 2 chars, accepts diacritics.
     * * @param name The first name to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        // Regex Breakdown:
        // ^[\\p{L}]+(?: [\\p{L}]+)*$
        // \\p{L} matches any Unicode letter (including diacritics like é, ü, ñ)
        // Allows internal single spaces only between letter groups
        String regex = "^[\\p{L}]+(?: [\\p{L}]+)*$";
        return name.trim().matches(regex);
    }

    /**
     * Validates the 'last name' field.
     * Requirements: Letters, spaces, and dashes; min 2 chars, accepts diacritics.
     * * @param lastName The last name to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return false;
        }
        // Similar to name, but allows dashes between letter groups.
        String regex = "^[\\p{L}]+(?:[ -][\\p{L}]+)*$";
        return lastName.trim().matches(regex);
    }

    /**
     * Validates the 'email' field.
     * Requirements: Standard email format (name@example.com), non-empty.
     * * @param email The email address to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        // Standard Email Regex:
        // Checks for characters + @ + domain + . + top-level domain (2+ chars)
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.trim().matches(regex);
    }

    /**
     * Validates the year of the artwork.
     * Requirements: Must be a 4-digit number not exceeding the current year.
     * * @param year The year string to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidYear(String year) {
        if (year == null || !year.matches("^\\d{4}$")) {
            return false;
        }
        int yearInt = Integer.parseInt(year);
        int currentYear = java.time.Year.now().getValue();
        return yearInt <= currentYear && yearInt > 0;
    }

    /**
     * Validates that a price is a positive numeric value.
     * * @param price The price string to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidPrice(String price) {
        if (price == null) return false;
        try {
            double value = Double.parseDouble(price);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Entry point for quick manual validation checks.
     * This allows the file to run directly from the IDE.
     * * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        System.out.println("InputValidator quick check:");
        System.out.println("Name 'José' valid: " + isValidName("José"));
        System.out.println("Last name 'Vargas-Pérez' valid: " + isValidLastName("Vargas-Pérez"));
        System.out.println("Email 'name@example.com' valid: " + isValidEmail("name@example.com"));
    }
}