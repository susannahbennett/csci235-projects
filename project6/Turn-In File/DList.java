/**
 * DList.java
 *
 * A doubly-linked list.
 *
 * @author TVD/CGG/HK and Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 6
 * 11.26.19
 */

public class DList implements List235 {

    /**
     * The first node in this list.
     */
    private DLNode head;

    /**
     * Constructor.
     * POSTCONDITION: This list is empty.
     */
    public DList() {
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
    	// set the link going forward (next)
    	DLNode n = new DLNode(item);
    	n.spliceAsHead(head);
    	head = n;
    }

    /**
     * Delete the front item from this list.
     * PRECONDITION: This list is not empty.
     */
    public void deleteFront() {
	 head = head.spliceOut();
    }

    /**
     * Delete and return the front item from this list.
     * @return The item that was deleted.
     * PRECONDITION: This list is not empty.
     */
    public int removeFront() { 
    	DLNode oldHead = head;
    	head = head.spliceOut();
    	return oldHead.datum();
    }

    // Note that most of these can be the same as for singly-linked
    /**
     * How many items are in this list?
     * @return The number of items in this list.
     */
    public int length() {
    	DLNode place = head;
        int i = 0;
        while (place != null) {
                i++;
                place = place.next();
        }
        return i;
    }

    /**
     * Does the list contain an item?
     * @param item The value to look for.
     * @return Whether this list contains the item.
     */
    public boolean contains(int item) {
    	DLNode place = head;
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
    	DLNode place = head;  
        int i = 0;          
        while (place != null) {
            if (i == position) { 
            break;
            }
            place = place.next();
            i++;
        }
        return place.datum();
    }
    /**
     * Insert a new item at after a specified position.
     * @param item The value to insert.
     * @param position The index after which the item will be inserted.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void insertAfter(int item, int position) {
    	DLNode place = head;
        DLNode previous = null;
        int i = 0;  
        while (place != null) {
            if (i == position){
                DLNode insertedNew = new DLNode (item);
                insertedNew.spliceAfter(place);
                return;
            }
            previous = place;
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
    	DLNode place = head;    
	int i = 0;
	DLNode previous = null;
        while (place != null) {
            if (position == 0) {
		deleteFront();
		return;
            }
	    if (i == position) {
		place.spliceOut();
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
	DLNode place = head;
        int position = 0;
        while (place != null){
            if (place.datum() == item) {
                place.spliceOut();
                break;
            }
            position++;
            place = place.next();
        }
    }

    /**
     * Delete all occurrences of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteAll(int item) {
    	while (this.contains(item)) {
	    this.deleteFirstOccurrence(item);
	}
    }

    /**
     * Insert a new item at the right place in an (assumed sorted) list.
     * @param item The item to insert in the right place.
     */
    public void insertSorted(int item) {
        DLNode place = head;
        if(item < place.datum() || place == null) {
	    insertAtFront(item);
	    return;
	} 
	while (place.next() != null) {
	    if (item < place.next().datum()) {
		DLNode here = new DLNode (item);
		here.spliceAfter(place);
                return;
            }
	    place = place.next();
        }
        DLNode here = new DLNode (item);
        here.spliceAfter(place);
    }

    /**
     * Find the last node in this (non-empty) list.
     * @return The last node in this list.
     * PRECONDITION: this is not empty
     */
    private DLNode findLast() {
	   DLNode place = head;
       while (place.next() != null) {
        place = place.next();
       }
       return place;
    }
    
    /**
     * Insert an item at the back of this list.
     * @param item The item to add.
     */
    public void insertAtBack(int item) {
	if (head == null) {
	    insertAtFront(item);
	} else {
	    DLNode last = findLast();
	    DLNode n = new DLNode(item);
	    n.spliceAfter(last);
	}
    }

    /**
     * Remove and return the smallest element of the list.
     * First find the smallest, then delete it, then return it.
     * @return The (now removed) smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    public int removeSmallest() {
    	DLNode smallest = findSmallest();
    	smallest.spliceOut();
    	return smallest.datum();
    }

    /**
     * Return the value of the smallest element of the list.
     * @return The node containing the smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    private DLNode findSmallest() {
	   DLNode place = head;
       DLNode smallNode = place;
       while (place != null) {
        if (place.datum() < smallNode.datum()) {
            smallNode = place;
        }
        place = place.next();
       }
       return smallNode; 
    }

    /**
     * Print the elements of this list to System.out.
     */
    public void printList() {
	System.out.print("[ ");
	DLNode place = head;
	while (place != null) {
	    System.out.print(place.datum()+" ");
	    place = place.next();
	}
	System.out.println("]");
    }
    
    /**
     * Print the elements of this list in reverse order.
     */
    public void printListReverse() {
	DLNode place = head;
	if (place != null) {
	    while (place.next() != null) {
		place = place.next();
	    }
	}
	System.out.print ("reverse [ ");
	while (place != null) {
	    System.out.print (place.datum() + " ");
	    place = place.previous();
	}
	System.out.println ("]");
    }
    
    
    public static void main(String[] args) {
	// for testing
	DList x = new DList();
	x.insertAtFront(15);
	x.insertAtFront(12);
	x.insertAtFront(4);
	x.printList();

    // x.insertAfter(4, 1);
    // x.printList();

    // x.deleteAt(1);
    // x.printList();

    // x.deleteFirstOccurrence(13);
    // x.printList();

    // x.deleteAll(4);
    // x.printList();

    // x.insertSorted(13);
    // x.printList();

    // System.out.println ((x.findLast()).datum());
    // System.out.println ((x.findSmallest()).datum());

    // x.printListReverse();
	
    }
}
