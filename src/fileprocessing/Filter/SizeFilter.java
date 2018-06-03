package fileprocessing.Filter;

import java.io.File;
import java.util.List;

public abstract class SizeFilter extends Filter {

    double value;
    double antherValue;


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
    }

    @Override
    public abstract boolean doFilter(File file);

    @Override
    public boolean hasWarning() {
        if (value > 0){
            return false;
        }
        if (antherValue > value){
            return false;
        }
        return true;
    }


}
