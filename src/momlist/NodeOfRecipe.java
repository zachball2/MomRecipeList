package momlist;

import javax.swing.JOptionPane;

/**
 *
 * @author Zachcollins
 */
public class NodeOfRecipe {

    private Node h;     // a node in the linked list

    public NodeOfRecipe() {
        h = new Node();
    }

    public void insert(Recipes r) {
        Node n = new Node();    // Create a new node
        n.l = r.deepCopy(); // put the info into the new node
        if (h.next == null || h.next == h) {
            n.next = h;
        } else {
            n.next = h.next;    // Point to head node's link
        }

        h.next = n;         // insert the node

    }

    public Recipes search(String targetKey) {
        Node p = h.next;    // point to the first listing
        // search until found or the end of the list
        while (p != h && !(p.l.compareTo(targetKey) == 0)) {
            p = p.next;
        }                   // return the appropriate value
        if (p != h) {
            return p.l.deepCopy();
        } else {
            return null;
        }
    }

    public boolean delete(String targetKey) {
        Node q = h;         // Set the trailing pointer
        Node p = h.next;    // Set the traversal pointer to the first node
        // Search until end of list or found
        while (p != h && !(p.l.compareTo(targetKey) == 0)) {
            q = p;          // Set trailer to current
            p = p.next;     // Move along
        }
        if (p != h) {
            q.next = p.next;// If found, branch around the node
            return true;
        } else {
            return false;
        }
    }

    public boolean update(String targetKey, Recipes newListing) {
        if (!delete(targetKey)) {    // Return false if the record isn't deleted
            return false;
        }
        insert(newListing);  // Return false if it can't be inserted

        return true;
    }

    public void showAll(String t) {//String t
        Node p = h.next;    // Set up the traversal pointer
        while (p != h) {  // Continue to end of list
            // Display a listing
            if (t == p.l.getRecipeType()) {
                JOptionPane.showMessageDialog(null, p.l.toString(), "Listing", JOptionPane.PLAIN_MESSAGE);
            }
            p = p.next;     // Move the traversal pointer
        }
    }

    /*
    ***Wasnt working
    public void showAll(String t) {
        Node p = h.next;    // Set up the traversal pointer
        while (p != null) {  // Continue to end of list
            // Display a listing
            //if(t==p.l.getRecipeType())
            JOptionPane.showMessageDialog(null, p.l.toString(), "Listing", JOptionPane.PLAIN_MESSAGE);
            p = p.next;     // Move the traversal pointer
        }
    }
     */
    public void showOne(String t) {
        Node p = h.next;    // Set up the traversal pointer
        while (p != null) {  // Continue to end of list
            // Display a listing
            if (t == p.l.getRecipeType()) {
                JOptionPane.showMessageDialog(null, p.l.toString());
            }
            p = p.next;     // Move the traversal pointer

        }
    }

    public class Node {

        private Recipes l;  // a listing
        private Node next;  // pointer to the next listing

        /*
         * Constructor - creates a new header node
         * IN - none
         * OUT - none
         */
        public Node() {
        }
    }
}

/*class Link {

        public int iData;
        public Link next;

        public Link(int id) { // constructor
            iData = id;
        }

        public void displayLink() {
            System.out.print(iData + " ");
        }
    }

    public class CircularLinkedList {

        private Link first;
        private Link current;

        public Link getCurrent() {
            return current;
        }

        public void setCurrent(int data) {

        }

        public void advance() {
            current = current.next;
        }

        public void addRecipe(int data) {
            Link newLink = new Link(data);
            if (first == null) {
                first = current = newLink;
            } else {
                current.next = newLink;
            }
            current = newLink;
            newLink.next = first;
        }
        public void deletion(int data){
            Link newLink = new Link(data);
            
        }

    }*/
