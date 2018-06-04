package fileprocessing.Filter;

import java.io.File;

/**
 * This abstract class represents a TextFilter, that is a filter that determines by text
 */

public abstract class TextFilter extends Filter {

    String value;

    //Constructor/

    /**
     * A default constructor.
     * @param value - the text we want to compare the file to
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public TextFilter (String value, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
    }

    @Override
    public abstract boolean doFilter(File file);

    @Override
    public boolean hasWarning() {
        return false;
    }

}
