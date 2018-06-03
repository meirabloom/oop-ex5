package fileprocessing.Filter;

import java.io.File;

public class writable extends BooleanFilter {

    public writable(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.canWrite();
        }
        return file.canWrite();
    }
}
