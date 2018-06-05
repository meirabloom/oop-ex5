package filesprocessing.Filter;

import java.io.File;

/**
 * This class represents a writable Filter, that is a filter that determines by if or if not the file is
 * writable
 */

public class writable extends BooleanFilter {

    //Constructor/

    /**
     * A writable Filter constructor.
     * @param value - value are YES or NO
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public writable(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){ //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (valueIsYes()) {
            if (hadNot) {
                return !file.canWrite();
            }
            return file.canWrite();
        } else {
            if (hadNot) {
                return file.canWrite();
            }
            return !file.canWrite();
        }
    }
}
