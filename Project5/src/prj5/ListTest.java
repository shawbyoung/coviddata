package prj5;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Tests the List class
 * 
 * @author Shaw Young
 * @version 2021.11.20
 */
public class ListTest extends student.TestCase {
    private List l1;
    private List l2;
    private Tuple t2;
    private Tuple t3;
    private Tuple t4;
    private Tuple t5;
    private Tuple t6;
    private Tuple t7;
    private Tuple t8;
    private Tuple t9;

    /**
     *
     * Sets up the testing
     */
    public void setUp() {
        l1 = new List("DC");
        l2 = new List("DC");

        t2 = new Tuple("a", 10, 0.3);
        t3 = new Tuple("b", 10, 0.2);
        t4 = new Tuple("c", 10, 0.1);

        t5 = new Tuple("a", 10, 0.3);
        t6 = new Tuple("b", 10, 0.2);
        t7 = new Tuple("c", 10, 0.1);

        t8 = new Tuple("c", 10, 0.1);
        t9 = new Tuple("c", 10, 0.1);

    }


    /**
     *
     * Tests the add method
     */
    public void testAdd() {
        assertEquals(0, l1.getSize());

        Tuple t1 = new Tuple("black", 10, 0.1);

        assertEquals(0.1, t1.getCFR(), 0.0001);
        assertEquals(10, t1.getCases());
        assertEquals("black", t1.getRace());

        l1.addTuple(t1);
        assertEquals(1, l1.getSize());
        assertEquals("DC", l1.getState());
        assertTrue(t1.equals(l1.getHead()));
    }


    /**
     *
     * Tests the equals method
     */
    public void testEquals() {
        assertTrue(l1.equals(l2));
        assertTrue(l1.equals(l1));
        assertFalse(l1.equals(null));
        assertFalse(l1.equals("meow"));

        l2.addTuple(t2);
        l2.addTuple(t3);
        l2.addTuple(t4);

        l1.addTuple(t2);
        l1.addTuple(t3);

        assertFalse(l1.equals(l2));

        l1.addTuple(t4);
        
        assertTrue(l1.equals(l2));
        l2.setState("meow");
        assertFalse(l1.equals(l2));
        
        List l3 = new List("DC");
        l3.addTuple(t2);
        l3.addTuple(t3);
        l3.addTuple(t3);
        assertFalse(l1.equals(l3));

    }


    /**
     *
     * Tests the cfr sort method
     */
    public void testSort() {
        l2.addTuple(t8);
        l2.addTuple(t4);
        l2.addTuple(t3);
        l2.addTuple(t2);

        l1.addTuple(t9);
        l1.addTuple(t7);
        l1.addTuple(t6);
        l1.addTuple(t5);

        l2.selectionSortCFR();

        assertTrue(l1.equals(l2));

    }


    /**
     *
     * Tests the toString method
     */
    public void testToString() {
        l2.addTuple(t4);
        l2.addTuple(t3);
        l2.addTuple(t2);
        assertEquals("a: 10 cases, 30% CFR\r\n" + "b: 10 cases, 20% CFR\r\n"
            + "c: 10 cases, 10% CFR", l2.toString());
    }


    /**
     *
     * Tests the alphabetical sort method
     */
    public void testSortA() {

        l2.addTuple(t4);
        l2.addTuple(t3);
        l2.addTuple(t2);

        l1.addTuple(t5);
        l1.addTuple(t6);
        l1.addTuple(t7);

        l1.selectionSortAlphabet();

        assertTrue(l1.equals(l2));

    }
    
    /**
    *
    * Tests the Iterator
    */
    
    public void testListIterator() { 
        l1.addTuple(t2);
        l1.addTuple(t3);
        l1.addTuple(t4);
        Iterator<Tuple> iter = l1.iterator();
        assertTrue(iter.hasNext());
        assertTrue(iter.next().equals(t4));
        assertTrue(iter.hasNext());
        assertTrue(iter.next().equals(t3));
        assertTrue(iter.hasNext());
        assertTrue(iter.next().equals(t2));
        assertFalse(iter.hasNext());
        
        NoSuchElementException e = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException exception) { 
            e = exception;
        }
        
        assertNotNull(e);
        
    }
}
