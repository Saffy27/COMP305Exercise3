/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

import java.io.File;

public class InputValidator
{
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
}