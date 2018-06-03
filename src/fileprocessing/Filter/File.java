package fileprocessing.Filter;

public class File extends TextFilter {

    public File(String value, int filterLine, boolean hasNot) {
        super(value, filterLine, hasNot);
    }

    @Override
    public boolean doFilter(java.io.File file) {
        if (this.hasWarning()){
            return true;
        }
        if (hadNot){
            return !file.getName().equals(value);
        }
        return file.getName().equals(value);
    }
}
