package fileprocessing.Filter;

import java.io.File;
import java.util.List;

/**
 * This abstract class represents a SizeFilter, that is a filter that determines by size
 */
public abstract class SizeFilter extends Filter {
    final static int oneKbTobytes = 1024;
    double value;
    double antherValue;
    boolean isBetween = false;

    //Constructors/


    /**
     * A default constructor.
     * @param value - the size we want to compare the file to
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public SizeFilter (double value, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
    }

    /**
     A default constructor.
     * @param value - the size we want to compare the file to
     * @param antherValue - the size we want to compare the file to
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public SizeFilter (double value,double antherValue, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
        this.antherValue = antherValue;
        this.isBetween= true;
    }

    @Override
    public abstract boolean doFilter(File file);

    /**
     * checks if there is a problem with the filter line , value are not negtive numbers, or in the case of
     * Between filter if the lower bond is bigger than the higher bond.
     * @return true if there is a problem with the filter line, false otherwise
     */
    public boolean hasWarning() {
        if (value < 0){
            return true;
        }
        if (isBetween){ //checks if the requirements of the Between filter
            return  ((antherValue < value) || (antherValue < 0));
        }
        return false;
    }
}
