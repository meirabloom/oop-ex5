package fileprocessing.Filter;

import java.io.File;

public class prefix extends TextFilter {

    public prefix(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.getName().startsWith(value);
        }
        return file.getName().startsWith(value);
    }
}
