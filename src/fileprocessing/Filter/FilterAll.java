package fileprocessing.Filter;

import java.io.File;

public class FilterAll extends Filter{
    boolean hasWarning ;


    public FilterAll ( int filterLine, boolean hasNot,boolean hasWarning){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.hasWarning = hasWarning;
    }
    @Override
    public boolean doFilter(File file) {
        if (hadNot){
            return false;
        }
        return true;
    }

    @Override
    public boolean hasWarning() {
        return hasWarning;
    }
}
