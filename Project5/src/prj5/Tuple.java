package prj5;

import java.text.DecimalFormat;

/**
 * Tuple class that contains case, race, and CFR data.
 *
 * @author Shaw Young
 * @version 2021.09.07
 */

public class Tuple {

    private Tuple next;
    private String race;
    private int cases;
    private double cfr;

    /**
     * New Tuple object.
     *
     * @param race
     *            racial background
     * @param cases
     *            number of cases
     * @param cfr
     *            covid fatality rate
     */
    public Tuple(String race, int cases, double cfr) {
        this.race = race;
        this.cfr = cfr;
        this.cases = cases;
        next = null;
    }


    /**
     * Sets race
     *
     * @param s
     *            race to be set
     */

    public void setRace(String s) {
        race = s;
    }


    /**
     * Sets cases
     *
     * @param i
     *            cases to be set
     */

    public void setCases(int i) {
        cases = i;
    }


    /**
     * Sets CFR
     *
     * @param s
     *            sets the CFR
     */

    public void setCFR(double s) {
        cfr = s;
    }


    /**
     * Gets race
     *
     * @return racial background
     * 
     */

    public String getRace() {
        return race;
    }


    /**
     * Returns number of cases
     *
     * @return number of cases
     */

    public int getCases() {
        return cases;
    }


    /**
     * Returns the covid fatality rate
     *
     * @return the covid fatality rate
     */

    public double getCFR() {
        return cfr;
    }


    /**
     * Sets the next tuple
     * 
     * @param t
     *            the next tuple
     *
     */

    public void setNext(Tuple t) {
        next = t;
    }


    /**
     * Returns the next Tuple
     *
     * @return the next Tuple
     */

    public Tuple getNext() {
        return next;
    }


    /**
     * Returns the Tuple as a String
     *
     * @return the Tuple as a String
     */

    public String toString() {
        DecimalFormat percent = new DecimalFormat("##.#%");
        return race + ": " + Integer.toString(cases) + " cases, " + percent
            .format(cfr) + " CFR";
    }


    /**
     * Returns whether or not the object is equal to the current object
     * 
     * @param obj
     *            object being compared
     * @return whether or not the object is equal to the current object
     */

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass() == this.getClass()) {

            Tuple comp = (Tuple)obj;
            if (comp.getCases() != this.getCases()) {
                return false;
            }
            if (comp.getCFR() != this.getCFR()) {
                return false;
            }
            return comp.getRace().equals(this.getRace());
        }
        return false;
    }
}
