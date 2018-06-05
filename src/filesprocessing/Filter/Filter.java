package filesprocessing.Filter;

import java.io.File;

/**
 * This abstract class represents a Filter,
 */
public abstract class Filter {

    int filterLineNumber;
    boolean hadNot;

    //Public methods/

    /**
     * An abstract function that receives a file and determines whether it meets the filter requirements
     * @param file - the file that needs to be determine
     * @return true if is passed the filters requirements, false otherwise
     */
    public abstract boolean doFilter(File file);

    /**
     * An abstract function that determines if filter has warning.
     * @return true if has, false otherwise
     */
    public abstract boolean hasWarning();

    /**
     * if filter has warning, will print them as required
     */
    public void printWarning(){
        if (hasWarning()){
            System.err.println("Warning in line "+filterLineNumber);
        }
    }

}
