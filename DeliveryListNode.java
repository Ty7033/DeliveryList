package com.company;

/**
 * This class creates a delivery list node stores the delivery information and creates the links to the
 * previous and next nodes in the list.
 *
 *  @author  Tracy Yip
 */
public class DeliveryListNode
{
    private Delivery data;//contains the Delivery object reference
    private DeliveryListNode next;//A link to the next node
    private DeliveryListNode prev;//A link to the previous node

    /**
     * This is a constructor that creates a DeliveryListNode that takes in and stores the Delivery object
     * reference passed in the parameter.
     *
     * @param intData
     *    A Delivery object reference passed in the parameter
     * @throws IllegalArgumentException
     *    Checks if there is data in the Delivery object
     */
    public DeliveryListNode(Delivery intData) throws IllegalArgumentException
    {
        if(intData==null)
        {
            throw new IllegalArgumentException("There is no data in the delivery object. Please try again.");
        }
        this.data=intData;
        next=null;
        prev=null;
    }

    /**
     * This method gets the data stored in the node.
     *
     * @return
     *    The Delivery object stored in the node
     */
    public Delivery getData()
    {
        return data;
    }

    /**
     * This method gets the reference of the next node.
     *
     * @return
     *    The reference of the next node
     */
    public DeliveryListNode getNext()
    {
        return next;
    }

    /**
     * This method gets the reference of the previous node.
     *
     * @return
     *    The reference of the previous node
     */
    public DeliveryListNode getPrev()
    {
        return prev;
    }

    /**
     * This method sets the data of the current node to the reference of the Delivery object passed in the parameter.
     */
    public void setData(Delivery data)
    {
        this.data = data;
    }

    /**
     * This method sets the reference of the next node to the reference passed in the parameter.
     */
    public void setNext(DeliveryListNode next)
    {
        this.next = next;
    }

    /**
     * This method sets the reference of the previous node to the reference passed in the parameter.
     */
    public void setPrev(DeliveryListNode prev)
    {
        this.prev = prev;
    }
}
