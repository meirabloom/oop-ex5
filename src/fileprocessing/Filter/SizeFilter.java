package fileprocessing.Filter;

import java.io.File;
import java.util.List;

public abstract class SizeFilter extends Filter {
    final static int oneKbTobytes = 1024;
    double value;
    double antherValue;
    boolean isBetween = false;


    public SizeFilter (double value, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
    }

    public SizeFilter (double value,double antherValue, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
        this.antherValue = antherValue;
        this.isBetween= true;
    }

    @Override
    public abstract boolean doFilter(File file);

    @Override
    public boolean hasWarning() {
        if (value < 0){
            return true;
        }
        if (isBetween){
            return  ((antherValue < value) || (antherValue < 0));
        }
        return false;
    }
}