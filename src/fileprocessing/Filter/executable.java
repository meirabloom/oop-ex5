package fileprocessing.Filter;

import java.io.File;

/**
 * This class represents a executable Filter, that is a filter that determines by if or if not the file is
 * executable
 */

public class executable extends BooleanFilter {

    //Constructor/

    /**
     * A executable Filter constructor.
     *
     * @param value      - value are YES or NO
     * @param filterLine - the filter line number
     * @param hasNot     - if the filter has a "NOT"
     */
    public executable(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()) { //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (valueIsYes()) {
            if (hadNot) {
                return !file.canExecute();
            }
            return file.canExecute();
        } else {
            if (hadNot) {
                return file.canExecute();
            }
            return !file.canExecute();
        }

    }
}