package src;
/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Assert;
import org.junit.Test;
import java.io.File;


public class InputValidatorTest
{
    public static void main(String[] args)
    {

    }

    InputValidator validator = new InputValidator();

    // Test ensures input description is not empty and length<=1000
    @Test public void testDescriptionValidLength()
    {
        String desc = validator.getDescription();
        Assert.assertFalse(desc.isEmpty());
        Assert.assertTrue(desc.length() <= 1000);
    }

    // Test ensure input image is not null (exists in folder)
    @Test public void testImageNotNull()
    {
        File input_file = validator.getFile();
        Assert.assertTrue(input_file.exists());
    }

    // Test ensures file is not over 4MB large
    @Test public void testImageSize()
    {
        File input_file = validator.getFile();
        long byte_length = input_file.length();
        long megabyte_length = (byte_length/1024)/1024;
        Assert.assertTrue(byte_length > 0);
        Assert.assertTrue(megabyte_length <= 4);
    }

    // Test ensures image extension is .png or .jpg
    @Test public void testImageExtensionExtension()
    {
        String path = validator.getFile().getPath();
        boolean is_png = path.endsWith(".png");
        boolean is_jpg = path.endsWith(".jpg");
        Assert.assertTrue(is_png || is_jpg);
    }

    // Test ensures dimension array and dimension values are non-null
    @Test public void testDimensionsNotNull()
    {
        // Get array of values describing dimensions in format:
        // [long width, long height, String unit]
        Object[] dimensions = validator.getDimensions();

        // Ensure the array and each element is non-null
        Assert.assertNotNull(dimensions);
        Assert.assertNotNull(dimensions[0]);
        Assert.assertNotNull(dimensions[1]);
        Assert.assertNotNull(dimensions[2]);
    }

    // Test ensures dimension values are of correct type
    @Test public void testDimensionTypes()
    {
        // Get array of values describing dimensions in format:
        // [float width, float height, String unit]
        Object[] dimensions = validator.getDimensions();

        // Create variable names for easier reference
        // Get each value for easy reference
        Object width_obj = dimensions[0];
        Object height_obj = dimensions[1];
        Object unit_obj = dimensions[2];

        // Ensure each object is of correct type then create local variable
        Assert.assertTrue(width_obj instanceof Float);
        Assert.assertTrue(height_obj instanceof Float);
        Assert.assertTrue(unit_obj instanceof String);
    }

    // Test ensures dimension values are within requirements
    @Test public void testDimensionsValid()
    {
        // Get array of values describing dimensions in format:
        // [long width, long height, String unit]
        Object[] dimensions = validator.getDimensions();

        // Create variable names for easier reference
        // Get each value for easy reference, using dangerous type cast
        // testDimensionTypes() should fail if wrong type is given
        float width = (float) dimensions[0];
        float height = (float) dimensions[1];
        String unit_str = (String) dimensions[2];

        // Ensure width, height, and unit meet requirements.
        Assert.assertTrue(width > 0);
        Assert.assertTrue(height > 0);
        Assert.assertFalse(unit_str.isEmpty()); // Redundant as testDimensionsNotNull will catch this, included for completeness
    }
}