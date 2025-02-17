/**
 * IList.java
 *
 * A first stab at a linked list (iterative version)
 *
 * @author Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 4
 * 11.26.19
 */

public class IList implements List235{

    /**
     * The first INode in this list.
     */
    private INode head;

    /**
     * Constructor.
     * POSTCONDITION: This list is empty.
     */
    public IList() {
	head = null;
    }

    /**
     * Alternative to constructor: create a list for use by sorting methods.
     * To simplify the insertion methods used for sorting, this starts
     * out the list with an extra zero item on the front.
     * After fixing the insertions to work on an empty list,
     * change this method  to start with an empty list.
     */
    public static IList newSortList() {
	IList theList = new IList();
	theList.insertAtFront(0);
	return theList;
    }

    /**
     * Is this list empty?
     * @return Whether this list is empty.
     */
    public boolean isEmpty() {
	return head == null;
    }

    /**
     * Insert an item at the front of this list.
     * @param item The item to add.
     */
    public void insertAtFront(int item) {
	head = new INode(item, head);
    }

    /**
     * Delete the front item from this list.
     * PRECONDITION: This list is not empty.
     */
    public void deleteFront() {
	head = head.next();
    }

    /**
     * Delete and return the front item from this list.
     * @return The item that was deleted.
     * PRECONDITION: This list is not empty.
     */
    public int removeFront() {
	int temp = head.datum();
	head = head.next();
	return temp;
    }

    /**
     * Print the elements of this list to System.out.
     */
    public void printList() {
	System.out.print("[ ");
	INode place = head; // position within this list
	while (place != null) {
	    System.out.print(place.datum()+" ");
	    place = place.next();
	}
	System.out.println("]");
    }
    /**
     * How many items are in this list?
     * @return The number of items in this list.
     */
    public int length() {
	INode place = head;
	int i = 0;
	while (place != null) {
            i++;
            place = place.next();
	}
	return i;
    }
 
    /**
     * What is the sum of items in the list?
     * @return The sum of all items in this list.
     */
    public int sum() {
	INode place = head;
	int sum = 0;
	while (place != null) {
	    sum += place.datum();
	    place = place.next();
	}
	
	return sum;
    }

    /**
     * Does the list contain an item?
     * @param item The value to look for.
     * @return Whether this list contains the item.
     */
    public boolean contains(int item) {
	INode place = head;
    while (place != null){
        if (place.datum() == item){
            return true;
        }
        place = place.next();
    }
    return false;
    }

    /**
     * Get the value of the item at a specified position.
     * @param position The position in the list.
     * @return The value at position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public int elementAt(int position) {
	//but this form can be adapted to other uses.
	INode place = head;  // the node we are looking at
	int i = 0;           // the position of place
	while (place != null) {
	    if (i == position) { // is place the node we want?
		break;
	    }
	    // do something before going to the next node
	    place = place.next();
	    i++;
	}
    return place.datum();
	// ran off the end
	// throw new RuntimeException("precondition violated");
    }

    /**
     * Insert a new item at after a specified position.
     * @param item The value to insert.
     * @param position The index after which the item will be inserted.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void insertAfter(int item, int position) {
	INode place = head;
	int i = 0;  
	while (place != null) {
	    if (i == position){
    		INode insertedNew = new INode (item, place.next());
    		place.setNext(insertedNew);
	    }
	    place = place.next();
	    i++;
	}
    }

    /**
     * Delete the item at a specified position.
     * @param position The position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void deleteAt(int position) {
	INode place = head;    
	int i = 0;             
	INode previous = null; 
	while (place != null) {
	    if (position == 0) {
		this.deleteFront();
		return;
	    }
	    if (i == position) {
		previous.setNext(place.next());
		return;
	    }
	    previous = place;
	    place = place.next();
	    i += 1;
	}
	
    }

    /**
     * Delete the first occurrence of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteFirstOccurrence(int item) {
        INode place = head;
        INode previous = null;
        if (place.datum() == item) {
            head = place.next();
            return;
        }
        while (place != null){
            if (place.datum() == item) {
                previous.setNext(place.next());
                return;
            }
            previous = place;
            place = place.next();
        }
    }

    /**
     * Delete all occurrences of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteAll(int item) {
	if (isEmpty()){
	    return;
	}
	while (this.contains(item)){
	    this.deleteFirstOccurrence(item);
	}
    }
    /**
     * Make a new list that is the reverse of this one.
     * @return the reversed new list
     */
    public IList makeReverse() {
        IList reverseList = new IList ();
        INode place = head;

        while (place != null){
            reverseList.insertAtFront(place.datum());
            place = place.next();
        }
        return reverseList;
    }

    /**
     * Reverse this list (without making a new list).
     * (Ideally, do it without making any new nodes.)
     */
    public void reverse() {
        int i = 0;
        while (i < length()){
            insertAtFront(head.datum());
            head = head.next();
            i++;
        }
    }


    /**
     * Insert a new item at the right place in an (assumed sorted) list.
     * @param item The item to insert in the right place.
     */
    public void insertSorted(int item) {
        INode place = head;
	if (item < place.datum() || place == null) {
	    insertAtFront(item);
	    return;
	}
        while (place.next() != null) {
            if (item < place.next().datum()) {
                INode here = new INode(item, place.next());
                place.setNext(here);
                return;
            }
            place = place.next();
        }
        INode here = new INode (item, null);
        place.setNext(here);
    }

    /**
     * Insert an item at the back of the list.
     * @param item The item to to add
     */
    public void insertAtBack(int item) {
        INode place = head;
        while (place.next() != null) {
            place = place.next();
        }
        INode last = new INode(item, null);
        place.setNext(last);
    }

    /**
     * Remove and return the smallest element of the list.
     * First find the smallest, then delete it, then return it.
     * @return The (now removed) smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    public int removeSmallest() {
        int smallest = findSmallest();
        deleteFirstOccurrence(smallest);
        return smallest;
    }

    /**
     * Return the value of the smallest element of the list.
     * @return The smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    private int findSmallest() {
        // find the smallest element value
	//throw new RuntimeException("method not written");
        INode place = head;
        int minimum = place.datum();
        while (place.next() != null){
            if (place.next().datum() < minimum) {
		minimum = place.next().datum();
            }  
            place = place.next();
        }
        System.out.println(minimum);
        return minimum;
    }

    public static void main(String[] args) {
	// whatever we need to test the class
	IList x = new IList();
	System.out.println("isEmpty()? "+x.isEmpty());
	System.out.print("Initial: ");
	x.printList();
	System.out.println("insertAtFront(15)");
	x.insertAtFront(15);
	x.printList();
	System.out.println("insertAtFront(12)");
	x.insertAtFront(12); 
	System.out.println("insertAtFront(4)");
	x.insertAtFront(4);
	x.printList();
    System.out.println("insertSorted(5)");
    x.insertSorted(5);
    x.printList();
	System.out.println("deleteAt(2)");
	x.deleteAt(2);  
	x.printList();
    System.out.println("insertSorted(10)");
    x.insertSorted(10);
    x.printList();
    System.out.println("x.makeReverse()");
    IList y = x.makeReverse();
    y.printList();
    System.out.println("x.reverse()");
    x.reverse();
    x.printList();
	System.out.println("isEmpty()? "+x.isEmpty());
	System.out.println("length() "+x.length());
	System.out.println("deleteFront()");
	x.deleteFront();
    x.printList();
	System.out.println("deleteFront()");
	x.deleteFront();
	x.printList();
	System.out.println("insertAtFront(15)");
	x.insertAtFront(15);
	System.out.println("insertAtFront(7)");
	x.insertAtFront(7);
	System.out.println("removeFront() "+x.removeFront());
	x.printList();
    System.out.println("removeSmallest()"+x.findSmallest());
    x.removeSmallest();
    x.printList();
    System.out.println("deleteFirstOccurrence(15)");
    x.deleteFirstOccurrence(15);
    x.printList();
    System.out.println("insertAtBack(20)");
    x.insertAtBack(20);
    x.printList();
	System.out.println("insertAfter(10, 1)");
	x.insertAfter(10, 1);
	x.printList();
	System.out.println("insertAfter(10, 1)");
	x.insertAfter(10, 1);
	x.printList();
	System.out.println("deleteAll(10)");
	x.deleteAll(10);
	x.printList();
    System.out.println("contains(20)");
    x.contains(20);
    System.out.println("contains(6)");
    x.contains(6);
    }
}

