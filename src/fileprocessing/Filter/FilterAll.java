package fileprocessing.Filter;

import java.io.File;

/**
 * This class represents a all Filter, that is a filter that accept all or none of the files. can be use
 * for filter with warnings.
 */


public class FilterAll extends Filter{
    private boolean hasWarning ;

    //Constructor/
    /**
     *  A all Filter constructor.
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     * @param hasWarning - if the filter has a warnings
     */
    public FilterAll ( int filterLine, boolean hasNot,boolean hasWarning){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.hasWarning = hasWarning;
    }

    @Override
    public boolean doFilter(File file) {
        return hasWarning() || !hadNot;
    }

    /**
     * checks if there is a problem with the filter line, if has the info is sent from the FilterFactory
     * @return true if there is a problem with the filter line, false otherwise
     */
    public boolean hasWarning() {return this.hasWarning;}
}
