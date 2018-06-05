package fileprocessing.Filter;
import java.io.File;

/**
 * This class represents a between Filter, that is a filter that determines if the file size's is or isn't
 * between 2 given size.
 */

public class between extends SizeFilter {

    private double fileSize;

    //Constructors/

    /**
     * A constructor for a between Filter.
     * @param value - the lower size bound
     * @param antherValue - the higher size bound
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public between(double value,double antherValue, int filterLine, boolean hasNot) {
        super(value,antherValue, filterLine,hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        fileSize = file.length()/oneKbTobytes;
        if (this.hasWarning()){ //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (hadNot){
            return fileSize > value || fileSize < antherValue;
        }
        return fileSize >= value && fileSize <= antherValue;
    }
}
