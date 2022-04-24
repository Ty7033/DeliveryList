package com.company;
import java.util.Scanner;

/**
 * This class sets up the delivery list for each driver. It lets the user manipulate the
 * list of orders to be delivered.
 *
 *  @author  Tracy Yip
 */
public class DeliveryDriver
{
    private static DeliveryList list1;// The delivery list of Biz Billy
    private static DeliveryList list2;//The delivery list of Money Mike
    private static DeliveryList currentList;//The current delivery list
    private static Delivery temp;// A Delivery object that holds data of the removed cursor of the Cut Cursor function

    /**
     * This is the main method of the class where the user can interact with the program.
     * Based on selected option,the program will perform the corresponding action listed
     * in the menu. The functions update the delivery list corresponding to each driver.
     */
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        list1=new DeliveryList();
        list2=new DeliveryList();
        currentList=list1;
        System.out.println("Welcome to the Delinquent Dollar Delivery Scheduler.");
        optionM();
        System.out.println("Please select an option: ");
        String x=scan.nextLine();
        if(!check(x))
        {
            System.out.println("Option does not exist. Try Again. Please enter an option:");
            x = scan.nextLine();
        }
        while(!x.equals("Q") && !x.equals("q"))
        {
            // Adds a new Delivery object after cursor
            if(x.equals("A") || x.equals("a"))
            {
                optionA(scan);
            }

            //Sets the cursor to head
            else if (x.equals("H") || x.equals("h"))
            {
                optionH();
            }

            //Sets the cursor to tail
            else if (x.equals("T") || x.equals("t"))
            {
                optionT();
            }

            //Advances the cursor to the next node
            else if (x.equals("F") || x.equals("f"))
            {
                optionF();
            }

            //Moves the cursor back one node
            else if (x.equals("B") || x.equals("b"))
            {
                optionB();
            }

            //Removes the Delivery object at the cursor
            else if (x.equals("R") || x.equals("r"))
            {
                optionR();
            }

            //Cuts the cursor
            else if (x.equals("X") || x.equals("x"))
            {
                optionX();
            }

            // Paste after the cursor
            else if (x.equals("V") || x.equals("v"))
            {
                optionV();
            }

            // Switch Delivery Route
            else if (x.equals("S") || x.equals("s"))
            {
                optionS();
            }

            //Print the current delivery route
            else if (x.equals("P") || x.equals("p"))
            {
                optionP();
            }

            // Prints out the menu
            else if(x.equals("M") || x.equals("m"))
            {
                optionM();
            }

            // Asks the user to enter another option
            System.out.println("Please select an option:");
            x = scan.nextLine();
            if(!check(x))
            {
                System.out.println("Option does not exist. Try Again. Please enter an option:");
                x = scan.nextLine();
            }
        }
        System.out.println("Next time, try UPS!");//If the user decides to quit the program
        System.exit(0);
    }

    /**
     * This method creates a new Delivery object with the source, destination, and
     * instruction entered by user.The object is wrapped into a DeliveryListNode
     * and is added after cursor.
     *
     * @param scan
     *    A scanner that takes in the user inputs
     */
    public static void optionA(Scanner scan)
    {
        try
        {
            System.out.println("Enter a source:");
            String source=scan.nextLine();
            System.out.println("Enter a destination: ");
            String dest=scan.nextLine();
            System.out.println("Please enter any special instructions:");
            String instruction=scan.nextLine();
            Delivery newOrder= new Delivery(source, dest, instruction);
            if(instruction.equals(""))
            {
                newOrder.setInstruction("None");
            }
            currentList.insertAfterCursor(newOrder);
            System.out.println("Order inserted.");
        }
        catch(IllegalArgumentException a)
        {
            System.out.println(a.getMessage());
            optionA(scan);
        }
    }

    /**
     * This method is called on when the user wants to remove the DeliveryListNode referenced by cursor.
     *
     */
    public static void optionR()
    {
        try
        {
            System.out.println("Delivery to " + currentList.removeCursor().getDest()+ " removed.");
        }
        catch(EndOfListException q)
        {
            System.out.println(q.getMessage());
        }
    }

    /**
     * This method first stores the Delivery object at the cursor into a temp node. It then removes the
     * DeliveryListNode referenced by cursor.
     */
    public static void optionX()
    {
        try
        {
            temp= currentList.removeCursor();
            System.out.println("Cursor is cut.");
        }
        catch (EndOfListException w)
        {
            System.out.println(w.getMessage());
        }
    }

    /**
     * This method is called on when the user wants to paste the Delivery object saved in the temp
     * variable after the cursor.
     */
    public static void optionV()
    {
        try
        {
            if (temp == null)
            {
                System.out.println("There is nothing to paste. You would need to call on the cut method first.");
            }
            else
            {
                currentList.insertAfterCursor(temp);
            }
        }
        catch (IllegalArgumentException r)
        {
            System.out.println(r.getMessage());
        }
    }

    /**
     * This method is called on when the user wants to move the cursor back to the head.
     */
    public static void optionH()
    {
        currentList.resetCursorToHead();
    }

    /**
     * This method is called on when the user wants to move the cursor to the tail.
     */
    public static void optionT()
    {
        currentList.setCursorToTail();
    }

    /**
     * This method is called on when the user wants to move the cursor to the next node.
     */
    public static void optionF()
    {
        try
        {
            currentList.cursorForward();
            System.out.println("Cursor moved forward.");
        }
        catch(EndOfListException|CursorIsNullException t)
        {
            System.out.println(t.getMessage());
        }
    }

    /**
     * This method is called on when the user wants to move the cursor back one node.
     */
    public static void optionB()
    {
        try
        {
            currentList.cursorBackward();
            System.out.println("Cursor moved backward.");
        }
        catch(EndOfListException|CursorIsNullException t)
        {
            System.out.println(t.getMessage());
        }

    }

    /**
     * This method is called on when the user wants to look at a different list.
     */
    public static void optionS()
    {
        if(currentList==list1)
        {
            currentList=list2;
            System.out.println("Money Mike's list is selected.");
        }
        else
        {
            currentList=list1;
            System.out.println("Biz Billy's list is selected.");
        }
    }

    /**
     * This method is called on when the user wants to print the current DeliveryList.
     */
    public static void optionP()
    {
        if(currentList==list1)
        {
            System.out.println("Biz Billy's Deliveries:");
            System.out.println("--------------------------------------------------");
            System.out.print(list1.toString());
            System.out.println("--------------------------------------------------");
        }
        else
        {
            System.out.println("Money Mike's Deliveries:");
            System.out.println("--------------------------------------------------");
            System.out.print(list2.toString());
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * This method prints the menu of functions the user can perform of the linked list of Deliveries.
     */
    public static void optionM()
    {
        System.out.println("Menu:\n A) Add a Delivery After Cursor\n R) Remove Delivery At Cursor\n X) Cut Cursor\n"
            +" V) Paste After Cursor\n H) Cursor to Head\n T) Cursor to Tail\n F) Cursor Forward\n B) Cursor Backward\n "
            + "S) Switch Delivery Lists\n P) Print current list\n M) Menu\n Q) Quit");
    }

    /**
     * This method checks if the letter of the option entered by the user is in the menu.
     * The letters are not case-sensitive.
     *
     * @param in
     *    The string entered by the user when choosing an option on the menu
     * @return
     *    A boolean that indicates whether the string entered by the user is a valid option on the menu
     */
    public static boolean check(String in)
    {
        String [] options={"A","a","R","r","X","x","V","v","H","h","T","t","F","f","B","b","S","s","P","p",
            "M","m","Q","q"};
        boolean check=false;
        for(int i=0; i< options.length; i++)
        {
            if(options[i].equals(in))
            {
                check=true;
                break;
            }
        }
        return check;
    }
}
