package filesprocessing.Filter;

import java.io.File;

/**
 * This class represents a between Filter, that is a filter that determines if the file size's is or isn't
 * smaller than given size.
 */

public class smaller extends SizeFilter {

//Constructors/

    /**
     * A constructor for a smaller Filter.
     * @param value - the given size
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public smaller (double value, int filterLine, boolean hasNot) {
        super(value,filterLine,hasNot);
    }


    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){ //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (hadNot){
            return (file.length()/oneKbTobytes) >= value;
        }
        return (file.length()/oneKbTobytes) < value;
    }
}
