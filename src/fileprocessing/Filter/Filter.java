package fileprocessing.Filter;

import java.io.File;
import java.util.List;

public abstract class Filter {

    int filterLineNumber;
    boolean hadNot;

    public abstract boolean doFilter(File file);

    public abstract boolean hasWarning();

    public void printWarning(){
        if (hasWarning()){
            System.err.println("Warning in line "+filterLineNumber);
        }
    }

}
