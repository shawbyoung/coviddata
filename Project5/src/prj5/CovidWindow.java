package prj5;

import cs2.Window;
import cs2.WindowSide;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;

/**
 * 
 * CovidWindow creates and updates the front-end of this data visualization.
 * This class is used within the Reader class.
 *
 * @author Shaw Young
 * @version 12.3.21
 * 
 */

public class CovidWindow {
    private ArrayList<List> list;
    private List curr;

    private Window window;
    private final int barWidth = 25;
    private final int cfrFactor = 750;
    private Button sortByAlpha;
    private Button quit;
    private Button sortByCFR;
    private int index;

    private Button dc;
    private Button ga;
    private Button md;
    private Button nc;
    private Button tn;
    private Button va;

    private TextShape text;
    
    /**
     * Constructor
     * 
     * @param list
     *            ArrayList of state lists
     */
    public CovidWindow(ArrayList<List> list) {
        index = -1;
        this.list = list;
        window = new Window("CFR Visualization");

        sortByAlpha = new Button("Sort By Alpha");
        sortByAlpha.onClick(this, "sortA");
        quit = new Button("Quit");
        quit.onClick(this, "quit");
        sortByCFR = new Button("Sort By CFR");
        sortByCFR.onClick(this, "sortCFR");

        dc = new Button("Represent DC");
        dc.onClick(this, "dc");

        ga = new Button("Represent GA");
        ga.onClick(this, "ga");

        md = new Button("Represent MD");
        md.onClick(this, "md");

        nc = new Button("Represent NC");
        nc.onClick(this, "nc");

        tn = new Button("Represent TN");
        tn.onClick(this, "tn");

        va = new Button("Represent VA");
        va.onClick(this, "va");

        window.addButton(sortByAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortByCFR, WindowSide.NORTH);

        window.addButton(dc, WindowSide.SOUTH);
        window.addButton(ga, WindowSide.SOUTH);
        window.addButton(md, WindowSide.SOUTH);
        window.addButton(nc, WindowSide.SOUTH);
        window.addButton(tn, WindowSide.SOUTH);
        window.addButton(va, WindowSide.SOUTH);

        dc.enable();
        ga.enable();
        md.enable();
        nc.enable();
        tn.enable();
        va.enable();
    }

    /**
     * Sorts alphabetically.
     * 
     * @param button
     *            button associated with the method
     */
    public void sortA(Button button) {
        curr.selectionSortAlphabet();
        displayBars();
    }
    /**
     * Sorts according to Covid Fatality Ratio.
     * 
     * @param button
     *            button associated with the method
     */

    public void sortCFR(Button button) {
        curr.selectionSortCFR();
        displayBars();
    }

    /**
     * Quits.
     * 
     * @param button
     *            button associated with the method
     */
    public void quit(Button button) {
        System.exit(0);
    }

    /**
     * Sets the current list to DC, changes index accordingly.
     * 
     * @param button
     *            button associated with the method
     */
    public void dc(Button button) {
        curr = list.get(0);
        index = 0;
        displayBars();
    }

    /**
     * Sets the current list to GA, changes index accordingly.
     * 
     * @param button
     *            button associated with the method
     */
    public void ga(Button button) {
        curr = list.get(1);
        index = 1;
        displayBars();
    }

    /**
     * Sets the current list to MD, changes index accordingly.
     * 
     * @param button
     *            button associated with the method
     */
    public void md(Button button) {
        curr = list.get(2);
        index = 2;
        displayBars();
    }

    /**
     * Sets the current list to NC, changes index accordingly.
     * 
     * @param button
     *            button associated with the method
     */
    public void nc(Button button) {
        curr = list.get(3);
        index = 3;
        displayBars();
    }

    /**
     * Sets the current list to TN, changes index accordingly.
     * 
     * @param button
     *            button associated with the method
     */
    public void tn(Button button) {
        curr = list.get(4);
        index = 4;
        displayBars();
    }

    /**
     * Sets the current list to VA, changes index accordingly.
     * 
     * @param button
     *            button associated with the method
     */
    public void va(Button button) {
        curr = list.get(5);
        index = 5;
        displayBars();
    }

    /**
     * Displays all the graph bars and texts on the windows.
     * 
     */
    public void displayBars() {
        window.removeAllShapes();
        String meow;
        switch (index) {
            case 0:
                meow = "DC";
                break;
            case 1:
                meow = "GA";
                break;
            case 2:
                meow = "MD";
                break;
            case 3:
                meow = "NC";
                break;
            case 4:
                meow = "TN";
                break;
            case 5:
                meow = "VA";
                break;
            default:
                meow = "";
                break;

        }
        text = new TextShape((window.getGraphPanelWidth() / 2) - 125, 30, meow
            + " Case Fatality Ratios by Race");
        window.addShape(text);
        DecimalFormat percent = new DecimalFormat("##.#%");
        Iterator<Tuple> iter = curr.iterator();
        int placement = 1;

        while (iter.hasNext()) {
            Tuple a = iter.next();
            if (a.getCFR() < 0) {
                window.addShape(new TextShape((window.getGraphPanelWidth() / 6)
                    * placement, (window.getGraphPanelHeight() / 2) - 20,
                    "NA"));
            }
            else {
                window.addShape(new Shape((window.getGraphPanelWidth() / 6)
                    * placement, (window.getGraphPanelHeight() / 2)
                        - (int)(cfrFactor * a.getCFR()), barWidth,
                    (int)(cfrFactor * a.getCFR())));
                window.addShape(new TextShape((window.getGraphPanelWidth() / 6)
                    * placement, (window.getGraphPanelHeight() / 2) + 60,
                    percent.format(a.getCFR())));
            }

            window.addShape(new TextShape((window.getGraphPanelWidth() / 6)
                * placement, (window.getGraphPanelHeight() / 2) + 30, a
                    .getRace()));

            placement++;
        }

    }
}
