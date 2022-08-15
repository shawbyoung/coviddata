package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List class.
 * 
 * @author Shaw Young
 * @version 2021.11.20
 */

public class List {

    private Tuple head;
    private int size;
    private String state;

    /**
     *
     * @param s
     *            state name
     */
    public List(String s) {
        head = null;
        size = 0;
        state = s;
    }


    /**
     * Returns the first Tuple in the list
     * 
     * @return the head
     */

    public Tuple getHead() {
        return head;
    }


    /**
     * Returns the state name
     * 
     * @return the state name
     */

    public String getState() {
        return state;
    }


    /**
     * Returns the size
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }


    /**
     * Adds a tuple to the list
     * 
     * @param t
     *            tuple to be added
     */

    public void addTuple(Tuple t) {
        t.setNext(head);
        head = t;
        size++;
    }


    /**
     * Changes state name
     * 
     * @param s
     *            new State name
     */

    public void setState(String s) {
        state = s;
    }


    /**
     * Returns the list as a String
     * 
     * @return the list as a String
     * 
     */

    public String toString() {
        String str = "";

        Tuple current = head;
        while (current != null) {

            str += current.toString();
            if (current.getNext() != null) {
                str += "\n";
            }
            current = current.getNext();
        }
        return str;
    }


    /**
     * Sorts the list by covid fatality rate
     * 
     * 
     */

    public void selectionSortCFR() {

        Tuple temp = head;

        while (temp != null) {

            Tuple min = temp;

            Tuple r = temp.getNext();

            if (r != null) {
                while (r != null) {

                    if (min.getCFR() <= r.getCFR()) {
                        min = r;
                    }
                    r = r.getNext();

                }
            }

            double tcfr = temp.getCFR();
            int tcases = temp.getCases();
            String trace = temp.getRace();

            temp.setCFR(min.getCFR());
            temp.setRace(min.getRace());
            temp.setCases(min.getCases());
            min.setCFR(tcfr);
            min.setRace(trace);
            min.setCases(tcases);
            temp = temp.getNext();

        }
    }


    /**
     * Sorts the list by alphabetically
     * 
     * 
     */
    public void selectionSortAlphabet() {

        Tuple temp = head;

        while (temp != null) {

            Tuple min = temp;

            Tuple r = temp.getNext();

            if (r != null) {
                while (r != null) {

                    if (r.getRace().compareTo(min.getRace()) < 0) {
                        min = r;
                    }
                    r = r.getNext();

                }
            }

            double tcfr = temp.getCFR();
            int tcases = temp.getCases();
            String trace = temp.getRace();

            temp.setCFR(min.getCFR());
            temp.setRace(min.getRace());
            temp.setCases(min.getCases());
            min.setCFR(tcfr);
            min.setRace(trace);
            min.setCases(tcases);
            temp = temp.getNext();

        }
    }


    /**
     * Sees if the current list and the compared to object are equal
     * 
     * @param obj
     *            compared to object
     * @return if the current list and the compared to object are equal
     * 
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        List comp = (List)obj;

        if (!comp.getState().equals(this.getState())) {
            return false;
        }

        if (comp.getSize() != this.getSize()) {
            return false;
        }

        Tuple temp = comp.getHead();
        Tuple temp2 = this.getHead();

        while (temp != null) {
            if (!temp.equals(temp2)) {
                return false;
            }
            temp = temp.getNext();
            temp2 = temp2.getNext();
        }
        return true;

    }
    
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public ListIterator iterator() {
        return new ListIterator();
    }


    /**
     * List Iterator class
     * @author Shaw Young
     * @version 12.3.21
     * @param <Tuple>
     *            the components of the list
     * 
     */
    
    @SuppressWarnings("unused")
    private class ListIterator implements Iterator<Tuple> {
        private Tuple curr;
        
        /**
         * Creates a new ListIterator
         */
        
        public ListIterator() {
            curr = head;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return curr != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */

        @Override
        public Tuple next() {
            if (curr == null) {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            
            Tuple temp = curr;

            curr = curr.getNext();

            return temp;
        }

    }

}
