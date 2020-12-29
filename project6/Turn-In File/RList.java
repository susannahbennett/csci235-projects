/**
 * RList.java
 *
 * Linked list, recursively.
 *
 * Note that in the recursive version, most of the work is done
 * in the node class.
 *
 * @author TVD/CGG and Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 6 
 * Date?
 */

public class RList implements List235 {

    /**
     * The first node in this list.
     */
    private RNode head;

    /**
     * Constructor.
     * POSTCONDITION: This list is empty.
     */
    public RList() {
	head = null;
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
	head = new RNode(item, head);
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
	int result = head.datum();
	deleteFront();
        return result;
    }

    /**
     * How many items are in this list?
     * @return The number of items in this list.
     */
    public int length() {
	if (head == null) {
	    return 0;
	}
	return head.length();
    }

    /**
     * Does the list contain an item?
     * @param item The value to look for.
     * @return Whether this list contains the item.
     */
    public boolean contains(int item) {
	if (head == null){
	    return false;
	} else {
	    return head.contains(item);
	}
    }

    /**
     * Get the value of the item at a specified position.
     * @param position The position in the list.
     * @return The value at position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public int elementAt(int position) {
	 if (head != null) return head.elementAt(position);
	 throw new RuntimeException("The list is empty");
    }

    /**
     * Insert a new item at after a specified position.
     * @param item The value to insert.
     * @param position The index after which the item will be inserted.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void insertAfter(int item, int position) {
	if (head == null){
	    insertAtFront(item);
	} else {
	    head.insertAfter(item, position);
	}
    }

    /**
     * Delete the item at a specified position.
     * @param position The position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void deleteAt(int position) {
	if (head != null) {
	    head = head.deleteAt(position);
	}
    }

    /**
     * Delete the first occurrence of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteFirstOccurrence(int item) {
	if (head != null) {
	    head = head.deleteFirstOccurrence(item);
	}
    }

    /**
     * Delete all occurrences of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteAll(int item) {
	if (head != null) {
	    head = head.deleteAll(item);
	}
    }

    // more methods specifically for sorting
    
    /**
     * Insert a new item at the right place in an (assumed sorted) list.
     * @param item The item to insert in the right place.
     */
    public void insertSorted(int item) {
	if (head == null) {
	    insertAtFront(item);
	} else {
	    head = head.insertSorted(item);
	}
    }

    /**
     * Insert an item at the back of this list.
     * @param item The item to add.
     */
    public void insertAtBack(int item) {
	if (head == null) {
	    insertAtFront(item);
	} else {
	    head.insertAtBack(item);
	}
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
     * PRECONDITION: the list is not empty
     */
    private int findSmallest() {
        int smallest = head.datum();
	RNode place = head.next();
	while (place != null) {
	    if (place.datum() < smallest) {
		smallest = place.datum();
	    } 
	    place = place.next();
	}
	return smallest;
	//throw new RuntimeException("method not written");
    }

    /**
     * Print the elements of this list to System.out.
     */
    public void printList() {
	System.out.print("[ ");
	if (head != null) {
	    head.print();
	}
	System.out.println(" ]");
    }

}
