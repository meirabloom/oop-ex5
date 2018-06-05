package fileprocessing.Filter;
import java.io.File;


/**
 * This class represents a File Filter, that is a filter that determines if or if not the file name is equals
 * to the given text
 */

public class FileFilter extends TextFilter {

//Constructor/

    /**
     * A File Filter constructor.
     * @param value - the text we want to compare the file to
     * @param filterLine - the filter line number
     * @param hasNot - if the filter has a "NOT"
     */
    public FileFilter(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){ //if has warning than the filer became an all filter - true for all
            return true;
        }
        if (hadNot){
            return !file.getName().equals(value);
        }
        return file.getName().equals(value);
    }
}
