package fileprocessing.Filter;

import java.io.File;

public class suffix extends TextFilter {

    public suffix(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.getName().endsWith(value);
        }
        return file.getName().endsWith(value);
    }
}
