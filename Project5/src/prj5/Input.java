package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * Input class.
 *
 * @author Shaw Young
 * @version 2021.11.20
 * 
 */

public class Input {
    /**
     * reader
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {

        try {
            for (int i = 0; i < args.length; i++) {
                Reader r = new Reader(args[i]);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
