package fileprocessing.Filter;

import java.io.File;
import java.util.List;

public abstract class Filter {

    int filterLineNumber;
    boolean hadNot;

    public abstract List<File> doFilter();

    public abstract boolean hasWarning();

    public abstract void printWarning();

}
