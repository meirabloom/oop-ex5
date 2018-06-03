package fileprocessing.Filter;

import java.io.File;

public class contains extends TextFilter {

    public contains(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.getName().contains(value);
        }
        return file.getName().contains(value);
    }
}
