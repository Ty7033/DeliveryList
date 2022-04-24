package com.company;

/**
 * This class creates a doubly-linked list called DeliveryList that
 * stores the order information. It includes different methods to
 * manipulate properties(head, tail, & cursor) and deliveries on the list.
 *
 * @author  Tracy Yip
 */
public class DeliveryList
{
    private DeliveryListNode head;//The head node of the list
    private DeliveryListNode tail;//The tail node of the list
    private DeliveryListNode cursor;//The cursor of the list
    private int count=0;//The number of orders in the list

    /**
     * This is a constructor that creates a DeliveryList and initiates the head, tail, and cursor to null.
     */
    public DeliveryList()
    {
        head=null;
        tail=null;
        cursor=null;
    }

    /**
     * This method gives the user the number of orders in the list.
     *
     * @return
     *    The number of orders that needs to be delivered.
     */
    public int numDeliveries()
    {
        return count;
    }

    /**
     * This method is used to get the order information at the cursor.
     *
     * @return
     *    The data of the node the cursor is at
     */
    public Delivery getCursor()
    {
        if(cursor==null)
        {
            return null;
        }
        return cursor.getData();
    }

    /**
     * This method moves the cursor back to the head node.
     */
    public void resetCursorToHead()
    {
        if(head==null)
        {
            cursor=null;
            System.out.println("Cursor is at head, which is currently null.");
        }
        else
        {
            cursor=head;
            System.out.println("Cursor is at head.");
        }
    }

    /**
     * This method sets the cursor to the tail node.
     */
    public void setCursorToTail()
    {
        if(tail==null)
        {
            cursor=null;
            System.out.println("Cursor is at tail, which is currently null.");
        }
        else
        {
            cursor=tail;
            System.out.println("Cursor is at tail.");
        }
    }

    /**
     * This method advances the cursor in the list.
     *
     * @throws EndOfListException
     *    When the user tries to move the cursor which has already reached the end of the list.
     */
    public void cursorForward() throws EndOfListException, CursorIsNullException
    {
        if(cursor==null)
        {
            throw new CursorIsNullException();
        }
        if(cursor==tail)
        {
            throw new EndOfListException("This action cannot be performed because the cursor is " +
                "currently at last delivery of the list. Please try another option");
        }
        cursor=cursor.getNext();
    }

    /**
     * This method moves the cursor back one node.
     *
     * @throws EndOfListException
     *    When the current node is at the head of the list and there is no deliveries before it.
     */
    public void cursorBackward() throws EndOfListException, CursorIsNullException
    {
        if(cursor==null)
        {
            throw new CursorIsNullException("There cursor is currently null. Please assign it to a node first.");
        }
        if(cursor==head)
        {
            throw new EndOfListException("This action cannot be performed because the cursor is" +
                " currently at first delivery of the list. Please try another option");
        }
        cursor=cursor.getPrev();
    }

    /**
     * This method adds a new Delivery object after the cursor. When the cursor is null,
     * the new DeliveryListNode is set as the head and tail of the list.
     * The cursor remains unchanged after the method is called.
     *
     * @param newDelivery
     *    A new delivery object to be inserted
     * @throws IllegalArgumentException
     *    When the delivery object passed in the parameter is null
     */
    public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException
    {
        if(newDelivery==null|| newDelivery.getDest().equals("")||newDelivery.getSource().equals(""))
        {
            throw new IllegalArgumentException("The delivery can't be processed because it is missing some info." +
                " Please try again.");
        }
        DeliveryListNode newNode=new DeliveryListNode(newDelivery);
        if(cursor==null)
        {
            head=newNode;
            tail=newNode;
            cursor=newNode;
        }
        else
        {
            newNode.setPrev(cursor);
            newNode.setNext(cursor.getNext());
            if(cursor.getNext()==null)
            {
                tail=newNode;
            }
            else
            {
                cursor.getNext().setPrev(newNode);
            }
            cursor.setNext(newNode);
        }
        count++;
    }

    /**
     * This method inserts a new Delivery object after the tail of the list.
     * The tail is set to the node that holds the new object.The new node is
     * set as the tail and cursor of the list if the tail was previously null.
     *
     * @param newDelivery
     *    A new Delivery object to be added at the end of the list
     * @throws IllegalArgumentException
     *    When the new Delivery object is null
     */
    public void appendToTail(Delivery newDelivery) throws IllegalArgumentException
    {
        if(newDelivery==null)
        {
            throw new IllegalArgumentException("There is no information in the order. Please try adding another order.");
        }
        DeliveryListNode newNode=new DeliveryListNode(newDelivery);
        if(head==null && tail==null)
        {
            head=newNode;
            tail=newNode;
            cursor=newNode;
        }
        else
        {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail=newNode;
        }
        count++;
    }

    /**
     * This method removes the node the cursor is currently at and advances the cursor to the next node.
     *
     * @return
     *    The data stored in the node that was removed.
     * @throws EndOfListException
     *    When the cursor is null
     */
    public Delivery removeCursor()throws EndOfListException
    {
        if(cursor==null)
        {
            throw new EndOfListException("There is no cursor in the list yet. Please try another option.");
        }
        Delivery cursorData=cursor.getData();
        if(head==tail)
        {
            head=null;
            tail=null;
            cursor=null;
        }
        else if(cursor==head)
        {
            head=head.getNext();
            head.setPrev(null);
            cursor=head;
        }
        else if (cursor==tail)
        {
            tail=cursor.getPrev();
            tail.setNext(null);
            cursor=tail;
        }
        else
        {
            DeliveryListNode newCursor=cursor.getNext();
            DeliveryListNode beforeCursor=cursor.getPrev();
            newCursor.setPrev(beforeCursor);
            beforeCursor.setNext(newCursor);
            cursor=newCursor;
            if(cursor.getNext()==null)
            {
                tail=cursor;
            }
        }
        count--;
        return cursorData;
    }

    /**
     * This method organizes the delivery list into a table like structure that holds
     * information of the different orders needed to be delivered.
     *
     * @return
     *    A string containing the list of deliveries
     */
    public String toString()
    {
        String output="";
        if(!emptyListCheck())
        {
            DeliveryListNode temp= head;
            if(cursor==head)
            {
                output+="->\n"+head.getData()+"\n";
            }
            else
            {
                output+= temp.getData()+"\n";
            }
            temp=temp.getNext();
            for(int x=1; x<count; x++)
            {
                if(temp==cursor)
                {
                    output+="->\n"+temp.getData()+"\n";
                }
                else
                {
                    output+="~\n"+temp.getData()+"\n";
                }
                temp=temp.getNext();
            }
        }
        else
        {
            return "The list is currently empty. \nPlease try adding some orders before printing it.\n";
        }
        return output;
    }

    /**
     * This method checks if the list is empty.
     *
     * @return
     *      A boolean that indicates whether count=0
     */
    public boolean emptyListCheck()
    {
        if(count==0)
        {
            return true;
        }
        return false;
    }
}
