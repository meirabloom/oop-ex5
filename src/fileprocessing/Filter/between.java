package fileprocessing.Filter;

import java.io.File;

public class between extends SizeFilter {

    double fileSize;

    public between(double value,double antherValue, int filterLine, boolean hasNot) {
        super(value,antherValue, filterLine,hasNot);
    }

    @Override
    public boolean doFilter(File file) {
        fileSize = file.length()/oneKbTobytes;
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return fileSize > value || fileSize < antherValue;
        }
        return fileSize >= value && fileSize <= antherValue;
    }
}
