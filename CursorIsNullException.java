package com.company;

/**
 * This exception class is thrown to check if the cursor is null.
 *
 *  @author  Tracy Yip
 */
public class CursorIsNullException extends Exception
{
    /**
     * Constructs an CursorIsNull that passes
     * a string to its super class (Exception)
     */
    public CursorIsNullException()
    {
        super("Cursor is not set to a node yet. Please try a different option.");
    }

    /**
     * Constructs an CursorIsNull that passes
     * a specified string given in the parameter to its
     * super class (Exception)
     *
     * @param in
     *    A specified string of message that is desired to be printed
     */
    public CursorIsNullException(String in)
    {
        super(in);
    }
}