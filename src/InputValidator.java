/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * InputValidator class provides static methods to validate user input fields.
 */
public class InputValidator {

    // Validate Date of Birth (must be 18+ and yyyy-MM-dd)
    public static boolean isValidDOB(String dob) {
        if (dob == null || dob.isEmpty()) return false;

        try {
            LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (birthDate.isAfter(LocalDate.now())) return false;

            return Period.between(birthDate, LocalDate.now()).getYears() >= 18;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Postal Code: 5 digits or empty allowed
    public static boolean isValidPostalCode(String code) {
        if (code == null) return false;
        if (code.isEmpty()) return true;

        return code.matches("\\d{5}");
    }

    // Title: not empty, max 100 chars
    public static boolean isValidTitle(String title) {
        if (title == null || title.isEmpty()) return false;

        return title.length() <= 100;
    }
}