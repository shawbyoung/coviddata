package prj5;

/**
 * List class.
 * 
 * @author Shaw Young
 * @version 2021.09.07
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private ArrayList<List> list;
    /**
     * An array of races
     */
    public static final String[] RACES = { "white", "black", "latinx", "asian",
        "other" };

    /**
     * Instantiates a reader
     * 
     * @param filename
     *            name of file
     */
    public Reader(String filename)
        throws FileNotFoundException,
        ParseException {
        list = readFile(filename);
        CovidWindow cw = new CovidWindow(list);
    }


    /**
     * Reads file, returns an ArrayList of lists
     * 
     * @param s
     *            name of file
     */
    public ArrayList<List> readFile(String s)
        throws ParseException,
        FileNotFoundException {

        ArrayList<List> ret = new ArrayList<List>();

        File caseFile = new File(s);
        Scanner scanner = new Scanner(caseFile);

        String line = scanner.nextLine();

        String clone = "";
        String temp = "";
        int count = 0;
        int i = 0;
        double cfr = 0;

        Integer[] data = new Integer[10];

        while (scanner.hasNextLine()) {

            List n;
            switch (i) {
                case 0:
                    n = new List("DC");
                    break;
                case 1:
                    n = new List("GA");
                    break;
                case 2:
                    n = new List("MD");
                    break;
                case 3:
                    n = new List("NC");
                    break;
                case 4:
                    n = new List("TN");
                    break;
                case 5:
                    n = new List("VA");
                    break;
                default:
                    n = new List("X");
                    break;
            }
            System.out.println(n.getState());

            line = scanner.nextLine(); // gets the line

            clone = line;
            count = clone.length() - clone.replace(",", "").length();

            if (count != 10) {
                throw new java.text.ParseException(
                    "Not 10 comma separated values on this line", i);
                // check to see the data formatting
            }

            line = line.substring(line.indexOf(",") + 1);

            for (int j = 0; j < 10; j++) {

                if (j < 9) {
                    temp = line.substring(0, line.indexOf(","));
                }
                else {
                    temp = line;
                }

                if (temp.equals("NA")) {
                    data[j] = -1;
                }
                else {

                    data[j] = Integer.parseInt(temp);
                }

                if (j < 9) {
                    line = line.substring(line.indexOf(",") + 1);
                }
            }

            for (int k = 0; k < 5; k++) {
                if (data[k] == -1 || data[k + 5] == -1) {
                    cfr = -0.01;
                }
                else {
                    cfr = ((double)data[k + 5]) / ((double)data[k]);
                }
                Tuple t = new Tuple(Reader.RACES[k], data[k], cfr);
                n.addTuple(t);

            }

            n.selectionSortAlphabet();
            System.out.print(n.toString());
            System.out.println("\n=====");

            n.selectionSortCFR();
            System.out.println(n.toString());
            System.out.println("=====");

            ret.add(n);

            i++;

        }
        scanner.close();
        return ret;
    }
}
