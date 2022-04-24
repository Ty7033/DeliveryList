package com.company;

/**
 * This exception class is thrown to check if the list is null.
 *
 *  @author  Tracy Yip
 */
public class EndOfListException extends Exception
{
    /**
     * Constructs an EndOfListException that passes
     * a string to its super class (Exception)
     */
    public EndOfListException()
    {
        super("You have reached the end of the DeliveryList and the function can't be performed. " +
            "Please try a different option.");
    }

    /**
     * Constructs an EndOfListException that passes
     * a specified string given in the parameter to its
     * super class (Exception)
     *
     * @param in
     *    A specified string of message that is desired to be printed
     */
    public EndOfListException(String in)
    {
        super(in);
    }
}

