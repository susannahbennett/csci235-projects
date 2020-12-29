/**
 * DLNode.java
 *
 * Nodes for doubly-linked lists.
 *
 * @author TVD/CGG and Susannah Bennett
 * Wheaton College, CSCI 235, Fall 2019
 * Project 6
 * 11.26.19
 */

public class DLNode {

    /**
     * The payload for this node.  (Note that it is immutable.)
     */
    private final int datum;

    /**
     * The node before this one.
     */
    private DLNode previous;

    /**
     * The node following this one.
     */
    private DLNode next;
    
    /**
     * Constructor for dummy node (circular list).
     */
    public DLNode() {
	datum = Integer.MIN_VALUE;
	previous = this;
	next = this;
    }

    /**
     * Constructor.
     * @param datum The payload for this INode.
     */
    public DLNode(int item) {
	datum = item;
	next = null;
	previous = null;
    }

    // accessor methods

    public int datum() { return datum; }

    public DLNode next() { return next; }

    public DLNode previous() { return previous; }

    // splicing

    /**
     * Splice this at the head of a list (non-circular).
     * @param oldHead The old head node.
     */
    public void spliceAsHead(DLNode oldHead) {
        next = oldHead;
        previous = null;
	if (oldHead != null) {
	    oldHead.previous = this;
	}
    }
    
    /**
     * Splice this into a list, following node before.
     * @param before  The node that this one should follow.
     * PRECONDITION: before is already in a list
     * POSTCONDITION: this is between before and (old) before.next()
     */
    public void spliceAfter(DLNode before) {
		if (before.next == null) {
			before.next = this;
			this.previous = before;
		} else {
			this.next = before.next;
			next.previous = this;
			before.next = this;
			this.previous = before;
		}
    }

    /**
     * Splice this node out of the list it is in; return its next node.
     * @return The node (or null) following this.
     */
    public DLNode spliceOut() {
	DLNode p = previous;
	DLNode n = next;
	if (p != null) {
	    p.next = n;
	}
	if (n != null) {
	    n.previous = p;
	}
	// The next two lines are not strictly necessary, but
	// they make it less likely that errors go undetected.
	next = null;
	previous = null;
	return n;
    }

}
