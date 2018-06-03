package fileprocessing.Filter;

import java.io.File;

public class Greater extends SizeFilter {

    public Greater (double value, int filterLine, boolean hasNot) {
        super(value,filterLine,hasNot);
    }

        @Override
    public boolean doFilter(File file) {
            if (this.hasWarning()){
                return true;
            }
            if (hadNot){
                return (file.length()/oneKbTobytes) <= value;
            }
            return (file.length()/oneKbTobytes) > value;
    }
}
