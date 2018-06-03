package fileprocessing.Filter;

import java.io.File;

public abstract class TextFilter extends Filter {

    String value;

    public TextFilter (String value, int filterLine, boolean hasNot){
        this.filterLineNumber = filterLine;
        this.hadNot = hasNot;
        this.value = value;
    }

    @Override
    public abstract boolean doFilter(File file);

    @Override
    public boolean hasWarning() {
        return false;
    }

}
