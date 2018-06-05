package fileprocessing.Filter;

import java.io.File;

/**
 * This class represents a suffix Filter, that is a filter that determines if or if not the file name end
 * with the given text
 */

public class suffix extends TextFilter {

    //Constructor/

    /**
     * A suffix Filter constructor.
     * @param value - the text we want to compare the file to
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public suffix(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){ //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (hadNot){
            return !file.getName().endsWith(value);
        }
        return file.getName().endsWith(value);
    }
}
