package fileprocessing.Filter;

import java.io.File;
import java.util.List;

public abstract class BooleanFilter extends Filter {

    final static String yes = "YES";
    final static String no = "NO";
    String value;

    public BooleanFilter (String value, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
    }

    @Override
    public abstract boolean doFilter(File file);

    @Override
    public boolean hasWarning() {
        if (value.equals(yes) || value.equals(no)){
            return true;
        }
        return false;
    }

}
