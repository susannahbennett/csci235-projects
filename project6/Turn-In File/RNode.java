/**
 * RNode.java
 *
 * Node for a recursive linked list.
 *
 * Note that in the recursive version, most of the work for the list methods
 * is done here.
 *
 * @author TVD/CGG/HK, and Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 6
 * 11.26.19
 */

public class RNode {
    /**
     * The payload for this RNode.  This should be treated as immutable.
     */
    private final int datum;
    /**
     * The INode following this one.
     */
    private RNode next;

    /**
     * Constructor.
     * @param datum The payload for this INode.
     * @param next  The node that follows this one.
     */
    public RNode(int datum, RNode next) {
        this.datum = datum;
        this.next = next;
    }

    /**
     * Accessor method.
     */
    public int datum() { return datum; }
    

     /**
     * Accessor method.
     */
    public RNode next() { return next; }
    

    /**
     * print this node and its successors
     */
    public void print() {
    System.out.print(datum+" ");
    if (next != null) {
        next.print();
    }
    }

    public int length() {
    if (next == null) {
        return 1;
    }
    return 1 + next.length();
    }

    /**                                                                                                                             
     * Insert a new item at the right place in an (assumed sorted) list.                                                            
     * @param item The item to insert in the right place.                                                                           
     */
    public RNode insertSorted(int item) {
    if (item < datum()){
        return new RNode (item, this);
    } else if (next == null){
        next = new RNode (item, null);
        return this;
    } else {
        next = next.insertSorted(item);
        return this;
    }
    }
    /**                                                                     
     * Adds a new RNode into the list at the specified position and with the datum of the item
     * @param item The value to insert.                                                                                             
     * @param position The index after which the item will be inserted. 
     * PRECONDITION: position is within the list                                                                                    
     */
    public RNode insertAfter(int item, int position){
        if (position == 0){
            next = new RNode (item, next);
	    return this;
        } else {
            next = next.insertAfter(item, position-1);
	    return this;
        }
    }

    /**                                                                                                                              
     * Delete the first occurrence of item in this list, if any.                                                                    
     * @param item The item to delete                                                                                               
     * @return the next place it should move to
     */
    public RNode deleteFirstOccurrence(int item) {
    if (this.datum == item) {
        return next;
    } else if (next == null) {
        return this;
    } else {
        next = next.deleteFirstOccurrence(item);
        return this;
    }
    }
    
    /**
     * For determining the datum at the specified position in the list
     * @param position The position of the datum being looked for
     * @return recursive, calls the method again but with a lowered position
     */
    public int elementAt(int position) {
        if (position == 0) return datum;
        else return next.elementAt(position - 1);
    }
    /**
     * Adding an RNode with a datum of item to the back of the list
     * @param item The datum to be contained in the new RNode at the end
     * @return this The calling object, or list
     */
    public RNode insertAtBack (int item) {
        if (next == null) {
            next = new RNode (item, null);
            return this;
        } else {
            next = next.insertAtBack(item);
            return this;
        }
    }
    
    /**
     * Check if the item exists in the list
     * @param item The item to check for
     * @return true/false The boolean of whether it is in the list or not
     */
    public boolean contains (int item){
        if (next == null){
            return false;
        } else if (datum == item){
            return true;
        } else {
            return next.contains(item);
        }
    }

    /**
     * Delete the item at a specified position.
     * @param position The position in the list.
     * @return next The RNode after the position, so the RNode at position can be deleted/skipped
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public RNode deleteAt(int position) {
        if (position == 0){
            return next;
        } else {
            next = next.deleteAt(position-1);
            return this;
        }
    }
    
    /**                                                                                                                                           
     * Delete all occurrences of item in this list, if any.
     * @param item The item in the list.
     * @return this or the holder of next
     */
    public RNode deleteAll(int item) {
	if (item == this.datum) {
	   RNode holder = next;
	   if (next!=null){
	       next = next.deleteAll(item);
	   }
	   return holder;
	} else if (next == null){
	    return this;
	} else {
	    next = next.deleteAll(item);
	    return this;
	}
    }
    
    /**
     * Finds the smallest value in the list
     * @return smallest The int value of smallest
     */
    public int findSmallest () {
     	if (next == null) {
	       return datum;
	    } else {
	       int smallest = next.findSmallest();
	       if (datum >= smallest) {
		      return smallest;
	       } else {
		      return datum;
	       }
	    }
    }
}
