package fileprocessing.Filter;

import java.io.File;

public class TextFilter extends Filter {


    @Override
    public boolean doFilter(File file) {
        return false;
    }

    @Override
    public boolean hasWarning() {
        return false;
    }

    @Override
    public void printWarning() {

    }

}
