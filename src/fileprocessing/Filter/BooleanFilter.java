package fileprocessing.Filter;

import java.io.File;
import java.util.List;

/**
 * This abstract class represents a SizeFilter, that is a filter that determines by size
 */
public abstract class BooleanFilter extends Filter {

    final static String yes = "YES";
    final static String no = "NO";
    String value;

    //Constructor/

    /**
     * A default constructor.
     * @param value -
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public BooleanFilter (String value, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
    }

    @Override
    public abstract boolean doFilter(File file);

    /**
     * checks if there is a problem with the filter line , value are not YES or NO
     * @return true if there is a problem with the filter line, false otherwise
     */
    public boolean hasWarning() {
        if (value.equals(yes) || value.equals(no)){
            return true;
        }
        return false;
    }

}
