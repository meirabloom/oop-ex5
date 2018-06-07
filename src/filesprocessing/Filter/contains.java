package filesprocessing.Filter;

import java.io.File;
/**
 * This class represents a contains Filter, that is a filter that determines if or if not the file name
 * contains the given text
 */

public class contains extends TextFilter {

    //Constructor/

    /**
     * A contains Filter constructor.
     * @param value - the text we want to compare the file to
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public contains(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){ //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (hadNot){
            return !file.getName().contains(value);
        }
        return file.getName().contains(value);
    }
}
