package fileprocessing.Filter;

import java.io.File;

public class executable extends BooleanFilter {


    public executable(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.canExecute();
        }
        return file.canExecute();
    }
}
