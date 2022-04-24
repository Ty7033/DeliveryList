package com.company;

/**
 * This class creates a delivery object that keeps track of an order with a source, destination, and instructions.
 *
 *  @author  Tracy Yip 
 */
public class Delivery {
    private String source;//A string that holds the source of the order
    private String dest;//A string that holds the destination of the order
    private String instruction;//A string that holds the instructions of the order

    /**
     * This is a constructor that creates a Delivery object and sets the source, dest, and instruction to empty strings.
     */
    public Delivery()
    {
        source="";
        dest="";
        instruction="";
    }

    /**
     * This is a constructor used to create a Delivery object.
     *
     * @param source
     *    The source of the order
     * @param dest
     *    The destination of the order
     * @param instruction
     *    The special instructions provided by the customer
     */
    public Delivery(String source, String dest, String instruction)
    {
        this.source=source;
        this.dest=dest;
        this.instruction=instruction;
    }

    /**
     * This is a getter method in the Delivery class.
     *
     * @return
     *    The source of the order
     */
    public String getSource()
    {
        return source;
    }

    /**
     * This is a getter method in the Delivery class.
     *
     * @return
     *    The destination of the order
     */
    public String getDest()
    {
        return dest;
    }

    /**
     * This is a getter method in the Delivery class.
     *
     * @return
     *    The instructions of the order
     */
    public String getInstruction()
    {
        return instruction;
    }

    /**
     * This method sets the source of the delivery object to the String in its parameter.
     *
     * @param source
     *    The source of the delivery
     */
    public void setSource(String source)
    {
        this.source = source;
    }

    /**
     * This method sets the destination of the delivery object to the String in its parameter.
     *
     * @param dest
     *    The destination of the delivery
     */
    public void setDest(String dest)
    {
        this.dest = dest;
    }
    /**
     * This method sets the instruction of the delivery object to the String in its parameter.
     *
     * @param instruction
     *    The instructions of the delivery
     */
    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    /**
     * This toString method organizes the delivery's source, destination, and instruction
     * that are neatly spaced out.
     *
     * @return
     *    A string that contains the information on the delivery neatly spaced out in the
     *    order of destination, source, and instruction.
     */
    public String toString()
    {
        return "To: " + dest + " | From: "+ source+ "\n"+ "Instruction: " + instruction;
    }
}
