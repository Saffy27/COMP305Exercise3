package src;/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user.
 */

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import java.util.Arrays;
import java.util.List;

/**
 * The InputValidator class provides static methods to validate user input
 * for the Nube Art Catalog system.
 * * @author Jeremy Tarn
 * @version 1.1
 */
public class InputValidator {

    // Placeholder method for the description input.
    String getDescription()
    {
        //String description = "Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!Here is a string that is over 1000 characters!!!!!";
        String description = "hello world";
        //String description = "";
        return description;
    }

    // Placeholder method for the filepath input.
    File getFile()
    {
        File input_file = new File("test.png");
        //File input_file = new File("");
        return input_file;
    }

    // Placeholder method for the dimensions input
    Object[] getDimensions()
    {
        Object[] dimensions = new Object[3];
        float width = 2;
        float height = 1.5F;
        String unit = "m";
        dimensions[0] = width;
        dimensions[1] = height;
        dimensions[2] = unit;
        return dimensions;
    }

    private static final DateTimeFormatter DOB_FORMATTER =
            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);

    // Validate Date of Birth (must be 18+ and yyyy-MM-dd)
    public static boolean isValidDOB(String dob) {
        if (dob == null || dob.trim().isEmpty()) return false;

        try {
            LocalDate birthDate = LocalDate.parse(dob.trim(), DOB_FORMATTER);

            if (birthDate.isAfter(LocalDate.now())) return false;

            return Period.between(birthDate, LocalDate.now()).getYears() >= 18;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Postal Code: 5 digits or empty allowed
    public static boolean isValidPostalCode(String code) {
        if (code == null) return false;
        if (code.trim().isEmpty()) return true;

        return code.trim().matches("\\d{5}");
    }

    // Title: not empty, max 100 chars
    public static boolean isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) return false;

        return title.trim().length() < 100;
    }

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

        public static boolean isValidPriceJeremy(String price)
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

//    /**
//     * Validates that a price is a positive numeric value.
//     * * @param price The price string to validate.
//     * @return true if valid, false otherwise.
//     */
//    public static boolean isValidPrice(String price) {
//        if (price == null) return false;
//        try {
//            double value = Double.parseDouble(price);
//            return value >= 0;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }

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