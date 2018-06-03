package fileprocessing.Filter;

import java.io.File;

public class hidden extends BooleanFilter {


    public hidden(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.isHidden();
        }
        return file.isHidden();
    }
}
