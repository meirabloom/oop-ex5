package fileprocessing.Filter;

import java.io.File;
import java.util.List;

public class BooleanFilter extends Filter {
    @Override
    public boolean doFilter(File file) {
        return true;
    }

    @Override
    public boolean hasWarning() {
        return false;
    }

    @Override
    public void printWarning() {

    }
}
