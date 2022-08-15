package prj5;

/**
 * Tuple test class.
 *
 * @author Shaw Young
 * @version 2021.09.07
 */

public class TupleTest extends student.TestCase {
    private Tuple t1;

    /**
     * Sets up the testing.
     *
     */
    public void setUp() {
        t1 = new Tuple("Black", 10, 0.1);
    }


    /**
     * Tests the getters and setters.
     *
     */
    public void testGettersSetters() {
        assertEquals(10, t1.getCases());
        assertEquals(0.1, t1.getCFR(), 0.0001);
        assertEquals("Black", t1.getRace());
        t1.setRace("White");
        t1.setCases(5);
        t1.setCFR(.02);
        assertEquals(5, t1.getCases());
        assertEquals(0.02, t1.getCFR(), 0.0001);
        assertEquals("White", t1.getRace());

    }


    /**
     * Tests the getters and setters.
     *
     */
    public void testNext() {
        assertNull(t1.getNext());
        Tuple t6 = new Tuple("White", 10, 0.3);
        t1.setNext(t6);
        assertTrue(t6.equals(t1.getNext()));
    }


    /**
     * Tests the toString method.
     *
     */

    public void testToString() {
        assertEquals("Black: 10 cases, 10% CFR", t1.toString());
    }


    /**
     * Tests the equals.
     *
     */
    public void testEquals() {
        assertTrue(t1.equals(t1));
        assertFalse(t1.equals(null));
        assertFalse(t1.equals("meow"));

        Tuple t2 = new Tuple("White", 10, 0.1);
        Tuple t3 = new Tuple("Black", 20, 0.1);
        Tuple t4 = new Tuple("Black", 10, 0.3);
        Tuple t5 = new Tuple("Black", 10, 0.1);

        assertFalse(t1.equals(t2));
        assertFalse(t1.equals(t3));
        assertFalse(t1.equals(t4));
        assertTrue(t1.equals(t5));
    }
}
